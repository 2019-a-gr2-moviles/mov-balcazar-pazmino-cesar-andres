package com.example.user.appex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_crear_so.*
import java.util.*

class CrearSO : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_so)

        btn_guardar.setOnClickListener {
            crearSO();
        }
    }

    fun crearSO(){
        var nombre:String=txt_nombre.text.toString();
        var api=txt_api.text.toString().toInt();
        var yearaux=Date(txt_fecha.text.toString().toInt(),1,1);
        var peso=txt_peso.text.toString().toDouble();
        var instalado=checkinstalado.isChecked;

        var soaux=SO(0,nombre,api,yearaux,peso,instalado);
        SO.insertar(soaux);

        txt_nombre.setText("");
        txt_api.setText("");
        txt_fecha.setText("");
        txt_peso.setText("");
        checkinstalado.isChecked=false;

        Snackbar.make(layout1, "${Usuario.nombreUsuario} Inserto un SO", Snackbar.LENGTH_LONG).show()

    }
}
