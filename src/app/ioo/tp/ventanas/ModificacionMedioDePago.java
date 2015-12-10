package app.ioo.tp.ventanas;

import app.ioo.tp.Controlador;
import app.ioo.tp.util.Constantes;
import app.ioo.tp.util.ItemCombo;
import app.ioo.tp.vistas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ModificacionMedioDePago extends JDialog {

    private JLabel label;
    private JComboBox<ItemCombo> comboBox;

    private JLabel jLabel4;
    private JTextField DniCliente;

    private JButton alta;
    private JButton buscar;

    private Controlador controlador;
    private ClienteView clienteView;

    public ModificacionMedioDePago(Controlador controlador) throws HeadlessException {
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

        comboBox = new JComboBox<ItemCombo>();
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

                if (item.getValue() instanceof EfectivoView){

                    ModificacionEfectivo ventana = new ModificacionEfectivo(controlador, (MedioDePagoView) item.getValue(), clienteView);
                    ventana.setVisible(true);

                }else if (item.getValue() instanceof DebitoCBUView){

                    ModificacionCBU ventana = new ModificacionCBU(controlador, (MedioDePagoView) item.getValue(), clienteView);
                    ventana.setVisible(true);

                }else if (item.getValue() instanceof DebitoTarjetaCreditoView){
                    ModificacionTarjetaCredito ventana = new ModificacionTarjetaCredito(controlador, (MedioDePagoView) item.getValue(), clienteView);
                    ventana.setVisible(true);

                }
                dispose();
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

                    Vector<ItemCombo> opciones = new Vector<ItemCombo>();
                    for (MedioDePagoView m : controlador.obtenerMediosPagoCliente(clienteView.getDni()) ){
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
                    comboBox.setModel(new DefaultComboBoxModel<ItemCombo>(opciones));

                    alta.setEnabled(true);
                    label.setVisible(true);
                    comboBox.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(ModificacionMedioDePago.this, Constantes.Error_NoExisteCliente, "", JOptionPane.ERROR_MESSAGE);

                    comboBox.removeAllItems();
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
