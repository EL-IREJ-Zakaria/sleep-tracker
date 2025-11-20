package com.example.sleeptrackerapp

import java.io.Serializable

/**
 * Représente un objectif de sommeil
 */
data class SleepGoal(
    val id: Int,
    val titleResId: Int,
    val descriptionResId: Int,
    val targetValue: String,
    val iconResId: Int,
    val category: GoalCategory,
    var isActive: Boolean = false,
    var progress: Int = 0 // Pourcentage de progression (0-100)
) : Serializable

/**
 * Catégories d'objectifs de sommeil
 */
enum class GoalCategory {
    DURATION,      // Durée du sommeil
    QUALITY,       // Qualité du sommeil
    SCHEDULE,      // Régularité des horaires
    LIFESTYLE      // Style de vie
}
