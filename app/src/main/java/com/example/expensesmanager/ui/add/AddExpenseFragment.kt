package com.example.expensesmanager.ui.add

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.expensesmanager.data.model.Expense
import com.example.expensesmanager.databinding.FragmentAddExpenseBinding
import com.example.expensesmanager.viewmodel.AddExpenseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Calendar

class AddExpenseFragment : Fragment() {

    private lateinit var binding: FragmentAddExpenseBinding
    private val viewModel: AddExpenseViewModel by viewModel()

    private var selectedDate: Long = System.currentTimeMillis()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddExpenseBinding.inflate(inflater, container, false)

        setupCategoryDropdown()
        setupDatePicker()
        setupSaveButton()

        return binding.root
    }

    private fun setupCategoryDropdown() {
        val categories = listOf(
            "Food", "Salary", "Shopping", "Dairy", "Bills",
            "Electricity", "Water", "Recharge", "EMI", "Travel", "Health", "Other"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, categories)
        binding.inputCategory.setAdapter(adapter)
        binding.inputCategory.threshold = 0
    }

    private fun setupDatePicker() {
        binding.txtDate.setOnClickListener {
            val c = Calendar.getInstance()

            DatePickerDialog(
                requireContext(),
                { _, y, m, d ->
                    val cal = Calendar.getInstance()
                    cal.set(y, m, d)
                    selectedDate = cal.timeInMillis
                    binding.txtDate.text = "$d-${m + 1}-$y"
                },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun setupSaveButton() {
        binding.btnSave.setOnClickListener {

            val amountText = binding.inputAmount.text.toString()
            val amount = amountText.toDoubleOrNull()
            val category = binding.inputCategory.text.toString()
            val note = binding.inputNote.text.toString()
            val type = if (binding.rbIncome.isChecked) "income" else "expense"

            if (amount == null || category.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val model = Expense(
                id = 0,
                amount = amount,
                category = category,
                note = note,
                date = selectedDate,   // ✔ CORRECT FIELD NAME
                type = type
            )

            viewModel.insertExpense(model)
            Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
            findNavController().navigateUp()
        }
    }
}
