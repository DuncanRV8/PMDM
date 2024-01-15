package com.duncanrua.duncanfinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.duncanrua.duncanfinal.splashScreen.SplashScreen
import com.duncanrua.duncanfinal.ui.screen.AddScreen
import com.duncanrua.duncanfinal.ui.screen.AuthorScreen
import com.duncanrua.duncanfinal.ui.screen.MainScreen
import com.duncanrua.duncanfinal.ui.screen.onboarding.MainOnboarding
import com.duncanrua.duncanfinal.viewModel.UserNameViewModel

@Composable
fun Navigation(userNameViewModel: UserNameViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route){
        composable(Routes.MainScreen.route){
            MainScreen( navController, userNameViewModel)
        }
        composable(Routes.MainOnboarding.route){
            MainOnboarding( navController, userNameViewModel)
        }
        composable(Routes.AddScreen.route){
            AddScreen(navController, userNameViewModel )
        }
        composable(Routes.SplashScreen.route){
            SplashScreen(navController, userNameViewModel)
        }
        composable(Routes.AuthorScreen.route){
            AuthorScreen(navController, userNameViewModel)
        }
    }
}