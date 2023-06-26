package org.example;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

import controlador.ControladorLogin;
import dao.DaoEmpleado;
import dao.DaoEstudiante;
import dao.DaoProfesor;
import vista.VentanaLogin;

public class Main {
    public static void main(String[] args)
    {
        VentanaLogin a = new VentanaLogin();
        DaoEstudiante b = new DaoEstudiante();
        DaoProfesor d = new DaoProfesor();
        DaoEmpleado e = new DaoEmpleado();
        ControladorLogin c = new ControladorLogin(a, b, d, e);
    }
}