/**
 * Es una aplicación donde pones los animes con la información.
 *
 * @author: Duncan Rua Valiente
 * @version: 7.2.1
 */
package com.duncanrua.duncanfinal.splashScreen

import android.os.Build
import android.os.Build.VERSION.SDK_INT
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.duncanrua.duncanfinal.R
import com.duncanrua.duncanfinal.navigation.Routes
import com.duncanrua.duncanfinal.viewModel.mainViewModels.MainViewModels
import com.example.compose.md_theme_light_inversePrimary

import kotlinx.coroutines.delay

/**
 * Depende de si carga el nombre del usuario irá a una pantalla o otra. Un tiempo de carga de 3 segundos al inciarse la aplicación
 *
 * @param navController
 * @param mainViewModels
 */
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

/**
 * Para poner la animación de la imagen
 *
 */
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
        GifImage()
    }
}

/**
 * Para poner un gift
 *
 * @param modifier
 */
@Composable
fun GifImage(
    modifier: Modifier = Modifier,
) {
    var visible by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = visible) {
        delay(2000)
        visible = false
    }

    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    val scale by animateFloatAsState(
        targetValue = if (visible) 1.5f else 1f,
        animationSpec = tween(durationMillis = 1000), label = ""
    )
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = R.drawable.cargando).apply(block = {

            }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp, 200.dp)
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .offset(y = 120.dp)
    )
}