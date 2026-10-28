package app.bebu.tracker.ui.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import app.bebu.tracker.ui.theme.BebuTheme
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * UI tests for HomeScreen composable.
 * 
 * These tests use Robolectric to run Compose UI tests on the JVM without
 * requiring an emulator or device. This makes them fast and suitable for CI.
 * 
 * For instrumented tests that run on actual devices, see androidTest directory
 * (not included in this skeleton as they require emulator setup in CI).
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class HomeScreenTest {
    
    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    @Config(qualifiers = "en")
    fun `home screen displays English welcome title`() {
        // Given: Home screen is rendered with English locale
        val context = RuntimeEnvironment.getApplication()
        
        composeTestRule.setContent {
            BebuTheme {
                HomeScreenContent(
                    showReadyMessage = false,
                    onGetStartedClick = {}
                )
            }
        }
        
        // Then: English welcome title should be displayed
        composeTestRule
            .onNodeWithText("Welcome to Bebu")
            .assertIsDisplayed()
    }
    
    @Test
    @Config(qualifiers = "ro")
    fun `home screen displays Romanian welcome title`() {
        // Given: Home screen is rendered with Romanian locale
        val context = RuntimeEnvironment.getApplication()
        
        composeTestRule.setContent {
            BebuTheme {
                HomeScreenContent(
                    showReadyMessage = false,
                    onGetStartedClick = {}
                )
            }
        }
        
        // Then: Romanian welcome title should be displayed
        composeTestRule
            .onNodeWithText("Bine ai venit la Bebu")
            .assertIsDisplayed()
    }
    
    @Test
    @Config(qualifiers = "en")
    fun `clicking get started button triggers callback`() {
        // Given: Home screen with click handler
        var buttonClicked = false
        composeTestRule.setContent {
            BebuTheme {
                HomeScreenContent(
                    showReadyMessage = false,
                    onGetStartedClick = { buttonClicked = true }
                )
            }
        }
        
        // When: User clicks the "Get Started" button
        composeTestRule
            .onNodeWithText("Get Started")
            .performClick()
        
        // Then: Callback should have been invoked
        assertEquals(true, buttonClicked)
    }
    
    @Test
    @Config(qualifiers = "ro")
    fun `clicking get started button in Romanian triggers callback`() {
        // Given: Home screen with Romanian locale and click handler
        var buttonClicked = false
        composeTestRule.setContent {
            BebuTheme {
                HomeScreenContent(
                    showReadyMessage = false,
                    onGetStartedClick = { buttonClicked = true }
                )
            }
        }
        
        // When: User clicks the "Începe" button
        composeTestRule
            .onNodeWithText("Începe")
            .performClick()
        
        // Then: Callback should have been invoked
        assertEquals(true, buttonClicked)
    }
    
    @Test
    @Config(qualifiers = "en")
    fun `ready message is displayed when showReadyMessage is true`() {
        // Given: Home screen with showReadyMessage = true
        composeTestRule.setContent {
            BebuTheme {
                HomeScreenContent(
                    showReadyMessage = true,
                    onGetStartedClick = {}
                )
            }
        }
        
        // Then: Ready message should be visible
        composeTestRule
            .onNodeWithText("Ready to track your baby's journey!")
            .assertIsDisplayed()
    }
    
    @Test
    @Config(qualifiers = "ro")
    fun `ready message is displayed in Romanian when showReadyMessage is true`() {
        // Given: Home screen with showReadyMessage = true and Romanian locale
        composeTestRule.setContent {
            BebuTheme {
                HomeScreenContent(
                    showReadyMessage = true,
                    onGetStartedClick = {}
                )
            }
        }
        
        // Then: Romanian ready message should be visible
        composeTestRule
            .onNodeWithText("Gata să urmărești călătoria bebelușului tău!")
            .assertIsDisplayed()
    }
    
    @Test
    fun `home screen renders in dark theme without errors`() {
        // Given: Home screen in dark theme
        composeTestRule.setContent {
            BebuTheme(darkTheme = true) {
                HomeScreenContent(
                    showReadyMessage = true,
                    onGetStartedClick = {}
                )
            }
        }
        
        // Then: Screen should render without crashing
        composeTestRule.waitForIdle()
        assertTrue(true)
    }
}
