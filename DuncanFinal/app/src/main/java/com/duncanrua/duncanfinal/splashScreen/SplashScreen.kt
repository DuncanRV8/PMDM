package com.duncanrua.duncanfinal.splashScreen

import android.os.Build
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.duncanrua.duncanfinal.R
import com.duncanrua.duncanfinal.navigation.Routes
import com.duncanrua.duncanfinal.viewModel.mainViewModels.MainViewModels
import com.example.compose.md_theme_light_inversePrimary

import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController,mainViewModels: MainViewModels){
    val userNameViewModel = mainViewModels.userNameViewModel
    userNameViewModel.loadName()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = md_theme_light_inversePrimary
    ) {
        LaunchedEffect(key1 = true) {
            delay(3000)
            navController.popBackStack()
            navController.navigate(Routes.MainOnboarding.route)

            val userName = userNameViewModel.userName.value.orEmpty()
            if(userName.length > 1){
                navController.navigate(Routes.MainScreen.route)
            }else{
                navController.navigate(Routes.MainOnboarding.route)
            }
        }
        Splash()
    }
}
//.background(MaterialTheme.colorScheme.onPrimary)
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
            painter = painterResource(id = R.drawable.anime),
            contentDescription = "Logo",
            modifier = Modifier
                .size(200.dp, 200.dp)
                .graphicsLayer(scaleX = scale, scaleY = scale),
        )
    }
}