package com.example.ratesapp.view.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ratesapp.R
import com.example.ratesapp.util.RatesUtil
import com.example.ratesapp.util.RatesUtil.Companion.getImageMoeda
import com.example.ratesapp.util.RatesUtil.Companion.getNomeMoeda
import java.text.DecimalFormat
import kotlin.math.roundToLong

class RatesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private var mImageView : ImageView = itemView.findViewById(R.id.row_image_list)
    private var mTextNome: TextView = itemView.findViewById(R.id.row_txt_cambio)
    private var mTextValor: TextView = itemView.findViewById(R.id.row_txt_valor)

    fun bindData(rates : Pair<String,Float>){
        val(nome, valor) = rates
        val image = if (getImageMoeda(nome) == 0){ R.drawable.block} else{ getImageMoeda(nome)}
        val dec  = DecimalFormat("#,##0.00")

        this.mTextNome.text = "${getNomeMoeda(nome)} :"
        this.mTextValor.text = dec.format(valor)
        this.mImageView.setImageResource(image)
    }
}