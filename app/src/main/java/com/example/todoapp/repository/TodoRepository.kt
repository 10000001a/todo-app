package com.example.todoapp.repository

import com.example.todoapp.model.TodoEntity

interface TodoRepository {
    suspend fun insert(item: TodoEntity)
}