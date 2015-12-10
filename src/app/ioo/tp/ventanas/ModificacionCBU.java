package app.ioo.tp.ventanas;

import app.ioo.tp.Controlador;
import app.ioo.tp.MedioDePago;
import app.ioo.tp.util.Constantes;
import app.ioo.tp.vistas.ClienteView;
import app.ioo.tp.vistas.DebitoCBUView;
import app.ioo.tp.vistas.DebitoTarjetaCreditoView;
import app.ioo.tp.vistas.MedioDePagoView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by josur on 06/12/2015.
 */
public class ModificacionCBU extends JDialog {

    private final ClienteView clienteView;
    private final MedioDePagoView medioDePagoView;
    private Controlador controlador;

    private JButton alta;
    private JLabel labelCBU;
    private JTextField cbu;
    private JLabel labelEntidadBancaria;
    private JTextField entidadBancaria;

    public ModificacionCBU(Controlador controlador, MedioDePagoView medioDePagoView, ClienteView clienteView) throws HeadlessException {
        super();
        this.controlador = controlador;
        this.clienteView = clienteView;
        this.medioDePagoView = medioDePagoView;
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
        cbu.setText(((DebitoCBUView)medioDePagoView).getCbu());
        getContentPane().add(cbu);

        labelEntidadBancaria = new JLabel(Constantes.EntidadBancaria);
        labelEntidadBancaria.setBounds(21, 110, 100, 28);
        getContentPane().add(labelEntidadBancaria);

        entidadBancaria = new JTextField();
        entidadBancaria.setBounds(150, 110, 210, 28);
        entidadBancaria.setText(((DebitoCBUView) medioDePagoView).getEntidad_bancaria());
        getContentPane().add(entidadBancaria);

        alta = new JButton(Constantes.Aceptar);
        alta.setBounds(119, 217, 150, 28);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (controlador.modificarMedioDePagoDebitoCBU(clienteView.getDni(), medioDePagoView.getId(), cbu.getText(), entidadBancaria.getText())){
                    dispose();
                    JOptionPane.showMessageDialog(ModificacionCBU.this, Constantes.Correcto_MedioPago, "", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    dispose();
                    JOptionPane.showMessageDialog(ModificacionCBU.this, Constantes.Error_ModificacionMedioDePago, "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        getContentPane().add(alta);

        setTitle(Constantes.MedioDePagoDebitoCBU);
        pack();
        setSize(500, 300);

    }
}
