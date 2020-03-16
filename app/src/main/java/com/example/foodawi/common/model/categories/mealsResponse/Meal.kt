package com.example.foodawi.common.model.categories.mealsResponse


import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("idMeal")
    var idMeal: String,
    @SerializedName("strMeal")
    val strMeal: String,
    @SerializedName("strMealThumb")
    val strMealThumb: String
)