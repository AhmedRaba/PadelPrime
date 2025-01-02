package com.training.padelprime.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.training.padelprime.ui.theme.PadelPrimeTheme
import com.training.padelprime.ui.theme.blueBlack
import com.training.padelprime.ui.theme.gray
import com.training.padelprime.ui.theme.orange

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val items = listOf(
        BottomNavItem.CommunityScreen,
        BottomNavItem.ActivitiesScreen,
        BottomNavItem.AddScreen,
        BottomNavItem.ManagementScreen,
        BottomNavItem.ProfileScreen,
    )

    val selectedColor = orange
    val unselectedColor = gray

    NavigationBar(
        modifier = modifier
            .background(Color.Transparent)
            .height(100.dp),
        containerColor = blueBlack
    ) {
        val currentRoute =
            navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->

            NavigationBarItem(
                selected = currentRoute == item.route,
                icon = {
                    when (item.route) {
                        "add_screen" -> {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(70.dp)

                            )
                        }

                        "profile_screen" -> {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(24.dp)
                                    .offset(y = 14.dp)

                            )
                        }

                        else -> {
                            // Default behavior for other icons
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = null,
                                tint = if (currentRoute == item.route) selectedColor else unselectedColor,
                                modifier = Modifier
                                    .size(24.dp)
                                    .offset(y = 14.dp)
                            )
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = selectedColor,
                    unselectedIconColor = unselectedColor,
                    selectedTextColor = selectedColor,
                    unselectedTextColor = unselectedColor,
                    indicatorColor = Color.Unspecified
                ),
                label = {
                    Text(
                        text = item.label,
                        fontSize = 8.sp,
                        maxLines = 1,
                        color = if (currentRoute == item.route) selectedColor else unselectedColor,
                        modifier = Modifier.offset(y = 10.dp)
                    )
                },
                alwaysShowLabel = true,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                modifier = Modifier.weight(1f)
            )


        }


    }


}


@PreviewLightDark
@Composable
private fun Preview() {
    PadelPrimeTheme {
        BottomBar(navController = rememberNavController())
    }
}