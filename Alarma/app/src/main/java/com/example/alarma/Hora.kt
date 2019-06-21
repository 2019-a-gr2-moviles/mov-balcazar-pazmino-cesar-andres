package com.example.alarma

class Hora(var hora:String,var dias: ArrayList<String>) {

    companion object{

        val listaHoras= arrayListOf<Hora>(
            Hora("  6:00",dias = arrayListOf("L","M","M","J","V","S","D")),
            Hora("  7:00",dias = arrayListOf("L","M","M","J","V","S","D")),
            Hora("  5:30",dias = arrayListOf("V","S")),
            Hora("  5:30",dias = arrayListOf("M","J","V")),
            Hora("  4:30",dias = arrayListOf("S","D")),
            Hora("  19:30",dias = arrayListOf("M","J","V")),
            Hora("  20:30",dias = arrayListOf("D"))



        )

        fun agregarHora(hora:Hora){
            listaHoras.add(hora);
        }
    }
}