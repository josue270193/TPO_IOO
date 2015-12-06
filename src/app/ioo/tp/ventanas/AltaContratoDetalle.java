package app.ioo.tp.ventanas;

import app.ioo.tp.Constantes;
import app.ioo.tp.Controlador;
import app.ioo.tp.vistas.ContratoView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AltaContratoDetalle extends JDialog {

    private ContratoView contratoView;
    private Controlador controlador;

    private JLabel labelFechaInicio;
    private JFormattedTextField fechaInicio;

    private JLabel labelFechaFin;
    private JFormattedTextField fechaFin;

    private JButton alta;
    private DateFormat formatoFecha;

    public AltaContratoDetalle(Controlador controlador, ContratoView contratoView) throws HeadlessException {
        super();
        this.controlador = controlador;
        this.contratoView = contratoView;
        initGUI();
    }

    private void initGUI() {
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labelFechaInicio = new JLabel(Constantes.FechaInicio);
        labelFechaInicio.setBounds(21, 12, 63, 28);
        getContentPane().add(labelFechaInicio);

        fechaInicio = new JFormattedTextField(formatoFecha);
        fechaInicio.setBounds(119, 12, 210, 28);
        getContentPane().add(fechaInicio);

        labelFechaFin = new JLabel(Constantes.FechaFin);
        labelFechaFin.setBounds(21, 52, 63, 28);
        getContentPane().add(labelFechaFin);

        fechaFin= new JFormattedTextField(formatoFecha);
        fechaFin.setBounds(119, 52, 210, 28);
        getContentPane().add(fechaFin);

        alta = new JButton(Constantes.Siguiente);
        alta.setBounds(119, 217, 150, 28);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("fechaInicio " + fechaInicio.getValue() + " - " + fechaInicio.getValue().getClass().toString());
                System.out.println("fechaFin " + fechaFin.getValue());
            }
        });

        getContentPane().add(alta);
        pack();
        setTitle(Constantes.AltaContratoAltaAuto);
        setSize(500, 300);
    }
}

