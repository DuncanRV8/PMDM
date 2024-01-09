package com.duncanrua.duncanfinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.duncanrua.duncanfinal.splashScreen.SplashScreen
import com.duncanrua.duncanfinal.ui.screen.AddScreen
import com.duncanrua.duncanfinal.ui.screen.MainScreen
import com.duncanrua.duncanfinal.ui.screen.onboarding.MainOnboarding
import com.duncanrua.duncanfinal.viewModel.AnimeViewModel

@Composable
fun Navigation(animeViewModel: AnimeViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MainScreen.route){
        composable(Routes.MainScreen.route){
            MainScreen( navController, animeViewModel)
        }
        composable(Routes.MainOnboarding.route){
            MainOnboarding( navController, animeViewModel)
        }
        composable(Routes.AddScreen.route){
            AddScreen(navController, animeViewModel )
        }
        composable(Routes.SplashScreen.route){
            SplashScreen(navController, animeViewModel)
        }
    }

}