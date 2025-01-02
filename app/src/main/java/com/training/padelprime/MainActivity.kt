package com.training.padelprime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.training.padelprime.presentation.navigation.BottomBar
import com.training.padelprime.presentation.navigation.Navigation
import com.training.padelprime.ui.theme.PadelPrimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PadelPrimeTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomBar(
                            navController = navController
                        )
                    }
                ) { innerPadding ->
                    Image(
                        painter = painterResource(id = R.drawable.iv_background),
                        contentDescription = "app background",
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .padding(innerPadding)
                    ) {

                        Navigation(navController = navController)

                    }
                }
            }
        }
    }
}
