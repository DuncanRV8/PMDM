package com.duncanrua.listduncan.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duncanrua.listduncan.ui.Anime
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AnimeViewModel: ViewModel(){
    private val _animes = MutableLiveData<List<Anime>>()
    val animes: LiveData<List<Anime>> = _animes

    private val _selectedAnime = MutableLiveData<Anime>()
    val selectedAnime: LiveData<Anime> = _selectedAnime

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            _animes.value = Anime.getData()
            _isLoading.value = false
        }
    }

    fun deleteAnime(anime: Anime){
        _animes.value = _animes.value?.filter { it != anime }
    }
    fun onAnimeClicked(anime: Anime){
        _selectedAnime.value = anime
    }
    fun isSelectedFavorite(){
    }
}
