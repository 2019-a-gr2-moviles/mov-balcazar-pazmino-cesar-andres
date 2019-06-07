package com.example.usrsig.reciclerview


import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager



class PersonasAdaptor(
        private val listaPersonas: List<Persona>,
        private val contexto: Activity,
        private val recyclerView: RecyclerView
) :
        RecyclerView.Adapter<PersonasAdaptor.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var nombreTextView: TextView;
        var cedulaTextView: TextView;
        var acbutton: Button;

        init{
            nombreTextView=view.findViewById(R.id.txt_1) as TextView
            cedulaTextView=view.findViewById(R.id.txt_2) as TextView
            acbutton=view.findViewById(R.id.btn_action) as Button

            val layout=view.findViewById(R.id.id_linear_layout) as LinearLayout

            layout.setOnClickListener {
                Log.i("re","layout pressed")
            }
        }
    }

}




//devuelve el numero de items de la lista
override fun getItemCount(): Int {
    //return listaPersonas.size
}

override fun onBindViewHolder(p0: PersonasAdaptor.MyViewHolder, p1: Int) {//el p1 es la posicion
//    val persona=listaPersonas[p1]
//    p0.nombreTextView.text=persona.nombre
//    p0.cedulaTextView.text=persona.cedula
}



//esta funcion define el template que vamos a usar

override fun onCreateViewHolder(p0: ViewGroup, p1: Int):
        PersonasAdaptor.MyViewHolder {


    val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                    R.layout.layout,
                    p0,
                    false
            )

    return PersonasAdaptor.MyViewHolder(itemView)
}