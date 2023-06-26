package dao;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

import modelo.AutorLibro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoAutorLibro {

    FachadaBd fachada;

    public DaoAutorLibro()
        {
            fachada = new FachadaBd();
        }

    public boolean eliminarAutorLibro(String isbn){
        String sql_lb;

        sql_lb = "DELETE FROM autor_libro WHERE isbn = '" + isbn + "'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaLb = conn.createStatement();
            sentenciaLb.executeUpdate(sql_lb);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }

    public ArrayList<String> consultarNomsAutoresLibro(String isbn)
    {
        String nombreAutor;
        ArrayList<String> Nombres;
        String sql_select;
        sql_select = "SELECT Concat(primer_nom, ' ', primer_apellido) FROM autor_libro INNER JOIN autor ON autor_libro.cod_autor = autor.codigo_autor  WHERE isbn='" + isbn + "'";

        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            Nombres = new ArrayList<>();
            while(tabla.next()){

                nombreAutor =  tabla.getString(1);
                Nombres.add(nombreAutor);
            }
            conn.close();
            return Nombres;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }
    }




