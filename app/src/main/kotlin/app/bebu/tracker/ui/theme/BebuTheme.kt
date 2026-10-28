package app.bebu.tracker.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/**
 * Terracotta color palette for light theme.
 * 
 * These are placeholder tokens based on a warm terracotta palette.
 * The designer will provide final color tokens later, which can be
 * easily replaced here in one place.
 */
private val TerracottaLightColorScheme = lightColorScheme(
    primary = Color(0xFFD4704A),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFDBD0),
    onPrimaryContainer = Color(0xFF3A0900),
    
    secondary = Color(0xFF77574E),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFFFDBD0),
    onSecondaryContainer = Color(0xFF2C150F),
    
    tertiary = Color(0xFF6C5D2F),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFF5E1A7),
    onTertiaryContainer = Color(0xFF231B00),
    
    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),
    
    background = Color(0xFFFFF8F6),
    onBackground = Color(0xFF231917),
    surface = Color(0xFFFFF8F6),
    onSurface = Color(0xFF231917),
    surfaceVariant = Color(0xFFF5DED7),
    onSurfaceVariant = Color(0xFF53433F),
    
    outline = Color(0xFF85736E),
    outlineVariant = Color(0xFFD8C2BC),
    scrim = Color(0xFF000000)
)

/**
 * Terracotta color palette for dark theme.
 * 
 * Dark theme variant of the terracotta palette, ensuring proper
 * contrast and readability in dark mode.
 */
private val TerracottaDarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFB59C),
    onPrimary = Color(0xFF5F1600),
    primaryContainer = Color(0xFF7E2E10),
    onPrimaryContainer = Color(0xFFFFDBD0),
    
    secondary = Color(0xFFE7BDB1),
    onSecondary = Color(0xFF442A22),
    secondaryContainer = Color(0xFF5D4037),
    onSecondaryContainer = Color(0xFFFFDBD0),
    
    tertiary = Color(0xFFD8C58D),
    onTertiary = Color(0xFF3A2F05),
    tertiaryContainer = Color(0xFF534619),
    onTertiaryContainer = Color(0xFFF5E1A7),
    
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),
    
    background = Color(0xFF1A110F),
    onBackground = Color(0xFFF1DED9),
    surface = Color(0xFF1A110F),
    onSurface = Color(0xFFF1DED9),
    surfaceVariant = Color(0xFF53433F),
    onSurfaceVariant = Color(0xFFD8C2BC),
    
    outline = Color(0xFFA08D87),
    outlineVariant = Color(0xFF53433F),
    scrim = Color(0xFF000000)
)

/**
 * Main theme composable for the Bebu app.
 * 
 * By default, uses the warm terracotta palette. Material You dynamic colors
 * can be enabled via the [useDynamicColor] parameter (Android 12+).
 * 
 * Note: Dynamic color is OFF by default. Once a settings screen is implemented,
 * this parameter should be tied to a user preference.
 * 
 * @param darkTheme Whether to use dark theme. Defaults to system setting.
 * @param useDynamicColor Whether to use Material You dynamic colors (Android 12+).
 *                        Defaults to false (terracotta palette).
 * @param content The composable content to display with this theme.
 */
@Composable
fun BebuTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    useDynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        useDynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
        darkTheme -> TerracottaDarkColorScheme
        else -> TerracottaLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
