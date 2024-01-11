package com.duncanrua.duncanfinal.navigation

sealed class Routes (val route: String){
    object MainScreen: Routes("main_screen")
    object MainOnboarding: Routes("main_onboarding")
    object AddScreen: Routes("add_screen")
    object SplashScreen: Routes("splash_screen")
    object AuthorScreen: Routes("author_screen")
}