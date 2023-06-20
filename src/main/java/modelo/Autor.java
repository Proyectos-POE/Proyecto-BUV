package modelo;

public class Autor
{
    private int codAutor;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    public Autor(String auxPrimerNombre, String auxSegundoNombre, String auxPrimerApellido, String auxSegundoApellido)
    {
        this.primerNombre = auxPrimerNombre;
        this.segundoNombre = auxSegundoNombre;
        this.primerApellido = auxPrimerApellido;
        this.segundoApellido = auxSegundoApellido;
    }

    public Autor(int auxCod, String auxPrimerNombre, String auxSegundoNombre, String auxPrimerApellido, String auxSegundoApellido)
    {
        this.codAutor = auxCod;
        this.primerNombre = auxPrimerNombre;
        this.segundoNombre = auxSegundoNombre;
        this.primerApellido = auxPrimerApellido;
        this.segundoApellido = auxSegundoApellido;
    }

    public Autor()
    {

    }

    public int getCodAutor()
    {
        return codAutor;
    }

    public void setCodAutor(int codAutor)
    {
        this.codAutor = codAutor;
    }

    public String getPrimerNombre()
    {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre)
    {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre()
    {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre)
    {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido()
    {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido)
    {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido()
    {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido)
    {
        this.segundoApellido = segundoApellido;
    }

    public String toString(){return primerNombre + " " + primerApellido;}
}
