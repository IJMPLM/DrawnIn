package com.drawnin.screens

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.drawnin.R

@Composable
fun MainMenuScreen(navController: NavHostController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFf1c40f))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Centered header text
        Text(
            text = "Drawn In",
            color = Color.Black,
            fontSize = 150.sp, // Increased font size
            fontFamily = FontFamily(Font(R.font.mainmenufont)),
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, // Bold styling
            textAlign = TextAlign.Center,
            lineHeight = 100.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

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
        Button(
            onClick = { (context as? Activity)?.finishAffinity() },
            modifier = Modifier
                .padding(top = 24.dp)
        ) {
            Text(
                text = "QUIT",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun MenuBox(label: String, iconResId: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .size(140.dp) // Increased size of the entire clickable area
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
            modifier = Modifier.size(80.dp) // Adjusted icon size to fit within the new box size
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
