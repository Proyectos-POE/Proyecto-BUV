package dao;

import modelo.Empleado;
import modelo.Prestamo;
import modelo.Solicitud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoSolicitud {
    FachadaBd fachada;
    Connection conn;

    DaoSolicitud(){
        fachada = new FachadaBd();
    }

    public int insertSolicitud(Solicitud soli){
        String sql_soli;

        sql_soli = "INSERT INTO prestamo(num_solicitud, id_usuario, isbn, titulo, descripcion) VALUES ('" +
                soli.getNumero() + "', '" + soli.getIdUsuario() +"', '" + soli.getIsbnLibro() +"', '" + soli.getTitulo() +"', '" + soli.getDescripcion() +"')";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaSoli = conn.createStatement();
            int numFilas1 = sentenciaSoli.executeUpdate(sql_soli);
            conn.close();
            return numFilas1;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Solicitud consultarSolicitud(int numero){
        Solicitud soli = new Solicitud();
        String sql_select;
        sql_select="SELECT * FROM  solicitud WHERE num_solicitud='" + numero +  "'";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                soli.setNumero(tabla.getInt(1));
                soli.setIdUsuario(tabla.getString(2));
                soli.setIsbnLibro(tabla.getString(3));
                soli.setTitulo(tabla.getString(4));
                soli.setDescripcion(tabla.getString(5));
            }

            return soli;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Solicitud> listarSolicitud(){
        ArrayList<Solicitud> arraySoli = new ArrayList<>();
        String sql_select;
        sql_select="SELECT * FROM  solicitud";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            do{
                Solicitud soli = new Solicitud();
                soli.setNumero(tabla.getInt(1));
                soli.setIdUsuario(tabla.getString(2));
                soli.setIsbnLibro(tabla.getString(3));
                soli.setTitulo(tabla.getString(4));
                soli.setDescripcion(tabla.getString(5));
                arraySoli.add(soli);
            }while (tabla.next());

            return arraySoli;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarSolicitud(Solicitud soli){
        String sql_soli;

        sql_soli = "UPDATE solicitud" + " SET num_solicitud = '" + soli.getNumero() + "', id_usuario = '" + soli.getIdUsuario() + "', isbn = '" + soli.getIsbnLibro() + "', titulo = '"  + soli.getTitulo() +"', descripcion = '"  + soli.getDescripcion() +"'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaPres = conn.createStatement();
            sentenciaPres.executeUpdate(sql_soli);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}
