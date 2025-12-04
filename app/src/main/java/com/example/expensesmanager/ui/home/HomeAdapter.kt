package com.example.expensesmanager.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expensesmanager.R
import com.example.expensesmanager.data.model.Expense
import com.example.expensesmanager.databinding.ItemExpenseBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ExpenseViewHolder>() {

    private var list: List<Expense> = emptyList()

    fun submitList(newList: List<Expense>) {
        list = newList
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Expense = list[position]

    inner class ExpenseViewHolder(private val binding: ItemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Expense) {

            binding.txtCategory.text = item.category
            binding.txtDate.text = convertDate(item.date)

            // --------------------------
            // UI Styling Based on Income/Expense
            // --------------------------
            if (item.type.equals("income", ignoreCase = true)) {
                binding.txtAmount.text = "+₹${item.amount}"
                binding.txtAmount.setTextColor(Color.parseColor("#2ECC71")) // Green
                binding.imgType.setImageResource(R.drawable.ic_income)
                binding.imgType.setColorFilter(Color.parseColor("#2ECC71"))
            } else {
                binding.txtAmount.text = "-₹${item.amount}"
                binding.txtAmount.setTextColor(Color.parseColor("#FF5252")) // Red
                binding.imgType.setImageResource(R.drawable.ic_expense)
                binding.imgType.setColorFilter(Color.parseColor("#FF5252"))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val binding = ItemExpenseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ExpenseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}

// ----------------------
// DATE CONVERTER FUNCTION
// ----------------------
private fun convertDate(timeMillis: Long): String {
    val sdf = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    return sdf.format(Date(timeMillis))
}
