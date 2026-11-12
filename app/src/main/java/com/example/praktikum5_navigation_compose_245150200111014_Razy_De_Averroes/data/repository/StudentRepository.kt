package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.repository

import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.model.Student


interface StudentRepository {
//    fun getStudents(callback: (Result<List<Student>>) -> Unit)
//    fun getStudent(id: Int, callback: (Result<Student>) -> Unit)
//
//    fun searchStudents(query: String, callback: (Result<List<Student>>) -> Unit)
suspend fun getStudents(): List<Student>
    suspend fun getStudent(id: Int): Student
    suspend fun searchStudents(query: String): List<Student>

}

