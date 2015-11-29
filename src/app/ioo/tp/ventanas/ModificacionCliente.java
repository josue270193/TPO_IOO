package app.ioo.tp.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import app.ioo.tp.Constantes;
import app.ioo.tp.Controlador;
import app.ioo.tp.vistas.ClienteView;

public class ModificacionCliente extends JDialog {

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
    private ClienteView clienteView;

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
        getContentPane().add(labelDni);

        Dni = new JTextField();
        Dni.setBounds(119, 42, 210, 28);
        Dni.setEnabled(false);
        getContentPane().add(Dni);

        labelNombre = new JLabel(Constantes.Nombre);
        labelNombre.setBounds(21, 82, 63, 28);
        getContentPane().add(labelNombre);

        nombre = new JTextField();
        nombre.setBounds(119, 82, 210, 28);
        nombre.setEnabled(false);
        getContentPane().add(nombre);

        labelDomicilio = new JLabel(Constantes.Domicilio);
        labelDomicilio.setBounds(21, 110, 70, 28);
        getContentPane().add(labelDomicilio);

        domicilio = new JTextField();
        domicilio.setBounds(119, 110, 210, 28);
        domicilio.setEnabled(false);
        getContentPane().add(domicilio);

        labelMail = new JLabel(Constantes.Mail);
        labelMail.setBounds(21, 140, 63, 28);
        getContentPane().add(labelMail);

        mail = new JTextField();
        mail.setBounds(119, 140, 210, 28);
        mail.setEnabled(false);
        getContentPane().add(mail);

        labelTelefono = new JLabel(Constantes.Telefono);
        labelTelefono.setBounds(21, 182, 63, 28);
        getContentPane().add(labelTelefono);

        telefono = new JTextField();
        telefono.setBounds(119, 182, 210, 28);
        telefono.setEnabled(false);
        getContentPane().add(telefono);

        alta = new JButton(Constantes.Aceptar);
        alta.setBounds(119, 217, 150, 28);
        alta.setEnabled(false);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	            	            	
            	clienteView.setNombre(nombre.getText());
            	clienteView.setDomicilio(domicilio.getText());
            	clienteView.setTelefono(telefono.getText());
            	clienteView.setMail(mail.getText());
            	
                controlador.modificarCliente(clienteView);

                JOptionPane.showMessageDialog(ModificacionCliente.this, Constantes.Exito_ClienteModificado, "", JOptionPane.INFORMATION_MESSAGE);

                DniCliente.setText("");
                Dni.setText("");
                nombre.setText("");
                domicilio.setText("");
                mail.setText("");
                telefono.setText("");

                alta.setEnabled(false);
                nombre.setEnabled(false);
                domicilio.setEnabled(false);
                mail.setEnabled(false);
                telefono.setEnabled(false);
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
            	            	            	            	                
                if (controlador.existeCliente(DniCliente.getText()) 
                		&&  ((clienteView = controlador.getClienteView(DniCliente.getText())) != null) 
                	) {                	
                	
                    nombre.setEnabled(true);
                    domicilio.setEnabled(true);
                    mail.setEnabled(true);
                    telefono.setEnabled(true);

                    Dni.setText(clienteView.getDni());
                    nombre.setText(clienteView.getNombre());
                    domicilio.setText(clienteView.getDomicilio());
                    mail.setText(clienteView.getMail());
                    telefono.setText(clienteView.getTelefono());

                    alta.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(ModificacionCliente.this, Constantes.Error_NoExisteCliente, "", JOptionPane.ERROR_MESSAGE);

                    Dni.setText("");
                    nombre.setText("");
                    domicilio.setText("");
                    mail.setText("");
                    telefono.setText("");

                    alta.setEnabled(false);
                    nombre.setEnabled(false);
                    domicilio.setEnabled(false);
                    mail.setEnabled(false);
                    telefono.setEnabled(false);
                }
            }
        });
        getContentPane().add(buscar);
        pack();

        setTitle(Constantes.ModificacionCliente);
        setSize(500, 300);
    }
}
