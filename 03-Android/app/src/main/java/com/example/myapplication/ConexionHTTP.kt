package com.example.myapplication

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log
import com.beust.klaxon.Klaxon

import kotlinx.android.synthetic.main.activity_conexion_http.*
import java.lang.Exception
import java.util.*
import com.github.kittinunf.result.Result.*
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost

class ConexionHTTP : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conexion_http)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        val json = """
            [
                {
                  "usuariosDeEmpresa": [
                      {
                          "createdAt": 1561663617636,
                          "updatedAt": 1561663617636,
                          "id": 1,
                          "nombre": "Adrian",
                          "fkEmpresa": 1,
                      }
                  ],
                  "createdAt": 1561663617636,
                  "updatedAt": 1561663617636,
                  "id": 1,
                  "nombre": "Manticore Labs"
                }
            ]
        """.trimIndent()

        try {
            val empresaInstancia = Klaxon()
                .parseArray<Empresa>(json)

            empresaInstancia?.forEach {

                Log.i(
                    "http",
                    "Nombre ${it.nombre}"
                )

                Log.i(
                    "http",
                    "Id ${it.id}"
                )

                Log.i(
                    "http",
                    "Fecha ${it.fechaCreacion}"
                )

                it.usuariosDeEmpresa.forEach {
                    Log.i(
                        "http",
                        "Nombre ${it.nombre}"
                    )
                    Log.i(
                        "http",
                        "FK ${it.fkEmpresa}"
                    )
                }

            }
        } catch (e: Exception) {
            Log.i("http", "${e.message}")
            Log.i(
                "http",
                "Error instanciando la empresa"
            )
        }


        /*val url = "http://192.168.80.1:1337/empresa/1";

        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Success -> {
                        val data = result.get()
                        Log.i("http", "Data: ${data}")

                        val empresaParsead = Klaxon().parse<Empresa>(data);
                        if(empresaParsead!=null){
                            Log.i("http", "a la verga");
                            Log.i("http", "${empresaParsead.nombre}");
                        }
                    }
                }

            }*/

        val urlCrearEmpresa="http//172.31.104.78/empresa";

        val parametrosCrearEmpresa= listOf( //lista de pares
            "nombre" to "Cesar", //este sirve
            "apellido" to "Balcazar",
            "sueldo" to 2000,
            "casado" to false,
            "hijos" to null
        )


        urlCrearEmpresa
            .httpPost(parametrosCrearEmpresa)
            .responseString { request, response, result ->
                when(result){

                    is Failure->{

                    }

                    is Success->{
                        val empresaString= result.get();

                        Log.i("http","${empresaString}");
                    }

                }

            }
    }

}
