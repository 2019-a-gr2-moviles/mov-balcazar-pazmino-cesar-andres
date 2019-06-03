package com.example.user.appex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
//import kotlinx.android.synthetic.main.activity_crear_so.*
//import kotlinx.android.synthetic.main.activity_crear_so.*
//import kotlinx.android.synthetic.main.activity_crear_so.*
import kotlinx.android.synthetic.main.activity_gestion_individual_so.*
import java.util.*

class GestionIndividualSO : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_individual_so)

        val id:Int=intent.getIntExtra("idSO",0);
        val so:String=intent.getStringExtra("so");

        traerDatosSO(id)


        btn_eliminar.setOnClickListener {
            eliminar(id,so);
        }

        btn_actualizar.setOnClickListener {
            actualizar(id,so);
        }

        btn_crearhijo.setOnClickListener {
            crearhijo(id,so);
        }

        btn_gestionhijos.setOnClickListener {
            gestionHijo(id,so);
        }
    }


   fun traerDatosSO(id:Int){
        txt_nombre.setText(SO.listaSOs[id].nombre)
        txt_api.setText(SO.listaSOs[id].versionAPI.toString())
        txt_fecha.setText(SO.listaSOs[id].fechalanzamiento.year.toString())
        txt_peso.setText(SO.listaSOs[id].pesogigas.toString())
        //var aux=SO.listaSOs[id].instalado
        check_instalado.isChecked=SO.listaSOs[id].instalado

    }

    fun eliminar(id:Int,so:String){

        //var idborrar=SO.devolverIndex(so);

        SO.eliminar(id);

        Snackbar.make(layoutgiso, "${Usuario.nombreUsuario} elimino un SO", Snackbar.LENGTH_LONG).show()

        val intent = Intent(
                this,
                GestionListaSO::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        Delay.after(2000, {

            startActivity(intent)
        })

    }

    fun actualizar(id:Int,so:String){
        var nombre:String=txt_nombre.text.toString();
        var api=txt_api.text.toString().toInt();
        var yearaux= Date(txt_fecha.text.toString().toInt(),1,1);
        var peso=txt_peso.text.toString().toDouble();
        var instalado=check_instalado.isChecked;



        var idaux=SO.devolverIndex(so);
        Log.i("idsos","$idaux")
        var soaux=SO(idaux,nombre,api,yearaux,peso,instalado);
        SO.actualizar(id,soaux);

        Snackbar.make(layoutgiso, "${Usuario.nombreUsuario} Actualizo un SO", Snackbar.LENGTH_LONG).show()

        val intent = Intent(
                this,
                GestionListaSO::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        Delay.after(2000, {

            startActivity(intent)
        })
    }


    fun crearhijo(id:Int,so:String){
        val intent = Intent(
                this,
                CrearHijo::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("idso",id);
        intent.putExtra("so",so);
        startActivity(intent)
    }

    fun gestionHijo(idpadre:Int,so:String){
        val intent = Intent(
                this,
                ListaHijos::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("idso",idpadre);
        intent.putExtra("so",so);
        startActivity(intent)
    }
}
