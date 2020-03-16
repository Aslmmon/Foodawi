package com.example.foodawi.common.repositories.mealDetailRepo

import com.example.foodawi.common.model.categories.meal_details.MealDetailsResponse
import com.example.foodawi.common.model.categories.mealsResponse.MealsResponse

interface IMealDetail {

    suspend fun getMealDetails(id:String): MealDetailsResponse
}