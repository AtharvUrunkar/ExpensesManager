package com.example.expensesmanager.data.repository

import com.example.expensesmanager.data.dao.ExpenseDao
import com.example.expensesmanager.data.model.Expense
import kotlinx.coroutines.flow.Flow

class ExpenseRepositoryImpl(
    private val expenseDao: ExpenseDao
) : ExpenseRepository {

    override suspend fun insertExpense(expense: Expense) {
        expenseDao.insertExpense(expense)
    }

    override suspend fun deleteExpense(expense: Expense) {
        expenseDao.deleteExpense(expense)
    }

    override fun getAllExpenses(): Flow<List<Expense>> {
        return expenseDao.getAllExpenses()
    }

    override fun getExpensesByCategory(category: String): Flow<List<Expense>> {
        return expenseDao.getExpensesByCategory(category)
    }

    override fun getByType(type: String): Flow<List<Expense>> {
        return expenseDao.getByType(type)
    }

    override fun getTotalIncome(): Flow<Double?> {
        return expenseDao.getTotalIncome()
    }

    override fun getTotalExpense(): Flow<Double?> {
        return expenseDao.getTotalExpense()
    }
}
