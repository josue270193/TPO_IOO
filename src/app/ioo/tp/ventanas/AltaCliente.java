package app.ioo.tp.ventanas;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import app.ioo.tp.util.Constantes;
import app.ioo.tp.Controlador;

public class AltaCliente extends JDialog {

    private Controlador controlador;

    private JLabel labelDni;
    private JTextField Dni;

    private JLabel labelNombre;
    private JTextField nombre;

    private JLabel labelDomicilio;
    private JTextField domicilio;

    private JLabel labelMail;
    private JTextField mail;

    private JLabel labelTelefono;
    private JTextField telefono;

    private JButton alta;

    public AltaCliente(Controlador controlador) throws HeadlessException {
        super();
        this.controlador = controlador;
        initGUI();
    }

    private void initGUI() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labelDni = new JLabel();
        labelDni.setText(Constantes.Dni);
        labelDni.setBounds(21, 42, 63, 28);
        getContentPane().add(labelDni);

        Dni = new JTextField();
        Dni.setBounds(119, 42, 210, 28);
        getContentPane().add(Dni);

        labelNombre = new JLabel(Constantes.Nombre);
        labelNombre.setBounds(21, 82, 63, 28);
        getContentPane().add(labelNombre);

        nombre = new JTextField();
        nombre.setBounds(119, 82, 210, 28);
        getContentPane().add(nombre);

        labelDomicilio = new JLabel(Constantes.Domicilio);
        labelDomicilio.setBounds(21, 110, 70, 28);
        getContentPane().add(labelDomicilio);

        domicilio = new JTextField();
        getContentPane().add(domicilio);
        domicilio.setBounds(119, 110, 210, 28);

        labelMail = new JLabel(Constantes.Mail);
        labelMail.setBounds(21, 140, 63, 28);
        getContentPane().add(labelMail);

        mail = new JTextField();
        mail.setBounds(119, 140, 210, 28);
        getContentPane().add(mail);

        labelTelefono = new JLabel(Constantes.Telefono);
        labelTelefono.setBounds(21, 180, 63, 28);
        getContentPane().add(labelTelefono);

        telefono = new JTextField();
        telefono.setBounds(119, 180, 210, 28);
        getContentPane().add(telefono);

        alta = new JButton(Constantes.Aceptar);
        alta.setBounds(119, 217, 150, 28);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
                if (!controlador.existeCliente(Dni.getText())) {                
                	                	
                    controlador.crearCliente(Dni.getText(), nombre.getText(), domicilio.getText(), telefono.getText(), mail.getText());

                    JOptionPane.showMessageDialog(AltaCliente.this, Constantes.Exito_ClienteCreado, "", JOptionPane.INFORMATION_MESSAGE);

                    Dni.setText("");
                    nombre.setText("");
                    domicilio.setText("");
                    telefono.setText("");
                    mail.setText("");

                } else {
                    JOptionPane.showMessageDialog(AltaCliente.this, Constantes.Error_ExisteCliente, "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getContentPane().add(alta);

        setTitle(Constantes.AltaCliente);
        pack();
        setSize(500, 300);
    }
}
