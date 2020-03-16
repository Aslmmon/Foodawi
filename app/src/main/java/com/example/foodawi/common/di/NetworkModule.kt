package com.example.foodawi.common.di

import com.example.foodawi.common.network.createNetworkClient
import com.example.foodawi.common.repositories.mealDetailRepo.IMealDetail
import com.example.foodawi.common.rest.DetailsApi
import com.example.foodawi.common.rest.MainApi
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Aslm on 1/1/2020
 */


val retrofit: Retrofit = createNetworkClient()
private val MAIN_API: MainApi = retrofit.create(MainApi::class.java)
private val DETAILS_API: DetailsApi = retrofit.create(DetailsApi::class.java)


val networkModule = module {
    single { MAIN_API }
    single { DETAILS_API }

}