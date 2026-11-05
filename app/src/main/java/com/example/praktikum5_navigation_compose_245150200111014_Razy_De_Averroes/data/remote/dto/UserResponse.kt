package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.remote.dto

data class UserResponse(
    val users: List<UserDto>,
    val total: Int,
    val skip: Int,
    val limit: Int
)