package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actividad_dos.*

class Actividad_dos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_dos)

        btn_actividaduno.setOnClickListener {
            iractuno()
        }
    }

    fun iractuno(){
        var intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

}
