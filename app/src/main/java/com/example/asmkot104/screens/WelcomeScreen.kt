package com.example.asmkot104.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.asmkot104.R
import com.example.asmkot104.ui.theme.AsmKOT104Theme


@Composable
fun WelcomeScreen(
    navController: NavHostController
) {
    Box() {
        //Background Image
        Image(

            painter = painterResource(id = R.drawable.banner),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        //Context
        Column(
            modifier = Modifier.padding(top = 220.dp)
        ) {
            Text(
                text = "MAKE YOUR",
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF606060),
                lineHeight = 30.sp,
                modifier = Modifier.padding(start = 30.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "HOME BEAUTIFUL",
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF303030),
                lineHeight = 38.sp,
                modifier = Modifier.padding(start = 30.dp)
            )
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                fontSize = 18.sp,
                fontWeight = FontWeight(300),
                color = Color(0xFF808080),
                lineHeight = 35.sp,
                modifier = Modifier
                    .padding(start = 70.dp, end = 40.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(200.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row {
                    Button(
                        onClick = { navController.navigate("login") },
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF303030),
                        ),
                        modifier = Modifier
                            .width(150.dp)
                            .height(40.dp)
                    ) {
                        Text(text = "Login")
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    Button(
                        onClick = { navController.navigate("signup") },
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF303030),
                        ),
                        modifier = Modifier
                            .width(150.dp)
                            .height(40.dp)
                    ) {
                        Text(text = "Sign Up")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    AsmKOT104Theme {
        WelcomeScreen(navController = rememberNavController())
    }
}