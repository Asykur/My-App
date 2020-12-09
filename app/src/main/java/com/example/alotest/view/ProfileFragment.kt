package com.example.alotest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.alotest.R
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    companion object {
        fun newInstance(): ProfileFragment {
            val profileFragment = ProfileFragment()
            val args = Bundle()
            profileFragment.arguments = args
            return profileFragment
        }
    }
}