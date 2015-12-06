package app.ioo.tp.ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import app.ioo.tp.Constantes;
import app.ioo.tp.Controlador;
import app.ioo.tp.TipoCochera;
import app.ioo.tp.util.ItemCombo;
import app.ioo.tp.vistas.AutoView;
import app.ioo.tp.vistas.ContratoView;

public class AltaContratoAltaAuto extends JDialog {

    private ContratoView contratoView;
    private AutoView autoView;

    private Controlador controlador;

    private JLabel labelDni;
    private JTextField Dni;

    private JLabel labelPatente;
    private JTextField fieldPatente;

    private JLabel labelmarca;
    private JTextField fieldMarca;

    private JLabel labelModelo;
    private JTextField fieldModelo;

    private JLabel labelTamanno;
    private JComboBox<ItemCombo> fieldTamanno;

    private JButton alta;

    public AltaContratoAltaAuto(Controlador controlador, ContratoView contratoView) throws HeadlessException {
        super();
        this.controlador = controlador;
        this.contratoView = contratoView;
        initGUI();
    }

    private void initGUI() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labelDni = new JLabel(Constantes.Dni);
        labelDni.setBounds(21, 12, 63, 28);
        getContentPane().add(labelDni);

        Dni = new JTextField();
        Dni.setBounds(119, 12, 210, 28);
        Dni.setEnabled(false);
        getContentPane().add(Dni);

        Dni.setText(contratoView.getClienteView().getDni());

        labelPatente = new JLabel(Constantes.Patente);
        labelPatente.setBounds(21, 42, 63, 28);
        getContentPane().add(labelPatente);

        fieldPatente = new JTextField();
        fieldPatente.setBounds(119, 42, 210, 28);
        getContentPane().add(fieldPatente);

        labelmarca = new JLabel(Constantes.Marca);
        labelmarca.setBounds(21, 82, 63, 28);
        getContentPane().add(labelmarca);

        fieldMarca = new JTextField();
        fieldMarca.setBounds(119, 82, 210, 28);
        getContentPane().add(fieldMarca);

        labelModelo = new JLabel(Constantes.Modelo);
        labelModelo.setBounds(21, 140, 63, 28);
        getContentPane().add(labelModelo);

        fieldModelo = new JTextField();
        fieldModelo.setBounds(119, 140, 210, 28);
        getContentPane().add(fieldModelo);

        labelTamanno = new JLabel(Constantes.Tamanno);
        labelTamanno.setBounds(21, 180, 63, 28);
        getContentPane().add(labelTamanno);

        Vector<ItemCombo> opcionesTamano = new Vector<ItemCombo>();
        opcionesTamano.add(new ItemCombo(TipoCochera.TAMANO_PEQUENA, Constantes.Pequenas));
        opcionesTamano.add(new ItemCombo(TipoCochera.TAMANO_MEDIANA, Constantes.Medianas));
        opcionesTamano.add(new ItemCombo(TipoCochera.TAMANO_GRANDE, Constantes.Grandes));

        fieldTamanno = new JComboBox<ItemCombo>(opcionesTamano);
        fieldTamanno.setRenderer(new ItemCombo.ItemComboRender());
        fieldTamanno.setBounds(119, 180, 210, 28);
        getContentPane().add(fieldTamanno);

        alta = new JButton(Constantes.Siguiente);
        alta.setBounds(119, 217, 150, 28);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ItemCombo item = (ItemCombo) fieldTamanno.getSelectedItem();

                if (controlador.existeCocheraDisponible((Long) item.getValue()) ) {
                    autoView = new AutoView(fieldPatente.getText(), fieldMarca.getText(), fieldModelo.getText(), (Long) item.getValue());
                    contratoView.setAutoView(autoView);

                    dispose();

                    AltaContratoDetalle altaContratoDetalle = new AltaContratoDetalle(controlador, contratoView);
                    altaContratoDetalle.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(AltaContratoAltaAuto.this, Constantes.Error_NoExisteCocheraDisponible, "", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        getContentPane().add(alta);
        pack();
        setTitle(Constantes.AltaContratoAltaAuto);
        setSize(500, 300);
    }
}

