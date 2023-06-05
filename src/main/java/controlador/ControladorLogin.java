package controlador;

import dao.DaoEstudiante;
import dao.DaoProfesor;
import modelo.Estudiante;
import modelo.Profesor;
import vista.VentanaBiblioteca;
import vista.VentanaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorLogin
{
    private final VentanaLogin ventanaLogin;
    private final DaoEstudiante daoEstudiante;
    private final DaoProfesor daoProfesor;

    public ControladorLogin(VentanaLogin auxA, DaoEstudiante auxB, DaoProfesor auxC)
    {
        this.ventanaLogin = auxA;
        this.daoEstudiante = auxB;
        this.daoProfesor = auxC;

        RegistroListener registroListener = new RegistroListener();
        ventanaLogin.addBtnRegistrarseAListener(registroListener);
        ventanaLogin.addBtnRegistrarseDListener(registroListener);

        LoginListener loginListener = new LoginListener();
        ventanaLogin.addBtnLoginListener(loginListener);

        ventanaLogin.setVisible(true);
    }

    private boolean comprobarRegistroEstudiante()
    {
        return true;
    }

    private void agregarEstudiante()
    {
        Estudiante auxEstudiante;

        String auxCedula;
        String auxNombre;
        String auxCorreo;
        String auxClave;
        String auxDireccion;
        String auxTelefono;
        String auxCarrera;
        String auxUniversidad;

        if(comprobarRegistroEstudiante())
        {
            try
            {
                ArrayList<String> formularioRegistroE = ventanaLogin.getFormularioEstudiante();
                auxCedula = formularioRegistroE.get(0);
                auxNombre = formularioRegistroE.get(1);
                auxCorreo = formularioRegistroE.get(2);
                auxClave = formularioRegistroE.get(3);
                auxDireccion = formularioRegistroE.get(4);
                auxTelefono = formularioRegistroE.get(5);
                auxCarrera = formularioRegistroE.get(6);
                auxUniversidad = formularioRegistroE.get(7);

                auxEstudiante = new Estudiante(auxCedula, auxNombre, auxCorreo, auxClave, auxDireccion, auxTelefono, auxCarrera, auxUniversidad);

                if(daoEstudiante.insertEstudiante(auxEstudiante) != -1)
                {
                    ventanaLogin.mostrarMensaje("Registro realizado con exito");
                }
                else
                {
                    ventanaLogin.mostrarMensajeError("Registro realizado sin exito");
                }
                ventanaLogin.limpiarRegistroA();
            }
            catch (NumberFormatException e)
            {

            }
        }

    }

    private boolean comprobarRegistroProfesor()
    {
        return true;
    }

    private void agregarProfesor()
    {
        Profesor auxProfesor;

        String auxCedula;
        String auxNombre;
        String auxCorreo;
        String auxClave;
        String auxDireccion;
        String auxTelefono;
        String auxTitulo;
        String auxDependencia;

        if(comprobarRegistroProfesor())
        {
            try
            {
                ArrayList<String> formularioRegistroP = ventanaLogin.getFormularioProfesor();
                auxCedula = formularioRegistroP.get(0);
                auxNombre = formularioRegistroP.get(1);
                auxCorreo = formularioRegistroP.get(2);
                auxClave = formularioRegistroP.get(3);
                auxDireccion = formularioRegistroP.get(4);
                auxTelefono = formularioRegistroP.get(5);
                auxTitulo = formularioRegistroP.get(6);
                auxDependencia = formularioRegistroP.get(7);

                auxProfesor = new Profesor(auxCedula, auxNombre, auxCorreo, auxClave, auxDireccion, auxTelefono, auxTitulo, auxDependencia);

                if(daoProfesor.insertProfesor(auxProfesor) != -1)
                {
                    ventanaLogin.mostrarMensaje("Registro realizado con exito");
                }
                else
                {
                    ventanaLogin.mostrarMensajeError("Registro realizado sin exito");
                }
                ventanaLogin.limpiarRegistroD();
            }
            catch (NumberFormatException e)
            {

            }
        }

    }

    private void login()
    {
        Profesor auxProfesor;
        Estudiante auxEstudiante;
        //Administrador auxAdministrador;

        String auxCorreo;
        String auxContrasena;

        ArrayList<String> formularioLogin = ventanaLogin.getFormularioLogin();

        auxCorreo = formularioLogin.get(0);
        auxContrasena = formularioLogin.get(1);

        auxProfesor = daoProfesor.consultarProfesorEmail(auxCorreo, auxContrasena);
        auxEstudiante = daoEstudiante.consultarEstudianteEmail(auxCorreo, auxContrasena);

        if(auxProfesor != null)
        {
            ventanaLogin.dispose();
            ControladorBiblioteca controladorBiblioteca = new ControladorBiblioteca(new VentanaBiblioteca(), auxProfesor);
        }
        else if(auxEstudiante != null)
        {
            ventanaLogin.dispose();
            ControladorBiblioteca controladorBiblioteca = new ControladorBiblioteca(new VentanaBiblioteca(), auxEstudiante);
        }
        /*else if(daoAdministrador.consultarProfesorEmail(auxCorreo, auxContrasena) != null)
        {
            ventanaLogin.dispose();
        }*/
        else
        {
            ventanaLogin.mostrarMensajeError("Correo o contaseña incorrectas");
        }
    }

    class RegistroListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("RegistrarseA"))
            {
                agregarEstudiante();
            }
            if (e.getActionCommand().equalsIgnoreCase("RegistrarseD"))
            {
                agregarProfesor();
            }
        }
    }

    class LoginListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("Login"))
            {
                login();
            }
        }
    }


}
