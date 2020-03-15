package com.example.foodawi.common.repositories.MainRepo

import com.example.foodawi.common.model.categories.CategoriesResponse
import com.example.foodawi.common.rest.MainApi

class MainRepo(var mainApi:MainApi) : IMain {
    override suspend fun getMainCategories()  = mainApi.getFoodCategories()
}