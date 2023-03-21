package com.example.movie.data.network

import com.example.movie.data.models.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/shows")
    suspend fun getMovies(): Response<List<Movies>>
}