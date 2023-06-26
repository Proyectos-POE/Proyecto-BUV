package modelo;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

public class Empleado extends Usuario
{
    private String cargo;

    public Empleado()
    {

    }

    public Empleado(String auxIdentificacion, String auxNombre, String auxEmail, String auxContrasena, String auxDireccion, String  auxTelefono, String auxCargo)
    {
        this.identificacion = auxIdentificacion;
        this.nombre = auxNombre;
        this.contrasena = auxContrasena;
        this.direccion = auxDireccion;
        this.telefono = auxTelefono;
        this.cargo = auxCargo;
        this.email = auxEmail;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
