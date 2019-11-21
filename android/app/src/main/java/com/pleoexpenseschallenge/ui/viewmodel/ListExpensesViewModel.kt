package com.pleoexpenseschallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pleoexpenseschallenge.domain.action.FetchExpenses
import com.pleoexpenseschallenge.domain.model.PleoExpenses
import com.pleoexpenseschallenge.rxextentions.onDefaultSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class ListExpensesViewModel(private val fetchExpenses: FetchExpenses) : ViewModel() {

    private val _mutablePleoExpenses = MutableLiveData<PleoExpenses>()
    val pleoExpenses: LiveData<PleoExpenses> = _mutablePleoExpenses

    private val subscriptions = CompositeDisposable()

    private var limit = 25
    private var offset = 0
    private var total = 0

    fun onViewCreated(){
        getExpenses()
    }

    fun getExpenses(){
        if (offset == 0 || offset < total){
            fetchExpenses(limit, offset)
                    .onDefaultSchedulers()
                    .subscribe { onPleoExpensesFetched(it) }
                    .addTo(subscriptions)
        }
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.clear()
    }

    private fun onPleoExpensesFetched(expenses: PleoExpenses) {
        total = expenses.total
        updateOffset(expenses.listExpens.last().index + 1)
        _mutablePleoExpenses.postValue(expenses)
    }

    private fun updateOffset(lastExpenseIndex: Int) {
        offset = lastExpenseIndex
    }

    fun sortByAmount() {
        var listExpenses = _mutablePleoExpenses.value?.listExpens!!
        var sortedList = listExpenses.sortedWith(compareBy { it.amount.value })
        var expensesSortedByAmount = PleoExpenses(sortedList.toMutableList(), total)
        _mutablePleoExpenses.postValue(expensesSortedByAmount)
    }

    fun sortByAlphabet() {
        var listExpenses = _mutablePleoExpenses.value?.listExpens!!
        var sortedList = listExpenses.sortedWith(compareBy { it.merchant })
        var expensesSortedByAmount = PleoExpenses(sortedList.toMutableList(), total)
        _mutablePleoExpenses.postValue(expensesSortedByAmount)
    }

}