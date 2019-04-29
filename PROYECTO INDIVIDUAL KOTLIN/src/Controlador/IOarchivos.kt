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

        var fis=FileInputStream("src/basedatos/"+nombreArchivo+".lista");
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
        JOptionPane.showMessageDialog(null,"Registro exitoso!");

        if (bw != null){
            bw.close();
        }

        if (fw != null){
            fw.close();
        }


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
}