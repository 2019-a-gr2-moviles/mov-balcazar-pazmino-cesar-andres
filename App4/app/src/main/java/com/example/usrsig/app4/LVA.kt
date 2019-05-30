package com.example.usrsig.app4

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_lv.*

class LVA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lv)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        var lista= arrayListOf<String>()
        lista.add("Cesar")


        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,lista)//indico como mostrar listas en android

        lv_ejemplo.adapter=adapter //lv_ejemplo es el id de la list view
    }

}
