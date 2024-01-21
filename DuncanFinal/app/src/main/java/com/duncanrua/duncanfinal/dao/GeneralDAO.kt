package com.duncanrua.duncanfinal.dao

import androidx.lifecycle.LiveData
import com.duncanrua.duncanfinal.entities.AnimeEntity

interface GeneralDAO {

    fun getAllAnimes(): LiveData<MutableList<AnimeEntity>>

    suspend fun animeExists(name: String): Int

    suspend fun getAnimeBYId(id: Int): AnimeEntity

    suspend fun addAnime(animeEntity: AnimeEntity): Long

    suspend fun updateAnime(animeEntity: AnimeEntity): Int

    suspend fun deleteAnime(animeEntity: AnimeEntity): Int
}