package dao;

import modelo.Empleado;
import modelo.Estudiante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoEmpleado
{
    FachadaBd fachada;
    Connection conn;

    DaoEmpleado(){
        fachada = new FachadaBd();
    }

    public int insertEmpleado(Empleado emp){
        String sql_emp;

        sql_emp = "INSERT INTO empleado(id_empleado, nombre, cargo) VALUES ('" +
                emp.getId() + "', '" + emp.getNombre() +"', '" +  emp.getCargo() +"')";
        try{
            Connection conn= fachada.openConnection();
            Statement sentenciaUsu = conn.createStatement();
            Statement sentenciaEst = conn.createStatement();
            int numFilas1 = sentenciaUsu.executeUpdate(sql_emp);
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
        sql_select="SELECT id_empleado, nombre FROM  Empleado WHERE id_empleado='" + identificacion +  "'";
        try{

            System.out.println("consultando en la bd");
            Statement sentencia = this.conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                emp.setId(tabla.getString(1));
                emp.setNombre(tabla.getString(2));
                emp.setCargo(tabla.getString(3));
            }

            return emp;
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
            Statement sentenciaUsu = conn.createStatement();
            Statement sentenciaEst = conn.createStatement();
            sentenciaUsu.executeUpdate(sql_emp);
            conn.close();
            return true;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
}
