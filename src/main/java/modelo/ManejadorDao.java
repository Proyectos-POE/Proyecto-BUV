package modelo;

import dao.*;

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
    }

    public ManejadorDao(String nombre, Profesor profesor)
    {
        this.nombre = nombre;
        this.daoProfesor = new DaoProfesor();
        this.daoSolicitud = new DaoSolicitud();
        this.daoPrestamo = new DaoPrestamo();
        this.daoMulta = new DaoMulta();
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
    /*
    public int agregarEst(Estudiante estudiante)
    {
        return this.daoEstudiante.insertEstudiante(estudiante);
    }

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
    /*
    public int agregarEst(Estudiante estudiante)
    {
        return this.daoEstudiante.insertEstudiante(estudiante);
    }

     */

    public Profesor consultarProId(String id)
    {
        return this.daoProfesor.consultarProfesorId(id);
    }

    public Boolean modificarPro(Profesor profesor)
    {
        return this.daoProfesor.modificarProfesor(profesor);
    }

}
