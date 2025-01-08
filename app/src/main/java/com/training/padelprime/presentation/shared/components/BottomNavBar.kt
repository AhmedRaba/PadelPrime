package com.training.padelprime.presentation.shared.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.training.padelprime.R
import com.training.padelprime.presentation.navigation.BottomNavItem
import com.training.padelprime.presentation.navigation.Screen
import com.training.padelprime.ui.theme.PadelPrimeTheme
import com.training.padelprime.ui.theme.gray
import com.training.padelprime.ui.theme.orange

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val items = listOf(
        BottomNavItem.CommunityScreen,
        BottomNavItem.ActivitiesScreen,
        BottomNavItem.ManagementScreen,
        BottomNavItem.ProfileScreen,
    )

    val selectedColor = orange
    val unselectedColor = gray

    val currentRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.iv_bottom_nav),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-12).dp)
                .shadow(elevation = 8.dp, shape = CircleShape, spotColor = Color(0xFFF6B027))
                .size(56.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFFF6B027), Color(0xFFB27600))
                    ),
                    shape = CircleShape
                )
                .clickable {
                    if (currentRoute != Screen.AddScreen.route) {
                        navController.navigate(Screen.AddScreen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
                .zIndex(1f),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(28.dp),
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = Color.White
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            NavigationBar(
                containerColor = Color.Transparent, modifier = Modifier.weight(1f)
            ) {


                items.take(2).forEach { item ->

                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = null,
                                tint = if (currentRoute == item.route) selectedColor else unselectedColor,
                                modifier = Modifier
                                    .size(22.dp)
                                    .background(Color.Transparent)
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = selectedColor,
                            unselectedIconColor = unselectedColor,
                            selectedTextColor = selectedColor,
                            unselectedTextColor = unselectedColor,
                            indicatorColor = Color.Transparent,
                        ),
                        label = {
                            Text(
                                text = item.label,
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Light,
                                maxLines = 1,
                                color = if (currentRoute == item.route) selectedColor else unselectedColor,
                                modifier = Modifier.offset(y = (-6).dp)

                            )
                        },
                        modifier = Modifier
                            .weight(1f)
                            .clickable(interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                enabled = false,
                                onClick = {})
                            .background(Color.Transparent)
                            .offset(y = 14.dp),
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
                    )


                }

                Spacer(modifier = Modifier.width(72.dp))

                items.takeLast(2).forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        icon = {
                            when (item.route) {
                                "profile_screen" -> {
                                    Icon(
                                        painter = painterResource(id = item.icon),
                                        contentDescription = null,
                                        tint = Color.Unspecified,
                                        modifier = Modifier.size(27.dp)

                                    )
                                }

                                else -> {
                                    Icon(
                                        painter = painterResource(id = item.icon),
                                        contentDescription = null,
                                        tint = if (currentRoute == item.route) selectedColor else unselectedColor,
                                        modifier = Modifier
                                            .size(22.dp)
                                            .background(Color.Transparent)
                                    )
                                }
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = selectedColor,
                            unselectedIconColor = unselectedColor,
                            selectedTextColor = selectedColor,
                            unselectedTextColor = unselectedColor,
                            indicatorColor = Color.Transparent,
                        ),
                        label = {
                            Text(
                                text = item.label,
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Light,
                                maxLines = 1,
                                color = if (currentRoute == item.route) selectedColor else unselectedColor,
                                modifier = Modifier.offset(y = (-6).dp)

                            )
                        },
                        modifier = Modifier
                            .weight(1f)
                            .clickable(interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                enabled = false,
                                onClick = {})
                            .background(Color.Transparent)
                            .offset(y = 14.dp),
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
                    )

                }

            }

        }

    }

}


@Preview
@Composable
private fun Preview() {
    PadelPrimeTheme {
        BottomNavBar(navController = rememberNavController())
    }
}