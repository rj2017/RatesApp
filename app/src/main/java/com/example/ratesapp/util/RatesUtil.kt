package com.example.ratesapp.util

class RatesUtil {

    companion object{
        fun getNomeMoeda(sigla : String) : String{
            var nome : String = ""
            when(sigla){
                "BRL" -> nome = "Real Brasileiro"
                "EUR" -> nome = "Euro"
                "USD" -> nome = "Dóla EUA"
                "CAD" -> nome = "Dóla Canadense"
                "HKD" -> nome = "Dólar de Hong Kong"
                "ISK" -> nome = "Coroa islandesa"
                "PHP" -> nome = "Peso filipino"
                "DKK" -> nome = "Coroa dinamarquesa"
                "HUF" -> nome = "Forint"
                "CZK" -> nome = "Coroa checa"
                "GBP" -> nome = "Libra esterlina"
                "RON" -> nome = "Moeda da Romênia"
                "SEK" -> nome = "Coroa sueca"
                "IDR" -> nome = "Rupiah"
                "INR" -> nome = "Rupia indiana"
                "HRK" -> nome = "Kuna"
                "JPY" -> nome = "Yen"
                "RUB" -> nome = "Rublo Russo"
                "NOK" -> nome = "Coroa Norueguesa"
                "THB" -> nome = "Baht"
                "CHF" -> nome = "Franco suíço"
                "MYR" -> nome = "Ringgit da Malásia"
                "BGN" -> nome = "Lev búlgaro"
                "TRY" -> nome = "Lira turca"
                "CNY" -> nome = "Ren-Min-Bi, Yuan"
                "NZD" -> nome = "Dólar neozelandês"
                "ZAR" -> nome = "Rand"
                "MXN" -> nome = "Peso mexicano"
                "SGD" -> nome = "Dólar de Cingapura"
                "AUD" -> nome = "Dólar australiano"
                "ILS" -> nome = "shekel israelita"
                "KRW" -> nome = "Won sul-coreano"
                "PLN" -> nome = "Zloty"
            }
            return nome
        }
    }
}