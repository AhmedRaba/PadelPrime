package com.training.padelprime.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.training.padelprime.ui.theme.PadelPrimeTheme

@Composable
fun ManagementScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {


}


@PreviewLightDark
@Composable
private fun ManagementScreenPreview() {
    PadelPrimeTheme {
        ManagementScreen(navController = rememberNavController())
    }

}