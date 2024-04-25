package com.xzq.composestudy

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.xzq.composestudy.drawer.AppDrawer
import com.xzq.composestudy.main.iconList
import com.xzq.composestudy.main.navList
import com.xzq.composestudy.navigation.NaviGraph
import com.xzq.composestudy.root.rootMinePage
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePage() {
    val context = LocalContext.current
    var selectIndex by rememberSaveable { mutableIntStateOf(0) }
    var visible by remember { mutableStateOf(true) }
    val pageState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    // This top level scaffold contains the app drawer, which needs to be accessible
    // from multiple screens. An event to open the drawer is passed down to each
    // screen that needs it.
    val scaffoldState = rememberScaffoldState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: NaviGraph.HOME_ROUTE

    Log.e("TAG", "----    currentRoute=$currentRoute")

    /*  val systemUiController = rememberSystemUiController().apply {
  //        setSystemBarsColor(
  //            color = Color(0xffEDEDED),
  //            darkIcons = false,
  //        )
          setStatusBarColor(Color.Transparent, darkIcons = MaterialTheme.colors.isLight)
      }*/

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            if (selectIndex != 0) {
                CenterAlignedTopAppBar(title = {
                    Text(
                        navList[selectIndex], maxLines = 1, fontSize = 22.sp, overflow = TextOverflow.Ellipsis
                    )
                }, actions = { getCenterAlignedTopAppBarActions(context, selectIndex) },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = getDefaultColor(context, selectIndex),
                        scrolledContainerColor = getDefaultColor(context, selectIndex),
                        navigationIconContentColor = Color.White,
                        titleContentColor = getBlack10(context),
                        actionIconContentColor = getBlack10(context),
                    )
                )
            }
        },
        drawerContent = {
            AppDrawer(currentRoute = currentRoute,
                navigateHome = { navController.navigate(NaviGraph.HOME_ROUTE) },
                navigateToInterests = { navController.navigate(NaviGraph.INTERESTS_ROUTE) },
                closeDrawer = { coroutineScope.launch { scaffoldState.drawerState.close() } })
        },
        bottomBar = {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                BottomAppBar(
                    backgroundColor = Color(0xffEDEDED),
                    contentColor = Color(ContextCompat.getColor(context, if (selectIndex > 1) R.color.black else R.color.nav_bg)),
                ) {
                    navList.forEachIndexed { index, str ->
                        Box(contentAlignment = Alignment.Center, modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable {
                                selectIndex = index
                                coroutineScope.launch {
                                    pageState.scrollToPage(index)
                                }
                            }) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom
                            ) {
                                Icon(
                                    imageVector = iconList[index], contentDescription = null, tint = getTintColor(context, index, selectIndex)
                                )
                                Text(
                                    text = str, fontSize = 12.sp, color = getTintColor(context, index, selectIndex)
                                )
                            }
                        }
                    }
                }
            }
        },
    ) { innerPadding ->
        Box {
            HorizontalPager(
                count = 4, state = pageState, modifier = Modifier.fillMaxSize(), userScrollEnabled = visible
            ) { page ->

                val openDrawer: () -> Unit = { coroutineScope.launch { scaffoldState.drawerState.open() } }

                when (page) {
                    0 -> rootMainPage(innerPadding, onChangeVisible = { v ->
                        visible = !v
//                        systemUiController.setSystemBarsColor(
//                            color = if (visible) Color(0xffEDEDED) else Color(0xff1B1B2B),
//                            darkIcons = true,
//                        )
                    }, openDrawer = openDrawer)

                    1 -> rootDiscoverPage(innerPadding)
                    2 -> rootFriendPage(innerPadding)
                    3 -> rootMinePage(innerPadding)
                }
            }
            LaunchedEffect(pageState) {
                snapshotFlow { pageState.currentPage }.collect { page ->
                    selectIndex = page
                    visible = true
//                    systemUiController.setSystemBarsColor(
//                        color = if (page != 3) Color(0xffEDEDED) else Color.White,
//                        darkIcons = true,
//                    )
                }
            }
        }
    }
}

@Composable
private fun getCenterAlignedTopAppBarActions(context: Context, selectIndex: Int) {
    if (selectIndex != 3) {
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.Search, contentDescription = null, modifier = Modifier.size(30.dp), tint = getBlack10(context)
            )
        }
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.Close, contentDescription = null, modifier = Modifier.size(25.dp), tint = getBlack10(context)
            )
        }
    }
}

private fun getTintColor(context: Context, index: Int, selectIndex: Int) = Color(
    if (selectIndex == index) {
        ContextCompat.getColor(context, R.color.green)
    } else {
        ContextCompat.getColor(context, R.color.gray)
    }
)

private fun getDefaultColor(context: Context, selectIndex: Int) = Color(
    ContextCompat.getColor(
        context, if (selectIndex != 3) R.color.nav_bg else R.color.white
    )
)

private fun getBlack10(context: Context) = Color(
    ContextCompat.getColor(
        context, R.color.black_10
    )
)

/* navList.forEachIndexed { index, str ->
                             BottomNavigationItem(
                                 label = { Text(str) },
                                 selected = index == selectIndex,
                                 onClick = { selectIndex = index },
                                 icon = { Icon(imageVector = iconList[index], contentDescription = null) },
                                 selectedContentColor = colorResource(id = R.color.green),
                                 unselectedContentColor = colorResource(id = R.color.nav_bg)
                             )
 }*/
