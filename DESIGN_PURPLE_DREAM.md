# 🎨 Design Purple Dream - Documentation

## Vue d'ensemble

Ce document décrit la nouvelle palette de couleurs **Purple Dream** appliquée à l'application Sleep Tracker. Le design utilise des tons de violet profond pour créer une atmosphère apaisante et propice au sommeil.

---

## 🎨 Palette de Couleurs Principale

| Nom | Code Hex | Utilisation |
|-----|----------|-------------|
| **Soft Eggplant** | `#2E1065` | Fond principal - Violet très sombre |
| **Lavender** | `#C084FC` | Couleur primaire - Boutons et interactions |
| **Pink Dream** | `#E879F9` | Couleur secondaire - Accents visuels |
| **Night Blue** | `#4C1D95` | Couleur tertiaire - Arrières-plans de cartes |
| **Pale Purple** | `#FAF5FF` | Texte principal - Très clair avec teinte violette |

---

## 📄 Fichiers Modifiés

### 1. **Couleurs** (`colors.xml`)
- ✅ Palette complète de couleurs violettes
- ✅ Couleurs pour les textes (primaire, secondaire, tertiaire)
- ✅ Couleurs fonctionnelles (succès, avertissement, erreur)
- ✅ Couleurs pour les graphiques de sommeil
- ✅ Couleurs pour les dégradés

### 2. **Thèmes**
- ✅ `themes.xml` - Thème principal avec palette Purple Dream
- ✅ `themes-night.xml` - Thème nuit compatible
- ✅ Styles de boutons personnalisés (primaire, secondaire, outlined)
- ✅ Styles de cartes avec coins arrondis
- ✅ Styles de texte

### 3. **Layouts - Pages Principales**

#### Authentification
- ✅ `activity_login.xml` - Page de connexion
- ✅ `activity_register.xml` - Page d'inscription
- ✅ `activity_reset_password.xml` - Réinitialisation du mot de passe
- ✅ `activity_onboarding.xml` - Écrans d'introduction

#### Fragments Principaux
- ✅ `fragment_dashboard.xml` - Tableau de bord
- ✅ `fragment_goals.xml` - Objectifs de sommeil (complété avec UI)
- ✅ `fragment_tips.xml` - Conseils pour mieux dormir (complété avec UI)
- ✅ `fragment_account.xml` - Compte utilisateur

#### Autres Activités
- ✅ `activity_main.xml` - Activité principale
- ✅ `activity_splash.xml` - Écran de démarrage
- ✅ `activity_add_sleep.xml` - Ajout de session de sommeil (complété avec UI)
- ✅ `dialog_sleep_tracking.xml` - Dialog de suivi du sommeil

### 4. **Layouts - Items RecyclerView**
- ✅ `item_sleep_session.xml` - Item de session de sommeil
- ✅ `item_tip.xml` - Item de conseil
- ✅ `item_goal_history.xml` - Item d'historique d'objectif
- ✅ `item_onboarding_page.xml` - Item de page d'onboarding
- ✅ `item_day.xml` - Item de jour (déjà configuré)
- ✅ `onboarding_page.xml` - Page d'onboarding (déjà configuré)

### 5. **Drawables - Boutons et Formes**
- ✅ `primary_button_background.xml` - Fond de bouton primaire
- ✅ `button_rounded.xml` - Bouton arrondi
- ✅ `button_primary.xml` - Bouton primaire avec dégradé
- ✅ `social_button_background.xml` - Boutons sociaux
- ✅ `input_background.xml` - Fond des champs de saisie
- ✅ `spinner_background.xml` - Fond des spinners

### 6. **Drawables - Navigation et UI**
- ✅ `nav_bg.xml` - Fond de la barre de navigation
- ✅ `nav_bar_background.xml` - Fond alternatif de navigation
- ✅ `selected_background.xml` - Fond de l'élément sélectionné
- ✅ `selected_item_bg.xml` - Fond d'item sélectionné
- ✅ `dot_active.xml` - Point actif (pagination)
- ✅ `dot_inactive.xml` - Point inactif (pagination)

### 7. **Drawables - Effets et Décorations**
- ✅ `gradient_background.xml` - Dégradé de fond
- ✅ `gradient_primary.xml` - Dégradé primaire
- ✅ `gradient_card.xml` - Dégradé pour cartes
- ✅ `bg_gradient.xml` - Dégradé de fond alternatif
- ✅ `card_modern.xml` - Carte moderne
- ✅ `blur_circle_1.xml` - Cercle flou effet 1
- ✅ `blur_circle_2.xml` - Cercle flou effet 2
- ✅ `circle_progress.xml` - Cercle de progression

---

## 🎯 Utilisation des Couleurs par Composant

### Boutons
- **Bouton Principal** : Fond `lavender` (#C084FC), texte `soft_eggplant` (#2E1065)
- **Bouton Secondaire** : Fond `pink_dream` (#E879F9), texte `soft_eggplant` (#2E1065)
- **Bouton Outlined** : Bordure `lavender` (#C084FC), texte `lavender` (#C084FC)

### Cartes
- **Fond** : `night_blue` (#4C1D95)
- **Titre** : `lavender` (#C084FC)
- **Texte** : `pale_purple` (#FAF5FF)
- **Coins arrondis** : 16-20dp

### Textes
- **Titres principaux** : `lavender` (#C084FC), 28-32sp, sans-serif-medium
- **Sous-titres** : `lavender` (#C084FC), 18-20sp
- **Texte normal** : `pale_purple` (#FAF5FF), 14-16sp
- **Texte secondaire** : `text_secondary` (#E9D5FF)

### Éléments d'interface
- **FAB (Floating Action Button)** :
  - Dashboard : `lavender` avec icône `soft_eggplant`
  - Goals : `pink_dream` avec icône `soft_eggplant`
- **Barre de navigation** : Fond `night_blue`, icônes sélectionnées avec dégradé `lavender` → `pink_dream`
- **Champs de saisie** : Fond `soft_eggplant` avec bordure `night_blue`

---

## 🌈 Dégradés

### Dégradé Principal
```
Angle: 135°
Start: lavender (#C084FC)
Center: pink_dream (#E879F9)
End: violet (#A855F7)
```

### Dégradé de Fond
```
Angle: 135°
Start: soft_eggplant (#2E1065)
Center: night_blue (#4C1D95)
End: background_tertiary (#5B21B6)
```

---

## 📱 Composants Complétés

### Nouveaux layouts créés/complétés :
1. **Fragment Goals** - Interface complète avec carte d'objectif et FAB
2. **Fragment Tips** - Interface avec RecyclerView pour les conseils
3. **Activity Add Sleep** - Formulaire d'ajout de session de sommeil

### Items RecyclerView créés :
1. **Item Sleep Session** - Affichage d'une session de sommeil
2. **Item Tip** - Affichage d'un conseil
3. **Item Goal History** - Affichage d'un objectif dans l'historique
4. **Item Onboarding Page** - Page d'introduction

---

## ✨ Caractéristiques du Design

- **Cohérence** : Toutes les pages utilisent la même palette de couleurs
- **Accessibilité** : Contraste élevé entre texte clair et fond sombre
- **Modernité** : Coins arrondis (12-20dp), cartes avec élévation
- **Atmosphère** : Tons violets apaisants pour favoriser le sommeil
- **Gradients** : Effets de dégradé subtils pour profondeur visuelle

---

## 🔧 Commandes Utiles

### Rebuild du projet
```bash
./gradlew clean build
```

### Synchroniser Gradle
```bash
./gradlew sync
```

---

## 📝 Notes

- Tous les layouts utilisent désormais des références de couleurs (`@color/...`) au lieu de codes hex en dur
- Les drawables utilisent les couleurs du thème pour une cohérence maximale
- Le design est compatible avec le mode jour/nuit
- Aucune erreur de linting détectée

---

**Date de création** : $(Get-Date -Format "yyyy-MM-dd")
**Version** : 1.0 - Purple Dream Design
