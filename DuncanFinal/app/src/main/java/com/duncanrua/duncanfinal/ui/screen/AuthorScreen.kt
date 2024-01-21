package com.duncanrua.duncanfinal.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.viewModel.UserNameViewModel
import kotlinx.coroutines.delay
import com.duncanrua.duncanfinal.R
import androidx.compose.ui.text.font.FontWeight
import com.example.compose.md_theme_light_inversePrimary

@Composable
fun AuthorScreen(
    navController: NavController,
){
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = visible) {
        delay(1000)
        visible = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(color = md_theme_light_inversePrimary),
        contentAlignment = Alignment.Center
    ) {
        val alpha by animateFloatAsState(
            targetValue = if (visible) 1f else 0f,
            animationSpec = tween(durationMillis = 1000), label = ""
        )

        Image(
            painter = painterResource(id = R.drawable.duncan),
            contentDescription = stringResource(id = R.string.logo),
            modifier = Modifier
                .size(200.dp, 200.dp)
                .graphicsLayer(
                    alpha = alpha
                ),
        )

        Text(
            text = stringResource(id = R.string.application_author),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .graphicsLayer(
                    alpha = alpha
                )
                .offset(y = 120.dp)
        )
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("main_screen")
        },
            modifier = Modifier
                .graphicsLayer(alpha = alpha)
                .offset(y = 180.dp))
        {
            Text(text = stringResource(id = R.string.return_))
        }
    }
}