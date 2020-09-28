package com.example.ratesapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ratesapp.R
import com.example.ratesapp.util.RatesUtil.Companion.getCodigoPorNome
import com.example.ratesapp.viewmodel.ConversaoViewModel
import kotlinx.android.synthetic.main.fragment_conversao.*
import java.text.SimpleDateFormat
import java.util.*

class ConversaoFragment : Fragment() {

    private lateinit var conversaoViewModel: ConversaoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        conversaoViewModel = ViewModelProvider(this).get(ConversaoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_conversao, container, false)
        val button = root.findViewById<Button>(R.id.bt_converter)

        button.setOnClickListener {
            handleConversao()
        }

        observer()
        //tratamento dos spinner
        val spinner_base: Spinner = root.findViewById(R.id.spinner_val_base)
        val spinner_referencia: Spinner = root.findViewById(R.id.spinner_val_referencia)

        val array = mapOf<String, String>("BRL" to "Real")

        ArrayAdapter.createFromResource(
            root.context,
            R.array.rates_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_base.adapter = adapter
            spinner_referencia.adapter = adapter
        }
        return root
    }


    private fun handleConversao() {
        val base = getCodigoPorNome(spinner_val_base.selectedItem.toString())
        val referencia = getCodigoPorNome(spinner_val_referencia.selectedItem.toString())
        val valBase = if (edit_valor_base.text.toString() != "") edit_valor_base.text.toString()
            .toFloat() else 1.0F

        val date = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm:ss a", Locale.getDefault())
        conversaoViewModel.converter(base, referencia, valBase, dateFormat.format(date))
    }

    private fun observer() {
        conversaoViewModel.resultado.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                edit_valor_referencia.setText(it.toString())
            } else {
                Toast.makeText(context, "Não localizado a moeda informada", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

}