package dao;
import java.sql.*;
import java.util.ArrayList;
import modelo.Autor;

public class DaoAutor
{
    FachadaBd fachada;

    Connection conn;

    public DaoAutor()
    {
        fachada = new FachadaBd();
    }

    public int insertAutor(Autor at)
    {
        String sql_at;

        sql_at = "INSERT INTO autor(primer_nom, segundo_nom, primer_apellido, segundo_apellido) VALUES('"+
                at.getPrimerNombre() + "', '" + at.getSegundoNombre() + "', '" + at.getPrimerApellido() + "', '" +
                at.getSegundoApellido() +"')";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaAt = conn.createStatement();
            int numFilas1 = sentenciaAt.executeUpdate(sql_at);
            conn.close();
            return numFilas1;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Autor consultarAutor(int codAutor)
    {
        Autor at = new Autor();
        String sql_select;
        sql_select = "SELECT codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido FROM autor WHERE codigo_autor='" + codAutor + "'";

        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

                at.setCodAutor(tabla.getInt(1));
                at.setPrimerNombre(tabla.getString(2));
                at.setSegundoNombre(tabla.getString(3));
                at.setPrimerApellido(tabla.getString(4));
                at.setSegundoApellido(tabla.getString(5));
            }
            conn.close();
            return at;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public String consultarNomAutor(int codAutor)
    {
        String nombreAutor = null;
        String sql_select;
        sql_select = "SELECT Concat(primer_nom, ' ', primer_apellido) FROM autor WHERE codigo_autor='" + codAutor + "'";

        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                nombreAutor = tabla.getString(1);
            }
            conn.close();
            return nombreAutor;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Autor> listarAutores(){
        ArrayList<Autor> arrayAt = new ArrayList<>();
        String sql_select;
        sql_select="SELECT codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido FROM  autor ORDER BY codigo_autor";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()){
                Autor at = new Autor();
                at.setCodAutor(tabla.getInt(1));
                at.setPrimerNombre(tabla.getString(2));
                at.setSegundoNombre(tabla.getString(3));
                at.setPrimerApellido(tabla.getString(4));
                at.setSegundoApellido(tabla.getString(5));
                arrayAt.add(at);
            }
            conn.close();
            return arrayAt;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarAutor(Autor at)
    {
        String sql_at;

        sql_at = "UPDATE autor" + " SET primer_nom = '"+ at.getPrimerNombre() + "', segundo_nom = '" + at.getSegundoNombre() + "', primer_apellido = '" + at.getPrimerApellido() + "', segundo_apellido = '" + at.getSegundoApellido() + "' WHERE codigo_autor = '" + at.getCodAutor() + "'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaAt = conn.createStatement();
            sentenciaAt.executeUpdate(sql_at);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}


