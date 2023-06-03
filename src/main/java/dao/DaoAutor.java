package dao;
import java.sql.*;
import java.util.ArrayList;
import modelo.Autor;
import modelo.Ejemplar;

public class DaoAutor
{
    FachadaBd fachada;

    Connection conn;

    DaoAutor()
    {
        fachada = new FachadaBd();
    }

    public int insertAutor(Autor at)
    {
        String sql_at;

        sql_at = "INSERT INTO autor(codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido) VALUES('"+ at.getCodAutor() + "', '" +
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

    public Autor consultarAutor(String codAutor)
    {
        Autor at = new Autor();
        String sql_select;
        sql_select = "SELECT codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido FROM autor WHERE codigo_autor='" + codAutor + "'";

        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

                at.setCodAutor(tabla.getString(1));
                at.setPrimerNombre(tabla.getString(2));
                at.setSegundoNombre(tabla.getString(3));
                at.setPrimerApellido(tabla.getString(4));
                at.setSegundoApellido(tabla.getString(5));
            }

            return at;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Autor> listarAutor(){
        ArrayList<Autor> arrayAt = new ArrayList<>();
        String sql_select;
        sql_select="SELECT codigo_autor, primer_nom, segundo_nom, primer_apellido, segundo_apellido FROM  autor";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            do{
                Autor at = new Autor();
                at.setCodAutor(tabla.getString(1));
                at.setPrimerNombre(tabla.getString(2));
                at.setSegundoNombre(tabla.getString(3));
                at.setPrimerApellido(tabla.getString(4));
                at.setSegundoApellido(tabla.getString(5));
                arrayAt.add(at);
            }while (tabla.next());

            return arrayAt;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarAutor(Autor at)
    {
        String sql_at;

        sql_at = "UPDATE autor" + " SET codigo_autor = '" + at.getCodAutor() + "', primer_nom = '"+ at.getPrimerNombre() + "', segundo_nom = '" + at.getSegundoNombre() + "', primer_apellido = '" + at.getPrimerApellido() + "', segundo_apellido = '" + at.getSegundoApellido() + "' WHERE codigo_autor = '" + at.getCodAutor() + "'";

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


