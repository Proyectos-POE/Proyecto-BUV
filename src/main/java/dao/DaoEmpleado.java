package dao;

import modelo.Empleado;
import modelo.Estudiante;
import modelo.Prestamo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoEmpleado
{
    FachadaBd fachada;
    Connection conn;

    public DaoEmpleado(){
        fachada = new FachadaBd();
    }

    public int insertEmpleado(Empleado emp){
        String sql_usu;
        String sql_emp;

        sql_usu = "INSERT INTO usuario(id_usuario, contrasena, nombre, direccion, telefono, email) VALUES ('" + emp.getId() + "', '" + emp.getContrasena() +"', '" +  emp.getNombre() +  "', '" + emp.getDireccion() + "', '"  +
                emp.getTelefono() + "', '"  + emp.getEmail() + "')";
        sql_emp = "INSERT INTO empleado(id_empleado, cargo) VALUES ('" +
                emp.getId() + "', '"  +  emp.getCargo() +"')";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaUsu = conn.createStatement();
            Statement sentenciaEmp = conn.createStatement();
            int numFilas1 = sentenciaUsu.executeUpdate(sql_usu);
            int numFilas2 = sentenciaEmp.executeUpdate(sql_emp);
            conn.close();
            return numFilas1 + numFilas2;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Empleado consultarEmpleado(String identificacion){
        Empleado emp = new Empleado();
        String sql_select;
        sql_select="SELECT id_usuario, contrasena, nombre, direccion, telefono, email, cargo  FROM  empleado INNER JOIN usuario ON id_empleado = id_usuario WHERE id_usuario ='" + identificacion +  "'";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                emp.setId(tabla.getString(1));
                emp.setContrasena(tabla.getString(2));
                emp.setNombre(tabla.getString(3));
                emp.setDireccion(tabla.getString(4));
                emp.setTelefono(tabla.getString(5));
                emp.setEmail(tabla.getString(6));
                emp.setCargo(tabla.getString(7));
            }
            conn.close();
            return emp;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public Empleado consultarEmpleadoEmail(String email, String contrasena){
        Empleado emp = new Empleado();
        String sql_select;
        sql_select="SELECT id_usuario, contrasena, nombre, direccion, telefono, email, cargo  FROM Empleado INNER JOIN Usuario ON id_empleado = id_usuario WHERE email ='" + email +  "' AND contrasena = '" + contrasena +  "'";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            boolean valido = false;

            while(tabla.next()){
                valido = true;
                emp.setId(tabla.getString(1));
                emp.setContrasena(tabla.getString(2));
                emp.setNombre(tabla.getString(3));
                emp.setDireccion(tabla.getString(4));
                emp.setTelefono(tabla.getString(5));
                emp.setEmail(tabla.getString(6));
                emp.setCargo(tabla.getString(7));
            }
            conn.close();

            if(valido)
            {
                return emp;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Empleado> listarEmpleados(){
        ArrayList<Empleado> arrayEmp = new ArrayList<>();
        String sql_select;
        sql_select="SELECT id_usuario, contrasena, nombre, direccion, telefono, email, cargo  FROM  empleado INNER JOIN usuario ON id_empleado = id_usuario";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()){
                Empleado emp = new Empleado();
                emp.setId(tabla.getString(1));
                emp.setContrasena(tabla.getString(2));
                emp.setNombre(tabla.getString(3));
                emp.setDireccion(tabla.getString(4));
                emp.setTelefono(tabla.getString(5));
                emp.setEmail(tabla.getString(6));
                emp.setCargo(tabla.getString(7));
                arrayEmp.add(emp);
            }
            conn.close();
            return arrayEmp;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public boolean modificarEmpleado(Empleado emp){
        String sql_emp;
        String sql_usu;

        sql_usu = "UPDATE usuario" + " SET id_usuario = '" + emp.getId() + "', contrasena = '" + emp.getContrasena() + "', nombre = '" + emp.getNombre() + "', direccion = '"  + emp.getDireccion() + "', telefono = '" + emp.getTelefono() +"' , email = '" + emp.getEmail() +"' WHERE id_usuario ='" + emp.getId() +"'";

        sql_emp = "UPDATE empleado" + " SET id_empleado = '" + emp.getId() + "', cargo = '"  + emp.getCargo() +"' WHERE id_empleado ='" + emp.getId() +"'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEmp = conn.createStatement();
            Statement sentenciaUsu = conn.createStatement();
            sentenciaUsu.executeUpdate(sql_usu);
            sentenciaEmp.executeUpdate(sql_emp);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }

    public boolean eliminarEmpleado(String id){
        String sql_emp;
        String sql_usu;

        sql_emp = "DELETE FROM empleado WHERE id_empleado = '" + id + "'";
        sql_usu = "DELETE FROM usuario WHERE id_usuario = '" + id + "'";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEmp = conn.createStatement();
            Statement sentenciaUsu = conn.createStatement();
            sentenciaEmp.executeUpdate(sql_emp);
            sentenciaUsu.executeUpdate(sql_usu);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}
