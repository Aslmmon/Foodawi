package com.example.foodawi.common.di


import com.example.foodawi.features.meal_categories.MealsActivityViewModel
import com.example.foodawi.features.home_categories.MainActivityViewModel
import com.example.foodawi.features.meal_details.MealDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Aslm on 1/1/2020
 */

val viewModelModule = module {
    viewModel { MainActivityViewModel(get()) }
    viewModel { MealsActivityViewModel(get()) }
    viewModel { MealDetailViewModel(get()) }
}