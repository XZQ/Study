package com.xzq.composestudy

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import com.xzq.composestudy.view.WellnessScreen
import com.xzq.composestudy.widgets.AllButtons
import com.xzq.composestudy.widgets.Chips

@Composable
fun rootDiscoverPage(innerPadding: PaddingValues) {
    val statusBarHeight = LocalDensity.current.run {
        WindowInsets.statusBars.getTop(this).toDp()
    }
    Surface(
        modifier = Modifier.fillMaxSize().padding(top = statusBarHeight),
        color = MaterialTheme.colors.background
    ) {
        WidgetScreenContent()
    }
}

@Composable
fun WidgetScreenContent(modifier: Modifier = Modifier) {
    LazyColumn(
        state = rememberLazyListState(),
        modifier = modifier
    ) {
        item { AllButtons() }
        item { Chips() }
    }
}