package com.xzq.composestudy.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun AnimatedVisibilitySample() {
    var editable by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "AnimatedVisibility",
            style = MaterialTheme.typography.h6
        )

        AnimatedVisibility(visible = editable) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan)
                    .height(200.dp)
//                    .wrapContentHeight(Alignment.CenterVertically)
//                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "蔚来汽车",
                    color = Color.Magenta,
                    fontSize = 20.sp, modifier = Modifier.align(Alignment.TopStart)
                )
                Text(
                    text = "理想汽车",
                    color = Color.Green,
                    fontSize = 20.sp, modifier = Modifier.align(Alignment.TopCenter)
                )
                Text(
                    text = "理想汽车",
                    color = Color.Red,
                    fontSize = 20.sp, modifier = Modifier.align(Alignment.TopEnd)
                )
                Text(
                    text = "理想汽车",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Text(
                    text = "理想汽车",
                    color = Color.Yellow,
                    fontSize = 20.sp, modifier = Modifier.align(Alignment.Center)
                )
                Text(
                    text = "理想汽车",
                    color = Color.DarkGray,
                    fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterEnd)
                )

                Text(
                    text = "理想汽车",
                    color = Color.Blue,
                    fontSize = 20.sp, modifier = Modifier.align(Alignment.BottomStart)
                )
                Text(
                    text = "理想汽车",
                    color = Color.Magenta,
                    fontSize = 20.sp, modifier = Modifier.align(Alignment.BottomCenter)
                )
                Text(
                    text = "理想汽车",
                    color = Color.Gray,
                    fontSize = 20.sp, modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
        }
        Button(
            onClick = { editable = !editable },
            modifier = Modifier.fillMaxWidth(),
            content = { Text(text = "Toggle") }
        )
    }
}