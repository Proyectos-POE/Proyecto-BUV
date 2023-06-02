package modelo;

import java.util.Date;

public class Prestamo
{
 private int numPrestamo;
 private String idUsuario;
 private String idEmpleado;
 private Date fecha;

 public Prestamo()
 {

 }

 public Prestamo(int numPrestamo, String idUsuario, String idEmpleado, Date fecha) {
  this.numPrestamo = numPrestamo;
  this.idUsuario = idUsuario;
  this.idEmpleado = idEmpleado;
  this.fecha = fecha;
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
}
