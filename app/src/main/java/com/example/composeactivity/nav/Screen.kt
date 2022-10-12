package com.example.composeactivity.nav

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Details: Screen("details")
    object MainFeed: Screen("main")
    object Design: Screen("design")
}