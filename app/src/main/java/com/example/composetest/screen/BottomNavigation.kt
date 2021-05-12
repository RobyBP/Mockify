package com.example.composetest.screen

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.example.composetest.data.*
import com.example.composetest.ui.theme.ComposeTestTheme
import com.example.composetest.ui.theme.LightBlack
import com.example.composetest.ui.theme.LightGray

@Composable
fun BottomNavigationLayout() {
    ComposeTestTheme {
        val navController = rememberNavController()
        Surface(color = LightBlack) {
            Scaffold(bottomBar = {
                val items = listOf(ScreenState.Home, ScreenState.Search, ScreenState.Library)
                BottomNavigation(modifier = Modifier.wrapContentHeight()) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                    items.forEach {
                        BottomNavigationItem(icon = {
                            Icon(
                                modifier = Modifier
                                    .size(30.dp),
                                imageVector = it.icon,
                                contentDescription = ""
                            )
                        },
                            selected = currentRoute == it.route,
                            label = { Text(text = it.label, color = LightGray) },
                            onClick = {
                                navController.popBackStack(
                                    navController.graph.startDestination, false
                                )
                                if (currentRoute != it.route) {
                                    navController.navigate(it.route)
                                }
                            }
                        )
                    }
                }

            }) {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(listOf {
                            HorizontalArtistList(
                                artistList = recintlyPlayed,
                                title = "Recently played"
                            )
                            DailyMixList(title = "Made for you")
                            HorizontalArtistList(
                                artistList = bestOfArtists,
                                title = "Best of artists"
                            )
                            HorizontalArtistList(moreOfWhatYouLike, title = "More of what you like")
                            HorizontalArtistList(jumpBackIn, title = "Jump back in")
                            HorizontalArtistList(
                                basedOnYourSelections,
                                title = "Based on your selections"
                            )
                        })
                    }
                    composable("library") {
                        LibraryScreen()
                    }
                    composable("search") {
                        SearchScreen()
                    }
                }
            }
        }
    }
}