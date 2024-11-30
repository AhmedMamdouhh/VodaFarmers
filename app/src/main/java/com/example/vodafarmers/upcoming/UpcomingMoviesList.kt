package com.example.vodafarmers.upcoming

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vodafarmers.ui.theme.VodaFarmersTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpcomingMoviesList(modifier: Modifier = Modifier) {
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    val movies = getDummyMovies()
    Column {
        Row(
            modifier = modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Upcoming Movies",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            TextButton(
                onClick = { isBottomSheetVisible = true },
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("View all")
            }

        }

        LazyRow {
            items(movies) { _ ->
                UpcomingMoviesHomeItem(modifier = Modifier.padding(8.dp))
            }
        }

        if (isBottomSheetVisible) {
            ModalBottomSheet(
                onDismissRequest = { isBottomSheetVisible = false }
            ) {
                LazyColumn {
                    items(movies) { _ ->
                        UpcomingMoviesItem(modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }

    }
}

private fun getDummyMovies(): List<String> {
    return listOf(
        "The Silent Echo",
        "Chasing Shadows",
        "Whispers of Time",
        "Beyond the Horizon",
        "The Forgotten Journey",
        "Mirage of Dreams",
        "Eclipsed by Fate",
        "Labyrinth of Lies",
        "Resonance of the Heart",
        "Fragments of Tomorrow"
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun UpcomingMoviesListScreenPreview() {
    VodaFarmersTheme {
        Surface {
            UpcomingMoviesList()
        }
    }
}