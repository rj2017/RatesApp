package com.example.ratesapp.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ratesapp.R
import com.example.ratesapp.view.AlterarSenhaActivity
import com.example.ratesapp.view.MainActivity
import com.example.ratesapp.viewmodel.MainViewModel
import com.example.ratesapp.viewmodel.PerfilViewModel
import kotlinx.android.synthetic.main.fragment_perfil.*

class PerfilFragment : Fragment() {

    private lateinit var perfilViewModel: PerfilViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_perfil, container, false)
        perfilViewModel = ViewModelProvider(this).get(PerfilViewModel::class.java)

        val button = root.findViewById<Button>(R.id.button_alterar_perfil)
        val alterarSenha = root.findViewById<TextView>(R.id.alterar_senha)

        button.setOnClickListener {
            alterarDadosPessoais()
        }

        alterarSenha.setOnClickListener{
            startActivity(Intent(context,AlterarSenhaActivity::class.java))
        }

        observer()
        return root
    }

    override fun onResume() {
        perfilViewModel.loadDados()
        super.onResume()
    }

    fun alterarDadosPessoais(){
        val nome = edttxt_perfil_nome.text.toString()
        val email = edttxt_perfil_email.text.toString()

        if (nome.isEmpty() || email.isEmpty()){
            Toast.makeText(context,"Nenhum campo deve estar vazio, gentileza verificar!", Toast.LENGTH_LONG).show()
        }else{
            perfilViewModel.alterarDadosUsuario(nome,email)
        }
    }

    fun observer(){
        perfilViewModel.userInfor.observe(viewLifecycleOwner, Observer {
            if (it != null){
                edttxt_perfil_nome.setText(it.nome)
                edttxt_perfil_email.setText(it.email)
            }
        })
        perfilViewModel.isAlterado.observe(viewLifecycleOwner, Observer {
            if (it){
                Toast.makeText(context,"Dados Alterado com sucesso", Toast.LENGTH_LONG).show()
                startActivity(Intent(context,MainActivity::class.java))
            }else{
                Toast.makeText(context,"Gentileza alterar alguma informação para que seja possível a alteração", Toast.LENGTH_LONG).show()
            }
        })
    }


}