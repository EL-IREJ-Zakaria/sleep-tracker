package com.example.sleeptrackerapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GoalsFragment : Fragment(R.layout.fragment_goals) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyView: TextView
    private lateinit var adapter: SleepGoalAdapter
    private val goals = mutableListOf<SleepGoal>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_goals)
        emptyView = view.findViewById(R.id.tv_empty_goals)

        setupGoals()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        if (goals.isEmpty()) {
            recyclerView.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyView.visibility = View.GONE

            adapter = SleepGoalAdapter(goals) { goal ->
                onGoalClicked(goal)
            }
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun onGoalClicked(goal: SleepGoal) {
        // Toggle l'état actif de l'objectif
        goal.isActive = !goal.isActive

        val message = if (goal.isActive) {
            getString(R.string.goals_activate)
        } else {
            getString(R.string.goals_deactivate)
        }

        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        adapter.notifyDataSetChanged()
    }

    /**
     * Initialise tous les objectifs de sommeil disponibles
     * Organisés par catégories : Durée, Qualité, Horaires, Style de vie
     */
    private fun setupGoals() {
        goals.clear()

        // OBJECTIFS DE DURÉE
        goals.add(
            SleepGoal(
                id = 1,
                titleResId = R.string.goal_8h_title,
                descriptionResId = R.string.goal_8h_desc,
                targetValue = getString(R.string.goal_8h_target),
                iconResId = R.drawable.ic_moon,
                category = GoalCategory.DURATION,
                isActive = true,
                progress = 75
            )
        )

        goals.add(
            SleepGoal(
                id = 2,
                titleResId = R.string.goal_7h_title,
                descriptionResId = R.string.goal_7h_desc,
                targetValue = getString(R.string.goal_7h_target),
                iconResId = R.drawable.ic_moon,
                category = GoalCategory.DURATION,
                isActive = false,
                progress = 85
            )
        )

        goals.add(
            SleepGoal(
                id = 3,
                titleResId = R.string.goal_consistent_duration_title,
                descriptionResId = R.string.goal_consistent_duration_desc,
                targetValue = getString(R.string.goal_consistent_duration_target),
                iconResId = R.drawable.ic_stats,
                category = GoalCategory.DURATION,
                isActive = false,
                progress = 60
            )
        )

        // OBJECTIFS DE QUALITÉ
        goals.add(
            SleepGoal(
                id = 4,
                titleResId = R.string.goal_deep_sleep_title,
                descriptionResId = R.string.goal_deep_sleep_desc,
                targetValue = getString(R.string.goal_deep_sleep_target),
                iconResId = R.drawable.ic_moon,
                category = GoalCategory.QUALITY,
                isActive = false,
                progress = 45
            )
        )

        goals.add(
            SleepGoal(
                id = 5,
                titleResId = R.string.goal_sleep_efficiency_title,
                descriptionResId = R.string.goal_sleep_efficiency_desc,
                targetValue = getString(R.string.goal_sleep_efficiency_target),
                iconResId = R.drawable.ic_stats,
                category = GoalCategory.QUALITY,
                isActive = false,
                progress = 70
            )
        )

        goals.add(
            SleepGoal(
                id = 6,
                titleResId = R.string.goal_no_interruptions_title,
                descriptionResId = R.string.goal_no_interruptions_desc,
                targetValue = getString(R.string.goal_no_interruptions_target),
                iconResId = R.drawable.ic_moon,
                category = GoalCategory.QUALITY,
                isActive = false,
                progress = 55
            )
        )

        // OBJECTIFS D'HORAIRES
        goals.add(
            SleepGoal(
                id = 7,
                titleResId = R.string.goal_regular_bedtime_title,
                descriptionResId = R.string.goal_regular_bedtime_desc,
                targetValue = getString(R.string.goal_regular_bedtime_target),
                iconResId = R.drawable.ic_bell,
                category = GoalCategory.SCHEDULE,
                isActive = false,
                progress = 80
            )
        )

        goals.add(
            SleepGoal(
                id = 8,
                titleResId = R.string.goal_regular_wake_title,
                descriptionResId = R.string.goal_regular_wake_desc,
                targetValue = getString(R.string.goal_regular_wake_target),
                iconResId = R.drawable.ic_bell,
                category = GoalCategory.SCHEDULE,
                isActive = false,
                progress = 90
            )
        )

        goals.add(
            SleepGoal(
                id = 9,
                titleResId = R.string.goal_no_snooze_title,
                descriptionResId = R.string.goal_no_snooze_desc,
                targetValue = getString(R.string.goal_no_snooze_target),
                iconResId = R.drawable.ic_bell,
                category = GoalCategory.SCHEDULE,
                isActive = false,
                progress = 30
            )
        )

        goals.add(
            SleepGoal(
                id = 10,
                titleResId = R.string.goal_early_bedtime_title,
                descriptionResId = R.string.goal_early_bedtime_desc,
                targetValue = getString(R.string.goal_early_bedtime_target),
                iconResId = R.drawable.ic_moon,
                category = GoalCategory.SCHEDULE,
                isActive = false,
                progress = 65
            )
        )

        // OBJECTIFS DE STYLE DE VIE
        goals.add(
            SleepGoal(
                id = 11,
                titleResId = R.string.goal_no_screens_title,
                descriptionResId = R.string.goal_no_screens_desc,
                targetValue = getString(R.string.goal_no_screens_target),
                iconResId = R.drawable.ic_music,
                category = GoalCategory.LIFESTYLE,
                isActive = false,
                progress = 40
            )
        )

        goals.add(
            SleepGoal(
                id = 12,
                titleResId = R.string.goal_evening_routine_title,
                descriptionResId = R.string.goal_evening_routine_desc,
                targetValue = getString(R.string.goal_evening_routine_target),
                iconResId = R.drawable.ic_music,
                category = GoalCategory.LIFESTYLE,
                isActive = false,
                progress = 50
            )
        )

        goals.add(
            SleepGoal(
                id = 13,
                titleResId = R.string.goal_no_caffeine_title,
                descriptionResId = R.string.goal_no_caffeine_desc,
                targetValue = getString(R.string.goal_no_caffeine_target),
                iconResId = R.drawable.ic_bell,
                category = GoalCategory.LIFESTYLE,
                isActive = false,
                progress = 95
            )
        )

        goals.add(
            SleepGoal(
                id = 14,
                titleResId = R.string.goal_exercise_daily_title,
                descriptionResId = R.string.goal_exercise_daily_desc,
                targetValue = getString(R.string.goal_exercise_daily_target),
                iconResId = R.drawable.ic_stats,
                category = GoalCategory.LIFESTYLE,
                isActive = false,
                progress = 70
            )
        )

        goals.add(
            SleepGoal(
                id = 15,
                titleResId = R.string.goal_no_alcohol_title,
                descriptionResId = R.string.goal_no_alcohol_desc,
                targetValue = getString(R.string.goal_no_alcohol_target),
                iconResId = R.drawable.ic_bell,
                category = GoalCategory.LIFESTYLE,
                isActive = false,
                progress = 85
            )
        )
    }

    companion object {
        fun newInstance() = GoalsFragment()
    }
}