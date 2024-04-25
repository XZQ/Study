package com.xzq.composestudy.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import com.xzq.composestudy.R

object NaviGraph {
    const val HOME_ROUTE = "home"
    const val INTERESTS_ROUTE = "interests"
    const val ARTICLE_ROUTE = "post"
    const val ARTICLE_ID_KEY = "postId"
}

sealed class Destinations(val route: String) {
    object HomeDistinations : Destinations("home")
    object Discoveristinations : Destinations("discover")
    object FriendDistinations : Destinations("friend")
    object MineDistinations : Destinations("mine")
}


val items = listOf(
        Screen.Home, Screen.Discover, Screen.Friend, Screen.Mine
)

sealed class Screen(
        val route: String,
        @StringRes val resId: Int = 0,
        val iconSelect: ImageVector,
        val iconUnselect: Int = 0,
        var isShowText: Boolean = true
) {
    object Home : Screen(
            route = Destinations.HomeDistinations.route,
            resId = R.string.screen_home,
            iconSelect = Icons.Default.Home,
    )

    object Discover : Screen(
            route = Destinations.Discoveristinations.route,
            resId = R.string.screen_discover,
            iconSelect = Icons.Default.AccountCircle,
    )

    object Friend : Screen(
            route = Destinations.FriendDistinations.route,
            resId = R.string.screen_friend,
            iconSelect = Icons.Default.AccountBox,
    )

    object Mine : Screen(
            route = Destinations.MineDistinations.route,
            resId = R.string.screen_mine,
            iconSelect = Icons.Filled.Menu,
    )
}

