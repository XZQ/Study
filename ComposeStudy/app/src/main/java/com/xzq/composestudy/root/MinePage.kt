package com.xzq.composestudy.root

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.xzq.composestudy.view.WellnessScreen

@Composable
fun rootMinePage(innerPadding: PaddingValues) {
//    val statusBarHeight = LocalDensity.current.run {
//        WindowInsets.statusBars.getTop(this).toDp()
//    }
    Surface(
        color = MaterialTheme.colors.background
    ) {
        WellnessScreen(modifier = Modifier.padding(innerPadding))
    }
}
