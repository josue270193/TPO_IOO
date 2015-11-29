package app.ioo.tp.ventanas;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import app.ioo.tp.Constantes;
import app.ioo.tp.Controlador;
import app.ioo.tp.vistas.ClienteView;

public class AltaAuto extends JDialog {

    private final ClienteView clienteView;
    private Controlador controlador;

    private JLabel labelDni;
    private JTextField Dni;

    private JLabel labelPatente;
    private JTextField fieldPatente;

    private JLabel labelmarca;
    private JTextField fieldMarca;

    private JLabel labelModelo;
    private JTextField fieldModelo;

    private JLabel labelTamanno;
    private JTextField fieldTamanno;

    private JButton alta;

    public AltaAuto(Controlador controlador, ClienteView clienteView) throws HeadlessException {
        super();
        this.controlador = controlador;
        this.clienteView = clienteView;
        initGUI();
    }

    private void initGUI() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labelDni = new JLabel(Constantes.Dni);
        labelDni.setBounds(21, 12, 63, 28);
        getContentPane().add(labelDni);

        Dni = new JTextField();
        Dni.setBounds(119, 12, 210, 28);
        Dni.setEnabled(false);
        getContentPane().add(Dni);

        Dni.setText(clienteView.getDni());

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
                
            }
        });

        getContentPane().add(alta);
        pack();
        setTitle(Constantes.AltaContratoAltaAuto);
        setSize(500, 300);
    }
}
