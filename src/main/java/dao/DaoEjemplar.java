package dao;
import java.sql.*;
import java.util.ArrayList;
import modelo.Ejemplar;

public class DaoEjemplar
{
    FachadaBd fachada;

    Connection conn;

    public DaoEjemplar()
    {
        fachada = new FachadaBd();
    }

    public int insertEjemplar(Ejemplar ej)
    {
        String sql_ej;

        sql_ej = "INSERT INTO ejemplar(isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo) VALUES('"+ ej.getIsbn() + "', '" +
                ej.getNumEjemplar() + "', '" + ej.getEstante() + "', '" + ej.getNumCajon() + "', '" +
                ej.getNomSala() +"', '" + ej.getNumPasillo() +"')";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEj = conn.createStatement();
            int numFilas1 = sentenciaEj.executeUpdate(sql_ej);
            conn.close();
            return numFilas1;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Ejemplar consultarEjemplar(String isbn, int numEJemplar)
    {
        Ejemplar ej = new Ejemplar();
        String sql_select;
        sql_select = "SELECT isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo FROM ejemplar WHERE isbn='" + isbn + "' AND num_ejemplar ='" + numEJemplar +"'";

        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

                ej.setIsbn(tabla.getString(1));
                ej.setNumEjemplar(tabla.getInt(2));
                ej.setEstante(tabla.getInt(3));
                ej.setNumCajon(tabla.getInt(4));
                ej.setNomSala(tabla.getString(5));
                ej.setNumPasillo(tabla.getInt(6));
            }

            return ej;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Ejemplar> listarEjemplar(){
        ArrayList<Ejemplar> arrayEj = new ArrayList<>();
        String sql_select;
        sql_select="SELECT isbn, num_ejemplar, estante, num_cajon, nom_sala, num_pasillo FROM  ejemplar";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            do{
                Ejemplar ej = new Ejemplar();
                ej.setIsbn(tabla.getString(1));
                ej.setNumEjemplar(tabla.getInt(2));
                ej.setEstante(tabla.getInt(3));
                ej.setNumCajon(tabla.getInt(4));
                ej.setNomSala(tabla.getString(5));
                ej.setNumPasillo(tabla.getInt(6));
                arrayEj.add(ej);
            }while (tabla.next());

            return arrayEj;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarEjemplar(Ejemplar ej)
    {
        String sql_ej;

        sql_ej = "UPDATE ejemplar" + " SET isbn = '" + ej.getIsbn() + "', num_ejemplar = '"+ ej.getNumEjemplar() + "', estante = '" + ej.getEstante() + "', num_cajon = '" + ej.getNumCajon() + "', nom_sala = '" + ej.getNomSala() + "', num_pasillo = '" + ej.getNumPasillo() + "' WHERE isbn = '" + ej.getIsbn() + "' AND num_ejemplar = '" + ej.getNumEjemplar() + "'";

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
}
