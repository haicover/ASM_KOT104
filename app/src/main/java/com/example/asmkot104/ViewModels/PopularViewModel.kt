package com.example.asmkot104.ViewModels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.asmkot104.model.Carts
import com.example.asmkot104.model.Favorites
import com.example.asmkot104.model.Populars
import com.example.asmkot104.screens.CartItem

class PopularViewModel : ViewModel() {

    private val _popular = MutableLiveData<List<Populars>>()
    val populars: LiveData<List<Populars>> = _popular
    fun addToFavorites(item: Populars) {
        val currentList = _popular.value ?: emptyList()
        _popular.value = currentList + item
    }

    fun removeFromFavorites(item: Populars) {
        val currentList = _popular.value ?: emptyList()
        _popular.value = currentList.filter { it.id != item.id }
    }

    fun addToCart(item: Populars) {
        val currentList = _popular.value ?: emptyList()
        _popular.value = currentList + item
    }

    fun removeFromCart(item: Populars) {
        val currentList = _popular.value ?: emptyList()
        _popular.value = currentList.filter { it.id != item.id }
    }
}
