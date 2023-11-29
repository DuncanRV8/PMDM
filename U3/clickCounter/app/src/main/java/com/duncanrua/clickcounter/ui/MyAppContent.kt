package com.duncanrua.clickcounter.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.duncanrua.clickcounter.ui.theme.ClickCounterTheme

@Composable
fun MyAppContent(content: @Composable () -> Unit) {
    ClickCounterTheme{
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}