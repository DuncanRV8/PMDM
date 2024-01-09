@file:OptIn(ExperimentalMaterial3Api::class)

package com.duncanrua.duncanfinal.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.ui.screen.detailMainScreen.TopBar
import com.duncanrua.duncanfinal.viewModel.AnimeViewModel

@Composable
fun MainScreen(
    navController: NavController,
    animeViewModel: AnimeViewModel
){
    Scaffold(
        topBar = { TopBar()}
    ) {
        Box(modifier = Modifier.padding(it))
    }
}