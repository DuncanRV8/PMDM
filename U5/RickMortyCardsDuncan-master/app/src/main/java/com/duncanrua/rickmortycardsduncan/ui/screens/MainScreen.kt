@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.duncanrua.rickmortycardsduncan.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.duncanrua.rickmortycardsduncan.R
import com.duncanrua.rickmortycardsduncan.navigation.Routes


@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MainScreen(navController: NavController){
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
                    var expanded by rememberSaveable { mutableStateOf(false)}
                    IconButton(onClick = {expanded=true }){
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = stringResource(id = R.string.see_more))
                    }
                    DropdownMenu(expanded = expanded, onDismissRequest = {

                    }) {
                        DropdownMenuItem(text = { Text(text = stringResource(id = R.string.main)) }, onClick = {})
                        DropdownMenuItem(text = { Text(text = stringResource(id = R.string.equip)) }, onClick = {
                            navController.popBackStack()
                            navController.navigate(route = Routes.SecondScreen.route)
                        })
                    }
                },
            )
        },
    ){
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Image(painter = painterResource(id = R.drawable.rymportal), contentDescription = stringResource(id = R.string.portal_morty))
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                
            }) {
                Text(text = stringResource(id = R.string.start_game))
            }
        }
    }
}