package com.example.vodafarmers.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vodafarmers.home.composable.CardTopRatedMovies
import com.example.vodafarmers.home.composable.RowMoviesHeader
import com.example.vodafarmers.ui.theme.VodaFarmersTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Put your home screen content here.
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        RowMoviesHeader(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            title = "Top Rated",
            onClickViewAll = {}
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            items(15) { dayTime ->
                CardTopRatedMovies(
                    releaseDate = "2021-8-11",
                    ratedStarts = 4.5f,
                    onClickMovie = {},
                    movieImageUrl = "https://upload.wikimedia.org/wikipedia/en/9/94/John_Wick_Chapter_3_Parabellum.png",
                    movieName = "John Wick Chapter 3"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HomeScreenPreview() {
    VodaFarmersTheme {
        Surface {
            HomeScreen()
        }
    }
}