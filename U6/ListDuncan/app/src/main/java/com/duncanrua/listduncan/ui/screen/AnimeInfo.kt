package com.duncanrua.listduncan.ui.screen

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duncanrua.listduncan.ui.Anime
import com.duncanrua.listduncan.viewmodel.AnimeViewModel

@Composable
fun AnimeInfo(
    navController: NavController,
    animeViewModel: AnimeViewModel
){
    val anime: Anime by animeViewModel.selectedAnime.observeAsState(Anime())
    var isFavorite by rememberSaveable {mutableStateOf(anime.favorite)}
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.errorContainer,)
            .padding(8.dp)
    ){
        Row (
            modifier = Modifier.clickable {
                navController.popBackStack()
            }
        ){
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Volver")
            Text(text = "Volver")
        }
        Row {
            Button(onClick = {
                anime.favorite = !anime.favorite
                isFavorite = !isFavorite
            }) {
                if (isFavorite == false){
                    Icon(imageVector = Icons.Default.Star, contentDescription = "favorite")
                    Text(text = "Marcar como favorito")
                    isFavorite = false
                }else{
                    Icon(imageVector = Icons.Default.Star, contentDescription = "favorite", tint = MaterialTheme.colorScheme.error)
                    Text(text = "Quitar de favoritos")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(imageVector = Icons.Default.Menu, contentDescription = "anime")
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = anime.title, fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = anime.titleJapanese,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = anime.author,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onTertiary)
                .padding(8.dp)
        ){
            Text(text = "Aqui se mostrara la informacion detallada del libro",
                 color = MaterialTheme.colorScheme.tertiary
            )

        }
    }

}