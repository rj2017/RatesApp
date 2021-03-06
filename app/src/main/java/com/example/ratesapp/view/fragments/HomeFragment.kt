package com.example.ratesapp.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ratesapp.R
import com.example.ratesapp.util.RatesUtil.Companion.getCodigoPorNome
import com.example.ratesapp.view.adapter.RatesAdapter
import com.example.ratesapp.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var homeViewModel: HomeViewModel
    private val viewAdapter = RatesAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel.listar("BRL")


        val spinner = root.findViewById<Spinner>(R.id.spinner_val_pesquisa)
        spinner.onItemSelectedListener = this

        root.findViewById<RecyclerView>(R.id.recycler_taxas_atualizadas).apply {
            setHasFixedSize(true)
            layoutManager =  LinearLayoutManager(context)
            adapter = viewAdapter
        }



        ArrayAdapter.createFromResource(
            root.context,
            R.array.rates_array,
            android.R.layout.simple_spinner_item
        ).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


        observe()

        return root
    }

    private fun handlePesquisa(){
        val base = getCodigoPorNome(spinner_val_pesquisa.selectedItem.toString())
        homeViewModel.listar(base)
    }

    private fun observe(){
        homeViewModel.list.observe(viewLifecycleOwner, Observer {
            if (it != null){
                viewAdapter.updateList(it)
            }
        })

        homeViewModel.validation.observe(viewLifecycleOwner, Observer {
            if (it.sucess()){
                Toast.makeText(context,"Informações carregadas com sucesso!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,it.failure(), Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        val s =""
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        handlePesquisa()
    }


}