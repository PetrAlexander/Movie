package com.example.movie.data.network

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getMovies() = apiService.getMovies()
}