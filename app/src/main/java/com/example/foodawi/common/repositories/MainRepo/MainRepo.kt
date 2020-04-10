package com.example.foodawi.common.repositories.MainRepo

import com.example.foodawi.common.bases.safeApiCall
import com.example.foodawi.common.rest.MainApi
import kotlinx.coroutines.Dispatchers

class MainRepo(var mainApi: MainApi) : IMain {
    override suspend fun getMainCategories()= safeApiCall(Dispatchers.IO, apiCall = { mainApi.getFoodCategories() })
    override suspend fun getMeals(category: String) = safeApiCall(Dispatchers.IO,apiCall = {mainApi.getMeals(category = category)})
}