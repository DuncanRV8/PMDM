/**
 *
 * Aplicacion para navegar por diferentes pantallas.
 *
 * @author: Duncan Rua Valiente
 * @version: 1.5.4
 *
 */

package com.duncanrua.rickmortycardsduncan.navigation
/*
Creamos las rutas que vamos a utilizar para navegar por las pantallas.
 */
sealed class Routes(val route: String) {
    object SplashScreen: Routes("splash_screen")
    object MainScreen: Routes("main_screen")
    object OnboardingOne:  Routes("onboarding_one")
    object OnboardingTwo: Routes("onboarding_two")
    object OnboardingThree: Routes("onboarding_three")
    object OnboardingFour: Routes("onboarding_four")
    object SecondScreen: Routes("SecondScreen")
}