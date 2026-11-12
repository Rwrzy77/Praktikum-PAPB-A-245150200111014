package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.repository.StudentRepository
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.detail.DetailUiState.DetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class DetailViewModel(
    private val repository: StudentRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun loadStudent(id: Int) {
        viewModelScope.launch {
            _uiState.value = DetailUiState(isLoading = true)

            try {
                val student = repository.getStudent(id)
                _uiState.value = DetailUiState(student = student)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = DetailUiState(
                    errorMessage = e.message ?: "Data tidak tersedia"
                )
            }
        }
    }

//    private val repository: StudentRepository
//
//) : ViewModel() {
//
//    var uiState by mutableStateOf(DetailUiState())
//        private set
//
//    fun loadStudent(id: Int) {
//        uiState = uiState.copy(isLoading = true, errorMessage = null)
//
//        repository.getStudent(id) { result ->
//            result
//                .onSuccess { student ->
//                    uiState = DetailUiState(student = student)
//                }
//                .onFailure { error ->
//                    uiState = DetailUiState(
//                        errorMessage = error.message ?: "Data tidak tersedia"
//                    )
//                }
//        }
//    }

    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DetailViewModel(repository) as T
            }
        }
    }
}