package com.example.appmov
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_actividad2.*

class Actividad2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)



        val nombre:String?=intent.getStringExtra("nombre"); //? que puede o no ser nulo
        val edad:Int?=intent.getIntExtra("edad",0)

        println(nombre)
        println(edad)



        Log.i("intents","Nombre: $nombre")
        Log.i("intents","Edad: $edad")



        btn_actividaduno.setOnClickListener {
            iractuno()
        }
    }

    fun iractuno(){
        var intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

}
