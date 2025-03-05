package com.yongjincompany.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorScheme = darkColorScheme(
    primary = Primary400,
    onPrimary = White,
    secondary = Primary500,
    onSecondary = White,
    tertiary = Primary600,
    onTertiary = White,
    error = Red,
    onError = White,
    surface = Background,
    onSurface = Primary400,
    onSurfaceVariant = White,
    background = Background,
    onBackground = White
)

private val LightColorScheme = lightColorScheme(
    primary = Primary400,
    onPrimary = White,
    secondary = Primary500,
    onSecondary = White,
    tertiary = Primary600,
    onTertiary = White,
    error = Red,
    onError = White,
    surface = Background,
    onSurface = Primary400,
    onSurfaceVariant = White,
    background = Background,
    onBackground = White
)

@Composable
fun SowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(
        LocalTypography provides Typography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}

object SowTheme {
    val typography: SowTypography
        @Composable
        get() = LocalTypography.current
}