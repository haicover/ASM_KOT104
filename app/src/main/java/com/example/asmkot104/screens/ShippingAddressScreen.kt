package com.example.asmkot104.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShippingAddressScreen(navControl: NavHostController) {
    var selectedOption by remember { mutableIntStateOf(1) }
    val context = LocalContext.current
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
                        .clip(RoundedCornerShape(5.dp))
                        .clickable { navControl.popBackStack() },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = null,
                        tint = Color.Black,
                    )
                }
                Text(
                    text = "SHIPPING ADDRESS",
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
                onClick = {  Toast.makeText(
                    context,
                    "Không thêm được nữa",
                    Toast.LENGTH_SHORT
                ).show()},
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
//            CartSection(navControl)
            SquareRadioButton(
                selected = selectedOption == 1,
                onClick = { selectedOption = 1 }, "Use as the shipping address"
            )
            ShippingAddressTemp("Nguyễn Hải", "Gia Viễn, Ninh Bình")

            SquareRadioButton(
                selected = selectedOption == 2,
                onClick = { selectedOption = 2 },
                "Use as the shipping address"
            )
            ShippingAddressTemp(" Nguyễn Hưng", " Gia Viễn")

            SquareRadioButton(
                selected = selectedOption == 3,
                onClick = { selectedOption = 3 },
                "Use as the shipping address"
            )
            ShippingAddressTemp(" Nguyễn Hảo", "  Ninh Bình")
        }
    }
}

@Composable
fun ShippingAddressTemp(name: String, address: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxWidth()
            .background(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(5.dp),

        )
    {
        Column(
            modifier = Modifier

                .fillMaxWidth()
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = name,
                    fontFamily = FontFamily.Serif,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(10.dp)
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Outlined.Edit, contentDescription = null)
                }
            }
            Divider(
                color = Color(0xffF0F0F0),
                thickness = 1.7.dp,
            )
            Text(
                text = address,
                fontFamily = FontFamily.Serif,
                color = Color(0xff909090),
                fontSize = 17.sp,
                modifier = Modifier.padding(10.dp)
            )
        }

    }
}

@Composable
@Preview(showBackground = true)
fun ShippingAddressScreenPreview() {
    ShippingAddressScreen(navControl = rememberNavController())
}