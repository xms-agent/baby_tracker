# Bebu - Baby Tracker App

Bebu is a baby tracking application for Android that helps parents track feeding, diapers, sleep, milestones, and journal entries. The app is available in both Romanian and English.

## 🏗️ Current Status

This is the **initial project skeleton**. Only the basic app structure is implemented - no product features yet. This skeleton demonstrates the architecture and development setup.

## 📱 What's Included

- ✅ Buildable empty Android app
- ✅ Jetpack Compose with Material 3
- ✅ Warm terracotta color theme (light + dark modes)
- ✅ MVVM architecture with clean architecture principles
- ✅ Hilt dependency injection
- ✅ Room database setup with schema export
- ✅ Bilingual support (English + Romanian)
- ✅ Unit tests with Robolectric
- ✅ GitHub Actions CI pipeline
- ✅ Gradle version catalog

## 🛠️ Technology Stack

### Core
- **Language**: Kotlin 2.0.21
- **Min SDK**: 26 (Android 8.0 Oreo)
- **Target/Compile SDK**: 35 (Android 15)
- **Build**: Gradle 8.11.1 with Kotlin DSL

### Architecture & UI
- **Architecture**: Single-activity, MVVM with clean architecture
  - `ui` - Presentation layer (Compose UI, ViewModels)
  - `data` - Data layer (Room database, DAOs, entities)
  - `di` - Dependency injection modules (Hilt)
- **UI Framework**: Jetpack Compose with Compose BOM 2024.12.01
- **Material Design**: Material 3
- **Navigation**: Jetpack Navigation Compose (ready to use)

### Dependencies
- **Dependency Injection**: Hilt 2.52
- **Database**: Room 2.6.1 with KSP
- **Lifecycle**: AndroidX Lifecycle 2.8.7
- **Testing**: JUnit 4, Robolectric 4.14.1, Compose UI Testing

### Why These Libraries?

**Jetpack Compose** - Modern declarative UI toolkit that simplifies Android UI development with less boilerplate and better preview support.

**Material 3** - Latest Material Design guidelines with support for dynamic theming and modern design patterns.

**Hilt** - Official Android dependency injection framework built on Dagger, provides compile-time safety and integrates seamlessly with Android components.

**Room** - Official Android ORM that provides compile-time SQL query verification and easy database migrations. Essential for offline-first baby tracking data.

**Robolectric** - Enables fast JVM-based unit tests for Android UI components without requiring an emulator.

**Gradle Version Catalog** - Centralized dependency management in `gradle/libs.versions.toml` makes version updates easier and prevents version conflicts.

## 🎨 Theme & Design

The app uses a **warm terracotta color palette** as default:
- Primary: Terracotta orange (`#D4704A`)
- Background: Warm off-white (`#FFF8F6`)
- Both light and dark themes supported

**Material You dynamic colors** are available as an optional setting (Android 12+) but **OFF by default**. The theme parameter `useDynamicColor` controls this in `BebuTheme.kt`.

> **Note**: Current colors are placeholder tokens. The designer will provide final color and typography specifications later, which can be easily swapped in `ui/theme/BebuTheme.kt` and `colors.xml`.

## 📂 Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── kotlin/app/bebu/tracker/
│   │   │   ├── BebuApplication.kt          # Hilt app class
│   │   │   ├── MainActivity.kt             # Single activity
│   │   │   ├── ui/
│   │   │   │   ├── home/
│   │   │   │   │   ├── HomeScreen.kt       # Placeholder home screen
│   │   │   │   │   └── HomeViewModel.kt    # Demo ViewModel
│   │   │   │   └── theme/
│   │   │   │       ├── BebuTheme.kt        # Material 3 theme
│   │   │   │       └── Type.kt             # Typography
│   │   │   ├── data/
│   │   │   │   └── local/
│   │   │   │       ├── BebuDatabase.kt     # Room database
│   │   │   │       ├── entity/             # Database entities
│   │   │   │       └── dao/                # Database DAOs
│   │   │   └── di/
│   │   │       └── DatabaseModule.kt       # Hilt DI module
│   │   ├── res/
│   │   │   ├── values/strings.xml          # English strings
│   │   │   ├── values-ro/strings.xml       # Romanian strings
│   │   │   └── values/colors.xml           # Color tokens
│   │   └── AndroidManifest.xml
│   └── test/
│       └── kotlin/app/bebu/tracker/
│           └── ui/home/
│               ├── HomeViewModelTest.kt    # ViewModel unit tests
│               └── HomeScreenTest.kt       # Compose UI tests
├── build.gradle.kts                        # App module build config
└── schemas/                                # Room database schemas
```

## 🚀 Getting Started

### Prerequisites
- **Android Studio**: Ladybug (2024.2.1) or newer
- **JDK**: 17 or higher
- **Android SDK**: API 35 installed

### Opening the Project

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd bebu
   ```

2. **Open in Android Studio**:
   - Launch Android Studio
   - Click "Open" (not "Import")
   - Navigate to the project folder and select it
   - Wait for Gradle sync to complete (may take a few minutes on first open)

3. **If Gradle sync fails**:
   - Check that JDK 17 is configured (File → Project Structure → SDK Location)
   - Ensure Android SDK is installed with API 35
   - Try "File → Invalidate Caches and Restart"

### Running the App

#### On a Physical Device
1. Enable Developer Options on your Android device:
   - Go to Settings → About Phone
   - Tap "Build Number" 7 times
   - Go back to Settings → Developer Options
   - Enable "USB Debugging"

2. Connect your device via USB and allow debugging

3. In Android Studio, click the green "Run" button (▶️) or press Shift+F10

4. Select your device from the dropdown and click OK

#### On an Emulator
1. Open AVD Manager (Tools → Device Manager)
2. Create a new virtual device (e.g., Pixel 6 with API 34+)
3. Click "Run" and select your emulator

**What to expect**: You'll see a simple welcome screen with the Bebu app name, a welcome message (in your device language if set to Romanian or English), and a "Get Started" button.

### Running Tests

#### From Android Studio
- **All tests**: Right-click `app/src/test` → Run 'Tests in app'
- **Single test**: Click the green arrow next to a test class or method

#### From Command Line
```bash
# Run all unit tests
./gradlew testDebugUnitTest

# Run tests with coverage report
./gradlew testDebugUnitTest jacocoTestReport

# Run lint checks
./gradlew lintDebug

# Build debug APK
./gradlew assembleDebug
```

**Test output location**: `app/build/reports/tests/testDebugUnitTest/index.html`

## 🔄 CI/CD

The project includes a GitHub Actions workflow (`.github/workflows/ci.yml`) that runs on every pull request:

- ✅ Builds the app (`assembleDebug`)
- ✅ Runs unit tests (`testDebugUnitTest`)
- ✅ Runs lint checks (`lintDebug`)
- ✅ Uploads build artifacts (APK, test reports)

**Why no instrumented tests in CI?** Instrumented tests require an emulator and significantly increase CI time (5-10 minutes). They're better run locally or in a dedicated nightly build. The Robolectric tests provide good coverage for UI components without emulator overhead.

## 🔥 Firebase (Not Yet Configured)

Firebase is **not** set up in this skeleton because no Firebase project exists yet. When ready to add Firebase:

1. Create a Firebase project in the Firebase Console
2. Add an Android app with package name `app.bebu.tracker`
3. Download `google-services.json` and place it in the `app/` directory
4. Uncomment the Firebase plugin in `app/build.gradle.kts`:
   ```kotlin
   // plugins {
   //     id("com.google.gms.google-services")
   // }
   ```
5. Add Firebase dependencies to the version catalog and sync

Common Firebase services you might need:
- Authentication (email/phone sign-in)
- Firestore (cloud sync for backup/multi-device)
- Cloud Storage (photos of milestones, baby journal)
- Remote Config (feature flags)
- Crashlytics (crash reporting)

**Note**: No analytics or tracking SDKs are included by design.

## 🌍 Localization

The app supports:
- **English** (`values/strings.xml`)
- **Romanian** (`values-ro/strings.xml`)

All UI text must use string resources - no hardcoded text is allowed. To add a new string:

1. Add to `app/src/main/res/values/strings.xml` (English)
2. Add translation to `app/src/main/res/values-ro/strings.xml` (Romanian)
3. Use in Compose: `stringResource(R.string.your_key)`

## 📝 Next Steps

This skeleton is ready for feature development:

1. **User onboarding flow** - Welcome wizard, privacy policy acceptance
2. **Baby profile setup** - Name, birthdate, photo
3. **Feeding tracker** - Breast/bottle, times, duration, amounts
4. **Diaper tracker** - Type (wet/dirty/both), timestamps
5. **Sleep tracker** - Start/end times, nap vs. night sleep
6. **Milestone tracker** - Predefined + custom milestones with photos
7. **Journal** - Daily notes, photos, memories
8. **Data export/backup** - CSV export, Firebase sync (once configured)
9. **Widgets** - Quick log entry from home screen
10. **Settings** - Theme selection (including dynamic color toggle), units, notifications

Each feature should follow the established architecture:
- Add entities and DAOs in `data/local/`
- Create repository classes for business logic
- Build ViewModels in `ui/<feature>/`
- Design Compose screens with proper state management
- Write unit tests for ViewModels and repositories

## 🤝 Contributing

When adding features:
1. Create a feature branch from `main`
2. Follow the existing package structure (`ui`, `data`, `di`)
3. Add string resources in both languages
4. Write unit tests for ViewModels
5. Update this README if adding major features
6. Submit a PR for review

## 📄 License

[Add your license here]

## 🙋 Questions?

This README is written for a beginner learning Android development. Each section explains not just *what* but *why*. As you build features, refer back to the existing code in `ui/home/` for examples of the architecture patterns in action.

Happy coding! 👶📱
