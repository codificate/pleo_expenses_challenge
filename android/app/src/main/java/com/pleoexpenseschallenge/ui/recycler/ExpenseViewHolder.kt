package com.pleoexpenseschallenge.ui.recycler

import androidx.recyclerview.widget.RecyclerView
import com.pleoexpenseschallenge.domain.model.Expense

class ExpenseViewHolder(val expenseView: ExpenseView) : RecyclerView.ViewHolder(expenseView) {

    fun bind(expense: Expense){
        expenseView.setMerchant(expense.merchant)
        expenseView.setDate(expense.date)
        expenseView.setAmount(expense.amount.value)
    }
}
