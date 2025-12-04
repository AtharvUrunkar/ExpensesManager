package com.example.expensesmanager.di

import com.example.expensesmanager.viewmodel.HomeViewModel
import com.example.expensesmanager.viewmodel.AddExpenseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get()) }

    viewModel { AddExpenseViewModel(get()) }
}
