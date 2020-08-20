package com.example.ratesapp.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ratesapp.R
import com.example.ratesapp.view.fragments.PerfilFragment
import com.example.ratesapp.viewmodel.AlterarSenhaViewModel
import kotlinx.android.synthetic.main.activity_alterar_senha.*


class AlterarSenhaActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var alterarSenhaViewModel : AlterarSenhaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alterar_senha)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setHomeButtonEnabled(true);

        alterarSenhaViewModel = ViewModelProvider(this).get(AlterarSenhaViewModel::class.java)
        observer()
        setListeners()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }

    fun setListeners(){
        button_alterar_senha.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        when(id){
            R.id.button_alterar_senha -> handleAlterarSenha()
        }
    }

    fun handleAlterarSenha(){
        val senhaAtual = edt_senha_atual.text.toString()
        val senhaNova = edt_senha_nova.text.toString()

        if (senhaAtual.isEmpty() || senhaNova.isEmpty()){
            Toast.makeText(this,"Todos os campos devem estar preenchidos!", Toast.LENGTH_LONG).show()
        }else if (senhaNova.length < 5){
            Toast.makeText(this,"A nova senha deve ter no minímo 5 caracteres!", Toast.LENGTH_LONG).show()
        }else if (senhaAtual.equals(senhaNova)){
            Toast.makeText(this,"As senhas devem ser diferentes!", Toast.LENGTH_LONG).show()
        }else{
            alterarSenhaViewModel.alterarSenha(senhaNova)
        }
    }

    fun observer(){
        alterarSenhaViewModel.isAlterado.observe(this, Observer {
            if (it){
                Toast.makeText(this,"Senha Alterada com sucesso!", Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"A senha atual digitada não confere com a senha utilizada!", Toast.LENGTH_LONG).show()
            }
        })
    }
}