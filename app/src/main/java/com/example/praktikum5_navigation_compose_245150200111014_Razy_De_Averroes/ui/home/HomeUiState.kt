package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.home

import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.model.Student

data class HomeUiState(
    val students: List<Student> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)