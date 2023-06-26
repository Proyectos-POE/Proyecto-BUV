package modelo;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

public class AreaConocimiento
{
    private int codigoArea;
    private String nomArea;
    private String descripcion;

    public AreaConocimiento(String auxNomArea, String auxDescripcion)
    {
        this.nomArea = auxNomArea;
        this.descripcion = auxDescripcion;
    }

    public AreaConocimiento(){}

    public int getCodigoArea()
    {
        return codigoArea;
    }

    public void setCodigoArea(int codigoArea)
    {
        this.codigoArea = codigoArea;
    }

    public String getNomArea()
    {
        return nomArea;
    }

    public void setNomArea(String nomArea)
    {
        this.nomArea = nomArea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
