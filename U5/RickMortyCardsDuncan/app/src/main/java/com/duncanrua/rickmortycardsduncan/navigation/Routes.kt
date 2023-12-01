package com.duncanrua.rickmortycardsduncan.navigation

sealed class Routes(val route: String) {
    object SplashScreen: Routes("splash_screen")
    object MainScreen: Routes("main_screen")
    object OnboardingOne:  Routes("onboarding_one")
    object OnboardingTwo: Routes("onboarding_two")
    object OnboardingThree: Routes("onboarding_three")
    object OnboardingFour: Routes("onboarding_four")
    object SecondScreen: Routes("SecondScreen")
}