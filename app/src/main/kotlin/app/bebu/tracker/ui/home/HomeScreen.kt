package app.bebu.tracker.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.bebu.tracker.R
import app.bebu.tracker.ui.theme.BebuTheme

/**
 * Home screen for the Bebu app.
 * 
 * This is a minimal placeholder screen demonstrating the app architecture:
 * - Composable UI layer
 * - ViewModel injected via Hilt
 * - State management with StateFlow
 * - Localized strings from resources
 * 
 * Product features will be added in subsequent PRs.
 */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    
    HomeScreenContent(
        showReadyMessage = uiState.showReadyMessage,
        onGetStartedClick = { viewModel.onGetStartedClick() }
    )
}

@Composable
internal fun HomeScreenContent(
    showReadyMessage: Boolean,
    onGetStartedClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.welcome_title),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = stringResource(R.string.welcome_message),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        if (showReadyMessage) {
            Text(
                text = stringResource(R.string.ready_to_track),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        Button(onClick = onGetStartedClick) {
            Text(text = stringResource(R.string.get_started))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    BebuTheme {
        HomeScreenContent(
            showReadyMessage = false,
            onGetStartedClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenDarkPreview() {
    BebuTheme(darkTheme = true) {
        HomeScreenContent(
            showReadyMessage = true,
            onGetStartedClick = {}
        )
    }
}
