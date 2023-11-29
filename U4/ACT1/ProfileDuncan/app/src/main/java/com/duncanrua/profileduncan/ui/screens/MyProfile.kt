@file:OptIn(ExperimentalMaterial3Api::class)

package com.duncanrua.profileduncan.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyProfile() {
    Column(

    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Row (

        ){
            Column(

            ) {

                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
                Text(
                    text = "Duncan"
                )
            }
            Spacer(modifier = Modifier.width(120.dp))
            Hobbies()
        }
    }

        OutlinedTextField(value = "hola", onValueChange = {},
                          colors = TextFieldDefaults.outlinedTextFieldColors(


                          )
                          )


}

@Preview
@Composable
fun Hobbies() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Hobby(
                text = "Videojuegos",
                icon = Icons.Default.Add
            )
            Hobby(
                    text = "Karate",
            icon = Icons.Default.Add
            )
            Hobby(
                text = "Andar",
                icon = Icons.Default.Add
            )
            Hobby(
                text = "asd",
                icon = Icons.Default.Add
            )
        }
    }
}

@Composable
fun Hobby(text: String, icon: ImageVector) {
    Row {
        Icon(
            imageVector = icon,
            contentDescription = "Icono de $text",
            tint = Color.Cyan
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text)
    }
}

@Composable
fun TextField(value: String, onValueChange: (String) -> Unit ){
    TextField(
        value = value,
        onValueChange = {onValueChange(it)})
}
