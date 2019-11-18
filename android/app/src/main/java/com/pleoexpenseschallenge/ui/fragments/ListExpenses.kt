package com.pleoexpenseschallenge.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pleoexpenseschallenge.R
import com.pleoexpenseschallenge.domain.model.PleoExpenses
import com.pleoexpenseschallenge.ui.bindings.onChange
import com.pleoexpenseschallenge.ui.recycler.ExpensesAdapter
import com.pleoexpenseschallenge.ui.viewmodel.ListExpensesViewModel
import com.pleoexpenseschallenge.ui.viewmodel.ListExpensesViewModelFactory
import kotlinx.android.synthetic.main.fragment_list_expenses.*

class ListExpenses : Fragment() {

    private lateinit var viewModel: ListExpensesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ListExpensesViewModelFactory.create(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_expenses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onChange(viewModel.pleoExpenses){
            showExpenses(it)
        }
        viewModel.onViewCreated()
    }

    private fun showExpenses(pleoExpenses: PleoExpenses) {
        listExpensesRecyclerView.layoutManager = LinearLayoutManager(context)
        listExpensesRecyclerView.adapter = ExpensesAdapter(pleoExpenses.listExpens)
        listExpensesRecyclerView.adapter?.notifyDataSetChanged()
    }
}
