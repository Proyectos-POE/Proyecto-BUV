package dao;

import modelo.AutorLibro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoAutorLibro {

        FachadaBd fachada;

        Connection conn;

        public DaoAutorLibro()
        {
            fachada = new FachadaBd();
        }

        public int insertAutor(AutorLibro autorLibro)
        {
            String sql_autorLibro;

            sql_autorLibro = "INSERT INTO autor_libro(cod_autor, isbn) VALUES('"+
                    autorLibro.getCodAutor() + "', '" + autorLibro.getIsbn() + "')";
            try{
                Connection conn= fachada.openConnection();
                Statement sentenciaAt = conn.createStatement();
                int numFilas1 = sentenciaAt.executeUpdate(sql_autorLibro);
                conn.close();
                return numFilas1;
            }
            catch(SQLException e){ System.out.println(e); }
            catch(Exception e){ System.out.println(e); }
            return -1;
        }

        public ArrayList<Integer> consultarCodsAutores(String isbn)
        {
            AutorLibro at = new AutorLibro();
            ArrayList<Integer> arrayCods = new ArrayList<>();
            String codigoAutor;
            String sql_select;
            sql_select = "SELECT cod_autor FROM autor_libro WHERE isbn='" + isbn + "'";

            try{
                Connection conn= fachada.openConnection();
                System.out.println("consultando en la bd");
                Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql_select);

                while(tabla.next()){

                at.setCodAutor(tabla.getInt(1));
                arrayCods.add(at.getCodAutor());
                }
                conn.close();
                return arrayCods;
            }
            catch(SQLException e){ System.out.println(e); }
            catch(Exception e){ System.out.println(e); }
            return null;
        }
        /*
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

         */

        public boolean modificarAutorLibro(AutorLibro at)
        {
            String sql_at;

            sql_at = "UPDATE autor_libro" + " SET cod_autor = '"+ "'";

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

    public boolean eliminarAutorLibro(String isbn)
    {
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

    public boolean eliminarAutorLibroA(String isbn, int codAutor)
    {
        String sql_lb;

        sql_lb = "DELETE FROM autor_libro WHERE isbn = '" + isbn + "' AND cod_autor = '" + codAutor + "'";

        try
        {
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




