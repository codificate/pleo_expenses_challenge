package com.pleoexpenseschallenge.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.pleoexpenseschallenge.R


class ExpenseCommentDialog(private val context: Context, private val suggestComment: (subject: String) -> Unit) {

    private val dialog by lazy { createDialog() }
    private val dialogView: View by lazy { LayoutInflater.from(context).inflate(R.layout.expense_comment_dialog, null) }
    private val sendCommentButton get() = dialogView.findViewById<ImageView>(R.id.sendCommentIcon)
    private val comment get() = dialogView.findViewById<EditText>(R.id.commentEditable)

    init {
        dialogView.setOnClickListener {
            hideKeyBoard()
            dialog.dismiss()
        }

        sendCommentButton.setOnClickListener {
            comment.takeIf { it.text.isNotEmpty() }.let {
                suggestComment(it!!.text.toString())
                hideKeyBoard()
                dialog.dismiss()
                comment.text.clear()
            }
        }
    }

    fun show(){
        dialog.show()
        onShownOpenKeyboard()
    }

    private fun createDialog(): AlertDialog {
        val builder = AlertDialog.Builder(context)
        builder.setView(dialogView)
        builder.setCancelable(true)
        return builder.create()
    }

    private fun onShownOpenKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.showSoftInput(comment, InputMethodManager.SHOW_IMPLICIT)
    }

    private fun hideKeyBoard(){
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(dialogView.windowToken, 0)
    }
}