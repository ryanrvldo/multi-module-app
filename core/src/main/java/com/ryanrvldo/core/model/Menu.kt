package com.ryanrvldo.core.model

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes

data class Menu(
    val title: String,
    @IdRes val navId: Int,
    @DrawableRes val bannerId: Int? = null,
    val subtitle: String? = null
)
