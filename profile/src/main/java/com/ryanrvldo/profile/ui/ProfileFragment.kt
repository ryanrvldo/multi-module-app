package com.ryanrvldo.profile.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ryanrvldo.commons.ui.extensions.buildComponent
import com.ryanrvldo.profile.databinding.FragmentProfileBinding
import com.ryanrvldo.profile.di.DaggerProfileComponent
import javax.inject.Inject

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = _binding!!

    @Inject
    lateinit var menuAdapter: ProfileMenuAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        buildComponent(DaggerProfileComponent.builder()).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvMenu.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvMenu.adapter = menuAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}