package com.example.todoapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.dao.TodoDao
import com.example.todoapp.model.TodoEntity

@Database(entities = [TodoEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}