package modelo;

import java.util.Date;

public class Prestamo
{
 private int numPrestamo;
 private String idUsuario;
 private String idEmpleado;
 private Date fecha;
 private String isbn;
 private int numEjemplar;
 private Date fechaDevolucion;

 public Prestamo()
 {

 }

 public Prestamo(int numPrestamo, String idUsuario, String idEmpleado, Date fecha, String isbn, int numEjemplar, Date fechaDevolucion) {
  this.numPrestamo = numPrestamo;
  this.idUsuario = idUsuario;
  this.idEmpleado = idEmpleado;
  this.fecha = fecha;
  this.isbn = isbn;
  this.numEjemplar = numEjemplar;
  this.fechaDevolucion = fechaDevolucion;
 }

 public int getNumPrestamo() {
  return numPrestamo;
 }

 public void setNumPrestamo(int numPrestamo) {
  this.numPrestamo = numPrestamo;
 }

 public String getIdUsuario() {
  return idUsuario;
 }

 public void setIdUsuario(String idUsuario) {
  this.idUsuario = idUsuario;
 }

 public String getIdEmpleado() {
  return idEmpleado;
 }

 public void setIdEmpleado(String idEmpleado) {
  this.idEmpleado = idEmpleado;
 }

 public Date getFecha() {
  return fecha;
 }

 public void setFecha(Date fecha) {
  this.fecha = fecha;
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

 public Date getFechaDevolucion()
 {
  return fechaDevolucion;
 }

 public void setFechaDevolucion(Date fechaDevolucion)
 {
  this.fechaDevolucion = fechaDevolucion;
 }
}
