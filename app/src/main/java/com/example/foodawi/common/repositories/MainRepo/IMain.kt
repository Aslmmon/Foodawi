package com.example.foodawi.common.repositories.MainRepo

import com.example.foodawi.common.model.categories.CategoriesResponse

interface IMain {

    suspend fun getMainCategories() :CategoriesResponse
}