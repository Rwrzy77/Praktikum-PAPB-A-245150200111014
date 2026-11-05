package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.remote.dto

import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.model.Student
data class UserDto(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val university: String
)

fun UserDto.toStudent() = Student(
    id = id,
    name = "$firstName $lastName",
    email = email,
    university = university
)