package com.duncanrua.rickmortycardsduncan.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duncanrua.rickmortycardsduncan.R
import com.duncanrua.rickmortycardsduncan.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SecondScreen(navController: NavController){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.rymlogo),
                        contentDescription = stringResource(id = R.string.logo_morty)
                    )
                },
                navigationIcon = {
                    var expanded by rememberSaveable { mutableStateOf(false) }
                    IconButton(onClick = {expanded=true }){
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = stringResource(id = R.string.see_more))
                    }
                    DropdownMenu(expanded = expanded, onDismissRequest = {

                    }) {
                        DropdownMenuItem(text = { Text(text = stringResource(id = R.string.main)) }, onClick = {
                            navController.popBackStack()
                            navController.navigate(route = Routes.MainScreen.route)
                        })
                        DropdownMenuItem(text = { Text(text = stringResource(id = R.string.equip)) }, onClick = {})
                    }
                },
            )
        },
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.select_your_characters))
        }
    }
}
