package app.bebu.tracker

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class for Bebu baby tracker.
 * 
 * This class is annotated with @HiltAndroidApp to enable Hilt dependency injection
 * throughout the app. Hilt will generate the necessary components and provide
 * dependencies to Android framework classes like Activities and ViewModels.
 */
@HiltAndroidApp
class BebuApplication : Application()
