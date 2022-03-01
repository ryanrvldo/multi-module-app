package com.ryanrvldo.home.di

import androidx.lifecycle.ViewModel
import com.ryanrvldo.core.di.annotation.ViewModelKey
import com.ryanrvldo.home.HomeNavHostViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeNavHostViewModel::class)
    fun bindsHomeNavHostViewModel(vm: HomeNavHostViewModel): ViewModel

}