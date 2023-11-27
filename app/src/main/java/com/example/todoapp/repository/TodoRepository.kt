package com.example.todoapp.repository

import com.example.todoapp.model.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun loadList(): Flow<List<TodoEntity>>
    suspend fun insert(item: TodoEntity)
}