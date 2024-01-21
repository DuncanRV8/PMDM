/**
 * Es una aplicación donde pones los animes con la información.
 *
 * @author: Duncan Rua Valiente
 * @version: 7.2.1
 */
package com.duncanrua.duncanfinal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.duncanrua.duncanfinal.entities.AnimeEntity

/**
 * Metodos que se comunican con la base de datos
 *
 */
@Dao
interface AnimeDAO: GeneralDAO {
    @Query("SELECT * FROM animes ORDER BY name")
    override fun getAllAnimes(): LiveData<MutableList<AnimeEntity>>

    @Query("SELECT count(*) FROM animes WHERE name = :name")
    override suspend fun animeExists(name: String): Int

    @Query("SELECT * FROM animes WHERE id LIKE :id")
    override suspend fun getAnimeBYId(id: Int): AnimeEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun addAnime(animeEntity: AnimeEntity): Long

    @Update
    override suspend fun updateAnime(animeEntity: AnimeEntity): Int

    @Delete
    override suspend fun deleteAnime(animeEntity: AnimeEntity): Int
}