package com.example.composetest.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.composetest.data.*
import com.example.composetest.ui.theme.Black
import com.example.composetest.ui.theme.LightBlack

@Composable
fun HomeScreen(composableList: List<@Composable () -> Unit>) {

    Surface(color = Black) {
        LazyColumn(Modifier.fillMaxHeight(0.92f))
        {
            items(count = composableList.size) {
                composableList.forEach {
                    it.invoke()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun NavBarPrev() {
    HomeScreen(composableList = listOf {
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