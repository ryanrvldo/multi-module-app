package com.ryanrvldo.commons.ui.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.requireCompatActivity(): AppCompatActivity {
    requireActivity()
    val activity = requireActivity()
    if (activity is AppCompatActivity) {
        return activity
    } else {
        throw TypeCastException("Main activity should extend from 'AppCompatActivity'")
    }
}