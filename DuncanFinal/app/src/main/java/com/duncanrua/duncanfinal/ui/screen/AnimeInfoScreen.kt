/**
 * Es una aplicación donde pones los animes con la información.
 *
 * @author: Duncan Rua Valiente
 * @version: 7.2.1
 */
package com.duncanrua.duncanfinal.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.R
import com.duncanrua.duncanfinal.navigation.Routes
import com.duncanrua.duncanfinal.viewModel.mainViewModels.MainViewModels
import com.example.compose.md_theme_light_inversePrimary
import com.example.compose.md_theme_light_onBackground

/**
 * Donde saldrá la información del anime seleccionado
 *
 * @param navController
 * @param mainViewModels
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeInfoScreen(
    navController: NavController,
    mainViewModels: MainViewModels
) {
    val selectAnime by mainViewModels.animeViewModel.selectedAnime.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.anime_information)) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    selectAnime?.let { anime ->
                        Row {
                            IconButton(
                                onClick = {
                                    mainViewModels.animeViewModel.deleteAnime(anime)
                                    navController.navigateUp()
                                },
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = stringResource(id = R.string.delete),
                                    tint = Color.Black
                                )
                            }
                            IconButton(
                                onClick = {
                                    navController.navigate(Routes.EditScreen.route)
                                },
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = stringResource(id = R.string.edit),
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                }
            )
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize()
                .fillMaxWidth()
                .background(color = md_theme_light_inversePrimary),

        ) {
            selectAnime?.let { anime ->
                Spacer(modifier = Modifier.height(50.dp))

                Text(text = "Nombre: ${anime.name}",Modifier.padding(12.dp))
                Divider(color = md_theme_light_onBackground)
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Autor: ${anime.author}",Modifier.padding(12.dp))
                Divider(color = md_theme_light_onBackground)
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Genero del anime: ${anime.genre}",Modifier.padding(12.dp))
                Divider(color = md_theme_light_onBackground)
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Información:",Modifier.padding(12.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = anime.info,Modifier.padding(12.dp))
            }
        }
    }
}