package com.example.usrsig.reciclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recicler_view.*

class ReciclerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        val lista= arrayListOf<Persona>()

        val recycler_view=rv_personas
        val actividad=this

        lista.add("Andres","1")
        lista.add("Andres","2")
        lista.add("Andres","3")

        val adaptadorPersona=PersonasAdaptor(lista,actividad,recycler_view)


        rv_personas.adapter=adaptadorPersona;
        rv_personas.itemAnimator=DefaultItemAnimator();
        rv_personas.layoutManager=LinearLayoutManager(this);

        adaptadorPersona.notifyDataSetChanged()
    }
}
