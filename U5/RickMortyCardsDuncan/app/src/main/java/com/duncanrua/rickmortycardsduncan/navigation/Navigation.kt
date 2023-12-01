package com.duncanrua.rickmortycardsduncan.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.duncanrua.rickmortycardsduncan.ui.screens.MainScreen
import com.duncanrua.rickmortycardsduncan.ui.screens.SecondScreen
import com.duncanrua.rickmortycardsduncan.ui.screens.onboarding.Four
import com.duncanrua.rickmortycardsduncan.ui.screens.onboarding.One
import com.duncanrua.rickmortycardsduncan.ui.screens.onboarding.Three
import com.duncanrua.rickmortycardsduncan.ui.screens.onboarding.Two
import com.duncanrua.rickmortycardsduncan.ui.screens.splashscreen.SplashScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController ,
        startDestination = Routes.SplashScreen.route
    ){
        //definir el main
        composable(
            route = Routes.MainScreen.route
        ){
            MainScreen(navController)
        }
        //Splash
        composable(
            route = Routes.SplashScreen.route
        ){
            SplashScreen(navController)
        }
        //onboarding uno
        composable(
            route = Routes.OnboardingOne.route
        ){
            One(navController)
        }
        //onboarding two
        composable(
            route = Routes.OnboardingTwo.route
        ){
            Two(navController)
        }
        //onboarding three
        composable(
            route = Routes.OnboardingThree.route
        ){
            Three(navController)
        }
        //onboarding four
        composable(
            route = Routes.OnboardingFour.route
        ){
            Four(navController)
        }
        composable(
            route = Routes.SecondScreen.route
        ){
            SecondScreen(navController)
        }
    }
}