import javax.swing.JOptionPane;
import Controlador.IOarchivos;
import Modelo.Instrumento;
import  Vista.VistaInical;
import Vista.VistaPrincipal
import java.awt.Dimension
import java.awt.EventQueue;
import javax.swing.JFrame

//fun main(){
//var string=JOptionPane.showInputDialog(null,"Ingresa algo");
    //println(string)

    //ESTO SI
    /*var ins=Instrumento("Guitarra","Negra con blanco","Fender",950);
    var ins2=Instrumento("Piano","Blanco","Yamaha",1000);


    var io=IOarchivos();*/


   /* io.escribirArchivoObjeto(ins,"instrumeno")
    io.escribirArchivoObjeto(ins2,"instrumeno")*/


   /* io.escribirArchivo(ins.toString(),"instrumento.txt");
    io.escribirArchivo(ins2.toString(),"instrumento.txt");*/


    //var aux=io.leerArchivoObjeto("instrumento");



    /*ESTO SI
    var auxiliar=io.readFileAsLinesUsingUseLines("src/basedatos/instrumento.txt");


    auxiliar.forEach {
        //println(it)
        var aux=it.split(',');
        println(aux[0])

    }*/


   /* aux.forEach {
        println(it)
    }*/

   // var v=VistaInical("Simple");
  //  v.isVisible=true;
    //EventQueue.invokeLater(VistaInical.)


//}

//@JvmStatic
fun main(args: Array<String>) {
    val ventana = JFrame("Catálogo Instrumentos Musicales")
    ventana.contentPane = VistaPrincipal().panel
    ventana.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    ventana.preferredSize = Dimension(400, 300)
    ventana.pack()
    ventana.setLocationRelativeTo(null)
    ventana.isVisible = true
}

fun mensaje(){
    println("holaaaaaa");
}