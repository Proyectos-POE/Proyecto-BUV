package dao;
import java.sql.*;
import java.util.ArrayList;

import modelo.Digital;


public class DaoDigital
{
    FachadaBd fachada;

    Connection conn;

    public DaoDigital()
    {
        fachada = new FachadaBd();
    }

    public int insertLibroDigital(Digital dgt)
    {
        String sql_dgt;

        sql_dgt = "INSERT INTO digital(isbn, url, formato, bytes, ) VALUES('"+ dgt.getIsbn() + "', '" +
                dgt.getUrl() + "', '" + dgt.getFormato() + "', '" + dgt.getBytes() + "')";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaDgt = conn.createStatement();
            int numFilas1 = sentenciaDgt.executeUpdate(sql_dgt);
            conn.close();
            return numFilas1;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Digital consultarLibroDigital(String isbn, String url)
    {
        Digital dgt = new Digital();
        String sql_select;
        sql_select = "SELECT isbn, url, formato, bytes FROM digital WHERE isbn='" + isbn + "' AND url ='" + url +"'";

        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

                dgt.setIsbn(tabla.getString(1));
                dgt.setUrl(tabla.getString(2));;
                dgt.setFormato(tabla.getString(3));
                dgt.setBytes(tabla.getString(4));
            }

            return dgt;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Digital> listarDigital(){
        ArrayList<Digital> arrayDgt = new ArrayList<>();
        String sql_select;
        sql_select="SELECT isbn, url, formato, bytes FROM  digital";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            do{
                Digital dgt = new Digital();
                dgt.setIsbn(tabla.getString(1));
                dgt.setUrl(tabla.getString(2));
                dgt.setFormato(tabla.getString(3));
                dgt.setBytes(tabla.getString(4));
                arrayDgt.add(dgt);
            }while (tabla.next());

            return arrayDgt;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarLibroDigital(Digital dgt)
    {
        String sql_dgt;

        sql_dgt = "UPDATE digital" + " SET isbn = '" + dgt.getIsbn() + "', url = '"+ dgt.getUrl() + "', formato = '" + dgt.getFormato() + "', bytes = '" + dgt.getBytes() + "' WHERE isbn = '" + dgt.getIsbn() + "' AND url = '" + dgt.getUrl() + "'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaDgt = conn.createStatement();
            sentenciaDgt.executeUpdate(sql_dgt);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}
