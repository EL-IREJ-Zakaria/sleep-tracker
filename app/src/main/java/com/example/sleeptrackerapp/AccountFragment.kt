package com.example.sleeptrackerapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class AccountFragment : Fragment() {

    // Interface to communicate logout click back to the hosting Activity (MainActivity)
    interface LogoutListener {
        fun onLogoutClicked()
    }

    private var logoutListener: LogoutListener? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    // UI Elements
    private lateinit var tvUserName: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var tvMemberSince: TextView
    private lateinit var tvUserId: TextView
    private lateinit var tvAccountCreated: TextView
    private lateinit var tvLastLogin: TextView
    private lateinit var tvTotalSessions: TextView
    private lateinit var tvAvgSleep: TextView
    private lateinit var tvGoalsAchieved: TextView
    private lateinit var btnLogout: Button

    // Ensure the hosting activity implements the listener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is LogoutListener) {
            logoutListener = context
        } else {
            // Log this error or handle it as necessary
            // throw RuntimeException("$context must implement LogoutListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        // Initialize views
        initializeViews(view)

        // Load user data
        loadUserData()

        // Setup logout button
        btnLogout.setOnClickListener {
            logoutListener?.onLogoutClicked()
        }

        return view
    }

    private fun initializeViews(view: View) {
        tvUserName = view.findViewById(R.id.tv_user_name)
        tvUserEmail = view.findViewById(R.id.tv_user_email)
        tvMemberSince = view.findViewById(R.id.tv_member_since)
        tvUserId = view.findViewById(R.id.tv_user_id)
        tvAccountCreated = view.findViewById(R.id.tv_account_created)
        tvLastLogin = view.findViewById(R.id.tv_last_login)
        tvTotalSessions = view.findViewById(R.id.tv_total_sessions)
        tvAvgSleep = view.findViewById(R.id.tv_avg_sleep)
        tvGoalsAchieved = view.findViewById(R.id.tv_goals_achieved)
        btnLogout = view.findViewById(R.id.btn_logout)
    }

    private fun loadUserData() {
        val currentUser = auth.currentUser

        if (currentUser != null) {
            // Load basic user info from Firebase Auth
            tvUserEmail.text = currentUser.email ?: "Non disponible"

            // Show shortened user ID
            val userId = currentUser.uid
            tvUserId.text = if (userId.length > 8) {
                "${userId.substring(0, 8)}..."
            } else {
                userId
            }

            // Get user creation date
            val creationTimestamp = currentUser.metadata?.creationTimestamp
            if (creationTimestamp != null) {
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val creationDate = Date(creationTimestamp)
                tvAccountCreated.text = dateFormat.format(creationDate)

                // Calculate member since year
                val calendar = Calendar.getInstance()
                calendar.time = creationDate
                val year = calendar.get(Calendar.YEAR)
                tvMemberSince.text = "Membre depuis: $year"
            }

            // Get last login
            val lastSignInTimestamp = currentUser.metadata?.lastSignInTimestamp
            if (lastSignInTimestamp != null) {
                val lastSignIn = Date(lastSignInTimestamp)
                val now = Date()
                val diffInMillis = now.time - lastSignIn.time
                val diffInHours = diffInMillis / (1000 * 60 * 60)

                tvLastLogin.text = when {
                    diffInHours < 1 -> "Il y a quelques minutes"
                    diffInHours < 24 -> "Aujourd'hui"
                    diffInHours < 48 -> "Hier"
                    else -> {
                        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                        dateFormat.format(lastSignIn)
                    }
                }
            }

            // Load user profile data from Firestore
            loadUserProfile(userId)

            // Load statistics
            loadStatistics(userId)
        } else {
            // No user logged in - set default values
            setDefaultValues()
        }
    }

    private fun loadUserProfile(userId: String) {
        firestore.collection("users").document(userId)
            .get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    // Get username from Firestore
                    val username = document.getString("username") ?: document.getString("name")
                    tvUserName.text = username ?: "Utilisateur"
                } else {
                    // Use email as username if no profile exists
                    val email = auth.currentUser?.email
                    tvUserName.text = email?.substringBefore("@") ?: "Utilisateur"
                }
            }
            .addOnFailureListener {
                // Fallback to email
                val email = auth.currentUser?.email
                tvUserName.text = email?.substringBefore("@") ?: "Utilisateur"
            }
    }

    private fun loadStatistics(userId: String) {
        // Load sleep sessions count
        firestore.collection("users").document(userId)
            .collection("sleepSessions")
            .get()
            .addOnSuccessListener { querySnapshot ->
                val totalSessions = querySnapshot.size()
                tvTotalSessions.text = totalSessions.toString()

                // Calculate average sleep duration
                if (totalSessions > 0) {
                    var totalHours = 0.0
                    for (document in querySnapshot.documents) {
                        val duration = document.getDouble("duration") ?: 0.0
                        totalHours += duration
                    }
                    val avgHours = totalHours / totalSessions
                    tvAvgSleep.text = String.format("%.1fh", avgHours)
                } else {
                    tvAvgSleep.text = "0h"
                }
            }
            .addOnFailureListener {
                tvTotalSessions.text = "0"
                tvAvgSleep.text = "0h"
            }

        // Load goals count
        firestore.collection("users").document(userId)
            .collection("goals")
            .get()
            .addOnSuccessListener { querySnapshot ->
                val totalGoals = querySnapshot.documents.count { document ->
                    document.getBoolean("achieved") == true
                }
                tvGoalsAchieved.text = totalGoals.toString()
            }
            .addOnFailureListener {
                tvGoalsAchieved.text = "0"
            }
    }

    private fun setDefaultValues() {
        tvUserName.text = "Utilisateur"
        tvUserEmail.text = "Non connecté"
        tvMemberSince.text = "Membre depuis: 2024"
        tvUserId.text = "********"
        tvAccountCreated.text = "Non disponible"
        tvLastLogin.text = "Non disponible"
        tvTotalSessions.text = "0"
        tvAvgSleep.text = "0h"
        tvGoalsAchieved.text = "0"
    }

    override fun onDetach() {
        super.onDetach()
        logoutListener = null
    }

    companion object {
        fun newInstance() = AccountFragment()
    }
}