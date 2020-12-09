package com.example.alotest.utils

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.alotest.R
import com.example.alotest.model.ImageModel
import com.google.android.material.snackbar.Snackbar


open class ActivityUtils : AppCompatActivity() {

    protected fun showSnackBar(view: View, message: String){
        val snack = Snackbar.make(view,message, Snackbar.LENGTH_LONG)
        val view: View = snack.view
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP
        view.layoutParams = params
        snack.show()
    }

    protected fun disableButton(button: Button){
        button.backgroundTintList = ContextCompat.getColorStateList(this, R.color.grey)
        button.setTextColor(Color.BLACK)
        button.isEnabled = false
        button.isClickable = false
    }

    protected fun enableButton(button: Button){
        button.backgroundTintList = ContextCompat.getColorStateList(this, R.color.colorPrimary)
        button.setTextColor(Color.WHITE)
        button.isEnabled = true
        button.isClickable = true
    }
}