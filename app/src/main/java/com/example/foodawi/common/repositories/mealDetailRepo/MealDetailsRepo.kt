package com.example.foodawi.common.repositories.mealDetailRepo

import com.example.foodawi.common.rest.DetailsApi

class MealDetailsRepo(var detail: DetailsApi) : IMealDetail {
    override suspend fun getMealDetails(id: String) = detail.getMailDetials(id)
}