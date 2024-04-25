package com.xzq.composestudy

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.primarySurface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter.State.Empty.painter
import com.xzq.composestudy.main.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun rootMainPage(
    innerPadding: PaddingValues,
    viewModel: MainViewModel = MainViewModel(),
    onChangeVisible: (Boolean) -> Unit,
    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val context = LocalContext.current

    /*** 获取状态栏高度 */
//    val statusBarHeight = LocalDensity.current.run {
//        WindowInsets.statusBars.getTop(this).toDp()
//    }
    val scrollState = rememberLazyListState()

    var offset by remember { mutableFloatStateOf(0f) }

    val fullHeight = with(LocalContext.current) {
        resources.displayMetrics.heightPixels
    }
    val density = LocalDensity.current.density

//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        autoIncrement(modifier = Modifier)
//    }

    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.app_name)
            InsetAwareTopAppBar(
                title = { Text(text = title) },
                navigationIcon = {
                    IconButton(onClick = { coroutineScope.launch { openDrawer() } }) {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = stringResource(R.string.app_name)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        autoIncrement(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun InsetAwareTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = 4.dp
) {
    LocalDensity.current.run {
        WindowInsets.statusBars.getTop(this).toDp()
    }
    Surface(
        color = backgroundColor,
        elevation = elevation,
        modifier = modifier
    ) {
        TopAppBar(
            title = title,
            navigationIcon = navigationIcon,
            actions = actions,
            backgroundColor = Color.Transparent,
            contentColor = contentColor,
            elevation = 0.dp,
            modifier = Modifier.statusBarsPadding()
        )
    }
}

@Composable
private fun autoIncrement(modifier: Modifier) {
    val count = remember { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${count.value}", modifier = Modifier)
        Button(
            onClick = { count.value++ },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .background(Color.Transparent),
            border = BorderStroke(2.dp, Color.White),//边框颜色
//            BorderStroke(
//                10.dp,
//                Brush.radialGradient(listOf(Color.White, Color.Black))
//            )
            enabled = true,
//            shape = CutCornerShape(30),
//            contentPadding = PaddingValues(100.dp)
        ) {
            Text(text = "Add")
        }
    }
}

