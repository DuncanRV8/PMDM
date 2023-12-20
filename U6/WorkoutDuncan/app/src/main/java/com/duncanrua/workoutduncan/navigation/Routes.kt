/**
 *
 * Programa para entrenar en casa con 8 ejercicios y las repeticiones que quieras
 *
 * @author: Duncan Rua Valiente
 * @version: 1.5.6
 *
 */
package com.duncanrua.workoutduncan.navigation

sealed class Routes(val route: String) {
    object MainScreen: Routes("main_screen")
    object ExerciseScreen: Routes("exercise_screen")
}