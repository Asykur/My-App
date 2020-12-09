package com.example.alotest.utils

import com.example.alotest.model.ImageModel

class ImageSource {

    fun loadImageCategory(): ArrayList<ImageModel>{
        val images = ArrayList<ImageModel>()
        images.add(ImageModel("https://images.unsplash.com/photo-1566484129782-3dd362a75698?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2089&q=80",Constant.nature))
        images.add(ImageModel("https://images.unsplash.com/photo-1607214240122-5464f27f887f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2061&q=80",Constant.architecture))
        images.add(ImageModel("https://images.unsplash.com/photo-1605835963874-a7c87f56259e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80",Constant.technology))
        return images
    }

    fun loadNatureImages():ArrayList<String>{
        val images = ArrayList<String>()
        images.add("https://images.unsplash.com/photo-1606801802869-052b8c017084?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80")
        images.add("https://images.unsplash.com/photo-1606749128514-01add013f5c7?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80")
        images.add("https://images.unsplash.com/photo-1606641119957-e7db5241ae4f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80")
        return images
    }

    fun loadArchitectureImages():ArrayList<String>{
        val images = ArrayList<String>()
        images.add("https://images.unsplash.com/photo-1607270134634-75fb2ac1afd4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80")
        images.add("https://images.unsplash.com/photo-1461072492560-82b4f2ff2799?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80")
        images.add("https://images.unsplash.com/photo-1534166287108-181e69a3e7d8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80")
        return images
    }

    fun loadTechnologyImages():ArrayList<String>{
        val images = ArrayList<String>()
        images.add("https://images.unsplash.com/photo-1597765221336-1f65bb4c4fee?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80")
        images.add("https://images.unsplash.com/photo-1526498460520-4c246339dccb?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80")
        images.add("https://images.unsplash.com/photo-1604329051903-d89ddd523330?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1502&q=80")
        return images
    }

}