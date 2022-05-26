package com.onirutla.metal_gear_character_compose.ui.screens

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home")
    object DetailScreen : Screen("detail")
}
