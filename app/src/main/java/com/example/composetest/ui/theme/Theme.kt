package com.example.composetest.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val FakeSpotifyColorPalette = darkColors(
    primary = Black,
    primaryVariant = LightBlack,
    secondary = Gray,
    secondaryVariant = LightBlack,
    background = Black,
    surface = Black,
    onPrimary = LightGray,
    onBackground = Black,
    onSurface = Black
)

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */


@Composable
fun ComposeTestTheme(
    content: @Composable() () -> Unit
) {
    val colors = FakeSpotifyColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}