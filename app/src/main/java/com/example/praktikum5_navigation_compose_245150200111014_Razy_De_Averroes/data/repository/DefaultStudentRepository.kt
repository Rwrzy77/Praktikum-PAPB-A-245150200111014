package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.repository

import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.model.Student
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.remote.StudentRemoteDataSource
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.remote.dto.toStudent

class DefaultStudentRepository(
    private val remoteDataSource: StudentRemoteDataSource
) : StudentRepository {

    override fun getStudents(
        callback: (Result<List<Student>>) -> Unit
    ) {
        remoteDataSource.getStudents { result ->
            callback(result.map { users -> users.map { it.toStudent() } })
        }
    }

    override fun getStudent(
        id: Int,
        callback: (Result<Student>) -> Unit
    ) {
        remoteDataSource.getStudent(id) { result ->
            callback(result.map { it.toStudent() })
        }
    }

    override fun searchStudents(
        query: String,
        callback: (Result<List<Student>>) -> Unit
    ) {
        remoteDataSource.searchStudents(query) { result ->
            callback(result.map { users -> users.map { it.toStudent() } })
        }
    }
}