package modelo;

public class Libro
{
    protected String isbn;
    private String titulo;
    private int codEditorial;
    private int anhoPublicacion;
    private String numPaginas;
    private String idioma;

    public Libro(String auxIsbn, String auxTitulo, int auxCodEditorial, int auxAnhoPublicacion, String auxNumPaginas, String auxIdioma)
    {
        this.isbn = auxIsbn;
        this.titulo = auxTitulo;
        this.codEditorial = auxCodEditorial;
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
        this.codEditorial = codEditorial;
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
