package com.example.expensesmanager.di

import com.example.expensesmanager.data.db.ExpenseDb
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    // Room DB instance
    single { ExpenseDb.getInstance(androidContext()) }

    // DAO instance
    single { get<ExpenseDb>().expenseDao() }
}
