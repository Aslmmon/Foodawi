package com.example.foodawi.common.di

import com.example.foodawi.common.network.createNetworkClient
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Aslm on 1/1/2020
 */


val retrofit: Retrofit = createNetworkClient()
//private val LOGIN_API: LoginApi = retrofit.create(LoginApi::class.java)
//private val HOME_API: HomeApi = retrofit.create(HomeApi::class.java)
//private val CLEANING_API: CleaningApi = retrofit.create(CleaningApi::class.java)
//private val PROVIDERS_API: ProvidersApi = retrofit.create(ProvidersApi::class.java)
//private val ADDRESSES_API: AddressesApi = retrofit.create(AddressesApi::class.java)
//private val GENERAL_API: GeneralApi = retrofit.create(GeneralApi::class.java)
//private val ORDER_API: OrderApi = retrofit.create(OrderApi::class.java)


val networkModule = module {
//    single { LOGIN_API }
//    single { HOME_API }
//    single { CLEANING_API }
//    single { PROVIDERS_API }
//    single { ADDRESSES_API }
//    single { GENERAL_API }
//    single { ORDER_API }
}