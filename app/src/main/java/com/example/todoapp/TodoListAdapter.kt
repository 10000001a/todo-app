package com.example.todoapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.todoapp.databinding.TodoItemBinding
import com.example.todoapp.model.TodoEntity


class TodoListAdapter : ListAdapter<TodoEntity, TodoListViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        return TodoListViewHolder(
            TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<TodoEntity>() {
            override fun areItemsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
                Log.d("TodoListAdapter.kt", "${oldItem.id} ${newItem.id}")
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
                Log.d("TodoListAdapter.kt", "${oldItem.id} ${newItem.id}")
                return oldItem == newItem
            }
        }
    }
}