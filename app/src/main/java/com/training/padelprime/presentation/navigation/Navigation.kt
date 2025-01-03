package com.training.padelprime.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.training.padelprime.presentation.screen.ActivitiesScreen
import com.training.padelprime.presentation.screen.AddScreen
import com.training.padelprime.presentation.screen.CommunityScreen
import com.training.padelprime.presentation.screen.management.ManagementScreen
import com.training.padelprime.presentation.screen.ProfileScreen


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.ManagementScreen.route) {

        composable(route = Screen.CommunityScreen.route) {
            CommunityScreen(navController = navController)
        }

        composable(route = Screen.ActivitiesScreen.route) {
            ActivitiesScreen(navController = navController)
        }

        composable(route = Screen.AddScreen.route) {
            AddScreen(navController = navController)
        }

        composable(route = Screen.ManagementScreen.route) {
            ManagementScreen(navController = navController)
        }

        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
    }
}
