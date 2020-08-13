package com.example.ratesapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ratesapp.R
import com.example.ratesapp.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var loginViewModew : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModew = ViewModelProvider(this).get(LoginViewModel::class.java)
        setListeners()
        verifyLoggeduser()
        observer()
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == txt_login.id){
            startActivity(Intent(this, RegistrarActivity::class.java))
        }else if (id == bt_login.id){
            handleLogin()
        }
    }

    private fun setListeners(){
        txt_login.setOnClickListener(this)
        bt_login.setOnClickListener(this)
    }

    private fun handleLogin(){
        val email = et_email.text.toString()
        val senha = et_password.text.toString()
        if ( email == "" || senha == ""){
            Toast.makeText(this,"Todos os campos devem estar preenchidos",Toast.LENGTH_SHORT).show()
        }else{
            loginViewModew.logar(email,senha)
        }
    }

    private fun observer(){
        loginViewModew.logar.observe(this, Observer {
            if (it){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this,"Usuário e senha não cadastrado ou incorreto!",Toast.LENGTH_SHORT).show()
            }
        })
        loginViewModew.logado.observe(this, Observer {
            if (it){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })
    }

    private fun verifyLoggeduser(){
        loginViewModew.verifyLoggedUser()
    }
}