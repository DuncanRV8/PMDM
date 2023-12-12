package com.duncanrua.listduncan.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duncanrua.listduncan.navigation.Routes
import com.duncanrua.listduncan.ui.Anime
import com.duncanrua.listduncan.viewmodel.AnimeViewModel

@Composable
fun MainScreen(
    navController: NavController,
    animeViewModel: AnimeViewModel
){
    val animes: List<Anime> by animeViewModel.animes.observeAsState(initial = emptyList())
    val isLoadingAnimes: Boolean by animeViewModel.isLoading.observeAsState(initial = false)

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.inversePrimary)
            .padding(vertical = 8.dp)
    ){
        items(animes) { anime ->
            AnimeCard(anime = anime, navController = navController, animeViewModel = animeViewModel)
        }
    }
    if (isLoadingAnimes){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.inversePrimary)
        ) {
            Text(
                text = "Loading...",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(20.dp))
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeCard(
    anime: Anime,
    navController: NavController,
    animeViewModel: AnimeViewModel
){
    OutlinedCard(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                animeViewModel.onAnimeClicked(anime)
                navController.navigate(Routes.AnimeInfo.route)
            }
    ) {
        ListItem(
            headlineText = { Text(text = anime.title)},
            supportingText = { 
                Text(text = anime.titleJapanese)
                Text(text = anime.author) },
            leadingContent = {
                if (anime.favorite){
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "anime",
                        tint = Color(0xFFFB8C00)
                }
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "anime",
                    modifier = Modifier.clickable {
                        animeViewModel.deleteAnime(anime)
                    }
                )
            }
        )
    }
}