package com.example.user.appex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

         btn_login.setOnClickListener{
            login();
         }

    }


    fun login(){

        Usuario.nombreUsuario=txt_usuario.text.toString();

        val intent = Intent(
                this,
                GestionSO::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
