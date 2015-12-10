package app.ioo.tp.ventanas;

import app.ioo.tp.Controlador;
import app.ioo.tp.util.Constantes;
import app.ioo.tp.vistas.ClienteView;
import app.ioo.tp.vistas.DebitoTarjetaCreditoView;
import app.ioo.tp.vistas.MedioDePagoView;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by josur on 06/12/2015.
 */
public class ModificacionTarjetaCredito extends JDialog {

    private final ClienteView clienteView;
    private final MedioDePagoView medioDePagoView;
    private Controlador controlador;

    private JButton alta;
    private JLabel labelEntidadEmisora;
    private JTextField entidadEmisora;
    private JLabel labelNumeroTarjeta;
    private JFormattedTextField numeroTarjeta;

    private DateFormat formatoFecha;
    private JLabel labelFechaVencimiento;
    private JFormattedTextField fechaVencimiento;

    public ModificacionTarjetaCredito(Controlador controlador, MedioDePagoView medioDePagoView, ClienteView clienteView) throws HeadlessException {
        super();
        this.controlador = controlador;
        this.clienteView = clienteView;
        this.medioDePagoView = medioDePagoView;
        initGUI();
    }

    private void initGUI() {
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labelEntidadEmisora = new JLabel(Constantes.EntidadEmisora);
        labelEntidadEmisora.setBounds(21, 22, 130, 28);
        getContentPane().add(labelEntidadEmisora);

        entidadEmisora = new JTextField();
        entidadEmisora.setBounds(150, 22, 210, 28);
        entidadEmisora.setText( ((DebitoTarjetaCreditoView)medioDePagoView).getEntidad_emisora() );
        getContentPane().add(entidadEmisora);

        labelNumeroTarjeta = new JLabel(Constantes.NumeroTarjeta);
        labelNumeroTarjeta.setBounds(21, 52, 130, 28);
        getContentPane().add(labelNumeroTarjeta);

        numeroTarjeta = new JFormattedTextField();
        numeroTarjeta.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        numeroTarjeta.setBounds(150, 52, 210, 28);
        numeroTarjeta.setValue(((DebitoTarjetaCreditoView)medioDePagoView).getNumero_tarjeta());
        getContentPane().add(numeroTarjeta);

        labelFechaVencimiento = new JLabel(Constantes.FechaVencimiento);
        labelFechaVencimiento.setBounds(21, 82, 130, 28);
        getContentPane().add(labelFechaVencimiento);

        fechaVencimiento = new JFormattedTextField(formatoFecha);
        fechaVencimiento.setBounds(150, 82, 210, 28);
        fechaVencimiento.setValue(((DebitoTarjetaCreditoView)medioDePagoView).getFecha_vencimiento());
        getContentPane().add(fechaVencimiento);

        alta = new JButton(Constantes.Aceptar);
        alta.setBounds(119, 217, 150, 28);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (controlador.modificarMedioDePagoTarjetaCredito(clienteView.getDni(), medioDePagoView.getId(), entidadEmisora.getText(), (long)numeroTarjeta.getValue(),(Date) fechaVencimiento.getValue())){
                    dispose();
                    JOptionPane.showMessageDialog(ModificacionTarjetaCredito.this, Constantes.Correcto_ModificacionMedioPago, "", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    dispose();
                    JOptionPane.showMessageDialog(ModificacionTarjetaCredito.this, Constantes.Error_ModificacionMedioDePago, "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        getContentPane().add(alta);

        setTitle(Constantes.MedioDePagoDebitoTarjetaCredito);
        pack();
        setSize(500, 300);

    }
}
