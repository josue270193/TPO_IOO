package app.ioo.tp.ventanas;

import app.ioo.tp.util.Constantes;
import app.ioo.tp.Controlador;
import app.ioo.tp.vistas.ClienteView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by josur on 06/12/2015.
 */
public class AltaEfectivo extends JDialog {

    private final ClienteView clienteView;
    private Controlador controlador;

    private JButton alta;

    public AltaEfectivo (Controlador controlador, ClienteView clienteView) throws HeadlessException {
        super();
        this.controlador = controlador;
        this.clienteView = clienteView;
        initGUI();
    }

    private void initGUI() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);


        alta = new JButton(Constantes.Aceptar);
        alta.setBounds(119, 217, 150, 28);
        alta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (controlador.altaMedioDePagoEfectivo(clienteView.getDni())){
                    dispose();
                    JOptionPane.showMessageDialog(AltaEfectivo.this, Constantes.Correcto_MedioPago, "", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    dispose();
                    JOptionPane.showMessageDialog(AltaEfectivo.this, Constantes.Error_ExisteMedioPago, "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        getContentPane().add(alta);

        setTitle(Constantes.MedioDePagoEfectivo);
        pack();
        setSize(500, 300);

    }
}
