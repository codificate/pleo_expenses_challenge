package com.pleoexpenseschallenge.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pleoexpenseschallenge.domain.model.Expense

class ExpensesAdapter(val expenses: MutableList<Expense>) : RecyclerView.Adapter<ExpenseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        return ExpenseViewHolder(createExpenseView(parent))
    }

    override fun getItemCount() = expenses.size

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(expenses[position])
    }

    private fun createExpenseView(parent: ViewGroup): ExpenseView {
        return ExpenseView(parent.context)
    }
}