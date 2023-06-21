package modelo;

import java.util.Date;

public class Prestamo
{
 private int numPrestamo;
 private String idUsuario;
 private String idEmpleado;
 private Date fechaR;

 public Prestamo()
 {

 }

 public Prestamo(int numPrestamo, String idUsuario, String idEmpleado, Date fechaR) {
  this.numPrestamo = numPrestamo;
  this.idUsuario = idUsuario;
  this.idEmpleado = idEmpleado;
  this.fechaR = fechaR;
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

 public Date getFechaR() {
  return fechaR;
 }

 public void setFechaR(Date fechaR) {
  this.fechaR = fechaR;
 }
}
