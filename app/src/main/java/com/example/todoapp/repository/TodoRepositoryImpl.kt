package com.example.todoapp.repository

import com.example.todoapp.data.dao.TodoDao
import com.example.todoapp.model.TodoEntity
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) : TodoRepository {
    override suspend fun insert(item: TodoEntity) {
        todoDao.insert(item)
    }
}