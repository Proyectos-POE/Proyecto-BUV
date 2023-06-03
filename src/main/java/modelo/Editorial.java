package modelo;

public class Editorial
{
    protected String codEditorial;
    private String nomEditorial;
    private String paginaWeb;
    private String paisOrigen;

    public String getCodEditorial()
    {
        return codEditorial;
    }

    public void setCodEditorial(String codEditorial)
    {
        this.codEditorial = codEditorial;
    }

    public String getNomEditorial()
    {
        return nomEditorial;
    }

    public void setNomEditorial(String nomEditorial)
    {
        this.nomEditorial = nomEditorial;
    }

    public String getPaginaWeb()
    {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb)
    {
        this.paginaWeb = paginaWeb;
    }

    public String getPaisOrigen()
    {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen)
    {
        this.paisOrigen = paisOrigen;
    }
}
