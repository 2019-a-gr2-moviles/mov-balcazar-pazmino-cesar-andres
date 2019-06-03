package com.example.user.appex

import android.util.Log
import android.util.Log.i
import com.example.user.appex.SO.Companion.listaSOs
import java.util.*

class Aplicacion(var id:Int,var pesogigas:Number,var version:Number,var nombre:String,var urldescarga:String,var fechalanzamiento:Date,var costo:Number,var soID:Number) {

    companion object {
        var ident:Int=3;
        val listaApps= arrayListOf<Aplicacion>(
                Aplicacion(0,0.05, 2, "Snapseed","https://snapseed.online/",Date(2011,1,1),0,0),
                Aplicacion(1,0.08, 3, "CarrotWheather","https://www.meetcarrot.com/weather/",Date(2015,1,1),7.99,1),
                Aplicacion(2,0.4, 10, "Black Berry Msg","NA",Date(2005,1,1),0,2)


        )

        fun insertar(app:Aplicacion){
            app.id=ident;

            this.ident++;

            this.listaApps.add(app);
        }

        fun actualizar(id:Int,appActualizada:Aplicacion){

            var indexactualizar=-1;
            this.listaApps.forEachIndexed { index, aplicacion ->
                if(aplicacion.id==id){
                    indexactualizar=index;
                }
            }

            if(indexactualizar!=-1){
                listaApps[indexactualizar].pesogigas=appActualizada.pesogigas;
                listaApps[indexactualizar].version=appActualizada.version;
                listaApps[indexactualizar].nombre=appActualizada.nombre;
                listaApps[indexactualizar].urldescarga=appActualizada.urldescarga;
                listaApps[indexactualizar].fechalanzamiento=appActualizada.fechalanzamiento;
                listaApps[indexactualizar].costo=appActualizada.costo;
            }




        }



        fun eliminar(ide:Int,idso:Int){
            var indexborrar=-1;
            this.listaApps.forEachIndexed { index, aplicacion ->
                if(aplicacion.id==ide){
                    indexborrar=index;
                }
            }
            if(indexborrar!=-1){
                this.listaApps.removeAt(indexborrar);
            }

        }


        fun appporSO(id:Int):List<Aplicacion>{
            var listaporpadres=this.listaApps.filter {
                it.soID==id;
            }
            return listaporpadres;
        }

        fun devolverIndex(app:String):Int{


            var idactual=-1;
            this.listaApps.forEach {
                if(it.nombre==(app)){

                    idactual=it.id;
                }
            }

            return idactual;

        }

        fun devolverunicapp(id:Int):Aplicacion{
            var appaux:Aplicacion=Aplicacion(-1,0,0,"0","0",Date(2019,1,1),1.0,-1);
            this.listaApps.forEach {
                if(it.id==id){
                    appaux=it;
                }
            }

            return appaux;
        }

    }

    override fun toString(): String {
        return this.nombre;
    }
}

