package com.example.sleeptrackerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adaptateur pour afficher les conseils de sommeil dans un RecyclerView
 */
class SleepTipsAdapter(private val tips: List<SleepTip>) :
    RecyclerView.Adapter<SleepTipsAdapter.TipViewHolder>() {

    class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.tip_icon)
        val title: TextView = view.findViewById(R.id.tip_title)
        val description: TextView = view.findViewById(R.id.tip_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sleep_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        holder.icon.setImageResource(tip.iconResId)
        holder.title.setText(tip.titleResId)
        holder.description.setText(tip.descriptionResId)
    }

    override fun getItemCount() = tips.size
}
