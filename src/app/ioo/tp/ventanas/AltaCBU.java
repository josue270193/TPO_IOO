package app.ioo.tp.ventanas;

import app.ioo.tp.util.Constantes;
import app.ioo.tp.Controlador;
import app.ioo.tp.vistas.ClienteView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by josur on 06/12/2015.
 */
public class AltaCBU extends JDialog {

    private final ClienteView clienteView;
    private Controlador controlador;

    private JButton alta;
    private JLabel labelCBU;
    private JTextField cbu;
    private JLabel labelEntidadBancaria;
    private JTextField entidadBancaria;

    public AltaCBU(Controlador controlador, ClienteView clienteView) throws HeadlessException {
        super();
        this.controlador = controlador;
        this.clienteView = clienteView;
        initGUI();
    }

    private void initGUI() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labelCBU = new JLabel(Constantes.CBU);
        labelCBU.setBounds(21, 82, 100, 28);
        getContentPane().add(labelCBU);

        cbu = new JTextField();
        cbu.setBounds(150, 82, 210, 28);
        getContentPane().add(cbu);

        labelEntidadBancaria = new JLabel(Constantes.EntidadBancaria);
        labelEntidadBancaria.setBounds(21, 110, 100, 28);
        getContentPane().add(labelEntidadBancaria);

        entidadBancaria = new JTextField();
        entidadBancaria.setBounds(150, 110, 210, 28);
        getContentPane().add(entidadBancaria);

        alta = new JButton(Constantes.Aceptar);
        alta.setBounds(119, 217, 150, 28);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (controlador.altaMedioDePagoDebitoCBU(clienteView.getDni(), cbu.getText(), entidadBancaria.getText())){
                    dispose();
                    JOptionPane.showMessageDialog(AltaCBU.this, Constantes.Correcto_MedioPago, "", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    dispose();
                    JOptionPane.showMessageDialog(AltaCBU.this, Constantes.Error_ExisteMedioPago, "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        getContentPane().add(alta);

        setTitle(Constantes.MedioDePagoDebitoCBU);
        pack();
        setSize(500, 300);

    }
}
