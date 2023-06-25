package modelo;

import java.util.Date;

public class PrestamoLibro
{
    private int numero;
    private String isbn;
    private int numEjemplar;
    private String fechaDev;
    private boolean estado;

    public PrestamoLibro()
    {

    }

    public PrestamoLibro(int auxNumero, String auxIsbn, int auxNumE, String auxfechaD)
    {
        this.numero = auxNumero;
        this.isbn = auxIsbn;
        this.numEjemplar = auxNumE;
        this.fechaDev = auxfechaD;
        this.estado = false;
    }

    public PrestamoLibro(int auxNumero, String auxIsbn, int auxNumE, String auxfechaD, boolean auxEstado)
    {
        this.numero = auxNumero;
        this.isbn = auxIsbn;
        this.numEjemplar = auxNumE;
        this.fechaDev = auxfechaD;
        this.estado = auxEstado;
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

    public String getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(String fechaDev) {
        this.fechaDev = fechaDev;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
