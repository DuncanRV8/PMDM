package com.duncanrua.preferencesduncan.navigation

sealed class Routes(val route: String) {
    object MainScreen: Routes("main_screen")
    object MainOnboarding: Routes("main_onboarding")
    object SplashScreen: Routes("splash_screen")
}