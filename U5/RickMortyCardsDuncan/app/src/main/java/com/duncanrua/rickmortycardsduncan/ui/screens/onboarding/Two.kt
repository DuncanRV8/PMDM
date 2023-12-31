package com.duncanrua.rickmortycardsduncan.ui.screens.onboarding

import android.widget.Space
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                Text(text = stringResource(id = R.string.select_your_fight), fontSize = 20.sp)

                Spacer(modifier = Modifier.height(10.dp))

                cards()
                Spacer(modifier = Modifier.height(10.dp))
                Row (

                ){
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onTertiaryContainer),
                        onClick = {
                            navController.navigate(route = Routes.OnboardingFour.route)
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.skip)
                        )
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onTertiaryContainer),
                        onClick ={
                            navController.navigate(route = Routes.OnboardingThree.route)
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.next_page)
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
        var isVisible by remember { mutableStateOf(false) }
        AnimatedVisibility(
            visible =isVisible,
            enter = expandHorizontally(),
            exit = shrinkHorizontally()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                card(painter = R.drawable.card1, contentDescription = stringResource(id = R.string.card_one), modifier = Modifier.size(400.dp))
                Spacer(modifier = Modifier.height(40.dp))
                card(painter = R.drawable.card2, contentDescription = stringResource(id = R.string.card_two), modifier = Modifier.size(400.dp))
                Spacer(modifier = Modifier.height(40.dp))
                card(painter = R.drawable.card3, contentDescription = stringResource(id = R.string.card_three), modifier = Modifier.size(400.dp)
                )
            }
        }
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onTertiaryContainer),
            onClick = {
                isVisible = !isVisible
            }
        ) {
            Text(
                text = if (isVisible) "Ocultar Cartas" else "Mostrar Cartas"
            )
        }
    }
}