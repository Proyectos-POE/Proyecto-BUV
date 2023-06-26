package dao;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

import java.sql.*;
import java.util.ArrayList;
import modelo.AreaConocimiento;

public class DaoAreaConocimiento
{
    FachadaBd fachada;

    Connection conn;

    public DaoAreaConocimiento()
    {
        fachada = new FachadaBd();
    }

    public int insertAreaConocimiento(AreaConocimiento ac)
    {
        String sql_ac;

        sql_ac = "INSERT INTO area_conocimiento(nom_area, descripcion) VALUES('"+ ac.getNomArea() + "', '" +
                ac.getDescripcion() + "')";

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

    public AreaConocimiento consultarAreaConocimiento(int codigoArea)
    {
        AreaConocimiento ac = new AreaConocimiento();
        String sql_select;
        sql_select = "SELECT cod_area, nom_area, descripcion FROM area_conocimiento WHERE cod_area ='" + codigoArea + "'";

        try{
            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()) {

                ac.setCodigoArea(tabla.getInt(1));
                ac.setNomArea(tabla.getString(2));
                ac.setDescripcion(tabla.getString(3));
            }

            return ac;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<AreaConocimiento> listarAreasConocimientos(){
        ArrayList<AreaConocimiento> arrayAc = new ArrayList<>();
        String sql_select;
        sql_select="SELECT cod_area, nom_area, descripcion FROM area_conocimiento ORDER BY cod_area";
        try{
            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next())
            {
                AreaConocimiento ac = new AreaConocimiento();
                ac.setCodigoArea(tabla.getInt(1));
                ac.setNomArea(tabla.getString(2));
                ac.setDescripcion(tabla.getString(3));
                arrayAc.add(ac);
            }

            conn.close();
            return arrayAc;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarAreaConocimiento(AreaConocimiento ac)
    {
        String sql_ac;

        sql_ac = "UPDATE area_conocimiento" + " SET nom_area = '"+ ac.getNomArea() +"', descripcion = '" + ac.getDescripcion() + "' WHERE cod_area = '" + ac.getCodigoArea() + "'";

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

    public boolean eliminarAreaConocimiento(int codigoArea){
        String sql_ac;

        sql_ac = "DELETE FROM area_conocimiento WHERE cod_area = '" + codigoArea + "'";

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

    public AreaConocimiento consultarUltimoAreaConocimiento()
    {
        AreaConocimiento ac = new AreaConocimiento();
        String sql_select;
        sql_select = "SELECT cod_area, nom_area, descripcion FROM area_conocimiento WHERE cod_area = (SELECT MAX(cod_area) FROM area_conocimiento)";

        try{
            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()) {

                ac.setCodigoArea(tabla.getInt(1));
                ac.setNomArea(tabla.getString(2));
                ac.setDescripcion(tabla.getString(3));
            }

            return ac;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean consultarAreaLibro(int codigoArea)
    {
        String sql_select;
        sql_select = "SELECT isbn FROM libro WHERE cod_area ='" + codigoArea + "'";

        try{
            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            return !tabla.isBeforeFirst() && tabla.getRow() == 0;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}
