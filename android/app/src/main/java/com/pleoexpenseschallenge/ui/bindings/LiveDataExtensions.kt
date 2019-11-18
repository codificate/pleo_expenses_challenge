package com.pleoexpenseschallenge.ui.bindings

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


fun <T> LifecycleOwner.onChange(liveData: LiveData<T>, onChange: (T) -> Unit) {
    liveData.observe(this, Observer { it?.also{ onChange(it) } })
}