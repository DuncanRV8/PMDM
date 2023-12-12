package com.duncanrua.workoutduncan.navigation

sealed class Routes(val route: String) {
    object MainScreen: Routes("main_screen")
    object ExerciseScreen: Routes("exercise_screen")
}