package com.ryanrvldo.home.di

import android.content.Context
import com.ryanrvldo.home.HomeNavHostFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [HomeViewModelModule::class]
)
interface HomeComponent {

    fun inject(fragment: HomeNavHostFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun build(): HomeComponent
    }

}