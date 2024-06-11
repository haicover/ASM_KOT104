package com.example.asmkot104.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.asmkot104.ViewModels.CartViewModel
import com.example.asmkot104.ViewModels.FavoriteViewModel
import com.example.asmkot104.screens.FavoriteScreen
import com.example.asmkot104.screens.HomeScreen
import com.example.asmkot104.screens.NotificationScreen
import com.example.asmkot104.screens.PersonScreen
import com.example.asmkot104.ui.theme.AsmKOT104Theme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        MyBottomAppBar(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar(navController: NavHostController) {
    val context = LocalContext.current.applicationContext
    val navigationController = rememberNavController()
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.shadow(8.dp, shape = RoundedCornerShape(10.dp)),
                containerColor = Color(0xFFFFFFFF)
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navigationController.navigate(Screen.HomeScreen.route) {
                            popUpTo(0)

                        }
                    },
                    modifier = Modifier.weight(1f)
                )
                {
                    Icon(
                        if (selected.value == Icons.Default.Home) Icons.Default.Home else Icons.Outlined.Home,
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                    )

                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Favorite
                        navigationController.navigate(Screen.FavoriteScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
                {
                    Icon(
                        if (selected.value == Icons.Default.Favorite) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                    )

                }


                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Notifications
                        navigationController.navigate(Screen.NotificationScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
                {
                    Icon(
                        if (selected.value == Icons.Default.Notifications) Icons.Default.Notifications else Icons.Outlined.Notifications,
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                    )

                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(Screen.PersonScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
                {
                    Icon(
                        if (selected.value == Icons.Default.Person) Icons.Default.Person else Icons.Outlined.Person,
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                    )

                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") {
                HomeScreen(
                    navController = navController,
                )
            }
            composable("favorite") {

                FavoriteScreen(
                    navControl = navController,
//                    favoriteViewModel = FavoriteViewModel()
                )
            }
            composable("notification") { NotificationScreen(navController = navController) }
            composable("person") { PersonScreen(navController = navController) }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BottomScreenPreview() {
    AsmKOT104Theme {
        BottomNavigation(navController = rememberNavController())
    }
}