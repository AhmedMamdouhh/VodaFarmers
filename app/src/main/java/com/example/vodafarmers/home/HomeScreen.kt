package com.example.vodafarmers.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vodafarmers.R
import com.example.vodafarmers.ui.theme.VodaFarmersTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        TrendingMoviesSection(
            onViewAllClicked = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun TrendingMoviesSection(
    onViewAllClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        TrendingMoviesHeader(onViewAllClicked)
        TrendingMoviesList()
    }
}

@Composable
fun TrendingMoviesHeader(
    onViewAllClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.trending_movies_section_title),
            style = MaterialTheme.typography.titleLarge,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(12.dp)
                .weight(1f)
        )
        TextButton(onClick = onViewAllClicked) {
            Text(stringResource(R.string.view_all))
        }
    }
}

@Composable
fun TrendingMoviesList(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(12.dp),
        modifier = modifier.height(200.dp)
    ) {
        items(10) {
            TrendingMovieCard(Modifier.fillParentMaxWidth(0.9f))
        }
    }
}

@Composable
fun TrendingMovieCard(modifier: Modifier = Modifier) {
    Card(modifier) {
        Box {
            Image(
                painter = painterResource(R.drawable.placeholder_movie),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.BottomStart)
            ) {
                MovieInfoText(
                    text = "Journey to the center",
                    textStyle = MaterialTheme.typography.titleMedium
                )
                MovieInfoText(
                    text = "2024",
                    textStyle = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}

@Composable
fun MovieInfoText(
    text: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = textStyle.copy(
            color = MaterialTheme.colorScheme.inverseOnSurface
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.inverseSurface.copy(alpha = 0.9f)
            )
            .padding(4.dp)
    )
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