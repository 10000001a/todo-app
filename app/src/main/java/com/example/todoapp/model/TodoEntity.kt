package com.example.todoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Todo")
data class TodoEntity(
    @PrimaryKey(true)
    val id: Int = 0,

    @ColumnInfo
    val title: String = "",

    @ColumnInfo
    val description: String? = null,

    @ColumnInfo
    val isDone: Boolean = false
) : Serializable