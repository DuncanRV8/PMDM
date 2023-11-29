package com.duncanrua.rickmortycardsduncan.ui.screens.onboarding

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duncanrua.rickmortycardsduncan.R
import com.duncanrua.rickmortycardsduncan.navigation.Routes

@Composable
fun Two(navController: NavController){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, content ={
            item {
                Text(text = "HAZ TUS ELECCIONES DE PELEA", fontSize = 20.sp)

                Spacer(modifier = Modifier.height(10.dp))
                cards()
                Spacer(modifier = Modifier.height(10.dp))
                Row (

                ){
                    Button(
                        onClick = {
                            navController.navigate(route = Routes.OnboardingFour.route)
                        }
                    ) {
                        Text(
                            text = "Saltar"
                        )
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    Button(
                        onClick ={
                            navController.navigate(route = Routes.OnboardingThree.route)
                        }
                    ) {
                        Text(
                            text = "Siguiente pantalla"
                        )
                    }

                }
            }
        })
    }
}

@Composable
fun card(painter: Int, contentDescription: String, modifier: Modifier){
    Image(painter = painterResource(id = painter), contentDescription = contentDescription, modifier = modifier)
}

@Composable
fun cards(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        card(painter = R.drawable.card1, contentDescription = "Card1", modifier = Modifier.size(400.dp))
        Spacer(modifier = Modifier.height(10.dp))
        card(painter = R.drawable.card2, contentDescription = "Card2",modifier = Modifier.size(400.dp))
        Spacer(modifier = Modifier.height(10.dp))
        card(painter = R.drawable.card3, contentDescription = "Card3",modifier = Modifier.size(400.dp))
    }
}