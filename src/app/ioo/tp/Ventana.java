package app.ioo.tp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Ventana {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana ventana = new Ventana();
					ventana.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ventana() {
		inicializacion();
	}

	private void inicializacion() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel labelBoton = new JLabel("Label Accion");
		frame.getContentPane().add(labelBoton);
		
		JButton boton = new JButton("Accion");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "Ohhh... Me presionaste");				
			}
		});
		boton.setMnemonic(KeyEvent.VK_B);
		frame.getContentPane().add(boton);
	}

}
