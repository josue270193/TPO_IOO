package app.ioo.tp.ventanas;

import app.ioo.tp.Constantes;
import app.ioo.tp.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaAuto extends JDialog {

    private Controlador controlador;

    private JLabel labelPatente;
    private JTextField fieldPatente;

    private JLabel labelmarca;
    private JTextField fieldMarca;

    private JLabel labelModelo;
    private JTextField fieldModelo;

    private JLabel labelTamanno;
    private JTextField fieldTamanno;

    private JButton alta;

    public AltaAuto(Controlador controlador) throws HeadlessException {
        super();
        this.controlador = controlador;
        initGUI();
    }

    private void initGUI() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labelPatente = new JLabel(Constantes.Patente);
        labelPatente.setBounds(21, 42, 63, 28);
        getContentPane().add(labelPatente);

        fieldPatente = new JTextField();
        fieldPatente.setBounds(119, 42, 210, 28);
        getContentPane().add(fieldPatente);

        labelmarca = new JLabel(Constantes.Marca);
        labelmarca.setBounds(21, 82, 63, 28);
        getContentPane().add(labelmarca);

        fieldMarca = new JTextField();
        fieldMarca.setBounds(119, 82, 210, 28);
        getContentPane().add(fieldMarca);

        labelModelo = new JLabel(Constantes.Modelo);
        labelModelo.setBounds(21, 140, 63, 28);
        getContentPane().add(labelModelo);

        fieldModelo = new JTextField();
        fieldModelo.setBounds(119, 140, 210, 28);
        getContentPane().add(fieldModelo);

        labelTamanno = new JLabel(Constantes.Tamanno);
        labelTamanno.setBounds(21, 180, 63, 28);
        getContentPane().add(labelTamanno);

        fieldTamanno = new JTextField();
        fieldTamanno.setBounds(119, 180, 210, 28);
        getContentPane().add(fieldTamanno);

        alta = new JButton(Constantes.Aceptar);
        alta.setBounds(119, 217, 150, 28);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //TO-DO HACERRRR?
                /*	controlador.crearCliente(Dni.getText(), nombre.getText(), domicilio.getText(),
							telefono.getText(), mail.getText());
					Dni.setText("");
					nombre.setText("");
					domicilio.setText("");
					telefono.setText("");
					mail.setText("");
					controlador.*/
            }
        });

        getContentPane().add(alta);
        pack();

        setSize(400, 300);
    }
}
