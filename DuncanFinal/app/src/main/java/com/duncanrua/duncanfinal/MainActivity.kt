package com.duncanrua.duncanfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.duncanrua.duncanfinal.navigation.Navigation
import com.duncanrua.duncanfinal.viewModel.mainViewModels.MainViewModels
import com.example.compose.DuncanFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainViewModels by lazy { MainViewModels(application) }
        setContent {
            DuncanFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(mainViewModels)
                }
            }
        }
    }
}
