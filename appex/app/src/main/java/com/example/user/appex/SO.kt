package com.example.user.appex

import java.util.*

class SO(var id:Int,var nombre : String,var versionAPI : Number,var fechalanzamiento : Date,var pesogigas: Number,var instalado : Boolean) {

    companion object{
        var ident:Int=3;
        val listaSOs= arrayListOf<SO>(
                SO(0,"Android", 23, Date(2008,1,1), 1.5, true),
                SO(1,"iOS", 25, Date(2007,1,1), 3.5, false),
                SO(2,"Blackberry", 7, Date(1999,1,1), 0.5, false)

        )

        fun insertar(so:SO){
            so.id=ident;
            ident++;
            this.listaSOs.add(so);
        }

        fun eliminar(ide:Int){
            if(this.listaSOs.size==1){
                this.listaSOs.removeAt(0);
            }else{
                 this.listaSOs.removeAt(ide);
            }

        }

        fun actualizar(id:Int,soActualizado:SO){

            listaSOs[id].nombre=soActualizado.nombre;
            listaSOs[id].versionAPI=soActualizado.versionAPI;
            listaSOs[id].fechalanzamiento=soActualizado.fechalanzamiento;
            listaSOs[id].pesogigas=soActualizado.pesogigas;
            listaSOs[id].instalado=soActualizado.instalado;

        }

        fun devolverIndex(so:String):Int{
            var idactual=-1;
            this.listaSOs.forEach {
                if(it.nombre.equals(so)){
                    idactual=it.id;
                }
            }

            return idactual;

        }

    }

    override fun toString(): String {
        return this.nombre;
    }
}
