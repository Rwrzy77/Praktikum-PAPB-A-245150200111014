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

    init {
        loadStudents()
    }

    fun loadStudents() {
        val students = repository.getStudents()
        uiState = if (students.isNotEmpty()) {
            HomeUiState(students = students)
        } else {
            HomeUiState(errorMessage = "Belum ada data mahasiswa")
        }
    }

    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel(repository) as T
                }
            }
    }
}