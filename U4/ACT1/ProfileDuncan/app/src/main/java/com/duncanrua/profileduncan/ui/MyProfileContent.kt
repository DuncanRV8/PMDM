package com.duncanrua.profileduncan.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.duncanrua.profileduncan.ui.theme.ProfileDuncanTheme

@Composable
fun MyProfileContent(content: @Composable () -> Unit) {
    ProfileDuncanTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}