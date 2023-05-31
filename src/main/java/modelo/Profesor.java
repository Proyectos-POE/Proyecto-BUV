package modelo;

public class Profesor extends Usuario
{
    private String dependencia;
    private String titulo;
    public Profesor(String auxIdentificacion,String auxNombre, String auxDireccion, String auxTelefono, String auxEmail, String auxDependencia, String auxTitulo)
    {
        this.identificacion = auxIdentificacion;
        this.nombre = auxNombre;
        this.direccion = auxDireccion;
        this.telefono = auxTelefono;
        this.email = auxEmail;
        this.dependencia = auxDependencia;
        this.titulo = auxTitulo;
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
