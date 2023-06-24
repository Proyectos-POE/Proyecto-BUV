package modelo;

import java.sql.Time;
import java.util.Date;

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

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaDescarga() {
        return fechaDescarga;
    }

    public void setFechaDescarga(String fechaDescarga) {
        this.fechaDescarga = fechaDescarga;
    }

    public String getHoraDescarga() {
        return horaDescarga;
    }

    public void setHoraDescarga(String horaDescarga) {
        this.horaDescarga = horaDescarga;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
