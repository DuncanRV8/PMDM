package com.duncanrua.duncanfinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.duncanrua.duncanfinal.splashScreen.SplashScreen
import com.duncanrua.duncanfinal.viewModel.mainViewModels.MainViewModels
import com.duncanrua.duncanfinal.ui.screen.AddScreen
import com.duncanrua.duncanfinal.ui.screen.AnimeInfoScreen
import com.duncanrua.duncanfinal.ui.screen.AuthorScreen
import com.duncanrua.duncanfinal.ui.screen.EditScreen
import com.duncanrua.duncanfinal.ui.screen.MainScreen
import com.duncanrua.duncanfinal.ui.screen.onboarding.MainOnboarding

@Composable
fun Navigation(mainViewModels: MainViewModels){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route){
        composable(Routes.MainScreen.route){
            MainScreen( navController, mainViewModels)
        }
        composable(Routes.MainOnboarding.route){
            MainOnboarding( navController, mainViewModels)
        }
        composable(Routes.AddScreen.route){
            AddScreen(navController, mainViewModels )
        }
        composable(Routes.SplashScreen.route){
            SplashScreen(navController, mainViewModels)
        }
        composable(Routes.AuthorScreen.route){
            AuthorScreen(navController)
        }
        composable(Routes.AnimeInfoScreen.route){
            AnimeInfoScreen(navController,mainViewModels)
        }
        composable(Routes.EditScreen.route){
            EditScreen(navController,mainViewModels)
        }
    }
}