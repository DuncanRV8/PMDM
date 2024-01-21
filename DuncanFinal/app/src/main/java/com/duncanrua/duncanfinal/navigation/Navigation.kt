/**
 * Es una aplicación donde pones los animes con la información.
 *
 * @author: Duncan Rua Valiente
 * @version: 7.2.1
 */
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

/**
 * Para poder navegar entre pantallas
 *
 * @param mainViewModels
 */
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