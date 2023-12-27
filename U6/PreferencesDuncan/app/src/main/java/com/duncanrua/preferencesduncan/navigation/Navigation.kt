package com.duncanrua.preferencesduncan.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.duncanrua.preferencesduncan.viewModel.PreferencesViewModel
import androidx.navigation.compose.rememberNavController
import com.duncanrua.preferencesduncan.ui.oboarding.MainOnboarding
import com.duncanrua.preferencesduncan.splashScreen.SplashScreen
import com.duncanrua.preferencesduncan.ui.screen.MainScreen

@Composable
fun Navigation(preferencesViewModel: PreferencesViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route){
        composable(Routes.MainScreen.route){
            MainScreen( navController, preferencesViewModel)
        }
        composable(Routes.MainOnboarding.route){
            MainOnboarding( navController, preferencesViewModel)
        }
        composable(Routes.SplashScreen.route){
            SplashScreen(navController, preferencesViewModel)
        }
    }
}