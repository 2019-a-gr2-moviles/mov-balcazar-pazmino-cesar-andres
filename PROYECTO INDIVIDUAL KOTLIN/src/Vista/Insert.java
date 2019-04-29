package Vista;

import Controlador.MetodosBDKt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.DoublePredicate;


public class Insert {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton INSERTARButton;
    private JPanel panelinsert;

    public Insert() {
        INSERTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String tipo=textField1.getText();
                String desc=textField2.getText();
                String marca=textField3.getText();
                double precio= Double.parseDouble(textField4.getText());
               MainKt.insertarTupla(tipo,desc,marca,precio);
            }
        });
    }

    public JPanel getPanelinsert() {
        return panelinsert;
    }
}
