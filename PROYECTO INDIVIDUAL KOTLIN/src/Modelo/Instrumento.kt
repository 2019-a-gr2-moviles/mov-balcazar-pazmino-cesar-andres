package Modelo

import java.io.Serializable

class Instrumento: Serializable{

    var tipo:String="";
    var descripcion:String="";
    var marca:String="";
    var precio:Number=0;

    constructor(tipo:String,descripcion:String,marca:String,precio:Number){
        this.tipo=tipo;
        this.descripcion=descripcion;
        this.marca=marca;
        this.precio=precio;
    }

    override fun toString(): String {
        return this.tipo+","+this.descripcion+","+this.marca+","+this.precio;
    }

}