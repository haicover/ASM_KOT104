package com.example.asmkot104.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.asmkot104.R

@Composable
fun SuccessScreen(navControl: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Success!",
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp,
            fontWeight = FontWeight(600),
            modifier = Modifier.padding(bottom = 30.dp)
        )
        Image(painter = painterResource(id = R.drawable.success), contentDescription = "",
            modifier = Modifier.fillMaxWidth(0.9f), contentScale = ContentScale.FillWidth)

        Text(text = "Your order will be delivered soon.\n" +
                "Thank you for choosing our app!",
            fontFamily = FontFamily.Serif,
            fontSize = 18.sp,
            color = Color(0xff606060),
            modifier = Modifier.padding(top = 30.dp)
        )

        OutlinedButton(
            onClick = {
                navControl.navigate("bottom") {
                    popUpTo(navControl.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.81f),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Transparent
            ),
            border = BorderStroke(1.dp, Color(0xFF303030))
        ) {
            Text(text = "BACK TO HOME",
                Modifier.padding(8.dp),
                fontSize = 18.sp,
                color = Color(0xFF303030))
        }

    }
}