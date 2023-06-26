package modelo;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

public class Multa
{
    private String idUsuario;
    private String isbn;
    private int numEjemplar;
    private String fechaMulta;
    private int valor;
    private String descripcion;
    private boolean devuelto;

    public Multa (String auxIdUsuario, String auxIsbn, int auxNumEjemplar, String auxFechaMulta, int auxValor, String auxDescripcion, boolean auxDevuelto)
    {
        this.idUsuario = auxIdUsuario;
        this.isbn = auxIsbn;
        this.numEjemplar = auxNumEjemplar;
        this.fechaMulta = auxFechaMulta;
        this.valor = auxValor;
        this.descripcion = auxDescripcion;
        this.devuelto = auxDevuelto;
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

    public String getFechaMulta()
    {
        return fechaMulta;
    }

    public void setFechaMulta(String fechaMulta)
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
    public boolean isDevuelto() {
        return devuelto;
    }
    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
}
