package com.duncanrua.listduncan.navigation

sealed class Routes(val route: String){
    object MainScreen: Routes("main_screen")
    object AnimeInfo: Routes("anime_info_screen")
}
