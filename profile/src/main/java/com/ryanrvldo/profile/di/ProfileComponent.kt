package com.ryanrvldo.profile.di

import com.ryanrvldo.core.di.BaseComponentBuilder
import com.ryanrvldo.core.di.dependencies.ProfileModuleDependencies
import com.ryanrvldo.profile.ui.ProfileFragment
import dagger.Component

@Component(
    dependencies = [ProfileModuleDependencies::class]
)
interface ProfileComponent {

    fun inject(fragment: ProfileFragment)

    @Component.Builder
    interface Builder : BaseComponentBuilder<ProfileComponent, ProfileModuleDependencies>

}