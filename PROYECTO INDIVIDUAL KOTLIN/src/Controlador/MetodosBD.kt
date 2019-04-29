package Controlador
import Modelo.Instrumento;
import Controlador.IOarchivos;

var nombreArchivo="Instrumento.txt"
class MetodosBD {


    companion object {
        var io=IOarchivos();
        fun insertar(ins:Instrumento){
            io.escribirArchivo(ins.toString(), nombreArchivo);
        }

        fun leer():List<String>{
            var listaInstrumentos= io.readFileAsLinesUsingUseLines("src/basedatos"+ nombreArchivo);
            return listaInstrumentos;
        }
    }
}