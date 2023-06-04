package modelo;
import modelo.Usuario;
import java.util.Date;

public class Multa
{
    private String idUsuario;
    private String isbn;
    private int numEjemplar;
    private Date fechaMulta;
    private int valor;
    private String descripcion;

    public Multa (String auxIdUsuario, String auxIsbn, int auxNumEjemplar, Date auxFechaMulta, int auxValor, String auxDescripcion)
    {
        this.idUsuario = auxIdUsuario;
        this.isbn = auxIsbn;
        this.numEjemplar = auxNumEjemplar;
        this.fechaMulta = auxFechaMulta;
        this.valor = auxValor;
        this.descripcion = auxDescripcion;
    }

    public Multa() {}

    public String getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public int getNumEjemplar()
    {
        return numEjemplar;
    }

    public void setNumEjemplar(int numEjemplar)
    {
        this.numEjemplar = numEjemplar;
    }

    public Date getFechaMulta()
    {
        return fechaMulta;
    }

    public void setFechaMulta(Date fechaMulta)
    {
        this.fechaMulta = fechaMulta;
    }

    public int getValor()
    {
        return valor;
    }

    public void setValor(int valor)
    {
        this.valor = valor;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
}
