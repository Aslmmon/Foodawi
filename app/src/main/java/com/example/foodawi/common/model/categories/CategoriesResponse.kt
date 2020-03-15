package com.example.foodawi.common.model.categories


import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("categories")
    val categories: List<Category>
)