package com.example.alarma

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.ToggleButton
import java.util.ArrayList

class Adaptador(): RecyclerView.Adapter<Adaptador.MyViewHolder>() {



    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nombreTextView: TextView;
        var toggleO:Switch;

        init {
            nombreTextView = view.findViewById(R.id.id_hora) as TextView;
            toggleO = view.findViewById(R.id.id_switch) as Switch;


            }
        }



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Adaptador.MyViewHolder {

            val itemView = LayoutInflater
                .from(p0.context)
                .inflate(
                    R.layout.layout_item,
                    p0,
                    false
                )

            return MyViewHolder(itemView)
        }

    override fun getItemCount(): Int {
        return Hora.listaHoras.size;
    }

    override fun onBindViewHolder(p0: Adaptador.MyViewHolder, p1: Int) {
        val hora = Hora.listaHoras[p1]

        p0.nombreTextView.text = hora.hora
        p0.toggleO.text = hora.dias.toString()
    }

}