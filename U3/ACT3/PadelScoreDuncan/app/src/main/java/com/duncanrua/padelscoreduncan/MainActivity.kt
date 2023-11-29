package com.duncanrua.padelscoreduncan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duncanrua.padelscoreduncan.ui.theme.PadelScoreDuncanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

@Composable
fun Content(){
    //puntos del equipo A
    var actualySetPointsA by rememberSaveable { mutableStateOf(0) }
    var gamePointsA by rememberSaveable { mutableStateOf(0) }
    var setPointsA by rememberSaveable { mutableStateOf(0) }
    var tieBreakA by rememberSaveable { mutableStateOf(0) }

    //puntos del equipo B
    var actualySetPointsB by rememberSaveable { mutableStateOf(0) }
    var gamePointsB by rememberSaveable { mutableStateOf(0) }
    var setPointsB by rememberSaveable { mutableStateOf(0) }
    var tieBreakB by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        //Sets
        Text(
            modifier = Modifier
                .background(color = colorResource(id = R.color.blue))
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.sets),
            fontSize = dimensionResource(id = R.dimen.titulos).value.sp,
        )
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Spacer(modifier = Modifier.width(75.dp))
            Text(
                text = "$setPointsA",
                fontSize = dimensionResource(id = R.dimen.contadoresCero).value.sp
            )
            Spacer(modifier = Modifier.width(145.dp))
            Text(
                text = "$setPointsB",
                fontSize = dimensionResource(id = R.dimen.contadoresCero).value.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        //Tie-Break
        Text(
            modifier = Modifier
                .background(color = colorResource(id = R.color.blue))
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.tie_break),
            fontSize = dimensionResource(id = R.dimen.titulos).value.sp
            )
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Spacer(modifier = Modifier.width(75.dp))
            Text(
                text = "$tieBreakA",
                fontSize = dimensionResource(id = R.dimen.contadoresCero).value.sp
            )
            Spacer(modifier = Modifier.width(145.dp))
            Text(
                text = "$tieBreakB",
                fontSize = dimensionResource(id = R.dimen.contadoresCero).value.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .background(color = colorResource(id = R.color.blue))
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.games),
            fontSize = dimensionResource(id = R.dimen.titulos).value.sp
        )
        //marcador de los juegos
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Spacer(modifier = Modifier.width(75.dp))
            //puntos de juego para el equipo A
            Text(
                text = "$gamePointsA",
                fontSize = dimensionResource(id = R.dimen.contadoresCero).value.sp
            )
            if (gamePointsA >= 6){
                var resultMinusGames = gamePointsA - gamePointsB
                if (resultMinusGames >=2){
                    gamePointsA = 0
                    gamePointsB = 0
                    setPointsA++
                }
            }
            Spacer(modifier = Modifier.width(145.dp))
            //puntos de juego para el equipo B
            Text(
                text = "$gamePointsB",
                fontSize = dimensionResource(id = R.dimen.contadoresCero).value.sp
            )
            if (gamePointsB >= 6){
                var resultMinusGames =  gamePointsB - gamePointsA
                if (resultMinusGames >= 2){
                    gamePointsA = 0
                    gamePointsB = 0
                    setPointsB++
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.actualySet),
            fontSize = dimensionResource(id = R.dimen.titulos).value.sp,
            modifier = Modifier
                .background(color = colorResource(id = R.color.blue))
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        //marcador de los puntos actuales 15,30,45
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            if (setPointsA < 2 && setPointsB < 2){
                //Redimensionar los puntos y cambiar el texto del equipo A dependiendo del contador
                if (actualySetPointsA == 0){
                    Spacer(modifier = Modifier.width(75.dp))
                    Text(
                        text = stringResource(id = R.string.cero),
                        fontSize = dimensionResource(id = R.dimen.contadoresCero).value.sp
                    )
                }
                else if(actualySetPointsA == 1){
                    Spacer(modifier = Modifier.width(60.dp))
                    Text(
                        text = stringResource(id = R.string.fifteen),
                        fontSize = dimensionResource(id = R.dimen.number_contador).value.sp
                    )
                }
                else if(actualySetPointsA == 2){
                    Spacer(modifier = Modifier.width(60.dp))
                    Text(
                        text = stringResource(id = R.string.thirty),
                        fontSize = dimensionResource(id = R.dimen.number_contador).value.sp
                    )
                }
                else if(actualySetPointsA == 3){
                    Spacer(modifier = Modifier.width(60.dp))
                    Text(
                        text = stringResource(id = R.string.forty),
                        fontSize = dimensionResource(id = R.dimen.number_contador).value.sp
                    )
                }
                else if (actualySetPointsA == 4){
                    actualySetPointsA = 0
                    actualySetPointsB = 0
                    gamePointsA++
                }
            }
            //sets equipo B
            if (setPointsB < 2 && setPointsA < 2){
                //redimensionar los puntos y cambiar el texto del equipo B dependiendo de el contador
                if (actualySetPointsB == 0 ){
                    Spacer(modifier = Modifier.width(140.dp))
                    Text(
                        text = stringResource(id = R.string.cero),
                        fontSize = dimensionResource(id = R.dimen.contadoresCero).value.sp
                    )
                }
                else if(actualySetPointsB == 1){
                    Spacer(modifier = Modifier.width(120.dp))
                    Text(
                        text = stringResource(id = R.string.fifteen),
                        fontSize = dimensionResource(id = R.dimen.number_contador).value.sp
                    )
                }
                else if(actualySetPointsB == 2){
                    Spacer(modifier = Modifier.width(120.dp))
                    Text(
                        text = stringResource(id = R.string.thirty),
                        fontSize = dimensionResource(id = R.dimen.number_contador).value.sp
                    )
                }
                else if(actualySetPointsB == 3){
                    Spacer(modifier = Modifier.width(120.dp))
                    Text(
                        text = stringResource(id = R.string.forty),
                        fontSize = dimensionResource(id = R.dimen.number_contador).value.sp
                    )
                }
                else if(actualySetPointsB == 4){
                    actualySetPointsA = 0
                    actualySetPointsB = 0
                    gamePointsB++
                }
            }else{
                setPointsB
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        //botones para sumar puntos a los equipos
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Spacer(modifier = Modifier.width(35.dp))
            Button(
                onClick = {
                    //si los juegos estan en 6 los dos hacemos el tie-break
                    if (gamePointsA == 6 && gamePointsB == 6) {
                        tieBreakA++
                        //si llega el equipo A a 6 comprobara que tenga ventaja de dos o mas para sumarle el set
                        if (tieBreakA >= 6){
                            var resutlTieBreak = tieBreakA - tieBreakB
                            if (resutlTieBreak >= 2){
                                setPointsA++
                                gamePointsA = 0
                                gamePointsB = 0
                                tieBreakA = 0
                                tieBreakB = 0
                            }
                        }
                    }else{
                        actualySetPointsA++
                    }
                }
            ) {
                Text(
                    text = stringResource(id = R.string.plush_point),
                    fontSize = dimensionResource(id = R.dimen.plush_point).value.sp
                )
            }
            Spacer(modifier = Modifier.width(55.dp))
            Button(
                onClick = {
                       //si los dos equipos estan en 6 en el juego
                       if (gamePointsB == 6 && gamePointsA == 6) {
                           tieBreakB++
                           //si llega el equipo A a 6 comprobara que tenga ventaja de dos o ma para sumarle el set
                           if (tieBreakB >= 6){
                               var resutlTieBreak = tieBreakB - tieBreakA
                               if (resutlTieBreak >= 2){
                                   setPointsB++
                                   gamePointsA = 0
                                   gamePointsB = 0
                                   tieBreakA = 0
                                   tieBreakB = 0
                               }
                           }
                       }else{
                           actualySetPointsB++
                       }
                }
            ) {
                Text(
                    text = stringResource(id = R.string.plush_point),
                    fontSize = dimensionResource(id = R.dimen.plush_point).value.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = {
                actualySetPointsA = 0
                actualySetPointsB = 0
                gamePointsA = 0
                gamePointsB = 0
                setPointsA = 0
                setPointsB = 0
        }) {
            Text(
                text = stringResource(id = R.string.reset),
                fontSize = dimensionResource(id = R.dimen.titulos).value.sp
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    PadelScoreDuncanTheme {
        Content()
    }
}