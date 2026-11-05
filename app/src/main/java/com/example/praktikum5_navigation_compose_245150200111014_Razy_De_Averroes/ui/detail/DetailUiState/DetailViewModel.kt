package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.detail.DetailUiState

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.repository.StudentRepository

class DetailViewModel(
    private val repository: StudentRepository

) : ViewModel() {

    var uiState by mutableStateOf(DetailUiState())
        private set

    fun loadStudent(id: Int) {
        val student = repository.getStudentById(id)
        uiState = if (student != null) {
            DetailUiState(student = student)
        } else {
            DetailUiState(errorMessage = "Student tidak ditemukan")
        }
    }

    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return DetailViewModel(repository) as T
                }
            }
    }
}