package org.example;
import controlador.ControladorLogin;
import dao.DaoEmpleado;
import dao.DaoEstudiante;
import dao.DaoProfesor;
import vista.VentanaBiblioteca;
import vista.VentanaLogin;

public class Main {
    public static void main(String[] args)
    {
        VentanaLogin a = new VentanaLogin();
        DaoEstudiante b = new DaoEstudiante();
        DaoProfesor d = new DaoProfesor();
        DaoEmpleado e = new DaoEmpleado();
        //VentanaBiblioteca b = new VentanaBiblioteca();
        ControladorLogin c = new ControladorLogin(a, b, d, e);
    }
}