package com.example.expensesmanager.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expensesmanager.data.dao.ExpenseDao
import com.example.expensesmanager.data.model.Expense

@Database(
    entities = [Expense::class],
    version = 1,
    exportSchema = false
)
abstract class ExpenseDb : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao

    companion object {

        @Volatile
        private var INSTANCE: ExpenseDb? = null

        fun getInstance(context: Context): ExpenseDb {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ExpenseDb::class.java,
                    "expense_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
