package com.example.asmkot104.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.asmkot104.R
import com.example.asmkot104.ui.navigation.Screen
import com.example.asmkot104.ui.theme.AsmKOT104Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethodScreen(navControl: NavHostController) {
    var selectedOption by remember { mutableIntStateOf(1) }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { navControl.popBackStack() },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = null,

                        )
                }
                Text(
                    text = "PAYMENT METHOD",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 25.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navControl.navigate(Screen.AddPaymentMethod.route)
                },
                containerColor = Color.White,
                shape = CircleShape
            ) {
                Icon(Icons.Default.Add, contentDescription = "")

            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(0.9f),
                contentScale = ContentScale.FillWidth,
                painter =
                painterResource(id = if (selectedOption == 1) R.drawable.payment_card_true else R.drawable.payment_card_false),
                contentDescription = null
            )
            SquareRadioButton(
                selected = selectedOption == 1,
                onClick = { selectedOption = 1 }, "Use as default payment method"
            )
            Image(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth(0.9f),
                contentScale = ContentScale.FillWidth,
                painter =
                painterResource(id = if (selectedOption == 2) R.drawable.payment_card_true else R.drawable.payment_card_false),
                contentDescription = null
            )
            SquareRadioButton(
                selected = selectedOption == 2,
                onClick = { selectedOption = 2 },
                "Use as default payment method"
            )


        }


    }
}

@Composable
fun SquareRadioButton(selected: Boolean, onClick: () -> Unit, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onClick() }
            .padding(top = 30.dp)
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .padding(4.dp)
                .border(1.dp, Color.Black)
                .clickable { onClick() }
                .background(if (selected) Color.Black else Color.White),
            contentAlignment = Alignment.Center
        ) {
            if (selected) {
                Canvas(modifier = Modifier.size(24.dp)) {
                    scale(0.8f) {
                        drawLine(
                            color = Color.White,
                            start = Offset(size.width * 0.2f, size.height * 0.5f),
                            end = Offset(size.width * 0.4f, size.height * 0.7f),
                            strokeWidth = 3f
                        )
                        drawLine(
                            color = Color.White,
                            start = Offset(size.width * 0.4f, size.height * 0.7f),
                            end = Offset(size.width * 0.8f, size.height * 0.3f),
                            strokeWidth = 3f
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            color = if (selected) Color.Black else Color(0xff999999)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentMethodScreenPreview() {
    AsmKOT104Theme {
        PaymentMethodScreen(
            navControl = rememberNavController(),
        )
    }
}