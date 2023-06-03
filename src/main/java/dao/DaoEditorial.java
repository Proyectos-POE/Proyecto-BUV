package dao;
import java.sql.*;
import java.util.ArrayList;

import modelo.Editorial;

public class DaoEditorial
{
    FachadaBd fachada;

    Connection conn;

    DaoEditorial()
    {
        fachada = new FachadaBd();
    }

    public int insertEditorial(Editorial ed)
    {
        String sql_ed;

        sql_ed = "INSERT INTO editorial(codigo_ed, nom_ed, pagina_web, pais_origen) VALUES('"+ ed.getCodEditorial() + "', '" +
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

    public Editorial consultarEditorial(String codEditorial)
    {
        Editorial ed = new Editorial();
        String sql_select;
        sql_select = "SELECT codigo_ed, nom_ed, pagina_web, pais_origen FROM editorial WHERE codigo_ed='" + codEditorial + "'";

        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()) {

                ed.setCodEditorial(tabla.getString(1));
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

    public ArrayList<Editorial> listarEditorial(){
        ArrayList<Editorial> arrayEd = new ArrayList<>();
        String sql_select;
        sql_select="SELECT codigo_ed, nom_ed, pagina_web, pais_origen FROM  editorial";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            do{
                Editorial ed = new Editorial();
                ed.setCodEditorial(tabla.getString(1));
                ed.setNomEditorial(tabla.getString(2));
                ed.setPaginaWeb(tabla.getString(3));
                ed.setPaisOrigen(tabla.getString(4));
                arrayEd.add(ed);
            }while (tabla.next());

            return arrayEd;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarEditorial(Editorial ed)
    {
        String sql_ed;

        sql_ed = "UPDATE editorial" + " SET codigo_ed = '" + ed.getCodEditorial() + "', nom_ed = '"+ ed.getNomEditorial() + "', pagina_web = '" + ed.getPaginaWeb() + "', pais_origen = '" + ed.getPaisOrigen() + "' WHERE codigo_ed = '" + ed.getCodEditorial() + "'";

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
}