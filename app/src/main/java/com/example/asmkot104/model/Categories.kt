package com.example.asmkot104.model

import com.example.asmkot104.R

data class Categories(
    val id: Int,
    val pic: Int,
    val title: String,
)
val categoriesItem = listOf(
    Categories(
        id = 1,
        pic = R.drawable.stars,
        title = "Popular",
    ),
    Categories(
        id = 2,
        pic = R.drawable.chairs,
        title = "Chair",
    ),
    Categories(
        id = 3,
        pic = R.drawable.tables,
        title = "Table",
    ),
    Categories(
        id = 4,
        pic = R.drawable.armchairs,
        title = "Armchair",
    ),
    Categories(
        id = 5,
        pic = R.drawable.doublebed,
        title = "Bed",
    ),
    Categories(
        id = 6,
        pic = R.drawable.television,
        title = "Television",
    ),
)
