package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.remote

import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.remote.dto.UserDto
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.remote.dto.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StudentApiService {

//    @GET("users")
//    fun getUsers(
//        @Query("limit") limit: Int = 10
//    ): Call<UserResponse>
//
//    @GET("users/{id}")
//    fun getUser(
//        @Path("id") id: Int
//    ): Call<UserDto>
//
//    @GET("users/search")
//    fun searchUsers(
//        @Query("q") query: String
//    ): Call<UserResponse>

    @GET("users")
    suspend fun getUsers(
        @Query("limit") limit: Int = 10
    ): UserResponse

    @GET("users/{id}")
    suspend fun getUser(
        @Path("id") id: Int
    ): UserDto

    @GET("users/search")
    suspend fun searchUsers(
        @Query("q") query: String
    ): UserResponse

}

