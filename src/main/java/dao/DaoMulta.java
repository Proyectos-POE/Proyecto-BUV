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

        sql_mlt = "INSERT INTO multa(id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion) VALUES('" + mlt.getIdUsuario() + "', '"
                + mlt.getIsbn() + "', '" +  mlt.getNumEjemplar() + "', '" + mlt.getFechaMulta() +
                "', '" + mlt.getValor() + "', '" + mlt.getDescripcion() + "')";

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
        sql_select = "SELECT id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion FROM multa WHERE id_usuario='" + idUsuario + "' AND isbn = '" + isbn + "' AND num_ejemplar ='" + numEJemplar + "' AND fecha_multa = '"+ fechaMulta +  "'";

        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next())
            {
                mlt.setIdUsuario(tabla.getString(1));
                mlt.setIsbn(tabla.getString(2));
                mlt.setNumEjemplar(tabla.getInt(3));
                mlt.setFechaMulta(tabla.getDate(4));
                mlt.setValor(tabla.getInt(5));
                mlt.setDescripcion(tabla.getString(6));
            }

            return mlt;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Multa> listarMulta(){
        ArrayList<Multa> arrayMlt = new ArrayList<>();
        String sql_select;
        sql_select="SELECT id_usuario, isbn, num_ejemplar, fecha_multa, valor, descripcion FROM  multa";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            do{
                Multa mlt = new Multa();
                mlt.setIdUsuario(tabla.getString(1));
                mlt.setIsbn(tabla.getString(2));
                mlt.setNumEjemplar(tabla.getInt(3));
                mlt.setFechaMulta(tabla.getDate(4));
                mlt.setValor(tabla.getInt(5));
                mlt.setDescripcion(tabla.getString(6));
                arrayMlt.add(mlt);
            }while (tabla.next());

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
}
