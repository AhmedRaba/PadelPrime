package com.training.padelprime.presentation.navigation

import androidx.annotation.DrawableRes
import com.training.padelprime.R

sealed class BottomNavItem(
    val route: String,
    val label: String,
    @DrawableRes val icon: Int
){
    object CommunityScreen:BottomNavItem("community_screen","Community", R.drawable.ic_community)
    object ActivitiesScreen:BottomNavItem("activities_screen","Activities",R.drawable.ic_activities)
    object AddScreen:BottomNavItem("add_screen","",R.drawable.ic_add)
    object ManagementScreen:BottomNavItem("management_screen","Management",R.drawable.ic_management)
    object ProfileScreen:BottomNavItem("profile_screen","Profile",R.drawable.ic_profile)
}