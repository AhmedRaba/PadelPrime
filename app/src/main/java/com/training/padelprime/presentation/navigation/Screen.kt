package com.training.padelprime.presentation.navigation

sealed class Screen(val route: String) {

    object CommunityScreen : Screen("community_screen")
    object ActivitiesScreen : Screen("activities_screen")
    object AddScreen : Screen("add_screen")
    object ManagementScreen : Screen("management_screen")
    object ProfileScreen : Screen("profile_screen")


}