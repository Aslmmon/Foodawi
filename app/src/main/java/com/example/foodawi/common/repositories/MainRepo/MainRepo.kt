package com.example.foodawi.common.repositories.MainRepo

import com.example.foodawi.common.rest.MainApi

class MainRepo(var mainApi: MainApi) : IMain {
    override suspend fun getMainCategories() = mainApi.getFoodCategories()
    override suspend fun getMeals(category: String) = mainApi.getMeals(category = category)
}