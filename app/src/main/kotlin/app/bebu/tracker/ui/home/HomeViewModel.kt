package app.bebu.tracker.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.bebu.tracker.data.local.BebuDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * UI state for the home screen.
 */
data class HomeUiState(
    val showReadyMessage: Boolean = false
)

/**
 * ViewModel for the home screen.
 * 
 * Demonstrates the MVVM architecture pattern:
 * - Injected by Hilt (@HiltViewModel)
 * - Manages UI state via StateFlow
 * - Uses Room database (injected via constructor)
 * - Business logic separated from UI
 * 
 * This is a minimal placeholder. Real features (feeding, diapers, sleep tracking)
 * will follow similar patterns with their own ViewModels and data layers.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val database: BebuDatabase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    
    init {
        // Verify database is accessible
        viewModelScope.launch {
            try {
                // This just ensures the database is created
                database.openHelper.writableDatabase
            } catch (e: Exception) {
                // In a real app, handle database initialization errors
                e.printStackTrace()
            }
        }
    }
    
    /**
     * Handle "Get Started" button click.
     * 
     * This is just a demonstration of how user interactions flow through
     * the ViewModel to update UI state. Real navigation logic will be
     * added when implementing actual features.
     */
    fun onGetStartedClick() {
        _uiState.update { currentState ->
            currentState.copy(
                showReadyMessage = true
            )
        }
    }
}
