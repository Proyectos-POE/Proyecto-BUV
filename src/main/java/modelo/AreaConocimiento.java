package modelo;

public class AreaConocimiento
{
    private String codigoArea;
    private String nomArea;

    public AreaConocimiento(String auxCodigoArea, String auxNomArea)
    {
        this.codigoArea = auxCodigoArea;
        this.nomArea = auxNomArea;
    }

    public AreaConocimiento(){}

    public String getCodigoArea()
    {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea)
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
}
