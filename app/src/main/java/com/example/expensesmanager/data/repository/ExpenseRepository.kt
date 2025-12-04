package com.example.expensesmanager.data.repository

import com.example.expensesmanager.data.model.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {

    suspend fun insertExpense(expense: Expense)

    suspend fun deleteExpense(expense: Expense)

    fun getAllExpenses(): Flow<List<Expense>>

    fun getExpensesByCategory(category: String): Flow<List<Expense>>

    fun getByType(type: String): Flow<List<Expense>>

    fun getTotalIncome(): Flow<Double?>

    fun getTotalExpense(): Flow<Double?>
}
