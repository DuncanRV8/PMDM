package com.duncanrua.workoutduncan.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duncanrua.workoutduncan.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    exerciseViewModel: ExerciseViewModel
){
    var user by rememberSaveable { mutableStateOf("") }
    var repetitions by rememberSaveable { mutableStateOf(3) }
   Column(
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier
           .padding(15.dp)
   ) {
        Text(
            text = "ANIMO TITAN, ESOS PECTORALES NO SE VAN A PONER FUERTES SOLOS",
            //Animo titan, esos pectorales no se van a poner fuertes solos
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
       Spacer(modifier = Modifier.height(10.dp))
       TextField(
           label = { Text(text = "Nombre de usuario") },
           value = user,
           onValueChange = { user = it},
           modifier = Modifier
               .fillMaxWidth()
               .padding(8.dp)
       )
       Spacer(modifier = Modifier.height(10.dp))
       Column (
           horizontalAlignment = Alignment.CenterHorizontally
       ){
           Text(text = "Elige cuantas repeticiones quieres hacer",
                fontSize = 18.sp)
           Spacer(modifier = Modifier.height(10.dp))
           Text(
               text = repetitions.toString(),
               fontSize = 35.sp)
           Spacer(modifier = Modifier.width(10.dp))
           Slider(value = repetitions.toFloat(),
                  onValueChange = { repetitions = it.toInt()},
                  valueRange = 3f .. 20f,
                  steps = 19,
                  thumb = {
                      Icon(
                          imageVector = Icons.Default.LocationOn,
                          contentDescription = null
                      )
                  }
           )
           Spacer(modifier = Modifier.height(20.dp))
           Button(onClick = {

           }) {
               Text(text = "Siguiente ventana")
           }
       }
   }
}