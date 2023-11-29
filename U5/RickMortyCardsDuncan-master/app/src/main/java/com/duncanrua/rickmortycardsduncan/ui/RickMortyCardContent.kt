package com.duncanrua.rickmortycardsduncan.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.duncanrua.rickmortycardsduncan.ui.theme.RickMortyCardsDuncanTheme

@Composable
fun RickMortyCardContent(content: @Composable () -> Unit) {
    RickMortyCardsDuncanTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}