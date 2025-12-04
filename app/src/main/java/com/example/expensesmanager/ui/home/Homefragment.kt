package com.example.expensesmanager.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController
import com.example.expensesmanager.databinding.FragmentHomeBinding
import com.example.expensesmanager.viewmodel.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecycler()
        setupClicks()
        observeFlows()
    }

    private fun setupRecycler() {
        adapter = HomeAdapter()
        binding.recyclerTransactions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerTransactions.adapter = adapter
    }

    private fun setupClicks() {
        // Add Button → Navigate to Add Expense
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(com.example.expensesmanager.R.id.addExpenseFragment)
        }

        // Settings Button → Navigate to Settings Page
        binding.btnSettings.setOnClickListener {
            findNavController().navigate(com.example.expensesmanager.R.id.settingsFragment)
        }
    }

    private fun observeFlows() {

        // EXPENSE LIST
        lifecycleScope.launch {
            viewModel.expenses.collect { list ->
                adapter.submitList(list)
            }
        }

        // INCOME
        lifecycleScope.launch {
            viewModel.totalIncome.collect { income ->
                binding.txtIncomeTotal.text = "+ ₹$income"
            }
        }

        // EXPENSE
        lifecycleScope.launch {
            viewModel.totalExpense.collect { expense ->
                binding.txtExpenseTotal.text = "- ₹$expense"
            }
        }

        // WALLET BALANCE
        lifecycleScope.launch {
            viewModel.walletBalance.collect { wallet ->
                binding.txtWalletAmount.text = "₹ $wallet"
            }
        }
    }
}
