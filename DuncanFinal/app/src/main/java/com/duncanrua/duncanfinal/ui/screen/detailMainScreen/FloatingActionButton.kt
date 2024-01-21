/**
 * Es una aplicación donde pones los animes con la información.
 *
 * @author: Duncan Rua Valiente
 * @version: 7.2.1
 */
package com.duncanrua.duncanfinal.ui.screen.detailMainScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.res.stringResource
import com.duncanrua.duncanfinal.R

/**
 * Boton flotante que navegara al autor si lo pulsas
 *
 * @param navController
 */
@Composable
fun FloatingActionButton(
    navController: NavController
){
    FloatingActionButton(onClick = {
        navController.popBackStack()
        navController.navigate("add_screen")
    }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = stringResource(id = R.string.add))
    }
}