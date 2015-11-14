package app.ioo.tp.ventanas;

import app.ioo.tp.Constantes;
import app.ioo.tp.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaCliente extends JDialog{
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

	private JFrame padre;
	

	public AltaCliente(JFrame padre, Controlador controlador) throws HeadlessException {
		super();		
		this.padre = padre;
		this.controlador = controlador;
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
			labelDni.setVisible(true);
		}
		{
			labelNombre = new JLabel();
			getContentPane().add(labelNombre);
			labelNombre.setText(Constantes.Nombre);	
			labelNombre.setBounds(21, 82, 63, 28);
			labelNombre.setVisible(true);	
		}
		{
			labelDomicilio = new JLabel();
			getContentPane().add(labelDomicilio);
			labelDomicilio.setText(Constantes.Domicilio);
			labelDomicilio.setBounds(21, 110, 70, 28);
			labelDomicilio.setVisible(true);
		}
		{			
			labelMail = new JLabel();
			getContentPane().add(labelMail);
			labelMail.setText(Constantes.Mail);	
			labelMail.setBounds(21, 140, 63, 28);
			labelMail.setVisible(true);
		}
		{
			labelTelefono = new JLabel();
			getContentPane().add(labelTelefono);
			labelTelefono.setText(Constantes.Telefono);
			labelTelefono.setBounds(21, 180, 63, 28);
			labelTelefono.setVisible(true);
		}
		
		
		{
			Dni = new JTextField();
			getContentPane().add(Dni);
			Dni.setBounds(119, 42, 210, 28);
		}
		{
			nombre = new JTextField();
			getContentPane().add(nombre);
			nombre.setBounds(119, 82, 210, 28);
		}
		{
			domicilio = new JTextField();
			getContentPane().add(domicilio);
			domicilio.setBounds(119, 110, 210, 28);
		}
		{
			mail = new JTextField();
			getContentPane().add(mail);
			mail.setBounds(119, 140, 210, 28);
		}
		{
			telefono = new JTextField();
			getContentPane().add(telefono);
			telefono.setBounds(119, 180, 210, 28);
		}
		{
			alta = new JButton();
			getContentPane().add(alta);
			alta.setText("Ok");
			alta.setBounds(273, 217, 70, 28);
			alta.setVisible(true);
			alta.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					controlador.crearCliente(Dni.getText(), nombre.getText(), domicilio.getText(),
							telefono.getText(), mail.getText());
					Dni.setText("");
					nombre.setText("");
					domicilio.setText("");
					telefono.setText("");
					mail.setText("");						
				}
			});
		}
		
		pack();
		setSize(400, 300);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
