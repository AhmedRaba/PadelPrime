package com.training.padelprime.presentation.navigation

import androidx.annotation.DrawableRes
import com.training.padelprime.R

sealed class BottomNavItem(
    val route: String,
    val label: String,
    @DrawableRes val icon: Int
){
    object CommunityScreen:BottomNavItem(Screen.CommunityScreen.route,"Community", R.drawable.ic_community)
    object ActivitiesScreen:BottomNavItem(Screen.ActivitiesScreen.route,"Activities",R.drawable.ic_activities)
    object AddScreen:BottomNavItem(Screen.AddScreen.route,"",R.drawable.ic_add)
    object ManagementScreen:BottomNavItem(Screen.ManagementScreen.route,"Management",R.drawable.ic_management)
    object ProfileScreen:BottomNavItem(Screen.ProfileScreen.route,"Profile",R.drawable.ic_profile)
}