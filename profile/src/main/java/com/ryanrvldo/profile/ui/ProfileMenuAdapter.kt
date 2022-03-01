package com.ryanrvldo.profile.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ryanrvldo.core.model.Menu
import com.ryanrvldo.profile.R
import com.ryanrvldo.profile.databinding.MainMenuItemBinding
import timber.log.Timber
import javax.inject.Inject

class ProfileMenuAdapter @Inject constructor(context: Context) :
    RecyclerView.Adapter<ProfileMenuAdapter.ProfileMenuVH>() {

    private val menuList = mutableListOf<Menu>()

    init {
        val titles = context.resources.getStringArray(R.array.profile_menu_title)
        val navIds = context.resources.obtainTypedArray(R.array.profile_menu_navigation)
        for ((idx, title) in titles.withIndex()) {
            menuList.add(Menu(title, navIds.getResourceId(idx, -1)))
        }
        navIds.recycle()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileMenuVH {
        return ProfileMenuVH(
            MainMenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfileMenuVH, position: Int) {
        holder.bind(menuList[position])
    }

    override fun getItemCount(): Int = menuList.size

    inner class ProfileMenuVH(private val binding: MainMenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Menu) {
            binding.tvTitle.text = item.title
            binding.root.setOnClickListener {
                if (item.navId != -1) {
                    it.findNavController().navigate(item.navId)
                } else {
                    Timber.e(
                        "Item with title: '%s' has not been set up navigation's id yet.",
                        item.title
                    )
                }
            }
        }
    }

}