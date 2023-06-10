package dao;

import modelo.Solicitud;

import java.sql.*;
import java.util.ArrayList;

public class DaoSolicitud {
    FachadaBd fachada;
    Connection conn;

    public DaoSolicitud(){
        fachada = new FachadaBd();
    }

    public int insertSolicitud(Solicitud soli){
        String sql_soli;

        sql_soli = "INSERT INTO solicitud(id_usuario, isbn, titulo, descripcion) VALUES ('" +
                  soli.getIdUsuario() +"', '" + soli.getIsbnLibro() +"', '" + soli.getTitulo() +"', '" + soli.getDescripcion() +"')";
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
        sql_select="SELECT num_solicitud, id_usuario, isbn, titulo, descripcion FROM  solicitud WHERE num_solicitud='" + numero +  "'";
        try{
            Connection conn= fachada.openConnection();
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
            conn.close();
            return soli;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Solicitud> listarAllSolicitudes(){
        ArrayList<Solicitud> arraySoli = new ArrayList<>();
        String sql_select;
        sql_select="SELECT num_solicitud, id_usuario, isbn, titulo, descripcion FROM solicitud";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
                while (tabla.next()){
                    Solicitud soli = new Solicitud();
                    soli.setNumero(tabla.getInt(1));
                    soli.setIdUsuario(tabla.getString(2));
                    soli.setIsbnLibro(tabla.getString(3));
                    soli.setTitulo(tabla.getString(4));
                    soli.setDescripcion(tabla.getString(5));
                    arraySoli.add(soli);
                }
            conn.close();
            System.out.println("no se encontro nada");
            return arraySoli;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Solicitud> listarSolicitudesUsuario(String id){
        ArrayList<Solicitud> arraySoli = new ArrayList<>();
        String sql_select;
        sql_select="SELECT num_solicitud, id_usuario, isbn, titulo, descripcion FROM solicitud WHERE id_usuario = '" + id +  "'";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            while (tabla.next()){
                Solicitud soli = new Solicitud();
                soli.setNumero(tabla.getInt(1));
                soli.setIdUsuario(tabla.getString(2));
                soli.setIsbnLibro(tabla.getString(3));
                soli.setTitulo(tabla.getString(4));
                soli.setDescripcion(tabla.getString(5));
                arraySoli.add(soli);
            }
            conn.close();
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
