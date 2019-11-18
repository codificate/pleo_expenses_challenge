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

    fun onViewCreated(){
        getExpenses()
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.clear()
    }

    private fun getExpenses(){
        fetchExpenses()
                .onDefaultSchedulers()
                .subscribe { onPleoExpensesFetched(it) }
                .addTo(subscriptions)
    }

    private fun onPleoExpensesFetched(pleoExpenses: PleoExpenses) {
        _mutablePleoExpenses.postValue(pleoExpenses)
    }

}