package com.example.user.appex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_crear_hijo.*
//import kotlinx.android.synthetic.main.activity_crear_so.*
import java.util.*

class CrearHijo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_hijo)

        var idpadre=intent.getIntExtra("soid",0);
        var padre=intent.getStringExtra("so");

        btn_guardarhijo.setOnClickListener {
            guardarhijo(idpadre,padre);
        }
    }

    fun guardarhijo(idpadre:Int,so:String){

        var peso:Number=txt_pesogigas.text.toString().toDouble();
        var version:Number=txt_version.text.toString().toInt();
        var nombre:String=txt_nombreapp.text.toString();
        var url:String=txt_url.text.toString();
        var fecha:Date=Date(txt_fechalan.text.toString().toInt(),1,1);
        var precio:Number=txt_costoapp.text.toString().toDouble();


        var idso=SO.devolverIndex(so);

        var aux=Aplicacion(0,peso,version,nombre,url,fecha,precio,idso);

        Aplicacion.insertar(aux);


        txt_pesogigas.setText("");
        txt_version.setText("");
        txt_nombreapp.setText("");
        txt_url.setText("");
        txt_fechalan.setText("");
        txt_costoapp.setText("");


        Snackbar.make(layoutcrearhijo, "${Usuario.nombreUsuario} Inserto una App", Snackbar.LENGTH_LONG).show()

    }
}
