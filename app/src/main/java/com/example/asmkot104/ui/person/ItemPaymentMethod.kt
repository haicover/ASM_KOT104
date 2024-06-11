package com.example.asmkot104.ui.person

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ItemPaymentMethod(navControl: NavHostController) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(width = 350.dp, height = 80.dp)
            .clickable { navControl.navigate("payMethod") },
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
}

@Composable
@Preview(showBackground = true)
fun ItemPaymentMethodPreview() {
    ItemPaymentMethod(navControl = rememberNavController())
}