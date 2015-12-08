package app.ioo.tp.ventanas;

import app.ioo.tp.TipoCochera;
import app.ioo.tp.util.Constantes;
import app.ioo.tp.Controlador;
import app.ioo.tp.util.ItemCombo;
import app.ioo.tp.vistas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class AltaContratoDetalle extends JDialog {

    private ContratoView contratoView;
    private Controlador controlador;

    private JLabel labelFechaInicio;
    private JFormattedTextField fechaInicio;

    private JLabel labelFechaFin;
    private JFormattedTextField fechaFin;

    private JButton alta;
    private DateFormat formatoFecha;

    private Vector<ItemCombo> opciones;
    private JLabel labelMedioPago;
    private JComboBox<ItemCombo> fieldMedioPago;

    public AltaContratoDetalle(Controlador controlador, ContratoView contratoView) throws HeadlessException {
        super();
        this.controlador = controlador;
        this.contratoView = contratoView;

        opciones = new Vector<ItemCombo>();
        for (MedioDePagoView m : controlador.obtenerMediosPagoCliente(contratoView.getClienteView().getDni())){
            if (m instanceof EfectivoView){
                opciones.add(new ItemCombo(m, Constantes.MedioDePagoEfectivo));
            }
            else if (m instanceof DebitoCBUView){
                opciones.add(new ItemCombo(m, Constantes.MedioDePagoDebitoCBU + " - " + ((DebitoCBUView) m).getCbu()  ));
            }
            else if (m instanceof DebitoTarjetaCreditoView){
                opciones.add(new ItemCombo(m, Constantes.MedioDePagoDebitoTarjetaCredito + " - " + ((DebitoTarjetaCreditoView) m).getNumero_tarjeta()));
            }
        }

        initGUI();
    }

    private void initGUI() {
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labelFechaInicio = new JLabel(Constantes.FechaInicio);
        labelFechaInicio.setBounds(21, 12, 100, 28);
        getContentPane().add(labelFechaInicio);

        fechaInicio = new JFormattedTextField(formatoFecha);
        fechaInicio.setBounds(150, 12, 210, 28);
        getContentPane().add(fechaInicio);

        labelFechaFin = new JLabel(Constantes.FechaFin);
        labelFechaFin.setBounds(21, 52, 100, 28);
        getContentPane().add(labelFechaFin);

        fechaFin= new JFormattedTextField(formatoFecha);
        fechaFin.setBounds(150, 52, 210, 28);
        getContentPane().add(fechaFin);

        labelMedioPago = new JLabel(Constantes.MedioDePago);
        labelMedioPago.setBounds(21, 180, 100, 28);
        getContentPane().add(labelMedioPago);

        fieldMedioPago= new JComboBox<ItemCombo>(opciones);
        fieldMedioPago.setRenderer(new ItemCombo.ItemComboRender());
        fieldMedioPago.setBounds(150, 180, 210, 28);
        getContentPane().add(fieldMedioPago);

        alta = new JButton(Constantes.Aceptar);
        alta.setBounds(119, 217, 150, 28);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ItemCombo item = (ItemCombo) fieldMedioPago.getSelectedItem();

                contratoView.setMedioDePagoView((MedioDePagoView) item.getValue());
                contratoView.setFechaInicio((Date) fechaInicio.getValue());
                contratoView.setFechaFin((Date) fechaFin.getValue());

                if (controlador.crearContrato(
                        contratoView.getClienteView().getDni()
                        , contratoView.getMedioDePagoView().getId()
                        , contratoView.getAutoView().getPatente()
                        , contratoView.getAutoView().getMarca()
                        , contratoView.getAutoView().getModelo()
                        , contratoView.getAutoView().getTamanno()
                        , contratoView.getFechaInicio()
                        , contratoView.getFechaFin()
                )){
                    dispose();
                    JOptionPane.showMessageDialog(AltaContratoDetalle.this, Constantes.Exito_AltaContrato, "", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(AltaContratoDetalle.this, Constantes.Error_AltaContrato, "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getContentPane().add(alta);
        pack();
        setTitle(Constantes.AltaContratoAltaAuto);
        setSize(500, 300);
    }
}

