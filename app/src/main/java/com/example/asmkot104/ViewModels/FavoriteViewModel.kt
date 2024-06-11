package com.example.asmkot104.ViewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.asmkot104.model.Carts
import com.example.asmkot104.model.Favorites
import com.example.asmkot104.model.Populars

class FavoriteViewModel : ViewModel() {
    private val _favorites = MutableLiveData<List<Favorites>>()
    val favorites: LiveData<List<Favorites>> = _favorites

    init {
        _favorites.value = listOf()  // Initialize with an empty list
    }

    fun addToFavorite(item: Favorites) {
        val currentList = _favorites.value ?: emptyList()
        _favorites.value = currentList + item
    }

    fun removeFromFavorite(item: Favorites) {
        val currentList = _favorites.value ?: emptyList()
        _favorites.value = currentList.filter { it.id != item.id }
    }
}