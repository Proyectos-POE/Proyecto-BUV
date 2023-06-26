package dao;
import java.sql.*;
import java.util.ArrayList;

import modelo.Digital;
import modelo.Ejemplar;

public class DaoEjemplar
{
    FachadaBd fachada;

    Connection conn;

    public DaoEjemplar()
    {
        fachada = new FachadaBd();
    }

    public int insertEjemplar(Ejemplar ej)
    {
        String sql_ej;

        sql_ej = "INSERT INTO ejemplar(isbn, estante, num_cajon, nom_sala, num_pasillo, disponible) VALUES('"+ ej.getIsbn() +
                "', '" + ej.getEstante() + "', '" + ej.getNumCajon() + "', '" + ej.getNomSala() +"', '"
                + ej.getNumPasillo() + "', '"
                + true +"')";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEj = conn.createStatement();
            int numFilas1 = sentenciaEj.executeUpdate(sql_ej);
            conn.close();
            return numFilas1;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Ejemplar consultarEjemplar(String isbn, int numEJemplar)
    {
        Ejemplar ej = new Ejemplar();
        String sql_select;
        sql_select = "SELECT isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible FROM ejemplar WHERE isbn='" + isbn + "' AND num_ejemplar =" + numEJemplar +"";

        try{

            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

                ej.setIsbn(tabla.getString(1));
                ej.setNumEjemplar(tabla.getInt(2));
                ej.setEstante(tabla.getInt(3));
                ej.setNumCajon(tabla.getInt(4));
                ej.setNomSala(tabla.getString(5));
                ej.setNumPasillo(tabla.getInt(6));
                ej.setEstado(tabla.getBoolean(7));
            }

            conn.close();
            return ej;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Ejemplar> listarEjemplar(){
        ArrayList<Ejemplar> arrayEj = new ArrayList<>();
        String sql_select;
        sql_select="SELECT isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible FROM  ejemplar";
        try{

            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()){
                Ejemplar ej = new Ejemplar();
                ej.setIsbn(tabla.getString(1));
                ej.setNumEjemplar(tabla.getInt(2));
                ej.setEstante(tabla.getInt(3));
                ej.setNumCajon(tabla.getInt(4));
                ej.setNomSala(tabla.getString(5));
                ej.setNumPasillo(tabla.getInt(6));
                ej.setEstado(tabla.getBoolean(7));
                arrayEj.add(ej);
            }

            conn.close();
            return arrayEj;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarEjemplar(Ejemplar ej)
    {
        String sql_ej;

        sql_ej = "UPDATE ejemplar" + " SET isbn = '" + ej.getIsbn() + "', estante = '" + ej.getEstante() + "', num_cajon = '" + ej.getNumCajon() + "', nom_sala = '" + ej.getNomSala() + "', num_pasillo = '" + ej.getNumPasillo() + "' WHERE isbn = '" + ej.getIsbn() + "' AND num_ejemplar = '" + ej.getNumEjemplar() + "'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEj = conn.createStatement();
            sentenciaEj.executeUpdate(sql_ej);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }

    public boolean modificarEstadoEjemplar(String isbn, int numero, boolean estado)
    {
        String sql_ej;

        sql_ej = "UPDATE ejemplar" + " SET disponible = '" + estado +  "' WHERE isbn = '" + isbn + "' AND num_ejemplar = '" + numero+ "'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEj = conn.createStatement();
            sentenciaEj.executeUpdate(sql_ej);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }

    public boolean eliminarEjemplar(String isbn, int numEjemplar)
    {
        String sql_ej;
        sql_ej = "DELETE FROM ejemplar WHERE isbn = '" + isbn + "' AND num_ejemplar = '" + numEjemplar + "'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEj = conn.createStatement();
            sentenciaEj.executeUpdate(sql_ej);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }

    public ArrayList<Integer> getEjemplaresDisponibles(String isbn)
    {
        ArrayList<Integer> ejemplares;
        int numEjemplar;
        String sql_select;
        sql_select = "SELECT num_ejemplar FROM ejemplar WHERE isbn = '" + isbn + "' AND disponible = '" + true + "'";
        try{

            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            ejemplares = new ArrayList<>();
            while (tabla.next()){
                numEjemplar = tabla.getInt(1);
                ejemplares.add(numEjemplar);
            }

            conn.close();
            return ejemplares;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public Ejemplar consultarUltimoEjemplar(String isbn)
    {
        Ejemplar ejem = new Ejemplar();
        String sql_select;
        sql_select = "SELECT isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo, disponible FROM ejemplar WHERE num_ejemplar = (SELECT MAX(num_ejemplar) FROM ejemplar WHERE isbn = '" + isbn +"')";

        try{
            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next())
            {
                ejem.setIsbn(tabla.getString(1));
                ejem.setNumEjemplar(tabla.getInt(2));
                ejem.setEstante(tabla.getInt(3));
                ejem.setNumCajon(tabla.getInt(4));
                ejem.setNomSala(tabla.getString(5));
                ejem.setNumPasillo(tabla.getInt(6));
                ejem.setEstado(tabla.getBoolean(7));
            }
            return ejem;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }


}
