package com.duncanrua.preferencesduncan.splashScreen

import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.duncanrua.preferencesduncan.R
import com.duncanrua.preferencesduncan.navigation.Routes
import com.duncanrua.preferencesduncan.ui.screen.loadData
import com.duncanrua.preferencesduncan.viewModel.PreferencesViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, preferencesViewModel: PreferencesViewModel) {
    loadData(preferencesViewModel)
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack() // Evitar volver a la Splash Screen

        val userName = preferencesViewModel.userName.value.orEmpty()
        if(userName.length > 1){
            navController.navigate(Routes.MainScreen.route)
        }else{
            navController.navigate(Routes.MainOnboarding.route)
        }
    }

    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id= R.drawable.duncan),
            contentDescription = "logo",
            modifier = Modifier.size(200.dp, 200.dp)
        )
        Text(
            "Duncan Rua Valiente",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}