package com.example.todoapp

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.TodoItemBinding
import com.example.todoapp.model.TodoEntity

class TodoListViewHolder(
    private val binding: TodoItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(todo: TodoEntity) {
        binding.todo = todo

        binding.todoCheckBox.paintFlags = if (todo.isDone) Paint.STRIKE_THRU_TEXT_FLAG else 0
    }
}