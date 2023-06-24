package modelo;

public class Digital extends Libro
{
    private int numDigital;
    private String url;
    private String formato;
    private String bytes;

    public Digital(String auxIsbn, String auxUrl, String auxFormato, String auxBytes)
    {
        this.isbn = auxIsbn;
        this.url = auxUrl;
        this.formato = auxFormato;
        this.bytes = auxBytes;
    }

    public Digital(){}

    public int getNumDigital()
    {
        return numDigital;
    }

    public void setNumDigital(int numDigital)
    {
        this.numDigital = numDigital;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getFormato()
    {
        return formato;
    }

    public void setFormato(String formato)
    {
        this.formato = formato;
    }

    public String getBytes()
    {
        return bytes;
    }

    public void setBytes(String bytes)
    {
        this.bytes = bytes;
    }
}
