package com.example.ratesapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ratesapp.R
import com.example.ratesapp.view.viewHolder.RatesViewHolder

class RatesAdapter : RecyclerView.Adapter<RatesViewHolder>() {

    private var myDataset: List<Pair<String,Float>> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_rates_list, parent, false)

        return RatesViewHolder(item)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: RatesViewHolder, position: Int) {
        holder.bindData(myDataset[position])
    }

    fun updateList(list: List<Pair<String,Float>>) {
        myDataset = list
        notifyDataSetChanged()
    }

}