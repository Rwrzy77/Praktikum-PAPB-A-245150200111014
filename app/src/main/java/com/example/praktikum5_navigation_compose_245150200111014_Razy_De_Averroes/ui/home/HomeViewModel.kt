package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.repository.StudentRepository

class HomeViewModel(
    private val repository: StudentRepository
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    init { loadStudents() }

    fun onQueryChange(query: String) {
        uiState = uiState.copy(searchQuery = query)
    }

    fun loadStudents() {
        uiState = uiState.copy(isLoading = true, errorMessage = null)
        repository.getStudents { result ->
            result
                .onSuccess { data ->
                    uiState = uiState.copy(students = data, isLoading = false)
                }
                .onFailure { error ->
                    uiState = uiState.copy(
                        students = emptyList(),
                        isLoading = false,
                        errorMessage = error.message ?: "Gagal mengambil data"
                    )
                }
        }
    }

    fun search() {
        val query = uiState.searchQuery.trim()
        if (query.isEmpty()) {
            loadStudents()
            return
        }
        uiState = uiState.copy(isLoading = true, errorMessage = null)
        repository.searchStudents(query) { result ->
            result
                .onSuccess { data ->
                    uiState = uiState.copy(students = data, isLoading = false)
                }
                .onFailure { error ->
                    uiState = uiState.copy(
                        students = emptyList(),
                        isLoading = false,
                        errorMessage = error.message ?: "Gagal mencari data"
                    )
                }
        }
    }
}