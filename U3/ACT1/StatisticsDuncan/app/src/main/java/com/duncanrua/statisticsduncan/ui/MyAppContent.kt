package com.duncanrua.statisticsduncan.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.duncanrua.statisticsduncan.Content

@Composable
fun MyAppContent(content: @Composable () -> Unit) {
    clickCounter{
        Surface {
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        }
        Content()
    }
}
