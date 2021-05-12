package com.example.composetest.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composetest.data.dailyMixes
import com.example.composetest.ui.theme.LightBlack

@Composable
fun DailyMixCard(imageId: Int, position: Int, modifier: Modifier) {
    Surface(
        color = LightBlack, modifier = modifier
            .fillMaxWidth(0.5f)
            .clip(MaterialTheme.shapes.small)
            .padding(end = 7.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .clickable { }
        ) {
            Row() {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = "Daily mix image",
                    modifier = Modifier
                        .size(54.dp)
                        .clip(MaterialTheme.shapes.small)
                )
                Spacer(Modifier.width(5.dp))
                Text(
                    text = "Daily mix ${position + 1}",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun DailyMixRow(firstImage: Int, secondImage: Int, position: Int) {

    ConstraintLayout(Modifier.fillMaxWidth()) {
        val (firstCard, secondCard) = createRefs()
        DailyMixCard(
            imageId = firstImage, position = position, Modifier
                .constrainAs(firstCard) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(secondCard.start)
                }
        )
        Spacer(Modifier.width(2.dp))
        DailyMixCard(imageId = secondImage, position = position + 1, Modifier
            .constrainAs(secondCard) {
                start.linkTo(firstCard.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            })
    }


}

@Composable
fun DailyMixList(title: String) {
    Column(Modifier.padding(5.dp)) {
        Text(title, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(5.dp))
        Column() {
            for (i in 0 until dailyMixes.size - 1 step 2) {
                DailyMixRow(
                    firstImage = dailyMixes[i],
                    secondImage = dailyMixes[i + 1],
                    position = i
                )
                if (i != 4) Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}
