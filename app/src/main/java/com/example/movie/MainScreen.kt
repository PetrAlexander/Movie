package com.example.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.movie.data.models.Movies

@Composable
fun MainScreen(viewModel: MainViewModel) {
    viewModel.getAllMovies()
    val movies = viewModel.movies.observeAsState(listOf()).value
    Surface {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(movies.take(10)) { item ->
                MovieItem(item = item)
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieItem(item: Movies) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = item.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = rememberImagePainter(item.image.medium),
                contentDescription = "Film poster",
                modifier = Modifier
                    .size(256.dp)
                    .padding(vertical = 3.dp)
            )
            Text(
                text = "Rating: ${item.rating.average}",
                fontSize = 24.sp
            )
        }
    }
}