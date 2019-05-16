package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    //las actividades tienen estado->tienen un ciclo de vida
    //el oncreate es una de las etpas del ciclo de vida
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn_actividaddos.setOnClickListener {
            iractdos()
        }
    }


    fun iractdos(){
        var intent=Intent(this,Actividad_dos::class.java)
        startActivity(intent)
    }
}
