# 📸 Guide des Captures d'Écran

Ce dossier contient toutes les captures d'écran de l'application SleepTracker.

## 📋 Liste des Screenshots Requis

### 🎨 Icône et Splash
- [ ] `app_icon.png` - Icône de l'application (512x512px)
- [ ] `splash.png` - Écran de démarrage

### 🔐 Authentification
- [ ] `login.png` - Écran de connexion
- [ ] `register.png` - Écran d'inscription
- [ ] `reset_password.png` - Écran de réinitialisation du mot de passe

### 🎯 Onboarding
- [ ] `onboarding.png` - Vue d'ensemble de l'onboarding
- [ ] `onboarding_1.png` - Première page d'onboarding
- [ ] `onboarding_2.png` - Deuxième page d'onboarding
- [ ] `onboarding_3.png` - Troisième page d'onboarding

### 📱 Application Principale
- [ ] `dashboard.png` - Tableau de bord principal
- [ ] `goals.png` - Écran des objectifs de sommeil
- [ ] `tips.png` - Écran des conseils de sommeil
- [ ] `account.png` - Écran du compte utilisateur

### ⚙️ Fonctionnalités Avancées
- [ ] `add_sleep.png` - Écran d'ajout de session de sommeil
- [ ] `sleep_tracking.png` - Dialog de suivi du sommeil en cours

## 📐 Spécifications Techniques

### Format
- **Format** : PNG avec transparence si nécessaire
- **Résolution** : 1080x2400px (ratio 9:20) pour les screenshots d'écran
- **Qualité** : Haute qualité, sans compression excessive

### Appareil de Référence
- **Modèle** : Pixel 6 ou équivalent
- **Densité** : xxhdpi (480dpi)
- **Orientation** : Portrait

## 🎬 Comment Prendre les Screenshots

### Méthode 1 : Émulateur Android Studio
1. Lancez l'émulateur avec l'application
2. Naviguez vers l'écran souhaité
3. Cliquez sur l'icône 📷 dans la barre d'outils de l'émulateur
4. Ou utilisez le raccourci : `Ctrl + S` (Windows/Linux) ou `Cmd + S` (Mac)

### Méthode 2 : Appareil Physique
1. Connectez votre appareil en mode développeur
2. Naviguez vers l'écran souhaité
3. Utilisez `adb shell screencap -p /sdcard/screenshot.png`
4. Récupérez avec `adb pull /sdcard/screenshot.png`

### Méthode 3 : Android Studio Device File Explorer
1. Ouvrez View → Tool Windows → Device File Explorer
2. Naviguez vers l'écran dans l'app
3. Utilisez l'outil de capture intégré

## 🎨 Conseils pour de Belles Captures

### Données de Démonstration
- Utilisez des **données réalistes** mais cohérentes
- Remplissez les **graphiques** avec des données variées
- Montrez des **objectifs en cours** avec progression visible
- Utilisez des **noms d'utilisateur** génériques (ex: "John Doe")

### Timing
- Prenez les screenshots en **mode jour** pour la cohérence
- Assurez-vous que les **animations** sont terminées
- Vérifiez que tous les **éléments UI** sont chargés

### Qualité
- **Pas de barre de statut** avec notifications personnelles
- **Batterie pleine** et **signal fort** dans la barre de statut
- **Heure cohérente** sur tous les screenshots (ex: 10:30)
- **Pas d'erreurs** ou de messages de debug visibles

## 🖼️ Post-Production (Optionnel)

### Outils Recommandés
- **Figma** - Pour créer des mockups avec device frames
- **Canva** - Pour ajouter des annotations
- **Photoshop/GIMP** - Pour des retouches avancées

### Améliorations Possibles
- Ajouter un **device frame** (cadre de téléphone)
- Créer des **compositions** avec plusieurs écrans
- Ajouter des **annotations** pour expliquer les fonctionnalités
- Créer une **bannière** pour le README principal

## 📦 Organisation

```
screenshots/
├── README.md                    # Ce fichier
├── app_icon.png                # Icône
├── splash.png                  # Splash screen
├── login.png                   # Authentification
├── register.png
├── reset_password.png
├── onboarding.png              # Onboarding
├── onboarding_1.png
├── onboarding_2.png
├── onboarding_3.png
├── dashboard.png               # App principale
├── goals.png
├── tips.png
├── account.png
├── add_sleep.png               # Fonctionnalités
└── sleep_tracking.png
```

## ✅ Checklist Avant Publication

- [ ] Tous les screenshots sont pris
- [ ] Résolution et format corrects
- [ ] Pas d'informations personnelles visibles
- [ ] Qualité d'image optimale
- [ ] Noms de fichiers cohérents avec le README
- [ ] Screenshots mis à jour après modifications UI

## 🔄 Mise à Jour

Pensez à mettre à jour les screenshots lorsque :
- Le **design** de l'application change
- De **nouvelles fonctionnalités** sont ajoutées
- Des **bugs visuels** sont corrigés
- La **palette de couleurs** est modifiée

---
