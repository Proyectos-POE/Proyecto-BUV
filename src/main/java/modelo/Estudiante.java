package modelo;

public class Estudiante extends Usuario
{
    private String carrera;
    private String universidad;


    public Estudiante(String auxIdentificacion, String auxNombre, String auxDireccion, String  auxTelefono, String auxEmail, String auxCarrera, String auxUniversidad)
    {
        this.identificacion = auxIdentificacion;
        this.nombre = auxNombre;
        this.direccion = auxDireccion;
        this.telefono = auxTelefono;
        this.email = auxEmail;
        this.carrera = auxCarrera;
        this.universidad = auxUniversidad;
    }

    public Estudiante()
    {

    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
}
