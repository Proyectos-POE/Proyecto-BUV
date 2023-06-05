/*package dao;

import modelo.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoUsuario
{
    FachadaBd fachada;
    Connection conn;

    public DaoUsuario()
    {
        fachada = new FachadaBd();
    }

    public Usuario consultarUsuario(String identificacion)
    {
        Usuario usa = new Usuario();
        String sql_select;
        sql_select= "SELECT id_usuario, nombre, direccion, telefono, email, contrasena FROM usuario NATURAL JOIN profesor WHERE id_usuario='" + identificacion +  "'";
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
}*/
