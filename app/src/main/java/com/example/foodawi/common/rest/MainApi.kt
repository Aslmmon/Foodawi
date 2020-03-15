package com.example.foodawi.common.rest

import com.example.foodawi.common.model.categories.CategoriesResponse
import retrofit2.http.GET

interface MainApi {

    @GET("/api/json/v1/1/categories.php")
    suspend fun getFoodCategories(): CategoriesResponse


}