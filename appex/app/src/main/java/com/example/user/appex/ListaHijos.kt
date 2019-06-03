package com.example.user.appex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_gestion_lista_so.*
import kotlinx.android.synthetic.main.activity_lista_hijos.*

class ListaHijos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_hijos)

        var idpadre=intent.getIntExtra("idso",0);
        var padre=intent.getStringExtra("so");

        mostrarLista(SO.devolverIndex(padre),padre);
    }


    fun mostrarLista(idpadre:Int,padre:String){

        var listaporpadre=Aplicacion.appporSO(idpadre);
        val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                listaporpadre
        )
        list_hijos.adapter = adapter
        list_hijos.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            gestionIndividual(listaporpadre[position].nombre,idpadre,padre)
        }

    }

    fun gestionIndividual(app:String,idpadre: Int,padre:String){

        var idappactual=Aplicacion.devolverIndex(app);

        val intent = Intent(
                this,
                GestionIndividualApp::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("idapp", idappactual)
        intent.putExtra("idso",idpadre)
        intent.putExtra("so",padre)
        startActivity(intent)
    }
}
