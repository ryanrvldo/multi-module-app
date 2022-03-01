package com.ryanrvldo.core.di

import android.content.Context
import dagger.BindsInstance

interface BaseComponentBuilder<C, D> {

    fun context(@BindsInstance context: Context): BaseComponentBuilder<C, D>
    fun dependencies(dependencies: D): BaseComponentBuilder<C, D>
    fun build(): C

}