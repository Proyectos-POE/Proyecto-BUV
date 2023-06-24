package dao;

import modelo.AreaConocimiento;
import modelo.Descarga;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoDescarga
{
    FachadaBd fachada;

    Connection conn;

    public DaoDescarga()
    {
        fachada = new FachadaBd();
    }

    public int insertDescarga(Descarga de)
    {
        String sql_ac;

        sql_ac = "INSERT INTO descarga(isbn, url, id_usuario, fecha_descarga, hora_descarga, ip) VALUES('"+ de.getIsbn() + "', '" + de.getUrl() + "', '" + de.getIdUsuario() + "', '"+ de.getFechaDescarga() +"', '" + de.getHoraDescarga() +"', '" + de.getIp() + "')";

        try
        {
            Connection conn= fachada.openConnection();
            Statement sentenciaAc = conn.createStatement();
            int numFilas1 = sentenciaAc.executeUpdate(sql_ac);
            conn.close();
            return numFilas1;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public ArrayList<Descarga> listarDescargas(){
        ArrayList<Descarga> arrayDe = new ArrayList<>();
        String sql_select;
        sql_select="SELECT isbn, url, id_usuario, fecha_descarga, hora_descarga, ip FROM descarga ORDER BY isbn";
        try{
            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next())
            {
                Descarga de = new Descarga(tabla.getString(1), tabla.getString(2), tabla.getString(3), tabla.getString(4), tabla.getString(5), tabla.getString(6));
                arrayDe.add(de);
            }

            conn.close();
            return arrayDe;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }
}
