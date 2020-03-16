package com.example.foodawi.common.repositories.MainRepo

import com.example.foodawi.common.model.categories.CategoriesResponse
import com.example.foodawi.common.model.categories.mealsResponse.MealsResponse

interface IMain {

    suspend fun getMainCategories() :CategoriesResponse
    suspend fun getMeals(category:String):MealsResponse
}