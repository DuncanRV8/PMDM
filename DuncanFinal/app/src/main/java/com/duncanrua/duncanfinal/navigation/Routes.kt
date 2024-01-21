/**
 * Es una aplicación donde pones los animes con la información.
 *
 * @author: Duncan Rua Valiente
 * @version: 7.2.1
 */
package com.duncanrua.duncanfinal.navigation

/**
 * Sirve para acceder a las rutas con un nombre.
 *
 * @property route
 */
sealed class Routes (val route: String){
    object MainScreen: Routes("main_screen")
    object MainOnboarding: Routes("main_onboarding")
    object AddScreen: Routes("add_screen")
    object SplashScreen: Routes("splash_screen")
    object AuthorScreen: Routes("author_screen")
    object AnimeInfoScreen: Routes("anime_info_screen")
    object EditScreen: Routes("edit_screen")
}