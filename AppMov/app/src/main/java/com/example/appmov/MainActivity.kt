package com.example.appmov

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actividad2.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_actividaddos
            .setOnClickListener {
            iractdos()
        }
    }

    fun iractdos(){
        var intent= Intent(this,Actividad2::class.java)

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        //finish()


        //enviar archivos
        intent.putExtra("nombre","Cesar")
        intent.putExtra("edad",23)

        startActivity(intent)

    }

}
