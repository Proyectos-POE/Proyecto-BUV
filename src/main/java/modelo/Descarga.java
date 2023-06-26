package modelo;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

public class Descarga
{
    private String isbn;
    private String url;
    private String idUsuario;
    private String fechaDescarga;
    private String horaDescarga;
    private String ip;

    public Descarga(String isbn, String url, String idUsuario, String fechaDescarga, String horaDescarga, String ip) {
        this.isbn = isbn;
        this.url = url;
        this.idUsuario = idUsuario;
        this.fechaDescarga = fechaDescarga;
        this.horaDescarga = horaDescarga;
        this.ip = ip;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUrl() {
        return url;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getFechaDescarga() {
        return fechaDescarga;
    }

    public String getHoraDescarga() {
        return horaDescarga;
    }

    public String getIp() {
        return ip;
    }
}