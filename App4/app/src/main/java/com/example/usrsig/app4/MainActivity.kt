package com.example.usrsig.app4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_parcelable.setOnClickListener{
            irAParcelable()
        }

    }


    fun irAParcelable(){
        val intentExplicito=Intent(
            this,
            Parcelable::class.java
        )
        val cesar=Usuario("Cesar",23,Date(),1000.5)

        intentExplicito.putExtra("user",cesar)//puedo hacer esto porque la clase esta como Parcelable


        val mascota=Mascota("perro",cesar)
        intentExplicito.putExtra("mascota",mascota)


        startActivity(intentExplicito)
    }
}
