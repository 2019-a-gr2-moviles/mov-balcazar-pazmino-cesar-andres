package com.example.usrsig.app5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nombres= arrayListOf<String>();
        nombres.add("Cesar")
        nombres.add("Carlos")
        nombres.add("Pedro")


        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,nombres)

        list_view.adapter=adapter

        list_view.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->

            Snackbar
                .make(view,"posicion: $position",Snackbar.LENGTH_LONG)
                .setAction("Action",null).show()
        }

    }
}
