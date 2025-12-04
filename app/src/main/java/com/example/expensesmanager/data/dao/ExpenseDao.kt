package com.example.expensesmanager.data.dao

import androidx.room.*
import com.example.expensesmanager.data.model.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAllExpenses(): Flow<List<Expense>>

    @Query("SELECT * FROM expenses WHERE category = :category")
    fun getExpensesByCategory(category: String): Flow<List<Expense>>

    @Query("SELECT * FROM expenses WHERE type = :type")
    fun getByType(type: String): Flow<List<Expense>>

    @Query("SELECT SUM(amount) FROM expenses WHERE type = 'income'")
    fun getTotalIncome(): Flow<Double?>

    @Query("SELECT SUM(amount) FROM expenses WHERE type = 'expense'")
    fun getTotalExpense(): Flow<Double?>
}
