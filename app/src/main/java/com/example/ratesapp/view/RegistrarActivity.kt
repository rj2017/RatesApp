package com.example.ratesapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ratesapp.R
import com.example.ratesapp.services.model.UserLocalModel
import com.example.ratesapp.services.repository.local.SecurityPreferences
import com.example.ratesapp.viewmodel.RegistrarViewModel
import kotlinx.android.synthetic.main.activity_register.*

class RegistrarActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var registrarViewModel: RegistrarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registrarViewModel = ViewModelProvider(this).get(RegistrarViewModel::class.java)

        setListeners()
        observer()
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == txt_register.id){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }else if (id == bt_register.id){
            handleRegistrar()
        }
    }

    private fun setListeners(){
        txt_register.setOnClickListener(this)
        bt_register.setOnClickListener(this)
    }

    private fun handleRegistrar(){
        val nome = et_name_register.text.toString()
        val email = et_email_register.text.toString()
        val senha =  et_password_register.text.toString()
        val confSenha = et_password_register_confirm.text.toString()

        if (senha != confSenha){
            Toast.makeText(this,"As senhas devem ser indênticas!", Toast.LENGTH_LONG).show()
        }else if (nome == "" || email =="" || senha == "" || confSenha == ""){
            Toast.makeText(this,"Todos os campos devem estar preenchidos!", Toast.LENGTH_LONG).show()
        }else if (senha.length < 5){
            Toast.makeText(this,"A senha deve ter no mínimo 5 caracteres!", Toast.LENGTH_LONG).show()
        } else{
            val user = UserLocalModel()
            user.nome = nome
            user.email = email
            user.password =senha
            registrarViewModel.registrar(user)
        }

    }

    private fun observer(){
        registrarViewModel.save.observe(this, Observer {
            if (it){
                Toast.makeText(this,"usuário Cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }else{
                Toast.makeText(this,"Não foi possível cadastrar o usuário", Toast.LENGTH_LONG).show()
            }
        })
    }
}