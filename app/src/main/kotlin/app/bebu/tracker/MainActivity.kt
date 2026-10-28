package app.bebu.tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import app.bebu.tracker.ui.home.HomeScreen
import app.bebu.tracker.ui.theme.BebuTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main and only Activity for the Bebu app (single-activity architecture).
 * 
 * This activity serves as the host for all Compose UI screens. It's annotated with
 * @AndroidEntryPoint to enable Hilt dependency injection for this activity and its
 * composable hierarchy.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        setContent {
            BebuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}
