package app.bebu.tracker.ui.home

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import app.bebu.tracker.data.local.BebuDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Unit tests for HomeViewModel.
 * 
 * These tests demonstrate:
 * - Testing ViewModels with Robolectric (allows Android framework usage)
 * - Using Kotlin coroutines test utilities
 * - Testing StateFlow state changes
 * - Using an in-memory Room database for testing
 * 
 * Tests are fast, deterministic, and don't require an emulator or device.
 */
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class HomeViewModelTest {
    
    private lateinit var database: BebuDatabase
    private lateinit var viewModel: HomeViewModel
    private val testDispatcher = StandardTestDispatcher()
    
    @Before
    fun setup() {
        // Set up test coroutine dispatcher for deterministic testing
        Dispatchers.setMain(testDispatcher)
        
        // Create an in-memory database for testing
        // Data is cleared when the database is closed
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            BebuDatabase::class.java
        ).allowMainThreadQueries().build()
        
        viewModel = HomeViewModel(database)
    }
    
    @After
    fun tearDown() {
        database.close()
        Dispatchers.resetMain()
    }
    
    @Test
    fun `initial state has showReadyMessage false`() = runTest {
        // Given: ViewModel is created (in setup)
        advanceUntilIdle()
        
        // Then: Initial state should have showReadyMessage false
        val state = viewModel.uiState.value
        assertEquals(false, state.showReadyMessage)
    }
    
    @Test
    fun `onGetStartedClick sets showReadyMessage to true`() = runTest {
        // Given: ViewModel with initial state
        advanceUntilIdle()
        val initialState = viewModel.uiState.value
        assertEquals(false, initialState.showReadyMessage)
        
        // When: User clicks get started button
        viewModel.onGetStartedClick()
        advanceUntilIdle()
        
        // Then: showReadyMessage should be set to true
        val updatedState = viewModel.uiState.value
        assertEquals(true, updatedState.showReadyMessage)
    }
    
    @Test
    fun `database is accessible from ViewModel`() = runTest {
        // Given: ViewModel with database
        advanceUntilIdle()
        
        // Then: Database should be initialized and accessible
        val db = database.openHelper.writableDatabase
        assertTrue(db.isOpen)
    }
}
