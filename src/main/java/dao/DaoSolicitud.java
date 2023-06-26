package dao;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

import modelo.Solicitud;

import java.sql.*;
import java.util.ArrayList;

public class DaoSolicitud {
    FachadaBd fachada;

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

    public ArrayList<Solicitud> listarAllSolicitudes(){
        ArrayList<Solicitud> arraySoli = new ArrayList<>();
        String sql_select;
        sql_select="SELECT num_solicitud, id_usuario, isbn, titulo, descripcion FROM solicitud ORDER BY num_solicitud";
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

    public ArrayList<Solicitud> listarSolicitudesUsuario(String id){
        ArrayList<Solicitud> arraySoli = new ArrayList<>();
        String sql_select;
        sql_select="SELECT num_solicitud, id_usuario, isbn, titulo, descripcion FROM solicitud WHERE id_usuario = '" + id +  "' ORDER BY num_solicitud";
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

    public Solicitud consultarUltimaSolicitud(int codUsuario){
        Solicitud soli = new Solicitud();
        String sql_select;
        sql_select="SELECT num_solicitud, id_usuario, isbn, titulo, descripcion FROM solicitud WHERE num_solicitud = (SELECT MAX(num_solicitud) FROM solicitud WHERE id_usuario ='" + codUsuario + "')";
        System.out.println(sql_select);

        try
        {
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next())
            {
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
}
