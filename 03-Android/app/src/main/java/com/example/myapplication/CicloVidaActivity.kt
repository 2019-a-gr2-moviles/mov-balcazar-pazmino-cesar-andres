package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclo_vida.*

class CicloVidaActivity : AppCompatActivity() {

    var contador=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida)

        Log.i("ciclo-vida","onCreate");

        btn_contador.setOnClickListener {
            aumentarContador();
        }
    }


    fun aumentarContador(){
        contador++;
        txt_contador.setText(contador.toString());
        Log.i("Contador","$contador");
    }

    override fun onStart() {
        super.onStart();
        Log.i("ciclo-vida","onStart");
    }

    override fun onResume() {
        super.onResume();
        Log.i("ciclo-vida","onResume");
    }

    override fun onPause() {
        super.onPause();
        Log.i("ciclo-vida","onPause");
    }

    override fun onStop() {
        super.onStop();
        Log.i("ciclo-vida","onStop");
    }

    override fun onRestart() {
        super.onRestart();
        Log.i("ciclo-vida","onRestart");
    }

    override fun onDestroy() {
        super.onDestroy();
        Log.i("ciclo-vida","onDestroy");
    }


    //despues del stop
    override fun onSaveInstanceState(outState: Bundle?) {

        Log.i("ciclo-vida","onSaveInstanceState");

        //solo si no es nulo
        outState?.run {

            //aqui se guarda lo que sea mientras sea parcelable

            putInt("contadorGuardado", contador);
        }

        super.onSaveInstanceState(outState);

    }


    //entre el start y resume
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) { //Bundle es basicamente un parcelable

        super.onRestoreInstanceState(savedInstanceState);
        Log.i("ciclo-vida","onRestoreInstanceState");

        val contadorRecuperado=savedInstanceState?.getInt("contadorGuardado");

        if(contadorRecuperado!=null){
            this.contador=contadorRecuperado;
            this.txt_contador.text=this.contador.toString();
        }

    }




}
