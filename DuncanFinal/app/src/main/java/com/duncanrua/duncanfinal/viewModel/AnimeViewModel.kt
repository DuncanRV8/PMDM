/**
 * Es una aplicación donde pones los animes con la información.
 *
 * @author: Duncan Rua Valiente
 * @version: 7.2.1
 */
package com.duncanrua.duncanfinal.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duncanrua.duncanfinal.dao.AnimeDAO
import com.duncanrua.duncanfinal.dataBase.AnimeDatabase
import com.duncanrua.duncanfinal.entities.AnimeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Donde utilizare mis metodos del anime
 *
 * @constructor
 * TODO
 *
 * @param application
 */
class AnimeViewModel (application: Application): ViewModel() {
    val animeDAO: AnimeDAO = AnimeDatabase.getInstance(application).animeDAO()
    var animeList: LiveData<MutableList<AnimeEntity>> = MutableLiveData()

    private val _selectedAnime = MutableLiveData<AnimeEntity>()

    val selectedAnime: LiveData<AnimeEntity>
        get() = _selectedAnime
    fun animeSelected(anime: AnimeEntity) {
        _selectedAnime.value = anime
    }

    fun getAllAnimes() {
        viewModelScope.launch(Dispatchers.IO) {
            animeList = animeDAO.getAllAnimes()
        }
    }

    fun addAnime( anime: AnimeEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            if (animeDAO.animeExists(anime.name) == 0) {
                animeDAO.addAnime(anime)
            }
        }
    }

    fun deleteAnime(anime: AnimeEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            animeDAO.deleteAnime(anime)
        }
    }

    fun updateAnime(anime: AnimeEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            animeDAO.updateAnime(anime)
        }
    }
}