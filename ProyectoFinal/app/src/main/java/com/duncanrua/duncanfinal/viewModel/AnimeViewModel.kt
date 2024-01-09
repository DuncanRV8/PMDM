package com.duncanrua.duncanfinal.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.duncanrua.duncanfinal.dataStore.AnimePreferences

class AnimeViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = AnimePreferences(application.applicationContext)

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName
}