package dao;
import java.sql.*;
import java.util.ArrayList;
import modelo.AreaConocimiento;

public class DaoAreaConocimiento
{
    FachadaBd fachada;

    Connection conn;

    DaoAreaConocimiento()
    {
        fachada = new FachadaBd();
    }

    public int insertAreaConocimiento(AreaConocimiento ac)
    {
        String sql_ac;

        sql_ac = "INSERT INTO area_conocimiento(cod_area, nom_area) VALUES('"+ ac.getCodigoArea() + "', '" +
                ac.getNomArea() + "')";

        try{
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

    public AreaConocimiento consultarAreaConocimiento(String codigoArea)
    {
        AreaConocimiento ac = new AreaConocimiento();
        String sql_select;
        sql_select = "SELECT cod_area, nom_area FROM area_conocimiento WHERE cod_area='" + codigoArea + "'";

        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()) {

                ac.setCodigoArea(tabla.getString(1));
                ac.setNomArea(tabla.getString(2));
            }

            return ac;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<AreaConocimiento> listarAreaConocimiento(){
        ArrayList<AreaConocimiento> arrayAc = new ArrayList<>();
        String sql_select;
        sql_select="SELECT cod_area, nom_area FROM area_conocimiento";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            do{
                AreaConocimiento ac = new AreaConocimiento();
                ac.setCodigoArea(tabla.getString(1));
                ac.setNomArea(tabla.getString(2));
                arrayAc.add(ac);
            }while (tabla.next());

            return arrayAc;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarAreaConocimiento(AreaConocimiento ac)
    {
        String sql_ac;

        sql_ac = "UPDATE area_conocimiento" + " SET cod_area = '" + ac.getCodigoArea() + "', nom_area = '"+ ac.getNomArea() + "' WHERE cod_area = '" + ac.getCodigoArea() + "'";

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
