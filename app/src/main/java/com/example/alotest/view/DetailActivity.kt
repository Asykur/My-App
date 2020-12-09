package com.example.alotest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alotest.R
import com.example.alotest.adapter.ImageListAdapter
import com.example.alotest.presenter.ImageListPresenter
import com.example.alotest.utils.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_detail.*
import javax.sql.DataSource

class DetailActivity : ActivityUtils(), LoadImgListView {

    private var detailImgList = ArrayList<String>()
    private var groupAdapter = GroupAdapter<ViewHolder>()
    private var natureImgList = ArrayList<String>()
    private var architectureImgList = ArrayList<String>()
    private var technoImgList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val presenter = ImageListPresenter(this)
        val extras = intent.extras
        if (extras != null){
            val category = extras.getString(ImageListAdapter.itemKey)
            detailImgList = when {
                category.equals(Constant.architecture) -> {
                    presenter.getArchitectureImage()
                    architectureImgList
                }
                category.equals(Constant.nature) -> {
                    presenter.getNatureImage()
                    natureImgList
                }
                else -> {
                    presenter.getTechnologyImage()
                    technoImgList
                }
            }
        }

        rvDetail.apply {
            layoutManager = LinearLayoutManager(this@DetailActivity)
            adapter = groupAdapter
        }

        // declare banner carousel
        val bannerCarouselItem = BannerCarouselItem(detailImgList, supportFragmentManager)
        groupAdapter.add(bannerCarouselItem)

    }

    override fun getNatureImageList(natureImgList: ArrayList<String>) {
        this.natureImgList = natureImgList
    }

    override fun getArchitectureImageList(architectureImgList: ArrayList<String>) {
        this.architectureImgList = architectureImgList
    }

    override fun getTechnologyImageList(technoImgList: ArrayList<String>) {
        this.technoImgList = technoImgList
    }
}