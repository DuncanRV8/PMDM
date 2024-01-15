package com.duncanrua.duncanfinal.splashScreen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.R
import com.duncanrua.duncanfinal.navigation.Routes
import com.duncanrua.duncanfinal.viewModel.AnimeViewModel
import com.duncanrua.duncanfinal.viewModel.UserNameViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, userNameViewModel: UserNameViewModel, animeViewModel: AnimeViewModel){
    userNameViewModel.loadName()
    LaunchedEffect(key1 = true) {
        delay(3000)
        animeViewModel.getAllAnimes()
        navController.popBackStack()
        val userName = userNameViewModel.userName.value.orEmpty()
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
    var visible by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = visible) {
        delay(2000)
        visible = false
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val scale by animateFloatAsState(
            targetValue = if (visible) 1.5f else 1f,
            animationSpec = tween(durationMillis = 1000), label = ""
        )
        Image(
            painter = painterResource(id = R.drawable.duncan),
            contentDescription = "stringResource(id = R.string.logo)",
            modifier = Modifier
                .size(200.dp, 200.dp)
                .graphicsLayer(scaleX = scale, scaleY = scale),
        )
        Text(
            text = "Duncan Rua Valiente",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .graphicsLayer(scaleX = scale, scaleY = scale)
                .offset(y = 120.dp)
        )
    }
}