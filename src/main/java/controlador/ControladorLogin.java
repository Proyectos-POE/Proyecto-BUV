package controlador;

import dao.DaoEstudiante;
import modelo.Estudiante;
import vista.VentanaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorLogin
{
    private final VentanaLogin ventanaLogin;
    private final DaoEstudiante daoEstudiante;

    public ControladorLogin(VentanaLogin auxA, DaoEstudiante auxB)
    {
        this.ventanaLogin = auxA;
        this.daoEstudiante = auxB;

        ventanaLogin.addBtnRegistrarseAListener(new EstudianteListener());

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

    class EstudianteListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("RegistrarseA"))
            {
                agregarEstudiante();
            }
        }
    }


}
