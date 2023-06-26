package dao;

/** ****************************************************************************
 * Autores:
 * Nicolas Herrera Marulanda - 202182551
 * Samuel Galindo Cuevas - 202177491
 * Julian David Rendon Cardona - 202177387
 * *****************************************************************************/

import modelo.Estudiante;
import modelo.Prestamo;
import modelo.Profesor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoProfesor {
    FachadaBd fachada;

    public DaoProfesor(){
        fachada = new FachadaBd();
    }

    public int insertProfesor(Profesor pro){
        String sql_usu;
        String sql_pro;

        sql_usu = "INSERT INTO usuario(id_usuario, contrasena, nombre, direccion, telefono, email) VALUES ('" +
                pro.getId() + "', '" + pro.getContrasena() +"', '" +  pro.getNombre() +  "', '" + pro.getDireccion() + "', '"  +
                pro.getTelefono() + "', '"  + pro.getEmail() + "')";

        sql_pro="INSERT INTO profesor(id_usuario, dependencia, titulo) VALUES ('" + pro.getId() + "', '" + pro.getDependencia() + "', '" + pro.getTitulo() + "')";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaUsu = conn.createStatement();
            Statement sentenciaPro = conn.createStatement();
            int numFilas1 = sentenciaUsu.executeUpdate(sql_usu);
            int numFilas2 = sentenciaPro.executeUpdate(sql_pro);
            conn.close();
            return numFilas1 + numFilas2;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Profesor consultarProfesorId(String identificacion){
        Profesor pro = new Profesor();
        String sql_select;
        sql_select="SELECT id_usuario, contrasena, nombre, direccion, telefono, email, dependencia, titulo FROM Usuario NATURAL JOIN Profesor WHERE id_usuario='" + identificacion +  "'";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

                pro.setId(tabla.getString(1));
                pro.setContrasena(tabla.getString(2));
                pro.setNombre(tabla.getString(3));
                pro.setDireccion(tabla.getString(4));
                pro.setTelefono(tabla.getString(5));
                pro.setEmail(tabla.getString(6));
                pro.setDependencia(tabla.getString(7));
                pro.setTitulo(tabla.getString(8));
            }
            conn.close();
            return pro;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public Profesor consultarProfesorEmail(String email, String contrasena)
    {
        Profesor pro = new Profesor();
        String sql_select;
        sql_select="SELECT id_usuario, contrasena, nombre, direccion, telefono, email, dependencia, titulo FROM Usuario NATURAL JOIN Profesor WHERE email ='" + email +  "' AND contrasena = '" + contrasena +  "'";
        System.out.println(sql_select);
        try
        {
            Connection conn = fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            boolean valido = false;

            while(tabla.next())
            {
                valido = true;

                pro.setId(tabla.getString(1));
                pro.setContrasena(tabla.getString(2));
                pro.setNombre(tabla.getString(3));
                pro.setDireccion(tabla.getString(4));
                pro.setTelefono(tabla.getString(5));
                pro.setEmail(tabla.getString(6));
                pro.setDependencia(tabla.getString(7));
                pro.setTitulo(tabla.getString(8));
            }

            if(valido)
            {
                conn.close();
                return pro;
            }
            else
            {
                conn.close();
                return null;
            }
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Profesor> listarProfesores(){
        ArrayList<Profesor> arrayPro = new ArrayList<>();
        String sql_select;
        sql_select="SELECT id_usuario, contrasena, nombre, direccion, telefono, email, dependencia, titulo FROM  profesor NATURAL JOIN usuario";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()){
                Profesor pro = new Profesor();
                pro.setId(tabla.getString(1));
                pro.setContrasena(tabla.getString(2));
                pro.setNombre(tabla.getString(3));
                pro.setDireccion(tabla.getString(4));
                pro.setTelefono(tabla.getString(5));
                pro.setEmail(tabla.getString(6));
                pro.setDependencia(tabla.getString(7));
                pro.setTitulo(tabla.getString(8));
                arrayPro.add(pro);
            }
            conn.close();
            return arrayPro;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }
    public boolean modificarProfesor(Profesor pro){
        String sql_usu;
        String sql_pro;

        sql_usu = "UPDATE usuario" + " SET id_usuario = '" + pro.getId() + "', contrasena = '" + pro.getContrasena() + "', nombre = '" + pro.getNombre() + "', direccion = '"  + pro.getDireccion() + "', telefono = '" + pro.getTelefono() +"' , email = '" + pro.getEmail() +"' WHERE id_usuario ='" + pro.getId() +"'";

        sql_pro = "UPDATE profesor" + " SET dependencia = '" + pro.getDependencia() + "', titulo = '" + pro.getTitulo()+ "' WHERE id_usuario ='" + pro.getId() +"'";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaUsu = conn.createStatement();
            Statement sentenciaPro = conn.createStatement();
            sentenciaUsu.executeUpdate(sql_usu);
            sentenciaPro.executeUpdate(sql_pro);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}
