package com.xzq.composestudy.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun launchedEffect() {

    var state by remember { mutableStateOf(1) }
    var resp by remember { mutableStateOf("Hello") }

    LaunchedEffect(key1 = state, block = {
        delay(500L)
        resp = "state:$state 执行在${Thread.currentThread().name}"
    })

    Column {
        Text(text = resp)
        Button(
            onClick = {
                ++state
            },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Click")
        }
    }
}