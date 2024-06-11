package com.example.asmkot104.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import coil.compose.AsyncImage
import com.example.asmkot104.R
import com.example.asmkot104.ViewModels.CartViewModel
import com.example.asmkot104.detail.formatPrice
import com.example.asmkot104.model.Carts


@SuppressLint("AutoboxingStateCreation")
@Composable
fun CartScreen(navControl: NavHostController, cartViewModel: CartViewModel) {
    val cartItems by cartViewModel.carts.observeAsState(emptyList())
    var totalPrice by remember { mutableStateOf(calculateSubTotal(cartItems)) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
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
                    text = "MY CART",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 25.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF303030),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            CartList(
                navControl = navControl,
                cartItems,
                cartViewModel,
                onItemQuantityChange = { totalPrice = calculateSubTotal(cartItems) })
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 35.dp, end = 35.dp)
            ) {
                Text(
                    text = "Total:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xff808080)
                )
                Text(
                    text = formatPrice(totalPrice),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xff303030)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { navControl.navigate("checkOutScreen") },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 25.dp, end = 25.dp)
            ) {
                Text(text = "Check Out", color = Color.White)
            }
        }
    }
}

fun calculateSubTotal(cartItems: List<Carts>): Double {
    return cartItems.sumOf { it.price * it.quantity }
}

@Composable
fun CartList(
    navControl: NavHostController,
    cartItems: List<Carts>,
    cartViewModel: CartViewModel,
    onItemQuantityChange: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(cartItems.size) { cart ->
            CartItem(
                navControl = navControl,
                carts = cartItems[cart],
                cartViewModel,
                onItemQuantityChange = onItemQuantityChange
            )
        }
    }
}

@Composable
fun calculateTotalAmount(carts: Carts): String {
    return formatPrice(carts.price * carts.quantity)
}

@SuppressLint("Range")
@Composable
fun CartItem(
    navControl: NavHostController,
    carts: Carts,
    cartViewModel: CartViewModel,
    onItemQuantityChange: () -> Unit
) {
    val context = LocalContext.current
    var quantity by remember { mutableIntStateOf(carts.quantity) }
//    fun calculateTotalAmount(): String {
//        return formatPrice(quantity * carts.price)
//    }
//    fun calculateTotalAmount(): String {
//        return formatPrice(soLong.value * carts?.price!!)
//    }
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(width = 400.dp, height = 130.dp)
            .padding(bottom = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1))
    ) {
        Row(
            modifier = Modifier
                .size(width = 380.dp, height = 130.dp)
        ) {
            AsyncImage(
                model = carts.pic,
                modifier = Modifier
                    .height(130.dp)
                    .width(130.dp)
                    .clip(RoundedCornerShape(15)),
                contentDescription = null,
                contentScale = ContentScale.Crop,

                )
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 5.dp, horizontal = 10.dp)
            ) {
                Text(
                    text = carts.title,
                    color = Color(0xff606060),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "${carts.price}",
                    color = Color(0xff303030),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(2f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(0.4f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconButton(
                            onClick = {
                                cartViewModel.increaseFoodCount(carts)
                                onItemQuantityChange()
                            },
                            modifier = Modifier
                                .background(Color(0xffffffff), shape = RoundedCornerShape(5.dp))
                                .size(30.dp),

                            ) {
                            Icon(
                                painter = painterResource(id = R.drawable.plus),
                                contentDescription = "",
                                Modifier.size(24.dp)
                            )
                        }
                        Text(text = "${carts.quantity}")
                        IconButton(
                            onClick = {
                                cartViewModel.decreaseFoodCount(carts)
                                onItemQuantityChange()
                            },
                            modifier = Modifier
                                .background(Color(0xffffffff), shape = RoundedCornerShape(5.dp))
                                .size(30.dp),

                            ) {
                            Icon(
                                painter = painterResource(id = R.drawable.minus),
                                contentDescription = "",
                                Modifier.size(24.dp)
                            )
                        }
                    }
                    Text(
                        text = calculateTotalAmount(carts),
                        fontFamily = FontFamily.Serif,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                }
            }
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.padding(end = 10.dp, top = 10.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.TopEnd)
                        .clickable {
                            cartViewModel.removeFromCart(carts)
                            Toast
                                .makeText(context, "Removed from cart", Toast.LENGTH_SHORT)
                                .show()
                        },
                    contentDescription = null,
                    painter = painterResource(id = R.drawable.cancel),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CartScreenPreview() {
    CartScreen(navControl = rememberNavController(), cartViewModel = CartViewModel())
}
