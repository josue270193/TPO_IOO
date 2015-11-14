package app.ioo.tp.ventanas;

import app.ioo.tp.Constantes;
import app.ioo.tp.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaAuto extends JDialog{
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

	private JFrame padre;
	

	public AltaAuto(JFrame padre, Controlador controlador) throws HeadlessException {
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
			labelPatente = new JLabel();
			getContentPane().add(labelPatente);
			labelPatente.setText(Constantes.Dni);
			labelPatente.setBounds(21, 42, 63, 28);
			labelPatente.setVisible(true);
		}
		{
			labelmarca = new JLabel();
			getContentPane().add(labelmarca);
			labelmarca.setText(Constantes.Nombre);	
			labelmarca.setBounds(21, 82, 63, 28);
			labelmarca.setVisible(true);	
		}
		{			
			labelModelo = new JLabel();
			getContentPane().add(labelModelo);
			labelModelo.setText(Constantes.Mail);	
			labelModelo.setBounds(21, 140, 63, 28);
			labelModelo.setVisible(true);
		}
		{
			labelTamanno = new JLabel();
			getContentPane().add(labelTamanno);
			labelTamanno.setText(Constantes.Telefono);
			labelTamanno.setBounds(21, 180, 63, 28);
			labelTamanno.setVisible(true);
		}
		
		
		{
			fieldPatente = new JTextField();
			getContentPane().add(fieldPatente);
			fieldPatente.setBounds(119, 42, 210, 28);
		}
		{
			fieldMarca = new JTextField();
			getContentPane().add(fieldMarca);
			fieldMarca.setBounds(119, 82, 210, 28);
		}
		{
			fieldModelo = new JTextField();
			getContentPane().add(fieldModelo);
			fieldModelo.setBounds(119, 140, 210, 28);
		}
		{
			fieldTamanno = new JTextField();
			getContentPane().add(fieldTamanno);
			fieldTamanno.setBounds(119, 180, 210, 28);
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
		}
		
		pack();
		setSize(400, 300);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
