package com.example.alotest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.alotest.R
import kotlinx.android.synthetic.main.fragment_image_slider.*

class ImageSliderFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = arguments?.getString("img")
        Glide.with(this).load(image).into(imgDetail)
    }


    companion object {
        /**
         * new instance pattern for fragment
         */
        @JvmStatic
        fun newInstance(url: String): ImageSliderFragment {
            val sliderFragment = ImageSliderFragment()
            val args = Bundle()
            args.putString("img", url)
            sliderFragment.arguments = args
            return sliderFragment
        }
    }
}