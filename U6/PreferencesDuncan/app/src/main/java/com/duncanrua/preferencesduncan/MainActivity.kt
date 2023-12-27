package com.duncanrua.preferencesduncan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.duncanrua.preferencesduncan.navigation.Navigation
import com.duncanrua.preferencesduncan.ui.theme.PreferencesDuncanTheme
import com.duncanrua.preferencesduncan.viewModel.PreferencesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val preferencesViewModel by viewModels<PreferencesViewModel>()
        setContent {
            PreferencesDuncanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(preferencesViewModel)
                }
            }
        }
    }
}