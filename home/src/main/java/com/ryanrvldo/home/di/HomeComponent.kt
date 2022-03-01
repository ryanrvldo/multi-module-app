package com.ryanrvldo.home.di

import com.ryanrvldo.core.di.BaseComponentBuilder
import com.ryanrvldo.core.di.dependencies.HomeModuleDependencies
import com.ryanrvldo.home.HomeNavHostFragment
import dagger.Component

@Component(
    modules = [HomeViewModelModule::class],
    dependencies = [HomeModuleDependencies::class]
)
interface HomeComponent {

    fun inject(fragment: HomeNavHostFragment)

    @Component.Builder
    interface Builder : BaseComponentBuilder<HomeComponent, HomeModuleDependencies>

}