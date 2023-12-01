package com.duncanrua.rickmortycardsduncan.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.duncanrua.rickmortycardsduncan.R
import com.duncanrua.rickmortycardsduncan.navigation.Routes

@Composable
fun One(navController: NavController){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Image(painter = painterResource(id = R.drawable.rymlogo), contentDescription = stringResource(id = R.string.logo_morty))
        Spacer(modifier = Modifier.height(10.dp))
        Image(painter = painterResource(id = R.drawable.rymportal), contentDescription = stringResource(id = R.string.portal_morty))
        Row (

        ){
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onTertiaryContainer),
                onClick = {
                    navController.popBackStack()
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
                    navController.navigate(route = Routes.OnboardingTwo.route)
                }
            ) {
                Text(
                    text = stringResource(id = R.string.next_page)
                )
            }

        }
    }
}