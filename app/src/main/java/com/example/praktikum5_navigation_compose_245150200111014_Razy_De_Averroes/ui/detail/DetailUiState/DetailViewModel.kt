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
        uiState = uiState.copy(isLoading = true, errorMessage = null)

        repository.getStudent(id) { result ->
            result
                .onSuccess { student ->
                    uiState = DetailUiState(student = student)
                }
                .onFailure { error ->
                    uiState = DetailUiState(
                        errorMessage = error.message ?: "Data tidak tersedia"
                    )
                }
        }
    }

    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DetailViewModel(repository) as T
            }
        }
    }
}