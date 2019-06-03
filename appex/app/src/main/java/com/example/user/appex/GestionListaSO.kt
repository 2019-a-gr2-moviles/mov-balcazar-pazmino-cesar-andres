package com.example.user.appex

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_gestion_lista_so.*

class GestionListaSO : Activity() {


    private val sos = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_lista_so)


        mostrarLista();

    }


    fun mostrarLista(){
        val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                SO.listaSOs
        )
        lista_sos.adapter = adapter
        lista_sos.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            gestionIndividual(position,SO.listaSOs[position].nombre)
        }


    }

//    fun gestionIndividual(position:Int){
//        val intent = Intent(
//                this,
//                GestionIndividualSO::class.java
//        )
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        intent.putExtra("idSO", position)
//        startActivity(intent)
//    }


    fun gestionIndividual(id:Int,so:String){
        val intent = Intent(
                this,
                GestionIndividualSO::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("so", so)
        intent.putExtra("idSO",id)
        startActivity(intent)
    }



}
