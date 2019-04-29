package Vista;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VistaPrincipal {
    private JButton btnInsertar;
    private JButton btnConsultar;
    private JButton btnBorrar;
    private JButton btnActualizar;
    private JPanel panel;

    public VistaPrincipal() {
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainKt.ventanaInsert();

            }
        });
    }

    public static  void main(String args[]){
        JFrame ventana=new JFrame("Catálogo Instrumentos Musicales");
        ventana.setContentPane(new VistaPrincipal().panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setPreferredSize(new Dimension(400, 300));
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }
}
