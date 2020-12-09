package com.example.alotest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.alotest.R
import com.example.alotest.utils.ActivityUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ActivityUtils() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav.setOnNavigationItemSelectedListener (onNavigationSelectedListener)
        if (savedInstanceState == null){
            val fragment = HomeFragment.newInstance()
            addFragment(fragment)
        }
    }

    private val onNavigationSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragment: Fragment?
        val currentFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.container)
        when(item.itemId){
            R.id.nav_home -> {
                if (currentFragment !is HomeFragment){
                    fragment = HomeFragment.newInstance()
                    addFragment(fragment)
                }
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                if (currentFragment !is ProfileFragment){
                    fragment = ProfileFragment.newInstance()
                    addFragment(fragment)
                }
                return@OnNavigationItemSelectedListener true
            }
        }
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .addToBackStack(fragment.javaClass.simpleName)
            .commit()

    }

}