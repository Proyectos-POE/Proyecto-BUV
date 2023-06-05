package dao;
import java.sql.*;
import java.util.ArrayList;

import modelo.Empleado;
import modelo.Estudiante;
public class DaoEstudiante {
    FachadaBd fachada;
    Connection conn;

    public DaoEstudiante()
    {
        fachada = new FachadaBd();
    }

    public int insertEstudiante(Estudiante est)
    {
        String sql_usu;
        String sql_est;

        sql_usu = "INSERT INTO usuario(id_usuario, contrasena, nombre, direccion, telefono, email) VALUES ('" + est.getId() + "', '" + est.getContrasena() +"', '" +  est.getNombre() +  "', '" + est.getDireccion() + "', '"  +
                est.getTelefono() + "', '"  + est.getEmail() + "')";

        sql_est="INSERT INTO estudiante(id_usuario, carrera, universidad) VALUES ('" + est.getId() + "', '" + est.getCarrera() + "', '" + est.getUniversidad() + "')";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaUsu = conn.createStatement();
            Statement sentenciaEst = conn.createStatement();
            int numFilas1 = sentenciaUsu.executeUpdate(sql_usu);
            int numFilas2 = sentenciaEst.executeUpdate(sql_est);
            conn.close();
            return numFilas1 + numFilas2;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Estudiante consultarEstudiante(String identificacion){
        Estudiante est = new Estudiante();
        String sql_select;
        sql_select="SELECT id_usuario, contrasena, nombre, direccion, telefono, email, carrera, universidad FROM  usuario NATURAL JOIN estudiante WHERE id_usuario='" + identificacion +  "'";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

                est.setId(tabla.getString(1));
                est.setContrasena(tabla.getString(2));
                est.setNombre(tabla.getString(3));
                est.setDireccion(tabla.getString(4));
                est.setTelefono(tabla.getString(5));
                est.setEmail(tabla.getString(6));
                est.setCarrera(tabla.getString(7));
                est.setUniversidad(tabla.getString(8));
            }

            return est;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Estudiante> listarEstudiantes(){
        ArrayList<Estudiante> arrayEst = new ArrayList<>();
        String sql_select;
        sql_select="SELECT id_usuario, contrasena, nombre, direccion, telefono, email, carrera, universidad FROM  estudiante NATURAL JOIN usuario";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            do{
                Estudiante est = new Estudiante();
                est.setId(tabla.getString(1));
                est.setContrasena(tabla.getString(2));
                est.setNombre(tabla.getString(3));
                est.setDireccion(tabla.getString(4));
                est.setTelefono(tabla.getString(5));
                est.setEmail(tabla.getString(6));
                est.setCarrera(tabla.getString(7));
                est.setUniversidad(tabla.getString(8));
                arrayEst.add(est);
            }while (tabla.next());

            return arrayEst;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarEstudiante(Estudiante est){
        String sql_usu;
        String sql_est;

        sql_usu = "UPDATE usuario" + " SET id_usuario = '" + est.getId() + "', contrasena = '" + est.getContrasena() + "', nombre = '" + est.getNombre() + "', direccion = '"  + est.getDireccion() + "', telefono = '" + est.getTelefono() +"' , email = '" + est.getEmail() +"' WHERE id_usuario ='" + est.getId() +"'";

        sql_est = "UPDATE estudiante" + " SET carrera = '" + est.getCarrera() + "', universidad = '" + est.getUniversidad() + "'WHERE id_usuario ='" + est.getId() +"'";
        try
        {
            Connection conn= fachada.openConnection();
            Statement sentenciaUsu = conn.createStatement();
            Statement sentenciaEst = conn.createStatement();
            sentenciaUsu.executeUpdate(sql_usu);
            sentenciaEst.executeUpdate(sql_est);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}
