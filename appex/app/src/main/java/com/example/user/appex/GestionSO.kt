package com.example.user.appex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.accessibility.AccessibilityEventCompat.setAction
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_gestion_so.*

class GestionSO : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_so)

//        Snackbar
//                .make(null,"${Usuario.nombreUsuario}",Snackbar.LENGTH_LONG)
//                .setAction("Action",null).show()
        btn_crear.setOnClickListener {
            crearSO();
        }

        btn_gestion.setOnClickListener {
            gestionSO();
        }


    }

    fun crearSO(){
        val intent = Intent(
                this,
                CrearSO::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun gestionSO(){
        val intent = Intent(
                this,
                GestionListaSO::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
