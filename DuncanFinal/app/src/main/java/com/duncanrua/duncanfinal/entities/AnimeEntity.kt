package com.duncanrua.duncanfinal.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animes")
data class AnimeEntity(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val author: String = "",
    val genre: String = "",
    val info: String = ""
)