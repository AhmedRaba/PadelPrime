package com.training.padelprime.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.training.padelprime.ui.theme.PadelPrimeTheme


@Composable
fun ActivitiesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {

    Box(
        modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Activities Screen")
    }

}


@PreviewLightDark
@Composable
private fun ManagementScreenPreview() {
    PadelPrimeTheme {
        ActivitiesScreen(navController = rememberNavController())
    }

}