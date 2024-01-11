package com.duncanrua.duncanfinal.ui.screen.detailMainScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon

@Composable
fun FloatingActionButton(
    navController: NavController
){
    FloatingActionButton(onClick = {
        navController.popBackStack()
        navController.navigate("add_screen")
    }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Añadir")
    }
}