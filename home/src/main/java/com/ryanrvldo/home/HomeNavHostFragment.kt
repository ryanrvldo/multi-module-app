package com.ryanrvldo.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.ui.setupWithNavController
import com.ryanrvldo.commons.ui.extensions.buildComponent
import com.ryanrvldo.commons.ui.extensions.requireCompatActivity
import com.ryanrvldo.commons.ui.extensions.setupWithNavController
import com.ryanrvldo.core.ui.ViewModelFactory
import com.ryanrvldo.home.databinding.FragmentHomeNavHostBinding
import com.ryanrvldo.home.di.DaggerHomeComponent
import javax.inject.Inject
import com.ryanrvldo.multimoduleapp.R as AppR

class HomeNavHostFragment : Fragment() {

    private var _binding: FragmentHomeNavHostBinding? = null
    private val binding: FragmentHomeNavHostBinding
        get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel by viewModels<HomeNavHostViewModel> { factory }

    private val navGraphIds = listOf(
        AppR.navigation.home_nav_graph,
        AppR.navigation.profile_nav_graph
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        buildComponent(DaggerHomeComponent.builder()).inject(this)
    }

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
        viewModel.isTopLevelState.observe(requireActivity()) { isTopLevel ->
            binding.bottomNavigation.isVisible = isTopLevel
        }
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
            viewModel.onNavControllerChanged(it)
            binding.toolbar.setupWithNavController(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}