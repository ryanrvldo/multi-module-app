package com.ryanrvldo.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.ui.NavigationUI
import com.ryanrvldo.commons.ui.extensions.requireCompatActivity
import com.ryanrvldo.commons.ui.extensions.setupWithNavController
import com.ryanrvldo.home.databinding.FragmentHomeNavHostBinding
import com.ryanrvldo.multimoduleapp.R as AppR

class HomeNavHostFragment : Fragment() {

    private var _binding: FragmentHomeNavHostBinding? = null
    private val binding: FragmentHomeNavHostBinding
        get() = _binding!!

    private val navGraphIds = listOf(
        AppR.navigation.home_nav_graph,
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeNavHostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireCompatActivity().setSupportActionBar(binding.toolbar)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val navController = binding.bottomNavigation.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.home_nav_host,
            intent = requireActivity().intent
        )
        navController.observe(viewLifecycleOwner) {
            NavigationUI.setupActionBarWithNavController(requireCompatActivity(), it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}