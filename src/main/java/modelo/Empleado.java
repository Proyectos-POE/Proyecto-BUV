package modelo;

public class Empleado
{
    private String id;
    private String nombre;
    private String cargo;

    public Empleado()
    {

    }

    public Empleado(String auxId, String auxNombre, String auxCargo)
    {
        this.id = auxId;
        this.nombre = auxNombre;
        this.cargo = auxCargo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
