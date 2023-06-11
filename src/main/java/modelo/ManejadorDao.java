package modelo;

import dao.*;

import java.util.ArrayList;

public class ManejadorDao {
    private final String nombre;
    private DaoEstudiante daoEstudiante;
    private DaoProfesor daoProfesor;
    private DaoAutor daoAutor;
    private DaoDigital daoDigital;
    private DaoEditorial daoEditorial;
    private DaoAreaConocimiento daoAreaConocimiento;
    private DaoEjemplar daoEjemplar;
    private DaoEmpleado daoEmpleado;
    private DaoLibro daoLibro;
    private DaoMulta daoMulta;
    private DaoPrestamo daoPrestamo;
    private DaoSolicitud daoSolicitud;

    public ManejadorDao(String nombre, Estudiante estudiante)
    {
        this.nombre = nombre;
        this.daoEstudiante = new DaoEstudiante();
        this.daoSolicitud = new DaoSolicitud();
        this.daoPrestamo = new DaoPrestamo();
        this.daoMulta = new DaoMulta();
        this.daoLibro = new DaoLibro();
    }

    public ManejadorDao(String nombre, Profesor profesor)
    {
        this.nombre = nombre;
        this.daoProfesor = new DaoProfesor();
        this.daoSolicitud = new DaoSolicitud();
        this.daoPrestamo = new DaoPrestamo();
        this.daoMulta = new DaoMulta();
        this.daoLibro = new DaoLibro();
    }

    public ManejadorDao(String nombre)
    {
        this.nombre = nombre;
        this.daoEmpleado = new DaoEmpleado();
        this.daoAutor = new DaoAutor();
        this.daoEditorial = new DaoEditorial();
        this.daoLibro = new DaoLibro();
        this.daoEjemplar = new DaoEjemplar();
        this.daoDigital = new DaoDigital();
        this.daoAreaConocimiento = new DaoAreaConocimiento();
        this.daoMulta = new DaoMulta();
        this.daoPrestamo = new DaoPrestamo();
        this.daoSolicitud = new DaoSolicitud();
    }

    /*******
     * Estudiante
     */

    public Estudiante consultarEstId(String id)
    {
        return this.daoEstudiante.consultarEstudianteId(id);
    }

    public Boolean modificarEst(Estudiante estudiante)
    {
        return this.daoEstudiante.modificarEstudiante(estudiante);
    }

    /*******
     * Profesor
     */
    public Profesor consultarProId(String id)
    {
        return this.daoProfesor.consultarProfesorId(id);
    }

    public Boolean modificarPro(Profesor profesor)
    {
        return this.daoProfesor.modificarProfesor(profesor);
    }

    /*******
     * Solicitud
     */

    public int agregarSolicitud(Solicitud soli)
    {
        return this.daoSolicitud.insertSolicitud(soli);
    }

    public ArrayList<Solicitud> listarSolicitudesUsuario(String id)
    {
        return this.daoSolicitud.listarSolicitudesUsuario(id);
    }


    /*******
     * Prestamo
     */

    public ArrayList<Prestamo> listarPrestamosUsuario(String id)
    {
        return this.daoPrestamo.listarPrestamosU(id);
    }
}
