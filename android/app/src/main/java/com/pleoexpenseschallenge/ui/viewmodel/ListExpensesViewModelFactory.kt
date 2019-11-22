package com.pleoexpenseschallenge.ui.viewmodel

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.pleoexpenseschallenge.domain.factory.createFetchExpensesAction
import com.pleoexpenseschallenge.domain.factory.createPostCommentAction

object ListExpensesViewModelFactory {

    internal fun create(fragment: Fragment): ListExpensesViewModel{
        return ViewModelProviders.of(fragment, fragment.context?.let { createFactory(it) }).get(ListExpensesViewModel::class.java)
    }

    private fun createFactory(context: Context): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ListExpensesViewModel(
                        createFetchExpensesAction(),
                        createPostCommentAction()
                ) as T
            }
        }
    }

}