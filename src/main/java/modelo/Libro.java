package modelo;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

public class Libro
{
    protected String isbn;
    private String titulo;
    private int codEditorial;
    private int codArea;
    private int anhoPublicacion;
    private String numPaginas;
    private String idioma;

    public Libro(String auxIsbn, String auxTitulo, int auxCodEditorial, int auxCodArea, int auxAnhoPublicacion, String auxNumPaginas, String auxIdioma)
    {
        this.isbn = auxIsbn;
        this.titulo = auxTitulo;
        this.codEditorial = auxCodEditorial;
        this.codArea = auxCodArea;
        this.anhoPublicacion = auxAnhoPublicacion;
        this.numPaginas = auxNumPaginas;
        this.idioma = auxIdioma;
    }

    public Libro(){}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodEditorial()
    {
        return codEditorial;
    }

    public void setCodEditorial(int codigoEditorial) {
        this.codEditorial = codigoEditorial;
    }

    public int getCodArea() {
        return codArea;
    }

    public void setCodArea(int codArea) {
        this.codArea = codArea;
    }

    public int getAnhoPublicacion()
    {
        return anhoPublicacion;
    }

    public void setAnhoPublicacion(int anhoPublicacion) {
        this.anhoPublicacion = anhoPublicacion;
    }

    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}