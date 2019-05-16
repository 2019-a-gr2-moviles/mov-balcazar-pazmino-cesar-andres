package Controlador

import Modelo.Instrumento

import java.io.*
import javax.swing.JOptionPane
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import jdk.nashorn.internal.runtime.ScriptingFunctions.readLine
import java.io.InputStreamReader
import java.io.BufferedReader
import java.io.IOException
import java.io.FileNotFoundException




class IOarchivos {

    constructor(){

    }

    public fun escribirArchivoObjeto(objeto:Instrumento,nombreArchivo:String):Unit{
        var fos =FileOutputStream("src/basedatos/"+nombreArchivo+".lista");
        var ous =ObjectOutputStream(fos);
        ous.writeObject(objeto);
        ous.close();
    }

    public fun leerArchivoObjeto(nombreArchivo: String):Any{
        var o:Any;

        var fis=FileInputStream("src/basedatos/"+nombreArchivo);
        var ois=ObjectInputStream(fis);
        o=ois.readObject();
        ois.close();

        return o;
    }

    public fun escribirArchivo(tupla:String,nombreArchivo: String){
        var bw:BufferedWriter;
        var fw:FileWriter;

        var file:File= File("src/basedatos/"+nombreArchivo);

        if(!file.exists()){
            file.createNewFile();
        }

        fw= FileWriter(file.absoluteFile,true);
        bw= BufferedWriter(fw);

        bw.write(tupla+"\n");
        //JOptionPane.showMessageDialog(null,"Registro exitoso!");

        if (bw != null){
            bw.close();
        }

        if (fw != null){
            fw.close();
        }


    }


    public fun escribirArchivoIndex():Number{
        var bw:BufferedWriter;
        var fw:FileWriter;

        var file:File= File("src/basedatos/index.txt");
        var i=0;
        var bandera=file.exists();
        if(!bandera){
            file.createNewFile();
        }

        fw= FileWriter(file.absoluteFile,true);
        bw= BufferedWriter(fw);
        if(!bandera){
            bw.write(i.toString()+"\n");
        }else{
            var aux=readFileAsLinesUsingUseLines("src/basedatos/index.txt");
            var aux2= aux.get(aux.size-1).toString().toInt();
            i=aux2+1;
            bw.write(i.toString()+"\n")
        }


        if (bw != null){
            bw.close();
        }

        if (fw != null){
            fw.close();
        }

        return i;
    }


    @Throws(FileNotFoundException::class, IOException::class)
    public fun leerTxt(ruta: String): List<String> {
        var cadena: String

        var file = File(ruta);
        var fr=FileReader(file)
        val br = BufferedReader(fr);

        val l : MutableList<String> = ArrayList()
        //        FileReader f = new FileReader(ruta);
        //        BufferedReader br = new BufferedReader(f);
        println(br.readLine());
        var fin:Boolean=false;
        while(fin!=true){
            if(br.readLine()!=null){
                l.add(br.readLine());
            }else{
                fin=true;
            }

        }


        br.close()
        return l;
    }


    fun readFileLineByLineUsingForEachLine(fileName: String)
            = File(fileName).forEachLine { println(it) }


    fun readFileAsLinesUsingUseLines(fileName: String): List<String>
            = File(fileName).useLines { it.toList() }


    fun eliminarTuplaArchivo(index:Number){
        var listaAux=readFileAsLinesUsingUseLines("src/basedatos/instrumento.txt");

        var file = File("src/basedatos/instrumento.txt");

        if(file.exists()){
            file.delete();

            listaAux.forEach {
                var aux=it.split(',');
                if(aux[0]!=index.toString()){
                    escribirArchivo(it,"instrumento.txt")
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"ATENCIÓN: No existe algún registro que borrar!");
        }
    }


    fun actualizarTuplaArchivo(ins:String){
        var listaAux=readFileAsLinesUsingUseLines("src/basedatos/instrumento.txt");
        var indexaux=ins.split(',');
        var file = File("src/basedatos/instrumento.txt");

        if(file.exists()){
            file.delete();

            listaAux.forEach {
                var aux=it.split(',');
                if(aux[0]==indexaux[0]){
                    escribirArchivo(ins,"instrumento.txt");
                }else{
                    escribirArchivo(it,"instrumento.txt");

                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"ATENCIÓN: No existe algún registro que borrar!");
        }
    }
}