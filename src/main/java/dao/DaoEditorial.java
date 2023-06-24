package dao;
import java.sql.*;
import java.util.ArrayList;

import modelo.Editorial;

public class DaoEditorial
{
    FachadaBd fachada;

    Connection conn;

    public DaoEditorial()
    {
        fachada = new FachadaBd();
    }

    public int insertEditorial(Editorial ed)
    {
        String sql_ed;

        sql_ed = "INSERT INTO editorial(nom_ed, pagina_web, pais_origen) VALUES('" +
                ed.getNomEditorial() + "', '" + ed.getPaginaWeb() + "', '" + ed.getPaisOrigen() + "')";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEd = conn.createStatement();
            int numFilas1 = sentenciaEd.executeUpdate(sql_ed);
            conn.close();
            return numFilas1;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Editorial consultarEditorial(int codEditorial)
    {
        Editorial ed = new Editorial();
        String sql_select;
        sql_select = "SELECT codigo_ed, nom_ed, pagina_web, pais_origen FROM editorial WHERE codigo_ed='" + codEditorial + "'";

        try{
            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()) {

                ed.setCodEditorial(tabla.getInt(1));
                ed.setNomEditorial(tabla.getString(2));
                ed.setPaginaWeb(tabla.getString(3));
                ed.setPaisOrigen(tabla.getString(4));
            }

            return ed;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public String consultarNombreEditorial(int codEditorial)
    {
        String nombre;
        String sql_select;
        sql_select = "SELECT nom_ed FROM editorial WHERE codigo_ed='" + codEditorial + "'";

        try{
            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            while(tabla.next()) {
                nombre = tabla.getString(1);
                return nombre;
            }
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Editorial> listarEditorial(){
        ArrayList<Editorial> arrayEd = new ArrayList<>();
        String sql_select;
        sql_select="SELECT codigo_ed, nom_ed, pagina_web, pais_origen FROM  editorial ORDER BY codigo_ed";
        try{
            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()){
                Editorial ed = new Editorial();
                ed.setCodEditorial(tabla.getInt(1));
                ed.setNomEditorial(tabla.getString(2));
                ed.setPaginaWeb(tabla.getString(3));
                ed.setPaisOrigen(tabla.getString(4));
                arrayEd.add(ed);
            }

            conn.close();
            return arrayEd;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarEditorial(Editorial ed)
    {
        String sql_ed;

        sql_ed = "UPDATE editorial" + " SET  nom_ed = '"+ ed.getNomEditorial() + "', pagina_web = '" + ed.getPaginaWeb() + "', pais_origen = '" + ed.getPaisOrigen() + "' WHERE codigo_ed = '" + ed.getCodEditorial() + "'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEd = conn.createStatement();
            sentenciaEd.executeUpdate(sql_ed);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }

    public boolean eliminarEditorial(int codEditorial)
    {
        String sql_ed;

        sql_ed = "DELETE FROM editorial WHERE codigo_ed = '" + codEditorial + "'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEd = conn.createStatement();
            sentenciaEd.executeUpdate(sql_ed);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }

    public Editorial consultarUltimoEditorial()
    {
        Editorial ed = new Editorial();
        String sql_select;
        sql_select = "SELECT codigo_ed, nom_ed, pagina_web, pais_origen FROM editorial WHERE codigo_ed = (SELECT MAX(codigo_ed) FROM editorial)";


        try{
            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()) {

                ed.setCodEditorial(tabla.getInt(1));
                ed.setNomEditorial(tabla.getString(2));
                ed.setPaginaWeb(tabla.getString(3));
                ed.setPaisOrigen(tabla.getString(4));
            }

            return ed;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }
}