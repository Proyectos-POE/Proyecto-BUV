package modelo;

public class Ejemplar extends Libro
{
    private int numEjemplar;
    private int estante;
    private int numCajon;
    private String nomSala;
    private int numPasillo;

    public Ejemplar(String auxIsbn, int auxNumEjemplar, int auxEstante, int auxNumCajon, String auxNomSala, int auxNumPasillo)
    {
        this.isbn = auxIsbn;
        this.numEjemplar = auxNumEjemplar;
        this.estante = auxEstante;
        this.numCajon = auxNumCajon;
        this.nomSala = auxNomSala;
        this.numPasillo = auxNumPasillo;
    }

    public Ejemplar(){}

    public int getNumEjemplar()
    {
        return numEjemplar;
    }

    public void setNumEjemplar(int numEjemplar)
    {
        this.numEjemplar = numEjemplar;
    }

    public int getEstante()
    {
        return estante;
    }

    public void setEstante(int estante)
    {
        this.estante = estante;
    }

    public int getNumCajon()
    {
        return numCajon;
    }

    public void setNumCajon(int numCajon)
    {
        this.numCajon = numCajon;
    }

    public String getNomSala()
    {
        return nomSala;
    }

    public void setNomSala(String nomSala)
    {
        this.nomSala = nomSala;
    }

    public int getNumPasillo()
    {
        return numPasillo;
    }

    public void setNumPasillo(int numPasillo)
    {
        this.numPasillo = numPasillo;
    }
}