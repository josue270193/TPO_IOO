package app.ioo.tp.ventanas;

import app.ioo.tp.Constantes;
import app.ioo.tp.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaCochera extends JDialog{
	private Controlador controlador;
	
	private JLabel labelCant;
	private JLabel labelMonto;
	
	private JLabel labelPEQ;	
	private JTextField fieldPEQ;	
	private JTextField fieldMPEQ;//monto	
	
	private JLabel labelMED;
	private JTextField fieldMED;
	private JTextField fieldMMED;
	
	private JLabel labelGDE;
	private JTextField fieldGDE;
	private JTextField fieldMGDE;
	
	private JButton alta;

	private JFrame padre;
	

	public AltaCochera(JFrame padre, Controlador controlador) throws HeadlessException {
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
			labelCant = new JLabel();
			getContentPane().add(labelCant);
			labelCant.setText(Constantes.Cantidad);
			labelCant.setBounds(120, 25, 63, 28);
			labelCant.setVisible(true);
		}
		{
			labelMonto = new JLabel();
			getContentPane().add(labelMonto);
			labelMonto.setText(Constantes.Monto);
			labelMonto.setBounds(180, 25, 63, 28);
			labelMonto.setVisible(true);
		}
		{
			labelPEQ = new JLabel();
			getContentPane().add(labelPEQ);
			labelPEQ.setText(Constantes.Pequenas);
			labelPEQ.setBounds(40, 50, 63, 28);
			labelPEQ.setVisible(true);
		}	
		{
			labelMED = new JLabel();
			getContentPane().add(labelMED);
			labelMED.setText(Constantes.Medianas);	
			labelMED.setBounds(40, 80, 63, 28);
			labelMED.setVisible(true);	
		}
		{
			labelGDE = new JLabel();
			getContentPane().add(labelGDE);
			labelGDE.setText(Constantes.Grandes);
			labelGDE.setBounds(40, 110, 70, 28);
			labelGDE.setVisible(true);
		}
		
				
		{
			fieldPEQ = new JTextField();
			getContentPane().add(fieldPEQ);
			fieldPEQ.setBounds(120, 50, 50, 30);
			fieldPEQ.setText("0");
			fieldPEQ.setVisible(true);
		}
		{
			fieldMED = new JTextField();
			getContentPane().add(fieldMED);
			fieldMED.setBounds(120, 80, 50, 30);
			fieldMED.setText("0");
			fieldMED.setVisible(true);
		}
		{
			fieldGDE = new JTextField();
			getContentPane().add(fieldGDE);
			fieldGDE.setBounds(120, 110, 50, 30);
			fieldGDE.setText("0");
			fieldGDE.setVisible(true);
		}
		
		{
			fieldMPEQ = new JTextField();
			getContentPane().add(fieldMPEQ);
			fieldMPEQ.setBounds(175, 50, 50, 30);
			fieldMPEQ.setText("0");
			fieldMPEQ.setVisible(true);
		}
		{
			fieldMMED = new JTextField();
			getContentPane().add(fieldMMED);
			fieldMMED.setBounds(175, 80, 50, 30);
			fieldMMED.setText("0");
			fieldMMED.setVisible(true);	
		}
		{
			fieldMGDE = new JTextField();
			getContentPane().add(fieldMGDE);
			fieldMGDE.setBounds(175, 110, 50, 30);
			fieldMGDE.setText("0");
			fieldMGDE.setVisible(true);
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
					controlador.crearMapaCochera(
							Integer.parseInt(fieldPEQ.getText()), Integer.parseInt(fieldMPEQ.getText()),
							Integer.parseInt(fieldMED.getText()), Integer.parseInt(fieldMMED.getText()),
							Integer.parseInt(fieldGDE.getText()), Integer.parseInt(fieldMGDE.getText())
							);
					fieldGDE.setText("0");
					fieldMED.setText("0");
					fieldPEQ.setText("0");
					fieldMGDE.setText("0");
					fieldMMED.setText("0");
					fieldMPEQ.setText("0");
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
