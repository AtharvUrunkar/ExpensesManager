package com.example.expensesmanager.di

import com.example.expensesmanager.data.repository.ExpenseRepository
import com.example.expensesmanager.data.repository.ExpenseRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    // Bind interface to implementation
    single<ExpenseRepository> { ExpenseRepositoryImpl(get()) }
    // get() -> ExpenseDao
}
