package com.example.composetest.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.composetest.R
import com.example.composetest.ui.theme.Black
import com.example.composetest.ui.theme.Gray
import com.example.composetest.ui.theme.Shapes

@Composable
fun SearchScreen() {
    Surface(color = Black) {
        Column() {
            Title()
            SearchBar()
            NoResultsIcon()
        }
    }
}


@Composable
fun Title() {
    Text(
        text = "Search",
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 5.dp, bottom = 5.dp)
    )
}

@Composable
fun NoResultsIcon() {

    Image(
        painter = painterResource(id = R.drawable.ic_don_t_know_posing),
        contentDescription = "Action not implemented",
        modifier = Modifier
            .focusModifier()
            .fillMaxWidth()
            .fillMaxHeight(0.82f)

    )


}

@Composable
fun SearchBar() {
    val hint = "Artists, songs, or podcasts"
    val text = remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier.padding(10.dp)) {
        Surface(
            color = Color.White, modifier = Modifier
                .fillMaxWidth()
                .clip(Shapes.medium)
        ) {
            TextField(
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                label =
                { Text(text = hint) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        modifier = Modifier.padding(end = 5.dp),
                        contentDescription = ""
                    )
                },
                textStyle = TextStyle(Color.Black, fontSize = 20.sp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Ascii
                )
            )
        }
    }
}
