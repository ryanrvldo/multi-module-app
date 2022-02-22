package com.ryanrvldo.multimoduleapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ryanrvldo.multimoduleapp.R
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            delay(1500)
            findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToHomeFragment())
        }
    }

}