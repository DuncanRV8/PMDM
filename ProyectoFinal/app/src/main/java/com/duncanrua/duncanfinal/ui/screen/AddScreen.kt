package com.duncanrua.duncanfinal.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.viewModel.AnimeViewModel

@Composable
fun AddScreen(
    navController: NavController,
    animeViewModel: AnimeViewModel
){
    Text(text = "Hola funciona")
}