package dao;

import modelo.AreaConforma;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoAreaConforma
{
    FachadaBd fachada;
    Connection conn;

    public DaoAreaConforma()
    {
        fachada = new FachadaBd();
    }

    public boolean insertAreaConforma(AreaConforma areaConf)
    {
        String sql_ac;

        sql_ac = "INSERT INTO area_conforma(cod_area, cod_area2) VALUES('"+ areaConf.getCodigoArea1() + "', '" +
                areaConf.getCodigoArea2() + "')";

        try
        {
            Connection conn= fachada.openConnection();
            Statement sentenciaAc = conn.createStatement();
            sentenciaAc.executeUpdate(sql_ac);
            conn.close();
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<Integer> consultarCodAreasConforma(int codArea)
    {
        AreaConforma areaConforma;
        ArrayList<Integer> codAreas = new ArrayList<Integer>();
        String sql_select;
        sql_select = "SELECT cod_area2 FROM area_conforma WHERE cod_area =" + codArea + "";

        try
        {
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next())
            {
                codAreas.add(tabla.getInt(1));
            }
            conn.close();
            return codAreas;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Integer> consultarCodAreasConforman(int codArea)
    {
        AreaConforma areaConforma;
        ArrayList<Integer> codAreas = new ArrayList<Integer>();
        String sql_select;
        sql_select = "SELECT cod_area FROM area_conforma WHERE cod_area2 =" + codArea +  "";

        try
        {
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next())
            {
                codAreas.add(tabla.getInt(1));
            }
            conn.close();
            return codAreas;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public boolean eliminarAreaConforma(int codArea1, int codArea2)
    {
        AreaConforma areaConforma;
        ArrayList<Integer> codAreas = new ArrayList<Integer>();
        String sql_select;
        sql_select = "DELETE FROM area_conforma WHERE cod_area2 =" + codArea2 + " AND cod_area = " + codArea1 + "";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaAc = conn.createStatement();
            sentenciaAc.executeUpdate(sql_select);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }

    public boolean eliminarAreaConforma(int codArea)
    {
        AreaConforma areaConforma;
        ArrayList<Integer> codAreas = new ArrayList<Integer>();
        String sql_select;
        sql_select = "DELETE FROM area_conforma WHERE cod_area2 =" + codArea + "";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaAc = conn.createStatement();
            sentenciaAc.executeUpdate(sql_select);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }

    public String consultarCodAreasHijaString(int codArea)
    {
        String nom_areas = "";
        String sql_select;
        sql_select = "SELECT STRING_AGG(nom_area, ',') FROM area_conforma AS a1 INNER JOIN area_conocimiento AS a2 ON a2.cod_area = cod_area2 WHERE a1.cod_area = " + codArea + "";

        try
        {
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            conn.close();

            while(tabla.next())
            {
                nom_areas = tabla.getString(1);
            }

            return nom_areas;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public boolean eliminarAreasHija(int codArea)
    {
        String sql_select;
        sql_select = "DELETE FROM area_conforma WHERE cod_area2 =" + codArea + "";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaAc = conn.createStatement();
            sentenciaAc.executeUpdate(sql_select);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }

    public boolean eliminarAreasPadre(int codArea)
    {
        String sql_select;
        sql_select = "DELETE FROM area_conforma WHERE cod_area =" + codArea + "";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaAc = conn.createStatement();
            sentenciaAc.executeUpdate(sql_select);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }





}
