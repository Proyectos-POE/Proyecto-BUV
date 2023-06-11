package dao;

import modelo.Empleado;
import modelo.Prestamo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoPrestamo
{
    FachadaBd fachada;
    Connection conn;

    public DaoPrestamo(){
        fachada = new FachadaBd();
    }

    public int insertPrestamo(Prestamo pres){
        String sql_pres;
        String sql_PresLib;

        sql_pres = "INSERT INTO prestamo(num_prestamo, id_usuario, id_empleado, fecha) VALUES ('" +
                pres.getNumPrestamo() + "', '" + pres.getIdUsuario() +"', '" + pres.getIdEmpleado() +"', '" + pres.getFecha() +"')";

        sql_PresLib = "INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion) VALUES ('" +
                pres.getNumPrestamo() + "', '" + pres.getIsbn() +"', '" + pres.getNumEjemplar() +"', '" + pres.getFechaDevolucion() +"')";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaPres = conn.createStatement();
            int numFilas1 = sentenciaPres.executeUpdate(sql_pres);
            int numFilas2 = sentenciaPres.executeUpdate(sql_PresLib);
            conn.close();
            return numFilas1 + numFilas2;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Prestamo consultarPrestamo(String numero){
        Prestamo pres = new Prestamo();
        String sql_select;
        sql_select="SELECT num_prestamo, id_usuario, id_empleado, fecha FROM  prestamo WHERE num_prestamo='" + numero +  "'";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                pres.setNumPrestamo(tabla.getInt(1));
                pres.setIdUsuario(tabla.getString(2));
                pres.setIdEmpleado(tabla.getString(3));
                pres.setFecha(tabla.getDate(4));
            }
            conn.close();
            return pres;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }
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
                pres.setFecha(tabla.getDate(4));
                pres.setIsbn(tabla.getString(5));
                pres.setNumEjemplar(tabla.getInt(6));
                pres.setFechaDevolucion(tabla.getDate(7));
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
        sql_select="SELECT num_prestamo, id_usuario, id_empleado, fecha, isbn, num_ejemplar, fecha_devolucion FROM prestamo NATURAL JOIN prestamo_libro WHERE id_usuario='" + id + "'";
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
                pres.setFecha(tabla.getDate(4));
                pres.setIsbn(tabla.getString(5));
                pres.setNumEjemplar(tabla.getInt(6));
                pres.setFechaDevolucion(tabla.getDate(7));
                arrayPres.add(pres);
            }
            conn.close();
            return arrayPres;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarPrestamo(Prestamo pres){
        String sql_pres;

        sql_pres = "UPDATE Prestamo" + " SET num_prestamo = '" + pres.getNumPrestamo() + "', id_usuario = '" + pres.getIdUsuario() + "', id_empleado = '" + pres.getIdEmpleado() + "', fecha = '"  + pres.getFecha() +"'";

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
}
