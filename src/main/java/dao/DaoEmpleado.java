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
        String sql_emp;

        sql_emp = "INSERT INTO empleado(id_empleado, nombre, cargo) VALUES ('" +
                emp.getId() + "', '" + emp.getNombre() +"', '" +  emp.getCargo() +"')";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEmp = conn.createStatement();
            int numFilas1 = sentenciaEmp.executeUpdate(sql_emp);
            conn.close();
            return numFilas1;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Empleado consultarEmpleado(String identificacion){
        Empleado emp = new Empleado();
        String sql_select;
        sql_select="SELECT id_empleado, nombre, cargo FROM  empleado WHERE id_empleado='" + identificacion +  "'";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                emp.setId(tabla.getString(1));
                emp.setNombre(tabla.getString(2));
                emp.setCargo(tabla.getString(3));
            }
            conn.close();
            return emp;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    public ArrayList<Empleado> listarEmpleados(){
        ArrayList<Empleado> arrayEmp = new ArrayList<>();
        String sql_select;
        sql_select="SELECT d_empleado, nombre, cargo FROM  empleado";
        try{
            Connection conn= fachada.openConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()){
                Empleado emp = new Empleado();
                emp.setId(tabla.getString(1));
                emp.setNombre(tabla.getString(2));
                emp.setCargo(tabla.getString(3));
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

        sql_emp = "UPDATE empleado" + " SET id_empleado = '" + emp.getId() + "', nombre = '" + emp.getNombre() + "', cargo = '"  + emp.getCargo() +"'";

        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaEmp = conn.createStatement();
            sentenciaEmp.executeUpdate(sql_emp);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}
