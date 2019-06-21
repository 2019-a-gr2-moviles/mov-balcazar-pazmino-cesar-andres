package com.example.alarma

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import android.app.Dialog
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)

       // fab.setOnClickListener { view ->
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show()
        //}
        fab.setOnClickListener {
            //inputAlarma();
            withMultiChoiceList();
        }

        iniciarRecylerView(recycler_id)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun iniciarRecylerView(recycler_view: RecyclerView) {
        val adaptador = Adaptador()

        recycler_view.adapter = adaptador
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(this)

        adaptador.notifyDataSetChanged();
        recycler_view.invalidate();
    }

    /*fun inputAlarma(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Androidly Alert")
        builder.setMessage("We have a message")
        builder.set
        //var view= View.inflate(R.layout.layout_dialog,null);
        //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))


        builder.show()
    }*/

    fun withMultiChoiceList() {

        val items = arrayOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo")
        val selectedList = ArrayList<Int>()
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Nueva alarma:")

        val inflater = layoutInflater

        val dialogLayout = inflater.inflate(R.layout.button_dialog, null)
        val editText  = dialogLayout.findViewById<EditText>(R.id.editText)
        builder.setView(dialogLayout)

        builder.setMultiChoiceItems(items, null
        ) { dialog, which, isChecked ->
            if (isChecked) {
                selectedList.add(which)
            } else if (selectedList.contains(which)) {
                selectedList.remove(Integer.valueOf(which))
            }
        }



        builder.setPositiveButton("Hecho") { dialogInterface, i ->
            val selectedStrings = arrayListOf<String>()

            for (j in selectedList.indices) {
                selectedStrings.add(items[selectedList[j]])
            }

            var diasAux= arrayListOf<String>();


            selectedStrings.forEach {
                if(it=="Lunes"){
                    diasAux.add("L");
                }
                if(it=="Martes"){
                    diasAux.add("M");
                }
                if(it=="Miercoles"){
                    diasAux.add("M");
                }
                if(it=="Jueves"){
                    diasAux.add("J");
                }
                if(it=="Viernes"){
                    diasAux.add("V");
                }
                if(it=="Sabado"){
                    diasAux.add("S");
                }
                if(it=="Domingo"){
                    diasAux.add("D");
                }
            }
            var horaAux=Hora("  "+editText.text.toString(),diasAux);
            Log.i("Hora","${horaAux.hora}")


            Hora.agregarHora(horaAux);

            Hora.listaHoras.forEach {
                Log.i("hora","${it.hora} ${it.dias}");
            }
        }

        builder.show()

    }


}
