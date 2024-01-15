package com.duncanrua.duncanfinal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.duncanrua.duncanfinal.entities.TaskEntity

@Dao
interface TaskDAO: GeneralDAO {
    @Query("SELECT * FROM animes ORDER BY name")
    override fun getAllTasks(): LiveData<MutableList<TaskEntity>>

    @Query("SELECT count(*) FROM animes WHERE name = :name")
    override suspend fun taskExists(name: String): Int

    @Query("SELECT * FROM animes WHERE id LIKE :id")
    override suspend fun getTaskBYId(id: Long): TaskEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun addTask(taskEntity: TaskEntity): Long

    @Update
    override suspend fun updateTask(taskEntity: TaskEntity): Int

    @Delete
    override suspend fun deleteTask(taskEntity: TaskEntity): Int
}