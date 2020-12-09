package com.example.alotest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.alotest.view.ImageSliderFragment

class BannerAdapter (fragmentManager: FragmentManager,
                     private val banners: List<String>) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(pos: Int): Fragment {
        return ImageSliderFragment.newInstance(banners[pos])
    }

    override fun getCount(): Int = banners.size

}