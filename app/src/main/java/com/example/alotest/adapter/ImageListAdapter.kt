package com.example.alotest.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alotest.R
import com.example.alotest.model.ImageModel
import com.example.alotest.view.DetailActivity
import kotlinx.android.synthetic.main.item_image.view.*

class ImageListAdapter : RecyclerView.Adapter<ImageListAdapter.VH>() {

    private var imageList = ArrayList<ImageModel>()

    companion object {
        const val itemKey = "image"
    }

    fun setImageData(images: ArrayList<ImageModel>) {
        this.imageList = images
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(imageList[position])
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private lateinit var itemImage: String
        private lateinit var itemCategory: String

        init {
            itemView.setOnClickListener(this)
        }

        fun onBind(dataSource: ImageModel) {
            itemImage = dataSource.image
            itemCategory = dataSource.category
            Glide.with(itemView.context)
                .load(dataSource.image)
                .into(itemView.imgCategory)
            itemView.tvCategory.text = dataSource.category
        }

        override fun onClick(v: View?) {
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra(itemKey, itemCategory)
            itemView.context.startActivity(intent)
        }

    }
}