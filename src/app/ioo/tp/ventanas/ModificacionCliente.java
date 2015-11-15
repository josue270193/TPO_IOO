package app.ioo.tp.ventanas;

import app.ioo.tp.Cliente;
import app.ioo.tp.Constantes;
import app.ioo.tp.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificacionCliente extends JDialog {

    private JPanel panel;
    private JPanel panelBotones;

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

    private JLabel jLabel4;
    private JTextField DniCliente;

    private JButton alta;
    private JButton buscar;

    private Controlador controlador;
    private Cliente cliente;

    public ModificacionCliente(Controlador ccontrolador) {
        super();
        this.controlador = ccontrolador;
        initGUI();
    }

    private void initGUI() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labelDni = new JLabel(Constantes.Dni);
        labelDni.setBounds(21, 42, 63, 28);
        labelDni.setVisible(false);
        getContentPane().add(labelDni);

        Dni = new JTextField();
        Dni.setBounds(119, 42, 210, 28);
        Dni.setVisible(false);
        getContentPane().add(Dni);

        labelNombre = new JLabel(Constantes.Nombre);
        labelNombre.setBounds(21, 82, 63, 28);
        labelNombre.setVisible(false);
        getContentPane().add(labelNombre);

        nombre = new JTextField();
        nombre.setBounds(119, 82, 210, 28);
        nombre.setVisible(false);
        getContentPane().add(nombre);

        labelDomicilio = new JLabel(Constantes.Domicilio);
        labelDomicilio.setBounds(21, 110, 70, 28);
        labelDomicilio.setVisible(false);
        getContentPane().add(labelDomicilio);

        domicilio = new JTextField();
        domicilio.setBounds(119, 110, 210, 28);
        domicilio.setVisible(false);
        getContentPane().add(domicilio);

        labelMail = new JLabel(Constantes.Mail);
        labelMail.setBounds(21, 140, 63, 28);
        labelMail.setVisible(false);
        getContentPane().add(labelMail);

        mail = new JTextField();
        mail.setBounds(119, 140, 210, 28);
        mail.setVisible(false);
        getContentPane().add(mail);

        labelTelefono = new JLabel(Constantes.Telefono);
        labelTelefono.setBounds(21, 182, 63, 28);
        labelTelefono.setVisible(false);
        getContentPane().add(labelTelefono);

        telefono = new JTextField();
        telefono.setBounds(119, 182, 210, 28);
        telefono.setVisible(false);
        getContentPane().add(telefono);

        alta = new JButton(Constantes.Aceptar);
        alta.setBounds(119, 217, 150, 28);
        alta.setVisible(false);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                controlador.modificarCliente(Dni.getText(), nombre.getText(), domicilio.getText(), telefono.getText(), mail.getText());

                JOptionPane.showMessageDialog(ModificacionCliente.this, Constantes.Exito_ClienteModificado, "", JOptionPane.INFORMATION_MESSAGE);

                DniCliente.setText("");

                labelNombre.setVisible(false);
                labelDni.setVisible(false);
                labelDomicilio.setVisible(false);
                labelMail.setVisible(false);
                labelTelefono.setVisible(false);
                Dni.setVisible(false);
                nombre.setVisible(false);
                domicilio.setVisible(false);
                mail.setVisible(false);
                telefono.setVisible(false);
                alta.setVisible(false);
            }
        });
        getContentPane().add(alta);

        jLabel4 = new JLabel(Constantes.IngresarDNI);
        jLabel4.setBounds(21, 7, 98, 28);
        getContentPane().add(jLabel4);

        DniCliente = new JTextField();
        DniCliente.setBounds(140, 7, 147, 28);
        getContentPane().add(DniCliente);

        buscar = new JButton(Constantes.Buscar);
        buscar.setBounds(301, 7, 100, 28);
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cliente = controlador.existeCliente(DniCliente.getText());

                if (cliente != null) {
                    labelNombre.setVisible(true);
                    labelDni.setVisible(true);
                    labelDomicilio.setVisible(true);
                    labelMail.setVisible(true);
                    labelTelefono.setVisible(true);
                    Dni.setVisible(true);
                    nombre.setVisible(true);
                    domicilio.setVisible(true);
                    mail.setVisible(true);
                    telefono.setVisible(true);
                    alta.setVisible(true);

                    Dni.setEnabled(false);

                    Dni.setText(cliente.getDni());
                    nombre.setText(cliente.getNombre());
                    domicilio.setText(cliente.getDomicilio());
                    mail.setText(cliente.getMail());
                    telefono.setText(cliente.getTelefono());
                }else{
                    JOptionPane.showMessageDialog(ModificacionCliente.this, Constantes.Error_NoExisteCliente, "", JOptionPane.ERROR_MESSAGE);

                    labelNombre.setVisible(false);
                    labelDni.setVisible(false);
                    labelDomicilio.setVisible(false);
                    labelMail.setVisible(false);
                    labelTelefono.setVisible(false);
                    Dni.setVisible(false);
                    nombre.setVisible(false);
                    domicilio.setVisible(false);
                    mail.setVisible(false);
                    telefono.setVisible(false);
                    alta.setVisible(false);
                }
            }
        });
        getContentPane().add(buscar);

        pack();
        setSize(500, 300);
    }


}

	


