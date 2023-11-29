/**
 *
 * Aplicacion que sumara, restara o reseteara dependiendo de que botón uses. También saca las estadísticas
 *
 * @author Duncan Rua Valiente
 * @version 1.1.2
 * 
 */

package com.duncanrua.statisticsduncan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duncanrua.statisticsduncan.ui.theme.StatisticsDuncanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatisticsDuncanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content()
                }
            }
        }
    }
}

/**
 * Sumar,restar y resetar los timers ademas de sacar las estadisticas.
 *
 */
@Composable
fun Content() {
    //Crear variables
    var totaltimes: Int by rememberSaveable { mutableStateOf(0) }
    var timesPerson: Int by rememberSaveable { mutableStateOf(0) }
    var timesScooter: Int by rememberSaveable { mutableStateOf(0) }
    var timesBikes: Int by rememberSaveable { mutableStateOf(0) }
    var timesCar: Int by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Text(
            text = "Estadísticas Duncan",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(

        ){
            //Crear botones para resetear el timer de cada uno.
            Button(
                onClick = {
                    totaltimes -= timesPerson
                    timesPerson = 0

                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFF1DE35)
                )
            ){
                Text(
                    text = "RESET",
                    fontSize = 10.sp
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    totaltimes -= timesScooter
                    timesScooter = 0
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFF1DE35)
                )
            ){
                Text(
                    text = "RESET",
                    fontSize = 10.sp
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    totaltimes -= timesBikes
                    timesBikes = 0
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFF1DE35)
                )
            ){
                Text(
                    text = "RESET",
                    fontSize = 10.sp
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    totaltimes -= timesCar
                    timesCar= 0
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFF1DE35)
                )
            ){
                Text(
                    text = "RESET",
                    fontSize = 10.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        //Crear botones para restar en el timer
        Row(

        ){
            Button(
                onClick = {
                    if (timesPerson >0){
                        timesPerson--
                        totaltimes--
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFBB2020)
                )
            ){
                Text(
                    text = "-1",
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(
                onClick = {
                    if (timesScooter > 0){
                        timesScooter--
                        totaltimes--
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFBB2020)
                )
            ){
                Text(
                    text = "-1",
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(
                onClick = {
                    if (timesBikes > 0){
                        timesBikes--
                        totaltimes--
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFBB2020)
                )
            ){
                Text(
                    text = "-1",
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(
                onClick = {
                    if (timesCar > 0){
                        timesCar--
                        totaltimes--
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFBB2020)
                )
            ){
                Text(
                    text = "-1",
                    fontSize = 15.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        //Crear botones para sumar en el timer
        Row(

        ){
            Button(
                onClick = {
                    timesPerson++
                    totaltimes++
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5EB33B)
                )
            ){
                Text(
                    text = "+1",
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(
                onClick = {
                    timesScooter++
                    totaltimes++
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5EB33B)
                )
            ){
                Text(
                    text = "+1",
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(
                onClick = {
                    timesBikes++
                    totaltimes++
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5EB33B)
                )
            ){
                Text(
                    text = "+1",
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(
                onClick = {
                    timesCar++
                    totaltimes++
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5EB33B)
                )
            ){
                Text(
                    text = "+1",
                    fontSize = 15.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        //Insertar los textos que quiero en una fila con su timer
        Row(

        ) {
            Text(
                text = "Personas: $timesPerson",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "Patinetes: $timesScooter",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "Bicicletas: $timesBikes",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Coches: $timesCar",
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row (

        ){
            Text(
                text = "Total: $totaltimes",
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(40.dp))
            //Resetear los timers a 0
            Button(
                onClick = {
                    totaltimes = 0
                    timesBikes = 0
                    timesPerson = 0
                    timesCar = 0
                    timesScooter = 0

                }
            ){
                Text(
                    text = "REINICIAR TODOS",
                    fontSize = 10.sp
                )

            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Estadísticas"
        )
        Spacer(modifier = Modifier.height(15.dp))
        //Calculo de las estadisticas
        if (totaltimes > 0){
            Text(
                text = """|Personas: ${String.format("%.2f",(timesPerson.toDouble()/totaltimes)*100)}%
                          |Patinetes: ${String.format("%.2f",(timesScooter.toDouble()/totaltimes) * 100)}%
                          |Bicicletas: ${String.format("%.2f",(timesBikes.toDouble()/totaltimes) * 100)}%
                          |Coches: ${String.format("%.2f",(timesCar.toDouble()/totaltimes) * 100)}%""".trimMargin()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Content()
    }
}