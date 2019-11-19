package com.pleoexpenseschallenge.ui.recycler

import android.content.Context
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.pleoexpenseschallenge.R
import kotlinx.android.synthetic.main.expense_view.view.*

class ExpenseView(context: Context) : ConstraintLayout(context){
    init {
        LayoutInflater.from(context).inflate(R.layout.expense_view, this, true)
    }

    fun setMerchant(merchant: String){
        expenseMerchant.text = merchant
    }

    fun setDate(date: String){
        expenseDate.text = date
    }

    fun setTime(time: String){
        expenseTime.text = time
    }

    fun setAmount(amount: String){
        expenseAmount.text = amount
    }

    fun setCurrency(currency: String){
        expenseAmountCurrency.text = currency
    }
}