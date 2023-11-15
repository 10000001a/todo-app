package com.example.todoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.model.TodoEntity
import com.example.todoapp.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class InputState(
    val title: String,
    val description: String,
    val success: Boolean = false
)

@HiltViewModel
class InputViewModel @Inject constructor(private val todoRepository: TodoRepository) : ViewModel() {

    var state = MutableStateFlow<InputState>(InputState("", ""))

    fun setTitle(title: String) {
        state.value = state.value.copy(title = title)
    }

    fun setDescription(description: String) {
        state.value = state.value.copy(description = description)
    }

    fun insertTodo() {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.insert(
                TodoEntity(
                    title = state.value.title,
                    description = state.value.description
                )
            )

            state.emit(state.value.copy(success = true))
        }
    }
}