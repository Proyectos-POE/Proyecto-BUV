package dao;
import java.sql.*;
import java.util.ArrayList;
import modelo.Libro;

public class DaoLibro
{
    FachadaBd fachada;
    Connection conn;

    DaoLibro()
    {
        fachada = new FachadaBd();
    }

    public int insertLibro(Libro lb)
    {
        String sql_lb;

        sql_lb = "INSERT INTO libro(isbn, codigo_ed, anho_publi, num_paginas, idioma) VALUES('"+ lb.getIsbn() + "', '" +
                lb.getCodigoEditorial() + "', '" + lb.getAnhoPublicacion() + "', '" + lb.getNumPaginas() + "', '" +
                lb.getIdioma() +"')";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaLb = conn.createStatement();
            int numFilas1 = sentenciaLb.executeUpdate(sql_lb);
            conn.close();
            return numFilas1;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Libro consultarLibro(String isbn)
    {
        Libro lb = new Libro();
        String sql_select;
        sql_select = "SELECT isbn, codigo_ed, anho_publi, num_paginas, idioma FROM libro WHERE isbn='" + isbn + "'";

        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

                lb.setIsbn(tabla.getString(1));
                lb.setCodigoEditorial(tabla.getString(2));
                lb.setAnhoPublicacion(tabla.getString(3));
                lb.setNumPaginas(tabla.getString(4));
                lb.setIdioma(tabla.getString(5));
            }

            return lb;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Libro> listarLibro(){
        ArrayList<Libro> arrayLb = new ArrayList<>();
        String sql_select;
        sql_select="SELECT isbn, codigo_ed, anho_publi, num_paginas, idioma FROM  libro";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            do{
                Libro lb = new Libro();
                lb.setIsbn(tabla.getString(1));
                lb.setCodigoEditorial(tabla.getString(2));
                lb.setAnhoPublicacion(tabla.getString(3));
                lb.setNumPaginas(tabla.getString(4));
                lb.setIdioma(tabla.getString(5));
                arrayLb.add(lb);
            }while (tabla.next());

            return arrayLb;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarLibro(Libro lb)
    {
        String sql_lb;

        sql_lb = "UPDATE libro" + " SET isbn = '" + lb.getIsbn() + "', codigo_ed = '"+ lb.getCodigoEditorial() + "', anho_publi = '" + lb.getAnhoPublicacion() + "', num_paginas = '" + lb.getNumPaginas() + "', idioma = '" + lb.getIdioma() + "' WHERE isbn = '" + lb.getIsbn() + "'";

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
}
