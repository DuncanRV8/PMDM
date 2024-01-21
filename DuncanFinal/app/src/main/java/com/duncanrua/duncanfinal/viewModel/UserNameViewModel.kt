/**
 * Es una aplicación donde pones los animes con la información.
 *
 * @author: Duncan Rua Valiente
 * @version: 7.2.1
 */
package com.duncanrua.duncanfinal.viewModel

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duncanrua.duncanfinal.dataStore.AnimePreferences
import kotlinx.coroutines.launch

/**
 * Donde me vinculare con el Animepreferences para guardar el nombre del usuario
 *
 * @constructor
 * TODO
 *
 * @param application
 */
class UserNameViewModel(application: Application) : ViewModel() {
    private val preferences = AnimePreferences(application)

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    fun updateUserName(name: String){
        _userName.value = name
    }
    fun onAnimeNameDelete() {
        _userName.value = ""
    }

    /**
     * Guardar el nombre
     *
     * @param name
     */
    fun saveName(name: String){
        viewModelScope.launch {
            preferences.saveName(name)
            _userName.value = ""
        }
    }

    /**
     * Cargar el dato del nombre
     *
     */
    fun loadName(){
        viewModelScope.launch {
            preferences.loadName().collect {
                _userName.value = it
            }
        }
    }
}