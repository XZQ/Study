package com.xzq.composestudy.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xzq.composestudy.rootDiscoverPage
import com.xzq.composestudy.rootFriendPage
import com.xzq.composestudy.root.rootMinePage
import com.xzq.composestudy.rootMainPage

@Composable
fun NavHostApp(navController: NavController, innerPadding: PaddingValues, startDestination: String = Destinations.HomeDistinations.route) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Destinations.HomeDistinations.route) {
            rootMainPage(innerPadding, onChangeVisible = {}, openDrawer = {})
        }
        composable(Destinations.Discoveristinations.route) {
            rootDiscoverPage(innerPadding)
        }
        composable(Destinations.FriendDistinations.route) {
            rootFriendPage(innerPadding)
        }
        composable(Destinations.MineDistinations.route) {
            rootMinePage(innerPadding)
        }
    }

}