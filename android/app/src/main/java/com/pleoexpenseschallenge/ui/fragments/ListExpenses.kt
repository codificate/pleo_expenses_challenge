package com.pleoexpenseschallenge.ui.fragments

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pleoexpenseschallenge.R
import com.pleoexpenseschallenge.domain.model.PleoExpenses
import com.pleoexpenseschallenge.ui.bindings.onChange
import com.pleoexpenseschallenge.ui.recycler.EndlessRecyclerOnScrollListener
import com.pleoexpenseschallenge.ui.recycler.ExpensesAdapter
import com.pleoexpenseschallenge.ui.viewmodel.ListExpensesViewModel
import com.pleoexpenseschallenge.ui.viewmodel.ListExpensesViewModelFactory
import kotlinx.android.synthetic.main.fragment_list_expenses.*
import java.lang.Math.hypot
import java.lang.Math.max


class ListExpenses : Fragment() {

    private lateinit var viewModel: ListExpensesViewModel
    private var isOpen = false
    private var isSorting = false

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
        listExpensesRecyclerView.layoutManager = LinearLayoutManager(context)
        listExpensesRecyclerView.addOnScrollListener(object : EndlessRecyclerOnScrollListener(){
            override fun onLoadMore() {
                listExpensesProgressBar.visibility = VISIBLE
                viewModel.getExpenses()
            }

        })
        onChange(viewModel.pleoExpenses){
            showExpenses(it)
        }
        viewModel.onViewCreated()
        listExpensesFiltersButton.setOnClickListener {
            showFilterButtons()
        }


        listExpensesSortByAmount.setOnClickListener {
            isSorting = true
            viewModel.sortByAmount()
        }

        listExpensesSortByMerchant.setOnClickListener {
            isSorting = true
            viewModel.sortByAlphabet()
        }

    }

    override fun onDetach() {
        super.onDetach()
        viewModel.pleoExpenses.removeObservers(this)
    }

    private fun showExpenses(pleoExpenses: PleoExpenses) {
        listExpensesProgressBar.visibility = GONE

        if (isSorting){
            isSorting = false
            showFilterButtons()
            (listExpensesRecyclerView.adapter as ExpensesAdapter).expenses.clear()
            (listExpensesRecyclerView.adapter as ExpensesAdapter).expenses.addAll(pleoExpenses.listExpens)
        }
        if (listExpensesRecyclerView.adapter != null){
            (listExpensesRecyclerView.adapter as ExpensesAdapter).expenses.addAll(pleoExpenses.listExpens)
        } else {
            listExpensesRecyclerView.adapter = ExpensesAdapter(pleoExpenses.listExpens)
            listExpensesFiltersButton.visibility = VISIBLE
        }

        listExpensesRecyclerView.adapter?.notifyDataSetChanged()
    }

    private fun showFilterButtons() {

        val thisview = this.view!!

        if (!isOpen) {

            val x = thisview.right
            val y = thisview.bottom

            val startRadius = 0
            val endRadius = hypot(thisview.width.toDouble(), thisview.height.toDouble()).toInt()

            val anim = ViewAnimationUtils.createCircularReveal(listExpensesFiltersGroup, x, y, startRadius.toFloat(), endRadius.toFloat())

            listExpensesRecyclerView.visibility = GONE
            listExpensesFiltersGroup.visibility = VISIBLE
            anim.start()

            isOpen = true

        } else {

            val x = listExpensesFiltersGroup.right
            val y = listExpensesFiltersGroup.bottom

            val startRadius = max(thisview.width, thisview.height)
            val endRadius = 0

            val anim = ViewAnimationUtils.createCircularReveal(listExpensesFiltersGroup, x, y, startRadius.toFloat(), endRadius.toFloat())
            anim.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animator: Animator) {

                }

                override fun onAnimationEnd(animator: Animator) {
                    listExpensesFiltersGroup.visibility = GONE
                    listExpensesRecyclerView.visibility = VISIBLE
                }

                override fun onAnimationCancel(animator: Animator) {

                }

                override fun onAnimationRepeat(animator: Animator) {

                }
            })
            anim.start()

            isOpen = false
        }
    }
}
