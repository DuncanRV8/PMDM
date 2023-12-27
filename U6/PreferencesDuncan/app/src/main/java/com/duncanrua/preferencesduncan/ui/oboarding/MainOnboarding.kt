@file:OptIn(ExperimentalMaterial3Api::class)

package com.duncanrua.preferencesduncan.ui.oboarding

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.duncanrua.preferencesduncan.viewModel.PreferencesViewModel

@Composable
fun MainOnboarding(
    navController: NavController,
    preferencesViewModel: PreferencesViewModel
){
    val userName: String by preferencesViewModel.userName.observeAsState(initial = "")
    val telephone: String by preferencesViewModel.telephone.observeAsState(initial = "")
    val regexUserName = Regex("^[a-zA-Z]{3,}\$")
    val regexTelephone = Regex("^[0-9]{9}\$")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            label = { Text(text = "Nombre del usuario")},
            value = userName,
            onValueChange = { userName -> preferencesViewModel.updateUserName(userName)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            label = { Text(text = "Telefono del usuario")},
            value = telephone,
            onValueChange = { telephone -> preferencesViewModel.updateTelephone(telephone)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            navController.navigate("main_screen")
            preferencesViewModel.saveName(userName)
            preferencesViewModel.saveTelephone(telephone)
        },
            enabled = regexUserName.matches(userName)&& regexTelephone.matches(telephone)) {
            Text(text = "Siguiente ventana")
        }
    }
}