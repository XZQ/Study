package com.xzq.composestudy.widgets

import android.provider.MediaStore
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// https://article.juejin.cn/post/6975041659729870885
// https://juejin.cn/post/7250639505527242789
// https://blog.csdn.net/xiayiye5/article/details/125129352
@Composable
fun showLazyColumn() {
    val list = java.util.ArrayList<String>()
    val state = rememberLazyListState()
    for (i in 0..100) {
        list.add(i.toString())
    }

    val scrollState = rememberScrollState()
    Row(modifier = Modifier.horizontalScroll(scrollState)) {
        MediaStore.Images()
    }

    LazyColumn {
        items(list) { item ->
            Text(text = "$item  ---")
        }
    }
}

