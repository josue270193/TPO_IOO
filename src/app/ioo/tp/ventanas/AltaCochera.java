package app.ioo.tp.ventanas;

import app.ioo.tp.Constantes;
import app.ioo.tp.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaCochera extends JDialog {

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

    public AltaCochera(Controlador controlador) throws HeadlessException {
        super();
        this.controlador = controlador;
        initGUI();
    }

    private void initGUI() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labelCant = new JLabel(Constantes.Cantidad);
        labelCant.setBounds(120, 25, 63, 28);
        getContentPane().add(labelCant);

        labelMonto = new JLabel(Constantes.Monto);
        labelMonto.setBounds(180, 25, 63, 28);
        getContentPane().add(labelMonto);

        labelPEQ = new JLabel(Constantes.Pequenas);
        labelPEQ.setBounds(40, 50, 63, 28);
        getContentPane().add(labelPEQ);

        labelMED = new JLabel(Constantes.Medianas);
        labelMED.setBounds(40, 80, 63, 28);
        getContentPane().add(labelMED);

        labelGDE = new JLabel(Constantes.Grandes);
        labelGDE.setBounds(40, 110, 70, 28);
        getContentPane().add(labelGDE);

        fieldPEQ = new JTextField();
        fieldPEQ.setBounds(120, 50, 50, 30);
        fieldPEQ.setText("0");
        getContentPane().add(fieldPEQ);

        fieldMED = new JTextField();
        fieldMED.setBounds(120, 80, 50, 30);
        fieldMED.setText("0");
        getContentPane().add(fieldMED);

        fieldGDE = new JTextField();
        fieldGDE.setBounds(120, 110, 50, 30);
        fieldGDE.setText("0");
        getContentPane().add(fieldGDE);

        fieldMPEQ = new JTextField();
        fieldMPEQ.setBounds(175, 50, 50, 30);
        fieldMPEQ.setText("0");
        getContentPane().add(fieldMPEQ);

        fieldMMED = new JTextField();
        fieldMMED.setBounds(175, 80, 50, 30);
        fieldMMED.setText("0");
        getContentPane().add(fieldMMED);

        fieldMGDE = new JTextField();
        fieldMGDE.setBounds(175, 110, 50, 30);
        fieldMGDE.setText("0");
        getContentPane().add(fieldMGDE);

        alta = new JButton(Constantes.Aceptar);
        alta.setBounds(119, 217, 150, 28);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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
        getContentPane().add(alta);

        pack();
        setSize(500, 300);
    }
}
