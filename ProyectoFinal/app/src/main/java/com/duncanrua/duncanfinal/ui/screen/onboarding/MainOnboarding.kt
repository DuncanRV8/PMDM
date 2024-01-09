@file:OptIn(ExperimentalMaterial3Api::class)

package com.duncanrua.duncanfinal.ui.screen.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.viewModel.AnimeViewModel

@Composable
fun MainOnboarding(
    navController: NavController,
    animeViewModel: AnimeViewModel
){
    val userName: String by animeViewModel.userName.observeAsState(initial = " ")
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            label = { Text(text = "Nombre del usuario") },
            value = userName,
            onValueChange = { userName -> animeViewModel.updateUserName(userName)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}