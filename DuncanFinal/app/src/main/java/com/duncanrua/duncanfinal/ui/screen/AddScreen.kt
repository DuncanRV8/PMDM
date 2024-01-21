/**
 * Es una aplicación donde pones los animes con la información.
 *
 * @author: Duncan Rua Valiente
 * @version: 7.2.1
 */
package com.duncanrua.duncanfinal.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.R
import com.duncanrua.duncanfinal.entities.AnimeEntity
import com.duncanrua.duncanfinal.navigation.Routes
import com.duncanrua.duncanfinal.viewModel.mainViewModels.MainViewModels
import com.example.compose.md_theme_light_inversePrimary

/**
 * Esta pantalla sirve para añadir animes
 *
 * @param navController
 * @param mainViewModels
 */
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun AddScreen(
    navController: NavController,
    mainViewModels: MainViewModels,
){
    val animeViewModel = mainViewModels.animeViewModel

    var name by rememberSaveable { mutableStateOf("") }
    var author by rememberSaveable { mutableStateOf("") }
    var genre by rememberSaveable { mutableStateOf("") }
    var info by rememberSaveable { mutableStateOf("") }

    Scaffold(
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .fillMaxWidth()
                .background(color = md_theme_light_inversePrimary)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(id = R.string.tell_me_anime_info))
            Spacer(modifier = Modifier.height(30.dp))
            TextField(
                value = name,
                onValueChange = { name  = (it) },
                label = { Text(text = stringResource(id = R.string.name)) },
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = author,
                onValueChange = { author = (it) },
                label = { Text(text = stringResource(id = R.string.author)) },
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = genre,
                onValueChange = { genre = (it) },
                label = { Text(text = stringResource(id = R.string.genre)) },
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = info,
                onValueChange = { info = (it) },
                label = { Text(text = stringResource(id = R.string.info)) },
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                val newAnime = AnimeEntity(
                    name = name,
                    author = author,
                    genre = genre,
                    info = info
                )
                animeViewModel.addAnime(newAnime)
                navController.navigate(Routes.MainScreen.route)
            }) {
                Text(text = stringResource(id = R.string.add))
            }
        }
        Divider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}