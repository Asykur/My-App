package com.example.alotest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.example.alotest.R
import com.example.alotest.db.LocalStorage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private val localStorage by lazy {
        LocalStorage(applicationContext)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        lifecycleScope.launch {
            delay(2000)
            localStorage.getSavedEmail.asLiveData().observe(this@SplashActivity, Observer { email ->
                if (!TextUtils.isEmpty(email)) {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                }else{
                    startActivity(Intent(applicationContext, LoginActivity::class.java))
                    finish()
                }
            })
        }
    }
}