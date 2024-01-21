package com.duncanrua.duncanfinal.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.duncanrua.duncanfinal.dao.AnimeDAO
import com.duncanrua.duncanfinal.entities.AnimeEntity


@Database(entities = [AnimeEntity::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {
    abstract fun animeDAO(): AnimeDAO

    companion object {
        private var instance: AnimeDatabase? = null

        fun getInstance(context: Context): AnimeDatabase {
            return instance ?: Room.databaseBuilder(context, AnimeDatabase::class.java, "anime-db")
                .build()
                .also {instance = it}
        }
    }
}
