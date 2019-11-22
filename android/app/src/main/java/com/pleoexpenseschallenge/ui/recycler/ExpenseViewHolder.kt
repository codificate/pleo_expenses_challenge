package com.pleoexpenseschallenge.ui.recycler

import androidx.recyclerview.widget.RecyclerView
import com.pleoexpenseschallenge.domain.model.Expense
import com.pleoexpenseschallenge.ui.dialog.ExpenseCommentDialog
import java.text.SimpleDateFormat
import java.util.*

class ExpenseViewHolder(private val expenseView: ExpenseView, private val updateItem: (position: Int, comment: String) -> Unit) : RecyclerView.ViewHolder(expenseView) {

    private val expenseCommentDialog: ExpenseCommentDialog by lazy {
        ExpenseCommentDialog(expenseView.context) { comment: String ->
            saveComment(comment)
        }
    }

    fun bind(expense: Expense){
        expenseView.setMerchant(expense.merchant)
        expenseView.setDate(dateToString(expense.date))
        expenseView.setTime(timeToString(expense.date))
        expenseView.setCurrency(expense.amount.currency)
        expenseView.setAmount(expense.amount.value.toString())

        if (expense.comment.isNotEmpty()){
            expenseView.setComment(expense.comment)
            expenseView.commentButton.setOnClickListener(null)
        } else {
            expenseView.commentButton.setOnClickListener {
                expenseCommentDialog.show()
            }
        }

    }

    private fun saveComment(comment: String) {
        updateItem(adapterPosition, comment)
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
