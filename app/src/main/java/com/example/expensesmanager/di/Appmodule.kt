package com.example.expensesmanager.di

import org.koin.dsl.module

val appModule = module {
    includes(
        databaseModule,
        repositoryModule,
        viewModelModule
    )
}
