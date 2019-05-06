package Modelo

import java.io.Serializable

class Instrumento: Serializable{

    var id:Number=0;
    var tipo:String="";
    var descripcion:String="";
    var marca:String="";
    var precio:Number=0;

    constructor(id:Number,tipo:String,descripcion:String,marca:String,precio:Number){
        this.id=id;
        this.tipo=tipo;
        this.descripcion=descripcion;
        this.marca=marca;
        this.precio=precio;
    }

    override fun toString(): String {
        return this.id.toString()+","+this.tipo+","+this.descripcion+","+this.marca+","+this.precio;
    }

}