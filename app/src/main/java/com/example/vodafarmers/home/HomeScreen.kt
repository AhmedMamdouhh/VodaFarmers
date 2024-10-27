package com.example.vodafarmers.home

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vodafarmers.ui.theme.VodaFarmersTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Put your home screen content here.
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