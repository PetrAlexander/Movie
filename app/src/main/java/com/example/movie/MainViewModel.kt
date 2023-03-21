package com.example.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.data.models.Movies
import com.example.movie.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {
    private val _movies = MutableLiveData<List<Movies>>()
    val movies: LiveData<List<Movies>>
        get() = _movies

    fun getAllMovies() {
        viewModelScope.launch {
            apiRepository.getMovies().let {
                if (it.isSuccessful) {
                    _movies.postValue(it.body())
                } else {
                    Log.d("MainViewModel", "Error ${it.errorBody()}")
                }
            }
        }
    }
}