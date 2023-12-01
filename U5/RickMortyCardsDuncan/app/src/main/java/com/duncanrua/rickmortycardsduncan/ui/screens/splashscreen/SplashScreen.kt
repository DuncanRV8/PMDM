package com.duncanrua.rickmortycardsduncan.ui.screens.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.duncanrua.rickmortycardsduncan.R
import com.duncanrua.rickmortycardsduncan.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1 = true){
        delay(3000)
        navController.popBackStack() // Evitar volver a la Splash Screen
        navController.navigate(Routes.OnboardingOne.route)
    }
    Splash()
}

@Composable
fun Splash(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.duncantrue), contentDescription = stringResource(id = R.string.photo_duncan))
        Text(text = stringResource(id = R.string.photo_name))
    }
}