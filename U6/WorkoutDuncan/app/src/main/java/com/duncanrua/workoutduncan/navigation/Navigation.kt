package com.duncanrua.workoutduncan.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.duncanrua.workoutduncan.ui.screen.ExerciseScreen
import com.duncanrua.workoutduncan.ui.screen.MainScreen
import com.duncanrua.workoutduncan.viewmodel.ExerciseViewModel

@Composable
fun Navigation(exerciseViewModel: ExerciseViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MainScreen.route){
        composable(Routes.MainScreen.route){
            MainScreen(navController, exerciseViewModel)
        }
        composable(Routes.ExerciseScreen.route){
            ExerciseScreen(navController, exerciseViewModel)
        }
    }
}