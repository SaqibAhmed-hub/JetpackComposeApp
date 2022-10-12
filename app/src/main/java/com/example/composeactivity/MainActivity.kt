package com.example.composeactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.composeactivity.nav.*
import com.example.composeactivity.ui.theme.ComposeActivityTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ComposeActivityTheme {
                Scaffold {
                    NavigationComponent(navController)
                }

            }
        }
    }

    @ExperimentalCoilApi
    @Composable
    private fun NavigationComponent(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) { Greeting(navController) }
            composable(Screen.Details.route) { DetailsScreen(navController) }
            composable(Screen.MainFeed.route) { MainFeed() }
            composable(Screen.Design.route){ DesignTab()}
        }
    }

}