package com.example.ratesapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ratesapp.R
import com.example.ratesapp.view.adapter.HistoricoAdapter
import com.example.ratesapp.view.adapter.RatesAdapter
import com.example.ratesapp.viewmodel.HistoricoViewModel

class HistoricoFragment : Fragment() {

    private lateinit var historicoViewModel: HistoricoViewModel
    private val viewAdapter = HistoricoAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        historicoViewModel = ViewModelProvider(this).get(HistoricoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_historico, container, false)

        listar()
        observer()
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_historico).apply {
            setHasFixedSize(true)
            layoutManager =  LinearLayoutManager(context)
            adapter = viewAdapter
        }

        return root
    }

    private fun listar(){
        historicoViewModel.listarHistorico()
    }

    private fun observer(){
        historicoViewModel.List.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()){
                viewAdapter.updateList(it)
            }
        })
    }
}