package com.duncanrua.duncanfinal.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.duncanrua.duncanfinal.dao.TaskDAO
import com.duncanrua.duncanfinal.entities.TaskEntity

@Database(entities = arrayOf(TaskEntity::class), version = 1)

abstract class TasksDatabase: RoomDatabase() {
    abstract fun taskDAO(): TaskDAO

    companion object {
        private var instance: TasksDatabase? = null

        fun getInstance(context: Context): TasksDatabase {
            return instance ?: Room.databaseBuilder(context, TasksDatabase::class.java, "animes-db")
                .build()
                .also { instance = it }
        }
    }
}