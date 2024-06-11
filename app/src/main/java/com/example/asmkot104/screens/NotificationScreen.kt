package com.example.asmkot104.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import coil.compose.AsyncImage
import com.example.asmkot104.R
import com.example.asmkot104.ui.navigation.Screen

@Composable
fun NotificationScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 26.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Notification",
                color = Color(0xFF303030),
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Box(modifier = Modifier
                .clickable { }
                .fillMaxSize()
                .background(color = Color(0xffF5F5F5))) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img2),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                    Column(modifier = Modifier.padding(start = 5.dp)) {
                        Text(
                            text = "Your order #123456789 has been confirmed",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xff242424)
                        )
                        Text(
                            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
                            color = Color(0xff808080),
                            fontSize = 11.sp
                        )
                        Text(
                            text = "New",
                            modifier = Modifier.align(Alignment.End),
                            color = Color(0xff27AE60),
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }
            }
            Box(modifier = Modifier
                .clickable { }
                .fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img1),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                    Column(modifier = Modifier.padding(start = 5.dp)) {
                        Text(
                            text = "Your order #123456789 has been canceled",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xff242424)
                        )
                        Text(
                            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
                            color = Color(0xff808080),
                            fontSize = 11.sp
                        )
                    }
                }
            }
            Box(modifier = Modifier
                .clickable { }
                .fillMaxSize()
                .background(color = Color(0xffF5F5F5))) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(10.dp)
                ) {
                    Column(modifier = Modifier.padding(start = 5.dp)) {
                        Text(
                            text = "Discover hot sale furnitures this week.",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xff242424)
                        )
                        Text(
                            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
                            color = Color(0xff808080),
                            fontSize = 12.sp
                        )
                        Text(
                            text = "Hot!".toUpperCase(),
                            modifier = Modifier.align(Alignment.End),
                            color = Color(0xffEB5757),
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }
            }
            Box(modifier = Modifier
                .clickable { }
                .fillMaxSize()) {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img2),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(5.dp))
                        )
                        Column(modifier = Modifier.padding(start = 5.dp)) {
                            Text(
                                text = "Your order #123456789 has been shipped successfully",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xff242424)
                            )
                            Text(
                                text = "Please help us to confirm and rate your order to get 10% discount code for next order.",
                                color = Color(0xff808080),
                                fontSize = 11.sp
                            )
                        }
                    }
                    Divider(modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 5.dp))
                }
            }
            Box(modifier = Modifier
                .clickable { }
                .fillMaxSize()) {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img2),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(5.dp))
                        )
                        Column(modifier = Modifier.padding(start = 5.dp)) {
                            Text(
                                text = "Your order #123456789 has been confirmed",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xff242424)
                            )
                            Text(
                                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
                                color = Color(0xff808080),
                                fontSize = 11.sp
                            )
                        }
                    }
                    Divider(modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 5.dp))
                }
            }
            Box(modifier = Modifier
                .clickable { }
                .fillMaxSize()) {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img4),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(5.dp))
                        )
                        Column(modifier = Modifier.padding(start = 5.dp)) {
                            Text(
                                text = "Your order #123456789 has been canceled",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xff242424)
                            )
                            Text(
                                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
                                color = Color(0xff808080),
                                fontSize = 11.sp
                            )
                        }
                    }
                    Divider(modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 5.dp))
                }
            }
            Box(modifier = Modifier
                .clickable { }
                .fillMaxSize()) {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img4),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(5.dp))
                        )
                        Column(modifier = Modifier.padding(start = 5.dp)) {
                            Text(
                                text = "Your order #123456789 has been shipped successfully",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xff242424)
                            )
                            Text(
                                text = "Please help us to confirm and rate your order to get 10% discount code for next order.",
                                color = Color(0xff808080),
                                fontSize = 11.sp
                            )
                        }
                    }
                    Divider(modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 5.dp))
                }
            }
            Box(modifier = Modifier
                .clickable { }
                .fillMaxSize()) {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img4),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(5.dp))
                        )
                        Column(modifier = Modifier.padding(start = 5.dp)) {
                            Text(
                                text = "Your order #123456789 has been shipped successfully",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xff242424)
                            )
                            Text(
                                text = "Please help us to confirm and rate your order to get 10% discount code for next order.",
                                color = Color(0xff808080),
                                fontSize = 11.sp
                            )
                        }
                    }
                    Divider(modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 5.dp))
                }
            }
            Box(modifier = Modifier
                .clickable { }
                .fillMaxSize()) {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img2),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(5.dp))
                        )
                        Column(modifier = Modifier.padding(start = 5.dp)) {
                            Text(
                                text = "Your order #123456789 has been shipped successfully",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xff242424)
                            )
                            Text(
                                text = "Please help us to confirm and rate your order to get 10% discount code for next order.",
                                color = Color(0xff808080),
                                fontSize = 11.sp
                            )
                        }
                    }
                    Divider(modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 5.dp))
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NotificationScreenPreview() {
    NotificationScreen(navController = rememberNavController())
}