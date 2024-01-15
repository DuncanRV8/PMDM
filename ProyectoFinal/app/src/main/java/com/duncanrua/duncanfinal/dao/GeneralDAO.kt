package com.duncanrua.duncanfinal.dao

import androidx.lifecycle.LiveData
import com.duncanrua.duncanfinal.entities.TaskEntity

interface GeneralDAO {
    fun getAllTasks(): LiveData<MutableList<TaskEntity>>

    suspend fun taskExists(name: String): Int

    suspend fun getTaskBYId(id: Long): TaskEntity

    suspend fun addTask(taskEntity: TaskEntity): Long

    suspend fun updateTask(taskEntity: TaskEntity): Int

    suspend fun deleteTask(taskEntity: TaskEntity): Int
}