package modelo;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

public class Prestamo
{
 private int numPrestamo;
 private String idUsuario;
 private String idEmpleado;
 private String fechaR;

 public Prestamo()
 {

 }

 public Prestamo(int numPrestamo, String idUsuario, String idEmpleado, String fechaR) {
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

 public String getFechaR() {
  return fechaR;
 }

 public void setFechaR(String fechaR) {
  this.fechaR = fechaR;
 }
}
