package com.example.expensesmanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.data.model.Expense
import com.example.expensesmanager.data.repository.ExpenseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddExpenseViewModel(
    private val repository: ExpenseRepository
) : ViewModel() {

    fun insertExpense(expense: Expense) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertExpense(expense)
        }
    }
}
