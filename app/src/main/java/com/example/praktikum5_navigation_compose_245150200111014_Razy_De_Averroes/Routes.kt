package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes

object Routes {
    const val HOME = "home"
    const val PROFILE = "profile"

    const val ABOUT = "about"
    const val DETAIL = "detail/{studentId}"

    fun detail(studentId: Int): String = "detail/$studentId"
}