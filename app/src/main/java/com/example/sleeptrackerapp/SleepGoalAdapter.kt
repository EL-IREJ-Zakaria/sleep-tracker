package com.example.sleeptrackerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class SleepGoalAdapter(
    private val goals: List<SleepGoal>,
    private val onGoalClick: (SleepGoal) -> Unit
) : RecyclerView.Adapter<SleepGoalAdapter.GoalViewHolder>() {

    inner class GoalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.card_goal)
        val statusIndicator: View = itemView.findViewById(R.id.status_indicator)
        val iconContainer: CardView = itemView.findViewById(R.id.icon_container)
        val iconView: ImageView = itemView.findViewById(R.id.iv_goal_icon)
        val titleView: TextView = itemView.findViewById(R.id.tv_goal_title)
        val descriptionView: TextView = itemView.findViewById(R.id.tv_goal_description)
        val targetView: TextView = itemView.findViewById(R.id.tv_goal_target)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progress_goal)
        val progressText: TextView = itemView.findViewById(R.id.tv_progress_percent)
        val statusIconContainer: CardView = itemView.findViewById(R.id.status_icon_container)
        val statusIcon: ImageView = itemView.findViewById(R.id.iv_goal_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sleep_goal, parent, false)
        return GoalViewHolder(view)
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        val goal = goals[position]
        val context = holder.itemView.context

        // Définir le titre et la description
        holder.titleView.text = context.getString(goal.titleResId)
        holder.descriptionView.text = context.getString(goal.descriptionResId)
        holder.targetView.text = goal.targetValue
        holder.iconView.setImageResource(goal.iconResId)

        // Progression
        holder.progressBar.progress = goal.progress
        holder.progressText.text = "${goal.progress}%"

        // Icône de statut (actif ou non)
        if (goal.isActive) {
            holder.statusIcon.setImageResource(R.drawable.ic_check)
            holder.statusIcon.setColorFilter(
                ContextCompat.getColor(context, R.color.green_success)
            )
            holder.statusIconContainer.setCardBackgroundColor(
                ContextCompat.getColor(context, R.color.success)
            )
            holder.statusIndicator.setBackgroundColor(
                ContextCompat.getColor(context, R.color.green_success)
            )
        } else {
            holder.statusIcon.setImageResource(R.drawable.ic_add)
            holder.statusIcon.setColorFilter(
                ContextCompat.getColor(context, R.color.pale_purple)
            )
            holder.statusIconContainer.setCardBackgroundColor(
                ContextCompat.getColor(context, R.color.night_blue)
            )
            holder.statusIndicator.setBackgroundColor(
                ContextCompat.getColor(context, R.color.pale_purple)
            )
        }

        // Click listener
        holder.cardView.setOnClickListener {
            onGoalClick(goal)
        }
    }

    override fun getItemCount() = goals.size
}
