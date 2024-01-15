package com.duncanrua.duncanfinal.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.duncanrua.duncanfinal.dao.TaskDAO
import com.duncanrua.duncanfinal.dataBase.TasksDatabase
import com.duncanrua.duncanfinal.entities.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeViewModel (application: Application): AndroidViewModel(application) {
    val animeDAO: TaskDAO = TasksDatabase.getInstance(application).taskDAO()

    var animeList: LiveData<MutableList<TaskEntity>> = MutableLiveData()

    fun getAllAnimes() {
        viewModelScope.launch(Dispatchers.IO) {
            animeList = animeDAO.getAllTasks()
        }
    }

    fun addAnime( anime: String, id: Int, author: String, genre: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (animeDAO.taskExists(anime) == 0) {
                animeDAO.addTask(TaskEntity( name = anime, id = id, author = author, genre = genre))
            }
        }
    }

    fun deleteAnime(anime: TaskEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            animeDAO.deleteTask(anime)
        }
    }

    fun updateAnime(anime: TaskEntity, id: Int, name: String, author: String, genre: String) {
        viewModelScope.launch(Dispatchers.IO) {
            animeDAO.updateTask(anime.copy(id = id, name = name, author = author, genre = genre))
        }
    }
}