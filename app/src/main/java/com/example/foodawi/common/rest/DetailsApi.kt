package com.example.foodawi.common.rest

import com.example.foodawi.common.model.categories.CategoriesResponse
import com.example.foodawi.common.model.categories.meal_details.MealDetailsResponse
import com.example.foodawi.common.model.categories.mealsResponse.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailsApi {

    @GET("/api/json/v1/1/lookup.php")
    suspend fun getMailDetials(@Query("i") mealId: String): MealDetailsResponse

}