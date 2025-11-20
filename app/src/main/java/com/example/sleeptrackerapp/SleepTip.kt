package com.example.sleeptrackerapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Modèle de données pour les conseils de sommeil professionnels
 * Basé sur les méthodes TCC-I (Thérapie Cognitivo-Comportementale pour l'Insomnie)
 * et les recommandations des experts du sommeil
 */
data class SleepTip(
    @StringRes val titleResId: Int,
    @StringRes val descriptionResId: Int,
    @DrawableRes val iconResId: Int,
    val category: TipCategory
)

enum class TipCategory {
    SCHEDULE,      // Horaires réguliers
    ENVIRONMENT,   // Environnement de sommeil
    LIFESTYLE,     // Style de vie
    RELAXATION,    // Techniques de relaxation
    NUTRITION      // Alimentation
}
