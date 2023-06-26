package modelo;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

public class Profesor extends Usuario
{
    private String dependencia;
    private String titulo;
    public Profesor(String auxIdentificacion, String auxNombre,String auxEmail, String auxContrasena, String auxDireccion, String auxTelefono, String auxTitulo, String auxDependencia)
    {
        this.identificacion = auxIdentificacion;
        this.nombre = auxNombre;
        this.direccion = auxDireccion;
        this.telefono = auxTelefono;
        this.email = auxEmail;
        this.dependencia = auxDependencia;
        this.titulo = auxTitulo;
        this.contrasena = auxContrasena;
    }

    public Profesor(){
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
