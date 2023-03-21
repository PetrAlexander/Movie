package com.example.movie.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.movie.MainViewModel
import com.example.movie.data.models.Movies


@Composable
fun MainScreen(viewModel: MainViewModel) {
    viewModel.getAllMovies()
    val movies = viewModel.movies.observeAsState(listOf()).value
    movies.forEach { Log.d("MainScreen", "Name: ${it.name}") }
    Surface() {
        LazyColumn {
            items(movies.take(10)) { item ->
                MovieItem(item = item)
            }
        }
    }
}

@Composable
fun MovieItem(item: Movies) {
    Row {
        Text(text = item.name)
    }
}