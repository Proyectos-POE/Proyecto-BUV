/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.toedter.calendar.JYearChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author Nicolas Herrera
 */
public class VentanaBiblioteca extends javax.swing.JFrame {

    /**
     * Creates new form VentanaBiblioteca
     */
    public VentanaBiblioteca()
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UIManager.put("OptionPane.messageFont", new java.awt.Font("Montserrat", 0, 12));
        UIManager.put("TabbedPane.selected", new java.awt.Color(249, 250, 252));
        UIManager.put("TabbedPane.unselectedForeground", new java.awt.Color(249, 250, 252));
        UIManager.put("TabbedPane.selectedBackground", new java.awt.Color(249, 250, 252));
        UIManager.put("TabbedPane.focus", new java.awt.Color(249, 250, 252));
    }

    public void pantallaCompleta()
    {
        this.setVisible(true);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
    }

    public void initEncabezado()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jpEncabezado = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnUsuario = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        jpEncabezado.setBackground(new java.awt.Color(225, 232, 239));
        jpEncabezado.setLayout(new java.awt.GridBagLayout());

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoUnivalleS.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 20, 40);
        jpEncabezado.add(lblIcono, gridBagConstraints);

        lblTitulo.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        lblTitulo.setText("BIBLIOTECA UNIVERSITARIA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jpEncabezado.add(lblTitulo, gridBagConstraints);

        btnUsuario.setBackground(new java.awt.Color(255, 0, 0));
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuarioB.png"))); // NOI18N
        btnUsuario.setActionCommand("usuario");
        btnUsuario.setBorderPainted(false);
        btnUsuario.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpEncabezado.add(btnUsuario, gridBagConstraints);

        btnCerrarSesion.setBackground(new java.awt.Color(255, 0, 0));
        btnCerrarSesion.setForeground(new java.awt.Color(255, 0, 51));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrarSesion.png"))); // NOI18N
        btnCerrarSesion.setActionCommand("cerrarSesion");
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 20);
        jpEncabezado.add(btnCerrarSesion, gridBagConstraints);

        getContentPane().add(jpEncabezado, java.awt.BorderLayout.PAGE_START);

        pack();
    }

    public void initMenuU()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jpMenu = new javax.swing.JPanel();
        jpMenuUsuario = new javax.swing.JPanel();
        btnLibrosUsuario = new javax.swing.JButton();
        btnPrestamosUsuario = new javax.swing.JButton();
        btnMultasUsuario = new javax.swing.JButton();
        btnSolicitudUsuario = new javax.swing.JButton();

        jpMenu.setLayout(new java.awt.CardLayout());

        jpMenuUsuario.setBackground(new java.awt.Color(235, 238, 243));
        jpMenuUsuario.setLayout(new java.awt.GridBagLayout());

        btnLibrosUsuario.setBackground(new java.awt.Color(225, 232, 239));
        btnLibrosUsuario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnLibrosUsuario.setText("LIBROS");
        btnLibrosUsuario.setActionCommand("libroUsuario");
        btnLibrosUsuario.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuUsuario.add(btnLibrosUsuario, gridBagConstraints);

        btnPrestamosUsuario.setBackground(new java.awt.Color(225, 232, 239));
        btnPrestamosUsuario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnPrestamosUsuario.setText("PRESTAMOS");
        btnPrestamosUsuario.setActionCommand("prestamoUsuario");
        btnPrestamosUsuario.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuUsuario.add(btnPrestamosUsuario, gridBagConstraints);

        btnMultasUsuario.setBackground(new java.awt.Color(225, 232, 239));
        btnMultasUsuario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnMultasUsuario.setText("MULTAS");
        btnMultasUsuario.setActionCommand("multasUsuario");
        btnMultasUsuario.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuUsuario.add(btnMultasUsuario, gridBagConstraints);

        btnSolicitudUsuario.setBackground(new java.awt.Color(225, 232, 239));
        btnSolicitudUsuario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnSolicitudUsuario.setText("SOLICITUDES");
        btnSolicitudUsuario.setActionCommand("solicitudUsuario");
        btnSolicitudUsuario.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuUsuario.add(btnSolicitudUsuario, gridBagConstraints);

        jpMenu.add(jpMenuUsuario, "jpMenuUsuario");

        getContentPane().add(jpMenu, java.awt.BorderLayout.WEST);

        pack();
    }

    public void initMenuA()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jpMenu = new javax.swing.JPanel();
        jpMenuAdmin = new javax.swing.JPanel();
        btnLibrosAdmin = new javax.swing.JButton();
        btnPrestamosAdmin = new javax.swing.JButton();
        btnMultasAdmin = new javax.swing.JButton();
        btnSolicitudAdmin = new javax.swing.JButton();
        btnAutoresAdmin = new javax.swing.JButton();
        btnEditorialesAdmin = new javax.swing.JButton();
        btnAreasAdmin = new javax.swing.JButton();
        btnDescargasAdmin = new javax.swing.JButton();
        btnEmpleadosAdmin = new javax.swing.JButton();
        btnUsuariosAdmin = new javax.swing.JButton();

        jpMenu.setLayout(new java.awt.CardLayout());

        jpMenuAdmin.setBackground(new java.awt.Color(235, 238, 243));
        jpMenuAdmin.setLayout(new java.awt.GridBagLayout());

        btnLibrosAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnLibrosAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnLibrosAdmin.setText("LIBROS");
        btnLibrosAdmin.setActionCommand("libroAdmin");
        btnLibrosAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnLibrosAdmin, gridBagConstraints);

        btnPrestamosAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnPrestamosAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnPrestamosAdmin.setText("PRESTAMOS");
        btnPrestamosAdmin.setActionCommand("prestamoAdmin");
        btnPrestamosAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnPrestamosAdmin, gridBagConstraints);

        btnMultasAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnMultasAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnMultasAdmin.setText("MULTAS");
        btnMultasAdmin.setActionCommand("multaAdmin");
        btnMultasAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnMultasAdmin, gridBagConstraints);

        btnSolicitudAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnSolicitudAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnSolicitudAdmin.setText("SOLICITUDES");
        btnSolicitudAdmin.setActionCommand("solicitudAdmin");
        btnSolicitudAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnSolicitudAdmin, gridBagConstraints);

        btnAutoresAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnAutoresAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnAutoresAdmin.setText("AUTORES");
        btnAutoresAdmin.setActionCommand("autorAdmin");
        btnAutoresAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnAutoresAdmin, gridBagConstraints);

        btnEditorialesAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnEditorialesAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnEditorialesAdmin.setText("EDITORIALES");
        btnEditorialesAdmin.setActionCommand("editorialAdmin");
        btnEditorialesAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnEditorialesAdmin, gridBagConstraints);

        btnAreasAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnAreasAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnAreasAdmin.setText("AREAS");
        btnAreasAdmin.setActionCommand("areaAdmin");
        btnAreasAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnAreasAdmin, gridBagConstraints);

        btnDescargasAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnDescargasAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnDescargasAdmin.setText("DESCARGAS");
        btnDescargasAdmin.setActionCommand("descargaAdmin");
        btnDescargasAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnDescargasAdmin, gridBagConstraints);

        btnEmpleadosAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnEmpleadosAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnEmpleadosAdmin.setText("EMPLEADOS");
        btnEmpleadosAdmin.setActionCommand("empleadoAdmin");
        btnEmpleadosAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnEmpleadosAdmin, gridBagConstraints);

        btnUsuariosAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnUsuariosAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnUsuariosAdmin.setText("USUARIOS");
        btnUsuariosAdmin.setActionCommand("usuarioAdmin");
        btnUsuariosAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnUsuariosAdmin, gridBagConstraints);

        jpMenu.add(jpMenuAdmin, "jpMenuAdmin");

        getContentPane().add(jpMenu, java.awt.BorderLayout.WEST);

        pack();
    }

    public void initMenuE()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jpMenu = new javax.swing.JPanel();
        jpMenuEmpleado = new javax.swing.JPanel();
        btnPrestamosEmpleado = new javax.swing.JButton();
        btnDevolucionesEmpleado = new javax.swing.JButton();
        btnSolicitudesEmpleado = new javax.swing.JButton();

        jpMenu.setLayout(new java.awt.CardLayout());

        jpMenuEmpleado.setBackground(new java.awt.Color(235, 238, 243));
        jpMenuEmpleado.setLayout(new java.awt.GridBagLayout());

        btnPrestamosEmpleado.setBackground(new java.awt.Color(225, 232, 239));
        btnPrestamosEmpleado.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnPrestamosEmpleado.setText("PRESTAMOS");
        btnPrestamosEmpleado.setActionCommand("prestamoEmpleado");
        btnPrestamosEmpleado.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuEmpleado.add(btnPrestamosEmpleado, gridBagConstraints);

        btnDevolucionesEmpleado.setBackground(new java.awt.Color(225, 232, 239));
        btnDevolucionesEmpleado.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnDevolucionesEmpleado.setText("DEVOLUCIONES");
        btnDevolucionesEmpleado.setActionCommand("devolucionEmpleado");
        btnDevolucionesEmpleado.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuEmpleado.add(btnDevolucionesEmpleado, gridBagConstraints);

        btnSolicitudesEmpleado.setBackground(new java.awt.Color(225, 232, 239));
        btnSolicitudesEmpleado.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnSolicitudesEmpleado.setText("SOLICITUDES");
        btnSolicitudesEmpleado.setActionCommand("solicitudEmpleado");
        btnSolicitudesEmpleado.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuEmpleado.add(btnSolicitudesEmpleado, gridBagConstraints);

        jpMenu.add(jpMenuEmpleado, "jpMenuEmpleado");

        getContentPane().add(jpMenu, java.awt.BorderLayout.WEST);

        pack();
    }

    public void initContU()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jpContenido = new javax.swing.JPanel();
        jpLibroUsuario = new javax.swing.JPanel();
        jpFormularioLibroU = new javax.swing.JPanel();
        lblTituloLibroU = new javax.swing.JLabel();
        lblIsbnLibroU = new javax.swing.JLabel();
        txtIsbnLibroU = new javax.swing.JTextField();
        btnDescargaLibroU = new javax.swing.JButton();
        jpTablaLibroU = new javax.swing.JPanel();
        jpsTablaLibroU = new javax.swing.JScrollPane();
        jtTablaLibroU = new javax.swing.JTable();
        jpPrestamoUsuario = new javax.swing.JPanel();
        jpFormularioPrestamoU = new javax.swing.JPanel();
        lblTituloPrestamoU = new javax.swing.JLabel();
        jpTablaPrestamoU = new javax.swing.JPanel();
        jpsTablaPrestamoU = new javax.swing.JScrollPane();
        jtTablaPrestamoU = new javax.swing.JTable();
        jpMultaUsuario = new javax.swing.JPanel();
        jpFormularioMultaU = new javax.swing.JPanel();
        lblMultasTitulo = new javax.swing.JLabel();
        lblNumeroMultaU = new javax.swing.JLabel();
        txtNumeroMultaU = new javax.swing.JTextField();
        btnPagarMultaU = new javax.swing.JButton();
        jpTablaMultaU = new javax.swing.JPanel();
        jpsTablaMultaU = new javax.swing.JScrollPane();
        jtTablaMultaU = new javax.swing.JTable();
        jpSolicitudUsuario = new javax.swing.JPanel();
        jpFormularioSolicitudU = new javax.swing.JPanel();
        lblIsbnSolicitudU = new javax.swing.JLabel();
        txtIsbnSolicitudU = new javax.swing.JTextField();
        lblTituloSolicitudU = new javax.swing.JLabel();
        txtTituloSolicitudU = new javax.swing.JTextField();
        lblDescripcionSolicitudU = new javax.swing.JLabel();
        jpsDescripcionSolicitudU = new javax.swing.JScrollPane();
        txaDescripcionSolicitudU = new javax.swing.JTextArea();
        btnEnviarSolicitudU = new javax.swing.JButton();
        lblTituloSolicitudesU = new javax.swing.JLabel();
        jpTablaSolicitudU = new javax.swing.JPanel();
        jpsTablaSolicitudU = new javax.swing.JScrollPane();
        jtTablaSolicitudU = new javax.swing.JTable();

        jpContenido.setBackground(new java.awt.Color(249, 250, 252));
        jpContenido.setLayout(new java.awt.CardLayout());

        jpLibroUsuario.setOpaque(false);
        jpLibroUsuario.setLayout(new java.awt.BorderLayout());

        jpFormularioLibroU.setOpaque(false);
        jpFormularioLibroU.setLayout(new java.awt.GridBagLayout());

        lblTituloLibroU.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloLibroU.setText("LIBROS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioLibroU.add(lblTituloLibroU, gridBagConstraints);

        lblIsbnLibroU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnLibroU.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        jpFormularioLibroU.add(lblIsbnLibroU, gridBagConstraints);

        txtIsbnLibroU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jpFormularioLibroU.add(txtIsbnLibroU, gridBagConstraints);

        btnDescargaLibroU.setBackground(new java.awt.Color(255, 0, 51));
        btnDescargaLibroU.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnDescargaLibroU.setForeground(new java.awt.Color(255, 255, 255));
        btnDescargaLibroU.setText("DESCARGAR");
        btnDescargaLibroU.setBorderPainted(false);
        btnDescargaLibroU.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jpFormularioLibroU.add(btnDescargaLibroU, gridBagConstraints);

        jpLibroUsuario.add(jpFormularioLibroU, java.awt.BorderLayout.PAGE_START);

        jpTablaLibroU.setOpaque(false);
        jpTablaLibroU.setLayout(new java.awt.GridBagLayout());

        jtTablaLibroU.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaLibroU.setDefaultEditor(Object.class, null);
        jtTablaLibroU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaLibroU.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "ISBN", "TITULO", "AUTOR", "EDITORIAL", "PUBLICACION", "IDIOMA", "# PAGINAS", "EJEMPLARES", "DIGITAL"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaLibroU.getTableHeader().setResizingAllowed(false);
        jtTablaLibroU.getTableHeader().setReorderingAllowed(false);
        jpsTablaLibroU.setViewportView(jtTablaLibroU);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaLibroU.add(jpsTablaLibroU, gridBagConstraints);

        jpLibroUsuario.add(jpTablaLibroU, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpLibroUsuario, "libroUsuario");

        jpPrestamoUsuario.setOpaque(false);
        jpPrestamoUsuario.setLayout(new java.awt.BorderLayout());

        jpFormularioPrestamoU.setOpaque(false);
        jpFormularioPrestamoU.setLayout(new java.awt.GridBagLayout());

        lblTituloPrestamoU.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloPrestamoU.setText("PRESTAMOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioPrestamoU.add(lblTituloPrestamoU, gridBagConstraints);

        jpPrestamoUsuario.add(jpFormularioPrestamoU, java.awt.BorderLayout.PAGE_START);

        jpTablaPrestamoU.setOpaque(false);
        jpTablaPrestamoU.setLayout(new java.awt.GridBagLayout());

        jtTablaPrestamoU.getTableHeader().setFont(new java.awt.Font("Montserrat", 0, 12));
        jtTablaPrestamoU.setDefaultEditor(Object.class, null);
        jtTablaPrestamoU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaPrestamoU.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# PRESTAMO", "FECHA REALIZACION", "ISBN", "# EJEMPLAR", "FECHA DEVOLUCION", "EMPLEADO", "ESTADO"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaPrestamoU.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaPrestamoU.getTableHeader().setResizingAllowed(false);
        jtTablaPrestamoU.getTableHeader().setReorderingAllowed(false);
        jpsTablaPrestamoU.setViewportView(jtTablaPrestamoU);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaPrestamoU.add(jpsTablaPrestamoU, gridBagConstraints);

        jpPrestamoUsuario.add(jpTablaPrestamoU, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpPrestamoUsuario, "prestamoUsuario");

        jpMultaUsuario.setOpaque(false);
        jpMultaUsuario.setLayout(new java.awt.BorderLayout());

        jpFormularioMultaU.setOpaque(false);
        jpFormularioMultaU.setLayout(new java.awt.GridBagLayout());

        lblMultasTitulo.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblMultasTitulo.setText("MULTAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioMultaU.add(lblMultasTitulo, gridBagConstraints);

        lblNumeroMultaU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumeroMultaU.setText("# MULTA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        jpFormularioMultaU.add(lblNumeroMultaU, gridBagConstraints);

        txtNumeroMultaU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jpFormularioMultaU.add(txtNumeroMultaU, gridBagConstraints);

        btnPagarMultaU.setBackground(new java.awt.Color(255, 0, 0));
        btnPagarMultaU.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnPagarMultaU.setForeground(new java.awt.Color(255, 255, 255));
        btnPagarMultaU.setText("PAGAR");
        btnPagarMultaU.setBorderPainted(false);
        btnPagarMultaU.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 50;
        jpFormularioMultaU.add(btnPagarMultaU, gridBagConstraints);

        jpMultaUsuario.add(jpFormularioMultaU, java.awt.BorderLayout.PAGE_START);

        jpTablaMultaU.setOpaque(false);
        jpTablaMultaU.setLayout(new java.awt.GridBagLayout());

        jtTablaMultaU.getTableHeader().setFont(new java.awt.Font("Montserrat", 0, 12));
        jtTablaMultaU.setDefaultEditor(Object.class, null);
        jtTablaMultaU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaMultaU.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# MULTA", "ISBN", "# EJEMPLAR", "FECHA MULTA", "VALOR", "DESCRIPCION"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaMultaU.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaMultaU.getTableHeader().setResizingAllowed(false);
        jtTablaMultaU.getTableHeader().setReorderingAllowed(false);
        jpsTablaMultaU.setViewportView(jtTablaMultaU);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaMultaU.add(jpsTablaMultaU, gridBagConstraints);

        jpMultaUsuario.add(jpTablaMultaU, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpMultaUsuario, "multaUsuario");

        jpSolicitudUsuario.setOpaque(false);
        jpSolicitudUsuario.setLayout(new java.awt.BorderLayout());

        jpFormularioSolicitudU.setOpaque(false);
        jpFormularioSolicitudU.setLayout(new java.awt.GridBagLayout());

        lblIsbnSolicitudU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnSolicitudU.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jpFormularioSolicitudU.add(lblIsbnSolicitudU, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jpFormularioSolicitudU.add(txtIsbnSolicitudU, gridBagConstraints);

        lblTituloSolicitudU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTituloSolicitudU.setText("TITULO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jpFormularioSolicitudU.add(lblTituloSolicitudU, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jpFormularioSolicitudU.add(txtTituloSolicitudU, gridBagConstraints);

        lblDescripcionSolicitudU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDescripcionSolicitudU.setText("DESCRIPCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jpFormularioSolicitudU.add(lblDescripcionSolicitudU, gridBagConstraints);

        txaDescripcionSolicitudU.setColumns(20);
        txaDescripcionSolicitudU.setRows(5);
        jpsDescripcionSolicitudU.setViewportView(txaDescripcionSolicitudU);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 20, 10);
        jpFormularioSolicitudU.add(jpsDescripcionSolicitudU, gridBagConstraints);

        btnEnviarSolicitudU.setBackground(new java.awt.Color(255, 0, 0));
        btnEnviarSolicitudU.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEnviarSolicitudU.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviarSolicitudU.setText("ENVIAR");
        btnEnviarSolicitudU.setBorderPainted(false);
        btnEnviarSolicitudU.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 50;
        jpFormularioSolicitudU.add(btnEnviarSolicitudU, gridBagConstraints);

        lblTituloSolicitudesU.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloSolicitudesU.setText("SOLICITUDES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioSolicitudU.add(lblTituloSolicitudesU, gridBagConstraints);

        jpSolicitudUsuario.add(jpFormularioSolicitudU, java.awt.BorderLayout.NORTH);

        jpTablaSolicitudU.setOpaque(false);
        jpTablaSolicitudU.setLayout(new java.awt.GridBagLayout());

        jpsTablaSolicitudU.setOpaque(false);

        jtTablaSolicitudU.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaSolicitudU.setDefaultEditor(Object.class, null);
        jtTablaSolicitudU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaSolicitudU.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# SOLICITUD", "ISBN", "TITULO", "DESCRIPCION"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaSolicitudU.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaSolicitudU.getTableHeader().setResizingAllowed(false);
        jtTablaSolicitudU.getTableHeader().setReorderingAllowed(false);
        jpsTablaSolicitudU.setViewportView(jtTablaSolicitudU);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 0);
        jpTablaSolicitudU.add(jpsTablaSolicitudU, gridBagConstraints);

        jpSolicitudUsuario.add(jpTablaSolicitudU, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpSolicitudUsuario, "solicitudUsuario");

        getContentPane().add(jpContenido, java.awt.BorderLayout.CENTER);

        pack();
    }

    public void initPerfilE()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jpPerfilUsuarioE = new javax.swing.JPanel();
        lblTituloUsuarioPE = new javax.swing.JLabel();
        lblCedulaEstudianteP = new javax.swing.JLabel();
        txtCedulaEstudianteP = new javax.swing.JTextField();
        lblTelefonoEstudianteP = new javax.swing.JLabel();
        txtTelefonoEstudianteP = new javax.swing.JTextField();
        lblNombreEstudianteP = new javax.swing.JLabel();
        txtNombreEstudianteP = new javax.swing.JTextField();
        lblCarreraEstudianteP = new javax.swing.JLabel();
        txtCarreraEstudianteP = new javax.swing.JTextField();
        lblDireccionEstudianteP = new javax.swing.JLabel();
        txtDireccionEstudianteP = new javax.swing.JTextField();
        lblClaveEstudianteP = new javax.swing.JLabel();
        txtClaveEstudianteP = new javax.swing.JTextField();
        lblUniversidadEstudianteP = new javax.swing.JLabel();
        txtUniversidadEstudianteP = new javax.swing.JTextField();
        lblCorreoEstudianteP = new javax.swing.JLabel();
        txtCorreoEstudianteP = new javax.swing.JTextField();
        btnModificarPerfilE = new javax.swing.JButton();

        jpPerfilUsuarioE.setOpaque(false);
        jpPerfilUsuarioE.setLayout(new java.awt.GridBagLayout());

        lblTituloUsuarioPE.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloUsuarioPE.setText("USUARIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpPerfilUsuarioE.add(lblTituloUsuarioPE, gridBagConstraints);

        lblCedulaEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaEstudianteP.setText("CEDULA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpPerfilUsuarioE.add(lblCedulaEstudianteP, gridBagConstraints);

        txtCedulaEstudianteP.setEditable(false);
        txtCedulaEstudianteP.setColumns(5);
        txtCedulaEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtCedulaEstudianteP, gridBagConstraints);

        lblTelefonoEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTelefonoEstudianteP.setText("TELEFONO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblTelefonoEstudianteP, gridBagConstraints);

        txtTelefonoEstudianteP.setColumns(5);
        txtTelefonoEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtTelefonoEstudianteP, gridBagConstraints);

        lblNombreEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombreEstudianteP.setText("NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblNombreEstudianteP, gridBagConstraints);

        txtNombreEstudianteP.setColumns(5);
        txtNombreEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtNombreEstudianteP, gridBagConstraints);

        lblCarreraEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCarreraEstudianteP.setText("CARRERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblCarreraEstudianteP, gridBagConstraints);

        txtCarreraEstudianteP.setColumns(5);
        txtCarreraEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpPerfilUsuarioE.add(txtCarreraEstudianteP, gridBagConstraints);

        lblDireccionEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDireccionEstudianteP.setText("DIRECCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblDireccionEstudianteP, gridBagConstraints);

        txtDireccionEstudianteP.setColumns(5);
        txtDireccionEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtDireccionEstudianteP, gridBagConstraints);

        lblClaveEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblClaveEstudianteP.setText("CLAVE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpPerfilUsuarioE.add(lblClaveEstudianteP, gridBagConstraints);

        txtClaveEstudianteP.setColumns(5);
        txtClaveEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtClaveEstudianteP, gridBagConstraints);

        lblUniversidadEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblUniversidadEstudianteP.setText("UNIVERSIDAD");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblUniversidadEstudianteP, gridBagConstraints);

        txtUniversidadEstudianteP.setColumns(5);
        txtUniversidadEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpPerfilUsuarioE.add(txtUniversidadEstudianteP, gridBagConstraints);

        lblCorreoEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCorreoEstudianteP.setText("CORREO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblCorreoEstudianteP, gridBagConstraints);

        txtCorreoEstudianteP.setColumns(5);
        txtCorreoEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtCorreoEstudianteP, gridBagConstraints);

        btnModificarPerfilE.setBackground(new java.awt.Color(255, 0, 0));
        btnModificarPerfilE.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarPerfilE.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarPerfilE.setText("MODIFICAR");
        btnModificarPerfilE.setBorderPainted(false);
        btnModificarPerfilE.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpPerfilUsuarioE.add(btnModificarPerfilE, gridBagConstraints);

        jpContenido.add(jpPerfilUsuarioE, "perfilEstudiante");

        pack();
    }

    public void initPerfilP()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jpPerfilUsuarioP = new javax.swing.JPanel();
        lblTituloUsuarioPP = new javax.swing.JLabel();
        lblCedulaProfesorP = new javax.swing.JLabel();
        txtCedulaProfesorP = new javax.swing.JTextField();
        lblTelefonoProfesorP = new javax.swing.JLabel();
        txtTelefonoProfesorP = new javax.swing.JTextField();
        lblNombreProfesorP = new javax.swing.JLabel();
        txtNombreProfesorP = new javax.swing.JTextField();
        lblTituloProfesorP = new javax.swing.JLabel();
        txtTituloProfesorP = new javax.swing.JTextField();
        lblDireccionProfesorP = new javax.swing.JLabel();
        txtDireccionProfesorP = new javax.swing.JTextField();
        lblClaveProfesorP = new javax.swing.JLabel();
        txtClaveProfesorP = new javax.swing.JTextField();
        lblDependenciaProfesorP = new javax.swing.JLabel();
        txtDependenciaProfesorP = new javax.swing.JTextField();
        lblCorreoProfesorP = new javax.swing.JLabel();
        txtCorreoProfesorP = new javax.swing.JTextField();
        btnModificarPerfilP = new javax.swing.JButton();

        jpPerfilUsuarioP.setOpaque(false);
        jpPerfilUsuarioP.setLayout(new java.awt.GridBagLayout());

        lblTituloUsuarioPP.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloUsuarioPP.setText("USUARIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpPerfilUsuarioP.add(lblTituloUsuarioPP, gridBagConstraints);

        lblCedulaProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaProfesorP.setText("CEDULA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpPerfilUsuarioP.add(lblCedulaProfesorP, gridBagConstraints);

        txtCedulaProfesorP.setEditable(false);
        txtCedulaProfesorP.setColumns(5);
        txtCedulaProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtCedulaProfesorP, gridBagConstraints);

        lblTelefonoProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTelefonoProfesorP.setText("TELEFONO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblTelefonoProfesorP, gridBagConstraints);

        txtTelefonoProfesorP.setColumns(5);
        txtTelefonoProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtTelefonoProfesorP, gridBagConstraints);

        lblNombreProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombreProfesorP.setText("NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblNombreProfesorP, gridBagConstraints);

        txtNombreProfesorP.setColumns(5);
        txtNombreProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtNombreProfesorP, gridBagConstraints);

        lblTituloProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTituloProfesorP.setText("TITULO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblTituloProfesorP, gridBagConstraints);

        txtTituloProfesorP.setColumns(5);
        txtTituloProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpPerfilUsuarioP.add(txtTituloProfesorP, gridBagConstraints);

        lblDireccionProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDireccionProfesorP.setText("DIRECCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblDireccionProfesorP, gridBagConstraints);

        txtDireccionProfesorP.setColumns(5);
        txtDireccionProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtDireccionProfesorP, gridBagConstraints);

        lblClaveProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblClaveProfesorP.setText("CLAVE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpPerfilUsuarioP.add(lblClaveProfesorP, gridBagConstraints);

        txtClaveProfesorP.setColumns(5);
        txtClaveProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtClaveProfesorP, gridBagConstraints);

        lblDependenciaProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDependenciaProfesorP.setText("DEPENDENCIA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblDependenciaProfesorP, gridBagConstraints);

        txtDependenciaProfesorP.setColumns(5);
        txtDependenciaProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpPerfilUsuarioP.add(txtDependenciaProfesorP, gridBagConstraints);

        lblCorreoProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCorreoProfesorP.setText("CORREO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblCorreoProfesorP, gridBagConstraints);

        txtCorreoProfesorP.setColumns(5);
        txtCorreoProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtCorreoProfesorP, gridBagConstraints);

        btnModificarPerfilP.setBackground(new java.awt.Color(255, 0, 0));
        btnModificarPerfilP.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarPerfilP.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarPerfilP.setText("MODIFICAR");
        btnModificarPerfilP.setBorderPainted(false);
        btnModificarPerfilP.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpPerfilUsuarioP.add(btnModificarPerfilP, gridBagConstraints);

        jpContenido.add(jpPerfilUsuarioP, "perfilProfesor");

        pack();
    }

    public void initContA()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jpContenido = new javax.swing.JPanel();
        jpAreaAdmin = new javax.swing.JPanel();
        jpFormularioAreaA = new javax.swing.JPanel();
        lblNombreAreaA = new javax.swing.JLabel();
        txtNombreAreaA = new javax.swing.JTextField();
        lblDescripcionAreaA = new javax.swing.JLabel();
        jspDescripcionAreaA = new javax.swing.JScrollPane();
        txaDescripcionAreaA = new javax.swing.JTextArea();
        lblTituloAreaA = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblCodigoArea1A = new javax.swing.JLabel();
        txtCodigoArea1A = new javax.swing.JTextField();
        lblCodigoArea2A = new javax.swing.JLabel();
        txtCodigoArea2A = new javax.swing.JTextField();
        btnAgregarAreaA = new javax.swing.JButton();
        btnModificarAreaA = new javax.swing.JButton();
        btnEliminarAreaA = new javax.swing.JButton();
        btnRelacionarAreaA = new javax.swing.JButton();
        txtIdAreaA = new javax.swing.JTextField();
        jpTablaAreaA = new javax.swing.JPanel();
        jpsTablaAreaA = new javax.swing.JScrollPane();
        jtTablaAreaA = new javax.swing.JTable();
        jpEditorialAdmin = new javax.swing.JPanel();
        jpFormularioEditorialA = new javax.swing.JPanel();
        lblTituloEditorialA = new javax.swing.JLabel();
        lblNombreEditorialA = new javax.swing.JLabel();
        txtNombreEditorialA = new javax.swing.JTextField();
        lblPaisEditorialA = new javax.swing.JLabel();
        txtPaisEditorialA = new javax.swing.JTextField();
        lblPaginaWebEditorialA = new javax.swing.JLabel();
        txtPaginaWebEditorialA = new javax.swing.JTextField();
        btnAgregarEditorialA = new javax.swing.JButton();
        btnModificarEditorialA = new javax.swing.JButton();
        btnEliminarEditorialA = new javax.swing.JButton();
        txtIdEditorialA = new javax.swing.JTextField();
        jpTablaEditorialA = new javax.swing.JPanel();
        jspTablaEditorialA = new javax.swing.JScrollPane();
        jtTablaEditorialA = new javax.swing.JTable();
        jpAutorAdmin = new javax.swing.JPanel();
        jpFormularioAutorA = new javax.swing.JPanel();
        lblTituloAutorA = new javax.swing.JLabel();
        lblNombre1AutorA = new javax.swing.JLabel();
        txtNombre1AutorA = new javax.swing.JTextField();
        lblNombre2Autor2 = new javax.swing.JLabel();
        txtNombre2AutorA = new javax.swing.JTextField();
        lblApellido1AutorA = new javax.swing.JLabel();
        txtApellido1AutorA = new javax.swing.JTextField();
        lblApellido2AutorA = new javax.swing.JLabel();
        txtApellido2AutorA = new javax.swing.JTextField();
        btnEliminarAutorA = new javax.swing.JButton();
        btnModificarAutorA = new javax.swing.JButton();
        btnAgregarAutorA = new javax.swing.JButton();
        txtIdAutorA = new javax.swing.JTextField();
        jpTablaAutorA = new javax.swing.JPanel();
        jspTablaAutorA = new javax.swing.JScrollPane();
        jtTablaAutorA = new javax.swing.JTable();
        jpPrestamoAdmin = new javax.swing.JPanel();
        jpFormularioPrestamoA = new javax.swing.JPanel();
        lblTituloPrestamoA = new javax.swing.JLabel();
        jpTablaPrestamoA = new javax.swing.JPanel();
        jspTablaPrestamoA = new javax.swing.JScrollPane();
        jtTablaPrestamoA = new javax.swing.JTable();
        jpDescargaAdmin = new javax.swing.JPanel();
        jpFormularioDescargaA = new javax.swing.JPanel();
        lblTituloDescargaA = new javax.swing.JLabel();
        jpTablaDescargaA = new javax.swing.JPanel();
        jspTablaDescargaA = new javax.swing.JScrollPane();
        jtTablaDescargaA = new javax.swing.JTable();
        jpMultaAdmin = new javax.swing.JPanel();
        jpFormularioMultaA = new javax.swing.JPanel();
        lblTituloMultaA = new javax.swing.JLabel();
        jpTablaMultaA = new javax.swing.JPanel();
        jspTablaMultaA = new javax.swing.JScrollPane();
        jtTablaMultaA = new javax.swing.JTable();
        jpSolicitudAdmin = new javax.swing.JPanel();
        jpFormularioSolicitudA = new javax.swing.JPanel();
        lblTituloSolicitudA = new javax.swing.JLabel();
        jpTablaSolicitudA = new javax.swing.JPanel();
        jspTablaSolicitudA = new javax.swing.JScrollPane();
        jtTablaSolicitudA = new javax.swing.JTable();
        jpEmpleadoAdmin = new javax.swing.JPanel();
        jpFormularioEmpleadoA = new javax.swing.JPanel();
        lblTituloEmpleadoA = new javax.swing.JLabel();
        lblCedulaEmpleadoA = new javax.swing.JLabel();
        txtCedulaEmpleadoA = new javax.swing.JTextField();
        lblTelefonoEmpleadoA = new javax.swing.JLabel();
        txtTelefonoEmpleadoA = new javax.swing.JTextField();
        lblNombreEmpleadoA = new javax.swing.JLabel();
        txtNombreEmpleadoA = new javax.swing.JTextField();
        lblCargoEmpleadoA = new javax.swing.JLabel();
        txtCargoEmpleadoA = new javax.swing.JTextField();
        btnEliminarEmpleadoA = new javax.swing.JButton();
        btnModificarEmpleadoA = new javax.swing.JButton();
        btnAgregarEmpleadoA = new javax.swing.JButton();
        lblDireccionEmpleadoA = new javax.swing.JLabel();
        txtDireccionEmpleadoA = new javax.swing.JTextField();
        lblClaveEmpleadoA = new javax.swing.JLabel();
        txtClaveEmpleadoA = new javax.swing.JTextField();
        lblCorreoEmpleadoA = new javax.swing.JLabel();
        txtCorreoEmpleadoA = new javax.swing.JTextField();
        jpTablaEmpleadoA = new javax.swing.JPanel();
        jspTablaEmpleadoA = new javax.swing.JScrollPane();
        jtTablaEmpleadoA = new javax.swing.JTable();
        jpUsuarioAdmin = new javax.swing.JPanel();
        jpFormularioUsuarioA = new javax.swing.JPanel();
        lblTituloUsuarioA = new javax.swing.JLabel();
        jpTablaEmpleadoA1 = new javax.swing.JPanel();
        jspTablaUsuarioA = new javax.swing.JScrollPane();
        jtTablaUsuarioA = new javax.swing.JTable();
        tabLibroAdmin = new javax.swing.JTabbedPane();
        jpLibroAdmin = new javax.swing.JPanel();
        jpFormularioLibroA = new javax.swing.JPanel();
        lblTituloLibrosA = new javax.swing.JLabel();
        lblIsbnLibroA = new javax.swing.JLabel();
        txtIsbnLibroA = new javax.swing.JTextField();
        btnAgregarLibroA = new javax.swing.JButton();
        lblEditorialLibroA = new javax.swing.JLabel();
        txtEditorialLibroA = new javax.swing.JTextField();
        lblNumPaginasLibroA = new javax.swing.JLabel();
        txtNumPaginasLibroA = new javax.swing.JTextField();
        lblIdiomaLibroA = new javax.swing.JLabel();
        txtIdiomaLibroA = new javax.swing.JTextField();
        lblAnoPublicLibroA = new javax.swing.JLabel();
        jyAnoPublicLibroA = new com.toedter.calendar.JYearChooser();
        btnModificarLibroA = new javax.swing.JButton();
        btnEliminarLibroA = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jpTablaAutorLibroA = new javax.swing.JPanel();
        jspTablaAutorLibroA = new javax.swing.JScrollPane();
        jtTablaAutorLibroA = new javax.swing.JTable();
        txtAutorLibroA = new javax.swing.JTextField();
        lblAutorLibroA = new javax.swing.JLabel();
        btnAgregarAutorLibroA = new javax.swing.JButton();
        btnEliminarAutorLibroA = new javax.swing.JButton();
        lblTituloLibroA = new javax.swing.JLabel();
        txtTituloLibroA = new javax.swing.JTextField();
        jpTablaLibroA = new javax.swing.JPanel();
        jpsTablaLibroA = new javax.swing.JScrollPane();
        jtTablaLibroA = new javax.swing.JTable();
        jpEjemplarAdmin = new javax.swing.JPanel();
        jpFormularioEjemplarA = new javax.swing.JPanel();
        lblTituloEjemplarA = new javax.swing.JLabel();
        lblIsbnEjemplarA = new javax.swing.JLabel();
        txtIsbnEjemplarA = new javax.swing.JTextField();
        btnAgregarEjemplarA = new javax.swing.JButton();
        lblEstanteEjemplarA = new javax.swing.JLabel();
        txtEstanteEjemplarA = new javax.swing.JTextField();
        lblNomSalaEjemplarA = new javax.swing.JLabel();
        txtNomSalaEjemplarA = new javax.swing.JTextField();
        lblNumCajonEjemplarA = new javax.swing.JLabel();
        txtNumCajonEjemplarA = new javax.swing.JTextField();
        lblNumPasilloEjemplarA = new javax.swing.JLabel();
        btnModificarEjemplarA = new javax.swing.JButton();
        btnEliminarEjemplarA = new javax.swing.JButton();
        txtNumPasilloEjemplarA = new javax.swing.JTextField();
        txtNumEjemplarA = new javax.swing.JTextField();
        jpTablaEjemplarA = new javax.swing.JPanel();
        jpsTablaEjemplarA = new javax.swing.JScrollPane();
        jtTablaEjemplarA = new javax.swing.JTable();
        jpDigitalAdmin = new javax.swing.JPanel();
        jpFormularioDigitalA = new javax.swing.JPanel();
        lblTituloDigitalA = new javax.swing.JLabel();
        lblIsbnDigitalA = new javax.swing.JLabel();
        txtIsbnDigitalA = new javax.swing.JTextField();
        btnAgregarDigitalA = new javax.swing.JButton();
        lblUrlDigitalA = new javax.swing.JLabel();
        txtUrlDigitalA = new javax.swing.JTextField();
        lblBytesDigitalA = new javax.swing.JLabel();
        txtBytesDigitalA = new javax.swing.JTextField();
        lblFormatoDigitalA = new javax.swing.JLabel();
        txtFormatoDigitalA = new javax.swing.JTextField();
        btnModificarDigitalA = new javax.swing.JButton();
        btnEliminarDigitalA = new javax.swing.JButton();
        txtNumDigitalA = new javax.swing.JTextField();
        jpTablaDigitalA = new javax.swing.JPanel();
        jpsTablaDigitalA = new javax.swing.JScrollPane();
        jtTablaDigitalA = new javax.swing.JTable();

        jpContenido.setBackground(new java.awt.Color(249, 250, 252));
        jpContenido.setLayout(new java.awt.CardLayout());
        jpAreaAdmin.setOpaque(false);
        jpAreaAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioAreaA.setOpaque(false);
        jpFormularioAreaA.setLayout(new java.awt.GridBagLayout());

        lblNombreAreaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombreAreaA.setText("NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioAreaA.add(lblNombreAreaA, gridBagConstraints);

        txtNombreAreaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 0);
        jpFormularioAreaA.add(txtNombreAreaA, gridBagConstraints);

        lblDescripcionAreaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDescripcionAreaA.setText("DESCRIPCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioAreaA.add(lblDescripcionAreaA, gridBagConstraints);

        txaDescripcionAreaA.setColumns(20);
        txaDescripcionAreaA.setRows(5);
        jspDescripcionAreaA.setViewportView(txaDescripcionAreaA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioAreaA.add(jspDescripcionAreaA, gridBagConstraints);

        lblTituloAreaA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloAreaA.setText("AREAS DE CONOCIMIENTO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioAreaA.add(lblTituloAreaA, gridBagConstraints);

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jpFormularioAreaA.add(jSeparator1, gridBagConstraints);

        lblCodigoArea1A.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCodigoArea1A.setText("CODIGO 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioAreaA.add(lblCodigoArea1A, gridBagConstraints);

        txtCodigoArea1A.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioAreaA.add(txtCodigoArea1A, gridBagConstraints);

        lblCodigoArea2A.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCodigoArea2A.setText("CODIGO 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioAreaA.add(lblCodigoArea2A, gridBagConstraints);

        txtCodigoArea2A.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioAreaA.add(txtCodigoArea2A, gridBagConstraints);

        btnAgregarAreaA.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregarAreaA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarAreaA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAreaA.setText("AGREGAR");
        btnAgregarAreaA.setBorderPainted(false);
        btnAgregarAreaA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioAreaA.add(btnAgregarAreaA, gridBagConstraints);

        btnModificarAreaA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarAreaA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarAreaA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarAreaA.setText("MODIFICAR");
        btnModificarAreaA.setBorderPainted(false);
        btnModificarAreaA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioAreaA.add(btnModificarAreaA, gridBagConstraints);

        btnEliminarAreaA.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminarAreaA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarAreaA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAreaA.setText("ELIMINAR");
        btnEliminarAreaA.setBorderPainted(false);
        btnEliminarAreaA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 20);
        jpFormularioAreaA.add(btnEliminarAreaA, gridBagConstraints);

        btnRelacionarAreaA.setBackground(new java.awt.Color(255, 0, 0));
        btnRelacionarAreaA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnRelacionarAreaA.setForeground(new java.awt.Color(255, 255, 255));
        btnRelacionarAreaA.setText("RELACIONAR");
        btnRelacionarAreaA.setBorderPainted(false);
        btnRelacionarAreaA.setFocusPainted(false);
        btnRelacionarAreaA.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioAreaA.add(btnRelacionarAreaA, gridBagConstraints);

        txtIdAreaA.setVisible(false);
        txtIdAreaA.setEditable(false);
        txtIdAreaA.setText("0");
        txtIdAreaA.setEnabled(false);
        txtIdAreaA.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jpFormularioAreaA.add(txtIdAreaA, gridBagConstraints);

        jpAreaAdmin.add(jpFormularioAreaA, java.awt.BorderLayout.PAGE_START);

        jpTablaAreaA.setOpaque(false);
        jpTablaAreaA.setLayout(new java.awt.GridBagLayout());

        jtTablaAreaA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaAreaA.setDefaultEditor(Object.class, null);
        jtTablaAreaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaAreaA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# AREA", "NOMBRE", "DESCRIPCION", "AREAS HIJAS"
                }
        ));
        jtTablaAreaA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaAreaA.getTableHeader().setResizingAllowed(false);
        jtTablaAreaA.getTableHeader().setReorderingAllowed(false);
        //jtTablaAreaA.getColumnModel().getColumn(3).setCellRenderer(new JTableCeldaPersonalizada());
        jpsTablaAreaA.setViewportView(jtTablaAreaA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaAreaA.add(jpsTablaAreaA, gridBagConstraints);

        jpAreaAdmin.add(jpTablaAreaA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpAreaAdmin, "jpAreaAdmin");

        jpEditorialAdmin.setOpaque(false);
        jpEditorialAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioEditorialA.setOpaque(false);
        jpFormularioEditorialA.setLayout(new java.awt.GridBagLayout());

        lblTituloEditorialA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloEditorialA.setText("EDITORIAL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioEditorialA.add(lblTituloEditorialA, gridBagConstraints);

        lblNombreEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombreEditorialA.setText("NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jpFormularioEditorialA.add(lblNombreEditorialA, gridBagConstraints);

        txtNombreEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 20, 0);
        jpFormularioEditorialA.add(txtNombreEditorialA, gridBagConstraints);

        lblPaisEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblPaisEditorialA.setText("PAIS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jpFormularioEditorialA.add(lblPaisEditorialA, gridBagConstraints);

        txtPaisEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 20, 0);
        jpFormularioEditorialA.add(txtPaisEditorialA, gridBagConstraints);

        lblPaginaWebEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblPaginaWebEditorialA.setText("PAGINA WEB");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jpFormularioEditorialA.add(lblPaginaWebEditorialA, gridBagConstraints);

        txtPaginaWebEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 20, 0);
        jpFormularioEditorialA.add(txtPaginaWebEditorialA, gridBagConstraints);

        btnAgregarEditorialA.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregarEditorialA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarEditorialA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEditorialA.setText("AGREGAR");
        btnAgregarEditorialA.setBorderPainted(false);
        btnAgregarEditorialA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 20);
        jpFormularioEditorialA.add(btnAgregarEditorialA, gridBagConstraints);

        btnModificarEditorialA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarEditorialA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarEditorialA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarEditorialA.setText("MODIFICAR");
        btnModificarEditorialA.setBorderPainted(false);
        btnModificarEditorialA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioEditorialA.add(btnModificarEditorialA, gridBagConstraints);

        btnEliminarEditorialA.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminarEditorialA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarEditorialA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEditorialA.setText("ELIMINAR");
        btnEliminarEditorialA.setBorderPainted(false);
        btnEliminarEditorialA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 20);
        jpFormularioEditorialA.add(btnEliminarEditorialA, gridBagConstraints);

        txtIdEditorialA.setVisible(false);
        txtIdEditorialA.setEditable(false);
        txtIdEditorialA.setText("0");
        txtIdEditorialA.setEnabled(false);
        txtIdEditorialA.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jpFormularioEditorialA.add(txtIdEditorialA, gridBagConstraints);

        jpEditorialAdmin.add(jpFormularioEditorialA, java.awt.BorderLayout.PAGE_START);

        jpTablaEditorialA.setOpaque(false);
        jpTablaEditorialA.setLayout(new java.awt.GridBagLayout());

        jtTablaEditorialA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaEditorialA.setDefaultEditor(Object.class, null);
        jtTablaEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaEditorialA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# EDITORIAL", "NOMBRE", "PAIS", "PAGINA WEB"
                }
        ));
        jtTablaEditorialA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaEditorialA.getTableHeader().setResizingAllowed(false);
        jtTablaEditorialA.getTableHeader().setReorderingAllowed(false);
        jspTablaEditorialA.setViewportView(jtTablaEditorialA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaEditorialA.add(jspTablaEditorialA, gridBagConstraints);

        jpEditorialAdmin.add(jpTablaEditorialA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpEditorialAdmin, "jpEditorialAdmin");

        jpAutorAdmin.setOpaque(false);
        jpAutorAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioAutorA.setOpaque(false);
        jpFormularioAutorA.setLayout(new java.awt.GridBagLayout());

        lblTituloAutorA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloAutorA.setText("AUTORES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioAutorA.add(lblTituloAutorA, gridBagConstraints);

        lblNombre1AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombre1AutorA.setText("1° NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioAutorA.add(lblNombre1AutorA, gridBagConstraints);

        txtNombre1AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioAutorA.add(txtNombre1AutorA, gridBagConstraints);

        lblNombre2Autor2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombre2Autor2.setText("2° NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioAutorA.add(lblNombre2Autor2, gridBagConstraints);

        txtNombre2AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioAutorA.add(txtNombre2AutorA, gridBagConstraints);

        lblApellido1AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblApellido1AutorA.setText("1° APELLIDO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioAutorA.add(lblApellido1AutorA, gridBagConstraints);

        txtApellido1AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioAutorA.add(txtApellido1AutorA, gridBagConstraints);

        lblApellido2AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblApellido2AutorA.setText("2° APELLIDO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioAutorA.add(lblApellido2AutorA, gridBagConstraints);

        txtApellido2AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioAutorA.add(txtApellido2AutorA, gridBagConstraints);

        btnEliminarAutorA.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminarAutorA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarAutorA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAutorA.setText("ELIMINAR");
        btnEliminarAutorA.setBorderPainted(false);
        btnEliminarAutorA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 20);
        jpFormularioAutorA.add(btnEliminarAutorA, gridBagConstraints);

        btnModificarAutorA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarAutorA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarAutorA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarAutorA.setText("MODIFICAR");
        btnModificarAutorA.setBorderPainted(false);
        btnModificarAutorA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioAutorA.add(btnModificarAutorA, gridBagConstraints);

        btnAgregarAutorA.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregarAutorA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarAutorA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAutorA.setText("AGREGAR");
        btnAgregarAutorA.setBorderPainted(false);
        btnAgregarAutorA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioAutorA.add(btnAgregarAutorA, gridBagConstraints);

        txtIdAutorA.setVisible(false);
        txtIdAutorA.setEditable(false);
        txtIdAutorA.setText("0");
        txtIdAutorA.setEnabled(false);
        txtIdAutorA.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jpFormularioAutorA.add(txtIdAutorA, gridBagConstraints);

        jpAutorAdmin.add(jpFormularioAutorA, java.awt.BorderLayout.PAGE_START);

        jpTablaAutorA.setOpaque(false);
        jpTablaAutorA.setLayout(new java.awt.GridBagLayout());

        jtTablaAutorA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaAutorA.setDefaultEditor(Object.class, null);
        jtTablaAutorA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# AUTOR", "1° NOMBRE", "2° NOMBRE", "1° APELLIDO", "2° APELLIDO"
                }
        ));
        jtTablaAutorA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaAutorA.getTableHeader().setResizingAllowed(false);
        jtTablaAutorA.getTableHeader().setReorderingAllowed(false);
        jspTablaAutorA.setViewportView(jtTablaAutorA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaAutorA.add(jspTablaAutorA, gridBagConstraints);

        jpAutorAdmin.add(jpTablaAutorA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpAutorAdmin, "jpAutorAdmin");

        jpPrestamoAdmin.setOpaque(false);
        jpPrestamoAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioPrestamoA.setOpaque(false);
        jpFormularioPrestamoA.setLayout(new java.awt.GridBagLayout());

        lblTituloPrestamoA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloPrestamoA.setText("PRESTAMOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioPrestamoA.add(lblTituloPrestamoA, gridBagConstraints);

        jpPrestamoAdmin.add(jpFormularioPrestamoA, java.awt.BorderLayout.PAGE_START);

        jpTablaPrestamoA.setOpaque(false);
        jpTablaPrestamoA.setLayout(new java.awt.GridBagLayout());

        jtTablaPrestamoA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaPrestamoA.setDefaultEditor(Object.class, null);
        jtTablaPrestamoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaPrestamoA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# PRESTAMO", "ISBN", "# EJEMPLAR", "TITULO", "# USUARIO", "# EMPLEADO", "FECHA REALIZACION", "FECHA DEVOLUCION", "ESTADO"
                }
        ));
        jtTablaPrestamoA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaPrestamoA.getTableHeader().setResizingAllowed(false);
        jtTablaPrestamoA.getTableHeader().setReorderingAllowed(false);
        jspTablaPrestamoA.setViewportView(jtTablaPrestamoA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaPrestamoA.add(jspTablaPrestamoA, gridBagConstraints);

        jpPrestamoAdmin.add(jpTablaPrestamoA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpPrestamoAdmin, "jpPrestamoAdmin");

        jpDescargaAdmin.setOpaque(false);
        jpDescargaAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioDescargaA.setOpaque(false);
        jpFormularioDescargaA.setLayout(new java.awt.GridBagLayout());

        lblTituloDescargaA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloDescargaA.setText("DESCARGAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioDescargaA.add(lblTituloDescargaA, gridBagConstraints);

        jpDescargaAdmin.add(jpFormularioDescargaA, java.awt.BorderLayout.PAGE_START);

        jpTablaDescargaA.setOpaque(false);
        jpTablaDescargaA.setLayout(new java.awt.GridBagLayout());

        jtTablaDescargaA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaDescargaA.setDefaultEditor(Object.class, null);
        jtTablaDescargaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaDescargaA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "ISBN", "TITULO", "# USUARIO", "IP", "FECHA DESCARGA", "HORA DESCARGA"
                }
        ));
        jtTablaDescargaA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaDescargaA.getTableHeader().setResizingAllowed(false);
        jtTablaDescargaA.getTableHeader().setReorderingAllowed(false);
        jspTablaDescargaA.setViewportView(jtTablaDescargaA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaDescargaA.add(jspTablaDescargaA, gridBagConstraints);

        jpDescargaAdmin.add(jpTablaDescargaA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpDescargaAdmin, "jpDescargaAdmin");

        jpMultaAdmin.setOpaque(false);
        jpMultaAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioMultaA.setOpaque(false);
        jpFormularioMultaA.setLayout(new java.awt.GridBagLayout());

        lblTituloMultaA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloMultaA.setText("MULTAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioMultaA.add(lblTituloMultaA, gridBagConstraints);

        jpMultaAdmin.add(jpFormularioMultaA, java.awt.BorderLayout.PAGE_START);

        jpTablaMultaA.setOpaque(false);
        jpTablaMultaA.setLayout(new java.awt.GridBagLayout());

        jtTablaMultaA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaMultaA.setDefaultEditor(Object.class, null);
        jtTablaMultaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaMultaA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# EJEMPLAR", "ISBN", "TITULO", "# USUARIO", "VALOR", "DESCRIPCION", "FECHA MULTA"
                }
        ));
        jtTablaMultaA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaMultaA.getTableHeader().setResizingAllowed(false);
        jtTablaMultaA.getTableHeader().setReorderingAllowed(false);
        jspTablaMultaA.setViewportView(jtTablaMultaA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaMultaA.add(jspTablaMultaA, gridBagConstraints);

        jpMultaAdmin.add(jpTablaMultaA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpMultaAdmin, "jpMultaAdmin");

        jpSolicitudAdmin.setOpaque(false);
        jpSolicitudAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioSolicitudA.setOpaque(false);
        jpFormularioSolicitudA.setLayout(new java.awt.GridBagLayout());

        lblTituloSolicitudA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloSolicitudA.setText("SOLICITUDES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioSolicitudA.add(lblTituloSolicitudA, gridBagConstraints);

        jpSolicitudAdmin.add(jpFormularioSolicitudA, java.awt.BorderLayout.PAGE_START);

        jpTablaSolicitudA.setOpaque(false);
        jpTablaSolicitudA.setLayout(new java.awt.GridBagLayout());

        jtTablaSolicitudA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaSolicitudA.setDefaultEditor(Object.class, null);
        jtTablaSolicitudA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaSolicitudA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# SOLICITUD", "ISBN", "TITULO", "DESCRIPCION"
                }
        ));
        jtTablaSolicitudA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaSolicitudA.getTableHeader().setResizingAllowed(false);
        jtTablaSolicitudA.getTableHeader().setReorderingAllowed(false);
        jspTablaSolicitudA.setViewportView(jtTablaSolicitudA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaSolicitudA.add(jspTablaSolicitudA, gridBagConstraints);

        jpSolicitudAdmin.add(jpTablaSolicitudA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpSolicitudAdmin, "jpSolicitudAdmin");

        jpEmpleadoAdmin.setOpaque(false);
        jpEmpleadoAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioEmpleadoA.setOpaque(false);
        jpFormularioEmpleadoA.setLayout(new java.awt.GridBagLayout());

        lblTituloEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloEmpleadoA.setText("EMPLEADOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioEmpleadoA.add(lblTituloEmpleadoA, gridBagConstraints);

        lblCedulaEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaEmpleadoA.setText("CEDULA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblCedulaEmpleadoA, gridBagConstraints);

        txtCedulaEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtCedulaEmpleadoA, gridBagConstraints);

        lblTelefonoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTelefonoEmpleadoA.setText("TELEFONO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblTelefonoEmpleadoA, gridBagConstraints);

        txtTelefonoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtTelefonoEmpleadoA, gridBagConstraints);

        lblNombreEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombreEmpleadoA.setText("NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblNombreEmpleadoA, gridBagConstraints);

        txtNombreEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtNombreEmpleadoA, gridBagConstraints);

        lblCargoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCargoEmpleadoA.setText("CARGO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 140, 0, 0);
        jpFormularioEmpleadoA.add(lblCargoEmpleadoA, gridBagConstraints);

        txtCargoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioEmpleadoA.add(txtCargoEmpleadoA, gridBagConstraints);

        btnEliminarEmpleadoA.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminarEmpleadoA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarEmpleadoA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEmpleadoA.setText("ELIMINAR");
        btnEliminarEmpleadoA.setBorderPainted(false);
        btnEliminarEmpleadoA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 20);
        jpFormularioEmpleadoA.add(btnEliminarEmpleadoA, gridBagConstraints);

        btnModificarEmpleadoA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarEmpleadoA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarEmpleadoA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarEmpleadoA.setText("MODIFICAR");
        btnModificarEmpleadoA.setBorderPainted(false);
        btnModificarEmpleadoA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioEmpleadoA.add(btnModificarEmpleadoA, gridBagConstraints);

        btnAgregarEmpleadoA.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregarEmpleadoA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarEmpleadoA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEmpleadoA.setText("AGREGAR");
        btnAgregarEmpleadoA.setBorderPainted(false);
        btnAgregarEmpleadoA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioEmpleadoA.add(btnAgregarEmpleadoA, gridBagConstraints);

        lblDireccionEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDireccionEmpleadoA.setText("DIRECCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblDireccionEmpleadoA, gridBagConstraints);

        txtDireccionEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtDireccionEmpleadoA, gridBagConstraints);

        lblClaveEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblClaveEmpleadoA.setText("CLAVE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblClaveEmpleadoA, gridBagConstraints);

        txtClaveEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtClaveEmpleadoA, gridBagConstraints);

        lblCorreoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCorreoEmpleadoA.setText("CORREO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblCorreoEmpleadoA, gridBagConstraints);

        txtCorreoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtCorreoEmpleadoA, gridBagConstraints);

        jpEmpleadoAdmin.add(jpFormularioEmpleadoA, java.awt.BorderLayout.PAGE_START);

        jpTablaEmpleadoA.setOpaque(false);
        jpTablaEmpleadoA.setLayout(new java.awt.GridBagLayout());

        jtTablaEmpleadoA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaEmpleadoA.setDefaultEditor(Object.class, null);
        jtTablaEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaEmpleadoA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "CEDULA", "NOMBRE", "EMAIL", "CLAVE", "DIRECCION", "TELEFONO", "CARGO"
                }
        ));
        jtTablaEmpleadoA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaEmpleadoA.getTableHeader().setResizingAllowed(false);
        jtTablaEmpleadoA.getTableHeader().setReorderingAllowed(false);
        jspTablaEmpleadoA.setViewportView(jtTablaEmpleadoA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaEmpleadoA.add(jspTablaEmpleadoA, gridBagConstraints);

        jpEmpleadoAdmin.add(jpTablaEmpleadoA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpEmpleadoAdmin, "jpEmpleadoAdmin");

        jpUsuarioAdmin.setOpaque(false);
        jpUsuarioAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioUsuarioA.setOpaque(false);
        jpFormularioUsuarioA.setLayout(new java.awt.GridBagLayout());

        lblTituloUsuarioA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloUsuarioA.setText("USUARIOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioUsuarioA.add(lblTituloUsuarioA, gridBagConstraints);

        jpUsuarioAdmin.add(jpFormularioUsuarioA, java.awt.BorderLayout.PAGE_START);

        jpTablaEmpleadoA1.setOpaque(false);
        jpTablaEmpleadoA1.setLayout(new java.awt.GridBagLayout());

        jtTablaUsuarioA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaUsuarioA.setDefaultEditor(Object.class, null);
        jtTablaUsuarioA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaUsuarioA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "CEDULA", "NOMBRE", "EMAIL", "DIRECCION", "TELEFONO"
                }
        ));
        jtTablaUsuarioA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaUsuarioA.getTableHeader().setResizingAllowed(false);
        jtTablaUsuarioA.getTableHeader().setReorderingAllowed(false);
        jspTablaUsuarioA.setViewportView(jtTablaUsuarioA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaEmpleadoA1.add(jspTablaUsuarioA, gridBagConstraints);

        jpUsuarioAdmin.add(jpTablaEmpleadoA1, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpUsuarioAdmin, "jpUsuarioAdmin");

        tabLibroAdmin.setBackground(new java.awt.Color(249, 250, 252));
        tabLibroAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabLibroAdmin.setFocusable(false);
        tabLibroAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tabLibroAdmin.setOpaque(true);

        jpLibroAdmin.setBackground(new java.awt.Color(249, 250, 252));
        jpLibroAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioLibroA.setOpaque(false);
        jpFormularioLibroA.setLayout(new java.awt.GridBagLayout());

        lblTituloLibrosA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloLibrosA.setText("LIBROS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioLibroA.add(lblTituloLibrosA, gridBagConstraints);

        lblIsbnLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnLibroA.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioLibroA.add(lblIsbnLibroA, gridBagConstraints);

        txtIsbnLibroA.setColumns(5);
        txtIsbnLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioLibroA.add(txtIsbnLibroA, gridBagConstraints);

        btnAgregarLibroA.setBackground(new java.awt.Color(255, 0, 51));
        btnAgregarLibroA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarLibroA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarLibroA.setText("AGREGAR");
        btnAgregarLibroA.setBorderPainted(false);
        btnAgregarLibroA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jpFormularioLibroA.add(btnAgregarLibroA, gridBagConstraints);

        lblEditorialLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblEditorialLibroA.setText("EDITORIAL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioLibroA.add(lblEditorialLibroA, gridBagConstraints);

        txtEditorialLibroA.setColumns(5);
        txtEditorialLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioLibroA.add(txtEditorialLibroA, gridBagConstraints);

        lblNumPaginasLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumPaginasLibroA.setText("# PAGINAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioLibroA.add(lblNumPaginasLibroA, gridBagConstraints);

        txtNumPaginasLibroA.setColumns(5);
        txtNumPaginasLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioLibroA.add(txtNumPaginasLibroA, gridBagConstraints);

        lblIdiomaLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIdiomaLibroA.setText("IDIOMA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioLibroA.add(lblIdiomaLibroA, gridBagConstraints);

        txtIdiomaLibroA.setColumns(5);
        txtIdiomaLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioLibroA.add(txtIdiomaLibroA, gridBagConstraints);

        lblAnoPublicLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblAnoPublicLibroA.setText("AÑO PUBLICACION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioLibroA.add(lblAnoPublicLibroA, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioLibroA.add(jyAnoPublicLibroA, gridBagConstraints);

        btnModificarLibroA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarLibroA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarLibroA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarLibroA.setText("MODIFICAR");
        btnModificarLibroA.setBorderPainted(false);
        btnModificarLibroA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        jpFormularioLibroA.add(btnModificarLibroA, gridBagConstraints);

        btnEliminarLibroA.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminarLibroA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarLibroA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarLibroA.setText("ELIMINAR");
        btnEliminarLibroA.setBorderPainted(false);
        btnEliminarLibroA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        jpFormularioLibroA.add(btnEliminarLibroA, gridBagConstraints);

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioLibroA.add(jSeparator2, gridBagConstraints);

        jpTablaAutorLibroA.setLayout(new java.awt.GridBagLayout());

        jspTablaAutorLibroA.setPreferredSize(new java.awt.Dimension(200, 160));

        jtTablaAutorLibroA.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaAutorLibroA.setDefaultEditor(Object.class, null);
        jtTablaAutorA.setFont(new java.awt.Font("Montserrat", 0, 12));
        jtTablaAutorLibroA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "# AUTOR", "NOMBRE"
                }
        ));
        jtTablaAutorLibroA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaAutorLibroA.getTableHeader().setResizingAllowed(false);
        jtTablaAutorLibroA.getTableHeader().setReorderingAllowed(false);
        jspTablaAutorLibroA.setViewportView(jtTablaAutorLibroA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jpTablaAutorLibroA.add(jspTablaAutorLibroA, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpFormularioLibroA.add(jpTablaAutorLibroA, gridBagConstraints);

        txtAutorLibroA.setColumns(5);
        txtAutorLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtAutorLibroA.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioLibroA.add(txtAutorLibroA, gridBagConstraints);

        lblAutorLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblAutorLibroA.setText("AUTOR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioLibroA.add(lblAutorLibroA, gridBagConstraints);

        btnAgregarAutorLibroA.setBackground(new java.awt.Color(255, 0, 51));
        btnAgregarAutorLibroA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarAutorLibroA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAutorLibroA.setText("AGREGAR");
        btnAgregarAutorLibroA.setBorderPainted(false);
        btnAgregarAutorLibroA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioLibroA.add(btnAgregarAutorLibroA, gridBagConstraints);

        btnEliminarAutorLibroA.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminarAutorLibroA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarAutorLibroA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAutorLibroA.setText("ELIMINAR");
        btnEliminarAutorLibroA.setBorderPainted(false);
        btnEliminarAutorLibroA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jpFormularioLibroA.add(btnEliminarAutorLibroA, gridBagConstraints);

        lblTituloLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTituloLibroA.setText("TITULO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioLibroA.add(lblTituloLibroA, gridBagConstraints);

        txtTituloLibroA.setColumns(5);
        txtTituloLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioLibroA.add(txtTituloLibroA, gridBagConstraints);

        jpLibroAdmin.add(jpFormularioLibroA, java.awt.BorderLayout.PAGE_START);

        jpTablaLibroA.setOpaque(false);
        jpTablaLibroA.setLayout(new java.awt.GridBagLayout());

        jtTablaLibroA.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaLibroA.setDefaultEditor(Object.class, null);
        jtTablaLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaLibroA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "ISBN", "TITULO", "AUTOR", "EDITORIAL", "PUBLICACION", "IDIOMA", "# PAGINAS", "EJEMPLARES", "DIGITAL"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaLibroA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaLibroA.getTableHeader().setResizingAllowed(false);
        jtTablaLibroA.getTableHeader().setReorderingAllowed(false);
        jtTablaLibroA.getColumnModel().getColumn(2).setCellRenderer(new JTableCeldaPersonalizada());
        jpsTablaLibroA.setViewportView(jtTablaLibroA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaLibroA.add(jpsTablaLibroA, gridBagConstraints);

        jpLibroAdmin.add(jpTablaLibroA, java.awt.BorderLayout.CENTER);

        tabLibroAdmin.addTab("LIBROS", jpLibroAdmin);

        jpEjemplarAdmin.setBackground(new java.awt.Color(249, 250, 252));
        jpEjemplarAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioEjemplarA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpFormularioEjemplarA.setOpaque(false);
        jpFormularioEjemplarA.setLayout(new java.awt.GridBagLayout());

        lblTituloEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloEjemplarA.setText("EJEMPLARES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioEjemplarA.add(lblTituloEjemplarA, gridBagConstraints);

        lblIsbnEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnEjemplarA.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioEjemplarA.add(lblIsbnEjemplarA, gridBagConstraints);

        txtIsbnEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioEjemplarA.add(txtIsbnEjemplarA, gridBagConstraints);

        btnAgregarEjemplarA.setBackground(new java.awt.Color(255, 0, 51));
        btnAgregarEjemplarA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarEjemplarA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEjemplarA.setText("AGREGAR");
        btnAgregarEjemplarA.setBorderPainted(false);
        btnAgregarEjemplarA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jpFormularioEjemplarA.add(btnAgregarEjemplarA, gridBagConstraints);

        lblEstanteEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblEstanteEjemplarA.setText("ESTANTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioEjemplarA.add(lblEstanteEjemplarA, gridBagConstraints);

        txtEstanteEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioEjemplarA.add(txtEstanteEjemplarA, gridBagConstraints);

        lblNomSalaEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNomSalaEjemplarA.setText("NOMBRE SALA");
        lblNomSalaEjemplarA.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioEjemplarA.add(lblNomSalaEjemplarA, gridBagConstraints);

        txtNomSalaEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioEjemplarA.add(txtNomSalaEjemplarA, gridBagConstraints);

        lblNumCajonEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumCajonEjemplarA.setText("# CAJON");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioEjemplarA.add(lblNumCajonEjemplarA, gridBagConstraints);

        txtNumCajonEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioEjemplarA.add(txtNumCajonEjemplarA, gridBagConstraints);

        lblNumPasilloEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumPasilloEjemplarA.setText("# PASILLO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpFormularioEjemplarA.add(lblNumPasilloEjemplarA, gridBagConstraints);

        btnModificarEjemplarA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarEjemplarA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarEjemplarA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarEjemplarA.setText("MODIFICAR");
        btnModificarEjemplarA.setBorderPainted(false);
        btnModificarEjemplarA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        jpFormularioEjemplarA.add(btnModificarEjemplarA, gridBagConstraints);

        btnEliminarEjemplarA.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminarEjemplarA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarEjemplarA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEjemplarA.setText("ELIMINAR");
        btnEliminarEjemplarA.setBorderPainted(false);
        btnEliminarEjemplarA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        jpFormularioEjemplarA.add(btnEliminarEjemplarA, gridBagConstraints);

        txtNumPasilloEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jpFormularioEjemplarA.add(txtNumPasilloEjemplarA, gridBagConstraints);

        txtNumEjemplarA.setVisible(false);
        txtNumEjemplarA.setEditable(false);
        txtNumEjemplarA.setText("0");
        txtNumEjemplarA.setEnabled(false);
        txtNumEjemplarA.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jpFormularioEjemplarA.add(txtNumEjemplarA, gridBagConstraints);

        jpEjemplarAdmin.add(jpFormularioEjemplarA, java.awt.BorderLayout.PAGE_START);

        jpTablaEjemplarA.setOpaque(false);
        jpTablaEjemplarA.setLayout(new java.awt.GridBagLayout());

        jtTablaEjemplarA.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaEjemplarA.setDefaultEditor(Object.class, null);
        jtTablaEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaEjemplarA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# EJEMPLAR", "ISBN", "ESTANTE", "# CAJON", "NOMBRE SALA", "# PASILLO", "ESTADO"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaEjemplarA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaEjemplarA.getTableHeader().setResizingAllowed(false);
        jtTablaEjemplarA.getTableHeader().setReorderingAllowed(false);
        jpsTablaEjemplarA.setViewportView(jtTablaEjemplarA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaEjemplarA.add(jpsTablaEjemplarA, gridBagConstraints);

        jpEjemplarAdmin.add(jpTablaEjemplarA, java.awt.BorderLayout.CENTER);

        tabLibroAdmin.addTab("EJEMPLARES", jpEjemplarAdmin);

        jpDigitalAdmin.setBackground(new java.awt.Color(249, 250, 252));
        jpDigitalAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioDigitalA.setOpaque(false);
        jpFormularioDigitalA.setLayout(new java.awt.GridBagLayout());

        lblTituloDigitalA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloDigitalA.setText("DIGITALES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioDigitalA.add(lblTituloDigitalA, gridBagConstraints);

        lblIsbnDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnDigitalA.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioDigitalA.add(lblIsbnDigitalA, gridBagConstraints);

        txtIsbnDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioDigitalA.add(txtIsbnDigitalA, gridBagConstraints);

        btnAgregarDigitalA.setBackground(new java.awt.Color(255, 0, 51));
        btnAgregarDigitalA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarDigitalA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarDigitalA.setText("AGREGAR");
        btnAgregarDigitalA.setBorderPainted(false);
        btnAgregarDigitalA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jpFormularioDigitalA.add(btnAgregarDigitalA, gridBagConstraints);

        lblUrlDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblUrlDigitalA.setText("URL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioDigitalA.add(lblUrlDigitalA, gridBagConstraints);

        txtUrlDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioDigitalA.add(txtUrlDigitalA, gridBagConstraints);

        lblBytesDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblBytesDigitalA.setText("BYTES");
        lblBytesDigitalA.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioDigitalA.add(lblBytesDigitalA, gridBagConstraints);

        txtBytesDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioDigitalA.add(txtBytesDigitalA, gridBagConstraints);

        lblFormatoDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblFormatoDigitalA.setText("FORMATO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioDigitalA.add(lblFormatoDigitalA, gridBagConstraints);

        txtFormatoDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioDigitalA.add(txtFormatoDigitalA, gridBagConstraints);

        btnModificarDigitalA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarDigitalA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarDigitalA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarDigitalA.setText("MODIFICAR");
        btnModificarDigitalA.setBorderPainted(false);
        btnModificarDigitalA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        jpFormularioDigitalA.add(btnModificarDigitalA, gridBagConstraints);

        btnEliminarDigitalA.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminarDigitalA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarDigitalA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarDigitalA.setText("ELIMINAR");
        btnEliminarDigitalA.setBorderPainted(false);
        btnEliminarDigitalA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        jpFormularioDigitalA.add(btnEliminarDigitalA, gridBagConstraints);

        txtNumDigitalA.setVisible(false);
        txtNumDigitalA.setEditable(false);
        txtNumDigitalA.setText("0");
        txtNumDigitalA.setEnabled(false);
        txtNumDigitalA.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jpFormularioDigitalA.add(txtNumDigitalA, gridBagConstraints);

        jpDigitalAdmin.add(jpFormularioDigitalA, java.awt.BorderLayout.PAGE_START);

        jpTablaDigitalA.setOpaque(false);
        jpTablaDigitalA.setLayout(new java.awt.GridBagLayout());

        jtTablaDigitalA.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaDigitalA.setDefaultEditor(Object.class, null);
        jtTablaDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaDigitalA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# DIGITAL", "ISBN", "URL", "FORMATO", "BYTES"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaDigitalA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaDigitalA.getTableHeader().setResizingAllowed(false);
        jtTablaDigitalA.getTableHeader().setReorderingAllowed(false);
        jpsTablaDigitalA.setViewportView(jtTablaDigitalA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaDigitalA.add(jpsTablaDigitalA, gridBagConstraints);

        jpDigitalAdmin.add(jpTablaDigitalA, java.awt.BorderLayout.CENTER);

        tabLibroAdmin.addTab("DIGITAL", jpDigitalAdmin);

        jpContenido.add(tabLibroAdmin, "jpLibroAdmin");

        getContentPane().add(jpContenido, java.awt.BorderLayout.CENTER);

        pack();
    }

    public void initContE()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jpContenido = new javax.swing.JPanel();
        jpPrestamoEmpleado = new javax.swing.JPanel();
        jpFormularioPrestamoE = new javax.swing.JPanel();
        lblTituloPrestamoE = new javax.swing.JLabel();
        lblIsbnPrestamoE = new javax.swing.JLabel();
        txtIsbnPrestamoE = new javax.swing.JTextField();
        btnAgregarLibroE = new javax.swing.JButton();
        lblNumeroEjemplarPreE = new javax.swing.JLabel();
        txtNumeroEjemplarPreE = new javax.swing.JTextField();
        lblCedulaPrestamoE = new javax.swing.JLabel();
        txtCedulaPrestamoE = new javax.swing.JTextField();
        lblFechaRPrestamoE = new javax.swing.JLabel();
        jdFechaRPrestamoE = new com.toedter.calendar.JDateChooser();
        lblFechaDPrestamoE = new javax.swing.JLabel();
        jdFechaDPrestamoE = new com.toedter.calendar.JDateChooser();
        jpTablaLibroPreE = new javax.swing.JPanel();
        jspTablaLibroPreE = new javax.swing.JScrollPane();
        jtTablaLibroPreE = new javax.swing.JTable();
        btnBorrarPrestamoE = new javax.swing.JButton();
        btnPrestarPrestamoE = new javax.swing.JButton();
        jpTablaPrestamoE = new javax.swing.JPanel();
        jpsTablaPrestamoE = new javax.swing.JScrollPane();
        jtTablaPrestamoE = new javax.swing.JTable();
        jpDevolucionEmpleado = new javax.swing.JPanel();
        jpFormularioDevolucionE = new javax.swing.JPanel();
        lblTituloDevolucionE = new javax.swing.JLabel();
        lblIsbnDevolucionE = new javax.swing.JLabel();
        txtIsbnDevolucionE = new javax.swing.JTextField();
        btnDevolverLibroE = new javax.swing.JButton();
        lblNumeroEjemplarDevE = new javax.swing.JLabel();
        txtNumeroEjemplarDevE = new javax.swing.JTextField();
        lblCedulaUDevolucionE = new javax.swing.JLabel();
        txtCedulaUDevolucionE = new javax.swing.JTextField();
        lblCedulaEDevolucionE = new javax.swing.JLabel();
        lblNumeroPrestamoDevE = new javax.swing.JLabel();
        txtCedulaEDevolucionE = new javax.swing.JTextField();
        txtNumeroPrestamoDevE = new javax.swing.JTextField();
        jpTablaDevolucionE = new javax.swing.JPanel();
        jpsTablaDevolucionE = new javax.swing.JScrollPane();
        jtTablaDevolucionE = new javax.swing.JTable();
        jpSolicitudEmpleado = new javax.swing.JPanel();
        jpFormularioSolicitudE = new javax.swing.JPanel();
        lblTituloSolicitudE = new javax.swing.JLabel();
        jpTablaSolicitudE = new javax.swing.JPanel();
        jspTablaSolicitudE = new javax.swing.JScrollPane();
        jtTablaSolicitudE = new javax.swing.JTable();

        jpContenido.setBackground(new java.awt.Color(249, 250, 252));
        jpContenido.setLayout(new java.awt.CardLayout());
        jpPrestamoEmpleado.setOpaque(false);
        jpPrestamoEmpleado.setLayout(new java.awt.BorderLayout());

        jpFormularioPrestamoE.setOpaque(false);
        jpFormularioPrestamoE.setLayout(new java.awt.GridBagLayout());

        lblTituloPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloPrestamoE.setText("PRESTAMOS");
        lblTituloPrestamoE.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioPrestamoE.add(lblTituloPrestamoE, gridBagConstraints);

        lblIsbnPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnPrestamoE.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 5, 0);
        jpFormularioPrestamoE.add(lblIsbnPrestamoE, gridBagConstraints);

        txtIsbnPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 20, 20);
        jpFormularioPrestamoE.add(txtIsbnPrestamoE, gridBagConstraints);

        btnAgregarLibroE.setBackground(new java.awt.Color(255, 0, 51));
        btnAgregarLibroE.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarLibroE.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarLibroE.setText("AGREGAR");
        btnAgregarLibroE.setBorderPainted(false);
        btnAgregarLibroE.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        jpFormularioPrestamoE.add(btnAgregarLibroE, gridBagConstraints);

        lblNumeroEjemplarPreE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumeroEjemplarPreE.setText("# EJEMPLAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 5, 20);
        jpFormularioPrestamoE.add(lblNumeroEjemplarPreE, gridBagConstraints);

        txtNumeroEjemplarPreE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 20, 20);
        jpFormularioPrestamoE.add(txtNumeroEjemplarPreE, gridBagConstraints);

        lblCedulaPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaPrestamoE.setText("CEDULA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 140, 5, 20);
        jpFormularioPrestamoE.add(lblCedulaPrestamoE, gridBagConstraints);

        txtCedulaPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jpFormularioPrestamoE.add(txtCedulaPrestamoE, gridBagConstraints);

        lblFechaRPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblFechaRPrestamoE.setText("FECHA REALIZACION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioPrestamoE.add(lblFechaRPrestamoE, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioPrestamoE.add(jdFechaRPrestamoE, gridBagConstraints);

        lblFechaDPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblFechaDPrestamoE.setText("FECHA DEVOLUCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioPrestamoE.add(lblFechaDPrestamoE, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioPrestamoE.add(jdFechaDPrestamoE, gridBagConstraints);

        jpTablaLibroPreE.setOpaque(false);
        jpTablaLibroPreE.setLayout(new java.awt.GridBagLayout());

        jspTablaLibroPreE.setOpaque(false);
        jspTablaLibroPreE.setPreferredSize(new java.awt.Dimension(452, 200));

        jtTablaLibroPreE.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaLibroPreE.setDefaultEditor(Object.class, null);
        jtTablaLibroPreE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaLibroPreE.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String [] {
                        "ISBN", "# EJEMPLAR", "FECHA DEVOLUCION"
                }
        ));
        jtTablaLibroPreE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaLibroPreE.getTableHeader().setResizingAllowed(false);
        jtTablaLibroPreE.getTableHeader().setReorderingAllowed(false);
        jspTablaLibroPreE.setViewportView(jtTablaLibroPreE);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jpTablaLibroPreE.add(jspTablaLibroPreE, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpFormularioPrestamoE.add(jpTablaLibroPreE, gridBagConstraints);

        btnBorrarPrestamoE.setBackground(new java.awt.Color(255, 0, 0));
        btnBorrarPrestamoE.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnBorrarPrestamoE.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarPrestamoE.setText("CANCELAR");
        btnBorrarPrestamoE.setBorderPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 60);
        jpFormularioPrestamoE.add(btnBorrarPrestamoE, gridBagConstraints);

        btnPrestarPrestamoE.setBackground(new java.awt.Color(255, 0, 0));
        btnPrestarPrestamoE.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnPrestarPrestamoE.setForeground(new java.awt.Color(255, 255, 255));
        btnPrestarPrestamoE.setText("PRESTAR");
        btnPrestarPrestamoE.setBorderPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 60, 0, 0);
        jpFormularioPrestamoE.add(btnPrestarPrestamoE, gridBagConstraints);

        jpPrestamoEmpleado.add(jpFormularioPrestamoE, java.awt.BorderLayout.PAGE_START);

        jpTablaPrestamoE.setOpaque(false);
        jpTablaPrestamoE.setLayout(new java.awt.GridBagLayout());

        jtTablaPrestamoE.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaPrestamoE.setDefaultEditor(Object.class, null);
        jtTablaPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaPrestamoE.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "ISBN", "# EJEMPLAR", "TITULO", "AUTOR", "EDITORIAL", "PUBLICACION", "IDIOMA", "# PAGINAS"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaPrestamoE.getTableHeader().setResizingAllowed(false);
        jtTablaPrestamoE.getTableHeader().setReorderingAllowed(false);
        jpsTablaPrestamoE.setViewportView(jtTablaPrestamoE);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaPrestamoE.add(jpsTablaPrestamoE, gridBagConstraints);

        jpPrestamoEmpleado.add(jpTablaPrestamoE, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpPrestamoEmpleado, "jpPrestamoEmpleado");

        jpDevolucionEmpleado.setOpaque(false);
        jpDevolucionEmpleado.setLayout(new java.awt.BorderLayout());

        jpFormularioDevolucionE.setOpaque(false);
        jpFormularioDevolucionE.setLayout(new java.awt.GridBagLayout());

        lblTituloDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloDevolucionE.setText("DEVOLUCIONES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioDevolucionE.add(lblTituloDevolucionE, gridBagConstraints);

        lblIsbnDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnDevolucionE.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 220);
        jpFormularioDevolucionE.add(lblIsbnDevolucionE, gridBagConstraints);

        txtIsbnDevolucionE.setColumns(4);
        txtIsbnDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jpFormularioDevolucionE.add(txtIsbnDevolucionE, gridBagConstraints);

        btnDevolverLibroE.setBackground(new java.awt.Color(255, 0, 51));
        btnDevolverLibroE.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnDevolverLibroE.setForeground(new java.awt.Color(255, 255, 255));
        btnDevolverLibroE.setText("DEVOLVER");
        btnDevolverLibroE.setBorderPainted(false);
        btnDevolverLibroE.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        jpFormularioDevolucionE.add(btnDevolverLibroE, gridBagConstraints);

        lblNumeroEjemplarDevE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumeroEjemplarDevE.setText("# EJEMPLAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 20);
        jpFormularioDevolucionE.add(lblNumeroEjemplarDevE, gridBagConstraints);

        txtNumeroEjemplarDevE.setColumns(4);
        txtNumeroEjemplarDevE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioDevolucionE.add(txtNumeroEjemplarDevE, gridBagConstraints);

        lblCedulaUDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaUDevolucionE.setText("CEDULA USUARIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 20);
        jpFormularioDevolucionE.add(lblCedulaUDevolucionE, gridBagConstraints);

        txtCedulaUDevolucionE.setColumns(4);
        txtCedulaUDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioDevolucionE.add(txtCedulaUDevolucionE, gridBagConstraints);

        lblCedulaEDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaEDevolucionE.setText("CEDULA EMPLEADO");
        lblCedulaEDevolucionE.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioDevolucionE.add(lblCedulaEDevolucionE, gridBagConstraints);

        lblNumeroPrestamoDevE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumeroPrestamoDevE.setText("# PRESTAMO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioDevolucionE.add(lblNumeroPrestamoDevE, gridBagConstraints);

        txtCedulaEDevolucionE.setColumns(4);
        txtCedulaEDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioDevolucionE.add(txtCedulaEDevolucionE, gridBagConstraints);

        txtNumeroPrestamoDevE.setColumns(4);
        txtNumeroPrestamoDevE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioDevolucionE.add(txtNumeroPrestamoDevE, gridBagConstraints);

        jpDevolucionEmpleado.add(jpFormularioDevolucionE, java.awt.BorderLayout.PAGE_START);

        jpTablaDevolucionE.setOpaque(false);
        jpTablaDevolucionE.setLayout(new java.awt.GridBagLayout());

        jtTablaDevolucionE.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaDevolucionE.setDefaultEditor(Object.class, null);
        jtTablaDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaDevolucionE.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# PRESTAMO", "ISBN", "# EJEMPLAR", "# CEDULA", "# EMPLEADO", "FECHA REALIZACION", "FECHA DEVOLUCION"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaDevolucionE.getTableHeader().setResizingAllowed(false);
        jtTablaDevolucionE.getTableHeader().setReorderingAllowed(false);
        jpsTablaDevolucionE.setViewportView(jtTablaDevolucionE);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaDevolucionE.add(jpsTablaDevolucionE, gridBagConstraints);

        jpDevolucionEmpleado.add(jpTablaDevolucionE, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpDevolucionEmpleado, "jpDevolucionEmpleado");

        jpSolicitudEmpleado.setOpaque(false);
        jpSolicitudEmpleado.setLayout(new java.awt.BorderLayout());

        jpFormularioSolicitudE.setOpaque(false);
        jpFormularioSolicitudE.setLayout(new java.awt.GridBagLayout());

        lblTituloSolicitudE.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloSolicitudE.setText("SOLICITUDES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioSolicitudE.add(lblTituloSolicitudE, gridBagConstraints);

        jpSolicitudEmpleado.add(jpFormularioSolicitudE, java.awt.BorderLayout.PAGE_START);

        jpTablaSolicitudE.setOpaque(false);
        jpTablaSolicitudE.setLayout(new java.awt.GridBagLayout());

        jtTablaSolicitudE.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaSolicitudE.setDefaultEditor(Object.class, null);
        jtTablaSolicitudE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaSolicitudE.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# SOLICITUD", "ISBN", "TITULO", "DESCRIPCION"
                }
        ));
        jtTablaSolicitudE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaSolicitudE.getTableHeader().setResizingAllowed(false);
        jtTablaSolicitudE.getTableHeader().setReorderingAllowed(false);
        jspTablaSolicitudE.setViewportView(jtTablaSolicitudE);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaSolicitudE.add(jspTablaSolicitudE, gridBagConstraints);

        jpSolicitudEmpleado.add(jpTablaSolicitudE, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpSolicitudEmpleado, "jpSolicitudEmpleado");

        getContentPane().add(jpContenido, java.awt.BorderLayout.CENTER);

        pack();
    }

    public void initListU()
    {
        this.addBotonesMenuUListener(new CambiarPaginaUListener());
        this.addTablaLibroUListener(new TablaLibroUListener());
        this.addTablaMultaUListener(new TablaMultaUListener());
    }

    public void initListA()
    {
        this.addBotonesMenuAListener(new CambiarPaginaAListener());
        this.addTablaAutorAListener(new TablaAutorAListener());
        this.addTablaEditorialAListener(new TablaEditorialAListener());
        this.addTablaAreaAListener(new TablaAreaAListener());
        this.addTablaEmpleadoAListener(new TablaEmpleadoAListener());
        this.addTablaLibroAListener(new TablaLibroAListener());
        this.addTablaAutorLibroAListener(new TablaAutorLibroAListener());
        this.addTablaEjemplarAListener(new TablaEjemplarAListener());
        this.addTablaDigitalAListener(new TablaDigitalAListener());
    }

    public void initListE()
    {
        this.addBotonesMenuEListener(new CambiarPaginaEListener());
        this.addTablaPrestamoEListener(new TablaPrestamoEListener());
        this.addTablaDevolucionEListener(new TablaDevolucionEListener());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    /*private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpEncabezado = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnUsuario = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jpMenu = new javax.swing.JPanel();
        jpMenuUsuario = new javax.swing.JPanel();
        btnLibrosUsuario = new javax.swing.JButton();
        btnPrestamosUsuario = new javax.swing.JButton();
        btnMultasUsuario = new javax.swing.JButton();
        btnSolicitudUsuario = new javax.swing.JButton();
        jpMenuAdmin = new javax.swing.JPanel();
        btnLibrosAdmin = new javax.swing.JButton();
        btnPrestamosAdmin = new javax.swing.JButton();
        btnMultasAdmin = new javax.swing.JButton();
        btnSolicitudAdmin = new javax.swing.JButton();
        btnAutoresAdmin = new javax.swing.JButton();
        btnEditorialesAdmin = new javax.swing.JButton();
        btnAreasAdmin = new javax.swing.JButton();
        btnDescargasAdmin = new javax.swing.JButton();
        btnEmpleadosAdmin = new javax.swing.JButton();
        btnUsuariosAdmin = new javax.swing.JButton();
        jpMenuEmpleado = new javax.swing.JPanel();
        btnPrestamosEmpleado = new javax.swing.JButton();
        btnDevolucionesEmpleado = new javax.swing.JButton();
        btnSolicitudesEmpleado = new javax.swing.JButton();
        jpContenido = new javax.swing.JPanel();
        jpLibroUsuario = new javax.swing.JPanel();
        jpFormularioLibroU = new javax.swing.JPanel();
        lblTituloLibroU = new javax.swing.JLabel();
        lblIsbnLibroU = new javax.swing.JLabel();
        txtIsbnLibroU = new javax.swing.JTextField();
        btnDescargaLibroU = new javax.swing.JButton();
        jpTablaLibroU = new javax.swing.JPanel();
        jpsTablaLibroU = new javax.swing.JScrollPane();
        jtTablaLibroU = new javax.swing.JTable();
        jpPrestamoUsuario = new javax.swing.JPanel();
        jpFormularioPrestamoU = new javax.swing.JPanel();
        lblTituloPrestamoU = new javax.swing.JLabel();
        jpTablaPrestamoU = new javax.swing.JPanel();
        jpsTablaPrestamoU = new javax.swing.JScrollPane();
        jtTablaPrestamoU = new javax.swing.JTable();
        jpMultaUsuario = new javax.swing.JPanel();
        jpFormularioMultaU = new javax.swing.JPanel();
        lblMultasTitulo = new javax.swing.JLabel();
        lblNumeroMultaU = new javax.swing.JLabel();
        txtNumeroMultaU = new javax.swing.JTextField();
        btnPagarMultaU = new javax.swing.JButton();
        jpTablaMultaU = new javax.swing.JPanel();
        jpsTablaMultaU = new javax.swing.JScrollPane();
        jtTablaMultaU = new javax.swing.JTable();
        jpSolicitudUsuario = new javax.swing.JPanel();
        jpFormularioSolicitudU = new javax.swing.JPanel();
        lblIsbnSolicitudU = new javax.swing.JLabel();
        txtIsbnSolicitudU = new javax.swing.JTextField();
        lblTituloSolicitudU = new javax.swing.JLabel();
        txtTituloSolicitudU = new javax.swing.JTextField();
        lblDescripcionSolicitudU = new javax.swing.JLabel();
        jpsDescripcionSolicitudU = new javax.swing.JScrollPane();
        txaDescripcionSolicitudU = new javax.swing.JTextArea();
        btnEnviarSolicitudU = new javax.swing.JButton();
        lblTituloSolicitudesU = new javax.swing.JLabel();
        jpTablaSolicitudU = new javax.swing.JPanel();
        jpsTablaSolicitudU = new javax.swing.JScrollPane();
        jtTablaSolicitudU = new javax.swing.JTable();
        jpAreaAdmin = new javax.swing.JPanel();
        jpFormularioAreaA = new javax.swing.JPanel();
        lblNombreAreaA = new javax.swing.JLabel();
        txtNombreAreaA = new javax.swing.JTextField();
        lblDescripcionAreaA = new javax.swing.JLabel();
        jspDescripcionAreaA = new javax.swing.JScrollPane();
        txaDescripcionAreaA = new javax.swing.JTextArea();
        lblTituloAreaA = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblCodigoArea1A = new javax.swing.JLabel();
        txtCodigoArea1A = new javax.swing.JTextField();
        lblCodigoArea2A = new javax.swing.JLabel();
        txtCodigoArea2A = new javax.swing.JTextField();
        btnAgregarAreaA = new javax.swing.JButton();
        btnModificarAreaA = new javax.swing.JButton();
        btnEliminarAreaA = new javax.swing.JButton();
        btnRelacionarAreaA = new javax.swing.JButton();
        txtIdAreaA = new javax.swing.JTextField();
        jpTablaAreaA = new javax.swing.JPanel();
        jpsTablaAreaA = new javax.swing.JScrollPane();
        jtTablaAreaA = new javax.swing.JTable();
        jpEditorialAdmin = new javax.swing.JPanel();
        jpFormularioEditorialA = new javax.swing.JPanel();
        lblTituloEditorialA = new javax.swing.JLabel();
        lblNombreEditorialA = new javax.swing.JLabel();
        txtNombreEditorialA = new javax.swing.JTextField();
        lblPaisEditorialA = new javax.swing.JLabel();
        txtPaisEditorialA = new javax.swing.JTextField();
        lblPaginaWebEditorialA = new javax.swing.JLabel();
        txtPaginaWebEditorialA = new javax.swing.JTextField();
        btnAgregarEditorialA = new javax.swing.JButton();
        btnModificarEditorialA = new javax.swing.JButton();
        btnEliminarEditorialA = new javax.swing.JButton();
        txtIdEditorialA = new javax.swing.JTextField();
        jpTablaEditorialA = new javax.swing.JPanel();
        jspTablaEditorialA = new javax.swing.JScrollPane();
        jtTablaEditorialA = new javax.swing.JTable();
        jpAutorAdmin = new javax.swing.JPanel();
        jpFormularioAutorA = new javax.swing.JPanel();
        lblTituloAutorA = new javax.swing.JLabel();
        lblNombre1AutorA = new javax.swing.JLabel();
        txtNombre1AutorA = new javax.swing.JTextField();
        lblNombre2Autor2 = new javax.swing.JLabel();
        txtNombre2AutorA = new javax.swing.JTextField();
        lblApellido1AutorA = new javax.swing.JLabel();
        txtApellido1AutorA = new javax.swing.JTextField();
        lblApellido2AutorA = new javax.swing.JLabel();
        txtApellido2AutorA = new javax.swing.JTextField();
        btnEliminarAutorA = new javax.swing.JButton();
        btnModificarAutorA = new javax.swing.JButton();
        btnAgregarAutorA = new javax.swing.JButton();
        txtIdAutorA = new javax.swing.JTextField();
        jpTablaAutorA = new javax.swing.JPanel();
        jspTablaAutorA = new javax.swing.JScrollPane();
        jtTablaAutorA = new javax.swing.JTable();
        jpPrestamoAdmin = new javax.swing.JPanel();
        jpFormularioPrestamoA = new javax.swing.JPanel();
        lblTituloPrestamoA = new javax.swing.JLabel();
        jpTablaPrestamoA = new javax.swing.JPanel();
        jspTablaPrestamoA = new javax.swing.JScrollPane();
        jtTablaPrestamoA = new javax.swing.JTable();
        jpDescargaAdmin = new javax.swing.JPanel();
        jpFormularioDescargaA = new javax.swing.JPanel();
        lblTituloDescargaA = new javax.swing.JLabel();
        jpTablaDescargaA = new javax.swing.JPanel();
        jspTablaDescargaA = new javax.swing.JScrollPane();
        jtTablaDescargaA = new javax.swing.JTable();
        jpMultaAdmin = new javax.swing.JPanel();
        jpFormularioMultaA = new javax.swing.JPanel();
        lblTituloMultaA = new javax.swing.JLabel();
        jpTablaMultaA = new javax.swing.JPanel();
        jspTablaMultaA = new javax.swing.JScrollPane();
        jtTablaMultaA = new javax.swing.JTable();
        jpSolicitudAdmin = new javax.swing.JPanel();
        jpFormularioSolicitudA = new javax.swing.JPanel();
        lblTituloSolicitudA = new javax.swing.JLabel();
        jpTablaSolicitudA = new javax.swing.JPanel();
        jspTablaSolicitudA = new javax.swing.JScrollPane();
        jtTablaSolicitudA = new javax.swing.JTable();
        jpEmpleadoAdmin = new javax.swing.JPanel();
        jpFormularioEmpleadoA = new javax.swing.JPanel();
        lblTituloEmpleadoA = new javax.swing.JLabel();
        lblCedulaEmpleadoA = new javax.swing.JLabel();
        txtCedulaEmpleadoA = new javax.swing.JTextField();
        lblTelefonoEmpleadoA = new javax.swing.JLabel();
        txtTelefonoEmpleadoA = new javax.swing.JTextField();
        lblNombreEmpleadoA = new javax.swing.JLabel();
        txtNombreEmpleadoA = new javax.swing.JTextField();
        lblCargoEmpleadoA = new javax.swing.JLabel();
        txtCargoEmpleadoA = new javax.swing.JTextField();
        btnEliminarEmpleadoA = new javax.swing.JButton();
        btnModificarEmpleadoA = new javax.swing.JButton();
        btnAgregarEmpleadoA = new javax.swing.JButton();
        lblDireccionEmpleadoA = new javax.swing.JLabel();
        txtDireccionEmpleadoA = new javax.swing.JTextField();
        lblClaveEmpleadoA = new javax.swing.JLabel();
        txtClaveEmpleadoA = new javax.swing.JTextField();
        lblCorreoEmpleadoA = new javax.swing.JLabel();
        txtCorreoEmpleadoA = new javax.swing.JTextField();
        jpTablaEmpleadoA = new javax.swing.JPanel();
        jspTablaEmpleadoA = new javax.swing.JScrollPane();
        jtTablaEmpleadoA = new javax.swing.JTable();
        jpUsuarioAdmin = new javax.swing.JPanel();
        jpFormularioUsuarioA = new javax.swing.JPanel();
        lblTituloUsuarioA = new javax.swing.JLabel();
        jpTablaEmpleadoA1 = new javax.swing.JPanel();
        jspTablaUsuarioA = new javax.swing.JScrollPane();
        jtTablaUsuarioA = new javax.swing.JTable();
        jpPerfilUsuarioE = new javax.swing.JPanel();
        lblTituloUsuarioPE = new javax.swing.JLabel();
        lblCedulaEstudianteP = new javax.swing.JLabel();
        txtCedulaEstudianteP = new javax.swing.JTextField();
        lblTelefonoEstudianteP = new javax.swing.JLabel();
        txtTelefonoEstudianteP = new javax.swing.JTextField();
        lblNombreEstudianteP = new javax.swing.JLabel();
        txtNombreEstudianteP = new javax.swing.JTextField();
        lblCarreraEstudianteP = new javax.swing.JLabel();
        txtCarreraEstudianteP = new javax.swing.JTextField();
        lblDireccionEstudianteP = new javax.swing.JLabel();
        txtDireccionEstudianteP = new javax.swing.JTextField();
        lblClaveEstudianteP = new javax.swing.JLabel();
        txtClaveEstudianteP = new javax.swing.JTextField();
        lblUniversidadEstudianteP = new javax.swing.JLabel();
        txtUniversidadEstudianteP = new javax.swing.JTextField();
        lblCorreoEstudianteP = new javax.swing.JLabel();
        txtCorreoEstudianteP = new javax.swing.JTextField();
        btnModificarPerfilE = new javax.swing.JButton();
        jpPerfilUsuarioP = new javax.swing.JPanel();
        lblTituloUsuarioPP = new javax.swing.JLabel();
        lblCedulaProfesorP = new javax.swing.JLabel();
        txtCedulaProfesorP = new javax.swing.JTextField();
        lblTelefonoProfesorP = new javax.swing.JLabel();
        txtTelefonoProfesorP = new javax.swing.JTextField();
        lblNombreProfesorP = new javax.swing.JLabel();
        txtNombreProfesorP = new javax.swing.JTextField();
        lblTituloProfesorP = new javax.swing.JLabel();
        txtTituloProfesorP = new javax.swing.JTextField();
        lblDireccionProfesorP = new javax.swing.JLabel();
        txtDireccionProfesorP = new javax.swing.JTextField();
        lblClaveProfesorP = new javax.swing.JLabel();
        txtClaveProfesorP = new javax.swing.JTextField();
        lblDependenciaProfesorP = new javax.swing.JLabel();
        txtDependenciaProfesorP = new javax.swing.JTextField();
        lblCorreoProfesorP = new javax.swing.JLabel();
        txtCorreoProfesorP = new javax.swing.JTextField();
        btnModificarPerfilP = new javax.swing.JButton();
        jpPrestamoEmpleado = new javax.swing.JPanel();
        jpFormularioPrestamoE = new javax.swing.JPanel();
        lblTituloPrestamoE = new javax.swing.JLabel();
        lblIsbnPrestamoE = new javax.swing.JLabel();
        txtIsbnPrestamoE = new javax.swing.JTextField();
        btnAgregarLibroE = new javax.swing.JButton();
        lblNumeroEjemplarPreE = new javax.swing.JLabel();
        txtNumeroEjemplarPreE = new javax.swing.JTextField();
        lblCedulaPrestamoE = new javax.swing.JLabel();
        txtCedulaPrestamoE = new javax.swing.JTextField();
        lblFechaRPrestamoE = new javax.swing.JLabel();
        jdFechaRPrestamoE = new com.toedter.calendar.JDateChooser();
        lblFechaDPrestamoE = new javax.swing.JLabel();
        jdFechaDPrestamoE = new com.toedter.calendar.JDateChooser();
        jpTablaLibroPreE = new javax.swing.JPanel();
        jspTablaLibroPreE = new javax.swing.JScrollPane();
        jtTablaLibroPreE = new javax.swing.JTable();
        btnBorrarPrestamoE = new javax.swing.JButton();
        btnPrestarPrestamoE = new javax.swing.JButton();
        jpTablaPrestamoE = new javax.swing.JPanel();
        jpsTablaPrestamoE = new javax.swing.JScrollPane();
        jtTablaPrestamoE = new javax.swing.JTable();
        jpDevolucionEmpleado = new javax.swing.JPanel();
        jpFormularioDevolucionE = new javax.swing.JPanel();
        lblTituloDevolucionE = new javax.swing.JLabel();
        lblIsbnDevolucionE = new javax.swing.JLabel();
        txtIsbnDevolucionE = new javax.swing.JTextField();
        btnDevolverLibroE = new javax.swing.JButton();
        lblNumeroEjemplarDevE = new javax.swing.JLabel();
        txtNumeroEjemplarDevE = new javax.swing.JTextField();
        lblCedulaUDevolucionE = new javax.swing.JLabel();
        txtCedulaUDevolucionE = new javax.swing.JTextField();
        lblCedulaEDevolucionE = new javax.swing.JLabel();
        lblNumeroPrestamoDevE = new javax.swing.JLabel();
        txtCedulaEDevolucionE = new javax.swing.JTextField();
        txtNumeroPrestamoDevE = new javax.swing.JTextField();
        jpTablaDevolucionE = new javax.swing.JPanel();
        jpsTablaDevolucionE = new javax.swing.JScrollPane();
        jtTablaDevolucionE = new javax.swing.JTable();
        jpSolicitudEmpleado = new javax.swing.JPanel();
        jpFormularioSolicitudE = new javax.swing.JPanel();
        lblTituloSolicitudE = new javax.swing.JLabel();
        jpTablaSolicitudE = new javax.swing.JPanel();
        jspTablaSolicitudE = new javax.swing.JScrollPane();
        jtTablaSolicitudE = new javax.swing.JTable();
        tabLibroAdmin = new javax.swing.JTabbedPane();
        jpLibroAdmin = new javax.swing.JPanel();
        jpFormularioLibroA = new javax.swing.JPanel();
        lblTituloLibrosA = new javax.swing.JLabel();
        lblIsbnLibroA = new javax.swing.JLabel();
        txtIsbnLibroA = new javax.swing.JTextField();
        btnAgregarLibroA = new javax.swing.JButton();
        lblEditorialLibroA = new javax.swing.JLabel();
        txtEditorialLibroA = new javax.swing.JTextField();
        lblNumPaginasLibroA = new javax.swing.JLabel();
        txtNumPaginasLibroA = new javax.swing.JTextField();
        lblIdiomaLibroA = new javax.swing.JLabel();
        txtIdiomaLibroA = new javax.swing.JTextField();
        lblAnoPublicLibroA = new javax.swing.JLabel();
        jyAnoPublicLibroA = new com.toedter.calendar.JYearChooser();
        btnModificarLibroA = new javax.swing.JButton();
        btnEliminarLibroA = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jpTablaAutorLibroA = new javax.swing.JPanel();
        jspTablaAutorLibroA = new javax.swing.JScrollPane();
        jtTablaAutorLibroA = new javax.swing.JTable();
        txtAutorLibroA = new javax.swing.JTextField();
        lblAutorLibroA = new javax.swing.JLabel();
        btnAgregarAutorLibroA = new javax.swing.JButton();
        btnEliminarAutorLibroA = new javax.swing.JButton();
        lblTituloLibroA = new javax.swing.JLabel();
        txtTituloLibroA = new javax.swing.JTextField();
        jpTablaLibroA = new javax.swing.JPanel();
        jpsTablaLibroA = new javax.swing.JScrollPane();
        jtTablaLibroA = new javax.swing.JTable();
        jpEjemplarAdmin = new javax.swing.JPanel();
        jpFormularioEjemplarA = new javax.swing.JPanel();
        lblTituloEjemplarA = new javax.swing.JLabel();
        lblIsbnEjemplarA = new javax.swing.JLabel();
        txtIsbnEjemplarA = new javax.swing.JTextField();
        btnAgregarEjemplarA = new javax.swing.JButton();
        lblEstanteEjemplarA = new javax.swing.JLabel();
        txtEstanteEjemplarA = new javax.swing.JTextField();
        lblNomSalaEjemplarA = new javax.swing.JLabel();
        txtNomSalaEjemplarA = new javax.swing.JTextField();
        lblNumCajonEjemplarA = new javax.swing.JLabel();
        txtNumCajonEjemplarA = new javax.swing.JTextField();
        lblNumPasilloEjemplarA = new javax.swing.JLabel();
        btnModificarEjemplarA = new javax.swing.JButton();
        btnEliminarEjemplarA = new javax.swing.JButton();
        txtNumPasilloEjemplarA = new javax.swing.JTextField();
        txtNumEjemplarA = new javax.swing.JTextField();
        jpTablaEjemplarA = new javax.swing.JPanel();
        jpsTablaEjemplarA = new javax.swing.JScrollPane();
        jtTablaEjemplarA = new javax.swing.JTable();
        jpDigitalAdmin = new javax.swing.JPanel();
        jpFormularioDigitalA = new javax.swing.JPanel();
        lblTituloDigitalA = new javax.swing.JLabel();
        lblIsbnDigitalA = new javax.swing.JLabel();
        txtIsbnDigitalA = new javax.swing.JTextField();
        btnAgregarDigitalA = new javax.swing.JButton();
        lblUrlDigitalA = new javax.swing.JLabel();
        txtUrlDigitalA = new javax.swing.JTextField();
        lblBytesDigitalA = new javax.swing.JLabel();
        txtBytesDigitalA = new javax.swing.JTextField();
        lblFormatoDigitalA = new javax.swing.JLabel();
        txtFormatoDigitalA = new javax.swing.JTextField();
        btnModificarDigitalA = new javax.swing.JButton();
        btnEliminarDigitalA = new javax.swing.JButton();
        txtNumDigitalA = new javax.swing.JTextField();
        jpTablaDigitalA = new javax.swing.JPanel();
        jpsTablaDigitalA = new javax.swing.JScrollPane();
        jtTablaDigitalA = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpEncabezado.setBackground(new java.awt.Color(225, 232, 239));
        jpEncabezado.setLayout(new java.awt.GridBagLayout());

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoUnivalleS.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 20, 40);
        jpEncabezado.add(lblIcono, gridBagConstraints);

        lblTitulo.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        lblTitulo.setText("BIBLIOTECA UNIVERSITARIA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jpEncabezado.add(lblTitulo, gridBagConstraints);

        btnUsuario.setBackground(new java.awt.Color(255, 0, 0));
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuarioB.png"))); // NOI18N
        btnUsuario.setActionCommand("usuario");
        btnUsuario.setBorderPainted(false);
        btnUsuario.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpEncabezado.add(btnUsuario, gridBagConstraints);

        btnCerrarSesion.setBackground(new java.awt.Color(255, 0, 0));
        btnCerrarSesion.setForeground(new java.awt.Color(255, 0, 51));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrarSesion.png"))); // NOI18N
        btnCerrarSesion.setActionCommand("cerrarSesion");
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 20);
        jpEncabezado.add(btnCerrarSesion, gridBagConstraints);

        getContentPane().add(jpEncabezado, java.awt.BorderLayout.PAGE_START);

        jpMenu.setLayout(new java.awt.CardLayout());

        jpMenuUsuario.setBackground(new java.awt.Color(235, 238, 243));
        jpMenuUsuario.setLayout(new java.awt.GridBagLayout());

        btnLibrosUsuario.setBackground(new java.awt.Color(225, 232, 239));
        btnLibrosUsuario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnLibrosUsuario.setText("LIBROS");
        btnLibrosUsuario.setActionCommand("libroUsuario");
        btnLibrosUsuario.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuUsuario.add(btnLibrosUsuario, gridBagConstraints);

        btnPrestamosUsuario.setBackground(new java.awt.Color(225, 232, 239));
        btnPrestamosUsuario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnPrestamosUsuario.setText("PRESTAMOS");
        btnPrestamosUsuario.setActionCommand("prestamoUsuario");
        btnPrestamosUsuario.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuUsuario.add(btnPrestamosUsuario, gridBagConstraints);

        btnMultasUsuario.setBackground(new java.awt.Color(225, 232, 239));
        btnMultasUsuario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnMultasUsuario.setText("MULTAS");
        btnMultasUsuario.setActionCommand("multasUsuario");
        btnMultasUsuario.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuUsuario.add(btnMultasUsuario, gridBagConstraints);

        btnSolicitudUsuario.setBackground(new java.awt.Color(225, 232, 239));
        btnSolicitudUsuario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnSolicitudUsuario.setText("SOLICITUDES");
        btnSolicitudUsuario.setActionCommand("solicitudUsuario");
        btnSolicitudUsuario.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuUsuario.add(btnSolicitudUsuario, gridBagConstraints);

        jpMenu.add(jpMenuUsuario, "jpMenuUsuario");

        jpMenuAdmin.setBackground(new java.awt.Color(235, 238, 243));
        jpMenuAdmin.setLayout(new java.awt.GridBagLayout());

        btnLibrosAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnLibrosAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnLibrosAdmin.setText("LIBROS");
        btnLibrosAdmin.setActionCommand("libroAdmin");
        btnLibrosAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnLibrosAdmin, gridBagConstraints);

        btnPrestamosAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnPrestamosAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnPrestamosAdmin.setText("PRESTAMOS");
        btnPrestamosAdmin.setActionCommand("prestamoAdmin");
        btnPrestamosAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnPrestamosAdmin, gridBagConstraints);

        btnMultasAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnMultasAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnMultasAdmin.setText("MULTAS");
        btnMultasAdmin.setActionCommand("multaAdmin");
        btnMultasAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnMultasAdmin, gridBagConstraints);

        btnSolicitudAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnSolicitudAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnSolicitudAdmin.setText("SOLICITUDES");
        btnSolicitudAdmin.setActionCommand("solicitudAdmin");
        btnSolicitudAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnSolicitudAdmin, gridBagConstraints);

        btnAutoresAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnAutoresAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnAutoresAdmin.setText("AUTORES");
        btnAutoresAdmin.setActionCommand("autorAdmin");
        btnAutoresAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnAutoresAdmin, gridBagConstraints);

        btnEditorialesAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnEditorialesAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnEditorialesAdmin.setText("EDITORIALES");
        btnEditorialesAdmin.setActionCommand("editorialAdmin");
        btnEditorialesAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnEditorialesAdmin, gridBagConstraints);

        btnAreasAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnAreasAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnAreasAdmin.setText("AREAS");
        btnAreasAdmin.setActionCommand("areaAdmin");
        btnAreasAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnAreasAdmin, gridBagConstraints);

        btnDescargasAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnDescargasAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnDescargasAdmin.setText("DESCARGAS");
        btnDescargasAdmin.setActionCommand("descargaAdmin");
        btnDescargasAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnDescargasAdmin, gridBagConstraints);

        btnEmpleadosAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnEmpleadosAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnEmpleadosAdmin.setText("EMPLEADOS");
        btnEmpleadosAdmin.setActionCommand("empleadoAdmin");
        btnEmpleadosAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnEmpleadosAdmin, gridBagConstraints);

        btnUsuariosAdmin.setBackground(new java.awt.Color(225, 232, 239));
        btnUsuariosAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnUsuariosAdmin.setText("USUARIOS");
        btnUsuariosAdmin.setActionCommand("usuarioAdmin");
        btnUsuariosAdmin.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuAdmin.add(btnUsuariosAdmin, gridBagConstraints);

        jpMenu.add(jpMenuAdmin, "jpMenuAdmin");

        jpMenuEmpleado.setBackground(new java.awt.Color(235, 238, 243));
        jpMenuEmpleado.setLayout(new java.awt.GridBagLayout());

        btnPrestamosEmpleado.setBackground(new java.awt.Color(225, 232, 239));
        btnPrestamosEmpleado.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnPrestamosEmpleado.setText("PRESTAMOS");
        btnPrestamosEmpleado.setActionCommand("prestamoEmpleado");
        btnPrestamosEmpleado.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuEmpleado.add(btnPrestamosEmpleado, gridBagConstraints);

        btnDevolucionesEmpleado.setBackground(new java.awt.Color(225, 232, 239));
        btnDevolucionesEmpleado.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnDevolucionesEmpleado.setText("DEVOLUCIONES");
        btnDevolucionesEmpleado.setActionCommand("devolucionEmpleado");
        btnDevolucionesEmpleado.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuEmpleado.add(btnDevolucionesEmpleado, gridBagConstraints);

        btnSolicitudesEmpleado.setBackground(new java.awt.Color(225, 232, 239));
        btnSolicitudesEmpleado.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnSolicitudesEmpleado.setText("SOLICITUDES");
        btnSolicitudesEmpleado.setActionCommand("solicitudEmpleado");
        btnSolicitudesEmpleado.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jpMenuEmpleado.add(btnSolicitudesEmpleado, gridBagConstraints);

        jpMenu.add(jpMenuEmpleado, "jpMenuEmpleado");

        getContentPane().add(jpMenu, java.awt.BorderLayout.WEST);

        jpContenido.setBackground(new java.awt.Color(249, 250, 252));
        jpContenido.setLayout(new java.awt.CardLayout());

        jpLibroUsuario.setOpaque(false);
        jpLibroUsuario.setLayout(new java.awt.BorderLayout());

        jpFormularioLibroU.setOpaque(false);
        jpFormularioLibroU.setLayout(new java.awt.GridBagLayout());

        lblTituloLibroU.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloLibroU.setText("LIBROS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioLibroU.add(lblTituloLibroU, gridBagConstraints);

        lblIsbnLibroU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnLibroU.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        jpFormularioLibroU.add(lblIsbnLibroU, gridBagConstraints);

        txtIsbnLibroU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jpFormularioLibroU.add(txtIsbnLibroU, gridBagConstraints);

        btnDescargaLibroU.setBackground(new java.awt.Color(255, 0, 51));
        btnDescargaLibroU.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnDescargaLibroU.setForeground(new java.awt.Color(255, 255, 255));
        btnDescargaLibroU.setText("DESCARGAR");
        btnDescargaLibroU.setBorderPainted(false);
        btnDescargaLibroU.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jpFormularioLibroU.add(btnDescargaLibroU, gridBagConstraints);

        jpLibroUsuario.add(jpFormularioLibroU, java.awt.BorderLayout.PAGE_START);

        jpTablaLibroU.setOpaque(false);
        jpTablaLibroU.setLayout(new java.awt.GridBagLayout());

        jtTablaLibroU.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaLibroU.setDefaultEditor(Object.class, null);
        jtTablaLibroU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaLibroU.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "ISBN", "TITULO", "AUTOR", "EDITORIAL", "PUBLICACION", "IDIOMA", "# PAGINAS", "EJEMPLARES", "DIGITAL"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaLibroU.getTableHeader().setResizingAllowed(false);
        jtTablaLibroU.getTableHeader().setReorderingAllowed(false);
        jpsTablaLibroU.setViewportView(jtTablaLibroU);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaLibroU.add(jpsTablaLibroU, gridBagConstraints);

        jpLibroUsuario.add(jpTablaLibroU, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpLibroUsuario, "libroUsuario");

        jpPrestamoUsuario.setOpaque(false);
        jpPrestamoUsuario.setLayout(new java.awt.BorderLayout());

        jpFormularioPrestamoU.setOpaque(false);
        jpFormularioPrestamoU.setLayout(new java.awt.GridBagLayout());

        lblTituloPrestamoU.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloPrestamoU.setText("PRESTAMOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioPrestamoU.add(lblTituloPrestamoU, gridBagConstraints);

        jpPrestamoUsuario.add(jpFormularioPrestamoU, java.awt.BorderLayout.PAGE_START);

        jpTablaPrestamoU.setOpaque(false);
        jpTablaPrestamoU.setLayout(new java.awt.GridBagLayout());

        jtTablaPrestamoU.getTableHeader().setFont(new java.awt.Font("Montserrat", 0, 12));
        jtTablaPrestamoU.setDefaultEditor(Object.class, null);
        jtTablaPrestamoU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaPrestamoU.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# PRESTAMO", "FECHA REALIZACION", "ISBN", "# EJEMPLAR", "FECHA DEVOLUCION", "EMPLEADO"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaPrestamoU.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaPrestamoU.getTableHeader().setResizingAllowed(false);
        jtTablaPrestamoU.getTableHeader().setReorderingAllowed(false);
        jpsTablaPrestamoU.setViewportView(jtTablaPrestamoU);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaPrestamoU.add(jpsTablaPrestamoU, gridBagConstraints);

        jpPrestamoUsuario.add(jpTablaPrestamoU, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpPrestamoUsuario, "prestamoUsuario");

        jpMultaUsuario.setOpaque(false);
        jpMultaUsuario.setLayout(new java.awt.BorderLayout());

        jpFormularioMultaU.setOpaque(false);
        jpFormularioMultaU.setLayout(new java.awt.GridBagLayout());

        lblMultasTitulo.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblMultasTitulo.setText("MULTAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioMultaU.add(lblMultasTitulo, gridBagConstraints);

        lblNumeroMultaU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumeroMultaU.setText("# MULTA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        jpFormularioMultaU.add(lblNumeroMultaU, gridBagConstraints);

        txtNumeroMultaU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jpFormularioMultaU.add(txtNumeroMultaU, gridBagConstraints);

        btnPagarMultaU.setBackground(new java.awt.Color(255, 0, 0));
        btnPagarMultaU.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnPagarMultaU.setForeground(new java.awt.Color(255, 255, 255));
        btnPagarMultaU.setText("PAGAR");
        btnPagarMultaU.setBorderPainted(false);
        btnPagarMultaU.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 50;
        jpFormularioMultaU.add(btnPagarMultaU, gridBagConstraints);

        jpMultaUsuario.add(jpFormularioMultaU, java.awt.BorderLayout.PAGE_START);

        jpTablaMultaU.setOpaque(false);
        jpTablaMultaU.setLayout(new java.awt.GridBagLayout());

        jtTablaMultaU.getTableHeader().setFont(new java.awt.Font("Montserrat", 0, 12));
        jtTablaMultaU.setDefaultEditor(Object.class, null);
        jtTablaMultaU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaMultaU.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# MULTA", "ISBN", "# EJEMPLAR", "FECHA MULTA", "VALOR", "DESCRIPCION"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaMultaU.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaMultaU.getTableHeader().setResizingAllowed(false);
        jtTablaMultaU.getTableHeader().setReorderingAllowed(false);
        jpsTablaMultaU.setViewportView(jtTablaMultaU);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaMultaU.add(jpsTablaMultaU, gridBagConstraints);

        jpMultaUsuario.add(jpTablaMultaU, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpMultaUsuario, "multaUsuario");

        jpSolicitudUsuario.setOpaque(false);
        jpSolicitudUsuario.setLayout(new java.awt.BorderLayout());

        jpFormularioSolicitudU.setOpaque(false);
        jpFormularioSolicitudU.setLayout(new java.awt.GridBagLayout());

        lblIsbnSolicitudU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnSolicitudU.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jpFormularioSolicitudU.add(lblIsbnSolicitudU, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jpFormularioSolicitudU.add(txtIsbnSolicitudU, gridBagConstraints);

        lblTituloSolicitudU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTituloSolicitudU.setText("TITULO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jpFormularioSolicitudU.add(lblTituloSolicitudU, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jpFormularioSolicitudU.add(txtTituloSolicitudU, gridBagConstraints);

        lblDescripcionSolicitudU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDescripcionSolicitudU.setText("DESCRIPCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jpFormularioSolicitudU.add(lblDescripcionSolicitudU, gridBagConstraints);

        txaDescripcionSolicitudU.setColumns(20);
        txaDescripcionSolicitudU.setRows(5);
        jpsDescripcionSolicitudU.setViewportView(txaDescripcionSolicitudU);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 20, 10);
        jpFormularioSolicitudU.add(jpsDescripcionSolicitudU, gridBagConstraints);

        btnEnviarSolicitudU.setBackground(new java.awt.Color(255, 0, 0));
        btnEnviarSolicitudU.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEnviarSolicitudU.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviarSolicitudU.setText("ENVIAR");
        btnEnviarSolicitudU.setBorderPainted(false);
        btnEnviarSolicitudU.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 50;
        jpFormularioSolicitudU.add(btnEnviarSolicitudU, gridBagConstraints);

        lblTituloSolicitudesU.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloSolicitudesU.setText("SOLICITUDES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioSolicitudU.add(lblTituloSolicitudesU, gridBagConstraints);

        jpSolicitudUsuario.add(jpFormularioSolicitudU, java.awt.BorderLayout.NORTH);

        jpTablaSolicitudU.setOpaque(false);
        jpTablaSolicitudU.setLayout(new java.awt.GridBagLayout());

        jpsTablaSolicitudU.setOpaque(false);

        jtTablaSolicitudU.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaSolicitudU.setDefaultEditor(Object.class, null);
        jtTablaSolicitudU.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaSolicitudU.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# SOLICITUD", "ISBN", "TITULO", "DESCRIPCION"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaSolicitudU.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaSolicitudU.getTableHeader().setResizingAllowed(false);
        jtTablaSolicitudU.getTableHeader().setReorderingAllowed(false);
        jpsTablaSolicitudU.setViewportView(jtTablaSolicitudU);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 0);
        jpTablaSolicitudU.add(jpsTablaSolicitudU, gridBagConstraints);

        jpSolicitudUsuario.add(jpTablaSolicitudU, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpSolicitudUsuario, "solicitudUsuario");

        jpAreaAdmin.setOpaque(false);
        jpAreaAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioAreaA.setOpaque(false);
        jpFormularioAreaA.setLayout(new java.awt.GridBagLayout());

        lblNombreAreaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombreAreaA.setText("NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioAreaA.add(lblNombreAreaA, gridBagConstraints);

        txtNombreAreaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 0);
        jpFormularioAreaA.add(txtNombreAreaA, gridBagConstraints);

        lblDescripcionAreaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDescripcionAreaA.setText("DESCRIPCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioAreaA.add(lblDescripcionAreaA, gridBagConstraints);

        txaDescripcionAreaA.setColumns(20);
        txaDescripcionAreaA.setRows(5);
        jspDescripcionAreaA.setViewportView(txaDescripcionAreaA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioAreaA.add(jspDescripcionAreaA, gridBagConstraints);

        lblTituloAreaA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloAreaA.setText("AREAS DE CONOCIMIENTO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioAreaA.add(lblTituloAreaA, gridBagConstraints);

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jpFormularioAreaA.add(jSeparator1, gridBagConstraints);

        lblCodigoArea1A.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCodigoArea1A.setText("CODIGO 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioAreaA.add(lblCodigoArea1A, gridBagConstraints);

        txtCodigoArea1A.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtCodigoArea1A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoArea1AActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioAreaA.add(txtCodigoArea1A, gridBagConstraints);

        lblCodigoArea2A.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCodigoArea2A.setText("CODIGO 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioAreaA.add(lblCodigoArea2A, gridBagConstraints);

        txtCodigoArea2A.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioAreaA.add(txtCodigoArea2A, gridBagConstraints);

        btnAgregarAreaA.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregarAreaA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarAreaA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAreaA.setText("AGREGAR");
        btnAgregarAreaA.setBorderPainted(false);
        btnAgregarAreaA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioAreaA.add(btnAgregarAreaA, gridBagConstraints);

        btnModificarAreaA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarAreaA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarAreaA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarAreaA.setText("MODIFICAR");
        btnModificarAreaA.setBorderPainted(false);
        btnModificarAreaA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioAreaA.add(btnModificarAreaA, gridBagConstraints);

        btnEliminarAreaA.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminarAreaA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarAreaA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAreaA.setText("ELIMINAR");
        btnEliminarAreaA.setBorderPainted(false);
        btnEliminarAreaA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 20);
        jpFormularioAreaA.add(btnEliminarAreaA, gridBagConstraints);

        btnRelacionarAreaA.setBackground(new java.awt.Color(255, 0, 0));
        btnRelacionarAreaA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnRelacionarAreaA.setForeground(new java.awt.Color(255, 255, 255));
        btnRelacionarAreaA.setText("RELACIONAR");
        btnRelacionarAreaA.setBorderPainted(false);
        btnRelacionarAreaA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioAreaA.add(btnRelacionarAreaA, gridBagConstraints);

        txtIdAreaA.setVisible(false);
        txtIdAreaA.setEditable(false);
        txtIdAreaA.setText("0");
        txtIdAreaA.setEnabled(false);
        txtIdAreaA.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jpFormularioAreaA.add(txtIdAreaA, gridBagConstraints);

        jpAreaAdmin.add(jpFormularioAreaA, java.awt.BorderLayout.PAGE_START);

        jpTablaAreaA.setOpaque(false);
        jpTablaAreaA.setLayout(new java.awt.GridBagLayout());

        jtTablaAreaA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaAreaA.setDefaultEditor(Object.class, null);
        jtTablaAreaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaAreaA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# AREA", "NOMBRE", "DESCRIPCION", "AREAS HIJAS"
                }
        ));
        jtTablaAreaA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaAreaA.getTableHeader().setResizingAllowed(false);
        jtTablaAreaA.getTableHeader().setReorderingAllowed(false);
        jpsTablaAreaA.setViewportView(jtTablaAreaA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaAreaA.add(jpsTablaAreaA, gridBagConstraints);

        jpAreaAdmin.add(jpTablaAreaA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpAreaAdmin, "jpAreaAdmin");

        jpEditorialAdmin.setOpaque(false);
        jpEditorialAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioEditorialA.setOpaque(false);
        jpFormularioEditorialA.setLayout(new java.awt.GridBagLayout());

        lblTituloEditorialA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloEditorialA.setText("EDITORIAL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioEditorialA.add(lblTituloEditorialA, gridBagConstraints);

        lblNombreEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombreEditorialA.setText("NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jpFormularioEditorialA.add(lblNombreEditorialA, gridBagConstraints);

        txtNombreEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 20, 0);
        jpFormularioEditorialA.add(txtNombreEditorialA, gridBagConstraints);

        lblPaisEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblPaisEditorialA.setText("PAIS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jpFormularioEditorialA.add(lblPaisEditorialA, gridBagConstraints);

        txtPaisEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 20, 0);
        jpFormularioEditorialA.add(txtPaisEditorialA, gridBagConstraints);

        lblPaginaWebEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblPaginaWebEditorialA.setText("PAGINA WEB");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jpFormularioEditorialA.add(lblPaginaWebEditorialA, gridBagConstraints);

        txtPaginaWebEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 20, 0);
        jpFormularioEditorialA.add(txtPaginaWebEditorialA, gridBagConstraints);

        btnAgregarEditorialA.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregarEditorialA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarEditorialA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEditorialA.setText("AGREGAR");
        btnAgregarEditorialA.setBorderPainted(false);
        btnAgregarEditorialA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 20);
        jpFormularioEditorialA.add(btnAgregarEditorialA, gridBagConstraints);

        btnModificarEditorialA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarEditorialA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarEditorialA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarEditorialA.setText("MODIFICAR");
        btnModificarEditorialA.setBorderPainted(false);
        btnModificarEditorialA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioEditorialA.add(btnModificarEditorialA, gridBagConstraints);

        btnEliminarEditorialA.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminarEditorialA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarEditorialA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEditorialA.setText("ELIMINAR");
        btnEliminarEditorialA.setBorderPainted(false);
        btnEliminarEditorialA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 20);
        jpFormularioEditorialA.add(btnEliminarEditorialA, gridBagConstraints);

        txtIdEditorialA.setVisible(false);
        txtIdEditorialA.setEditable(false);
        txtIdEditorialA.setText("0");
        txtIdEditorialA.setEnabled(false);
        txtIdEditorialA.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jpFormularioEditorialA.add(txtIdEditorialA, gridBagConstraints);

        jpEditorialAdmin.add(jpFormularioEditorialA, java.awt.BorderLayout.PAGE_START);

        jpTablaEditorialA.setOpaque(false);
        jpTablaEditorialA.setLayout(new java.awt.GridBagLayout());

        jtTablaEditorialA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaEditorialA.setDefaultEditor(Object.class, null);
        jtTablaEditorialA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaEditorialA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# EDITORIAL", "NOMBRE", "PAIS", "PAGINA WEB"
                }
        ));
        jtTablaEditorialA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaEditorialA.getTableHeader().setResizingAllowed(false);
        jtTablaEditorialA.getTableHeader().setReorderingAllowed(false);
        jspTablaEditorialA.setViewportView(jtTablaEditorialA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaEditorialA.add(jspTablaEditorialA, gridBagConstraints);

        jpEditorialAdmin.add(jpTablaEditorialA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpEditorialAdmin, "jpEditorialAdmin");

        jpAutorAdmin.setOpaque(false);
        jpAutorAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioAutorA.setOpaque(false);
        jpFormularioAutorA.setLayout(new java.awt.GridBagLayout());

        lblTituloAutorA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloAutorA.setText("AUTORES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioAutorA.add(lblTituloAutorA, gridBagConstraints);

        lblNombre1AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombre1AutorA.setText("1° NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioAutorA.add(lblNombre1AutorA, gridBagConstraints);

        txtNombre1AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioAutorA.add(txtNombre1AutorA, gridBagConstraints);

        lblNombre2Autor2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombre2Autor2.setText("2° NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioAutorA.add(lblNombre2Autor2, gridBagConstraints);

        txtNombre2AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioAutorA.add(txtNombre2AutorA, gridBagConstraints);

        lblApellido1AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblApellido1AutorA.setText("1° APELLIDO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioAutorA.add(lblApellido1AutorA, gridBagConstraints);

        txtApellido1AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioAutorA.add(txtApellido1AutorA, gridBagConstraints);

        lblApellido2AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblApellido2AutorA.setText("2° APELLIDO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioAutorA.add(lblApellido2AutorA, gridBagConstraints);

        txtApellido2AutorA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioAutorA.add(txtApellido2AutorA, gridBagConstraints);

        btnEliminarAutorA.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminarAutorA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarAutorA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAutorA.setText("ELIMINAR");
        btnEliminarAutorA.setBorderPainted(false);
        btnEliminarAutorA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 20);
        jpFormularioAutorA.add(btnEliminarAutorA, gridBagConstraints);

        btnModificarAutorA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarAutorA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarAutorA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarAutorA.setText("MODIFICAR");
        btnModificarAutorA.setBorderPainted(false);
        btnModificarAutorA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioAutorA.add(btnModificarAutorA, gridBagConstraints);

        btnAgregarAutorA.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregarAutorA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarAutorA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAutorA.setText("AGREGAR");
        btnAgregarAutorA.setBorderPainted(false);
        btnAgregarAutorA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioAutorA.add(btnAgregarAutorA, gridBagConstraints);

        txtIdAutorA.setVisible(false);
        txtIdAutorA.setEditable(false);
        txtIdAutorA.setText("0");
        txtIdAutorA.setEnabled(false);
        txtIdAutorA.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jpFormularioAutorA.add(txtIdAutorA, gridBagConstraints);

        jpAutorAdmin.add(jpFormularioAutorA, java.awt.BorderLayout.PAGE_START);

        jpTablaAutorA.setOpaque(false);
        jpTablaAutorA.setLayout(new java.awt.GridBagLayout());

        jtTablaAutorA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaAutorA.setDefaultEditor(Object.class, null);
        jtTablaAutorA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# AUTOR", "1° NOMBRE", "2° NOMBRE", "1° APELLIDO", "2° APELLIDO"
                }
        ));
        jtTablaAutorA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaAutorA.getTableHeader().setResizingAllowed(false);
        jtTablaAutorA.getTableHeader().setReorderingAllowed(false);
        jspTablaAutorA.setViewportView(jtTablaAutorA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaAutorA.add(jspTablaAutorA, gridBagConstraints);

        jpAutorAdmin.add(jpTablaAutorA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpAutorAdmin, "jpAutorAdmin");

        jpPrestamoAdmin.setOpaque(false);
        jpPrestamoAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioPrestamoA.setOpaque(false);
        jpFormularioPrestamoA.setLayout(new java.awt.GridBagLayout());

        lblTituloPrestamoA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloPrestamoA.setText("PRESTAMOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioPrestamoA.add(lblTituloPrestamoA, gridBagConstraints);

        jpPrestamoAdmin.add(jpFormularioPrestamoA, java.awt.BorderLayout.PAGE_START);

        jpTablaPrestamoA.setOpaque(false);
        jpTablaPrestamoA.setLayout(new java.awt.GridBagLayout());

        jtTablaPrestamoA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaPrestamoA.setDefaultEditor(Object.class, null);
        jtTablaPrestamoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaPrestamoA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# PRESTAMO", "ISBN", "# EJEMPLAR", "TITULO", "# USUARIO", "# EMPLEADO", "FECHA REALIZACION", "FECHA DEVOLUCION"
                }
        ));
        jtTablaPrestamoA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaPrestamoA.getTableHeader().setResizingAllowed(false);
        jtTablaPrestamoA.getTableHeader().setReorderingAllowed(false);
        jspTablaPrestamoA.setViewportView(jtTablaPrestamoA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaPrestamoA.add(jspTablaPrestamoA, gridBagConstraints);

        jpPrestamoAdmin.add(jpTablaPrestamoA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpPrestamoAdmin, "jpPrestamoAdmin");

        jpDescargaAdmin.setOpaque(false);
        jpDescargaAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioDescargaA.setOpaque(false);
        jpFormularioDescargaA.setLayout(new java.awt.GridBagLayout());

        lblTituloDescargaA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloDescargaA.setText("DESCARGAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioDescargaA.add(lblTituloDescargaA, gridBagConstraints);

        jpDescargaAdmin.add(jpFormularioDescargaA, java.awt.BorderLayout.PAGE_START);

        jpTablaDescargaA.setOpaque(false);
        jpTablaDescargaA.setLayout(new java.awt.GridBagLayout());

        jtTablaPrestamoA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaPrestamoA.setDefaultEditor(Object.class, null);
        jtTablaDescargaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaDescargaA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "ISBN", "TITULO", "# USUARIO", "IP", "FECHA DESCARGA", "HORA DESCARGA"
                }
        ));
        jtTablaDescargaA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaDescargaA.getTableHeader().setResizingAllowed(false);
        jtTablaDescargaA.getTableHeader().setReorderingAllowed(false);
        jspTablaDescargaA.setViewportView(jtTablaDescargaA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaDescargaA.add(jspTablaDescargaA, gridBagConstraints);

        jpDescargaAdmin.add(jpTablaDescargaA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpDescargaAdmin, "jpDescargaAdmin");

        jpMultaAdmin.setOpaque(false);
        jpMultaAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioMultaA.setOpaque(false);
        jpFormularioMultaA.setLayout(new java.awt.GridBagLayout());

        lblTituloMultaA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloMultaA.setText("MULTAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioMultaA.add(lblTituloMultaA, gridBagConstraints);

        jpMultaAdmin.add(jpFormularioMultaA, java.awt.BorderLayout.PAGE_START);

        jpTablaMultaA.setOpaque(false);
        jpTablaMultaA.setLayout(new java.awt.GridBagLayout());

        jtTablaPrestamoA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaPrestamoA.setDefaultEditor(Object.class, null);
        jtTablaMultaA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaMultaA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# EJEMPLAR", "ISBN", "TITULO", "# USUARIO", "VALOR", "DESCRIPCION", "FECHA MULTA"
                }
        ));
        jtTablaMultaA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaMultaA.getTableHeader().setResizingAllowed(false);
        jtTablaMultaA.getTableHeader().setReorderingAllowed(false);
        jspTablaMultaA.setViewportView(jtTablaMultaA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaMultaA.add(jspTablaMultaA, gridBagConstraints);

        jpMultaAdmin.add(jpTablaMultaA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpMultaAdmin, "jpMultaAdmin");

        jpSolicitudAdmin.setOpaque(false);
        jpSolicitudAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioSolicitudA.setOpaque(false);
        jpFormularioSolicitudA.setLayout(new java.awt.GridBagLayout());

        lblTituloSolicitudA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloSolicitudA.setText("SOLICITUDES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioSolicitudA.add(lblTituloSolicitudA, gridBagConstraints);

        jpSolicitudAdmin.add(jpFormularioSolicitudA, java.awt.BorderLayout.PAGE_START);

        jpTablaSolicitudA.setOpaque(false);
        jpTablaSolicitudA.setLayout(new java.awt.GridBagLayout());

        jtTablaPrestamoA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaPrestamoA.setDefaultEditor(Object.class, null);
        jtTablaSolicitudA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaSolicitudA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# SOLICITUD", "ISBN", "TITULO", "DESCRIPCION"
                }
        ));
        jtTablaSolicitudA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaSolicitudA.getTableHeader().setResizingAllowed(false);
        jtTablaSolicitudA.getTableHeader().setReorderingAllowed(false);
        jspTablaSolicitudA.setViewportView(jtTablaSolicitudA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaSolicitudA.add(jspTablaSolicitudA, gridBagConstraints);

        jpSolicitudAdmin.add(jpTablaSolicitudA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpSolicitudAdmin, "jpSolicitudAdmin");

        jpEmpleadoAdmin.setOpaque(false);
        jpEmpleadoAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioEmpleadoA.setOpaque(false);
        jpFormularioEmpleadoA.setLayout(new java.awt.GridBagLayout());

        lblTituloEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloEmpleadoA.setText("EMPLEADOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioEmpleadoA.add(lblTituloEmpleadoA, gridBagConstraints);

        lblCedulaEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaEmpleadoA.setText("CEDULA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblCedulaEmpleadoA, gridBagConstraints);

        txtCedulaEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtCedulaEmpleadoA, gridBagConstraints);

        lblTelefonoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTelefonoEmpleadoA.setText("TELEFONO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblTelefonoEmpleadoA, gridBagConstraints);

        txtTelefonoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtTelefonoEmpleadoA, gridBagConstraints);

        lblNombreEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombreEmpleadoA.setText("NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblNombreEmpleadoA, gridBagConstraints);

        txtNombreEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtNombreEmpleadoA, gridBagConstraints);

        lblCargoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCargoEmpleadoA.setText("CARGO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 180, 0, 0);
        jpFormularioEmpleadoA.add(lblCargoEmpleadoA, gridBagConstraints);

        txtCargoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpFormularioEmpleadoA.add(txtCargoEmpleadoA, gridBagConstraints);

        btnEliminarEmpleadoA.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminarEmpleadoA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarEmpleadoA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEmpleadoA.setText("ELIMINAR");
        btnEliminarEmpleadoA.setBorderPainted(false);
        btnEliminarEmpleadoA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 20);
        jpFormularioEmpleadoA.add(btnEliminarEmpleadoA, gridBagConstraints);

        btnModificarEmpleadoA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarEmpleadoA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarEmpleadoA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarEmpleadoA.setText("MODIFICAR");
        btnModificarEmpleadoA.setBorderPainted(false);
        btnModificarEmpleadoA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioEmpleadoA.add(btnModificarEmpleadoA, gridBagConstraints);

        btnAgregarEmpleadoA.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregarEmpleadoA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarEmpleadoA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEmpleadoA.setText("AGREGAR");
        btnAgregarEmpleadoA.setBorderPainted(false);
        btnAgregarEmpleadoA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jpFormularioEmpleadoA.add(btnAgregarEmpleadoA, gridBagConstraints);

        lblDireccionEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDireccionEmpleadoA.setText("DIRECCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblDireccionEmpleadoA, gridBagConstraints);

        txtDireccionEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtDireccionEmpleadoA, gridBagConstraints);

        lblClaveEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblClaveEmpleadoA.setText("CLAVE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblClaveEmpleadoA, gridBagConstraints);

        txtClaveEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtClaveEmpleadoA, gridBagConstraints);

        lblCorreoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCorreoEmpleadoA.setText("CORREO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioEmpleadoA.add(lblCorreoEmpleadoA, gridBagConstraints);

        txtCorreoEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpFormularioEmpleadoA.add(txtCorreoEmpleadoA, gridBagConstraints);

        jpEmpleadoAdmin.add(jpFormularioEmpleadoA, java.awt.BorderLayout.PAGE_START);

        jpTablaEmpleadoA.setOpaque(false);
        jpTablaEmpleadoA.setLayout(new java.awt.GridBagLayout());

        jtTablaPrestamoA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaPrestamoA.setDefaultEditor(Object.class, null);
        jtTablaEmpleadoA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaEmpleadoA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "CEDULA", "NOMBRE", "EMAIL", "CLAVE", "DIRECCION", "TELEFONO", "CARGO"
                }
        ));
        jtTablaEmpleadoA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaEmpleadoA.getTableHeader().setResizingAllowed(false);
        jtTablaEmpleadoA.getTableHeader().setReorderingAllowed(false);
        jspTablaEmpleadoA.setViewportView(jtTablaEmpleadoA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaEmpleadoA.add(jspTablaEmpleadoA, gridBagConstraints);

        jpEmpleadoAdmin.add(jpTablaEmpleadoA, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpEmpleadoAdmin, "jpEmpleadoAdmin");

        jpUsuarioAdmin.setOpaque(false);
        jpUsuarioAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioUsuarioA.setOpaque(false);
        jpFormularioUsuarioA.setLayout(new java.awt.GridBagLayout());

        lblTituloUsuarioA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloUsuarioA.setText("USUARIOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioUsuarioA.add(lblTituloUsuarioA, gridBagConstraints);

        jpUsuarioAdmin.add(jpFormularioUsuarioA, java.awt.BorderLayout.PAGE_START);

        jpTablaEmpleadoA1.setOpaque(false);
        jpTablaEmpleadoA1.setLayout(new java.awt.GridBagLayout());

        jtTablaPrestamoA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaPrestamoA.setDefaultEditor(Object.class, null);
        jtTablaUsuarioA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaUsuarioA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "CEDULA", "NOMBRE", "EMAIL", "DIRECCION", "TELEFONO"
                }
        ));
        jtTablaUsuarioA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaUsuarioA.getTableHeader().setResizingAllowed(false);
        jtTablaUsuarioA.getTableHeader().setReorderingAllowed(false);
        jspTablaUsuarioA.setViewportView(jtTablaUsuarioA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaEmpleadoA1.add(jspTablaUsuarioA, gridBagConstraints);

        jpUsuarioAdmin.add(jpTablaEmpleadoA1, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpUsuarioAdmin, "jpUsuarioAdmin");

        jpPerfilUsuarioE.setOpaque(false);
        jpPerfilUsuarioE.setLayout(new java.awt.GridBagLayout());

        lblTituloUsuarioPE.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloUsuarioPE.setText("USUARIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpPerfilUsuarioE.add(lblTituloUsuarioPE, gridBagConstraints);

        lblCedulaEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaEstudianteP.setText("CEDULA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpPerfilUsuarioE.add(lblCedulaEstudianteP, gridBagConstraints);

        txtCedulaEstudianteP.setEditable(false);
        txtCedulaEstudianteP.setColumns(5);
        txtCedulaEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtCedulaEstudianteP, gridBagConstraints);

        lblTelefonoEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTelefonoEstudianteP.setText("TELEFONO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblTelefonoEstudianteP, gridBagConstraints);

        txtTelefonoEstudianteP.setColumns(5);
        txtTelefonoEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtTelefonoEstudianteP, gridBagConstraints);

        lblNombreEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombreEstudianteP.setText("NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblNombreEstudianteP, gridBagConstraints);

        txtNombreEstudianteP.setColumns(5);
        txtNombreEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtNombreEstudianteP, gridBagConstraints);

        lblCarreraEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCarreraEstudianteP.setText("CARRERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblCarreraEstudianteP, gridBagConstraints);

        txtCarreraEstudianteP.setColumns(5);
        txtCarreraEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpPerfilUsuarioE.add(txtCarreraEstudianteP, gridBagConstraints);

        lblDireccionEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDireccionEstudianteP.setText("DIRECCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblDireccionEstudianteP, gridBagConstraints);

        txtDireccionEstudianteP.setColumns(5);
        txtDireccionEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtDireccionEstudianteP, gridBagConstraints);

        lblClaveEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblClaveEstudianteP.setText("CLAVE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpPerfilUsuarioE.add(lblClaveEstudianteP, gridBagConstraints);

        txtClaveEstudianteP.setColumns(5);
        txtClaveEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtClaveEstudianteP, gridBagConstraints);

        lblUniversidadEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblUniversidadEstudianteP.setText("UNIVERSIDAD");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblUniversidadEstudianteP, gridBagConstraints);

        txtUniversidadEstudianteP.setColumns(5);
        txtUniversidadEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpPerfilUsuarioE.add(txtUniversidadEstudianteP, gridBagConstraints);

        lblCorreoEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCorreoEstudianteP.setText("CORREO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioE.add(lblCorreoEstudianteP, gridBagConstraints);

        txtCorreoEstudianteP.setColumns(5);
        txtCorreoEstudianteP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioE.add(txtCorreoEstudianteP, gridBagConstraints);

        btnModificarPerfilE.setBackground(new java.awt.Color(255, 0, 0));
        btnModificarPerfilE.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarPerfilE.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarPerfilE.setText("MODIFICAR");
        btnModificarPerfilE.setBorderPainted(false);
        btnModificarPerfilE.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpPerfilUsuarioE.add(btnModificarPerfilE, gridBagConstraints);

        jpContenido.add(jpPerfilUsuarioE, "perfilEstudiante");

        jpPerfilUsuarioP.setOpaque(false);
        jpPerfilUsuarioP.setLayout(new java.awt.GridBagLayout());

        lblTituloUsuarioPP.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloUsuarioPP.setText("USUARIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpPerfilUsuarioP.add(lblTituloUsuarioPP, gridBagConstraints);

        lblCedulaProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaProfesorP.setText("CEDULA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpPerfilUsuarioP.add(lblCedulaProfesorP, gridBagConstraints);

        txtCedulaProfesorP.setEditable(false);
        txtCedulaProfesorP.setColumns(5);
        txtCedulaProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtCedulaProfesorP, gridBagConstraints);

        lblTelefonoProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTelefonoProfesorP.setText("TELEFONO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblTelefonoProfesorP, gridBagConstraints);

        txtTelefonoProfesorP.setColumns(5);
        txtTelefonoProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtTelefonoProfesorP, gridBagConstraints);

        lblNombreProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombreProfesorP.setText("NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblNombreProfesorP, gridBagConstraints);

        txtNombreProfesorP.setColumns(5);
        txtNombreProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtNombreProfesorP, gridBagConstraints);

        lblTituloProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTituloProfesorP.setText("TITULO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblTituloProfesorP, gridBagConstraints);

        txtTituloProfesorP.setColumns(5);
        txtTituloProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpPerfilUsuarioP.add(txtTituloProfesorP, gridBagConstraints);

        lblDireccionProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDireccionProfesorP.setText("DIRECCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblDireccionProfesorP, gridBagConstraints);

        txtDireccionProfesorP.setColumns(5);
        txtDireccionProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtDireccionProfesorP, gridBagConstraints);

        lblClaveProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblClaveProfesorP.setText("CLAVE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jpPerfilUsuarioP.add(lblClaveProfesorP, gridBagConstraints);

        txtClaveProfesorP.setColumns(5);
        txtClaveProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtClaveProfesorP, gridBagConstraints);

        lblDependenciaProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDependenciaProfesorP.setText("DEPENDENCIA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblDependenciaProfesorP, gridBagConstraints);

        txtDependenciaProfesorP.setColumns(5);
        txtDependenciaProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        jpPerfilUsuarioP.add(txtDependenciaProfesorP, gridBagConstraints);

        lblCorreoProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCorreoProfesorP.setText("CORREO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpPerfilUsuarioP.add(lblCorreoProfesorP, gridBagConstraints);

        txtCorreoProfesorP.setColumns(5);
        txtCorreoProfesorP.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        jpPerfilUsuarioP.add(txtCorreoProfesorP, gridBagConstraints);

        btnModificarPerfilP.setBackground(new java.awt.Color(255, 0, 0));
        btnModificarPerfilP.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarPerfilP.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarPerfilP.setText("MODIFICAR");
        btnModificarPerfilP.setBorderPainted(false);
        btnModificarPerfilP.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpPerfilUsuarioP.add(btnModificarPerfilP, gridBagConstraints);

        jpContenido.add(jpPerfilUsuarioP, "perfilProfesor");

        jpPrestamoEmpleado.setOpaque(false);
        jpPrestamoEmpleado.setLayout(new java.awt.BorderLayout());

        jpFormularioPrestamoE.setOpaque(false);
        jpFormularioPrestamoE.setLayout(new java.awt.GridBagLayout());

        lblTituloPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloPrestamoE.setText("PRESTAMOS");
        lblTituloPrestamoE.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioPrestamoE.add(lblTituloPrestamoE, gridBagConstraints);

        lblIsbnPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnPrestamoE.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 5, 0);
        jpFormularioPrestamoE.add(lblIsbnPrestamoE, gridBagConstraints);

        txtIsbnPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 20, 20);
        jpFormularioPrestamoE.add(txtIsbnPrestamoE, gridBagConstraints);

        btnAgregarLibroE.setBackground(new java.awt.Color(255, 0, 51));
        btnAgregarLibroE.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarLibroE.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarLibroE.setText("AGREGAR");
        btnAgregarLibroE.setBorderPainted(false);
        btnAgregarLibroE.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        jpFormularioPrestamoE.add(btnAgregarLibroE, gridBagConstraints);

        lblNumeroEjemplarPreE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumeroEjemplarPreE.setText("# EJEMPLAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 5, 20);
        jpFormularioPrestamoE.add(lblNumeroEjemplarPreE, gridBagConstraints);

        txtNumeroEjemplarPreE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 20, 20);
        jpFormularioPrestamoE.add(txtNumeroEjemplarPreE, gridBagConstraints);

        lblCedulaPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaPrestamoE.setText("CEDULA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 140, 5, 20);
        jpFormularioPrestamoE.add(lblCedulaPrestamoE, gridBagConstraints);

        txtCedulaPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jpFormularioPrestamoE.add(txtCedulaPrestamoE, gridBagConstraints);

        lblFechaRPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblFechaRPrestamoE.setText("FECHA REALIZACION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioPrestamoE.add(lblFechaRPrestamoE, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioPrestamoE.add(jdFechaRPrestamoE, gridBagConstraints);

        lblFechaDPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblFechaDPrestamoE.setText("FECHA DEVOLUCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioPrestamoE.add(lblFechaDPrestamoE, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioPrestamoE.add(jdFechaDPrestamoE, gridBagConstraints);

        jpTablaLibroPreE.setOpaque(false);
        jpTablaLibroPreE.setLayout(new java.awt.GridBagLayout());

        jspTablaLibroPreE.setOpaque(false);
        jspTablaLibroPreE.setPreferredSize(new java.awt.Dimension(452, 200));

        jtTablaLibroPreE.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaLibroPreE.setDefaultEditor(Object.class, null);
        jtTablaLibroPreE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaLibroPreE.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String [] {
                        "ISBN", "# EJEMPLAR", "FECHA DEVOLUCION"
                }
        ));
        jtTablaLibroPreE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaLibroPreE.getTableHeader().setResizingAllowed(false);
        jtTablaLibroPreE.getTableHeader().setReorderingAllowed(false);
        jspTablaLibroPreE.setViewportView(jtTablaLibroPreE);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jpTablaLibroPreE.add(jspTablaLibroPreE, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpFormularioPrestamoE.add(jpTablaLibroPreE, gridBagConstraints);

        btnBorrarPrestamoE.setBackground(new java.awt.Color(255, 0, 0));
        btnBorrarPrestamoE.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnBorrarPrestamoE.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarPrestamoE.setText("CANCELAR");
        btnBorrarPrestamoE.setBorderPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 60);
        jpFormularioPrestamoE.add(btnBorrarPrestamoE, gridBagConstraints);

        btnPrestarPrestamoE.setBackground(new java.awt.Color(255, 0, 0));
        btnPrestarPrestamoE.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnPrestarPrestamoE.setForeground(new java.awt.Color(255, 255, 255));
        btnPrestarPrestamoE.setText("PRESTAR");
        btnPrestarPrestamoE.setBorderPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 60, 0, 0);
        jpFormularioPrestamoE.add(btnPrestarPrestamoE, gridBagConstraints);

        jpPrestamoEmpleado.add(jpFormularioPrestamoE, java.awt.BorderLayout.PAGE_START);

        jpTablaPrestamoE.setOpaque(false);
        jpTablaPrestamoE.setLayout(new java.awt.GridBagLayout());

        jtTablaLibroU.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaLibroU.setDefaultEditor(Object.class, null);
        jtTablaPrestamoE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaPrestamoE.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "ISBN", "# EJEMPLAR", "TITULO", "AUTOR", "EDITORIAL", "PUBLICACION", "IDIOMA", "# PAGINAS"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaPrestamoE.getTableHeader().setResizingAllowed(false);
        jtTablaPrestamoE.getTableHeader().setReorderingAllowed(false);
        jpsTablaPrestamoE.setViewportView(jtTablaPrestamoE);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaPrestamoE.add(jpsTablaPrestamoE, gridBagConstraints);

        jpPrestamoEmpleado.add(jpTablaPrestamoE, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpPrestamoEmpleado, "jpPrestamoEmpleado");

        jpDevolucionEmpleado.setOpaque(false);
        jpDevolucionEmpleado.setLayout(new java.awt.BorderLayout());

        jpFormularioDevolucionE.setOpaque(false);
        jpFormularioDevolucionE.setLayout(new java.awt.GridBagLayout());

        lblTituloDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloDevolucionE.setText("DEVOLUCIONES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioDevolucionE.add(lblTituloDevolucionE, gridBagConstraints);

        lblIsbnDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnDevolucionE.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 220);
        jpFormularioDevolucionE.add(lblIsbnDevolucionE, gridBagConstraints);

        txtIsbnDevolucionE.setColumns(4);
        txtIsbnDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jpFormularioDevolucionE.add(txtIsbnDevolucionE, gridBagConstraints);

        btnDevolverLibroE.setBackground(new java.awt.Color(255, 0, 51));
        btnDevolverLibroE.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnDevolverLibroE.setForeground(new java.awt.Color(255, 255, 255));
        btnDevolverLibroE.setText("DEVOLVER");
        btnDevolverLibroE.setBorderPainted(false);
        btnDevolverLibroE.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        jpFormularioDevolucionE.add(btnDevolverLibroE, gridBagConstraints);

        lblNumeroEjemplarDevE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumeroEjemplarDevE.setText("# EJEMPLAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 20);
        jpFormularioDevolucionE.add(lblNumeroEjemplarDevE, gridBagConstraints);

        txtNumeroEjemplarDevE.setColumns(4);
        txtNumeroEjemplarDevE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioDevolucionE.add(txtNumeroEjemplarDevE, gridBagConstraints);

        lblCedulaUDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaUDevolucionE.setText("CEDULA USUARIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 20);
        jpFormularioDevolucionE.add(lblCedulaUDevolucionE, gridBagConstraints);

        txtCedulaUDevolucionE.setColumns(4);
        txtCedulaUDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioDevolucionE.add(txtCedulaUDevolucionE, gridBagConstraints);

        lblCedulaEDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblCedulaEDevolucionE.setText("CEDULA EMPLEADO");
        lblCedulaEDevolucionE.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioDevolucionE.add(lblCedulaEDevolucionE, gridBagConstraints);

        lblNumeroPrestamoDevE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumeroPrestamoDevE.setText("# PRESTAMO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioDevolucionE.add(lblNumeroPrestamoDevE, gridBagConstraints);

        txtCedulaEDevolucionE.setColumns(4);
        txtCedulaEDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioDevolucionE.add(txtCedulaEDevolucionE, gridBagConstraints);

        txtNumeroPrestamoDevE.setColumns(4);
        txtNumeroPrestamoDevE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioDevolucionE.add(txtNumeroPrestamoDevE, gridBagConstraints);

        jpDevolucionEmpleado.add(jpFormularioDevolucionE, java.awt.BorderLayout.PAGE_START);

        jpTablaDevolucionE.setOpaque(false);
        jpTablaDevolucionE.setLayout(new java.awt.GridBagLayout());

        jtTablaLibroU.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaLibroU.setDefaultEditor(Object.class, null);
        jtTablaDevolucionE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaDevolucionE.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# PRESTAMO", "ISBN", "# EJEMPLAR", "# CEDULA", "# EMPLEADO", "FECHA REALIZACION", "FECHA DEVOLUCION"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaDevolucionE.getTableHeader().setResizingAllowed(false);
        jtTablaDevolucionE.getTableHeader().setReorderingAllowed(false);
        jpsTablaDevolucionE.setViewportView(jtTablaDevolucionE);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaDevolucionE.add(jpsTablaDevolucionE, gridBagConstraints);

        jpDevolucionEmpleado.add(jpTablaDevolucionE, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpDevolucionEmpleado, "jpDevolucionEmpleado");

        jpSolicitudEmpleado.setOpaque(false);
        jpSolicitudEmpleado.setLayout(new java.awt.BorderLayout());

        jpFormularioSolicitudE.setOpaque(false);
        jpFormularioSolicitudE.setLayout(new java.awt.GridBagLayout());

        lblTituloSolicitudE.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloSolicitudE.setText("SOLICITUDES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioSolicitudE.add(lblTituloSolicitudE, gridBagConstraints);

        jpSolicitudEmpleado.add(jpFormularioSolicitudE, java.awt.BorderLayout.PAGE_START);

        jpTablaSolicitudE.setOpaque(false);
        jpTablaSolicitudE.setLayout(new java.awt.GridBagLayout());

        jtTablaPrestamoA.getTableHeader().setFont(new java.awt.Font("Montserrat", 0
                , 12));
        jtTablaPrestamoA.setDefaultEditor(Object.class, null);
        jtTablaSolicitudE.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaSolicitudE.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# SOLICITUD", "ISBN", "TITULO", "DESCRIPCION"
                }
        ));
        jtTablaSolicitudE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaSolicitudE.getTableHeader().setResizingAllowed(false);
        jtTablaSolicitudE.getTableHeader().setReorderingAllowed(false);
        jspTablaSolicitudE.setViewportView(jtTablaSolicitudE);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaSolicitudE.add(jspTablaSolicitudE, gridBagConstraints);

        jpSolicitudEmpleado.add(jpTablaSolicitudE, java.awt.BorderLayout.CENTER);

        jpContenido.add(jpSolicitudEmpleado, "jpSolicitudEmpleado");

        tabLibroAdmin.setBackground(new java.awt.Color(249, 250, 252));
        tabLibroAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabLibroAdmin.setFocusable(false);
        tabLibroAdmin.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tabLibroAdmin.setOpaque(true);

        jpLibroAdmin.setBackground(new java.awt.Color(249, 250, 252));
        jpLibroAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioLibroA.setOpaque(false);
        jpFormularioLibroA.setLayout(new java.awt.GridBagLayout());

        lblTituloLibrosA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloLibrosA.setText("LIBROS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioLibroA.add(lblTituloLibrosA, gridBagConstraints);

        lblIsbnLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnLibroA.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioLibroA.add(lblIsbnLibroA, gridBagConstraints);

        txtIsbnLibroA.setColumns(5);
        txtIsbnLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioLibroA.add(txtIsbnLibroA, gridBagConstraints);

        btnAgregarLibroA.setBackground(new java.awt.Color(255, 0, 51));
        btnAgregarLibroA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarLibroA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarLibroA.setText("AGREGAR");
        btnAgregarLibroA.setBorderPainted(false);
        btnAgregarLibroA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jpFormularioLibroA.add(btnAgregarLibroA, gridBagConstraints);

        lblEditorialLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblEditorialLibroA.setText("EDITORIAL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioLibroA.add(lblEditorialLibroA, gridBagConstraints);

        txtEditorialLibroA.setColumns(5);
        txtEditorialLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioLibroA.add(txtEditorialLibroA, gridBagConstraints);

        lblNumPaginasLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumPaginasLibroA.setText("# PAGINAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioLibroA.add(lblNumPaginasLibroA, gridBagConstraints);

        txtNumPaginasLibroA.setColumns(5);
        txtNumPaginasLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioLibroA.add(txtNumPaginasLibroA, gridBagConstraints);

        lblIdiomaLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIdiomaLibroA.setText("IDIOMA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioLibroA.add(lblIdiomaLibroA, gridBagConstraints);

        txtIdiomaLibroA.setColumns(5);
        txtIdiomaLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioLibroA.add(txtIdiomaLibroA, gridBagConstraints);

        lblAnoPublicLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblAnoPublicLibroA.setText("AÑO PUBLICACION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioLibroA.add(lblAnoPublicLibroA, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioLibroA.add(jyAnoPublicLibroA, gridBagConstraints);

        btnModificarLibroA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarLibroA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarLibroA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarLibroA.setText("MODIFICAR");
        btnModificarLibroA.setBorderPainted(false);
        btnModificarLibroA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        jpFormularioLibroA.add(btnModificarLibroA, gridBagConstraints);

        btnEliminarLibroA.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminarLibroA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarLibroA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarLibroA.setText("ELIMINAR");
        btnEliminarLibroA.setBorderPainted(false);
        btnEliminarLibroA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        jpFormularioLibroA.add(btnEliminarLibroA, gridBagConstraints);

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jpFormularioLibroA.add(jSeparator2, gridBagConstraints);

        jpTablaAutorLibroA.setLayout(new java.awt.GridBagLayout());

        jspTablaAutorLibroA.setPreferredSize(new java.awt.Dimension(200, 160));

        jtTablaAutorLibroA.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaAutorLibroA.setDefaultEditor(Object.class, null);
        jtTablaAutorLibroA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "# AUTOR", "NOMBRE"
                }
        ));
        jtTablaAutorLibroA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaAutorLibroA.getTableHeader().setResizingAllowed(false);
        jtTablaAutorLibroA.getTableHeader().setReorderingAllowed(false);
        jspTablaAutorLibroA.setViewportView(jtTablaAutorLibroA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jpTablaAutorLibroA.add(jspTablaAutorLibroA, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpFormularioLibroA.add(jpTablaAutorLibroA, gridBagConstraints);

        txtAutorLibroA.setColumns(5);
        txtAutorLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtAutorLibroA.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 0);
        jpFormularioLibroA.add(txtAutorLibroA, gridBagConstraints);

        lblAutorLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblAutorLibroA.setText("AUTOR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioLibroA.add(lblAutorLibroA, gridBagConstraints);

        btnAgregarAutorLibroA.setBackground(new java.awt.Color(255, 0, 51));
        btnAgregarAutorLibroA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarAutorLibroA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAutorLibroA.setText("AGREGAR");
        btnAgregarAutorLibroA.setBorderPainted(false);
        btnAgregarAutorLibroA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpFormularioLibroA.add(btnAgregarAutorLibroA, gridBagConstraints);

        btnEliminarAutorLibroA.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminarAutorLibroA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarAutorLibroA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAutorLibroA.setText("ELIMINAR");
        btnEliminarAutorLibroA.setBorderPainted(false);
        btnEliminarAutorLibroA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jpFormularioLibroA.add(btnEliminarAutorLibroA, gridBagConstraints);

        lblTituloLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblTituloLibroA.setText("TITULO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioLibroA.add(lblTituloLibroA, gridBagConstraints);

        txtTituloLibroA.setColumns(5);
        txtTituloLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioLibroA.add(txtTituloLibroA, gridBagConstraints);

        jpLibroAdmin.add(jpFormularioLibroA, java.awt.BorderLayout.PAGE_START);

        jpTablaLibroA.setOpaque(false);
        jpTablaLibroA.setLayout(new java.awt.GridBagLayout());

        jtTablaLibroU.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaLibroU.setDefaultEditor(Object.class, null);
        jtTablaLibroA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaLibroA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "ISBN", "TITULO", "AUTOR", "EDITORIAL", "PUBLICACION", "IDIOMA", "# PAGINAS", "EJEMPLARES", "DIGITAL"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaLibroA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaLibroA.getTableHeader().setResizingAllowed(false);
        jtTablaLibroA.getTableHeader().setReorderingAllowed(false);
        jpsTablaLibroA.setViewportView(jtTablaLibroA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaLibroA.add(jpsTablaLibroA, gridBagConstraints);

        jpLibroAdmin.add(jpTablaLibroA, java.awt.BorderLayout.CENTER);

        tabLibroAdmin.addTab("LIBROS", jpLibroAdmin);

        jpEjemplarAdmin.setBackground(new java.awt.Color(249, 250, 252));
        jpEjemplarAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioEjemplarA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpFormularioEjemplarA.setOpaque(false);
        jpFormularioEjemplarA.setLayout(new java.awt.GridBagLayout());

        lblTituloEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloEjemplarA.setText("EJEMPLARES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioEjemplarA.add(lblTituloEjemplarA, gridBagConstraints);

        lblIsbnEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnEjemplarA.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioEjemplarA.add(lblIsbnEjemplarA, gridBagConstraints);

        txtIsbnEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioEjemplarA.add(txtIsbnEjemplarA, gridBagConstraints);

        btnAgregarEjemplarA.setBackground(new java.awt.Color(255, 0, 51));
        btnAgregarEjemplarA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarEjemplarA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEjemplarA.setText("AGREGAR");
        btnAgregarEjemplarA.setBorderPainted(false);
        btnAgregarEjemplarA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jpFormularioEjemplarA.add(btnAgregarEjemplarA, gridBagConstraints);

        lblEstanteEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblEstanteEjemplarA.setText("ESTANTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioEjemplarA.add(lblEstanteEjemplarA, gridBagConstraints);

        txtEstanteEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioEjemplarA.add(txtEstanteEjemplarA, gridBagConstraints);

        lblNomSalaEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNomSalaEjemplarA.setText("NOMBRE SALA");
        lblNomSalaEjemplarA.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioEjemplarA.add(lblNomSalaEjemplarA, gridBagConstraints);

        txtNomSalaEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioEjemplarA.add(txtNomSalaEjemplarA, gridBagConstraints);

        lblNumCajonEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumCajonEjemplarA.setText("# CAJON");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioEjemplarA.add(lblNumCajonEjemplarA, gridBagConstraints);

        txtNumCajonEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioEjemplarA.add(txtNumCajonEjemplarA, gridBagConstraints);

        lblNumPasilloEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNumPasilloEjemplarA.setText("# PASILLO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpFormularioEjemplarA.add(lblNumPasilloEjemplarA, gridBagConstraints);

        btnModificarEjemplarA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarEjemplarA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarEjemplarA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarEjemplarA.setText("MODIFICAR");
        btnModificarEjemplarA.setBorderPainted(false);
        btnModificarEjemplarA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        jpFormularioEjemplarA.add(btnModificarEjemplarA, gridBagConstraints);

        btnEliminarEjemplarA.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminarEjemplarA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarEjemplarA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEjemplarA.setText("ELIMINAR");
        btnEliminarEjemplarA.setBorderPainted(false);
        btnEliminarEjemplarA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        jpFormularioEjemplarA.add(btnEliminarEjemplarA, gridBagConstraints);

        txtNumPasilloEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jpFormularioEjemplarA.add(txtNumPasilloEjemplarA, gridBagConstraints);

        txtNumEjemplarA.setVisible(false);
        txtNumEjemplarA.setEditable(false);
        txtNumEjemplarA.setText("0");
        txtNumEjemplarA.setEnabled(false);
        txtNumEjemplarA.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jpFormularioEjemplarA.add(txtNumEjemplarA, gridBagConstraints);

        jpEjemplarAdmin.add(jpFormularioEjemplarA, java.awt.BorderLayout.PAGE_START);

        jpTablaEjemplarA.setOpaque(false);
        jpTablaEjemplarA.setLayout(new java.awt.GridBagLayout());

        jtTablaLibroU.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaLibroU.setDefaultEditor(Object.class, null);
        jtTablaEjemplarA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaEjemplarA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# EJEMPLAR", "ISBN", "ESTANTE", "# CAJON", "NOMBRE SALA", "# PASILLO"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaEjemplarA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaEjemplarA.getTableHeader().setResizingAllowed(false);
        jtTablaEjemplarA.getTableHeader().setReorderingAllowed(false);
        jpsTablaEjemplarA.setViewportView(jtTablaEjemplarA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaEjemplarA.add(jpsTablaEjemplarA, gridBagConstraints);

        jpEjemplarAdmin.add(jpTablaEjemplarA, java.awt.BorderLayout.CENTER);

        tabLibroAdmin.addTab("EJEMPLARES", jpEjemplarAdmin);

        jpDigitalAdmin.setBackground(new java.awt.Color(249, 250, 252));
        jpDigitalAdmin.setLayout(new java.awt.BorderLayout());

        jpFormularioDigitalA.setOpaque(false);
        jpFormularioDigitalA.setLayout(new java.awt.GridBagLayout());

        lblTituloDigitalA.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblTituloDigitalA.setText("DIGITALES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        jpFormularioDigitalA.add(lblTituloDigitalA, gridBagConstraints);

        lblIsbnDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblIsbnDigitalA.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioDigitalA.add(lblIsbnDigitalA, gridBagConstraints);

        txtIsbnDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioDigitalA.add(txtIsbnDigitalA, gridBagConstraints);

        btnAgregarDigitalA.setBackground(new java.awt.Color(255, 0, 51));
        btnAgregarDigitalA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAgregarDigitalA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarDigitalA.setText("AGREGAR");
        btnAgregarDigitalA.setBorderPainted(false);
        btnAgregarDigitalA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jpFormularioDigitalA.add(btnAgregarDigitalA, gridBagConstraints);

        lblUrlDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblUrlDigitalA.setText("URL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioDigitalA.add(lblUrlDigitalA, gridBagConstraints);

        txtUrlDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioDigitalA.add(txtUrlDigitalA, gridBagConstraints);

        lblBytesDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblBytesDigitalA.setText("BYTES");
        lblBytesDigitalA.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 0);
        jpFormularioDigitalA.add(lblBytesDigitalA, gridBagConstraints);

        txtBytesDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioDigitalA.add(txtBytesDigitalA, gridBagConstraints);

        lblFormatoDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblFormatoDigitalA.setText("FORMATO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jpFormularioDigitalA.add(lblFormatoDigitalA, gridBagConstraints);

        txtFormatoDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        jpFormularioDigitalA.add(txtFormatoDigitalA, gridBagConstraints);

        btnModificarDigitalA.setBackground(new java.awt.Color(255, 0, 51));
        btnModificarDigitalA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnModificarDigitalA.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarDigitalA.setText("MODIFICAR");
        btnModificarDigitalA.setBorderPainted(false);
        btnModificarDigitalA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        jpFormularioDigitalA.add(btnModificarDigitalA, gridBagConstraints);

        btnEliminarDigitalA.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminarDigitalA.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEliminarDigitalA.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarDigitalA.setText("ELIMINAR");
        btnEliminarDigitalA.setBorderPainted(false);
        btnEliminarDigitalA.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        jpFormularioDigitalA.add(btnEliminarDigitalA, gridBagConstraints);

        txtNumDigitalA.setVisible(false);
        txtNumDigitalA.setEditable(false);
        txtNumDigitalA.setText("0");
        txtNumDigitalA.setEnabled(false);
        txtNumDigitalA.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jpFormularioDigitalA.add(txtNumDigitalA, gridBagConstraints);

        jpDigitalAdmin.add(jpFormularioDigitalA, java.awt.BorderLayout.PAGE_START);

        jpTablaDigitalA.setOpaque(false);
        jpTablaDigitalA.setLayout(new java.awt.GridBagLayout());

        jtTablaLibroU.getTableHeader().setFont(new java.awt.Font("Montserrat",0, 12));
        jtTablaLibroU.setDefaultEditor(Object.class, null);
        jtTablaDigitalA.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jtTablaDigitalA.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "# DIGITAL", "ISBN", "URL", "FORMATO", "BYTES"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaDigitalA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTablaDigitalA.getTableHeader().setResizingAllowed(false);
        jtTablaDigitalA.getTableHeader().setReorderingAllowed(false);
        jpsTablaDigitalA.setViewportView(jtTablaDigitalA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jpTablaDigitalA.add(jpsTablaDigitalA, gridBagConstraints);

        jpDigitalAdmin.add(jpTablaDigitalA, java.awt.BorderLayout.CENTER);

        tabLibroAdmin.addTab("DIGITAL", jpDigitalAdmin);

        jpContenido.add(tabLibroAdmin, "jpLibroAdmin");

        getContentPane().add(jpContenido, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>*/

    public void menuUsuario()
    {
        CardLayout a = (CardLayout)jpMenu.getLayout();
        a.show(jpMenu, "jpMenuUsuario");
    }

    public void menuAdmin()
    {
        CardLayout a = (CardLayout)jpMenu.getLayout();
        a.show(jpMenu, "jpMenuAdmin");
    }

    public void menuEmpleado()
    {
        CardLayout a = (CardLayout)jpMenu.getLayout();
        a.show(jpMenu, "jpMenuEmpleado");
    }

    public void pagAreaAdmin()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpAreaAdmin");
    }

    public void pagEditorialAdmin()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpEditorialAdmin");
    }

    public void pagAutorAdmin()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpAutorAdmin");
    }

    public void pagPrestamoAdmin()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpPrestamoAdmin");
    }

    public void pagMultaAdmin()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpMultaAdmin");
    }

    public void pagSolicitudAdmin()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpSolicitudAdmin");
    }

    public void pagEmpleadoAdmin()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpEmpleadoAdmin");
    }

    public void pagUsuarioAdmin()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpUsuarioAdmin");
    }

    public void pagDescargaAdmin()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpDescargaAdmin");
    }

    public void pagMultaUsuario()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "multaUsuario");
    }

    public void pagSolicitudUsuario()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "solicitudUsuario");
    }

    public void pagPrestamoUsuario()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "prestamoUsuario");
    }

    public void pagLibroUsuario()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "libroUsuario");
    }

    public void pagPerfilEstudiante()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "perfilEstudiante");
    }

    public void pagPerfilProfesor()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "perfilProfesor");
    }

    public void pagPrestamoEmpleado()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpPrestamoEmpleado");
    }

    public void pagDevolucionEmpleado()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpDevolucionEmpleado");
    }

    public void pagSolicitudEmpleado()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpSolicitudEmpleado");
    }

    public void pagLibroAdmin()
    {
        CardLayout a = (CardLayout)jpContenido.getLayout();
        a.show(jpContenido, "jpLibroAdmin");
    }

    class CambiarPaginaUListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("multasUsuario"))
            {
                pagMultaUsuario();
            }
            if (e.getActionCommand().equalsIgnoreCase("solicitudUsuario"))
            {
                pagSolicitudUsuario();
            }
            if (e.getActionCommand().equalsIgnoreCase("prestamoUsuario"))
            {
                pagPrestamoUsuario();
            }
            if (e.getActionCommand().equalsIgnoreCase("libroUsuario"))
            {
                pagLibroUsuario();
            }
            limpiarSolicitudUsuario();
        }
    }

    class CambiarPaginaAListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("areaAdmin"))
            {
                pagAreaAdmin();
            }
            if (e.getActionCommand().equalsIgnoreCase("editorialAdmin"))
            {
                pagEditorialAdmin();
            }
            if (e.getActionCommand().equalsIgnoreCase("autorAdmin"))
            {
                pagAutorAdmin();
            }
            if (e.getActionCommand().equalsIgnoreCase("prestamoAdmin"))
            {
                pagPrestamoAdmin();
            }
            if (e.getActionCommand().equalsIgnoreCase("multaAdmin"))
            {
                pagMultaAdmin();
            }
            if (e.getActionCommand().equalsIgnoreCase("solicitudAdmin"))
            {
                pagSolicitudAdmin();
            }
            if (e.getActionCommand().equalsIgnoreCase("empleadoAdmin"))
            {
                pagEmpleadoAdmin();
            }
            if (e.getActionCommand().equalsIgnoreCase("usuarioAdmin"))
            {
                pagUsuarioAdmin();
            }
            if (e.getActionCommand().equalsIgnoreCase("descargaAdmin"))
            {
                pagDescargaAdmin();
            }
            if (e.getActionCommand().equalsIgnoreCase("libroAdmin"))
            {
                pagLibroAdmin();
            }
            limpiarAutorAdmin();
            limpiarAreaAdmin();
            limpiarEditorialAdmin();
            limpiarEmpleadoAdmin();
            limpiarLibroAdmin();
            limpiarAutorLibroAdmin();
            limpiarEjemplarAdmin();
            limpiarDigitalAdmin();
        }
    }

    class CambiarPaginaEListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("prestamoEmpleado"))
            {
                pagPrestamoEmpleado();
            }
            if (e.getActionCommand().equalsIgnoreCase("devolucionEmpleado"))
            {
                pagDevolucionEmpleado();
            }
            if (e.getActionCommand().equalsIgnoreCase("solicitudEmpleado"))
            {
                pagSolicitudEmpleado();
            }
            limpiarPrestamoEmpleado();
            limpiarDevolucionEmpleado();
        }
    }

    public void addBotonesMenuUListener(ActionListener listenControles)
    {
        btnMultasUsuario.addActionListener(listenControles);
        btnSolicitudUsuario.addActionListener(listenControles);
        btnPrestamosUsuario.addActionListener(listenControles);
        btnLibrosUsuario.addActionListener(listenControles);
    }

    public void addBotonesMenuAListener(ActionListener listenControles)
    {
        btnAreasAdmin.addActionListener(listenControles);
        btnEditorialesAdmin.addActionListener(listenControles);
        btnAutoresAdmin.addActionListener(listenControles);
        btnPrestamosAdmin.addActionListener(listenControles);
        btnMultasAdmin.addActionListener(listenControles);
        btnSolicitudAdmin.addActionListener(listenControles);
        btnEmpleadosAdmin.addActionListener(listenControles);
        btnDescargasAdmin.addActionListener(listenControles);
        btnUsuariosAdmin.addActionListener(listenControles);
        btnLibrosAdmin.addActionListener(listenControles);
    }

    public void addBotonesMenuEListener(ActionListener listenControles)
    {
        btnPrestamosEmpleado.addActionListener(listenControles);
        btnDevolucionesEmpleado.addActionListener(listenControles);
        btnSolicitudesEmpleado.addActionListener(listenControles);
    }

    public void addBotonesPerfilEsudianteListener(ActionListener listenControles)
    {
        btnModificarPerfilE.addActionListener(listenControles);
    }

    public void addBotonesPerfilProfesorListener(ActionListener listenControles)
    {
        btnModificarPerfilP.addActionListener(listenControles);
    }
    public void addBotonAgregarSolicitud(ActionListener listenControles)
    {
        btnEnviarSolicitudU.addActionListener(listenControles);
    }

    public void addBotonesEncabezadoListener(ActionListener listenControles)
    {
        btnUsuario.addActionListener(listenControles);
        btnCerrarSesion.addActionListener(listenControles);
    }

    public void addBotonesEmpleadoAdminListener(ActionListener listenControles)
    {
        btnAgregarEmpleadoA.addActionListener(listenControles);
        btnEliminarEmpleadoA.addActionListener(listenControles);
        btnModificarEmpleadoA.addActionListener(listenControles);
    }


    public void addBotonesAreaAdminListener(ActionListener listenControles)
    {
        btnAgregarAreaA.addActionListener(listenControles);
        btnModificarAreaA.addActionListener(listenControles);
        btnRelacionarAreaA.addActionListener(listenControles);
        btnEliminarAreaA.addActionListener(listenControles);
    }

    public void addBotonesAutorAdListener(ActionListener listenControles)
    {
        btnAgregarAutorA.addActionListener(listenControles);
        btnModificarAutorA.addActionListener(listenControles);
        btnEliminarAutorA.addActionListener(listenControles);
    }

    public void addBotonesEditorialAdListener(ActionListener listenControles)
    {
        btnAgregarEditorialA.addActionListener(listenControles);
        btnModificarEditorialA.addActionListener(listenControles);
        btnEliminarEditorialA.addActionListener(listenControles);
    }

    public void addBtnDevolucionListener(ActionListener listenControles)
    {
        btnDevolverLibroE.addActionListener(listenControles);
    }

    public void addBotonesPrestamoEmpListener(ActionListener listenControles)
    {
        btnPrestarPrestamoE.addActionListener(listenControles);
        btnBorrarPrestamoE.addActionListener(listenControles);
        btnAgregarLibroE.addActionListener(listenControles);
    }
    public void addBotonesLibroAdListener(ActionListener listenControles)
    {
        btnAgregarLibroA.addActionListener(listenControles);
        btnModificarLibroA.addActionListener(listenControles);
        btnEliminarLibroA.addActionListener(listenControles);
    }

    public void addBotonesLibroUListener(ActionListener listenControles)
    {
        btnDescargaLibroU.addActionListener(listenControles);
    }

    public void addBotonesEjemplarAdListener(ActionListener listenControles)
    {
        btnAgregarEjemplarA.addActionListener(listenControles);
        btnModificarEjemplarA.addActionListener(listenControles);
        btnEliminarEjemplarA.addActionListener(listenControles);
    }

    public void addBotonesDigitalAdListener(ActionListener listenControles)
    {
        btnAgregarDigitalA.addActionListener(listenControles);
        btnModificarDigitalA.addActionListener(listenControles);
        btnEliminarDigitalA.addActionListener(listenControles);
    }

    public void limpiarSolicitudUsuario()
    {
        txtIsbnSolicitudU.setText("");
        txtTituloSolicitudU.setText("");
        txaDescripcionSolicitudU.setText("");
    }

    public void limpiarAreaAdmin()
    {
        txtIdAreaA.setText("0");
        txtNombreAreaA.setText("");
        txtCodigoArea1A.setText("");
        txtCodigoArea2A.setText("");
        txaDescripcionAreaA.setText("");
        btnRelacionarAreaA.setEnabled(false);
    }

    public void limpiarEditorialAdmin()
    {
        txtIdEditorialA.setText("0");
        txtNombreEditorialA.setText("");
        txtPaisEditorialA.setText("");
        txtPaginaWebEditorialA.setText("");
    }

    public void limpiarAutorAdmin()
    {
        txtNombre1AutorA.setText("");
        txtNombre2AutorA.setText("");
        txtApellido1AutorA.setText("");
        txtApellido2AutorA.setText("");
    }

    public void limpiarEmpleadoAdmin()
    {
        txtCedulaEmpleadoA.setText("");
        txtNombreEmpleadoA.setText("");
        txtCorreoEmpleadoA.setText("");
        txtClaveEmpleadoA.setText("");
        txtDireccionEmpleadoA.setText("");
        txtTelefonoEmpleadoA.setText("");
        txtCargoEmpleadoA.setText("");
        txtCedulaEmpleadoA.setEditable(true);
        btnAgregarEmpleadoA.setEnabled(true);
    }

    public void limpiarLibroUsuario()
    {
        txtIsbnLibroU.setText("");
    }

    public void limpiarMultaUsuario()
    {
        txtNumeroMultaU.setText("");
    }

    public void limpiarPrestamoEmpleado()
    {
        txtIsbnPrestamoE.setText("");
        txtNumeroEjemplarPreE.setText("");
        txtCedulaPrestamoE.setText("");
        jdFechaRPrestamoE.setDate(null);
        jdFechaDPrestamoE.setDate(null);
    }

    public void limpiarDevolucionEmpleado()
    {
        txtIsbnDevolucionE.setText("");
        txtNumeroEjemplarDevE.setText("");
        txtCedulaUDevolucionE.setText("");
        txtCedulaEDevolucionE.setText("");
        txtNumeroPrestamoDevE.setText("");
    }

    public void limpiarLibroAdmin()
    {
        txtIsbnLibroA.setText("");
        txtEditorialLibroA.setText("");
        txtIdiomaLibroA.setText("");
        txtNumPaginasLibroA.setText("");
        jyAnoPublicLibroA.setYear(2023);
    }

    public void limpiarEjemplarAdmin()
    {
        txtNumEjemplarA.setText("0");
        txtIsbnEjemplarA.setText("");
        txtEstanteEjemplarA.setText("");
        txtNumPasilloEjemplarA.setText("");
        txtNomSalaEjemplarA.setText("");
        txtNumCajonEjemplarA.setText("");
    }

    public void limpiarDigitalAdmin()
    {
        txtIsbnDigitalA.setText("");
        txtUrlDigitalA.setText("");
        txtFormatoDigitalA.setText("");
        txtBytesDigitalA.setText("");
    }

    public void limpiarAutorLibroAdmin()
    {
        txtAutorLibroA.setText("");
    }

    class TablaAutorAListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                txtIdAutorA.setText("0");
                txtNombre1AutorA.setText("");
                txtNombre2AutorA.setText("");
                txtApellido1AutorA.setText("");
                txtApellido2AutorA.setText("");
            }
            else
            {
                limpiarAutorAdmin();
                txtIdAutorA.setText(String.valueOf(tabla.getValueAt(fila , 0)));
                txtNombre1AutorA.setText(String.valueOf(tabla.getValueAt(fila , 1)));
                txtNombre2AutorA.setText(String.valueOf(tabla.getValueAt(fila , 2)));
                txtApellido1AutorA.setText(String.valueOf(tabla.getValueAt(fila , 3)));
                txtApellido2AutorA.setText(String.valueOf(tabla.getValueAt(fila , 4)));
            }
        }
    }

    class TablaEditorialAListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                txtIdEditorialA.setText("0");
                txtNombreEditorialA.setText("");
                txtPaisEditorialA.setText("");
                txtPaginaWebEditorialA.setText("");
            }
            else
            {
                limpiarEditorialAdmin();
                txtIdEditorialA.setText(String.valueOf(tabla.getValueAt(fila , 0)));
                txtNombreEditorialA.setText(String.valueOf(tabla.getValueAt(fila , 1)));
                txtPaisEditorialA.setText(String.valueOf(tabla.getValueAt(fila , 2)));
                txtPaginaWebEditorialA.setText(String.valueOf(tabla.getValueAt(fila , 3)));
            }
        }
    }

    class TablaAreaAListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                btnRelacionarAreaA.setEnabled(false);

                txtIdAreaA.setText("0");
                txtNombreAreaA.setText("");
                txtCodigoArea1A.setText("");
                txaDescripcionAreaA.setText("");
            }
            else
            {
                limpiarAreaAdmin();
                txtIdAreaA.setText(String.valueOf(tabla.getValueAt(fila , 0)));
                txtCodigoArea1A.setText(String.valueOf(tabla.getValueAt(fila , 0)));
                txtNombreAreaA.setText(String.valueOf(tabla.getValueAt(fila , 1)));
                txaDescripcionAreaA.setText(String.valueOf(tabla.getValueAt(fila , 2)));

                btnRelacionarAreaA.setEnabled(true);
            }
        }
    }

    class TablaEmpleadoAListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                txtCedulaEmpleadoA.setEditable(true);
                btnAgregarEmpleadoA.setEnabled(true);

                txtCedulaEmpleadoA.setText("");
                txtNombreEmpleadoA.setText("");
                txtCorreoEmpleadoA.setText("");
                txtClaveEmpleadoA.setText("");
                txtDireccionEmpleadoA.setText("");
                txtTelefonoEmpleadoA.setText("");
                txtCargoEmpleadoA.setText("");
            }
            else
            {
                limpiarEmpleadoAdmin();
                txtCedulaEmpleadoA.setText(String.valueOf(tabla.getValueAt(fila , 0)));
                txtNombreEmpleadoA.setText(String.valueOf(tabla.getValueAt(fila , 1)));
                txtCorreoEmpleadoA.setText(String.valueOf(tabla.getValueAt(fila , 2)));
                txtClaveEmpleadoA.setText(String.valueOf(tabla.getValueAt(fila , 3)));
                txtDireccionEmpleadoA.setText(String.valueOf(tabla.getValueAt(fila , 4)));
                txtTelefonoEmpleadoA.setText(String.valueOf(tabla.getValueAt(fila , 5)));
                txtCargoEmpleadoA.setText(String.valueOf(tabla.getValueAt(fila , 6)));

                txtCedulaEmpleadoA.setEditable(false);
                btnAgregarEmpleadoA.setEnabled(false);
            }
        }
    }

    class TablaLibroAListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                txtIsbnLibroA.setEditable(true);
                btnAgregarLibroA.setEnabled(true);

                txtIsbnLibroA.setText("");
                txtEditorialLibroA.setText("");
                txtIdiomaLibroA.setText("");
                txtNumPaginasLibroA.setText("");
                jyAnoPublicLibroA.setYear(2023);
            }
            else
            {
                limpiarLibroAdmin();
                txtIsbnLibroA.setText(String.valueOf(tabla.getValueAt(fila , 0)));
                txtTituloLibroA.setText(String.valueOf(tabla.getValueAt(fila , 1)));
                txtEditorialLibroA.setText(String.valueOf(tabla.getValueAt(fila , 3)));
                jyAnoPublicLibroA.setYear((Integer.parseInt(String.valueOf(tabla.getValueAt(fila , 4)))));
                txtIdiomaLibroA.setText(String.valueOf(tabla.getValueAt(fila , 5)));
                txtNumPaginasLibroA.setText(String.valueOf(tabla.getValueAt(fila , 6)));

                txtIsbnLibroA.setEditable(false);
                btnAgregarLibroA.setEnabled(false);
            }
        }
    }

    class TablaAutorLibroAListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                txtAutorLibroA.setText("");
            }
            else
            {
                limpiarAutorLibroAdmin();
                txtAutorLibroA.setText(String.valueOf(tabla.getValueAt(fila , 0)));
            }
        }
    }

    class TablaEjemplarAListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                txtNumEjemplarA.setText("0");
                txtIsbnEjemplarA.setText("");
                txtEstanteEjemplarA.setText("");
                txtNumPasilloEjemplarA.setText("");
                txtNomSalaEjemplarA.setText("");
                txtNumCajonEjemplarA.setText("");
            }
            else
            {
                limpiarEjemplarAdmin();
                txtNumEjemplarA.setText(String.valueOf(tabla.getValueAt(fila , 0)));
                txtIsbnEjemplarA.setText(String.valueOf(tabla.getValueAt(fila , 1)));
                txtEstanteEjemplarA.setText(String.valueOf(tabla.getValueAt(fila , 2)));
                txtNumCajonEjemplarA.setText(String.valueOf(tabla.getValueAt(fila , 3)));
                txtNomSalaEjemplarA.setText(String.valueOf(tabla.getValueAt(fila , 4)));
                txtNumPasilloEjemplarA.setText(String.valueOf(tabla.getValueAt(fila , 5)));
            }
        }
    }

    class TablaDigitalAListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                txtNumDigitalA.setText("0");
                txtIsbnDigitalA.setText("");
                txtUrlDigitalA.setText("");
                txtFormatoDigitalA.setText("");
                txtBytesDigitalA.setText("");
            }
            else
            {
                limpiarDigitalAdmin();
                txtNumDigitalA.setText(String.valueOf(tabla.getValueAt(fila , 0)));
                txtIsbnDigitalA.setText(String.valueOf(tabla.getValueAt(fila , 1)));
                txtUrlDigitalA.setText(String.valueOf(tabla.getValueAt(fila , 2)));
                txtFormatoDigitalA.setText(String.valueOf(tabla.getValueAt(fila , 3)));
                txtBytesDigitalA.setText(String.valueOf(tabla.getValueAt(fila , 4)));
            }
        }
    }


    class TablaLibroUListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                txtIsbnLibroU.setText("");
            }
            else
            {
                limpiarLibroUsuario();
                txtIsbnLibroU.setText(String.valueOf(tabla.getValueAt(fila , 0)));
            }
        }
    }

    class TablaMultaUListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                txtNumeroMultaU.setText("");
            }
            else
            {
                limpiarMultaUsuario();
                txtNumeroMultaU.setText(String.valueOf(tabla.getValueAt(fila , 0)));
            }
        }
    }

    class TablaPrestamoEListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                txtIsbnPrestamoE.setText("");
                txtNumeroEjemplarPreE.setText("");
            }
            else
            {
                limpiarPrestamoEmpleado();
                txtIsbnPrestamoE.setText(String.valueOf(tabla.getValueAt(fila , 0)));
                txtNumeroEjemplarPreE.setText(String.valueOf(tabla.getValueAt(fila , 1)));
            }
        }
    }

    class TablaDevolucionEListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JTable tabla = (JTable)e.getSource();
            int fila = tabla.getSelectedRow();
            if(fila == -1)
            {
                txtIsbnDevolucionE.setText("");
                txtNumeroEjemplarDevE.setText("");
                txtCedulaUDevolucionE.setText("");
                txtCedulaEDevolucionE.setText("");
                txtNumeroPrestamoDevE.setText("");
            }
            else
            {
                limpiarPrestamoEmpleado();
                txtNumeroPrestamoDevE.setText(String.valueOf(tabla.getValueAt(fila , 0)));
                txtIsbnDevolucionE.setText(String.valueOf(tabla.getValueAt(fila , 1)));
                txtNumeroEjemplarDevE.setText(String.valueOf(tabla.getValueAt(fila , 2)));
                txtCedulaUDevolucionE.setText(String.valueOf(tabla.getValueAt(fila , 3)));
                txtCedulaEDevolucionE.setText(String.valueOf(tabla.getValueAt(fila , 4)));

            }
        }
    }


    public void addTablaAreaAListener(MouseAdapter listenControles)
    {
        jtTablaAreaA.addMouseListener(listenControles);
    }

    public void addTablaEditorialAListener(MouseAdapter listenControles)
    {
        jtTablaEditorialA.addMouseListener(listenControles);
    }

    public void addTablaAutorAListener(MouseAdapter listenControles)
    {
        jtTablaAutorA.addMouseListener(listenControles);
    }

    public void addTablaEmpleadoAListener(MouseAdapter listenControles)
    {
        jtTablaEmpleadoA.addMouseListener(listenControles);
    }

    public void addTablaLibroUListener(MouseAdapter listenControles)
    {
        jtTablaLibroU.addMouseListener(listenControles);
    }

    public void addTablaMultaUListener(MouseAdapter listenControles)
    {
        jtTablaMultaU.addMouseListener(listenControles);
    }

    public void addTablaPrestamoEListener(MouseAdapter listenControles)
    {
        jtTablaPrestamoE.addMouseListener(listenControles);
    }

    public void addTablaDevolucionEListener(MouseAdapter listenControles)
    {
        jtTablaDevolucionE.addMouseListener(listenControles);
    }

    public void addTablaLibroAListener(MouseAdapter listenControles)
    {
        jtTablaLibroA.addMouseListener(listenControles);
    }

    public void addTablaAutorLibroAListener(MouseAdapter listenControles)
    {
        jtTablaAutorLibroA.addMouseListener(listenControles);
    }

    public void addTablaEjemplarAListener(MouseAdapter listenControles)
    {
        jtTablaEjemplarA.addMouseListener(listenControles);
    }

    public void addTablaDigitalAListener(MouseAdapter listenControles)
    {
        jtTablaDigitalA.addMouseListener(listenControles);
    }

    public void setCedulaEstudianteP(String txt)
    {
        txtCedulaEstudianteP.setText(txt);
    }

    public void setNombreEstudianteP(String txt)
    {
        txtNombreEstudianteP.setText(txt);
    }

    public void setCorreoEstudianteP(String txt)
    {
        txtCorreoEstudianteP.setText(txt);
    }

    public void setClaveEstudianteP(String txt)
    {
        txtClaveEstudianteP.setText(txt);
    }

    public void setDireccionEstudianteP(String txt)
    {
        txtDireccionEstudianteP.setText(txt);
    }

    public void setTelefonoEstudianteP(String txt)
    {
        txtTelefonoEstudianteP.setText(txt);
    }

    public void setCarreraEstudianteP(String txt)
    {
        txtCarreraEstudianteP.setText(txt);
    }

    public void setUniversidadEstudianteP(String txt)
    {
        txtUniversidadEstudianteP.setText(txt);
    }

    public void setCedulaProfesorP(String txt)
    {
        txtCedulaProfesorP.setText(txt);
    }

    public void setNombreProfesorP(String txt)
    {
        txtNombreProfesorP.setText(txt);
    }

    public void setCorreoProfesorP(String txt)
    {
        txtCorreoProfesorP.setText(txt);
    }

    public void setClaveProfesorP(String txt)
    {
        txtClaveProfesorP.setText(txt);
    }

    public void setDireccionProfesorP(String txt)
    {
        txtDireccionProfesorP.setText(txt);
    }

    public void setTelefonoProfesorP(String txt)
    {
        txtTelefonoProfesorP.setText(txt);
    }

    public void setTituloProfesorP(String txt)
    {
        txtTituloProfesorP.setText(txt);
    }

    public void setDependenciaProfesorP(String txt)
    {
        txtDependenciaProfesorP.setText(txt);
    }
    /**************************************************************************
     * Getters
     *************************************************************************/

    public String getCarreraEstudianteP() {
        return txtCarreraEstudianteP.getText();
    }

    public String getCedulaEstudianteP() {
        return txtCedulaEstudianteP.getText();
    }

    public String getCedulaProfesorP() {
        return txtCedulaProfesorP.getText();
    }

    public String getClaveEstudianteP() {
        return txtClaveEstudianteP.getText();
    }

    public String getClaveProfesorP() {
        return txtClaveProfesorP.getText();
    }

    public String getCorreoEstudianteP() {
        return txtCorreoEstudianteP.getText();
    }

    public String getCorreoProfesorP() {
        return txtCorreoProfesorP.getText();
    }

    public String getDependenciaProfesorP() {
        return txtDependenciaProfesorP.getText();
    }

    public String getDireccionEstudianteP() {
        return txtDireccionEstudianteP.getText();
    }

    public String getDireccionProfesorP() {
        return txtDireccionProfesorP.getText();
    }

    public String getNombreEstudianteP() {
        return txtNombreEstudianteP.getText();
    }

    public String getNombreProfesorP() {
        return txtNombreProfesorP.getText();
    }

    public String getTelefonoEstudianteP() {
        return txtTelefonoEstudianteP.getText();
    }

    public String getTelefonoProfesorP() {
        return txtTelefonoProfesorP.getText();
    }

    public String getTituloProfesorP() {
        return txtTituloProfesorP.getText();
    }

    public String getUniversidadEstudianteP() {
        return txtUniversidadEstudianteP.getText();
    }

    public String getTxaDescripcionSolicitudU() {return txaDescripcionSolicitudU.getText();}

    public String getTxtIsbnSolicitudU() {return txtIsbnSolicitudU.getText();}

    public String getTxtTituloSolicitudU() {return txtTituloSolicitudU.getText();}

    public String getTxtCargoEmpleadoA() {
        return txtCargoEmpleadoA.getText();
    }


    public String getTxtCedulaEmpleadoA() {
        return txtCedulaEmpleadoA.getText();
    }


    public String getTxtClaveEmpleadoA() {
        return txtClaveEmpleadoA.getText();
    }


    public String getTxtCorreoEmpleadoA() {
        return txtCorreoEmpleadoA.getText();
    }

    public String getTxtDireccionEmpleadoA() {
        return txtDireccionEmpleadoA.getText();
    }

    public String getTxtNombreEmpleadoA() {
        return txtNombreEmpleadoA.getText();
    }

    public String getTxtTelefonoEmpleadoA() {
        return txtTelefonoEmpleadoA.getText();
    }
    public String getTxtPrimerNomAu(){return txtNombre1AutorA.getText();}
    public String getTxtSegundoNomAu(){return txtNombre2AutorA.getText();}
    public String getTxtPrimerApeAu(){return txtApellido1AutorA.getText();}
    public String getTxtSegundoApeAu(){return txtApellido2AutorA.getText();}
    //Prestamo-Empleado
    public String getIsbnPresEmp(){return txtIsbnPrestamoE.getText();}
    public int getEjemplarPresEmp(){return Integer.parseInt(txtNumeroEjemplarPreE.getText());}
    public Date getFechaRPresEmp(){return jdFechaRPrestamoE.getDate();}
    public Date getFechaDPresEmp(){return jdFechaDPrestamoE.getDate();}
    public String getCedulaPresEmp(){return txtCedulaPrestamoE.getText();}

    //Devolución empleado

    public int getNumPresDevEmp(){return Integer.parseInt(txtNumeroPrestamoDevE.getText());}
    public String getCedulaDevEmp(){return txtCedulaEDevolucionE.getText();}
    public int getNumEjemDevEmp(){return Integer.parseInt(txtNumeroEjemplarDevE.getText());}
    public String getCedulaDevUsu(){return txtCedulaUDevolucionE.getText();}
    public String getIsbnDev(){return txtIsbnDevolucionE.getText();}
    /**************************************************************************
     * TableModel's
     *************************************************************************/

    public TableModel getSolicitudUTableModel(){return jtTablaSolicitudU.getModel();}
    public TableModel getPrestamoUTableModel(){return  jtTablaPrestamoU.getModel();}
    public TableModel getEmpleadoTableModel(){return  jtTablaEmpleadoA.getModel();}
    public TableModel getUsuarioAdminTableModel(){return jtTablaUsuarioA.getModel();}
    public TableModel getSolicitudAdminTableModel(){return jtTablaSolicitudA.getModel();}
    public TableModel getDescargaAdminTableModel(){return jtTablaDescargaA.getModel();}
    public TableModel getPrestamoAdminTableModel(){return jtTablaPrestamoA.getModel();}
    public TableModel getAreaAdminTableModel(){return jtTablaAreaA.getModel();}
    public TableModel getAutorAdminTableModel(){return jtTablaAutorA.getModel();}
    public TableModel getEditorialAdminTableModel(){return jtTablaEditorialA.getModel();}
    public TableModel getSolicitudEmpTableModel(){return  jtTablaSolicitudE.getModel();}
    public TableModel getLibroAdminTableModel(){return jtTablaLibroA.getModel();}
    public TableModel getLibroUTableModel(){return jtTablaLibroU.getModel();}
    public TableModel getEjemplarAdminTableModel(){return jtTablaEjemplarA.getModel();}
    public TableModel getDigitalAdminTableModel(){return jtTablaDigitalA.getModel();}

    public int getFilaSeleccionadaEmpleado()
    {
        return jtTablaEmpleadoA.getSelectedRow();
    }

    public void deseleccionarFilaTablaEmpleado()
    {
        jtTablaEmpleadoA.getSelectionModel().clearSelection();
    }
    public int getFilaSeleccionadaAutor(){return jtTablaAutorA.getSelectedRow();}
    public void deseleccionarFilaTablaAutor(){jtTablaAutorA.getSelectionModel().clearSelection();}

    //tablas prestamos-admin
    public TableModel getPrestamoEmpTabMod(){return jtTablaPrestamoE.getModel();}
    public TableModel getLibrosPresEmpTabMod(){return jtTablaLibroPreE.getModel();}
    public int getFilaLibrosPres(){return jtTablaLibroPreE.getSelectedRow();}
    public void deseleccionarFilaLibrosPres(){jtTablaLibroPreE.getSelectionModel().clearSelection();}

    //tablas devoluciones-admin
    public TableModel getDevEmpTabMod(){return jtTablaDevolucionE.getModel();}
    public int getFilaSeleccionadaDev(){return jtTablaDevolucionE.getSelectedRow();}
    public void deseleccionarFilaDev(){jtTablaDevolucionE.getSelectionModel().clearSelection();}
    public String getTxtCodAreaA()
    {
        return txtIdAreaA.getText();
    }

    public String getTxtNombreAreaA()
    {
        return txtNombreAreaA.getText();
    }

    public String getTxaDescripcionAreaA()
    {
        return txaDescripcionAreaA.getText();
    }

    public String getTxtCodigoArea1A()
    {
        return txtCodigoArea1A.getText();
    }

    public String getTxtCodigoArea2A()
    {
        return txtCodigoArea2A.getText();
    }

    public int getFilaSeleccionadaArea()
    {
        return jtTablaAreaA.getSelectedRow();
    }

    public void deseleccionarFilaTablaArea()
    {
        jtTablaAreaA.getSelectionModel().clearSelection();
    }

    public String getTxtIdEditorialA() {
        return txtIdEditorialA.getText();
    }

    public String getTxtNombreEditorialA() {
        return txtNombreEditorialA.getText();
    }

    public String getTxtPaginaWebEditorialA() {
        return txtPaginaWebEditorialA.getText();
    }

    public String getTxtPaisEditorialA() {
        return txtPaisEditorialA.getText();
    }

    public int getFilaSeleccionadaEditorial(){
        return jtTablaEditorialA.getSelectedRow();
    }

    public void deseleccionarFilaTablaEditorial(){
        jtTablaEditorialA.getSelectionModel().clearSelection();
    }

    public String getTxtAutorLibroA() {
        return txtAutorLibroA.getText();
    }

    public String getTxtEditorialLibroA() {
        return txtEditorialLibroA.getText();
    }

    public String getTxtIdiomaLibroA() {
        return txtIdiomaLibroA.getText();
    }

    public String getTxtIsbnLibroA() {
        return txtIsbnLibroA.getText();
    }

    public String getTxtIsbnLibroU() {
        return txtIsbnLibroU.getText();
    }

    public String getTxtNumPaginasLibroA() {
        return txtNumPaginasLibroA.getText();
    }

    public String getTxtTituloLibroA() {
        return txtTituloLibroA.getText();
    }

    public int getJyAnoPublicLibroA() {
        return jyAnoPublicLibroA.getYear();
    }

    public int getFilaSeleccionadaLibroAd(){
        return jtTablaLibroA.getSelectedRow();
    }

    public int getFilaSeleccionadaLibroU(){
        return jtTablaLibroU.getSelectedRow();
    }

    public void deseleccionarFilaTablaLibroAd(){
        jtTablaLibroA.getSelectionModel().clearSelection();
    }

    public void deseleccionarFilaTablaLibroU(){
        jtTablaLibroU.getSelectionModel().clearSelection();
    }

    public String getTxtEstanteEjemplarA() {
        return txtEstanteEjemplarA.getText();
    }

    public String getTxtIsbnEjemplarA() {
        return txtIsbnEjemplarA.getText();
    }

    public String getTxtNomSalaEjemplarA() {
        return txtNomSalaEjemplarA.getText();
    }

    public String getTxtNumCajonEjemplarA() {
        return txtNumCajonEjemplarA.getText();
    }

    public String getTxtNumEjemplarA() {
        return txtNumEjemplarA.getText();
    }

    public String getTxtNumPasilloEjemplarA() {
        return txtNumPasilloEjemplarA.getText();
    }

    public int getFilaSeleccionadaEjemplarAd(){
        return jtTablaEjemplarA.getSelectedRow();
    }

    public void deseleccionarTablaFilaEjemplarAd(){
        jtTablaEjemplarA.getSelectionModel().clearSelection();
    }

    public String getTxtBytesDigitalA() {
        return txtBytesDigitalA.getText();
    }

    public String getTxtFormatoDigitalA() {
        return txtFormatoDigitalA.getText();
    }

    public String getTxtIsbnDigitalA() {
        return txtIsbnDigitalA.getText();
    }

    public String getTxtNumDigitalA() {
        return txtNumDigitalA.getText();
    }

    public String getTxtUrlDigitalA() {
        return txtUrlDigitalA.getText();
    }

    public int getFilaSeleccionadaDigitalAd()
    {
        return jtTablaDigitalA.getSelectedRow();
    }

    public void deseleccionarFilaTablaDigitalAd()
    {
        jtTablaDigitalA.getSelectionModel().clearSelection();
    }

    public void mostrarMensaje(String auxMensaje)
    {
        JOptionPane.showMessageDialog(this, auxMensaje);
    }

    public void mostrarMensajeError(String auxMensaje)
    {
        JOptionPane.showMessageDialog(this, auxMensaje, "", JOptionPane.ERROR_MESSAGE);
    }

    private static class JTableCeldaPersonalizada extends JTextArea implements TableCellRenderer
    {
        JTableCeldaPersonalizada()
        {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            setText( (value == null) ? "" : value.toString() );
            setSize(table.getColumnModel().getColumn(column).getWidth(), table.getRowHeight(row));

            int preferredHeight = getPreferredSize().height;

            if (table.getRowHeight(row) != preferredHeight)
            {
                table.setRowHeight(row, preferredHeight);
            }

            return this;
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAgregarAreaA;
    private javax.swing.JButton btnAgregarAutorA;
    private javax.swing.JButton btnAgregarAutorLibroA;
    private javax.swing.JButton btnAgregarDigitalA;
    private javax.swing.JButton btnAgregarEditorialA;
    private javax.swing.JButton btnAgregarEjemplarA;
    private javax.swing.JButton btnAgregarEmpleadoA;
    private javax.swing.JButton btnAgregarLibroA;
    private javax.swing.JButton btnAgregarLibroE;
    private javax.swing.JButton btnAreasAdmin;
    private javax.swing.JButton btnAutoresAdmin;
    private javax.swing.JButton btnBorrarPrestamoE;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnDescargaLibroU;
    private javax.swing.JButton btnDescargasAdmin;
    private javax.swing.JButton btnDevolucionesEmpleado;
    private javax.swing.JButton btnDevolverLibroE;
    private javax.swing.JButton btnEditorialesAdmin;
    private javax.swing.JButton btnEliminarAreaA;
    private javax.swing.JButton btnEliminarAutorA;
    private javax.swing.JButton btnEliminarAutorLibroA;
    private javax.swing.JButton btnEliminarDigitalA;
    private javax.swing.JButton btnEliminarEditorialA;
    private javax.swing.JButton btnEliminarEjemplarA;
    private javax.swing.JButton btnEliminarEmpleadoA;
    private javax.swing.JButton btnEliminarLibroA;
    private javax.swing.JButton btnEmpleadosAdmin;
    private javax.swing.JButton btnEnviarSolicitudU;
    private javax.swing.JButton btnLibrosAdmin;
    private javax.swing.JButton btnLibrosUsuario;
    private javax.swing.JButton btnModificarAreaA;
    private javax.swing.JButton btnModificarAutorA;
    private javax.swing.JButton btnModificarDigitalA;
    private javax.swing.JButton btnModificarEditorialA;
    private javax.swing.JButton btnModificarEjemplarA;
    private javax.swing.JButton btnModificarEmpleadoA;
    private javax.swing.JButton btnModificarLibroA;
    private javax.swing.JButton btnModificarPerfilE;
    private javax.swing.JButton btnModificarPerfilP;
    private javax.swing.JButton btnMultasAdmin;
    private javax.swing.JButton btnMultasUsuario;
    private javax.swing.JButton btnPagarMultaU;
    private javax.swing.JButton btnPrestamosAdmin;
    private javax.swing.JButton btnPrestamosEmpleado;
    private javax.swing.JButton btnPrestamosUsuario;
    private javax.swing.JButton btnPrestarPrestamoE;
    private javax.swing.JButton btnRelacionarAreaA;
    private javax.swing.JButton btnSolicitudAdmin;
    private javax.swing.JButton btnSolicitudUsuario;
    private javax.swing.JButton btnSolicitudesEmpleado;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnUsuariosAdmin;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private com.toedter.calendar.JDateChooser jdFechaDPrestamoE;
    private com.toedter.calendar.JDateChooser jdFechaRPrestamoE;
    private javax.swing.JPanel jpAreaAdmin;
    private javax.swing.JPanel jpAutorAdmin;
    private javax.swing.JPanel jpContenido;
    private javax.swing.JPanel jpDescargaAdmin;
    private javax.swing.JPanel jpDevolucionEmpleado;
    private javax.swing.JPanel jpDigitalAdmin;
    private javax.swing.JPanel jpEditorialAdmin;
    private javax.swing.JPanel jpEjemplarAdmin;
    private javax.swing.JPanel jpEmpleadoAdmin;
    private javax.swing.JPanel jpEncabezado;
    private javax.swing.JPanel jpFormularioAreaA;
    private javax.swing.JPanel jpFormularioAutorA;
    private javax.swing.JPanel jpFormularioDescargaA;
    private javax.swing.JPanel jpFormularioDevolucionE;
    private javax.swing.JPanel jpFormularioDigitalA;
    private javax.swing.JPanel jpFormularioEditorialA;
    private javax.swing.JPanel jpFormularioEjemplarA;
    private javax.swing.JPanel jpFormularioEmpleadoA;
    private javax.swing.JPanel jpFormularioLibroA;
    private javax.swing.JPanel jpFormularioLibroU;
    private javax.swing.JPanel jpFormularioMultaA;
    private javax.swing.JPanel jpFormularioMultaU;
    private javax.swing.JPanel jpFormularioPrestamoA;
    private javax.swing.JPanel jpFormularioPrestamoE;
    private javax.swing.JPanel jpFormularioPrestamoU;
    private javax.swing.JPanel jpFormularioSolicitudA;
    private javax.swing.JPanel jpFormularioSolicitudE;
    private javax.swing.JPanel jpFormularioSolicitudU;
    private javax.swing.JPanel jpFormularioUsuarioA;
    private javax.swing.JPanel jpLibroAdmin;
    private javax.swing.JPanel jpLibroUsuario;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JPanel jpMenuAdmin;
    private javax.swing.JPanel jpMenuEmpleado;
    private javax.swing.JPanel jpMenuUsuario;
    private javax.swing.JPanel jpMultaAdmin;
    private javax.swing.JPanel jpMultaUsuario;
    private javax.swing.JPanel jpPerfilUsuarioE;
    private javax.swing.JPanel jpPerfilUsuarioP;
    private javax.swing.JPanel jpPrestamoAdmin;
    private javax.swing.JPanel jpPrestamoEmpleado;
    private javax.swing.JPanel jpPrestamoUsuario;
    private javax.swing.JPanel jpSolicitudAdmin;
    private javax.swing.JPanel jpSolicitudEmpleado;
    private javax.swing.JPanel jpSolicitudUsuario;
    private javax.swing.JPanel jpTablaAreaA;
    private javax.swing.JPanel jpTablaAutorA;
    private javax.swing.JPanel jpTablaAutorLibroA;
    private javax.swing.JPanel jpTablaDescargaA;
    private javax.swing.JPanel jpTablaDevolucionE;
    private javax.swing.JPanel jpTablaDigitalA;
    private javax.swing.JPanel jpTablaEditorialA;
    private javax.swing.JPanel jpTablaEjemplarA;
    private javax.swing.JPanel jpTablaEmpleadoA;
    private javax.swing.JPanel jpTablaEmpleadoA1;
    private javax.swing.JPanel jpTablaLibroA;
    private javax.swing.JPanel jpTablaLibroPreE;
    private javax.swing.JPanel jpTablaLibroU;
    private javax.swing.JPanel jpTablaMultaA;
    private javax.swing.JPanel jpTablaMultaU;
    private javax.swing.JPanel jpTablaPrestamoA;
    private javax.swing.JPanel jpTablaPrestamoE;
    private javax.swing.JPanel jpTablaPrestamoU;
    private javax.swing.JPanel jpTablaSolicitudA;
    private javax.swing.JPanel jpTablaSolicitudE;
    private javax.swing.JPanel jpTablaSolicitudU;
    private javax.swing.JPanel jpUsuarioAdmin;
    private javax.swing.JScrollPane jpsDescripcionSolicitudU;
    private javax.swing.JScrollPane jpsTablaAreaA;
    private javax.swing.JScrollPane jpsTablaDevolucionE;
    private javax.swing.JScrollPane jpsTablaDigitalA;
    private javax.swing.JScrollPane jpsTablaEjemplarA;
    private javax.swing.JScrollPane jpsTablaLibroA;
    private javax.swing.JScrollPane jpsTablaLibroU;
    private javax.swing.JScrollPane jpsTablaMultaU;
    private javax.swing.JScrollPane jpsTablaPrestamoE;
    private javax.swing.JScrollPane jpsTablaPrestamoU;
    private javax.swing.JScrollPane jpsTablaSolicitudU;
    private javax.swing.JScrollPane jspDescripcionAreaA;
    private javax.swing.JScrollPane jspTablaAutorA;
    private javax.swing.JScrollPane jspTablaAutorLibroA;
    private javax.swing.JScrollPane jspTablaDescargaA;
    private javax.swing.JScrollPane jspTablaEditorialA;
    private javax.swing.JScrollPane jspTablaEmpleadoA;
    private javax.swing.JScrollPane jspTablaLibroPreE;
    private javax.swing.JScrollPane jspTablaMultaA;
    private javax.swing.JScrollPane jspTablaPrestamoA;
    private javax.swing.JScrollPane jspTablaSolicitudA;
    private javax.swing.JScrollPane jspTablaSolicitudE;
    private javax.swing.JScrollPane jspTablaUsuarioA;
    private javax.swing.JTable jtTablaAreaA;
    private javax.swing.JTable jtTablaAutorA;
    private javax.swing.JTable jtTablaAutorLibroA;
    private javax.swing.JTable jtTablaDescargaA;
    private javax.swing.JTable jtTablaDevolucionE;
    private javax.swing.JTable jtTablaDigitalA;
    private javax.swing.JTable jtTablaEditorialA;
    private javax.swing.JTable jtTablaEjemplarA;
    private javax.swing.JTable jtTablaEmpleadoA;
    private javax.swing.JTable jtTablaLibroA;
    private javax.swing.JTable jtTablaLibroPreE;
    private javax.swing.JTable jtTablaLibroU;
    private javax.swing.JTable jtTablaMultaA;
    private javax.swing.JTable jtTablaMultaU;
    private javax.swing.JTable jtTablaPrestamoA;
    private javax.swing.JTable jtTablaPrestamoE;
    private javax.swing.JTable jtTablaPrestamoU;
    private javax.swing.JTable jtTablaSolicitudA;
    private javax.swing.JTable jtTablaSolicitudE;
    private javax.swing.JTable jtTablaSolicitudU;
    private javax.swing.JTable jtTablaUsuarioA;
    private com.toedter.calendar.JYearChooser jyAnoPublicLibroA;
    private javax.swing.JLabel lblAnoPublicLibroA;
    private javax.swing.JLabel lblApellido1AutorA;
    private javax.swing.JLabel lblApellido2AutorA;
    private javax.swing.JLabel lblAutorLibroA;
    private javax.swing.JLabel lblBytesDigitalA;
    private javax.swing.JLabel lblCargoEmpleadoA;
    private javax.swing.JLabel lblCarreraEstudianteP;
    private javax.swing.JLabel lblCedulaEDevolucionE;
    private javax.swing.JLabel lblCedulaEmpleadoA;
    private javax.swing.JLabel lblCedulaEstudianteP;
    private javax.swing.JLabel lblCedulaPrestamoE;
    private javax.swing.JLabel lblCedulaProfesorP;
    private javax.swing.JLabel lblCedulaUDevolucionE;
    private javax.swing.JLabel lblClaveEmpleadoA;
    private javax.swing.JLabel lblClaveEstudianteP;
    private javax.swing.JLabel lblClaveProfesorP;
    private javax.swing.JLabel lblCodigoArea1A;
    private javax.swing.JLabel lblCodigoArea2A;
    private javax.swing.JLabel lblCorreoEmpleadoA;
    private javax.swing.JLabel lblCorreoEstudianteP;
    private javax.swing.JLabel lblCorreoProfesorP;
    private javax.swing.JLabel lblDependenciaProfesorP;
    private javax.swing.JLabel lblDescripcionAreaA;
    private javax.swing.JLabel lblDescripcionSolicitudU;
    private javax.swing.JLabel lblDireccionEmpleadoA;
    private javax.swing.JLabel lblDireccionEstudianteP;
    private javax.swing.JLabel lblDireccionProfesorP;
    private javax.swing.JLabel lblEditorialLibroA;
    private javax.swing.JLabel lblEstanteEjemplarA;
    private javax.swing.JLabel lblFechaDPrestamoE;
    private javax.swing.JLabel lblFechaRPrestamoE;
    private javax.swing.JLabel lblFormatoDigitalA;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblIdiomaLibroA;
    private javax.swing.JLabel lblIsbnDevolucionE;
    private javax.swing.JLabel lblIsbnDigitalA;
    private javax.swing.JLabel lblIsbnEjemplarA;
    private javax.swing.JLabel lblIsbnLibroA;
    private javax.swing.JLabel lblIsbnLibroU;
    private javax.swing.JLabel lblIsbnPrestamoE;
    private javax.swing.JLabel lblIsbnSolicitudU;
    private javax.swing.JLabel lblMultasTitulo;
    private javax.swing.JLabel lblNomSalaEjemplarA;
    private javax.swing.JLabel lblNombre1AutorA;
    private javax.swing.JLabel lblNombre2Autor2;
    private javax.swing.JLabel lblNombreAreaA;
    private javax.swing.JLabel lblNombreEditorialA;
    private javax.swing.JLabel lblNombreEmpleadoA;
    private javax.swing.JLabel lblNombreEstudianteP;
    private javax.swing.JLabel lblNombreProfesorP;
    private javax.swing.JLabel lblNumCajonEjemplarA;
    private javax.swing.JLabel lblNumPaginasLibroA;
    private javax.swing.JLabel lblNumPasilloEjemplarA;
    private javax.swing.JLabel lblNumeroEjemplarDevE;
    private javax.swing.JLabel lblNumeroEjemplarPreE;
    private javax.swing.JLabel lblNumeroMultaU;
    private javax.swing.JLabel lblNumeroPrestamoDevE;
    private javax.swing.JLabel lblPaginaWebEditorialA;
    private javax.swing.JLabel lblPaisEditorialA;
    private javax.swing.JLabel lblTelefonoEmpleadoA;
    private javax.swing.JLabel lblTelefonoEstudianteP;
    private javax.swing.JLabel lblTelefonoProfesorP;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloAreaA;
    private javax.swing.JLabel lblTituloAutorA;
    private javax.swing.JLabel lblTituloDescargaA;
    private javax.swing.JLabel lblTituloDevolucionE;
    private javax.swing.JLabel lblTituloDigitalA;
    private javax.swing.JLabel lblTituloEditorialA;
    private javax.swing.JLabel lblTituloEjemplarA;
    private javax.swing.JLabel lblTituloEmpleadoA;
    private javax.swing.JLabel lblTituloLibroA;
    private javax.swing.JLabel lblTituloLibroU;
    private javax.swing.JLabel lblTituloLibrosA;
    private javax.swing.JLabel lblTituloMultaA;
    private javax.swing.JLabel lblTituloPrestamoA;
    private javax.swing.JLabel lblTituloPrestamoE;
    private javax.swing.JLabel lblTituloPrestamoU;
    private javax.swing.JLabel lblTituloProfesorP;
    private javax.swing.JLabel lblTituloSolicitudA;
    private javax.swing.JLabel lblTituloSolicitudE;
    private javax.swing.JLabel lblTituloSolicitudU;
    private javax.swing.JLabel lblTituloSolicitudesU;
    private javax.swing.JLabel lblTituloUsuarioA;
    private javax.swing.JLabel lblTituloUsuarioPE;
    private javax.swing.JLabel lblTituloUsuarioPP;
    private javax.swing.JLabel lblUniversidadEstudianteP;
    private javax.swing.JLabel lblUrlDigitalA;
    private javax.swing.JTabbedPane tabLibroAdmin;
    private javax.swing.JTextArea txaDescripcionAreaA;
    private javax.swing.JTextArea txaDescripcionSolicitudU;
    private javax.swing.JTextField txtApellido1AutorA;
    private javax.swing.JTextField txtApellido2AutorA;
    private javax.swing.JTextField txtAutorLibroA;
    private javax.swing.JTextField txtBytesDigitalA;
    private javax.swing.JTextField txtCargoEmpleadoA;
    private javax.swing.JTextField txtCarreraEstudianteP;
    private javax.swing.JTextField txtCedulaEDevolucionE;
    private javax.swing.JTextField txtCedulaEmpleadoA;
    private javax.swing.JTextField txtCedulaEstudianteP;
    private javax.swing.JTextField txtCedulaPrestamoE;
    private javax.swing.JTextField txtCedulaProfesorP;
    private javax.swing.JTextField txtCedulaUDevolucionE;
    private javax.swing.JTextField txtClaveEmpleadoA;
    private javax.swing.JTextField txtClaveEstudianteP;
    private javax.swing.JTextField txtClaveProfesorP;
    private javax.swing.JTextField txtCodigoArea1A;
    private javax.swing.JTextField txtCodigoArea2A;
    private javax.swing.JTextField txtCorreoEmpleadoA;
    private javax.swing.JTextField txtCorreoEstudianteP;
    private javax.swing.JTextField txtCorreoProfesorP;
    private javax.swing.JTextField txtDependenciaProfesorP;
    private javax.swing.JTextField txtDireccionEmpleadoA;
    private javax.swing.JTextField txtDireccionEstudianteP;
    private javax.swing.JTextField txtDireccionProfesorP;
    private javax.swing.JTextField txtEditorialLibroA;
    private javax.swing.JTextField txtEstanteEjemplarA;
    private javax.swing.JTextField txtFormatoDigitalA;
    private javax.swing.JTextField txtIdAreaA;
    private javax.swing.JTextField txtIdAutorA;
    private javax.swing.JTextField txtIdEditorialA;
    private javax.swing.JTextField txtIdiomaLibroA;
    private javax.swing.JTextField txtIsbnDevolucionE;
    private javax.swing.JTextField txtIsbnDigitalA;
    private javax.swing.JTextField txtIsbnEjemplarA;
    private javax.swing.JTextField txtIsbnLibroA;
    private javax.swing.JTextField txtIsbnLibroU;
    private javax.swing.JTextField txtIsbnPrestamoE;
    private javax.swing.JTextField txtIsbnSolicitudU;
    private javax.swing.JTextField txtNomSalaEjemplarA;
    private javax.swing.JTextField txtNombre1AutorA;
    private javax.swing.JTextField txtNombre2AutorA;
    private javax.swing.JTextField txtNombreAreaA;
    private javax.swing.JTextField txtNombreEditorialA;
    private javax.swing.JTextField txtNombreEmpleadoA;
    private javax.swing.JTextField txtNombreEstudianteP;
    private javax.swing.JTextField txtNombreProfesorP;
    private javax.swing.JTextField txtNumCajonEjemplarA;
    private javax.swing.JTextField txtNumDigitalA;
    private javax.swing.JTextField txtNumEjemplarA;
    private javax.swing.JTextField txtNumPaginasLibroA;
    private javax.swing.JTextField txtNumPasilloEjemplarA;
    private javax.swing.JTextField txtNumeroEjemplarDevE;
    private javax.swing.JTextField txtNumeroEjemplarPreE;
    private javax.swing.JTextField txtNumeroMultaU;
    private javax.swing.JTextField txtNumeroPrestamoDevE;
    private javax.swing.JTextField txtPaginaWebEditorialA;
    private javax.swing.JTextField txtPaisEditorialA;
    private javax.swing.JTextField txtTelefonoEmpleadoA;
    private javax.swing.JTextField txtTelefonoEstudianteP;
    private javax.swing.JTextField txtTelefonoProfesorP;
    private javax.swing.JTextField txtTituloLibroA;
    private javax.swing.JTextField txtTituloProfesorP;
    private javax.swing.JTextField txtTituloSolicitudU;
    private javax.swing.JTextField txtUniversidadEstudianteP;
    private javax.swing.JTextField txtUrlDigitalA;
    // End of variables declaration
}
