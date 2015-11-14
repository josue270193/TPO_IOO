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
	
	private JFrame padre;
	
	private Controlador controlador;
	private Cliente cliente;
	
	public ModificacionCliente (JFrame padre, Controlador c) throws HeadlessException{
		super();
		this.padre=padre;
		controlador=c;
		initGUI();	
	}

		private void initGUI() {
		
			try {
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				getContentPane().setLayout(null);
			{
				labelDni = new JLabel();
				getContentPane().add(labelDni);
				labelDni.setText(Constantes.Dni);
				labelDni.setBounds(21, 42, 63, 28);
				labelDni.setVisible(false);
			}
			{
				labelNombre = new JLabel();
				getContentPane().add(labelNombre);
				labelNombre.setText(Constantes.Nombre);	
				labelNombre.setBounds(21, 82, 63, 28);
				labelNombre.setVisible(false);	
			}
			{
				labelDomicilio = new JLabel();
				getContentPane().add(labelDomicilio);
				labelDomicilio.setText(Constantes.Domicilio);
				labelDomicilio.setBounds(21, 110, 70, 28);
				labelDomicilio.setVisible(false);
			}
			{			
				labelMail = new JLabel();
				getContentPane().add(labelMail);
				labelMail.setText(Constantes.Mail);	
				labelMail.setBounds(21, 140, 63, 28);
				labelMail.setVisible(false);
			}
			{
				labelTelefono = new JLabel();
				getContentPane().add(labelTelefono);
				labelTelefono.setText(Constantes.Telefono);
				labelTelefono.setBounds(21, 182, 63, 28);
				labelTelefono.setVisible(false);
			}
			{
				Dni = new JTextField();
				getContentPane().add(Dni);
				Dni.setBounds(119, 42, 210, 28);
				Dni.setVisible(false);
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(119, 82, 210, 28);
				nombre.setVisible(false);
			}
			{
				domicilio = new JTextField();
				getContentPane().add(domicilio);
				domicilio.setBounds(119, 110, 210, 28);
				domicilio.setVisible(false);
			}
			{
				mail = new JTextField();
				getContentPane().add(mail);
				mail.setBounds(119, 140, 210, 28);
				mail.setVisible(false);
			}
			{
				telefono = new JTextField();
				getContentPane().add(telefono);
				telefono.setBounds(119, 182, 210, 28);
				telefono.setVisible(false);
			}
			{
				alta = new JButton();
				getContentPane().add(alta);
				alta.setText("Ok");
				alta.setBounds(273, 217, 63, 28);
				alta.setVisible(false);	
				alta.addActionListener(new ActionListener()
					{
					public void actionPerformed(ActionEvent evt) 
					{
						controlador.modificarCliente(Dni.getText(),nombre.getText(), domicilio.getText(), telefono.getText(),
								mail.getText());
					}
				});
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Ingrese Dni:");
				jLabel4.setBounds(21, 7, 98, 28);
			}
			{
				DniCliente = new JTextField();
				getContentPane().add(DniCliente);
				DniCliente.setBounds(140, 7, 147, 28);
			}
			{
				buscar = new JButton();
				getContentPane().add(buscar);
				buscar.setText("Buscar");
				buscar.setBounds(301, 7, 100, 28);
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cliente = controlador.existeCliente(DniCliente.getText());
						if (cliente != null)
						{
							labelNombre.setVisible(true);
							labelDni.setVisible(true);
							labelDomicilio.setVisible(true);
							labelMail.setVisible(true);
							labelTelefono.setVisible(true);
							
							Dni.setVisible(true);
							Dni.setEnabled(false);
							nombre.setVisible(true);
							domicilio.setVisible(true);
							mail.setVisible(true);
							telefono.setVisible(true);
							alta.setVisible(true);
							Dni.setText(cliente.getDni());
							nombre.setText(cliente.getNombre());
							domicilio.setText(cliente.getDomicilio());
							mail.setText(cliente.getMail());
							telefono.setText(cliente.getTelefono());
						}
					}
				});
			}
		
		
			pack();
			setSize(400, 300);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	

		
	}
		
	


