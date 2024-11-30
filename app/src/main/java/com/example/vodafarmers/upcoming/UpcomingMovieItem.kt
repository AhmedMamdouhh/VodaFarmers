package com.example.vodafarmers.upcoming

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vodafarmers.R
import com.example.vodafarmers.ui.theme.VodaFarmersTheme
import com.example.vodafarmers.ui.theme.onPrimaryLight
import com.example.vodafarmers.ui.theme.scrimLight

@Composable
fun UpcomingMoviePoster(
    imageResource: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp)
) {
    Image(
        painter = painterResource(imageResource),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(shape)
    )
}

@Composable
fun UpcomingMovieDetails(
    title: String,
    date: String,
    titleStyle: TextStyle = MaterialTheme.typography.headlineMedium,
    dateStyle: TextStyle = MaterialTheme.typography.labelSmall,
    titleColor: Color = Color.Unspecified,
    dateColor: Color = Color.Unspecified,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(horizontal = 8.dp)) {
        Text(text = title, style = titleStyle, color = titleColor)
        Text(text = date, style = dateStyle, color = dateColor)
    }
}

@Composable
fun UpcomingMoviesItem(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        UpcomingMoviePoster(
            imageResource = R.drawable.moonlight,
            contentDescription = "Upcoming Movie Poster",
            modifier = Modifier.size(100.dp)
        )

        UpcomingMovieDetails(
            title = "Moonlight",
            date = "Fri 1 Nov, 2020"
        )

    }
}

@Composable
fun UpcomingMoviesHomeItem(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        UpcomingMoviePoster(
            imageResource = R.drawable.moonlight,
            contentDescription = "Upcoming Movie Poster",
            modifier = Modifier.height(250.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer { alpha = 0.9f }
                .background(
                    Brush.verticalGradient(
                        colors = listOf(scrimLight, Color.Transparent),
                        startY = 500.dp.value,
                        endY = 0.dp.value
                    )
                )
        )

        Box(
            modifier = Modifier
                .matchParentSize()
        ) {
            UpcomingMovieDetails(
                title = "Moonlight",
                date = "Fri 1 Nov, 2020",
                titleColor = onPrimaryLight,
                dateColor = onPrimaryLight,
                modifier = Modifier.align(Alignment.BottomStart)
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun UpcomingMovieItemScreenPreview() {
    VodaFarmersTheme {
        Surface {
            UpcomingMoviesHomeItem()
        }
    }
}

