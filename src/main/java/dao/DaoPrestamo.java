package dao;

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
                pres.getNumPrestamo() + "', '" + pres.getIdUsuario() +"', '" + pres.getIdEmpleado() +"', '" + pres.getFechaR() +"')";

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
                pres.setFechaR(tabla.getDate(4));
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
        sql_select="SELECT num_prestamo, id_usuario, id_empleado, fecha FROM prestamo ORDER BY num_prestamo";
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
        sql_select="SELECT num_prestamo, id_usuario, id_empleado, fecha FROM prestamo WHERE id_usuario='" + id + "'";
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

    public boolean modificarPrestamo(Prestamo pres){
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
}
