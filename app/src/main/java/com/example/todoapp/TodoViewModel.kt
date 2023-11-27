package com.example.todoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.model.TodoEntity
import com.example.todoapp.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    todoRepository: TodoRepository
) : ViewModel() {
    val todoList: StateFlow<List<TodoEntity>> = todoRepository.loadList().stateIn(
        initialValue = emptyList<TodoEntity>(),
        started = SharingStarted.WhileSubscribed(5000),
        scope = viewModelScope
    )
}