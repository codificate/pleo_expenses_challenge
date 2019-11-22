package com.pleoexpenseschallenge.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pleoexpenseschallenge.domain.model.Expense

class ExpensesAdapter(val expenses: MutableList<Expense>, private val setCommentOnExpense: (id: String, comment: String) -> Unit) : RecyclerView.Adapter<ExpenseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        return ExpenseViewHolder(createExpenseView(parent)){ position, comment->
            updateItem(position, comment)
        }
    }

    override fun getItemCount() = expenses.size

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(expenses[position])
    }

    private fun createExpenseView(parent: ViewGroup): ExpenseView {
        return ExpenseView(parent.context)
    }

    private fun updateItem(position : Int, comment: String) {
        setCommentOnExpense(expenses[position].id, comment)
        expenses[position].comment = comment
        notifyItemChanged(position)
    }
}