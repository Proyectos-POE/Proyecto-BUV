package controlador;

import dao.DaoEstudiante;
import dao.DaoProfesor;
import modelo.Estudiante;
import modelo.Profesor;
import modelo.Usuario;
import vista.VentanaBiblioteca;
import vista.VentanaLogin;

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

    }
}
