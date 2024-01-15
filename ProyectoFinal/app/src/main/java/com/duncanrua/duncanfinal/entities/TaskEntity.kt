package com.duncanrua.duncanfinal.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animes")
data class TaskEntity(
    @PrimaryKey (autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var author: String,
    var genre: String,
    var isDone: Boolean = false
)