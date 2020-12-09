package com.example.alotest.presenter

import com.example.alotest.utils.ImageSource
import com.example.alotest.utils.LoadImgCategoryView

class CategoryImagePresenter(private var view : LoadImgCategoryView) {

    fun getImageCategory(){
        view.getImageCategoryList(ImageSource().loadImageCategory())
    }

}