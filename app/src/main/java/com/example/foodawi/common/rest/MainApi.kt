package com.example.foodawi.common.rest

import com.example.foodawi.common.model.categories.CategoriesResponse
import com.example.foodawi.common.model.categories.mealsResponse.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MainApi {

    @GET("/api/json/v1/1/categories.php")
    suspend fun getFoodCategories(): CategoriesResponse

    @GET("/api/json/v1/1/filter.php")
    suspend fun getMeals(@Query("c") category: String): MealsResponse

}