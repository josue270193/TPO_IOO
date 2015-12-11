package app.ioo.tp.ventanas;

import app.ioo.tp.util.Constantes;
import app.ioo.tp.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {

    private JMenuBar menuBar;

    private JMenu menuCliente;
    private JMenuItem altaCliente;
    private JMenuItem modificacionCliente;
    private JMenuItem bajaCliente;

    private JMenu menuCochera;
    private JMenuItem altaCochera;
    private JMenuItem modificacionCochera;
    private JMenuItem bajaCochera;

    private JMenu menuAuto;
    private JMenuItem altaAuto;
    private JMenuItem modificacionAuto;
    private JMenuItem bajaAuto;

    private JMenu menuContrato;
    private JMenuItem altaContrato;
    private JMenuItem modificacionContrato;
    private JMenuItem bajaContrato;

    private JMenu menuMedioPago;
    private JMenuItem altaMedioPago;
    private JMenuItem modificacionMedioPago;
    private JMenuItem bajaMedioPago;

    private JMenu menuOpciones;
    private JMenuItem opcionSalir;

    private Controlador controlador;

    public MainWindow() {
        super();
        initGUI();
        controlador = new Controlador();
    }

    private void initGUI() {
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            menuBar = new JMenuBar();
            menuBar.setPreferredSize(new java.awt.Dimension(392, 22));

            /** CLIENTE **/
            menuCliente = new JMenu();
            menuCliente.setText(Constantes.Cliente);
            menuCliente.setPreferredSize(new java.awt.Dimension(56, 21));
            menuCliente.setMnemonic(KeyEvent.VK_1);

            altaCliente = new JMenuItem();
            altaCliente.setText(Constantes.AltaCliente);
            altaCliente.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    AltaCliente altaClienteVentana = new AltaCliente(controlador);
                    altaClienteVentana.setVisible(true);
                }
            });

            modificacionCliente = new JMenuItem();
            modificacionCliente.setText(Constantes.ModificacionCliente);
            modificacionCliente.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ModificacionCliente modificacionClienteVentana = new ModificacionCliente(controlador);
                    modificacionClienteVentana.setVisible(true);
                }
            });

            bajaCliente = new JMenuItem();
            bajaCliente.setText(Constantes.BajaCliente);
            bajaCliente.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    BajaCliente bajaClienteVentana = new BajaCliente(controlador);
                    bajaClienteVentana.setVisible(true);
                }
            });

            /** AUTO **/
            menuAuto = new JMenu();
            menuAuto.setText(Constantes.Auto);
            menuAuto.setEnabled(false);
            menuAuto.setPreferredSize(new java.awt.Dimension(56, 21));
            menuAuto.setMnemonic(KeyEvent.VK_2);

            altaAuto = new JMenuItem();
            altaAuto.setText(Constantes.AltaAuto);
            altaAuto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                }
            });

            modificacionAuto = new JMenuItem();
            modificacionAuto.setText(Constantes.ModificacionAuto);
            modificacionAuto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                }
            });

            bajaAuto = new JMenuItem();
            bajaAuto.setText(Constantes.BajaAuto);
            bajaAuto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                }
            });

            /** COCHERA **/
            menuCochera = new JMenu();
            menuCochera.setText(Constantes.Cochera);
            menuCochera.setPreferredSize(new java.awt.Dimension(60, 21));
            menuCochera.setMnemonic(KeyEvent.VK_3);

            altaCochera = new JMenuItem();
            altaCochera.setText(Constantes.AltaCochera);
            altaCochera.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    AltaCochera altaCocheraVentana = new AltaCochera(controlador);
                    altaCocheraVentana.setVisible(true);
                }
            });

            modificacionCochera = new JMenuItem();
            modificacionCochera.setText(Constantes.ModificacionCochera);
            modificacionCochera.setEnabled(false);
            modificacionCochera.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                }
            });

            bajaCochera = new JMenuItem();
            bajaCochera.setText(Constantes.BajaCochera);
            bajaCochera.setEnabled(false);
            bajaCochera.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                }
            });


            /** CONTRATO **/
            menuContrato = new JMenu();
            menuContrato.setText(Constantes.Contrato);
            menuContrato.setPreferredSize(new java.awt.Dimension(60, 21));
            menuContrato.setMnemonic(KeyEvent.VK_4);

            altaContrato= new JMenuItem();
            altaContrato.setText(Constantes.AltaContrato);
            altaContrato.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    AltaContratoBusquedaSocio altaContratoBusquedaSocioVentana = new AltaContratoBusquedaSocio(controlador);
                    altaContratoBusquedaSocioVentana.setVisible(true);
                }
            });

            modificacionContrato = new JMenuItem();
            modificacionContrato.setText(Constantes.ModificacionContrato);
            modificacionContrato.setEnabled(false);
            modificacionContrato.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                }
            });

            bajaContrato = new JMenuItem();
            bajaContrato.setText(Constantes.BajaContrato);
            bajaContrato.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    BajaContrato bajaContrato = new BajaContrato(controlador);
                    bajaContrato.setVisible(true);
                }
            });

            /** MEDIO DE PAGO **/
            menuMedioPago = new JMenu();
            menuMedioPago.setText(Constantes.MedioDePago);
            menuMedioPago.setPreferredSize(new java.awt.Dimension(100, 21));
            menuMedioPago.setMnemonic(KeyEvent.VK_5);

            altaMedioPago= new JMenuItem();
            altaMedioPago.setText(Constantes.AltaMedioDePago);
            altaMedioPago.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    AltaMedioDePago altaMedioDePagoVentana = new AltaMedioDePago(controlador);
                    altaMedioDePagoVentana.setVisible(true);
                }
            });

            modificacionMedioPago = new JMenuItem();
            modificacionMedioPago.setText(Constantes.ModificacionMedioDePago);
            modificacionMedioPago.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ModificacionMedioDePago modificacionMedioDePagoVentana = new ModificacionMedioDePago(controlador);
                    modificacionMedioDePagoVentana.setVisible(true);
                }
            });

            bajaMedioPago = new JMenuItem();
            bajaMedioPago.setText(Constantes.BajaMedioDePago);
            bajaMedioPago.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    BajaMedioDePago bajaMedioDePagoVentana = new BajaMedioDePago(controlador);
                    bajaMedioDePagoVentana.setVisible(true);
                }
            });

            /** OPCIONES **/
            menuOpciones = new JMenu();
            menuOpciones.setText(Constantes.Opciones);
            menuOpciones.setMnemonic(KeyEvent.VK_9);

            opcionSalir = new JMenuItem();
            opcionSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
            opcionSalir.setText(Constantes.OpcionSalir);
            opcionSalir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    System.exit(0);
                }
            });

            setJMenuBar(menuBar);

            menuCochera.add(altaCochera);
            menuCochera.add(modificacionCochera);
            menuCochera.add(bajaCochera);

            menuCliente.add(altaCliente);
            menuCliente.add(modificacionCliente);
            menuCliente.add(bajaCliente);

            menuAuto.add(altaAuto);
            menuAuto.add(modificacionAuto);
            menuAuto.add(bajaAuto);

            menuContrato.add(altaContrato);
            menuContrato.add(modificacionContrato);
            menuContrato.add(bajaContrato);

            menuMedioPago.add(altaMedioPago);
            menuMedioPago.add(modificacionMedioPago);
            menuMedioPago.add(bajaMedioPago);

            menuOpciones.add(opcionSalir);

            menuBar.add(menuCliente);
            menuBar.add(menuAuto);
            menuBar.add(menuCochera);
            menuBar.add(menuContrato);
            menuBar.add(menuMedioPago);
            menuBar.add(menuOpciones);

            setTitle(Constantes.VentanaPrincipal);
            pack();
            setBounds(0, 0, getToolkit().getScreenSize().width / 2, getToolkit().getScreenSize().height / 2);
            setResizable(false);
//			setAlwaysOnTop(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MainWindow inst = new MainWindow();
        inst.setVisible(true);
    }

}
