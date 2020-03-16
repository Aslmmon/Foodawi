package com.example.foodawi.common.model.categories.meal_details


import com.google.gson.annotations.SerializedName

data class MealDetailsResponse(
    @SerializedName("meals")
    val meals: List<Meal>
)