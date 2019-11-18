package com.pleoexpenseschallenge

import android.content.Intent
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.pleoexpenseschallenge.ui.ExpensesActivity

class ExpensesModule constructor(private val context: ReactApplicationContext) : ReactContextBaseJavaModule(context) {

    override fun getName(): String {
        return "ExpensesModule"
    }

    @ReactMethod
    fun show() {
        val intent = Intent(context, ExpensesActivity::class.java)
        takeIf { intent.resolveActivity(context.packageManager) != null }.let {
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
}