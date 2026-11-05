package com.example.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class ReaderThemeMode {
    LIGHT,
    SEPIA,
    NIGHT
}

private val LightColorScheme = lightColorScheme(
    primary = EmeraldPrimary,
    onPrimary = Color.White,
    primaryContainer = EmeraldContainer,
    onPrimaryContainer = OnEmeraldContainer,
    secondary = GoldDark,
    onSecondary = Color.White,
    secondaryContainer = GoldLight,
    onSecondaryContainer = Color(0xFF332000),
    background = LightBg,
    onBackground = LightTextPrimary,
    surface = LightSurface,
    onSurface = LightTextPrimary,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightTextSecondary,
    outline = LightBorder
)

private val SepiaColorScheme = lightColorScheme(
    primary = Color(0xFF6B4E23),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFEBD8B8),
    onPrimaryContainer = Color(0xFF281804),
    secondary = SepiaGold,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFF3E7CA),
    onSecondaryContainer = Color(0xFF302008),
    background = SepiaBg,
    onBackground = SepiaTextPrimary,
    surface = SepiaSurface,
    onSurface = SepiaTextPrimary,
    surfaceVariant = SepiaSurfaceVariant,
    onSurfaceVariant = SepiaTextSecondary,
    outline = SepiaBorder
)

private val NightColorScheme = darkColorScheme(
    primary = NightGold,
    onPrimary = NightBg,
    primaryContainer = EmeraldPrimaryDark,
    onPrimaryContainer = GoldLight,
    secondary = EmeraldSecondary,
    onSecondary = Color.White,
    secondaryContainer = NightSurfaceVariant,
    onSecondaryContainer = NightTextPrimary,
    background = NightBg,
    onBackground = NightTextPrimary,
    surface = NightSurface,
    onSurface = NightTextPrimary,
    surfaceVariant = NightSurfaceVariant,
    onSurfaceVariant = NightTextSecondary,
    outline = NightBorder
)

@Composable
fun ArRaheeqTheme(
    themeMode: ReaderThemeMode = ReaderThemeMode.LIGHT,
    content: @Composable () -> Unit
) {
    val colorScheme: ColorScheme = when (themeMode) {
        ReaderThemeMode.LIGHT -> LightColorScheme
        ReaderThemeMode.SEPIA -> SepiaColorScheme
        ReaderThemeMode.NIGHT -> NightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
