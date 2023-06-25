package dao;
import java.util.ArrayList;
import java.sql.*;

import modelo.Multa;

public class DaoMulta
{
    FachadaBd fachada;

    Connection conn;

    public DaoMulta()
    {
        fachada = new FachadaBd();
    }

    public int insertMulta(Multa mlt)
    {
        String sql_mlt;

        sql_mlt = "INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado) VALUES('" + mlt.getIdUsuario() + "', '"
                + mlt.getIsbn() + "', '" +  mlt.getNumEjemplar() + "', '" + mlt.getFechaMulta() +
                "', '" + mlt.getValor() + "', '" + mlt.getDescripcion() + "', '" + mlt.isDevuelto() + "')";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaMlt = conn.createStatement();
            int numFilas1 = sentenciaMlt.executeUpdate(sql_mlt);
            conn.close();
            return numFilas1;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Multa consultarMulta(String idUsuario, String isbn, int numEJemplar, Date fechaMulta)
    {
        Multa mlt = new Multa();
        String sql_select;
        sql_select = "SELECT id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion, estado FROM multa WHERE id_usuario='" + idUsuario + "' AND isbn = '" + isbn + "' AND num_ejemplar ='" + numEJemplar + "' AND fecha_multa = '"+ fechaMulta +  "'";

        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next())
            {
                mlt.setIdUsuario(tabla.getString(1));
                mlt.setIsbn(tabla.getString(2));
                mlt.setNumEjemplar(tabla.getInt(3));
                mlt.setFechaMulta(tabla.getString(4));
                mlt.setValor(tabla.getInt(5));
                mlt.setDescripcion(tabla.getString(6));
            }

            conn.close();
            return mlt;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Multa> listarMultasA()
    {
        ArrayList<Multa> arrayMlt = new ArrayList<>();
        String sql_select;
        sql_select="SELECT id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion FROM  multa ORDER BY id_usuario";
        try{

            Connection conn= fachada.openConnection();
            Statement sentenciaMlt = conn.createStatement();
            System.out.println("consultando en la bd");
            ResultSet tabla = sentenciaMlt.executeQuery(sql_select);

            while (tabla.next()){
                Multa mlt = new Multa();
                mlt.setIdUsuario(tabla.getString(1));
                mlt.setIsbn(tabla.getString(2));
                mlt.setNumEjemplar(tabla.getInt(3));
                mlt.setFechaMulta(tabla.getString(4));
                mlt.setValor(tabla.getInt(5));
                mlt.setDescripcion(tabla.getString(6));
                arrayMlt.add(mlt);
            }

            conn.close();
            return arrayMlt;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Multa> listarMultasU(String cedula)
    {
        ArrayList<Multa> arrayMlt = new ArrayList<>();
        String sql_select;
        sql_select="SELECT id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion FROM  multa WHERE id_usuario = '" + cedula +"' AND estado = '" + true + "'";
        try{

            Connection conn= fachada.openConnection();
            Statement sentenciaMlt = conn.createStatement();
            System.out.println("consultando en la bd");
            ResultSet tabla = sentenciaMlt.executeQuery(sql_select);

            while (tabla.next()){
                Multa mlt = new Multa();
                mlt.setIdUsuario(tabla.getString(1));
                mlt.setIsbn(tabla.getString(2));
                mlt.setNumEjemplar(tabla.getInt(3));
                mlt.setFechaMulta(tabla.getString(4));
                mlt.setValor(tabla.getInt(5));
                mlt.setDescripcion(tabla.getString(6));
                arrayMlt.add(mlt);
            }

            conn.close();
            return arrayMlt;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarMulta(Multa mlt)
    {
        String sql_mlt;

        sql_mlt = "UPDATE multa" + " SET id_usuario = '" + mlt.getIdUsuario() + "', isbn = '"+ mlt.getIsbn() + "', num_ejemplar = '" + mlt.getNumEjemplar() + "', fecha_multa = '" + mlt.getFechaMulta() + "', valor = '" + mlt.getValor() + "', descripcion = '" + mlt.getDescripcion() +  "'WHERE id_usuario='" + mlt.getIdUsuario() + "' AND isbn = '" + mlt.getIsbn() + "' AND num_ejemplar ='" + mlt.getNumEjemplar() + "' AND fecha_multa = '"+ mlt.getFechaMulta() + "'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaMlt = conn.createStatement();
            sentenciaMlt.executeUpdate(sql_mlt);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }

    public boolean eliminarMulta(String cedula, String isbn, int numEjemplar, String fecha){
        String sql_ac;

        sql_ac = "DELETE FROM multa WHERE id_usuario = '" + cedula + "' AND isbn = '" + isbn + "' AND num_ejemplar = '" + numEjemplar + "' AND fecha_multa = '" + fecha + "'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaAc = conn.createStatement();
            sentenciaAc.executeUpdate(sql_ac);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}
