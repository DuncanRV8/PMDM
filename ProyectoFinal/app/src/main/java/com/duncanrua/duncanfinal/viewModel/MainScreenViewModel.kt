package com.duncanrua.duncanfinal.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainScreenViewModel() : ViewModel() {

    private val _animeId = MutableLiveData<Int>()
    val animeId: LiveData<Int> = _animeId

    private val _animeName = MutableLiveData<String>()
    val animeName: LiveData<String> = _animeName

    private val _animeAuthor = MutableLiveData<String>()
    val animeAuthor: LiveData<String> = _animeAuthor
    private val _animeGenre = MutableLiveData<String>()
    val animeGenre: LiveData<String> = _animeGenre

    fun onAnimeNameChange(animeName: String) {
        _animeName.value = animeName
    }

    fun onAnimeNameDelete() {
        _animeName.value = ""
    }
}