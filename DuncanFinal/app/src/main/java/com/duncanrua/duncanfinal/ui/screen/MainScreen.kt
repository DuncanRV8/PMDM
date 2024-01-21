@file:OptIn(ExperimentalMaterial3Api::class)

package com.duncanrua.duncanfinal.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.R
import com.duncanrua.duncanfinal.entities.AnimeEntity
import com.duncanrua.duncanfinal.viewModel.mainViewModels.MainViewModels
import com.duncanrua.duncanfinal.ui.screen.detailMainScreen.TopBar
import com.duncanrua.duncanfinal.ui.screen.detailMainScreen.FloatingActionButton
import com.duncanrua.duncanfinal.viewModel.AnimeViewModel
import com.example.compose.md_theme_light_inversePrimary
import com.example.compose.md_theme_light_onSurfaceVariant

@Composable
fun MainScreen(
    navController: NavController,
    mainViewModels: MainViewModels
){
    val userNameViewModel = mainViewModels.userNameViewModel
    val animeViewModel = mainViewModels.animeViewModel

    animeViewModel.getAllAnimes()
    userNameViewModel.loadName()
    val animeList by animeViewModel.animeList.observeAsState(initial = emptyList())

    Scaffold(
        topBar = { TopBar(userNameViewModel, navController)},
        floatingActionButton = { FloatingActionButton(navController)}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = md_theme_light_inversePrimary)
        ) {
            Text(
                text = stringResource(id = R.string.anime_list),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
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
                    items(animeList) { anime ->
                        AnimeItem(
                            anime = anime,
                            onDelete = {
                                animeViewModel.deleteAnime(anime)
                            },
                            navController,
                            mainViewModels
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeItem(
    anime: AnimeEntity,
    onDelete: () -> Unit,
    navController: NavController,
    mainViewModels: MainViewModels
) {
    OutlinedCard (
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                mainViewModels.animeViewModel.animeSelected(anime)
                navController.navigate("anime_info_screen")
            }
    ){
        ListItem(
            headlineText = { Text(text = anime.name)},
            colors = ListItemDefaults.colors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            ),
            leadingContent =  {
            },
            trailingContent = {
                IconButton(onClick = {
                    onDelete()
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = stringResource(id = R.string.delete_anime),
                    )
                }
            }
        )
    }
}