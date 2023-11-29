@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.duncanrua.rickmortycardsduncan.ui.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.duncanrua.rickmortycardsduncan.navigation.Routes

@Composable
fun Four(navController: NavController){
    var name by rememberSaveable { mutableStateOf("") }
    val checkname = Regex("^[a-zA-Z]{3,}+\$")
    Column() {
        Button(onClick = {
            navController.popBackStack()
            navController.navigate(route = Routes.OnboardingOne.route)
        }) {
            Text(text = "Volver")
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        TextField(value = name, onValueChange = {name = it}, label = { Text(text = "Pon el nombre")}, placeholder = { Text(
            text = "Ejemplo: Duncan")})

        Button(onClick = {
            navController.navigate(route = Routes.MainScreen.route)
        }, enabled = checkname.matches(name)) {
            Text(text = "Ir a la principal")
        }
    }
}