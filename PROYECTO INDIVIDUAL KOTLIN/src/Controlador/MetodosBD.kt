package Controlador

import Modelo.Instrumento;
import Controlador.IOarchivos;
import java.io.File
import java.lang.Exception
import javax.print.DocFlavor

var nombreArchivo = "instrumento.txt"

class MetodosBD {


    companion object {
        var io = IOarchivos();
        fun insertar(id:Number,tipo:String,desc:String,marca:String,precio:Number) {
            var ins=Instrumento(id,tipo,desc,marca,precio);
            io.escribirArchivo(ins.toString(), nombreArchivo);
        }

        fun crearIndex(): Number {
            var i = io.escribirArchivoIndex();
            return i;
        }

        fun leer(): List<String> {
            var listaInstrumentosMusicales:List<String> = emptyList()
            try {
                listaInstrumentosMusicales=io.readFileAsLinesUsingUseLines("src/basedatos/" + nombreArchivo);
                return listaInstrumentosMusicales;
            }catch(e:Exception){
                return  listaInstrumentosMusicales;
            }


        }

        fun eliminar(index: Number) {
            io.eliminarTuplaArchivo(index);
        }

        fun actualizar(id:Number,tipo:String,desc: String,marca: String,precio: Number) {
            var ins=Instrumento(id,tipo,desc,marca,precio);
            io.actualizarTuplaArchivo(ins.toString());
        }
    }
}