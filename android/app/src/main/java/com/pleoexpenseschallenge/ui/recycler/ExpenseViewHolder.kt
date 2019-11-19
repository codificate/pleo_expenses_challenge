package com.pleoexpenseschallenge.ui.recycler

import androidx.recyclerview.widget.RecyclerView
import com.pleoexpenseschallenge.domain.model.Expense
import java.text.SimpleDateFormat
import java.util.*

class ExpenseViewHolder(val expenseView: ExpenseView) : RecyclerView.ViewHolder(expenseView) {

    fun bind(expense: Expense){
        expenseView.setMerchant(expense.merchant)
        expenseView.setDate(dateToString(expense.date))
        expenseView.setTime(timeToString(expense.date))
        expenseView.setCurrency(expense.amount.currency)
        expenseView.setAmount(expense.amount.value.toString())
    }

    private fun dateToString(date: Date): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        return formatter.format(date)
    }

    private fun timeToString(date: Date): String {
        val formatter = SimpleDateFormat("hh:mm")
        return formatter.format(date)
    }
}
