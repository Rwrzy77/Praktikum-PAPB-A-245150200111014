package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.repository

import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.model.Student
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.source.StudentLocalDataSource

interface StudentRepository {
    fun getStudents(): List<Student>
    fun getStudentById(id: Int): Student?
}

class DefaultStudentRepository(
    private val dataSource: StudentLocalDataSource
) : StudentRepository {
    override fun getStudents(): List<Student> =
        dataSource.getStudents()

    override fun getStudentById(id: Int): Student? =
        dataSource.getStudentById(id)
}