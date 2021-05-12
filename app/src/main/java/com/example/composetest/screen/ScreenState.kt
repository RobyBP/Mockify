package com.example.composetest.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenState(val route: String, val label: String, val icon: ImageVector) {
    object Home : ScreenState("home", "Home", Icons.Filled.Home)
    object Search : ScreenState("search", "Search", Icons.Filled.Search)
    object Library : ScreenState("library", "Library", Icons.Filled.Star)
}
