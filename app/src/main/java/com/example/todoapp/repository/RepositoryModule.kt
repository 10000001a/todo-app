package com.example.todoapp.repository

import com.example.todoapp.data.dao.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesTodoRepository(todoDao: TodoDao): TodoRepository = TodoRepositoryImpl(todoDao)
}