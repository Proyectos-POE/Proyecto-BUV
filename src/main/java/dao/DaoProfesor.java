package dao;

import modelo.Estudiante;
import modelo.Profesor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoProfesor {
    FachadaBd fachada;
    Connection conn;

    DaoProfesor(){
        fachada = new FachadaBd();
    }

    public int insertProfesor(Profesor pro){
        String sql_usu;
        String sql_pro;

        sql_usu = "INSERT INTO usuario(id_usuario, contrasena, nombre, direccion, telefono, email) VALUES ('" +
                pro.getId() + "', '" + pro.getContrasena() +"', '" +  pro.getNombre() +  "', '" + pro.getDireccion() + "', '"  +
                pro.getTelefono() + "', '"  + pro.getEmail() + "')";

        sql_pro="INSERT INTO profesor(id_usuario, carrera, universidad) VALUES ('" +
                pro.getId() + "', '" + pro.getDependencia() + "', '" + pro.getTitulo() + "')";
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

    public Profesor consultarProfesor(String identificacion){
        Profesor pro = new Profesor();
        String sql_select;
        sql_select="SELECT id_usuario, contrasena, nombre, direccion, telefono, email, dependencia, titulo FROM  usuario NATURAL JOIN profesor WHERE id_usuario='" + identificacion +  "'";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
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

            return pro;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarProfesor(Profesor pro){
        String sql_usu;
        String sql_pro;

        sql_usu = "UPDATE usuario" + " SET id_usuario = '" + pro.getId() + "', contrasena = '" + pro.getContrasena() + "', nombre = '" + pro.getNombre() + "', direccion = '"  + pro.getDireccion() + "', telefono = '" + pro.getTelefono() +"' , email = '" + pro.getEmail() +"' WHERE id_usuario ='" + pro.getId() +"'";

        sql_pro = "UPDATE profesor" + " SET id_usuario = '" + pro.getId() + "', dependencia = '" + pro.getDependencia() + "', titulo = '" + pro.getTitulo()+ "' WHERE id_usuario ='" + pro.getId() +"'";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaUsu = conn.createStatement();
            Statement sentenciaEst = conn.createStatement();
            sentenciaUsu.executeUpdate(sql_usu);
            sentenciaEst.executeUpdate(sql_pro);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}
