package com.duncanrua.preferencesduncan.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.duncanrua.preferencesduncan.dataStore.AppPreferences
import kotlinx.coroutines.launch


class PreferencesViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = AppPreferences(application.applicationContext)

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _telephone = MutableLiveData<String>()
    val telephone: LiveData<String> = _telephone

    fun updateUserName(name: String){
        _userName.value = name
    }

    fun updateTelephone(telephone: String){
        _telephone.value = telephone
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

    fun saveTelephone(telephone: String){
        viewModelScope.launch {
            preferences.saveTelephone(telephone)
            _telephone.value = ""
        }
    }

    fun loadTelephone(){
        viewModelScope.launch {
            preferences.loadTelephone().collect {
                _telephone.value = it
            }
        }
    }
}

