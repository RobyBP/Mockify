package com.example.composetest.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.data.artists
import com.example.composetest.data.jumpBackIn

@Composable
fun BigPictureWithArtists(imageId: Int) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "Artist Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
            )
            Text(
                text = "Names of artis",
                maxLines = 2,
                color = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, top = 3.dp)
            )
        }
    }
}

@Composable
fun HorizontalArtistList(artistList: List<Int>, title: String) {
    Column(Modifier.padding(5.dp)) {
        Text(
            title,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 14.dp)
        )
        LazyRow() {
            items(count = 4) {
                BigPictureWithArtists(artistList[it])
            }
        }
    }
}

@Preview
@Composable
fun ListPrew() {
    HorizontalArtistList(artistList = jumpBackIn, title = "Jump back in")
}