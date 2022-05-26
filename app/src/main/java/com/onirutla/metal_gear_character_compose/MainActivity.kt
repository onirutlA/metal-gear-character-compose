@file:OptIn(ExperimentalAnimationApi::class)

package com.onirutla.metal_gear_character_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.onirutla.metal_gear_character_compose.ui.SharedViewModel
import com.onirutla.metal_gear_character_compose.ui.screens.DetailScreen
import com.onirutla.metal_gear_character_compose.ui.screens.HomeScreen
import com.onirutla.metal_gear_character_compose.ui.screens.Screen
import com.onirutla.metal_gear_character_compose.ui.theme.MetalGearCharacterComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MetalGearComposeApp {
                val navController = rememberAnimatedNavController()
                Content(navController)
            }
        }
    }
}

@Composable
fun MetalGearComposeApp(content: @Composable () -> Unit) {
    MetalGearCharacterComposeTheme {
        content()
    }
}

@Composable
fun Content(navHostController: NavHostController = rememberNavController()) {
    Navigation(navHostController)
}

@Composable
fun Navigation(navHostController: NavHostController) {
    val sharedViewModel: SharedViewModel = viewModel()
    AnimatedNavHost(navController = navHostController, startDestination = Screen.HomeScreen.route) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(navHostController, sharedViewModel = sharedViewModel)
        }
        composable(
            route = Screen.DetailScreen.route,
            enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Left) },
            exitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right) },
        ) {
            it.arguments
            DetailScreen(
                sharedViewModel.character,
                onIconButtonClick = { navHostController.navigateUp() }
            )
        }
    }
}