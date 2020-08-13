package com.example.ratesapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ratesapp.R
import com.example.ratesapp.services.model.HistoricoLocalModel
import com.example.ratesapp.view.viewHolder.HistoricoViewHolder
import com.example.ratesapp.view.viewHolder.RatesViewHolder

class HistoricoAdapter :RecyclerView.Adapter<HistoricoViewHolder>(){

    private var myDataset: List<HistoricoLocalModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricoViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_rates_historicos, parent, false)

        return HistoricoViewHolder(item)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: HistoricoViewHolder, position: Int) {
        holder.bindData(myDataset[position])
    }

    fun updateList(list: List<HistoricoLocalModel>) {
        myDataset = list
        notifyDataSetChanged()
    }

}