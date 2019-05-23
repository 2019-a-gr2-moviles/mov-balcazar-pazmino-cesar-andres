package com.example.usrsig.app4

import android.os.Parcel
import android.os.Parcelable
import java.util.*

//si estoy declarando sin var es como parametros, caso contrario como propiedad
class Usuario(
    var nombre:String,
    var edad:Int,
    var fechaNacimiento:Date,
    var sueldo:Double
):Parcelable {
    //esto hace todo primitivo
    //leyendo
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        //TODO("fechaNacimiento"), //"yo no entiendo cómo serializar una clase de tipo date"
        parcel.readSerializable() as Date,
        parcel.readDouble()
    ) {
    }

    //escribir
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(edad)
        parcel.writeSerializable(fechaNacimiento)
        parcel.writeDouble(sueldo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : android.os.Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }

}