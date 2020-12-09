package com.example.alotest.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.example.alotest.R
import com.example.alotest.db.LocalStorage
import com.example.alotest.utils.ActivityUtils
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.launch


class LoginActivity : ActivityUtils() {
    private val disposable = CompositeDisposable()
    private var eml = PublishSubject.create<Boolean>()
    private var pwd = PublishSubject.create<Boolean>()
    private lateinit var strEmail: String
    private lateinit var strPwd: String

    private val localStorage by lazy {
        LocalStorage(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            saveUserData()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        disposable.add(RxTextView.textChanges(etEmail)
            .doOnError { t -> Log.e("ERR", t.message.toString()) }
            .skip(1)
            .subscribe { email ->
                if (TextUtils.isEmpty(email.toString())) {
                    etEmail.error = "Email tidak boleh kosong"
                    etEmail.requestFocus()
                    eml.onNext(false)
                } else {
                    if (!(email.toString().contains("@") && email.toString().contains("."))) {
                        etEmail.error = "Format email salah"
                        etEmail.requestFocus()
                        eml.onNext(false)
                    } else {
                        strEmail = email.toString()
                        eml.onNext(true)
                    }
                }
            })

        disposable.add(RxTextView.textChanges(etPassword)
            .doOnError { t -> Log.e("ERR", t.message.toString()) }
            .skip(1)
            .subscribe { password ->
                if (TextUtils.isEmpty(password.toString())) {
                    etPassword.error = "Password tidak boleh kosong"
                    etPassword.requestFocus()
                    pwd.onNext(false)
                } else {
                    strPwd = password.toString()
                    pwd.onNext(true)
                }
            })

        disposable.addAll(isValidForm().subscribe { isValid ->
            if (isValid) {
                enableButton(btnLogin)
            } else {
                disableButton(btnLogin)
            }
        })

    }

    private fun isValidForm(): Observable<Boolean> {
        return Observable.combineLatest(
            eml,
            pwd,
            BiFunction { email, pwd ->
                email && pwd
            })
    }

    private fun saveUserData() {
        lifecycleScope.launch {
            localStorage.saveEmail(strEmail)
        }
    }
}