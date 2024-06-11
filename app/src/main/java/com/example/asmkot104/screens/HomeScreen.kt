package com.example.asmkot104.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.asmkot104.R
import com.example.asmkot104.model.Categories
import com.example.asmkot104.model.Populars
import com.example.asmkot104.model.categoriesItem
import com.example.asmkot104.model.popularItem
import com.example.asmkot104.ui.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    var filteredProducts by remember { mutableStateOf(popularItem) }
    var filteredCategories by remember { mutableStateOf(categoriesItem) }

    LaunchedEffect(searchQuery) {
        val query = searchQuery
        filteredProducts = if (query.isEmpty()) {
            popularItem
        } else {
            popularItem.filter { it.title.contains(searchQuery, ignoreCase = true) }
        }
        filteredCategories = if (query.isEmpty()) {
            categoriesItem
        } else {
            categoriesItem.filter { it.title.contains(query, ignoreCase = true) }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(3f)
            ) {
                Text(
                    text = "Make home",
                    fontSize = 18.sp,
                    lineHeight = 25.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF909090),
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "BEAUTIFUL",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 25.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF303030),
                )
            }
            Surface(
                modifier = Modifier
                    .size(30.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .align(Alignment.CenterVertically)
                    .clickable { navController.navigate(Screen.CartScreen.route) },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = null,
                    tint = Color.Black,
                )
            }
        }
        Box(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search.....") },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.Black
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search,
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        CategoriesList(categoriesList = filteredCategories, navControl = navController)
        PopularList(navController, filteredProducts = filteredProducts)
    }
}

@Composable
fun CategoriesList(navControl: NavHostController, categoriesList: List<Categories>) {
    var selectedIndex by remember { mutableIntStateOf(-1) }
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .background(Color(0xfffffff))
            .padding(10.dp),
    ) {
        categoriesList.forEachIndexed { index, category ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .clickable {
                        navigateToCategory(navControl, category)
                    }
            ) {
                Surface(
                    modifier = Modifier
                        .size(55.dp)
                        .padding(bottom = 4.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    color = if (selectedIndex == index) Color.LightGray else Color(0xfff5f5f5)
                ) {
                    Icon(
                        painter = painterResource(id = category.pic),
                        contentDescription = category.title,
                        tint = Color(0xff999999),
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .padding(10.dp)
                            .size(width = 23.dp, height = 23.dp)
                    )
                }
                Text(
                    text = category.title,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = if (selectedIndex == index) Color.Black else Color(0xff999999),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                )
            }
        }
    }
}

@Composable
fun PopularList(
    navControl: NavHostController,
    filteredProducts: List<Populars>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 45.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(filteredProducts.size) { index ->
            PopularItem(navControl, populars = filteredProducts[index])
        }
    }
}

@Composable
fun PopularItem(
    navControl: NavHostController,
    populars: Populars,
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(width = 157.dp, height = 260.dp)
            .padding(8.dp)
            .clickable {
                navControl.navigate("detail/${populars.id}")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xfff1f1f1))
    ) {
        Column {
            Box {
                AsyncImage(
                    model = populars.pic,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Image(
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .clickable { navControl.navigate(Screen.CartScreen.route) }
                        .background(Color(0xff909090)),
                    contentDescription = null,
                    painter = painterResource(id = R.drawable.frame),
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)) {
                Text(
                    text = populars.title,
                    color = Color(0xff606060),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "$ ${populars.price}",
                    color = Color(0xff303030),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}



