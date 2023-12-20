/**
 *
 * Programa para entrenar en casa con 8 ejercicios y las repeticiones que quieras
 *
 * @author: Duncan Rua Valiente
 * @version: 1.5.6
 *
 */
package com.duncanrua.workoutduncan.ui.screen


import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.duncanrua.workoutduncan.R
import com.duncanrua.workoutduncan.viewmodel.ExerciseViewModel


/**
 * Para sacar los ejercicios por pantalla y el nombre del usuario.
 *
 * @param username
 * @param repetitions
 * @param currentExercise
 * @param isExercising
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseScreen(
    navController: NavController,
    exerciseViewModel: ExerciseViewModel
){
    val userName by exerciseViewModel.userName.observeAsState("")
    val repetitions by exerciseViewModel.repetitions.observeAsState(0)
    val currentExercise by exerciseViewModel.currentExercise.observeAsState(0)
    val isExercising by exerciseViewModel.isExercising.observeAsState(false)

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(10.dp),
                title = {
                    Box(
                        modifier = Modifier
                            .padding(end = 20.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                text = "Usuario: $userName",
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                            exerciseViewModel.stopExercise()
                            exerciseViewModel.updateUserName("")
                            exerciseViewModel.updatedRepetitions(0)
                        }
                    ) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            Modifier.size(15.dp),
                        )
                    }
                },
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ExerciseGif(exerciseImage = currentExercise)
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Repeticiones: $repetitions",
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        if (!isExercising) {
                            exerciseViewModel.startExercise()
                        }
                    },
                    enabled = !isExercising
                ) {
                    Text(
                        text = if (isExercising) "Estas haciendo ejercicio" else "Empezar ejercicio"
                    )
                }
            }
        },
    )
}

/**
 * Para colocar los gifts
 *
 * @param exerciseImage
 */
@Composable
fun ExerciseGif(exerciseImage: Int) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest
                .Builder(context)
                .data(data = exerciseImage)
                .build(),
            imageLoader = imageLoader
        ),
        contentDescription = "Ejercicio",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(350.dp)
    )
}