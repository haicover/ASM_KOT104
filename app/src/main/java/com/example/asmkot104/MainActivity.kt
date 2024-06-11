package com.example.asmkot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.asmkot104.ViewModels.CartViewModel
import com.example.asmkot104.ViewModels.FavoriteViewModel
import com.example.asmkot104.ViewModels.PopularViewModel
import com.example.asmkot104.detail.DetailArmChairScreen
import com.example.asmkot104.ui.navigation.BottomNavigation
import com.example.asmkot104.ui.navigation.Screen
import com.example.asmkot104.screens.ArmchairScreen
import com.example.asmkot104.screens.BedScreen
import com.example.asmkot104.screens.CartScreen
import com.example.asmkot104.screens.ChairScreen
import com.example.asmkot104.screens.CheckOutScreen
import com.example.asmkot104.detail.DetailBedScreen
import com.example.asmkot104.detail.DetailChairScreen
import com.example.asmkot104.detail.DetailPopularScreen
import com.example.asmkot104.detail.DetailTableScreen
import com.example.asmkot104.detail.DetailTelevisionScreen
import com.example.asmkot104.screens.FavoriteScreen
import com.example.asmkot104.screens.ForgotPasswordScreen
import com.example.asmkot104.screens.LoginScreen
import com.example.asmkot104.screens.MyOrderScreen
import com.example.asmkot104.screens.NotificationScreen
import com.example.asmkot104.screens.PaymentMethodScreen
import com.example.asmkot104.screens.PersonScreen
import com.example.asmkot104.screens.PopularsScreen
import com.example.asmkot104.screens.ShippingAddressScreen
import com.example.asmkot104.screens.SignUpScreen
import com.example.asmkot104.screens.SuccessScreen
import com.example.asmkot104.screens.TableScreen
import com.example.asmkot104.screens.TelevisionScreen
import com.example.asmkot104.screens.WelcomeScreen

import com.example.asmkot104.ui.login.LoginViewModel
import com.example.asmkot104.ui.theme.AsmKOT104Theme

class MainActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private val favoriteViewModel: FavoriteViewModel by viewModels()
    private val cartViewModel: CartViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AsmKOT104Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "welcome") {
                        composable("welcome") {
                            WelcomeScreen(navController = navController)
                        }
                        composable("login") {
                            LoginScreen(
                                navController = navController,
                                loginViewModel = loginViewModel
                            )
                        }
                        composable("forgot") {
                            ForgotPasswordScreen(navController = navController)
                        }
                        composable("signup") {
                            SignUpScreen(
                                navController = navController,
                                loginViewModel = loginViewModel
                            )
                        }
                        composable("bottom") {
                            BottomNavigation(navController = navController)
                        }
                        composable("favorite") {
                            FavoriteScreen(
                                navControl = navController,
//                                favoriteViewModel = favoriteViewModel
                            )
                        }
                        composable("cart") {
                            CartScreen(navControl = navController, cartViewModel = cartViewModel)
                        }
                        composable("person") {
                            PersonScreen(navController = navController)
                        }
                        composable("notification") {
                            NotificationScreen(navController = navController)
                        }
                        composable("checkOutScreen") {
                            CheckOutScreen(navControl = navController, data = null)
                        }
                        composable("successScreen") {
                            SuccessScreen(navControl = navController)
                        }
                        composable("myOrderScreen") {
                            MyOrderScreen(navController = navController)
                        }
//                        composable("addPayMethod"){
//                            AddPaymentMethod(navControl = navController, data = null)
//                        }
//                        composable("addShippingAddress"){
//                            AddShippingAddress(navControl = navController)
//                        }
                        composable("payMethod") {
                            PaymentMethodScreen(navControl = navController)
                        }
                        composable("shippingAddressScreen") {
                            ShippingAddressScreen(navControl = navController)
                        }
                        composable("ChairScreen") {
                            ChairScreen(navControl = navController)
                        }
                        composable("TableScreen") {
                            TableScreen(navControl = navController)
                        }
                        composable("ArmchairScreen") {
                            ArmchairScreen(navControl = navController)
                        }
                        composable("BedScreen") {
                            BedScreen(navControl = navController)
                        }
                        composable("TelevisionScreen") {
                            TelevisionScreen(navControl = navController)
                        }
                        composable("PopularsScreen") {
                            PopularsScreen(navControl = navController)
                        }
                        composable(
                            route = "detail/{bedId}",
                            arguments = listOf(navArgument("bedId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val bedId =
                                backStackEntry.arguments?.getInt("bedId") ?: return@composable
                            DetailBedScreen(navController, bedId)
                        }
                        composable(
                            route = "detail/{chairId}",
                            arguments = listOf(navArgument("chairId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val bedId =
                                backStackEntry.arguments?.getInt("chairId") ?: return@composable
                            DetailChairScreen(navController, bedId)
                        }
                        composable(
                            route = "detail/{armChairId}",
                            arguments = listOf(navArgument("armChairId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val bedId =
                                backStackEntry.arguments?.getInt("armChairId") ?: return@composable
                            DetailArmChairScreen(navController, bedId)
                        }
                        composable(
                            route = "detail/{tableId}",
                            arguments = listOf(navArgument("tableId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val bedId =
                                backStackEntry.arguments?.getInt("tableId") ?: return@composable
                            DetailTableScreen(navController, bedId)
                        }
                        composable(
                            route = "detail/{televisionId}",
                            arguments = listOf(navArgument("televisionId") {
                                type = NavType.IntType
                            })
                        ) { backStackEntry ->
                            val bedId = backStackEntry.arguments?.getInt("televisionId")
                                ?: return@composable
                            DetailTelevisionScreen(navController, bedId)
                        }
                        composable(
                            route = "detail/{popularsId}",
                            arguments = listOf(navArgument("popularsId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val bedId =
                                backStackEntry.arguments?.getInt("popularsId") ?: return@composable
                            DetailPopularScreen(
                                navController, bedId,
//                                favoriteViewModel = favoriteViewModel,
                                cartViewModel = cartViewModel
//                                popularViewModel = popularViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}


