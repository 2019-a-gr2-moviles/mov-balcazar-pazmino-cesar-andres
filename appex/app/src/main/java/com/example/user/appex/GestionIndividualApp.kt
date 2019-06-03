package com.example.user.appex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
//import kotlinx.android.synthetic.main.activity_crear_hijo.*
import kotlinx.android.synthetic.main.activity_gestion_individual_app.*
import java.util.*

class GestionIndividualApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_individual_app)

        var idapp=intent.getIntExtra("idapp",0);
        var idpadre=intent.getIntExtra("idso",0);
        var padre=intent.getStringExtra("so");

        mostrarDatosApp(idapp);

        btn_eliminarhijo.setOnClickListener {
            eliminarapp(idapp,idpadre,padre);
        }

        btn_actualizarhijo.setOnClickListener {
            actualizarapp(idapp,idpadre,padre)
        }
    }

    fun mostrarDatosApp(id:Int){

        var appaux=Aplicacion.devolverunicapp(id);

        peso_txt.setText(appaux.pesogigas.toString());
        version_txt.setText(appaux.version.toString());
        nombre_txt.setText(appaux.nombre.toString());
        url_txt.setText(appaux.urldescarga.toString());
        fecha_txt.setText(appaux.fechalanzamiento.year.toString());
        costo_txt.setText(appaux.costo.toString());
    }

    fun eliminarapp(id:Int,idpadre:Int,padre:String){
        Aplicacion.eliminar(id,idpadre);


        Snackbar.make(layoutgiapp, "${Usuario.nombreUsuario} Elimino una App", Snackbar.LENGTH_LONG).show()

        val intent = Intent(
                this,
                ListaHijos::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("idso",idpadre);
        intent.putExtra("so",padre)

        Delay.after(2000, {

            startActivity(intent)
        })
    }

    fun actualizarapp(id:Int,idpadre:Int,padre:String){
        var peso:Number=peso_txt.text.toString().toDouble();
        var version:Number=version_txt.text.toString().toInt();
        var nombre:String=nombre_txt.text.toString();
        var url:String=url_txt.text.toString();
        var fecha= Date(fecha_txt.text.toString().toInt(),1,1);
        var precio:Number=costo_txt.text.toString().toDouble();


        var idaux=id;


        var aux=Aplicacion(idaux,peso,version,nombre,url,fecha,precio,idpadre);

        Aplicacion.actualizar(idaux,aux);


        Snackbar.make(layoutgiapp, "${Usuario.nombreUsuario} Actualizo una App", Snackbar.LENGTH_LONG).show()


        val intent = Intent(
                this,
                ListaHijos::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("idso",idpadre);
        intent.putExtra("so",padre)


        Delay.after(2000, {

            startActivity(intent)
       })

    }
}
