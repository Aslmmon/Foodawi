package com.example.foodawi.common.di


import com.example.foodawi.features.details.MealsActivityViewModel
import com.example.foodawi.features.home_categories.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Aslm on 1/1/2020
 */

val viewModelModule = module {
    viewModel { MainActivityViewModel(get()) }
    viewModel { MealsActivityViewModel(get()) }
}