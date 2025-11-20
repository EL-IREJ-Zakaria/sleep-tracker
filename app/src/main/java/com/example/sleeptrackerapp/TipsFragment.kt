package com.example.sleeptrackerapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TipsFragment : Fragment(R.layout.fragment_tips) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyView: TextView
    private lateinit var adapter: SleepTipsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_tips)
        emptyView = view.findViewById(R.id.tv_empty_tips)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val tips = getAllSleepTips()

        if (tips.isEmpty()) {
            recyclerView.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyView.visibility = View.GONE

            adapter = SleepTipsAdapter(tips)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    /**
     * Retourne tous les conseils de sommeil professionnels
     * Basés sur la TCC-I et les recommandations d'experts
     */
    private fun getAllSleepTips(): List<SleepTip> {
        return listOf(
            // HORAIRES RÉGULIERS (Contrôle du stimulus)
            SleepTip(
                titleResId = R.string.tip_regular_schedule_title,
                descriptionResId = R.string.tip_regular_schedule_desc,
                iconResId = R.drawable.ic_bell,
                category = TipCategory.SCHEDULE
            ),
            SleepTip(
                titleResId = R.string.tip_wake_time_title,
                descriptionResId = R.string.tip_wake_time_desc,
                iconResId = R.drawable.ic_bell,
                category = TipCategory.SCHEDULE
            ),
            SleepTip(
                titleResId = R.string.tip_bed_sleep_only_title,
                descriptionResId = R.string.tip_bed_sleep_only_desc,
                iconResId = R.drawable.ic_moon,
                category = TipCategory.SCHEDULE
            ),

            // ENVIRONNEMENT DE SOMMEIL
            SleepTip(
                titleResId = R.string.tip_dark_room_title,
                descriptionResId = R.string.tip_dark_room_desc,
                iconResId = R.drawable.ic_moon,
                category = TipCategory.ENVIRONMENT
            ),
            SleepTip(
                titleResId = R.string.tip_temperature_title,
                descriptionResId = R.string.tip_temperature_desc,
                iconResId = R.drawable.ic_moon,
                category = TipCategory.ENVIRONMENT
            ),
            SleepTip(
                titleResId = R.string.tip_quiet_room_title,
                descriptionResId = R.string.tip_quiet_room_desc,
                iconResId = R.drawable.ic_music,
                category = TipCategory.ENVIRONMENT
            ),

            // STYLE DE VIE
            SleepTip(
                titleResId = R.string.tip_exercise_title,
                descriptionResId = R.string.tip_exercise_desc,
                iconResId = R.drawable.ic_stats,
                category = TipCategory.LIFESTYLE
            ),
            SleepTip(
                titleResId = R.string.tip_sunlight_title,
                descriptionResId = R.string.tip_sunlight_desc,
                iconResId = R.drawable.ic_stats,
                category = TipCategory.LIFESTYLE
            ),
            SleepTip(
                titleResId = R.string.tip_screen_time_title,
                descriptionResId = R.string.tip_screen_time_desc,
                iconResId = R.drawable.ic_moon,
                category = TipCategory.LIFESTYLE
            ),

            // TECHNIQUES DE RELAXATION
            SleepTip(
                titleResId = R.string.tip_relaxation_title,
                descriptionResId = R.string.tip_relaxation_desc,
                iconResId = R.drawable.ic_music,
                category = TipCategory.RELAXATION
            ),
            SleepTip(
                titleResId = R.string.tip_worry_time_title,
                descriptionResId = R.string.tip_worry_time_desc,
                iconResId = R.drawable.ic_music,
                category = TipCategory.RELAXATION
            ),

            // ALIMENTATION ET SUBSTANCES
            SleepTip(
                titleResId = R.string.tip_caffeine_title,
                descriptionResId = R.string.tip_caffeine_desc,
                iconResId = R.drawable.ic_bell,
                category = TipCategory.NUTRITION
            ),
            SleepTip(
                titleResId = R.string.tip_alcohol_title,
                descriptionResId = R.string.tip_alcohol_desc,
                iconResId = R.drawable.ic_bell,
                category = TipCategory.NUTRITION
            ),
            SleepTip(
                titleResId = R.string.tip_heavy_meals_title,
                descriptionResId = R.string.tip_heavy_meals_desc,
                iconResId = R.drawable.ic_bell,
                category = TipCategory.NUTRITION
            ),

            // CONSEILS SPÉCIFIQUES AVANCÉS

            // Restriction du sommeil
            SleepTip(
                titleResId = R.string.tip_sleep_restriction_title,
                descriptionResId = R.string.tip_sleep_restriction_desc,
                iconResId = R.drawable.ic_moon,
                category = TipCategory.SCHEDULE
            ),
            SleepTip(
                titleResId = R.string.tip_no_lying_awake_title,
                descriptionResId = R.string.tip_no_lying_awake_desc,
                iconResId = R.drawable.ic_moon,
                category = TipCategory.SCHEDULE
            ),

            // Siestes
            SleepTip(
                titleResId = R.string.tip_nap_strategy_title,
                descriptionResId = R.string.tip_nap_strategy_desc,
                iconResId = R.drawable.ic_bell,
                category = TipCategory.SCHEDULE
            ),

            // Techniques de respiration
            SleepTip(
                titleResId = R.string.tip_478_breathing_title,
                descriptionResId = R.string.tip_478_breathing_desc,
                iconResId = R.drawable.ic_music,
                category = TipCategory.RELAXATION
            ),
            SleepTip(
                titleResId = R.string.tip_coherence_cardiaque_title,
                descriptionResId = R.string.tip_coherence_cardiaque_desc,
                iconResId = R.drawable.ic_music,
                category = TipCategory.RELAXATION
            ),

            // Gestion des réveils nocturnes
            SleepTip(
                titleResId = R.string.tip_night_awakening_title,
                descriptionResId = R.string.tip_night_awakening_desc,
                iconResId = R.drawable.ic_moon,
                category = TipCategory.SCHEDULE
            ),
            SleepTip(
                titleResId = R.string.tip_clock_management_title,
                descriptionResId = R.string.tip_clock_management_desc,
                iconResId = R.drawable.ic_bell,
                category = TipCategory.SCHEDULE
            ),

            // Environnement et literie
            SleepTip(
                titleResId = R.string.tip_mattress_pillow_title,
                descriptionResId = R.string.tip_mattress_pillow_desc,
                iconResId = R.drawable.ic_moon,
                category = TipCategory.ENVIRONMENT
            ),
            SleepTip(
                titleResId = R.string.tip_bedroom_declutter_title,
                descriptionResId = R.string.tip_bedroom_declutter_desc,
                iconResId = R.drawable.ic_moon,
                category = TipCategory.ENVIRONMENT
            ),

            // Aliments et compléments
            SleepTip(
                titleResId = R.string.tip_sleep_foods_title,
                descriptionResId = R.string.tip_sleep_foods_desc,
                iconResId = R.drawable.ic_bell,
                category = TipCategory.NUTRITION
            ),
            SleepTip(
                titleResId = R.string.tip_magnesium_title,
                descriptionResId = R.string.tip_magnesium_desc,
                iconResId = R.drawable.ic_bell,
                category = TipCategory.NUTRITION
            ),

            // Techniques mentales avancées
            SleepTip(
                titleResId = R.string.tip_paradoxical_intention_title,
                descriptionResId = R.string.tip_paradoxical_intention_desc,
                iconResId = R.drawable.ic_music,
                category = TipCategory.RELAXATION
            ),
            SleepTip(
                titleResId = R.string.tip_mental_imagery_title,
                descriptionResId = R.string.tip_mental_imagery_desc,
                iconResId = R.drawable.ic_music,
                category = TipCategory.RELAXATION
            ),

            // Routine du soir
            SleepTip(
                titleResId = R.string.tip_evening_routine_title,
                descriptionResId = R.string.tip_evening_routine_desc,
                iconResId = R.drawable.ic_moon,
                category = TipCategory.LIFESTYLE
            ),
            SleepTip(
                titleResId = R.string.tip_dim_lights_title,
                descriptionResId = R.string.tip_dim_lights_desc,
                iconResId = R.drawable.ic_moon,
                category = TipCategory.ENVIRONMENT
            ),

            // Activité physique ciblée
            SleepTip(
                titleResId = R.string.tip_yoga_sleep_title,
                descriptionResId = R.string.tip_yoga_sleep_desc,
                iconResId = R.drawable.ic_stats,
                category = TipCategory.RELAXATION
            ),
            SleepTip(
                titleResId = R.string.tip_progressive_relaxation_title,
                descriptionResId = R.string.tip_progressive_relaxation_desc,
                iconResId = R.drawable.ic_music,
                category = TipCategory.RELAXATION
            ),

            // Gestion du stress et anxiété
            SleepTip(
                titleResId = R.string.tip_journaling_title,
                descriptionResId = R.string.tip_journaling_desc,
                iconResId = R.drawable.ic_music,
                category = TipCategory.RELAXATION
            ),
            SleepTip(
                titleResId = R.string.tip_meditation_title,
                descriptionResId = R.string.tip_meditation_desc,
                iconResId = R.drawable.ic_music,
                category = TipCategory.RELAXATION
            )
        )
    }

    companion object {
        fun newInstance() = TipsFragment()
    }
}