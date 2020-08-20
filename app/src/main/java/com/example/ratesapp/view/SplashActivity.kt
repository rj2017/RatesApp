package com.example.ratesapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ratesapp.R
import com.example.ratesapp.viewmodel.SplashViewModel

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT : Long = 2000
    private lateinit var splahsViewModel : SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splahsViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        isLogin()
        observer()
        Handler().postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))
        },SPLASH_TIME_OUT)
    }

    fun isLogin(){
        splahsViewModel.isLogado()
    }

    fun observer(){
        splahsViewModel.logado.observe(this, Observer {
            if (it){
                finish()
            }
        })
    }
}