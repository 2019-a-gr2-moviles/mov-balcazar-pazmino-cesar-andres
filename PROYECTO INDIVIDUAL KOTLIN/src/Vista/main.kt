package Vista

import java.awt.Dimension
import Controlador.MetodosBD
import Modelo.Instrumento
import java.awt.GridLayout
import java.util.*
import javax.swing.*
import javax.swing.table.DefaultTableModel
import java.awt.BorderLayout
import javax.swing.JScrollPane


fun main(args: Array<String>) {
    llamarVentanaInicial();
}


fun llamarVentanaInicial() {
    //static GraphicsConfiguration gc;
    val experimentLayout = GridLayout(2, 2, 10, 10)
    val ventana = JFrame("Catálogo Instrumentos Musicales")


    //PONERLE UN LAYOUT
    ventana.getContentPane().setLayout(experimentLayout);

    //ANIADIR COMPONENTES
    /*var textfield1 = JTextField("Text field 1", 10)
    var textfield2 = JTextField("Text field 2", 10)
    var textfield3 = JTextField("Text field 3", 10)
    ventana.getContentPane().add(textfield1)
    ventana.getContentPane().add(textfield2)
    ventana.getContentPane().add(textfield3)*/

    var botonInsertar = JButton("INSERTAR");
    var botonRead = JButton("LEER");
    var botonDelete = JButton("BORRAR");
    var botonUpdate = JButton("ACTUALIZAR");

    ventana.getContentPane().add(botonInsertar);
    ventana.getContentPane().add(botonRead);
    ventana.getContentPane().add(botonUpdate);
    ventana.getContentPane().add(botonDelete);

    botonInsertar.addActionListener {
        ventanaInsert();
        ventana.dispose();
    }

    botonRead.addActionListener {
        ventanaConsultar();
        ventana.dispose();
    }

    botonDelete.addActionListener {
        ventanaDelete();
        ventana.dispose();
    }

    botonUpdate.addActionListener {
        ventanaUpdate();
        ventana.dispose();
    }

    //poner caracteristicas
    ventana.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    ventana.preferredSize = Dimension(300, 200)
    ventana.isResizable = false
    ventana.pack()
    ventana.setLocationRelativeTo(null)
    ventana.isVisible = true
}


fun ventanaInsert() {
    val experimentLayout = GridLayout(5, 2, 20, 20)
    val ventanainsert = JFrame("Inserción instrumento musical");

    ventanainsert.getContentPane().setLayout(experimentLayout);

    var label1 = JLabel("Tipo:", 10)

    var textTipo = JTextField("", 10)

    var label2 = JLabel("Descripcion:", 10)
    var textDescripcion = JTextField("", 10)

    var label3 = JLabel("Marca:", 10)
    var textMarca = JTextField("", 10)

    var label4 = JLabel("Precio:", 10)
    var textPrecio = JTextField("", 10)

    var boton = JButton("INSERTAR");
    var botonvoler = JButton("VOLVER");


    ventanainsert.getContentPane().add(label1);
    ventanainsert.getContentPane().add(textTipo);
    ventanainsert.getContentPane().add(label2);
    ventanainsert.getContentPane().add(textDescripcion);
    ventanainsert.getContentPane().add(label3);
    ventanainsert.getContentPane().add(textMarca);
    ventanainsert.getContentPane().add(label4);
    ventanainsert.getContentPane().add(textPrecio);
    ventanainsert.getContentPane().add(botonvoler);
    ventanainsert.getContentPane().add(boton);

    ventanainsert.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    ventanainsert.preferredSize = Dimension(500, 300)
    ventanainsert.pack()
    ventanainsert.setLocationRelativeTo(null)
    ventanainsert.isVisible = true


    boton.addActionListener {
        var tipo = textTipo.getText();
        var descripcion = textDescripcion.getText();
        var marca = textMarca.getText();
        var precio: Number = 0;
        try {
            precio = textPrecio.getText().toString().toDouble()
            insertarTupla(tipo, descripcion, marca, precio);
        } catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "Ingresar bien el campo de precio!")
        };

    }

    botonvoler.addActionListener {
        llamarVentanaInicial();
        ventanainsert.dispose();
    }


}

fun insertarTupla(tipo: String, desc: String, marca: String, precio: Number) {

    var id = MetodosBD.crearIndex();

    MetodosBD.insertar(id,tipo,desc,marca,precio);

}


fun llenarTabla(): DefaultTableModel {
    var datos = selectDatos();
    var dtm = DefaultTableModel();
    if(!datos.isEmpty()){


        //Agrego columnas a la tabla
        dtm.addColumn("ID");
        dtm.addColumn("Tipo");
        dtm.addColumn("Descripcion");
        dtm.addColumn("Marca");
        dtm.addColumn("Precio");

        //Agrego tuplas a la tabla, de la manera dificil y complicada por las huevas
        // porque mi manera es LA MANERA DE LOS DIOSES
        if (!datos.isEmpty()) {
            datos.forEach {
                var lista = it.split(',');
                var vector = Vector<String>();
                lista.forEach {

                    vector.add(it);

                }
                dtm.addRow(vector);
            }
        }
    }


    return dtm;
}

fun ventanaConsultar() {

    var panelTabla = JPanel();
    var panelBoton = JPanel();

    val ventanaconsultar = JFrame("Catálogo");

    ventanaconsultar.getContentPane().add(panelTabla, BorderLayout.CENTER);
    ventanaconsultar.getContentPane().add(panelBoton, BorderLayout.SOUTH);


    //Instancio la tabla
    var tabla = JTable(llenarTabla())

    tabla.dragEnabled = false;

    //Creo el scroll pane que contendra a la tabla
    var jsp = JScrollPane(tabla)
    panelTabla.add(jsp);


    var botonVolver = JButton("Volver");
    panelBoton.add(botonVolver);


    ventanaconsultar.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    //ventanainsert.preferredSize = Dimension(400, 300)
    ventanaconsultar.pack()
    ventanaconsultar.setLocationRelativeTo(null)
    ventanaconsultar.isVisible = true

    botonVolver.addActionListener {
        llamarVentanaInicial();
        ventanaconsultar.dispose();
    }
}


fun selectDatos(): List<String> {
    var retorno = MetodosBD.leer();
    return retorno;
}


fun ventanaDelete() {
    var panelTabla = JPanel();
    var panelBoton = JPanel();

    val ventanaeliminar = JFrame("Eliminar elemento");

    ventanaeliminar.getContentPane().add(panelTabla, BorderLayout.CENTER);
    ventanaeliminar.getContentPane().add(panelBoton, BorderLayout.SOUTH);

    //Instancio la tabla
    var dtm=llenarTabla();
    var tabla = JTable(dtm);
    tabla.dragEnabled = false;

    //Creo el scroll pane que contendra a la tabla
    var jsp = JScrollPane(tabla)
    panelTabla.add(jsp);


    var botonVolver = JButton("Volver");
    var botonEliminar = JButton("Eliminar elemento.");
    panelBoton.add(botonVolver);
    panelBoton.add(botonEliminar);


    ventanaeliminar.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    //ventanainsert.preferredSize = Dimension(400, 300)
    ventanaeliminar.pack()
    ventanaeliminar.setLocationRelativeTo(null)
    ventanaeliminar.isVisible = true


    botonVolver.addActionListener {
        llamarVentanaInicial();
        ventanaeliminar.dispose();
    }


    botonEliminar.addActionListener {
        //println(tabla.rowCount)
        if (tabla.rowCount > 0) {
            var i = tabla.getSelectedRow();
            if (i != -1) {
                var index = dtm.getValueAt(i, 0).toString().toInt();
                println(index)
                eliminarTupla(index);
            } else {
                JOptionPane.showMessageDialog(null, "Escoja un registro para borrar!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existen registros!");
        }


    }
}


fun eliminarTupla(i: Number) {
    MetodosBD.eliminar(i);
}

fun ventanaUpdate() {
    var panelTabla = JPanel();
    //panelTabla.preferredSize=Dimension(500, 300)

    var panelBoton = JPanel();
    var panelCampos = JPanel();

    val ventanaactualizar = JFrame("Eliminar elemento");

    ventanaactualizar.getContentPane().add(panelTabla, BorderLayout.NORTH);

    ventanaactualizar.getContentPane().add(panelBoton, BorderLayout.CENTER);
    ventanaactualizar.getContentPane().add(panelCampos, BorderLayout.SOUTH);

    //Instancio la tabla
    var dtm=llenarTabla();
    var tabla = JTable(dtm);
    tabla.dragEnabled = false;

    //Creo el scroll pane que contendra a la tabla
    var jsp = JScrollPane(tabla)
    panelTabla.add(jsp);

    var botonEscojer = JButton("Editar");
    panelBoton.add(botonEscojer);


    var label1 = JLabel("Tipo:", 10)

    var textTipo = JTextField("", 10)

    var label2 = JLabel("Descripcion:", 10)
    var textDescripcion = JTextField("", 10)

    var label3 = JLabel("Marca:", 10)
    var textMarca = JTextField("", 10)

    var label4 = JLabel("Precio:", 10)
    var textPrecio = JTextField("", 10)

    var boton = JButton("Confirmar actualización");
    var botonvoler = JButton("VOLVER");


    val experimentLayout = GridLayout(5, 2, 20, 20)
    panelCampos.setLayout(experimentLayout);

    panelCampos.add(label1);
    panelCampos.add(textTipo);
    panelCampos.add(label2);
    panelCampos.add(textDescripcion);
    panelCampos.add(label3);
    panelCampos.add(textMarca);
    panelCampos.add(label4);
    panelCampos.add(textPrecio);
    panelCampos.add(botonvoler);
    panelCampos.add(boton);



    ventanaactualizar.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    //ventanainsert.preferredSize = Dimension(400, 300)
    ventanaactualizar.pack()
    ventanaactualizar.setLocationRelativeTo(null)
    ventanaactualizar.isVisible = true

    botonvoler.addActionListener {
        llamarVentanaInicial();
        ventanaactualizar.dispose();
    }

    var id = -1;
    botonEscojer.addActionListener {
        var i = tabla.getSelectedRow();
        if(i!=-1){
            id = dtm.getValueAt(i, 0).toString().toInt();
            var tipoaux = dtm.getValueAt(i, 1);
            var descaux = dtm.getValueAt(i, 2);
            var marcaaux = dtm.getValueAt(i, 3);
            var precioaux = dtm.getValueAt(i, 4);

            textTipo.text = tipoaux.toString();
            textDescripcion.text = descaux.toString();
            textMarca.text = marcaaux.toString();
            textPrecio.text = precioaux.toString();
        }else{
            JOptionPane.showMessageDialog(null,"Escoja un registro para actualizar!");
        }

    }

    boton.addActionListener {

        if (id != -1 && !textTipo.getText().isEmpty() && !textDescripcion.getText().isEmpty() &&
            !textMarca.getText().isEmpty() && !textPrecio.getText().isEmpty()
        ) {
            actualizarTupla(
                id,
                textTipo.getText(),
                textDescripcion.getText(),
                textMarca.getText(),
                textPrecio.getText().toDouble()
            );

        }


    }

}

fun actualizarTupla(id: Number, tipo: String, desc: String, marca: String, precio: Number) {


    MetodosBD.actualizar(id,tipo,desc,marca,precio);
}
