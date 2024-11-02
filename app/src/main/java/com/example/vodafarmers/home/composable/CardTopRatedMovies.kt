package com.example.vodafarmers.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.vodafarmers.ui.theme.VodaFarmersTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTopRatedMovies(
    modifier: Modifier = Modifier,
    movieName: String,
    ratedStarts: Float,
    movieImageUrl: String,
    releaseDate: String,
    onClickMovie: () -> Unit,
    movieHeight: Dp = 140.dp,
    movieWidth: Dp = 120.dp,
    shape: RoundedCornerShape = RoundedCornerShape(16.dp)
) {
    Card(
        modifier = modifier
            .width(movieWidth)
            .height(movieHeight),
        shape = shape,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        onClick = onClickMovie
    ) {
        Box {
            ImageNetwork(
                modifier = Modifier.fillMaxSize(),
                imageUrl = movieImageUrl
            )
            BoxOverlay()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(
                    text = movieName,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
                RowStarsRating(rating = ratedStarts, startSize = 14.dp)
                Text(
                    text = releaseDate,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
    }
}

@Composable
@Preview
fun TopRatedMovieScreenPreview() {
    VodaFarmersTheme {
        CardTopRatedMovies(
            releaseDate = "2021-8-11",
            ratedStarts = 4.5f,
            onClickMovie = {},
            movieImageUrl = "https://upload.wikimedia.org/wikipedia/en/9/94/John_Wick_Chapter_3_Parabellum.png",
            movieName = "John Wick Chapter 3"
        )
    }
}