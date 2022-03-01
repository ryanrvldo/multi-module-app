package com.ryanrvldo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ryanrvldo.multimoduleapp.R
import javax.inject.Inject

class HomeNavHostViewModel @Inject constructor() : ViewModel() {

    private val topDestinationIds = setOf(R.id.homeFragment, R.id.profileFragment)

    private val _isTopLevelState = MutableLiveData<Boolean>()
    val isTopLevelState: LiveData<Boolean> get() = _isTopLevelState

    fun onNavControllerChanged(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            _isTopLevelState.postValue(topDestinationIds.contains(destination.id))
        }
    }

}