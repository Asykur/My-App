package com.example.alotest.utils

import com.example.alotest.model.ImageModel

interface LoadImgCategoryView {
    fun getImageCategoryList(imgCategoryList: ArrayList<ImageModel>)
}