package com.drawnin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.drawnin.R

@Composable
fun MainMenuScreen(navController: NavHostController) {
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
            MenuBox("ARTS", R.drawable.arts) { navController.navigate("catalog/ARTS") }
            MenuBox("MATH", R.drawable.math) { navController.navigate("catalog/MATH") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuBox("MUSIC", R.drawable.music) { navController.navigate("catalog/MUSIC") }
            MenuBox("SCIENCE", R.drawable.science) { navController.navigate("catalog/SCIENCE") }
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
                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        androidx.compose.foundation.Image(
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
