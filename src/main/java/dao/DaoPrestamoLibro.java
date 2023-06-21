package dao;

import modelo.Prestamo;
import modelo.PrestamoLibro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoPrestamoLibro
{
    FachadaBd fachada;
    Connection conn;

    public DaoPrestamoLibro()
    {
            fachada = new FachadaBd();
    }

    public int insertPrestamoLibro(PrestamoLibro presLib){
        String sql_pres;
        String sql_PresLib;
        sql_pres = "INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion) VALUES ('" +
                presLib.getNumero() + "', '" + presLib.getIsbn() +"', '" + presLib.getNumEjemplar() +"', '" + presLib.getFechaDev() +"')";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaPres = conn.createStatement();
            int numFilas1 = sentenciaPres.executeUpdate(sql_pres);
            conn.close();
            return numFilas1;
            }
            catch(SQLException e){ System.out.println(e); }
            catch(Exception e){ System.out.println(e); }
            return -1;
        }

        public ArrayList<PrestamoLibro> consultarPrestamosLibros(int numero){
            PrestamoLibro prestamoLibro;
            ArrayList<PrestamoLibro> prestamos = new ArrayList<>();
            String sql_select;
            sql_select="SELECT num_prestamo, isbn, num_ejemplar, fecha_devolucion FROM prestamo_libro WHERE num_prestamo=" + numero +  "";
            try{
                Connection conn= fachada.openConnection();
                System.out.println("consultando en la bd");
                Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql_select);

                while(tabla.next()){
                    prestamoLibro = new PrestamoLibro();
                    prestamoLibro.setNumero(tabla.getInt(1));
                    prestamoLibro.setIsbn(tabla.getString(2));
                    prestamoLibro.setNumEjemplar(tabla.getInt(3));
                    prestamoLibro.setFechaDev(tabla.getDate(4));
                    prestamos.add(prestamoLibro);
                }
                conn.close();
                return prestamos;
            }
            catch(SQLException e){ System.out.println(e); }
            catch(Exception e){ System.out.println(e); }
            return null;
        }
        /*
        public ArrayList<Prestamo> listarPrestamos(){
            ArrayList<Prestamo> arrayPres = new ArrayList<>();
            String sql_select;
            sql_select="SELECT num_prestamo, id_usuario, id_empleado, fecha, isbn, num_ejemplar, fecha_devolucion FROM prestamo NATURAL JOIN prestamo_libro";
            try{
                Connection conn= fachada.openConnection();
                System.out.println("consultando en la bd");
                Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql_select);

                while (tabla.next()){
                    Prestamo pres = new Prestamo();
                    pres.setNumPrestamo(tabla.getInt(1));
                    pres.setIdUsuario(tabla.getString(2));
                    pres.setIdEmpleado(tabla.getString(3));
                    pres.setFechaR(tabla.getDate(4));
                    arrayPres.add(pres);
                }
                conn.close();
                return arrayPres;
            }
            catch(SQLException e){ System.out.println(e); }
            catch(Exception e){ System.out.println(e); }
            return null;
        }

        public ArrayList<Prestamo> listarPrestamosU(String id){
            ArrayList<Prestamo> arrayPres = new ArrayList<>();
            String sql_select;
            sql_select="SELECT num_prestamo, id_usuario, id_empleado, fecha, isbn, num_ejemplar, fecha_devolucion FROM prestamo WHERE id_usuario='" + id + "'";
            try{
                Connection conn= fachada.openConnection();
                System.out.println("consultando en la bd");
                Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql_select);

                while (tabla.next()){
                    Prestamo pres = new Prestamo();
                    pres.setNumPrestamo(tabla.getInt(1));
                    pres.setIdUsuario(tabla.getString(2));
                    pres.setIdEmpleado(tabla.getString(3));
                    pres.setFechaR(tabla.getDate(4));
                    arrayPres.add(pres);
                }
                conn.close();
                return arrayPres;
            }
            catch(SQLException e){ System.out.println(e); }
            catch(Exception e){ System.out.println(e); }
            return null;
        }
        public boolean modificarPrestamo(Prestamo pres)
        {
            String sql_pres;

            sql_pres = "UPDATE Prestamo" + " SET id_usuario = '" + pres.getIdUsuario() + "', id_empleado = '" + pres.getIdEmpleado() + "', fecha = '"  + pres.getFechaR() +"'";

            try{
                Connection conn= fachada.openConnection();
                Statement sentenciaPres = conn.createStatement();
                sentenciaPres.executeUpdate(sql_pres);
                conn.close();
                return true;
            }
            catch(SQLException e){ System.out.println(e); }
            catch(Exception e){ System.out.println(e); }
            return false;
    }

         */
}

