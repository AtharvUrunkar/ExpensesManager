package com.example.expensesmanager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val amount: Double,        // Expense amount
    val category: String,      // Category selected from dropdown
    val note: String?,         // Optional note
    val date: Long,            // Timestamp in milliseconds
    val type: String           // "income" or "expense"
)
