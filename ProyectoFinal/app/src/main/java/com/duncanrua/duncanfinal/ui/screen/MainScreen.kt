@file:OptIn(ExperimentalMaterial3Api::class)

package com.duncanrua.duncanfinal.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.entities.TaskEntity
import com.duncanrua.duncanfinal.ui.screen.detailMainScreen.TopBar
import com.duncanrua.duncanfinal.ui.screen.detailMainScreen.FloatingActionButton
import com.duncanrua.duncanfinal.viewModel.AnimeViewModel
import com.duncanrua.duncanfinal.viewModel.MainScreenViewModel
import com.duncanrua.duncanfinal.viewModel.UserNameViewModel

@Composable
fun MainScreen(
    navController: NavController,
    userNameViewModel: UserNameViewModel,
    animeViewModel: AnimeViewModel
){
    userNameViewModel.loadName()
    val animeList by animeViewModel.animeList.observeAsState(initial = emptyList())
    val mainScreenViewModel = remember { MainScreenViewModel() }
    val inputAnimeName by mainScreenViewModel.animeName.observeAsState(initial = "")
    val inputAnimeAuthor by mainScreenViewModel.animeAuthor.observeAsState(initial = "")
    val inputAnimeGenre by mainScreenViewModel.animeGenre.observeAsState(initial = "")
    val inputAnimeId by mainScreenViewModel.animeId.observeAsState(initial = 0)
    val showDelteIcon = remember { derivedStateOf { inputAnimeName.isNotEmpty() }}

    Scaffold(
        topBar = { TopBar(userNameViewModel, navController)},
        floatingActionButton = { FloatingActionButton(navController)}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Lista de tareas:",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
            )
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                TextField(
                    value = inputAnimeName,
                    onValueChange = { mainScreenViewModel.onAnimeNameChange(it) },
                    label = { Text(text = "Tarea a añadir") },
                    trailingIcon = {
                        if (showDelteIcon.value) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = "Eliminar tarea",
                                modifier = Modifier.clickable { mainScreenViewModel.onAnimeNameDelete() })
                        }
                    }
                )
                Button(onClick = {
                    animeViewModel.addAnime(inputAnimeName,inputAnimeId,inputAnimeAuthor,inputAnimeGenre)
                    mainScreenViewModel.onAnimeNameDelete()

                },
                    enabled = showDelteIcon.value
                ) {
                    Text(text = "Añadir")
                }
            }
            Divider(
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(7.7f)
            ) {
                LazyColumn(
                    Modifier.fillMaxSize()
                ) {

                }
            }
        }
    }
}

@Composable
fun AnimeItem(
    anime: TaskEntity,
    onUpdate: (Boolean) -> Unit,
    onDelete: () -> Unit,
) {
    ListItem(
        headlineText = { Text(text = anime.name)},
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        ),
        leadingContent =  {
            Checkbox(
                checked = anime.isDone ,
                onCheckedChange = {
                    onUpdate(it)
                })
        },
        trailingContent = {
            IconButton(onClick = {
                onDelete()
            }) {
                Icon(imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar tarea",
                    )
            }
        }
    )
}