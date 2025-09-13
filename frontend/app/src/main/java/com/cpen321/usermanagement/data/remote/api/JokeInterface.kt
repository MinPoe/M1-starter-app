package com.cpen321.usermanagement.data.remote.api

import com.cpen321.usermanagement.data.remote.dto.JokeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface JokeInterface {
    @GET("/")
    suspend fun getRandomJoke(
        @Header("Accept") accept: String = "application/json",
    ): Response<JokeResponse>
}