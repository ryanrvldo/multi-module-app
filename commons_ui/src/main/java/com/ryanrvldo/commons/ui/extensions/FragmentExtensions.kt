package com.ryanrvldo.commons.ui.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ryanrvldo.core.di.BaseComponentBuilder
import dagger.hilt.android.EntryPointAccessors

fun Fragment.requireCompatActivity(): AppCompatActivity {
    requireActivity()
    val activity = requireActivity()
    if (activity is AppCompatActivity) {
        return activity
    } else {
        throw TypeCastException("Main activity should extend from 'AppCompatActivity'")
    }
}

inline fun <C, reified D> Fragment.buildComponent(builder: BaseComponentBuilder<C, D>): C =
    builder.context(requireContext())
        .dependencies(
            EntryPointAccessors.fromApplication(
                requireContext().applicationContext,
                D::class.java
            )
        )
        .build()