package controlador;

import dao.DaoEstudiante;
import dao.DaoProfesor;
import modelo.Estudiante;
import modelo.Profesor;
import modelo.Usuario;
import vista.VentanaBiblioteca;
import vista.VentanaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorBiblioteca
{

    private final VentanaBiblioteca ventanaBiblioteca;
    private final Usuario usuario;
    public ControladorBiblioteca(VentanaBiblioteca auxA, Usuario auxB)
    {
        this.ventanaBiblioteca = auxA;
        this.usuario = auxB;

        if(usuario instanceof Profesor || usuario instanceof Estudiante)
        {
            ventanaBiblioteca.menuUsuario();
            ventanaBiblioteca.pagLibroUsuario();
            ventanaBiblioteca.pantallaCompleta();
        }
        else if(usuario == null)
        {
            ventanaBiblioteca.menuAdmin();
            ventanaBiblioteca.pagAreaAdmin();
            ventanaBiblioteca.pantallaCompleta();
        }

        ventanaBiblioteca.addBotonesEncabezadoListener(new EncabezadoListener());

    }

    private void cerrarSesion()
    {
        ventanaBiblioteca.dispose();
        VentanaLogin a = new VentanaLogin();
        DaoEstudiante b = new DaoEstudiante();
        DaoProfesor d = new DaoProfesor();
        ControladorLogin c = new ControladorLogin(a, b, d);
    }

    private void perfilEstudiante()
    {
        ventanaBiblioteca.setCedulaEstudianteP(usuario.getId());
        ventanaBiblioteca.setNombreEstudianteP(usuario.getNombre());
        ventanaBiblioteca.setCorreoEstudianteP(usuario.getEmail());
        ventanaBiblioteca.setClaveEstudianteP(usuario.getContrasena());
        ventanaBiblioteca.setDireccionEstudianteP(usuario.getDireccion());
        ventanaBiblioteca.setTelefonoEstudianteP(usuario.getTelefono());
        ventanaBiblioteca.setCarreraEstudianteP(((Estudiante) usuario).getCarrera());
        ventanaBiblioteca.setUniversidadEstudianteP(((Estudiante) usuario).getUniversidad());
    }

    private void perfilProfesor()
    {
        ventanaBiblioteca.setCedulaProfesorP(usuario.getId());
        ventanaBiblioteca.setNombreProfesorP(usuario.getNombre());
        ventanaBiblioteca.setCorreoProfesorP(usuario.getEmail());
        ventanaBiblioteca.setClaveProfesorP(usuario.getContrasena());
        ventanaBiblioteca.setDireccionProfesorP(usuario.getDireccion());
        ventanaBiblioteca.setTelefonoProfesorP(usuario.getTelefono());
        ventanaBiblioteca.setTituloProfesorP(((Profesor) usuario).getTitulo());
        ventanaBiblioteca.setDependenciaProfesorP(((Profesor) usuario).getDependencia());
    }

    class EncabezadoListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("cerrarSesion"))
            {
                cerrarSesion();
            }
            if (e.getActionCommand().equalsIgnoreCase("usuario"))
            {
                if(usuario instanceof Profesor)
                {
                    ventanaBiblioteca.pagPerfilProfesor();
                    perfilProfesor();
                }
                else if(usuario instanceof Estudiante)
                {
                    ventanaBiblioteca.pagPerfilEstudiante();
                    perfilEstudiante();
                }
            }
        }
    }
}
