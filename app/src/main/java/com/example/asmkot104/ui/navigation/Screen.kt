package com.example.asmkot104.ui.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.asmkot104.R


sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home")
    data object CartScreen : Screen("cart")
    data object NotificationScreen : Screen("notification")
    data object PersonScreen : Screen("person")
    data object FavoriteScreen : Screen("favorite")
    data object PaymentMethodScreen : Screen("payMethod")
    data object AddPaymentMethod : Screen("addPayMethod")
    data object AddShippingAddress : Screen("addShippingAddress")
    data object ShippingAddressScreen: Screen("shippingAddressScreen")
    data object SuccessScreen : Screen("successScreen")
    data object MyOrderScreen : Screen("myOrderScreen")
    data object CheckOutScreen: Screen("checkOutScreen")
    data object CategoriesScreen: Screen("categoriesScreen")
}



