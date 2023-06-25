package dao;

import modelo.Estudiante;
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

    public ArrayList<Usuario> listarUsuarios(){
        ArrayList<Usuario> arrayUsu = new ArrayList<>();
        String sql_select;
        sql_select="SELECT id_usuario, contrasena, nombre, direccion, telefono, email FROM usuario";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()){
                Usuario usu = new Usuario();
                usu.setId(tabla.getString(1));
                usu.setContrasena(tabla.getString(2));
                usu.setNombre(tabla.getString(3));
                usu.setDireccion(tabla.getString(4));
                usu.setTelefono(tabla.getString(5));
                usu.setEmail(tabla.getString(6));
                arrayUsu.add(usu);
            }
            conn.close();
            return arrayUsu;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public Usuario usariosMenosEmpleados(String id)
    {
        Usuario usuario;
        String sql_select;
        sql_select="SELECT id_usuario, nombre FROM usuario WHERE id_usuario ='" + id + "' AND id_usuario NOT IN(SELECT id_empleado FROM empleado)";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            usuario = new Usuario();
            while (tabla.next()){

                usuario.setId(tabla.getString(1));
                usuario.setNombre(tabla.getString(2));
            }
            conn.close();
            return usuario;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }
}
