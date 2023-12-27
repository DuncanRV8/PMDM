package com.duncanrua.preferencesduncan.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duncanrua.preferencesduncan.R
import com.duncanrua.preferencesduncan.viewModel.PreferencesViewModel

@Composable
fun MainScreen(
    navController: NavController,
    preferencesViewModel: PreferencesViewModel
){
    loadData(preferencesViewModel)
    val userName: String by preferencesViewModel.userName.observeAsState(initial = "")
    val telephone: String by preferencesViewModel.telephone.observeAsState(initial = "")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyPhoto()
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "El nombre de usuario es: $userName" )
        Text(text = "El telefono del usuario es: $telephone" )

        Button(onClick = {
            preferencesViewModel.saveName("")
            preferencesViewModel.saveTelephone("")
            navController.navigate("main_onboarding")
        }) {
            Text(text = "Cerrar sesión")
        }
    }
}

@Composable
fun MyPhoto(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id= R.drawable.duncan),
            contentDescription = "logo",
            modifier = Modifier.size(200.dp, 200.dp)
        )
        Text(
            "Duncan Rua Valiente",
            fontSize = 30.sp
        )
    }
}

@Composable
fun loadData(preferencesViewModel: PreferencesViewModel){
    preferencesViewModel.loadName()
    preferencesViewModel.loadTelephone()
}