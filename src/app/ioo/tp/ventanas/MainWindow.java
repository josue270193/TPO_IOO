package app.ioo.tp.ventanas;

import app.ioo.tp.Constantes;
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
            menuAuto.setPreferredSize(new java.awt.Dimension(56, 21));
            menuAuto.setMnemonic(KeyEvent.VK_2);

            altaAuto = new JMenuItem();
            altaAuto.setText(Constantes.AltaAuto);
            altaAuto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
//					AltaAlumno a = new AltaAlumno(sistema);
//					a.setVisible(true);
                }
            });

            modificacionAuto = new JMenuItem();
            modificacionAuto.setText(Constantes.ModificacionAuto);
            modificacionAuto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
//					ModificarAlumno m = new ModificarAlumno(sistema);
//					m.setVisible(true);
                }
            });

            bajaAuto = new JMenuItem();
            bajaAuto.setText(Constantes.BajaAuto);
            bajaAuto.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
//					ModificarAlumno m = new ModificarAlumno(sistema);
//					m.setVisible(true);
                }
            });

            /** COCHERA **/
            menuCochera = new JMenu();
            menuCochera.setText(Constantes.Cochera);
            menuCochera.setPreferredSize(new java.awt.Dimension(56, 21));
            menuCochera.setMnemonic(KeyEvent.VK_3);

            altaCochera = new JMenuItem();
            altaCochera.setText(Constantes.AltaCochera);
            altaCochera.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    AltaCochera ac = new AltaCochera(controlador);
                    ac.setVisible(true);
                }
            });

            modificacionCochera = new JMenuItem();
            modificacionCochera.setText(Constantes.ModificacionCochera);
            modificacionCochera.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
//					ModificarAlumno m = new ModificarAlumno(sistema);
//					m.setVisible(true);
                }
            });

            bajaCochera = new JMenuItem();
            bajaCochera.setText(Constantes.BajaCochera);
            bajaCochera.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
//					ModificarAlumno m = new ModificarAlumno(sistema);
//					m.setVisible(true);
                }
            });



            /** OPCIONES **/
            menuOpciones = new JMenu();
            menuOpciones.setText(Constantes.Opciones);
            menuOpciones.setMnemonic(KeyEvent.VK_4);

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

            menuOpciones.add(opcionSalir);

            menuBar.add(menuCliente);
            menuBar.add(menuAuto);
            menuBar.add(menuCochera);
            menuBar.add(menuOpciones);

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
