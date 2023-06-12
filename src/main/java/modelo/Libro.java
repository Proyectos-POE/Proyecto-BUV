package modelo;

public class Libro
{
    protected String isbn;
    private String titulo;
    private String codigoEditorial;
    private String anhoPublicacion;
    private String numPaginas;
    private String idioma;

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

    public String getCodigoEditorial()
    {
        return codigoEditorial;
    }

    public void setCodigoEditorial(String codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }

    public String getAnhoPublicacion()
    {
        return anhoPublicacion;
    }

    public void setAnhoPublicacion(String anhoPublicacion) {
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
