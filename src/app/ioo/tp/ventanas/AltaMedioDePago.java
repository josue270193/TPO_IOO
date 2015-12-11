package app.ioo.tp.ventanas;

import app.ioo.tp.util.Constantes;
import app.ioo.tp.Controlador;
import app.ioo.tp.util.ItemCombo;
import app.ioo.tp.util.WideComboBox;
import app.ioo.tp.vistas.ClienteView;
import app.ioo.tp.vistas.MedioDePagoView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AltaMedioDePago extends JDialog {

    private JLabel label;
    private WideComboBox<ItemCombo> comboBox;

    private JLabel jLabel4;
    private JTextField DniCliente;

    private JButton alta;
    private JButton buscar;

    private Controlador controlador;
    private ClienteView clienteView;

    public AltaMedioDePago(Controlador controlador) throws HeadlessException {
        super();
        this.controlador = controlador;
        initGUI();
    }

    private void initGUI() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);        
        getContentPane().setLayout(null);

        label = new JLabel(Constantes.TipoMedioDePago);
        label.setBounds(21, 50, 120, 28);
        label.setVisible(false);
        getContentPane().add(label);

        Vector<ItemCombo> opciones = new Vector<ItemCombo>();
        opciones.add(new ItemCombo(MedioDePagoView.MEDIO_PAGO_EFECTIVO , Constantes.MedioDePagoEfectivo));
        opciones.add(new ItemCombo(MedioDePagoView.MEDIO_PAGO_CBU, Constantes.MedioDePagoDebitoCBU));
        opciones.add(new ItemCombo(MedioDePagoView.MEDIO_PAGO_TARJETA_CREDITO, Constantes.MedioDePagoDebitoTarjetaCredito));

        comboBox = new WideComboBox<ItemCombo>(opciones);
        comboBox.setRenderer(new ItemCombo.ItemComboRender());
        comboBox.setBounds(119, 50, 210, 28);
        comboBox.setVisible(false);
        getContentPane().add(comboBox);

        alta = new JButton(Constantes.Siguiente);
        alta.setBounds(119, 217, 150, 28);
        alta.setEnabled(false);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ItemCombo item = (ItemCombo) comboBox.getSelectedItem();

                switch ( (String) item.getValue() ){
                    case MedioDePagoView.MEDIO_PAGO_EFECTIVO:
                        AltaEfectivo ventanaEfectivo = new AltaEfectivo(controlador, clienteView);
                        ventanaEfectivo.setVisible(true);
                        break;
                    case MedioDePagoView.MEDIO_PAGO_CBU:
                        AltaCBU ventanaCBU = new AltaCBU(controlador, clienteView);
                        ventanaCBU.setVisible(true);
                        break;

                    case MedioDePagoView.MEDIO_PAGO_TARJETA_CREDITO:
                        AltaTarjetaCredito ventanaTarjetaCredito = new AltaTarjetaCredito(controlador, clienteView);
                        ventanaTarjetaCredito.setVisible(true);
                        break;


                }

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

                    alta.setEnabled(true);
                    label.setVisible(true);
                    comboBox.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(AltaMedioDePago.this, Constantes.Error_NoExisteCliente, "", JOptionPane.ERROR_MESSAGE);

                    alta.setEnabled(false);
                    label.setVisible(false);
                    comboBox.setVisible(false);

                }
            }
        });
        getContentPane().add(buscar);
        pack();
        setTitle(Constantes.AltaMedioDePago);

        setSize(500, 300);
    }
}
