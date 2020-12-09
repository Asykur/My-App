package com.example.alotest.presenter

import com.example.alotest.utils.ImageSource
import com.example.alotest.utils.LoadImgListView

class ImageListPresenter(private val view: LoadImgListView) {

    fun getNatureImage(){
        view.getNatureImageList(ImageSource().loadNatureImages())
    }

    fun getArchitectureImage(){
        view.getArchitectureImageList(ImageSource().loadArchitectureImages())
    }

    fun getTechnologyImage(){
        view.getTechnologyImageList(ImageSource().loadTechnologyImages())
    }
}