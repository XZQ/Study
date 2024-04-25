@file:OptIn(ExperimentalAnimationApi::class)

package com.xzq.composestudy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.xzq.composestudy.cupcake.ui.StartOrderPreview
import com.xzq.composestudy.navigation.NavHostApp
import com.xzq.composestudy.navigation.Screen
import com.xzq.composestudy.navigation.items
import com.xzq.composestudy.rally.Overview
import com.xzq.composestudy.rally.RallyDestination
import com.xzq.composestudy.rally.rallyTabRowScreens
import com.xzq.composestudy.rally.ui.components.RallyTabRow
import com.xzq.composestudy.rally.ui.theme.RallyTheme
import com.xzq.composestudy.root.rootMinePage
import com.xzq.composestudy.ui.theme.ComposeStudyTheme

/**
 * https://juejin.cn/post/7271056651128832058?utm_source=gold_browser_extension
 * https://blog.csdn.net/qq_39312146/article/details/130664017
 * https://juejin.cn/post/7321558573518782490?utm_source=gold_browser_extension
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            rootCompose()
        }
    }
}

@Composable
fun ComposeHomeUI() {
    ProvideWindowInsets {
        ComposeStudyTheme {
            HomePage()
        }
    }
}

@Composable
fun ComposeCupcakeThemeUI() {
    ProvideWindowInsets {
        StartOrderPreview()
    }
}

@Composable
fun RallyApp() {
    ProvideWindowInsets {
        RallyTheme {
            var currentScreen: RallyDestination by remember { mutableStateOf(Overview) }
            Scaffold(topBar = {
                RallyTabRow(allScreens = rallyTabRowScreens, onTabSelected = { screen -> currentScreen = screen }, currentScreen = currentScreen)
            }) { innerPadding ->
                Box(Modifier.padding(innerPadding)) {
                    currentScreen.screen()
                }
            }
        }
    }
}

// https://juejin.cn/post/7330453329644273727?utm_source=gold_browser_extension
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun rootCompose() {
    val systemUiController = rememberSystemUiController()
    val navController = rememberNavController()
//    systemUiController.setSystemBarsColor(
//        color = Color(0xffEDEDED),
//        darkIcons = true,
//    )
    systemUiController.setStatusBarColor(Color.Transparent, darkIcons = MaterialTheme.colors.isLight)


    ProvideWindowInsets {
        Scaffold(
                topBar = { },
                drawerContent = { },
                bottomBar = { BottomBar(navController) })
        { innerPadding ->
            NavHost(
                    navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)
            ) {
                composable(Screen.Home.route) {
                    rootMainPage(innerPadding, onChangeVisible = {}, openDrawer = {})
                }
                composable(Screen.Discover.route) {
                    rootDiscoverPage(innerPadding)
                }
                composable(Screen.Friend.route) {
                    rootFriendPage(innerPadding)
                }
                composable(Screen.Mine.route) {
                    rootMinePage(innerPadding)
                }
            }
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController, modifier: Modifier = Modifier) {
    BottomAppBar {
        BottomNavigation {
            //获取当前的 NavBackStackEntry 来访问当前的 NavDestination
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            items.forEach { screen ->
                BottomNavigationItem(
                        label = { Text(stringResource(id = screen.resId)) },
                        icon = { Icon(imageVector = screen.iconSelect, contentDescription = null) },
                        selectedContentColor = colorResource(id = R.color.white),
                        unselectedContentColor = colorResource(id = R.color.gray_10),
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            //https://developer.android.google.cn/jetpack/compose/navigation?hl=ur
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
//                                popUpTo(navController.graph.findStartDestination().id) {
//                                    saveState = true
//                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
                )
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        Greeting("Android")
    }
}