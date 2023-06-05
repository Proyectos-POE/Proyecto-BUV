package org.example;
import controlador.ControladorLogin;
import dao.DaoEstudiante;
import vista.VentanaBiblioteca;
import vista.VentanaLogin;

public class Main {
    public static void main(String[] args)
    {
        VentanaLogin a = new VentanaLogin();
        DaoEstudiante b = new DaoEstudiante();
        //VentanaBiblioteca b = new VentanaBiblioteca();
        ControladorLogin c = new ControladorLogin(a, b);
    }
}