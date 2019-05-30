package com.example.usrsig.app4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_parcelable.*

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val datos:Usuario?=this.intent.getParcelableExtra<Usuario>("user")
        Log.i("parcelable","Nombre ${datos?.nombre}") //se pone el Elvis porque puede ser nulo
        Log.i("parcelable","Nombre ${datos?.edad}")
        Log.i("parcelable","Nombre ${datos?.fechaNacimiento}")
        Log.i("parcelable","Nombre ${datos?.sueldo}")


        btn_volver.setOnClickListener {
            regresarMenu();
        }
    }


    fun regresarMenu(){
        val intent=Intent(this,MainActivity::class.java)

        startActivity(intent)
    }
}
