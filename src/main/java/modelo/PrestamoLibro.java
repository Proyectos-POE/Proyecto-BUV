package modelo;

import java.util.Date;

public class PrestamoLibro
{
    private int numero;
    private String isbn;
    private int numEjemplar;
    private Date fechaDev;

    public PrestamoLibro()
    {

    }

    public PrestamoLibro(int auxNumero, String auxIsbn, int auxNumE, Date auxfechaD)
    {
        this.numero = auxNumero;
        this.isbn = auxIsbn;
        this.numEjemplar = auxNumE;
        this.fechaDev = auxfechaD;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumEjemplar() {
        return numEjemplar;
    }

    public void setNumEjemplar(int numEjemplar) {
        this.numEjemplar = numEjemplar;
    }

    public Date getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(Date fechaDev) {
        this.fechaDev = fechaDev;
    }
}
