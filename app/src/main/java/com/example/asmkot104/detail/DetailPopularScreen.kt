package com.example.asmkot104.detail

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.asmkot104.R
import com.example.asmkot104.ViewModels.CartViewModel
import com.example.asmkot104.ViewModels.FavoriteViewModel
import com.example.asmkot104.ViewModels.PopularViewModel
import com.example.asmkot104.model.Carts
import com.example.asmkot104.model.Favorites
import com.example.asmkot104.model.Populars
import com.example.asmkot104.model.cartItem
import com.example.asmkot104.model.favoriteItem
import com.example.asmkot104.model.popularItem
import com.example.asmkot104.screens.CartScreen
import com.example.asmkot104.screens.TelevisionItem
import java.math.BigDecimal
import java.text.NumberFormat


@SuppressLint("UnrememberedMutableState")
@Composable
fun DetailPopularScreen(
    navController: NavController,
    productId: Int,
    favoriteViewModel: FavoriteViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()
) {

    val context = LocalContext.current
    var soLong by remember { mutableIntStateOf(1) }

    val popular = popularItem.find { it.id == productId } ?: return
    val carts = cartItem.find { it.id == productId } ?: return
    val favorites = favoriteItem.find { it.id == productId } ?: return
    fun calculateTotalAmount(): String {
        return formatPrice(soLong * popular?.price!!)
    }
    if (popular != null) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(verticalAlignment = Alignment.Top) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 30.dp, top = 30.dp)
                            .size(30.dp)
                            .clickable { navController.popBackStack() },
                    )
                    Box(
                        modifier = Modifier
                            .width(400.dp)
                            .height(350.dp)
                            .padding(start = 52.dp)
                            .clip(RoundedCornerShape(bottomStart = 20.dp, topStart = 20.dp)),
                        contentAlignment = Alignment.TopEnd,
                    ) {
                        AsyncImage(
                            model = popular.pic,
                            modifier = Modifier.fillMaxSize(),
                            alignment = Alignment.TopEnd,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = popular.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 31.sp,
                    color = Color(0xff303030),
                    modifier = Modifier.padding(start = 25.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${popular.price}",
                        fontFamily = FontFamily.Serif,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(0.4f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {


                        IconButton(
                            onClick = { soLong += 1 },
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
                        Text(text = "" + soLong)
                        IconButton(
                            onClick = {
                                if (soLong > 1) {
                                    soLong -= 1
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Số lượng không thể nhỏ hơn 1",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                }
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
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total",
                        fontFamily = FontFamily.Serif,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = calculateTotalAmount(),
                        fontFamily = FontFamily.Serif,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        Icons.Default.Star, contentDescription = "",
                        tint = Color(0xffF2C94C)
                    )
                    Text(
                        text = "4.5",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 10.dp, end = 30.dp)
                    )

                    Text(
                        text = "( 50 reviews )",
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.padding(start = 10.dp, end = 30.dp),
                        color = Color(0xff808080)
                    )

                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = popular.description,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(300),
                    lineHeight = 20.sp,
                    color = Color(0xff606060),
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        cartViewModel.addToCart(carts)
                        Toast.makeText(
                            context,
                            "Product added to carts",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp, top = 20.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Add to cart",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        favoriteViewModel.addToFavorite(favorites)
                        Toast.makeText(
                            context,
                            "Product added to favorites",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Add to favorites",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
        }
    } else {
        // Handle the case where the popular item is null (e.g., show an error message or a default screen)
        Text(text = "Product not found", color = Color.Red, modifier = Modifier.padding(16.dp))
    }
}

fun formatPrice(price: Double): String {
    return NumberFormat.getCurrencyInstance().format(BigDecimal(price))
}

