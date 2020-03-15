package com.example.foodawi.common.di

import com.example.foodawi.common.repositories.MainRepo.IMain
import com.example.foodawi.common.repositories.MainRepo.MainRepo
import org.koin.dsl.module

/**
 * Created by Aslm on 1/1/2020
 */

val repositoriesModule = module {
    single { MainRepo(get()) as IMain }
}