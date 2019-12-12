package com.erkan.spotifyapp.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.erkan.spotifyapp.R
import com.erkan.spotifyapp.ui.favorites.FavoriteFragment
import com.erkan.spotifyapp.ui.radios.RadiosFragment

class MainPagerAdapter(
    context: Context,
    fragmentManager: FragmentManager,
    behavior: Int
) :
    FragmentStatePagerAdapter(fragmentManager, behavior) {

    private val arrayTabList = context.resources.getStringArray(R.array.tabs)

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> RadiosFragment.newInstance()
            1 -> FavoriteFragment.newInstance()
            else -> throw Throwable()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return arrayTabList.get(position)
    }

    override fun getCount() = 2

}