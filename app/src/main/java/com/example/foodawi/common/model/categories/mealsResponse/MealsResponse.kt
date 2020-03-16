package com.example.foodawi.common.model.categories.mealsResponse


import com.google.gson.annotations.SerializedName

data class MealsResponse(
    @SerializedName("meals")
    val meals: List<Meal>
)