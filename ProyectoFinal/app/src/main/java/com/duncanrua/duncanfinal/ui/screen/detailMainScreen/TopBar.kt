@file:OptIn(ExperimentalMaterial3Api::class)

package com.duncanrua.duncanfinal.ui.screen.detailMainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.CoPresent
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duncanrua.duncanfinal.R
import com.duncanrua.duncanfinal.viewModel.AnimeViewModel

@Composable
fun TopBar(
    animeViewModel: AnimeViewModel,
    navController: NavController,
){
    animeViewModel.loadName()
    val userName: String by animeViewModel.userName.observeAsState(initial = "")
    TopAppBar(
        navigationIcon = {
        var expanded by rememberSaveable { mutableStateOf(false)}
            IconButton(onClick = {expanded = true}) {
                Icon(imageVector = Icons.Default.Apps, 
                     contentDescription = "Menu"
                )
            }
            DropdownMenu(
                expanded = expanded, 
                onDismissRequest = { }
            ) {
                DropdownMenuItem(
                    text = {Text(text = "$userName")},
                    onClick = { /*TODO*/ },
                )
                Divider()
                DropdownMenuItem(
                    text = {Text(text = "Principal")},
                    onClick = {
                        navController.popBackStack()
                        navController.navigate("main_screen")
                              },
                    leadingIcon = {Icon(imageVector = Icons.Default.Home, contentDescription = "Principal")}
                )
                DropdownMenuItem(
                    text = {Text(text = "Añadir")},
                    onClick = { navController.navigate("add_screen") },
                    leadingIcon = {Icon(imageVector = Icons.Default.Add, contentDescription = "Añadir")}
                )
                DropdownMenuItem(
                    text = {Text(text = "Cerrar Sesión")},
                    onClick = {
                        animeViewModel.saveName("")
                        navController.navigate("main_onboarding")
                    },
                    leadingIcon = {Icon(imageVector = Icons.Default.Logout, contentDescription = "Cerrar sesión")}
                )
                DropdownMenuItem(
                    text = {Text(text = "Autor")},
                    onClick = { navController.navigate("author_screen")},
                    leadingIcon = {Icon(imageVector = Icons.Default.CoPresent, contentDescription = "Autor")}
                )
            }
        },
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(80.dp))
                Image(
                    painter = painterResource(id = R.drawable.letraanime),
                    contentDescription = "Letra de anime",
                    modifier = Modifier.height(50.dp)
                )
            }
        },
        actions = {

        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            navigationIconContentColor = Color.Cyan,
            containerColor = Color.Black
        )
    )
}