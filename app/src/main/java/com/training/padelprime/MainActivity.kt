package com.training.padelprime

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.training.padelprime.presentation.shared.components.BottomNavBar
import com.training.padelprime.presentation.navigation.Navigation
import com.training.padelprime.ui.theme.PadelPrimeTheme
import com.training.padelprime.ui.theme.blueBlack
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun attachBaseContext(newBase: android.content.Context) {
        super.attachBaseContext(
            updateLocale(newBase)
        )
    }

    private fun updateLocale(context: android.content.Context): android.content.Context {
        val locale = Locale("en", "US")
        val configuration = Configuration(context.resources.configuration)
        configuration.setLocale(locale)
        return context.createConfigurationContext(configuration)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            PadelPrimeTheme {
                val navController = rememberNavController()
                val systemUiController = rememberSystemUiController()

                val isDarkMode = isSystemInDarkTheme()
                val context = LocalContext.current as ComponentActivity


                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->

                    DisposableEffect(isDarkMode) {
                        systemUiController.setSystemBarsColor(
                            color = Color.Transparent,
                            darkIcons = false
                        )
                        systemUiController.setNavigationBarColor(
                            color = blueBlack,
                            darkIcons = false
                        )

                            systemUiController.setStatusBarColor(
                                color = Color.Black,
                                darkIcons = false
                            )



                        onDispose { }
                    }


                    Image(
                        painter = painterResource(id = R.drawable.iv_background),
                        contentDescription = "app background",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {

                        Navigation(navController = navController)

                        BottomNavBar(
                            navController = navController,
                            modifier = Modifier.align(Alignment.BottomCenter)
                        )
                    }
                }
            }
        }
    }
}
