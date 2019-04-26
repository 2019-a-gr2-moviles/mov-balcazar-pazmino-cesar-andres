package com.example.a1eraapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { //para trabajar en el ciclo de vida de la activity
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
