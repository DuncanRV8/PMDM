/**
 *
 * Programa para entrenar en casa con 8 ejercicios y las repeticiones que quieras
 *
 * @author: Duncan Rua Valiente
 * @version: 1.5.6
 *
 */

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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duncanrua.workoutduncan.viewmodel.ExerciseViewModel

/**
 * Poner las repeticiones y el nombre del usuario y si hay un usuario poder pasar a la siguiente pantalla.
 *
 * @param userName
 * @param repetitions
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    exerciseViewModel: ExerciseViewModel
){
    val userName: String by exerciseViewModel.userName.observeAsState(initial = "")
    var repetitions by rememberSaveable { mutableStateOf(exerciseViewModel.repetitions.value ?: 3)}
   Column(
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier
           .padding(15.dp)
   ) {
        Text(
            text = "ANIMO TITAN, ESOS PECTORALES NO SE VAN A PONER FUERTES SOLOS",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
       Spacer(modifier = Modifier.height(10.dp))
       TextField(
           label = { Text(text = "Nombre de usuario") },
           value = userName,
           onValueChange = { userName -> exerciseViewModel.updateUserName(userName)},
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
                  onValueChange = { newRepetitions -> repetitions = newRepetitions.toInt()
                      exerciseViewModel.updatedRepetitions(repetitions)},
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
                if (userName.length >= 3){
                    navController.navigate("exercise_screen")
                }
           },
               enabled = userName.length >= 3) {
               Text(text = "Siguiente ventana")
           }
       }
   }
}