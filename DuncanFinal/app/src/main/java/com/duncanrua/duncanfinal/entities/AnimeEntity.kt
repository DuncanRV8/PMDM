/**
 * Es una aplicación donde pones los animes con la información.
 *
 * @author: Duncan Rua Valiente
 * @version: 7.2.1
 */
package com.duncanrua.duncanfinal.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Toda la información de mi anime
 *
 * @property id
 * @property name
 * @property author
 * @property genre
 * @property info
 */
@Entity(tableName = "animes")
data class AnimeEntity(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val author: String = "",
    val genre: String = "",
    val info: String = ""
)