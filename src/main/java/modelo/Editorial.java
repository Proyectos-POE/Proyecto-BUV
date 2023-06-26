package modelo;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

public class Editorial
{
    private int codEditorial;
    private String nomEditorial;
    private String paginaWeb;
    private String paisOrigen;

    public Editorial(String auxNomEditorial, String auxPaginaWeb, String auxPaisOrigen)
    {
        this.nomEditorial = auxNomEditorial;
        this.paginaWeb = auxPaginaWeb;
        this.paisOrigen = auxPaisOrigen;
    }

    public Editorial(){}

    public int getCodEditorial()
    {
        return codEditorial;
    }

    public void setCodEditorial(int codEditorial)
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
