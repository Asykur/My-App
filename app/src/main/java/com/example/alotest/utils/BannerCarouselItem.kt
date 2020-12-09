package com.example.alotest.utils

import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alotest.R
import com.example.alotest.adapter.BannerAdapter
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.corousel_banner_item.view.*


class BannerCarouselItem (private val banners: List<String>, private val supportFragmentManager: FragmentManager) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val viewPagerAdapter = BannerAdapter(supportFragmentManager, banners)
        viewHolder.itemView.viewPagerBanner.adapter = viewPagerAdapter
        viewHolder.itemView.indicator.setViewPager(viewHolder.itemView.viewPagerBanner)
    }

    override fun getLayout(): Int = R.layout.corousel_banner_item
}