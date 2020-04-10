package com.example.foodawi.common.repositories.MainRepo

import com.example.foodawi.common.bases.ResponseWrapper
import com.example.foodawi.common.model.categories.CategoriesResponse
import com.example.foodawi.common.model.categories.mealsResponse.MealsResponse

interface IMain {

    suspend fun getMainCategories() :ResponseWrapper<CategoriesResponse>
    suspend fun getMeals(category:String):ResponseWrapper<MealsResponse>
}