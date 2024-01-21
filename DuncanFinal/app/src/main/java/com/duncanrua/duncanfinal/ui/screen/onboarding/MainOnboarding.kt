@file:OptIn(ExperimentalMaterial3Api::class)

package com.duncanrua.duncanfinal.ui.screen.onboarding

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.R
import com.duncanrua.duncanfinal.viewModel.mainViewModels.MainViewModels
import com.duncanrua.duncanfinal.viewModel.AnimeViewModel
import com.duncanrua.duncanfinal.viewModel.UserNameViewModel
import com.example.compose.md_theme_light_inversePrimary

@Composable
fun MainOnboarding(
    navController: NavController,
    mainViewModels: MainViewModels
){
    val userNameViewModel = mainViewModels.userNameViewModel
    val userName: String by userNameViewModel.userName.observeAsState(initial = "")
    val regexUserName = Regex("""^\S(?:.*\S)?$""")
    Column (
        modifier = Modifier.background(color = md_theme_light_inversePrimary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            label = { Text(text = stringResource(id = R.string.user_name)) },
            value = userName,
            onValueChange = { userName -> userNameViewModel.updateUserName(userName)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            navController.navigate("main_screen")
            userNameViewModel.saveName(userName)
        },
            enabled = regexUserName.matches(userName)) {
            Text(text =stringResource(id = R.string.next_windows))
        }
    }
}