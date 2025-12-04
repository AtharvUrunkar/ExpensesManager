package com.example.expensesmanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensesmanager.data.model.Expense
import com.example.expensesmanager.data.repository.ExpenseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: ExpenseRepository
) : ViewModel() {

    private val _expenses = MutableStateFlow<List<Expense>>(emptyList())
    val expenses: StateFlow<List<Expense>> get() = _expenses

    private val _totalIncome = MutableStateFlow(0.0)
    val totalIncome: StateFlow<Double> get() = _totalIncome

    private val _totalExpense = MutableStateFlow(0.0)
    val totalExpense: StateFlow<Double> get() = _totalExpense

    private val _walletBalance = MutableStateFlow(0.0)
    val walletBalance: StateFlow<Double> get() = _walletBalance


    init {
        loadExpenses()
        loadTotals()
    }

    private fun loadExpenses() {
        viewModelScope.launch {
            repository.getAllExpenses().collectLatest { list ->
                _expenses.value = list
            }
        }
    }

    private fun loadTotals() {
        viewModelScope.launch {

            // TOTAL INCOME
            launch {
                repository.getTotalIncome().collectLatest { income ->
                    _totalIncome.value = income ?: 0.0
                }
            }

            // TOTAL EXPENSE
            launch {
                repository.getTotalExpense().collectLatest { expense ->
                    _totalExpense.value = expense ?: 0.0
                }
            }

            // WALLET BALANCE
            launch {
                repository.getAllExpenses().collectLatest { list ->
                    val income = list.filter { it.type == "income" }.sumOf { it.amount }
                    val expense = list.filter { it.type == "expense" }.sumOf { it.amount }
                    _walletBalance.value = income - expense
                }
            }
        }
    }
}
