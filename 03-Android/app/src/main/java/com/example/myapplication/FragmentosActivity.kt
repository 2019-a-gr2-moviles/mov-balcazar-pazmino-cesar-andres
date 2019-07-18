package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        btn_f_1.setOnClickListener {
           primerFragmento();
        }
    }

    fun primerFragmento(){
        // 1) Manager
        val fragmentManager=supportFragmentManager;
        // 2) Empezar transaccion
        val transaccion=fragmentManager.beginTransaction();
        // 3) Definir la instancia del fragmento
        val fragmento= primerFragment();
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.constraintfragmentos,fragmento);
        // 5) Terminar transaccion
        transaccion.commit();
    }


    fun segundoFragmento(){
        // 1) Manager
        val fragmentManager=supportFragmentManager;
        // 2) Empezar transaccion
        val transaccion=fragmentManager.beginTransaction();
        // 3) Definir la instancia del fragmento
        val fragmento= segundoFragment();
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.constraintfragmentos,fragmento)
    }

    fun tercerFragmento(){
        // 1) Manager
        val fragmentManager=supportFragmentManager;
        // 2) Empezar transaccion
        val transaccion=fragmentManager.beginTransaction();
        // 3) Definir la instancia del fragmento
        val fragmento= terceroFragment();
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.constraintfragmentos,fragmento)
    }


}
