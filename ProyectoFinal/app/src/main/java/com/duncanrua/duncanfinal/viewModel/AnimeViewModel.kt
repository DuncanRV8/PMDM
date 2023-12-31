package com.duncanrua.duncanfinal.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.duncanrua.duncanfinal.dataStore.AnimePreferences
import kotlinx.coroutines.launch

class AnimeViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = AnimePreferences(application.applicationContext)

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    fun updateUserName(name: String){
        _userName.value = name
    }

    fun saveName(name: String){
        viewModelScope.launch {
            preferences.saveName(name)
            _userName.value = ""
        }
    }

    fun loadName(){
        viewModelScope.launch {
            preferences.loadName().collect {
                _userName.value = it
            }
        }
    }
}