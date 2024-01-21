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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.R
import com.duncanrua.duncanfinal.entities.AnimeEntity
import com.duncanrua.duncanfinal.navigation.Routes
import com.duncanrua.duncanfinal.viewModel.mainViewModels.MainViewModels
import com.example.compose.md_theme_light_inversePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    navController: NavController,
    mainViewModels: MainViewModels
){
    val selectAnime by mainViewModels.animeViewModel.selectedAnime.observeAsState()

    var nameChanged by rememberSaveable { mutableStateOf("") }
    var authorChanged by rememberSaveable { mutableStateOf("") }
    var genreChanged by rememberSaveable { mutableStateOf("") }
    var infoChanged by rememberSaveable { mutableStateOf("") }

    selectAnime?.let { anime ->
        Column (
            Modifier
                .background(color = md_theme_light_inversePrimary)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = stringResource(id = R.string.change_info_anime), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(40.dp))
            TextField(
                value = nameChanged,
                onValueChange = { nameChanged  = (it) },
                label = { Text(text = stringResource(id = R.string.name)) },
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = authorChanged,
                onValueChange = { authorChanged = (it) },
                label = { Text(text = stringResource(id = R.string.author)) },
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = genreChanged,
                onValueChange = { genreChanged = (it) },
                label = { Text(text = stringResource(id = R.string.genre)) },
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = infoChanged,
                onValueChange = { infoChanged = (it) },
                label = { Text(text = stringResource(id = R.string.info)) },
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {
                mainViewModels.animeViewModel.updateAnime(
                    AnimeEntity(
                        id = anime.id,
                        name = nameChanged,
                        author = authorChanged,
                        genre = genreChanged,
                        info = infoChanged
                    )
                )
                navController.navigate(Routes.MainScreen.route)
            }) {
                Text(text = stringResource(id = R.string.change_dades))
            }
        }
    }
}