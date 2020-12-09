package com.example.alotest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alotest.R
import com.example.alotest.adapter.ImageListAdapter
import com.example.alotest.model.ImageModel
import com.example.alotest.presenter.CategoryImagePresenter
import com.example.alotest.utils.Constant
import com.example.alotest.utils.ImageSource
import com.example.alotest.utils.LoadImgCategoryView
import kotlinx.android.synthetic.main.fragment_home.view.*
import javax.sql.DataSource

class HomeFragment : Fragment(), LoadImgCategoryView {

    private val adapter = ImageListAdapter()
    private var imgCategoryList =  ArrayList<ImageModel>()

    companion object {
        fun newInstance():HomeFragment{
            val homeFragment = HomeFragment()
            val args = Bundle()
            homeFragment.arguments = args
            return homeFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val presenter = CategoryImagePresenter(this)
        presenter.getImageCategory()

        adapter.setImageData(imgCategoryList)
        view.rvImages.adapter = adapter
        view.rvImages.layoutManager = LinearLayoutManager(activity?.applicationContext, RecyclerView.VERTICAL,false)
    }

    override fun getImageCategoryList(imgCategoryList: ArrayList<ImageModel>) {
        this.imgCategoryList = imgCategoryList
    }


}