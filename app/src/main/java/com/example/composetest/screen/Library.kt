package com.example.composetest.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.composetest.R
import com.example.composetest.ui.theme.LightBlack

@Composable
fun LibraryScreen() {

    Surface(color = Color.Black) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            TopNavigationBar(modifier = Modifier.wrapContentHeight())
            LibraryList(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.92f)
            )

        }
    }

}

@Composable
fun LibraryList(modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(count = 50) {
            ListRow()
            Spacer(Modifier.height(5.dp))
        }
    }
}

@Composable
fun ListRow() {
    Row(
        Modifier
            .clickable { }
            .fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.vanna),
            contentDescription = "Luda Vanchi",
            Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))

        Column() {
            Text(
                text = "Vanna",
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = "Kao Rijeka",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun TopNavigationBar(modifier: Modifier) {
    TopAppBar(backgroundColor = LightBlack, modifier = modifier) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(end = 5.dp)
        ) {
            val (profilePic, text, search, spacerRight) = createRefs()
            Spacer(
                Modifier
                    .width(10.dp)
                    .constrainAs(spacerRight) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(search.end)
                    })
            Image(
                painterResource(id = R.drawable.jake),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(37.dp)
                    .constrainAs(profilePic) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )
            Text(
                text = "Your library",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(5.dp)
                    .constrainAs(text) {
                        start.linkTo(profilePic.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )

            Box(modifier = Modifier
                .clickable { }
                .constrainAs(search) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .clickable { }
                .size(40.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search icon",
                    modifier = Modifier.align(Center)
                )
            }
        }
    }
}

@Preview
@Composable
fun Prew() {
    LibraryScreen()
}