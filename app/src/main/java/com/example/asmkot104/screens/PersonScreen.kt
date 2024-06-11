package com.example.asmkot104.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.asmkot104.R
import com.example.asmkot104.ui.navigation.Screen
import com.example.asmkot104.ui.person.ItemMyOrders
import com.example.asmkot104.ui.person.ItemMyReviews
import com.example.asmkot104.ui.person.ItemPaymentMethod
import com.example.asmkot104.ui.person.ItemSetting
import com.example.asmkot104.ui.person.ItemShippingAddresses
import com.google.firebase.auth.FirebaseAuth

@Composable
fun PersonScreen(navController: NavController) {
    val context = LocalContext.current
    val mAuth = remember { FirebaseAuth.getInstance() }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "PROFILE",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 25.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f),
            )
            Surface(
                modifier = Modifier
                    .size(30.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .align(Alignment.CenterVertically)
                    .clickable {
                        mAuth.signOut()
                        val message = if (mAuth.currentUser == null) {
                            "Đăng xuất thành công"
                        } else {
                            "Đăng xuất thất bại. Không có người dùng đang đăng nhập"
                        }
                        Toast
                            .makeText(context, message, Toast.LENGTH_SHORT)
                            .show()
                        navController.navigate("welcome")
                    },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = null,
                    tint = Color.Black,
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(20.dp)
                .height(100.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img6),
                contentDescription = null,
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp),

                )
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Bruno Pham",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 27.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF303030),

                    )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "bruno203@gmail.com",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 15.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF808080),
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Card(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .size(width = 350.dp, height = 80.dp)
                        .clickable { navController.navigate("myOrderScreen") },
                    colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1)),
                ) {
                    Row(
                        modifier = Modifier
                            .size(width = 335.dp, height = 80.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                                .padding(start = 15.dp),
                        ) {
                            Text(
                                text = "My orders",
                                color = Color(0xff303030),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(700)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "Already have 10 orders",
                                color = Color(0xff606060),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
                Card(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .size(width = 350.dp, height = 80.dp)
                        .clickable { navController.navigate("shippingAddressScreen") },
                    colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1)),
                ) {
                    Row(
                        modifier = Modifier
                            .size(width = 335.dp, height = 80.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                                .padding(start = 15.dp),
                        ) {
                            Text(
                                text = "Shipping addresses",
                                color = Color(0xff303030),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(700)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "03 Addresses",
                                color = Color(0xff606060),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
                Card(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .size(width = 350.dp, height = 80.dp)
                        .clickable { navController.navigate("payMethod") },
                    colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1)),
                ) {
                    Row(
                        modifier = Modifier
                            .size(width = 335.dp, height = 80.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                                .padding(start = 15.dp),
                        ) {
                            Text(
                                text = "Payment Method",
                                color = Color(0xff303030),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(700)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "You have 2 cards",
                                color = Color(0xff606060),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
                Card(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .size(width = 350.dp, height = 80.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1)),
                ) {
                    Row(
                        modifier = Modifier
                            .size(width = 335.dp, height = 80.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                                .padding(start = 15.dp),
                        ) {
                            Text(
                                text = "My Reviews",
                                color = Color(0xff303030),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(700)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "Reviews for 5 items",
                                color = Color(0xff606060),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
                Card(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .size(width = 350.dp, height = 80.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1)),
                ) {
                    Row(
                        modifier = Modifier
                            .size(width = 335.dp, height = 80.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                                .padding(start = 15.dp),
                        ) {
                            Text(
                                text = "Setting",
                                color = Color(0xff303030),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(700)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "Notification, Password, FAQ, Contact",
                                color = Color(0xff606060),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                            )
                        }
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun PersonScreenPreview() {
    PersonScreen(navController = rememberNavController())
}