package modelo;

import dao.*;

import java.util.ArrayList;

public class ManejadorDao {
    private final String nombre;
    private DaoUsuario daoUsuario;
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
    private DaoAutorLibro daoAutorLibro;
    private DaoPrestamoLibro daoPrestamoLibro;
    private DaoAreaConforma daoAreaConforma;
    private DaoDescarga daoDescarga;

    public ManejadorDao(String nombre, Estudiante estudiante)
    {
        this.nombre = nombre;
        this.daoEstudiante = new DaoEstudiante();
        this.daoSolicitud = new DaoSolicitud();
        this.daoPrestamo = new DaoPrestamo();
        this.daoPrestamoLibro = new DaoPrestamoLibro();
        this.daoMulta = new DaoMulta();
        this.daoLibro = new DaoLibro();
        this.daoEmpleado = new DaoEmpleado();
        this.daoDescarga = new DaoDescarga();
        this.daoDigital = new DaoDigital();
    }

    public ManejadorDao(String nombre, Profesor profesor)
    {
        this.nombre = nombre;
        this.daoProfesor = new DaoProfesor();
        this.daoSolicitud = new DaoSolicitud();
        this.daoPrestamo = new DaoPrestamo();
        this.daoPrestamoLibro = new DaoPrestamoLibro();
        this.daoMulta = new DaoMulta();
        this.daoLibro = new DaoLibro();
        this.daoEmpleado = new DaoEmpleado();
        this.daoDescarga = new DaoDescarga();
        this.daoDigital = new DaoDigital();
    }

    public ManejadorDao(String nombre, Empleado empleado)
    {
        this.nombre = nombre;
        this.daoProfesor = new DaoProfesor();
        this.daoEstudiante = new DaoEstudiante();
        this.daoEmpleado = new DaoEmpleado();
        this.daoLibro = new DaoLibro();
        this.daoEjemplar = new DaoEjemplar();
        this.daoPrestamo = new DaoPrestamo();
        this.daoPrestamoLibro = new DaoPrestamoLibro();
        this.daoSolicitud = new DaoSolicitud();
        this.daoDigital = new DaoDigital();
        this.daoAutor = new DaoAutor();
    }

    public ManejadorDao(String nombre)
    {
        this.nombre = nombre;
        this.daoUsuario = new DaoUsuario();
        this.daoProfesor = new DaoProfesor();
        this.daoEstudiante = new DaoEstudiante();
        this.daoEmpleado = new DaoEmpleado();
        this.daoAutor = new DaoAutor();
        this.daoEditorial = new DaoEditorial();
        this.daoLibro = new DaoLibro();
        this.daoEjemplar = new DaoEjemplar();
        this.daoDigital = new DaoDigital();
        this.daoAreaConocimiento = new DaoAreaConocimiento();
        this.daoMulta = new DaoMulta();
        this.daoPrestamo = new DaoPrestamo();
        this.daoPrestamoLibro = new DaoPrestamoLibro();
        this.daoSolicitud = new DaoSolicitud();
        this.daoAutorLibro = new DaoAutorLibro();
        this.daoAreaConforma = new DaoAreaConforma();
        this.daoDescarga = new DaoDescarga();
    }

    /*******
     * usuario
     */
    public ArrayList<Usuario> listarUsuarios(){return this.daoUsuario.listarUsuarios();}

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
    public ArrayList<Estudiante> listarEstudiantes(){return this.daoEstudiante.listarEstudiantes();}
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
    public ArrayList<Profesor> listarProfesores(){return this.daoProfesor.listarProfesores();}

    /*******
     * Solicitud
     */

    public int agregarSolicitud(Solicitud soli)
    {
        return this.daoSolicitud.insertSolicitud(soli);
    }

    public ArrayList<Solicitud> listarSolicitudes()
    {
        return this.daoSolicitud.listarAllSolicitudes();
    }

    public ArrayList<Solicitud> listarSolicitudesUsuario(String id) {return this.daoSolicitud.listarSolicitudesUsuario(id);}

    public Solicitud consultarUltimaSolicitud(int codUsuario){ return this.daoSolicitud.consultarUltimaSolicitud(codUsuario);}

    /*******
     * Prestamo
     */

    public ArrayList<Prestamo> listarPrestamosUsuario(String id)
    {
        return this.daoPrestamo.listarPrestamosU(id);
    }
    public ArrayList<Prestamo> listarPrestamos()
    {
        return this.daoPrestamo.listarPrestamos();
    }

    /*******
     * PrestamoLibro
     */
    public ArrayList<PrestamoLibro> listarPrestamosLibros(int numero){return this.daoPrestamoLibro.consultarPrestamosLibros(numero);}
    public ArrayList<PrestamoLibro> listarPrestamosActivos(int numero){return this.daoPrestamoLibro.consultarPrestamosActivos(numero);}
    public boolean modificarEstPresLib(int numPres, int numEjem, String isbn, boolean estado){return this.daoPrestamoLibro.modificarEstado(numPres, isbn, numEjem, estado);}
    public PrestamoLibro getPrestamoLib(int numeroPres, String isbn, int numEjem){return this.daoPrestamoLibro.getPl(numeroPres, isbn, numEjem);}
    /*******
     * Empleado
     */

    public int agregarEmpleado(Empleado empleado)
    {
        return this.daoEmpleado.insertEmpleado(empleado);
    }

    public boolean editarEmpleado(Empleado empleado)
    {
        return this.daoEmpleado.modificarEmpleado(empleado);
    }

    public boolean eliminarEmpleado(String id)
    {
        return this.daoEmpleado.eliminarEmpleado(id);
    }

    public Empleado buscarEmpleado(String id)
    {
        return this.daoEmpleado.consultarEmpleado(id);
    }

    public String buscarNombreEmpleado(String id)
    {
        return this.daoEmpleado.consultarEmpleado(id).getNombre();
    }

    public ArrayList<Empleado> listarEmpleados()
    {
        return this.daoEmpleado.listarEmpleados();
    }

    /*******
     * Autor
     */
    public int agregarAutor(Autor autor){return this.daoAutor.insertAutor(autor);}
    public boolean modificarAutor(Autor autor){return this.daoAutor.modificarAutor(autor);}
    public ArrayList<Autor> listarAutores(){return this.daoAutor.listarAutores();}
    public Autor consultarAutor(int cod){return this.daoAutor.consultarAutor(cod);}
    public String getNombreAutor(int cod){return this.daoAutor.consultarNomAutor(cod);}
    /*******
     * AreaConocimiento
     */

    public int agregarArea(AreaConocimiento area)
    {
        return this.daoAreaConocimiento.insertAreaConocimiento(area);
    }

    public boolean editarArea(AreaConocimiento area) {return this.daoAreaConocimiento.modificarAreaConocimiento(area);}

    public boolean eliminarArea(int codigoArea) {return this.daoAreaConocimiento.eliminarAreaConocimiento(codigoArea);}

    public AreaConocimiento buscarArea(int codigoArea) {return this.daoAreaConocimiento.consultarAreaConocimiento(codigoArea);}

    public AreaConocimiento buscarUltimoArea() {return this.daoAreaConocimiento.consultarUltimoAreaConocimiento();}

    public ArrayList<AreaConocimiento> listarAreas()
    {
        return this.daoAreaConocimiento.listarAreasConocimientos();
    }

    public boolean consultarAreaLibro(int codigoArea) {return this.daoAreaConocimiento.consultarAreaLibro(codigoArea);}

    /*******
     * AreaConforma
     */
    public boolean agregarAreaConforma(AreaConforma areaConf) {return this.daoAreaConforma.insertAreaConforma(areaConf);}

    public ArrayList<Integer> listarCodAreasConforma(int codArea) {return this.daoAreaConforma.consultarCodAreasConforma(codArea);}

    public ArrayList<Integer> listarCodAreasConforman(int codArea) {return this.daoAreaConforma.consultarCodAreasConforman(codArea);}

    public String consultarCodAreasConformaString(int codArea) {return  this.daoAreaConforma.consultarCodAreasHijaString(codArea);}

    public boolean eliminarAreasHija(int codArea) {return this.daoAreaConforma.eliminarAreasHija(codArea);}

    public boolean eliminarAreasPadre(int codArea) {return this.daoAreaConforma.eliminarAreasPadre(codArea);}

    /*******
     * Editorial
     */

    public int agregarEditorial(Editorial editorial)
    {
        return this.daoEditorial.insertEditorial(editorial);
    }

    public boolean editarEditorial(Editorial editorial)
    {
        return this.daoEditorial.modificarEditorial(editorial);
    }

    public boolean eliminarEditorial(int codEditorial)
    {
        return this.daoEditorial.eliminarEditorial(codEditorial);
    }

    public Editorial buscarEditorial(int codEditorial)
    {
        return this.daoEditorial.consultarEditorial(codEditorial);
    }

    public ArrayList<Editorial> listarEditoriales()
    {
        return this.daoEditorial.listarEditorial();
    }

    public String getNombreEditorial(int codEditorial){return this.daoEditorial.consultarNombreEditorial(codEditorial);}

    public Editorial consultarUltimoEditorial() {return this.consultarUltimoEditorial();}

    /*******
     * Libro
     */

    public int agregarLibro(Libro libro)
    {
        return this.daoLibro.insertLibro(libro);
    }

    public boolean editarLibro(Libro libro)
    {
        return this.daoLibro.modificarLibro(libro);
    }

    public boolean eliminarLibro(String isbn)
    {
        return this.daoLibro.eliminarLibro(isbn) && this.daoAutorLibro.eliminarAutorLibro(isbn);
    }

    public Libro buscarLibroIsbn(String isbn)
    {
        return this.daoLibro.consultarLibro(isbn);
    }

    public ArrayList<Libro> listarLibros()
    {
        return this.daoLibro.listarLibro();
    }

    /*******
     * Autor_Libro
     */

    public int agregarAutorlibro(AutorLibro autorLibro)
    {
        return this.daoAutorLibro.insertAutor(autorLibro);
    }

    public boolean editarAutorLibro(AutorLibro autorLibro)
    {
        return this.daoAutorLibro.modificarAutorLibro(autorLibro);
    }

    public ArrayList<Integer> getCodigosAutoresLibro(String isbn)
    {
        return this.daoAutorLibro.consultarCodsAutores(isbn);
    }

    /*******
     * Ejemplar
     */

    public int agregarEjemplar(Ejemplar ejemplar)
    {
        return this.daoEjemplar.insertEjemplar(ejemplar);
    }

    public boolean editarEjemplar(Ejemplar ejemplar)
    {
        return this.daoEjemplar.modificarEjemplar(ejemplar);
    }

    public boolean eliminarEjemplar(String isbn, int numEjemplar)
    {
        return this.daoEjemplar.eliminarEjemplar(isbn, numEjemplar);
    }

    public Ejemplar buscarEjemplar(String isbn, int numEjemplar)
    {
        return this.daoEjemplar.consultarEjemplar(isbn, numEjemplar);
    }

    public ArrayList<Ejemplar> listarEjemplares()
    {
        return this.daoEjemplar.listarEjemplar();
    }

    public boolean modificarEstadoEjem(String isbn, int numero, boolean estado){return this.daoEjemplar.modificarEstadoEjemplar(isbn, numero , estado);}
    /*******
     * Digital
     */

    public int agregarDigital(Digital digital)
    {
        return this.daoDigital.insertLibroDigital(digital);
    }

    public boolean editarDigital(Digital digital) {return this.daoDigital.modificarLibroDigital(digital);}

    public boolean eliminarDigital(String isbn) {return this.daoDigital.eliminarDigital(isbn);}

    public Digital buscarDigital(String isbn) {return this.daoDigital.consultarLibroDigital(isbn);}

    public ArrayList<Digital> listarDigitales() {return this.daoDigital.listarDigital();}

    /*******
     * Descarga
     */
    public int agregarDescarga(Descarga de) {return this.daoDescarga.insertDescarga(de);}

    public ArrayList<Descarga> listarDescargas() {return this.daoDescarga.listarDescargas();}
}
