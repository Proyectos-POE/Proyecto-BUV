package dao;

import modelo.PrestamoLibro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoPrestamoLibro
{
    FachadaBd fachada;
    Connection conn;

    public DaoPrestamoLibro()
    {
            fachada = new FachadaBd();
    }

    public int insertPrestamoLibro(PrestamoLibro presLib){
        String sql_pres;
        String sql_PresLib;
        sql_pres = "INSERT INTO prestamo_libro(num_prestamo, isbn, num_ejemplar, fecha_devolucion, estado) VALUES ('" +
                presLib.getNumero() + "', '" + presLib.getIsbn() +"', '" + presLib.getNumEjemplar() +"', '" + presLib.getFechaDev() + "', '" + false + "')";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaPres = conn.createStatement();
            int numFilas1 = sentenciaPres.executeUpdate(sql_pres);
            conn.close();
            return numFilas1;
            }
            catch(SQLException e){ System.out.println(e); }
            catch(Exception e){ System.out.println(e); }
            return -1;
        }

        public ArrayList<PrestamoLibro> consultarPrestamosLibros(int numero){
            PrestamoLibro prestamoLibro;
            ArrayList<PrestamoLibro> prestamos = new ArrayList<>();
            String sql_select;
            sql_select="SELECT num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado FROM prestamo_libro WHERE num_prestamo=" + numero +  "";
            try{
                Connection conn= fachada.openConnection();
                System.out.println("consultando en la bd");
                Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql_select);

                while(tabla.next()){
                    prestamoLibro = new PrestamoLibro();
                    prestamoLibro.setNumero(tabla.getInt(1));
                    prestamoLibro.setIsbn(tabla.getString(2));
                    prestamoLibro.setNumEjemplar(tabla.getInt(3));
                    prestamoLibro.setFechaDev(tabla.getDate(4));
                    prestamoLibro.setEstado(tabla.getBoolean(5));
                    prestamos.add(prestamoLibro);
                }
                conn.close();
                return prestamos;
            }
            catch(SQLException e){ System.out.println(e); }
            catch(Exception e){ System.out.println(e); }
            return null;
        }

    public ArrayList<PrestamoLibro> consultarPrestamosActivos(int numero){
        PrestamoLibro prestamoLibro;
        ArrayList<PrestamoLibro> prestamos = new ArrayList<>();
        String sql_select;
        sql_select="SELECT num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado FROM prestamo_libro WHERE num_prestamo=" + numero + " AND entregado = " + false + "";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                prestamoLibro = new PrestamoLibro();
                prestamoLibro.setNumero(tabla.getInt(1));
                prestamoLibro.setIsbn(tabla.getString(2));
                prestamoLibro.setNumEjemplar(tabla.getInt(3));
                prestamoLibro.setFechaDev(tabla.getDate(4));
                prestamoLibro.setEstado(tabla.getBoolean(5));
                prestamos.add(prestamoLibro);
            }
            conn.close();
            return prestamos;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarEstado(int numeroPres, String isbn, int numEjem, boolean estado)
    {
        String sql_ej;

        sql_ej = "UPDATE prestamo_libro" + " SET entregado = '" + estado +  "' WHERE isbn = '" + isbn + "' AND num_prestamo = '" + numeroPres + "'AND num_ejemplar = '" + numEjem + "'";

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

    public PrestamoLibro getPl(int numeroPres, String isbn, int numEjem)
    {
        PrestamoLibro pres = new PrestamoLibro();
        String sql_select;
        sql_select="SELECT num_prestamo, isbn, num_ejemplar, fecha_devolucion, entregado FROM prestamo_libro WHERE isbn = '" + isbn + "' AND num_prestamo = '" + numeroPres + "' AND num_ejemplar = " + numEjem + "";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            while(tabla.next()){
                pres.setNumero(tabla.getInt(1));
                pres.setIsbn(tabla.getString(2));
                pres.setNumEjemplar(tabla.getInt(3));
                pres.setFechaDev(tabla.getDate(4));
                pres.setEstado(tabla.getBoolean(5));
            }
            conn.close();
            return pres;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }
}

