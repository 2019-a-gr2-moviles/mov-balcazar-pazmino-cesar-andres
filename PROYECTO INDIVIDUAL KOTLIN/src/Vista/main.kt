package Vista

import java.awt.Dimension
import javax.swing.JFrame
import Controlador.MetodosBD
import Modelo.Instrumento


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

fun ventanaInsert(){
    val ventanainsert=JFrame("Inserción instrumento musical");
    ventanainsert.contentPane = Insert().panelinsert
    ventanainsert.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    //ventanainsert.preferredSize = Dimension(400, 300)
    ventanainsert.pack()
    ventanainsert.setLocationRelativeTo(null)
    ventanainsert.isVisible = true
}

fun insertarTupla(tipo:String,desc:String,marca:String,precio:Number){
    var auxIns=Instrumento(tipo,desc,marca,precio);
    MetodosBD.insertar(auxIns);

}


fun ventanaConsultar(){
    val ventanainsert=JFrame("Inserción instrumento musical");
    ventanainsert.contentPane = Insert().panelinsert
    ventanainsert.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    //ventanainsert.preferredSize = Dimension(400, 300)
    ventanainsert.pack()
    ventanainsert.setLocationRelativeTo(null)
    ventanainsert.isVisible = true
}

fun ventanaDelete(){
    val ventanainsert=JFrame("Inserción instrumento musical");
    ventanainsert.contentPane = Insert().panelinsert
    ventanainsert.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    //ventanainsert.preferredSize = Dimension(400, 300)
    ventanainsert.pack()
    ventanainsert.setLocationRelativeTo(null)
    ventanainsert.isVisible = true
}


fun ventanaUpdate(){
    val ventanainsert=JFrame("Inserción instrumento musical");
    ventanainsert.contentPane = Insert().panelinsert
    ventanainsert.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    //ventanainsert.preferredSize = Dimension(400, 300)
    ventanainsert.pack()
    ventanainsert.setLocationRelativeTo(null)
    ventanainsert.isVisible = true
}
