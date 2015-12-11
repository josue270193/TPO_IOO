package app.ioo.tp.ventanas;

import app.ioo.tp.Controlador;
import app.ioo.tp.util.Constantes;
import app.ioo.tp.util.ItemCombo;
import app.ioo.tp.util.WideComboBox;
import app.ioo.tp.vistas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BajaContrato extends JDialog {

    private JLabel label;
    private WideComboBox<ItemCombo> comboBox;

    private JLabel jLabel4;
    private JTextField DniCliente;

    private JButton alta;
    private JButton buscar;

    private Controlador controlador;
    private ClienteView clienteView;

    public BajaContrato(Controlador controlador) throws HeadlessException {
        super();
        this.controlador = controlador;
        initGUI();
    }

    private void initGUI() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);        
        getContentPane().setLayout(null);

        label = new JLabel(Constantes.Contrato);
        label.setBounds(21, 50, 120, 28);
        label.setVisible(false);
        getContentPane().add(label);

        comboBox = new WideComboBox<ItemCombo>();
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
                controlador.darBajaContrato(clienteView.getDni(), ((ContratoView)item.getValue()).getIdContrato() );
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
                    for (ContratoView c : controlador.obtenerContratoVigentesCliente(clienteView.getDni()) ){
                        opciones.add(new ItemCombo(c, c.getIdContrato() + " - " + c.getAutoView().getPatente() + " del "+ c.getFechaInicio() + " al " + c.getFechaFin()));
                    }
                    comboBox.setModel(new DefaultComboBoxModel<ItemCombo>(opciones));

                    alta.setEnabled(true);
                    label.setVisible(true);
                    comboBox.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(BajaContrato.this, Constantes.Error_NoExisteCliente, "", JOptionPane.ERROR_MESSAGE);

                    comboBox.removeAllItems();
                    alta.setEnabled(false);
                    label.setVisible(false);
                    comboBox.setVisible(false);
                }
            }
        });
        getContentPane().add(buscar);
        pack();
        setTitle(Constantes.BajaContrato);

        setSize(500, 300);
    }
}
