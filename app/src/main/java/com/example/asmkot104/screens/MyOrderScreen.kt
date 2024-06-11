package com.example.asmkot104.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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

data class Order(
    var id: Int,
    var date: String,
    var quantity: Int,
    var total: Double,
    var status: Int
)

val listOrder = listOf(
    Order(238562312, "20/03/2024", 3, 150.0, 1),
    Order(238562312, "20/03/2024", 3, 150.0, 1),
    Order(238562312, "20/03/2024", 3, 150.0, 1),
    Order(238562312, "20/03/2024", 3, 150.0, 1),
    Order(238562312, "20/03/2024", 3, 150.0, 1),

    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOrderScreen(navController: NavHostController) {
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
                        .clickable { navController.popBackStack() },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = null,
                        tint = Color.Black,
                    )
                }
                Text(
                    text = "MY ORDER",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 25.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(listOrder.size) { index ->
                ItemOrder(index = index)


            }
        }
    }
}

@Composable
fun ItemOrder(index: Int) {
    val order = listOrder[index]
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
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Order No${order.id}",
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(10.dp)
                )

                Text(
                    text = order.date,
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff808080)
                )
            }
            Divider(
                color = Color(0xffF0F0F0),
                thickness = 1.7.dp,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Quantity: ",
                        fontFamily = FontFamily.Serif,
                        color = Color(0xff909090),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = "${order.quantity}",
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Total Amount: ",
                        fontFamily = FontFamily.Serif,
                        color = Color(0xff909090),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = "$${order.total}",
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier.padding(bottom = 10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF242424)
                    )
                ) {
                    Text(text = "Detail")
                }

                Text(
                    text = "Delivered",
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff27AE60),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MyOrderScreenPreview() {
    MyOrderScreen(navController = rememberNavController())
}