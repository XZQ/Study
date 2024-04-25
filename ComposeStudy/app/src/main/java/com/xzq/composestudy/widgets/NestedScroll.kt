package com.xzq.composestudy.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// https://blog.csdn.net/qq_31339141/article/details/130536857
@Composable
fun nestScroll() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            // 固定头部
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(150.dp)
//                    .background(Color.Green)
//            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .background(Color.Green)
            ) {
                items(20) {
                    Text(
                        text = "第一部分${it}",
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp), fontSize = 24.sp, textAlign = TextAlign.Center
                    )
                }
            }
        }
        items(120) {
            Text(
                text = "第2部分$it", modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), textAlign = TextAlign.Start
            )
        }
    }
}