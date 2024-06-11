package com.example.asmkot104.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.asmkot104.R
import com.example.asmkot104.screens.ChairItem

@Composable
fun DetailChairScreen(
    navControl: NavHostController,
    chairId: Int
) {
    // Navigate back when the back button is clicked
    val chair = ChairItem.find { it.id == chairId } ?: return
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navControl.popBackStack() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = "Back",
                    tint = Color.Black,
                )
            }
            Text(
                text = chair.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 25.sp,
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.weight(1f)
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        // Display bed details
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(chair.pic),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(200.dp)
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Price: $${chair.price}", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Description: ${chair.description}", fontSize = 16.sp)
        }
    }
}