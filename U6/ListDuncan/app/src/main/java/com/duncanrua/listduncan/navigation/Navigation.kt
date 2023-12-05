package com.duncanrua.listduncan.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.duncanrua.listduncan.viewmodel.AnimeViewModel
import com.duncanrua.listduncan.ui.screen.AnimeInfo
import com.duncanrua.listduncan.ui.screen.MainScreen

@Composable
fun Navigation(animeViewModel: AnimeViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MainScreen.route ){
        composable(Routes.MainScreen.route){
            MainScreen(navController,animeViewModel)
        }
        composable(Routes.AnimeInfo.route){
            AnimeInfo(navController,animeViewModel)
        }
    }
}