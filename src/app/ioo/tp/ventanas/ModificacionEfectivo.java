package app.ioo.tp.ventanas;

import app.ioo.tp.Controlador;
import app.ioo.tp.util.Constantes;
import app.ioo.tp.vistas.ClienteView;
import app.ioo.tp.vistas.MedioDePagoView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by josur on 06/12/2015.
 */
public class ModificacionEfectivo extends JDialog {

    private final ClienteView clienteView;
    private final MedioDePagoView medioDePagoView;
    private Controlador controlador;

    private JButton alta;

    public ModificacionEfectivo(Controlador controlador, MedioDePagoView medioDePagoView, ClienteView clienteView) throws HeadlessException {
        super();
        this.controlador = controlador;
        this.clienteView = clienteView;
        this.medioDePagoView = medioDePagoView;
        initGUI();
    }

    private void initGUI() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        alta = new JButton(Constantes.Aceptar);
        alta.setBounds(119, 217, 150, 28);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    dispose();
            }
        });
        getContentPane().add(alta);

        setTitle(Constantes.MedioDePagoEfectivo);
        pack();
        setSize(500, 300);

    }
}
