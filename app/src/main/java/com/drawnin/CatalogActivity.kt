package com.drawnin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.drawnin.ui.theme.DrawnInTheme

class CatalogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Retrieve the passed label from Intent
        val selectedLabel = intent.getStringExtra("selectedLabel") ?: "Unknown"

        setContent {
            DrawnInTheme {
                GreetingScreen(selectedLabel)
            }
        }
    }
}

@Composable
fun GreetingScreen(label: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome to $label!",
            fontSize = 24.sp
        )
    }
}
