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

        btn_f_2.setOnClickListener {
            segundoFragmento();
        }

        btn_f_3.setOnClickListener {
            tercerFragmento();
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
        transaccion.replace(R.id.constraintfragmentos,fragmento); //transaccion.add causa que se sobrepongan :v
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
        transaccion.replace(R.id.constraintfragmentos,fragmento);

        transaccion.commit();
    }

    fun tercerFragmento(){
        // 1) Manager
        val fragmentManager=supportFragmentManager;
        // 2) Empezar transaccion
        val transaccion=fragmentManager.beginTransaction();
        // 3) Definir la instancia del fragmento
        val fragmento= terceroFragment();


        val argumentos = Bundle();
        argumentos.putInt("contador",1);
        fragmento.arguments = argumentos;


        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.constraintfragmentos,fragmento);

        transaccion.commit();
    }



    //https://developer.android.com/training/basics/fragments/communicating ->comunicacion de papa a hijo y viceversa (a dos vias mediante eventos)


}
