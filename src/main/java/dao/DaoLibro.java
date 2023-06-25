package dao;
import java.sql.*;
import java.time.Year;
import java.util.ArrayList;
import modelo.Libro;

public class DaoLibro
{
    FachadaBd fachada;
    Connection conn;

    public DaoLibro()
    {
        fachada = new FachadaBd();
    }

    public int insertLibro(Libro lb)
    {
        String sql_lb;

        sql_lb = "INSERT INTO libro(isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma) VALUES('"+ lb.getIsbn() + "', '" +
                lb.getTitulo() + "', '" + lb.getCodEditorial() + "', '" + lb.getAnhoPublicacion() + "', '" + lb.getNumPaginas() + "', '" +
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
        sql_select = "SELECT isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma FROM libro WHERE isbn='" + isbn + "'";

        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

                lb.setIsbn(tabla.getString(1));
                lb.setTitulo(tabla.getString(2));
                lb.setCodEditorial(tabla.getInt(3));
                lb.setAnhoPublicacion(tabla.getInt(4));
                lb.setNumPaginas(tabla.getString(5));
                lb.setIdioma(tabla.getString(6));
            }
            conn.close();
            return lb;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Libro> listarLibro(){
        ArrayList<Libro> arrayLb = new ArrayList<>();
        String sql_select;
        sql_select="SELECT isbn, titulo, codigo_ed, anho_publi, num_paginas, idioma FROM  libro";
        try{

            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()){
                Libro lb = new Libro();
                lb.setIsbn(tabla.getString(1));
                lb.setTitulo(tabla.getString(2));
                lb.setCodEditorial(tabla.getInt(3));
                lb.setAnhoPublicacion(tabla.getInt(4));
                lb.setNumPaginas(tabla.getString(5));
                lb.setIdioma(tabla.getString(6));
                arrayLb.add(lb);
            }

            conn.close();
            return arrayLb;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarLibro(Libro lb)
    {
        String sql_lb;

        sql_lb = "UPDATE libro" + " SET isbn = '" + lb.getIsbn() + "', titulo = '"+ lb.getTitulo() +"', codigo_ed = '"+ lb.getCodEditorial() + "', anho_publi = '" + lb.getAnhoPublicacion() + "', num_paginas = '" + lb.getNumPaginas() + "', idioma = '" + lb.getIdioma() + "' WHERE isbn = '" + lb.getIsbn() + "'";

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

    public boolean eliminarLibro(String isbn){
        String sql_lb;

        sql_lb = "DELETE FROM libro WHERE isbn = '" + isbn + "'";

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

    public ArrayList<Libro> listarLibroED()
    {
        ArrayList<Libro> arrayLb = new ArrayList<>();
        String sql_select;
        sql_select="SELECT isbn, titulo, codigo_ed, cod_area, anho_publi, num_paginas, idioma FROM  libro";
        try
        {

            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next())
            {
                Libro lb = new Libro();
                lb.setIsbn(tabla.getString(1));
                lb.setTitulo(tabla.getString(2));
                lb.setCodEditorial(tabla.getInt(3));
                lb.setAnhoPublicacion(tabla.getInt(4));
                lb.setNumPaginas(tabla.getString(5));
                lb.setIdioma(tabla.getString(6));
                arrayLb.add(lb);
            }

            conn.close();
            return arrayLb;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public int numeroEjemplaresLibro(String isbn)
    {
        int numeroEjemplares = 0;
        String sql_select;
        sql_select="SELECT COUNT(*) FROM ejemplar WHERE isbn = '" + isbn + "'";
        try
        {

            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next())
            {
                numeroEjemplares = tabla.getInt(1);
            }

            conn.close();
            return numeroEjemplares;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return 0;
    }

    public boolean existeDigitalLibro(String isbn)
    {
        String sql_select;
        sql_select="SELECT num_digital FROM digital WHERE isbn = '" + isbn + "'";
        try
        {

            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            conn.close();

            return !tabla.isBeforeFirst() && tabla.getRow() == 0;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}
