package com.drawnin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainMenuScreen { label ->
                // Navigate to CatalogActivity with the selected label
                val intent = Intent(this, CatalogActivity::class.java)
                intent.putExtra("selectedLabel", label)
                startActivity(intent)
            }
        }
    }
}

@Composable
fun MainMenuScreen(onMenuClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFf1c40f))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuBox("ARTS", R.drawable.arts) { onMenuClick("ARTS") }
            MenuBox("MATH", R.drawable.math) { onMenuClick("MATH") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuBox("MUSIC", R.drawable.music) { onMenuClick("MUSIC") }
            MenuBox("SCIENCE", R.drawable.science) { onMenuClick("SCIENCE") }
        }
    }
}

@Composable
fun MenuBox(label: String, iconResId: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .size(120.dp)
            .background(
                color = Color(0xFF9b59b6),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = label,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}
