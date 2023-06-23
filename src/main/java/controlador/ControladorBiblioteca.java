package controlador;

import dao.DaoEmpleado;
import dao.DaoEstudiante;
import dao.DaoProfesor;
import modelo.*;
import vista.VentanaBiblioteca;
import vista.VentanaLogin;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class ControladorBiblioteca
{

    private final VentanaBiblioteca ventanaBiblioteca;
    private final Usuario usuario;
    private final ManejadorDao manejadorDao;
    public ControladorBiblioteca(VentanaBiblioteca auxA, Usuario auxB, ManejadorDao manejadorDao)
    {
        this.ventanaBiblioteca = auxA;
        this.usuario = auxB;
        this.manejadorDao = manejadorDao;

        if(usuario instanceof Profesor || usuario instanceof Estudiante)
        {
            ventanaBiblioteca.menuUsuario();
            ventanaBiblioteca.pagLibroUsuario();
            ventanaBiblioteca.pantallaCompleta();
            listarTablasUsuarios(usuario.getId());


            ventanaBiblioteca.addBotonesPerfilEsudianteListener(new EstudianteUListener());
            ventanaBiblioteca.addBotonesPerfilProfesorListener(new ProfesorUListener());
            ventanaBiblioteca.addBotonAgregarSolicitud(new SolicitudUListener());
        }
        if(usuario instanceof Empleado)
        {
            ventanaBiblioteca.pantallaCompleta();
            listarTablasEmpleado();
        }
        else if(usuario == null)
        {
            ventanaBiblioteca.menuAdmin();
            ventanaBiblioteca.pagAreaAdmin();
            ventanaBiblioteca.pantallaCompleta();
            listarTablasAdmin();

            ventanaBiblioteca.addBotonesEmpleadoAdminListener(new EmpleadoListener());
            ventanaBiblioteca.addBotonesAreaAdminListener(new AreaConocimientoListener());
            ventanaBiblioteca.addBotonesAutorAdListener(new AutorListener());
            ventanaBiblioteca.addBotonesEditorialAdListener(new EditorialListener());
            ventanaBiblioteca.addBotonesLibroAdListener(new LibroListener());
            ventanaBiblioteca.addBotonesEditorialAdListener(new EditorialListener());
            ventanaBiblioteca.addBotonesEjemplarAdListener(new EjemplarListener());
            ventanaBiblioteca.addBotonesDigitalAdListener(new DigitalListener());
        }
        ventanaBiblioteca.addBotonesEncabezadoListener(new EncabezadoListener());
    }

    private void cerrarSesion()
    {
        ventanaBiblioteca.dispose();
        VentanaLogin a = new VentanaLogin();
        DaoEstudiante b = new DaoEstudiante();
        DaoProfesor d = new DaoProfesor();
        DaoEmpleado e = new DaoEmpleado();
        ControladorLogin c = new ControladorLogin(a, b, d, e);
    }

    private void perfilEstudiante()
    {
        ventanaBiblioteca.setCedulaEstudianteP(usuario.getId());
        ventanaBiblioteca.setNombreEstudianteP(usuario.getNombre());
        ventanaBiblioteca.setCorreoEstudianteP(usuario.getEmail());
        ventanaBiblioteca.setClaveEstudianteP(usuario.getContrasena());
        ventanaBiblioteca.setDireccionEstudianteP(usuario.getDireccion());
        ventanaBiblioteca.setTelefonoEstudianteP(usuario.getTelefono());
        ventanaBiblioteca.setCarreraEstudianteP(((Estudiante) usuario).getCarrera());
        ventanaBiblioteca.setUniversidadEstudianteP(((Estudiante) usuario).getUniversidad());
    }

    private void perfilProfesor()
    {
        ventanaBiblioteca.setCedulaProfesorP(usuario.getId());
        ventanaBiblioteca.setNombreProfesorP(usuario.getNombre());
        ventanaBiblioteca.setCorreoProfesorP(usuario.getEmail());
        ventanaBiblioteca.setClaveProfesorP(usuario.getContrasena());
        ventanaBiblioteca.setDireccionProfesorP(usuario.getDireccion());
        ventanaBiblioteca.setTelefonoProfesorP(usuario.getTelefono());
        ventanaBiblioteca.setTituloProfesorP(((Profesor) usuario).getTitulo());
        ventanaBiblioteca.setDependenciaProfesorP(((Profesor) usuario).getDependencia());
    }

    class EncabezadoListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("cerrarSesion"))
            {
                cerrarSesion();
            }
            if (e.getActionCommand().equalsIgnoreCase("usuario"))
            {
                if(usuario instanceof Profesor)
                {
                    ventanaBiblioteca.pagPerfilProfesor();
                    perfilProfesor();
                }
                else if(usuario instanceof Estudiante)
                {
                    ventanaBiblioteca.pagPerfilEstudiante();
                    perfilEstudiante();
                }
                else
                {
                    ventanaBiblioteca.mostrarMensajeError("No es posible para su perfil");
                }
            }
        }
    }

    private boolean comprobarCorreo(String email)
    {
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }

    /**************************************************************************
     * Listar
     *************************************************************************/
    public void listarTablasUsuarios(String id)
    {
        if(!manejadorDao.listarSolicitudesUsuario(id).isEmpty())
        {
            listarSolicitudesTablaU(usuario.getId());
        }
        if(!manejadorDao.listarPrestamosUsuario(id).isEmpty())
        {
            listarPrestamosTablaU(usuario.getId());
        }
    }

    public void listarTablasAdmin()
    {
        if(!manejadorDao.listarEmpleados().isEmpty())
        {
            listarEmpleadosTablaA();
        }
        if(!manejadorDao.listarUsuarios().isEmpty()) {
            listarUsuariosTablaA();
        }
        if(!manejadorDao.listarSolicitudes().isEmpty())
        {
            listarSolicitudesTablaA();
        }
        if(!manejadorDao.listarPrestamos().isEmpty())
        {
            listarPrestamosTablaA();
        }
        /*
        if(!manejadorDao.listarAreas().isEmpty())
        {
            listarAreasTablaA();
        }

         */
        if(!manejadorDao.listarAutores().isEmpty())
        {
            listarAutorTablaAd();
        }
        if(!manejadorDao.listarEditoriales().isEmpty())
        {
            listarEditorialTablaAd();
        }
        if(!manejadorDao.listarLibros().isEmpty())
        {
            listarLibroTablaAd();
        }
        if(!manejadorDao.listarEjemplares().isEmpty())
        {
            listarEjemplarTablaAd();
        }
        if(!manejadorDao.listarDigitales().isEmpty())
        {
            listarDigitalTablaAd();
        }
    }

    public void listarTablasEmpleado()
    {
        if(!manejadorDao.listarSolicitudes().isEmpty())
        {
            listarSolicitudesTablaE();
        }
    }

    /**************************************************************************
     * usuario - Admin
     *************************************************************************/
    public void listarUsuariosTablaA()
    {
        ArrayList<Usuario> arrayUsu;
        arrayUsu = manejadorDao.listarUsuarios();
        if(arrayUsu != null)
        {
            String id;
            String nom;
            String email;
            String dir;
            String telefono;

            for (Usuario usuario : arrayUsu) {
                id = usuario.getId();
                nom = usuario.getNombre();
                email = usuario.getEmail();
                dir = usuario.getDireccion();
                telefono = usuario.getTelefono();

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getUsuarioAdminTableModel();
                auxModeloTabla.addRow(new Object[]{id, nom, email, dir, telefono});
            }
        }
    }
    /**************************************************************************
     * Estudiante - Usuario
     *************************************************************************/
    class EstudianteUListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("modificar"))
            {
                modificarEstudiante();
            }
        }
    }
    private void modificarEstudiante()
    {
        Estudiante auxEstudiante;
        String auxId;
        String auxNombre;
        String auxDireccion;
        String auxTelefono;
        String auxEmail;
        String auxContrasena;
        String auxCarrera;
        String auxUniversidad;

        auxId = ventanaBiblioteca.getCedulaEstudianteP();
        auxNombre = ventanaBiblioteca.getNombreEstudianteP();
        auxDireccion = ventanaBiblioteca.getDireccionEstudianteP();
        auxTelefono = ventanaBiblioteca.getTelefonoEstudianteP();
        auxEmail = ventanaBiblioteca.getCorreoEstudianteP();
        auxContrasena = ventanaBiblioteca.getClaveEstudianteP();
        auxCarrera = ventanaBiblioteca.getCarreraEstudianteP();
        auxUniversidad = ventanaBiblioteca.getUniversidadEstudianteP();
        if(comprobarCamposEstudianteU())
        {
            if (comprobarCorreo(auxEmail))
            {
                auxEstudiante = new Estudiante(auxId, auxNombre, auxEmail, auxContrasena, auxDireccion, auxTelefono, auxCarrera, auxUniversidad);
                if (manejadorDao.modificarEst(auxEstudiante))
                {
                    ventanaBiblioteca.mostrarMensaje("Se ha actualizado la información");
                } else
                {
                    ventanaBiblioteca.mostrarMensajeError("No se ha podido actualizar la información");
                }
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("Email invalido");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Datos invalidos, recuerde no dejar campos vacios");
        }
    }

    private boolean comprobarCamposEstudianteU()
    {
        boolean valido;
        valido = !ventanaBiblioteca.getClaveEstudianteP().isEmpty() && !ventanaBiblioteca.getNombreEstudianteP().isEmpty() && !ventanaBiblioteca.getDireccionEstudianteP().isEmpty() && !ventanaBiblioteca.getCorreoEstudianteP().isEmpty() && !ventanaBiblioteca.getCarreraEstudianteP().isEmpty() && !ventanaBiblioteca.getUniversidadEstudianteP().isEmpty();
        return valido;
    }

    /**************************************************************************
     * Profesor - Usuario
     *************************************************************************/

    class ProfesorUListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("modificar"))
            {
                modificarProfesor();
            }

        }
    }
    private void modificarProfesor()
    {
        Profesor auxProfesor;
        String auxId;
        String auxNombre;
        String auxDireccion;
        String auxTelefono;
        String auxEmail;
        String auxContrasena;
        String auxTitulo;
        String auxDependencia;

        auxId = ventanaBiblioteca.getCedulaProfesorP();
        auxNombre = ventanaBiblioteca.getNombreProfesorP();
        auxDireccion = ventanaBiblioteca.getDireccionProfesorP();
        auxTelefono = ventanaBiblioteca.getTelefonoProfesorP();
        auxEmail = ventanaBiblioteca.getCorreoProfesorP();
        auxContrasena = ventanaBiblioteca.getClaveProfesorP();
        auxTitulo = ventanaBiblioteca.getTituloProfesorP();
        auxDependencia = ventanaBiblioteca.getDependenciaProfesorP();
        if(comprobarCamposProfesorU())
        {
            if(comprobarCorreo(auxEmail))
            {
                auxProfesor = new Profesor(auxId, auxNombre, auxEmail, auxContrasena, auxDireccion, auxTelefono, auxTitulo, auxDependencia);

                if (manejadorDao.modificarPro(auxProfesor))
                {
                    ventanaBiblioteca.mostrarMensaje("Se ha actualizado la información");
                } else
                {
                    ventanaBiblioteca.mostrarMensajeError("No se ha podido actualizar la información");
                }
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("Email invalido");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Datos invalidos, recuerde no dejar campos vacios");
        }
    }

    private boolean comprobarCamposProfesorU()
    {
        boolean valido;
        valido = !ventanaBiblioteca.getClaveProfesorP().isEmpty() && !ventanaBiblioteca.getNombreProfesorP().isEmpty() && !ventanaBiblioteca.getDireccionProfesorP().isEmpty() && !ventanaBiblioteca.getCorreoProfesorP().isEmpty() && !ventanaBiblioteca.getTituloProfesorP().isEmpty() && !ventanaBiblioteca.getDependenciaProfesorP().isEmpty();
        return valido;
    }

    /**************************************************************************
     * Solicitud - Usuario
     *************************************************************************/

    class SolicitudUListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("enviar"))
            {
                agregarSolicitud();
            }
        }
    }

    public void agregarSolicitud()
    {
        Solicitud solicitud;
        String auxIsbn;
        String auxTitulo;
        String auxDescripcion;

        auxIsbn = ventanaBiblioteca.getTxtIsbnSolicitudU();
        auxTitulo = ventanaBiblioteca.getTxtTituloSolicitudU();
        auxDescripcion = ventanaBiblioteca.getTxaDescripcionSolicitudU();

        if(comprobarCamposSolicitudU())
        {
            solicitud = new Solicitud(usuario.getId(), auxIsbn, auxTitulo, auxDescripcion);
            if(manejadorDao.agregarSolicitud(solicitud) > 0)
            {
                listarSolicitudesTablaUAgregar(solicitud);
                ventanaBiblioteca.mostrarMensaje("Solicitud realizada con exito");
                ventanaBiblioteca.limpiarSolicitudUsuario();
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("No se pudo crear la solicitud");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Verifique los campos isbn y titulo");
        }
    }

    public void listarSolicitudesTablaU(String id)
    {
        ArrayList<Solicitud> arraySol;
        arraySol = manejadorDao.listarSolicitudesUsuario(id);
        if(arraySol != null)
        {
            int auxId;
            String auxIsbn;
            String auxTitulo;
            String auxDescripcion;

            for (Solicitud solicitud : arraySol) {
                auxId = solicitud.getNumero();
                auxIsbn = solicitud.getIsbnLibro();
                auxTitulo = solicitud.getTitulo();
                auxDescripcion = solicitud.getDescripcion();

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getSolicitudUTableModel();
                auxModeloTabla.addRow(new Object[]{auxId, auxIsbn, auxTitulo, auxDescripcion});
            }
        }
    }

    public void listarSolicitudesTablaUAgregar(Solicitud solicitud)
    {
        if(solicitud != null)
        {
            int auxId;
            String auxIsbn;
            String auxTitulo;
            String auxDescripcion;

                auxId = solicitud.getNumero();
                auxIsbn = solicitud.getIsbnLibro();
                auxTitulo = solicitud.getTitulo();
                auxDescripcion = solicitud.getDescripcion();

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getSolicitudUTableModel();
                auxModeloTabla.addRow(new Object[]{auxId, auxIsbn, auxTitulo, auxDescripcion});
        }
    }

    public boolean comprobarCamposSolicitudU()
    {
        boolean valido;
        valido = !ventanaBiblioteca.getTxtIsbnSolicitudU().isEmpty() && !ventanaBiblioteca.getTxtTituloSolicitudU().isEmpty();
        return valido;
    }

    /**************************************************************************
     * Solicitud - Admin
     *************************************************************************/
    public void listarSolicitudesTablaA()
    {
        ArrayList<Solicitud> arraySol;
        arraySol = manejadorDao.listarSolicitudes();
        if(arraySol != null)
        {
            int auxId;
            String auxIsbn;
            String auxTitulo;
            String auxDescripcion;

            for (Solicitud solicitud : arraySol) {
                auxId = solicitud.getNumero();
                auxIsbn = solicitud.getIsbnLibro();
                auxTitulo = solicitud.getTitulo();
                auxDescripcion = solicitud.getDescripcion();

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getSolicitudAdminTableModel();
                auxModeloTabla.addRow(new Object[]{auxId, auxIsbn, auxTitulo, auxDescripcion});
            }
        }
    }

    /**************************************************************************
     * Solicitud - Empleado
     *************************************************************************/
    public void listarSolicitudesTablaE()
    {
        ArrayList<Solicitud> arraySol;
        arraySol = manejadorDao.listarSolicitudes();
        if(arraySol != null)
        {
            int auxId;
            String auxIsbn;
            String auxTitulo;
            String auxDescripcion;

            for (Solicitud solicitud : arraySol) {
                auxId = solicitud.getNumero();
                auxIsbn = solicitud.getIsbnLibro();
                auxTitulo = solicitud.getTitulo();
                auxDescripcion = solicitud.getDescripcion();

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getSolicitudEmpTableModel();
                auxModeloTabla.addRow(new Object[]{auxId, auxIsbn, auxTitulo, auxDescripcion});
            }
        }
    }

    /**************************************************************************
     * Prestamo - Usuario
     *************************************************************************/
    public void listarPrestamosTablaU(String id)
    {
        ArrayList<Prestamo> arrayPrestamo;
        ArrayList<PrestamoLibro> arrayPrestamoLibros;
        arrayPrestamo = manejadorDao.listarPrestamosUsuario(id);
        DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getPrestamoUTableModel();
        if(arrayPrestamo != null)
        {
            int num;
            String nomE;
            Date fecha;
            String isbn;
            int numEje;
            Date fechaD;

            for (Prestamo prestamo : arrayPrestamo) {
                num = prestamo.getNumPrestamo();
                fecha = prestamo.getFechaR();
                nomE = manejadorDao.buscarNombreEmpleado(prestamo.getIdEmpleado());

                arrayPrestamoLibros = manejadorDao.listarPrestamosLibros(num);

                for(PrestamoLibro prestamoLibro: arrayPrestamoLibros)
                {
                    isbn = prestamoLibro.getIsbn();
                    numEje = prestamoLibro.getNumEjemplar();
                    fechaD = prestamoLibro.getFechaDev();
                    auxModeloTabla.addRow(new Object[]{num, fecha, isbn, numEje, fechaD, nomE});
                }
            }
        }
    }

    /**************************************************************************
     * Prestamo - Admin
     *************************************************************************/
    public void listarPrestamosTablaA()
    {
        ArrayList<Prestamo> arrayPrestamo;
        arrayPrestamo = manejadorDao.listarPrestamos();

        ArrayList<PrestamoLibro> arrayPrestamoLibros;

        if(arrayPrestamo != null)
        {
            int num;
            String nomE;
            Date fecha;
            String isbn;
            int numEje;
            Date fechaD;
            String tituloL;
            String idUsu;

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getPrestamoAdminTableModel();

            for (Prestamo prestamo : arrayPrestamo)
            {
                num = prestamo.getNumPrestamo();
                idUsu = prestamo.getIdUsuario();
                fecha = prestamo.getFechaR();
                nomE = manejadorDao.buscarNombreEmpleado(prestamo.getIdEmpleado());

                arrayPrestamoLibros = manejadorDao.listarPrestamosLibros(num);

                for (PrestamoLibro prestamoLibro : arrayPrestamoLibros)
                {
                    isbn = prestamoLibro.getIsbn();
                    tituloL = manejadorDao.buscarLibroIsbn(isbn).getTitulo();
                    numEje = prestamoLibro.getNumEjemplar();
                    fechaD = prestamoLibro.getFechaDev();
                    auxModeloTabla.addRow(new Object[]{num, isbn, numEje, tituloL, idUsu, nomE, fecha, fechaD});
                }
            }
        }
    }

    /**************************************************************************
     * Empleado - admin
     *************************************************************************/
    class EmpleadoListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("agregar"))
            {
                agregarEmpleado();
            }
            if (e.getActionCommand().equalsIgnoreCase("modificar"))
            {
                editarEmpleado();
            }
            if (e.getActionCommand().equalsIgnoreCase("eliminar"))
            {
                eliminarEmpleado();
            }
        }
    }

    public void listarEmpleadosTablaA()
    {
        ArrayList<Empleado> arrayEmpleado;
        arrayEmpleado = manejadorDao.listarEmpleados();
        if(arrayEmpleado != null)
        {
            String id;
            String nom;
            String email;
            String clave;
            String dir;
            String telefono;
            String cargo;

            for (Empleado empleado : arrayEmpleado) {
                id = empleado.getId();
                nom = empleado.getNombre();
                email = empleado.getEmail();
                clave = empleado.getContrasena();
                dir = empleado.getDireccion();
                telefono = empleado.getTelefono();
                cargo = empleado.getCargo();

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEmpleadoTableModel();
                auxModeloTabla.addRow(new Object[]{id, nom, email, clave, dir, telefono, cargo});
            }
        }
    }
    public boolean comprobarCamposEmpleadoA()
    {
        boolean valido;
        valido = !ventanaBiblioteca.getTxtCedulaEmpleadoA().isEmpty() && !ventanaBiblioteca.getTxtNombreEmpleadoA().isEmpty() && !ventanaBiblioteca.getTxtClaveEmpleadoA().isEmpty() && !ventanaBiblioteca.getTxtCorreoEmpleadoA().isEmpty() && !ventanaBiblioteca.getTxtTelefonoEmpleadoA().isEmpty() && !ventanaBiblioteca.getTxtCargoEmpleadoA().isEmpty() && !ventanaBiblioteca.getTxtDireccionEmpleadoA().isEmpty();
        return valido;
    }

    public void agregarEmpleado()
    {
        Empleado empleado;
        String cedula;
        String clave;
        String nombre;
        String direccion;
        String correo;
        String telefono;
        String cargo;
        if(comprobarCamposEmpleadoA())
        {
            cedula = ventanaBiblioteca.getTxtCedulaEmpleadoA();
            clave = ventanaBiblioteca.getTxtClaveEmpleadoA();
            nombre = ventanaBiblioteca.getTxtNombreEmpleadoA();
            direccion = ventanaBiblioteca.getTxtDireccionEmpleadoA();
            correo = ventanaBiblioteca.getTxtCorreoEmpleadoA();
            telefono = ventanaBiblioteca.getTxtTelefonoEmpleadoA();
            cargo = ventanaBiblioteca.getTxtCargoEmpleadoA();

            if(comprobarCorreo(correo)) {
                empleado = new Empleado(cedula, nombre, correo, clave, direccion, telefono, cargo);
                if (manejadorDao.agregarEmpleado(empleado) > 0) {
                    listarEmpleadoTablaAdAgregar(empleado);
                    ventanaBiblioteca.mostrarMensaje("Empleado agregado con exito");
                    ventanaBiblioteca.limpiarEmpleadoAdmin();
                } else {
                    ventanaBiblioteca.mostrarMensajeError("No se pudo crear el empleado");
                }
            }
        }
        else
        {
                ventanaBiblioteca.mostrarMensajeError("Verifique que los campos hayan sido bien digitados");
        }
    }

    public void listarEmpleadoTablaAdAgregar(Empleado empleado)
    {
        if(empleado != null)
        {
            String cedula;
            String clave;
            String nombre;
            String direccion;
            String correo;
            String telefono;
            String cargo;

            cedula = empleado.getId();
            clave = empleado.getContrasena();
            nombre = empleado.getNombre();
            direccion = empleado.getDireccion();
            correo = empleado.getEmail();
            telefono = empleado.getTelefono();
            cargo = empleado.getCargo();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEmpleadoTableModel();
            auxModeloTabla.addRow(new Object[]{cedula, nombre, correo, clave, direccion, telefono, cargo});
        }
    }

    public void editarEmpleado()
    {
        Empleado empleado;
        String cedula;
        String correo;

        cedula = ventanaBiblioteca.getTxtCedulaEmpleadoA();
        empleado = manejadorDao.buscarEmpleado(cedula);
        if(ventanaBiblioteca.getFilaSeleccionadaEmpleado() >-1) {
            if (empleado != null) {
                correo = ventanaBiblioteca.getTxtCorreoEmpleadoA();
                if (comprobarCamposEmpleadoA() && comprobarCorreo(correo)) {
                    empleado.setContrasena(ventanaBiblioteca.getTxtClaveEmpleadoA());
                    empleado.setNombre(ventanaBiblioteca.getTxtNombreEmpleadoA());
                    empleado.setEmail(ventanaBiblioteca.getTxtCorreoEmpleadoA());
                    empleado.setDireccion(ventanaBiblioteca.getTxtDireccionEmpleadoA());
                    empleado.setTelefono(ventanaBiblioteca.getTxtTelefonoEmpleadoA());
                    empleado.setCargo(ventanaBiblioteca.getTxtCargoEmpleadoA());

                    if (manejadorDao.editarEmpleado(empleado)) {
                        ventanaBiblioteca.mostrarMensaje("Empleado editado con exito");
                        listarEmpleadoTabAdEditar(empleado);
                        ventanaBiblioteca.deseleccionarFilaTablaEmpleado();
                        ventanaBiblioteca.limpiarEmpleadoAdmin();
                    } else {
                        ventanaBiblioteca.mostrarMensajeError("No se pudo editar el empleado, puede que el correo ya este en uso");
                    }
                } else {
                    ventanaBiblioteca.mostrarMensajeError("Digite bien los campos");
                }
            } else {
                ventanaBiblioteca.mostrarMensajeError("Ocurrio un error");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Seleccione la fila a editar");
        }
    }

    public void listarEmpleadoTabAdEditar(Empleado empleado)
    {
        if(empleado != null) {
            String clave;
            String nombre;
            String direccion;
            String correo;
            String telefono;
            String cargo;

            clave = empleado.getContrasena();
            nombre = empleado.getNombre();
            direccion = empleado.getDireccion();
            correo = empleado.getEmail();
            telefono = empleado.getTelefono();
            cargo = empleado.getCargo();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEmpleadoTableModel();
            int auxFila = ventanaBiblioteca.getFilaSeleccionadaEmpleado();

            auxModeloTabla.setValueAt(nombre, auxFila, 1);
            auxModeloTabla.setValueAt(correo, auxFila, 2);
            auxModeloTabla.setValueAt(clave, auxFila, 3);
            auxModeloTabla.setValueAt(direccion, auxFila, 4);
            auxModeloTabla.setValueAt(telefono, auxFila, 5);
            auxModeloTabla.setValueAt(cargo, auxFila, 6);
        }
    }

    public void eliminarEmpleado()
    {
        String id = ventanaBiblioteca.getTxtCedulaEmpleadoA();
        Empleado empleado = manejadorDao.buscarEmpleado(id);

        if(empleado != null)
        {
            if(manejadorDao.eliminarEmpleado(id))
            {
                ventanaBiblioteca.mostrarMensaje("Empleado eliminado");
                ventanaBiblioteca.limpiarEmpleadoAdmin();
                listarEmpleadoTabAdEliminar();
                ventanaBiblioteca.deseleccionarFilaTablaEmpleado();
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("No se pudo realizar la acción");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("No se encontro el empleado");
        }
    }

    public void listarEmpleadoTabAdEliminar()
    {
        DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEmpleadoTableModel();
        int auxFila = ventanaBiblioteca.getFilaSeleccionadaEmpleado();
        auxModeloTabla.removeRow(auxFila);
    }

    /**************************************************************************
     Controlador_AreaConocimiento
     * AreaConocimiento - admin
     *************************************************************************/

    class AreaConocimientoListener implements ActionListener
    {
       @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("agregar"))
            {
                agregarArea();
            }
            if (e.getActionCommand().equalsIgnoreCase("modificar"))
            {
                editarArea();
            }
            if (e.getActionCommand().equalsIgnoreCase("eliminar"))
            {
                eliminarArea();
            }
        }
    }
      
      public void listarAreasTablaA()
    {
        ArrayList<AreaConocimiento> arrayArea;
        arrayArea = manejadorDao.listarAreas();
        if(arrayArea != null)
        {
            int codArea;
            String nomArea;
            String descripcion;
            String areaHija;

            for (AreaConocimiento area : arrayArea) {
                codArea = area.getCodigoArea();
                nomArea = area.getNomArea();
                descripcion = area.getDescripcion();
                areaHija = area.getAreaHija();

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getAreaAdminTableModel();
                auxModeloTabla.addRow(new Object[]{codArea, nomArea, descripcion, areaHija});
            }
        }
    }
    public boolean comprobarCamposAreaA()
    {
        boolean valido;
        valido = !ventanaBiblioteca.getTxtNombreAreaA().isEmpty();
        return valido;
    }

    public void listarAreaTablaAdAgregar(AreaConocimiento area)
    {
        if(area != null)
        {
            int codArea;
            String nomArea;
            String descripcion;
            String areaHija;

            codArea = area.getCodigoArea();
            nomArea = area.getNomArea();
            descripcion = area.getDescripcion();
            areaHija = area.getAreaHija();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getAreaAdminTableModel();
            auxModeloTabla.addRow(new Object[]{codArea, nomArea, descripcion, areaHija});
        }
    }

    public void agregarArea()
    {
        AreaConocimiento area;
        int codArea;
        String nomArea;
        String descripcion;

        codArea = Integer.parseInt(ventanaBiblioteca.getTxtCodAreaA());
        if(codArea == 0)
        {
            if (comprobarCamposAreaA())
            {
                try
                {
                    nomArea = ventanaBiblioteca.getTxtNombreAreaA();
                    descripcion = ventanaBiblioteca.getTxaDescripcionAreaA();

                    area = new AreaConocimiento(nomArea, descripcion);

                    if (manejadorDao.agregarArea(area) > 0)
                    {
                        listarAreaTablaAdAgregar(area);
                        ventanaBiblioteca.mostrarMensaje("Area agregada con exito");
                        ventanaBiblioteca.limpiarAreaAdmin();
                    }
                    else
                    {
                        ventanaBiblioteca.mostrarMensajeError("No se pudo crear el area");
                    }
                }
                catch (NumberFormatException e)
                {
                    ventanaBiblioteca.mostrarMensajeError("Llene el campo del nombre");
                }
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Deseleccione el area");
        }
    }

    public void listarAreaTabAdEditar(AreaConocimiento area){
        if(area != null)
        {
            String nomArea;
            String descripcion;
            String areaHija;

            nomArea = area.getNomArea();
            descripcion = area.getDescripcion();
            areaHija = area.getAreaHija();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getAreaAdminTableModel();
            int auxFila = ventanaBiblioteca.getFilaSeleccionadaArea();

            auxModeloTabla.setValueAt(nomArea, auxFila, 1);
            auxModeloTabla.setValueAt(descripcion, auxFila, 2);
            auxModeloTabla.setValueAt(areaHija, auxFila, 3);
        }
    }

    public void editarArea()
    {
        AreaConocimiento area;
        int codArea;

        codArea = Integer.parseInt(ventanaBiblioteca.getTxtCodAreaA());
        area = manejadorDao.buscarArea(codArea);

        if(area != null)
        {
            if(comprobarCamposAreaA())
            {
                area.setNomArea(ventanaBiblioteca.getTxtNombreAreaA());
                area.setDescripcion(ventanaBiblioteca.getTxaDescripcionAreaA());

                if(manejadorDao.editarArea(area))
                {
                    ventanaBiblioteca.mostrarMensaje("Area editado con exito");
                    listarAreaTabAdEditar(area);
                    ventanaBiblioteca.deseleccionarFilaTablaArea();
                    ventanaBiblioteca.limpiarAreaAdmin();
                }
                else
                {
                    ventanaBiblioteca.mostrarMensajeError("No se pudo editar el area");
                }
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("Llene el campo del nombre");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Ocurrio un error");
        }
    }

    public void listarAreaTablaAdEliminar(AreaConocimiento area)
    {
        DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getAreaAdminTableModel();
        int auxFila = ventanaBiblioteca.getFilaSeleccionadaArea();
        auxModeloTabla.removeRow(auxFila);
    }

    public void eliminarArea()
    {
        int codArea = Integer.parseInt(ventanaBiblioteca.getTxtCodAreaA());
        AreaConocimiento area = manejadorDao.buscarArea(codArea);

        if (area != null)
        {
           if (manejadorDao.eliminarArea(codArea))
           {
               ventanaBiblioteca.mostrarMensaje("Area eliminada");
               ventanaBiblioteca.limpiarAreaAdmin();
               listarAreaTablaAdEliminar(area);
               ventanaBiblioteca.deseleccionarFilaTablaArea();
           }
           else
           {
               ventanaBiblioteca.mostrarMensajeError("No se pudo realizar la acción");
           }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("No se encontró el area");
        }
    }

    /**************************************************************************
    Controlador_Autor
    * Autor - admin
    *************************************************************************/
    class AutorListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("agregar"))
            {
                agregarAutor();
            }
            if (e.getActionCommand().equalsIgnoreCase("modificar"))
            {
                editarAutor();
            }
        }
    }

    public void listarAutorTablaAd()
    {
        ArrayList<Autor> arrayList;
        arrayList = manejadorDao.listarAutores();

        int cod;
        String primerN;
        String segundoN;
        String primerA;
        String segundoA;
        if(arrayList != null)
        {
            for(Autor autor : arrayList)
            {
                cod = autor.getCodAutor();
                primerN = autor.getPrimerNombre();
                segundoN = autor.getSegundoNombre();
                primerA =  autor.getPrimerApellido();
                segundoA = autor.getSegundoApellido();

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getAutorAdminTableModel();
                auxModeloTabla.addRow(new Object[]{cod, primerN, segundoN, primerA, segundoA});
            }
        }
    }

    public void agregarAutor()
    {
        Autor autor;
        String primerN;
        String segundoN;
        String primerA;
        String segundoA;
        if(comprobarCamposAutor())
        {
            primerN = ventanaBiblioteca.getTxtPrimerNomAu();
            segundoN = ventanaBiblioteca.getTxtSegundoNomAu();
            primerA = ventanaBiblioteca.getTxtPrimerApeAu();
            segundoA = ventanaBiblioteca.getTxtSegundoApeAu();
            autor = new Autor(primerN,segundoN,primerA,segundoA);

            if(manejadorDao.agregarAutor(autor) > 0)
            {
                autor.setCodAutor(ventanaBiblioteca.getAutorAdminTableModel().getRowCount()+1);
                listarAutorAgregar(autor);
                ventanaBiblioteca.mostrarMensaje("Autor agregado con exito");
                ventanaBiblioteca.limpiarAutorAdmin();
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("No se pudo agregar el Autor");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Ingrese el primer nombre y los dos apellidos del autor");
        }
    }

    public void listarAutorAgregar(Autor autor)
    {
        if(autor != null)
        {
            int cod;
            String primerN;
            String segundoN;
            String primerA;
            String segundoA;

            cod = autor.getCodAutor();
            primerN = autor.getPrimerNombre();
            segundoN = autor.getSegundoNombre();
            primerA = autor.getPrimerApellido();
            segundoA = autor.getSegundoApellido();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getAutorAdminTableModel();
            auxModeloTabla.addRow(new Object[]{cod, primerN, segundoN, primerA, segundoA});
        }
    }

    public void editarAutor()
    {
        Autor autor;
        int codAutor;
        String primerN;
        String segundoN;
        String primerA;
        String segundoA;

        if (ventanaBiblioteca.getFilaSeleccionadaAutor() > -1) {
            if (comprobarCamposAutor()) {
                codAutor = (int) ventanaBiblioteca.getAutorAdminTableModel().getValueAt(ventanaBiblioteca.getFilaSeleccionadaAutor(), 0);
                System.out.println(codAutor);
                primerN = ventanaBiblioteca.getTxtPrimerNomAu();
                segundoN = ventanaBiblioteca.getTxtSegundoNomAu();
                primerA = ventanaBiblioteca.getTxtPrimerApeAu();
                segundoA = ventanaBiblioteca.getTxtSegundoApeAu();
                autor = new Autor(codAutor, primerN, segundoN, primerA, segundoA);

                if (manejadorDao.modificarAutor(autor)) {
                    listarAutorEditar(autor);
                    ventanaBiblioteca.mostrarMensaje("Autor editado con exito");
                    ventanaBiblioteca.limpiarAutorAdmin();
                    ventanaBiblioteca.deseleccionarFilaTablaAutor();
                } else {
                    ventanaBiblioteca.mostrarMensajeError("No se pudo editar el Autor");
                }
            } else {
                ventanaBiblioteca.mostrarMensajeError("Ingrese el primer nombre y los dos apellidos del autor a editar");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Seleccione la fila a editar");
        }
    }

    public void listarAutorEditar(Autor autor)
    {
        if(autor != null)
        {
            String primerN;
            String segundoN;
            String primerA;
            String segundoA;

            primerN = autor.getPrimerNombre();
            segundoN = autor.getSegundoNombre();
            primerA = autor.getPrimerApellido();
            segundoA = autor.getSegundoApellido();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getAutorAdminTableModel();
            int auxFila = ventanaBiblioteca.getFilaSeleccionadaAutor();

            auxModeloTabla.setValueAt(primerN, auxFila, 1);
            auxModeloTabla.setValueAt(segundoN, auxFila, 2);
            auxModeloTabla.setValueAt(primerA, auxFila, 3);
            auxModeloTabla.setValueAt(segundoA, auxFila, 4);
        }
    }

    public boolean comprobarCamposAutor()
    {
        boolean valido;
        valido = !ventanaBiblioteca.getTxtPrimerNomAu().isEmpty() && !ventanaBiblioteca.getTxtPrimerApeAu().isEmpty() && !ventanaBiblioteca.getTxtSegundoApeAu().isEmpty();
        return valido;
    }

    /**************************************************************************
     Controlador_Editorial
     * Editorial - admin
     *************************************************************************/

    class EditorialListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("agregar"))
            {
                agregarEditorial();
            }
            if (e.getActionCommand().equalsIgnoreCase("modificar"))
            {
                editarEditorial();
            }
            if (e.getActionCommand().equalsIgnoreCase("eliminar"))
            {
                eliminarEditorial();
            }
        }
    }

    public void listarEditorialTablaAd()
    {
        ArrayList<Editorial> arrayEditorial;
        arrayEditorial = manejadorDao.listarEditoriales();
        if(arrayEditorial != null)
        {
            int codEditorial;
            String nomEditorial;
            String paginaWeb;
            String paisOrigen;

            for (Editorial editorial : arrayEditorial) {
                codEditorial = editorial.getCodEditorial();
                nomEditorial = editorial.getNomEditorial();
                paginaWeb = editorial.getPaginaWeb();
                paisOrigen = editorial.getPaisOrigen();

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEditorialAdminTableModel();
                auxModeloTabla.addRow(new Object[]{codEditorial, nomEditorial, paisOrigen, paginaWeb});
            }
        }
    }
    public boolean comprobarCamposEditorialA()
    {
        boolean valido;
        valido = !ventanaBiblioteca.getTxtNombreEditorialA().isEmpty() && !ventanaBiblioteca.getTxtPaginaWebEditorialA().isEmpty() && !ventanaBiblioteca.getTxtPaisEditorialA().isEmpty();
        return valido;
    }

    public void listarEditorialTablaAdAgregar(Editorial editorial)
    {
        if(editorial != null)
        {
            int codEditorial;
            String nomEditorial;
            String paginaWeb;
            String paisOrigen;

            codEditorial = editorial.getCodEditorial();
            nomEditorial = editorial.getNomEditorial();
            paginaWeb = editorial.getPaginaWeb();
            paisOrigen = editorial.getPaisOrigen();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEditorialAdminTableModel();
            auxModeloTabla.addRow(new Object[]{codEditorial, nomEditorial, paisOrigen, paginaWeb});
        }
    }

    public void agregarEditorial()
    {
        Editorial editorial;
        int codEditorial;
        String nomEditorial;
        String paginaWeb;
        String paisOrigen;

        codEditorial = Integer.parseInt(ventanaBiblioteca.getTxtIdEditorialA());
        if(codEditorial == 0)
        {
            if (comprobarCamposEditorialA())
            {
                try
                {
                    nomEditorial = ventanaBiblioteca.getTxtNombreEditorialA();
                    paginaWeb = ventanaBiblioteca.getTxtPaginaWebEditorialA();
                    paisOrigen = ventanaBiblioteca.getTxtPaisEditorialA();

                    editorial = new Editorial(nomEditorial, paginaWeb, paisOrigen);

                    if (manejadorDao.agregarEditorial(editorial) > 0)
                    {
                        listarEditorialTablaAdAgregar(editorial);
                        ventanaBiblioteca.mostrarMensaje("Editorial agregada con exito");
                        ventanaBiblioteca.limpiarEditorialAdmin();
                    }
                    else
                    {
                        ventanaBiblioteca.mostrarMensajeError("No se pudo crear la editorial");
                    }
                }
                catch (NumberFormatException e)
                {
                    ventanaBiblioteca.mostrarMensajeError("Llene todos los campos");
                }
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Deseleccione la editorial");
        }
    }

    public void listarEditorialTabAdEditar(Editorial editorial){
        if(editorial != null)
        {
            String nomEditorial;
            String paginaWeb;
            String paisOrigen;

            nomEditorial = editorial.getNomEditorial();
            paginaWeb = editorial.getPaginaWeb();
            paisOrigen = editorial.getPaisOrigen();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEditorialAdminTableModel();
            int auxFila = ventanaBiblioteca.getFilaSeleccionadaEditorial();

            auxModeloTabla.setValueAt(nomEditorial, auxFila, 1);
            auxModeloTabla.setValueAt(paginaWeb, auxFila, 2);
            auxModeloTabla.setValueAt(paisOrigen, auxFila, 3);
        }
    }

    public void editarEditorial()
    {
        Editorial editorial;
        int codEditorial;

        codEditorial = Integer.parseInt(ventanaBiblioteca.getTxtIdEditorialA());
        editorial = manejadorDao.buscarEditorial(codEditorial);

        if(editorial != null)
        {
            if(comprobarCamposEditorialA())
            {
                editorial.setNomEditorial(ventanaBiblioteca.getTxtNombreEditorialA());
                editorial.setPaginaWeb(ventanaBiblioteca.getTxtPaginaWebEditorialA());
                editorial.setPaisOrigen(ventanaBiblioteca.getTxtPaisEditorialA());

                if(manejadorDao.editarEditorial(editorial))
                {
                    ventanaBiblioteca.mostrarMensaje("Editorial editada con exito");
                    listarEditorialTabAdEditar(editorial);
                    ventanaBiblioteca.deseleccionarFilaTablaEditorial();
                    ventanaBiblioteca.limpiarEditorialAdmin();
                }
                else
                {
                    ventanaBiblioteca.mostrarMensajeError("No se pudo editar la editorial");
                }
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("Llene todos los campos");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Ocurrio un error");
        }
    }

    public void listarEditorialTablaAdEliminar(Editorial editorial)
    {
        DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEditorialAdminTableModel();
        int auxFila = ventanaBiblioteca.getFilaSeleccionadaEditorial();
        auxModeloTabla.removeRow(auxFila);
    }

    public void eliminarEditorial()
    {
        int codEditorial = Integer.parseInt(ventanaBiblioteca.getTxtIdEditorialA());
        Editorial editorial = manejadorDao.buscarEditorial(codEditorial);

        if (editorial != null)
        {
            if (manejadorDao.eliminarEditorial(codEditorial))
            {
                ventanaBiblioteca.mostrarMensaje("Editorial eliminada");
                ventanaBiblioteca.limpiarEditorialAdmin();
                listarEditorialTablaAdEliminar(editorial);
                ventanaBiblioteca.deseleccionarFilaTablaEditorial();
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("No se pudo realizar la acción");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("No se encontró el editorial");
        }
    }

    /**************************************************************************
     Controlador_Libro
     * Libro - admin
     *************************************************************************/

    class LibroListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("agregar"))
            {
                agregarLibro();
            }
            if (e.getActionCommand().equalsIgnoreCase("modificar"))
            {
                editarLibro();
            }
            if (e.getActionCommand().equalsIgnoreCase("eliminar"))
            {
                eliminarLibro();
            }
        }
    }

    public void listarLibroTablaAd()
    {
        ArrayList<Libro> arrayLibro;
        arrayLibro = manejadorDao.listarLibros();
        if(arrayLibro != null)
        {
            String isbn;
            String titulo;
            ArrayList<Integer> codAutores;
            ArrayList<String> nombresAutores;
            String autores;
            int codEditorial;
            String nomEditorial;
            int anhoPublicacion;
            String numPaginas;
            String idioma;

            for (Libro libro : arrayLibro) {
                isbn = libro.getIsbn();
                titulo = libro.getTitulo();
                codEditorial = libro.getCodEditorial();
                nomEditorial = manejadorDao.buscarEditorial(codEditorial).getNomEditorial();
                anhoPublicacion = libro.getAnhoPublicacion();
                numPaginas = libro.getNumPaginas();
                idioma = libro.getIdioma();

                nombresAutores = new ArrayList<>();
                codAutores = (manejadorDao.getCodigosAutoresLibro(isbn));
                for(int cod: codAutores)
                {
                    nombresAutores.add(manejadorDao.consultarAutor(cod).toString());
                }
                autores = String.join(", ", nombresAutores);

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getLibroAdminTableModel();
                auxModeloTabla.addRow(new Object[]{isbn, titulo, autores, nomEditorial, anhoPublicacion, idioma, numPaginas});
            }
        }
    }

    public boolean comprobarCamposLibroA()
    {
        boolean valido;
        valido = !ventanaBiblioteca.getTxtIsbnLibroA().isEmpty() && !ventanaBiblioteca.getTxtTituloLibroA().isEmpty() && !ventanaBiblioteca.getTxtEditorialLibroA().isEmpty() && !ventanaBiblioteca.getTxtNumPaginasLibroA().isEmpty() && !ventanaBiblioteca.getTxtIdiomaLibroA().isEmpty();
        return valido;
    }

    public void listarLibroTablaAdAgregar(Libro libro)
    {
        if(libro != null)
        {
            String isbn;
            String titulo;
            int codEditorial;
            String nomEditorial;
            int anhoPublicacion;
            String numPaginas;
            String idioma;

            isbn = libro.getIsbn();
            titulo = libro.getTitulo();
            codEditorial = libro.getCodEditorial();
            nomEditorial = manejadorDao.buscarEditorial(codEditorial).getNomEditorial();
            anhoPublicacion = libro.getAnhoPublicacion();
            numPaginas = libro.getNumPaginas();
            idioma = libro.getIdioma();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEditorialAdminTableModel();
            auxModeloTabla.addRow(new Object[]{isbn, titulo, nomEditorial, anhoPublicacion, numPaginas, idioma});
        }
    }

    public void agregarLibro()
    {
        Libro libro;
        String isbn;
        String titulo;
        int codEditorial;
        int anhoPublicacion;
        String numPaginas;
        String idioma;

        isbn = ventanaBiblioteca.getTxtIsbnLibroA();
        titulo = ventanaBiblioteca.getTxtTituloLibroA();
        codEditorial = Integer.parseInt(ventanaBiblioteca.getTxtIdEditorialA());
        anhoPublicacion = ventanaBiblioteca.getJyAnoPublicLibroA();
        numPaginas = ventanaBiblioteca.getTxtNumPaginasLibroA();
        idioma = ventanaBiblioteca.getTxtIdiomaLibroA();

        if(comprobarCamposLibroA())
        {
            if (manejadorDao.buscarEditorial(codEditorial) != null)
            {
                libro = new Libro(isbn, titulo, codEditorial, anhoPublicacion, numPaginas, idioma);

                if (anhoPublicacion < 2024)
                {
                    if (manejadorDao.agregarLibro(libro) > 0)
                    {
                        listarLibroTablaAdAgregar(libro);
                        ventanaBiblioteca.mostrarMensaje("Libro agregado con exito");
                        ventanaBiblioteca.limpiarLibroAdmin();
                    }
                    else
                    {
                        ventanaBiblioteca.mostrarMensajeError("No se pudo crear el libro");
                    }
                }
                else
                {
                    ventanaBiblioteca.mostrarMensajeError("Digite una fecha correcta");
                }
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("No se encuentra una editorial con ese id");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Llene todos los campos");
        }
    }

    public void listarLibroTabAdEditar(Libro libro){
        if(libro != null)
        {
            String isbn;
            String titulo;
            int codEditorial;
            int anhoPublicacion;
            String numPaginas;
            String idioma;

            isbn = libro.getIsbn();
            titulo = libro.getTitulo();
            codEditorial = libro.getCodEditorial();
            anhoPublicacion = libro.getAnhoPublicacion();
            numPaginas = libro.getNumPaginas();
            idioma = libro.getIdioma();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getLibroAdminTableModel();
            int auxFila = ventanaBiblioteca.getFilaSeleccionadaLibroAd();

            auxModeloTabla.setValueAt(isbn, auxFila, 1);
            auxModeloTabla.setValueAt(titulo, auxFila, 2);
            auxModeloTabla.setValueAt(codEditorial, auxFila, 3);
            auxModeloTabla.setValueAt(anhoPublicacion, auxFila, 4);
            auxModeloTabla.setValueAt(numPaginas, auxFila, 5);
            auxModeloTabla.setValueAt(idioma, auxFila, 6);
        }
    }

    public void editarLibro()
    {
        Libro libro;
        String isbn;
        int anhoPublicacion;


        isbn = ventanaBiblioteca.getTxtIsbnLibroA();
        libro = manejadorDao.buscarLibroIsbn(isbn);

        if(libro != null)
        {
            libro.setTitulo(ventanaBiblioteca.getTxtTituloLibroA());
            libro.setCodEditorial(Integer.parseInt(ventanaBiblioteca.getTxtIdEditorialA()));
            libro.setAnhoPublicacion(ventanaBiblioteca.getJyAnoPublicLibroA());
            libro.setNumPaginas(ventanaBiblioteca.getTxtNumPaginasLibroA());
            libro.setIdioma(ventanaBiblioteca.getTxtIdiomaLibroA());

            if(comprobarCamposLibroA())
            {
                if (manejadorDao.buscarEditorial(libro.getCodEditorial()) != null)
                {
                    anhoPublicacion = ventanaBiblioteca.getJyAnoPublicLibroA();

                    if (anhoPublicacion < 2024)
                    {
                        if (manejadorDao.editarLibro(libro))
                        {
                            ventanaBiblioteca.mostrarMensaje("Libro editado con exito");
                            listarLibroTabAdEditar(libro);
                            ventanaBiblioteca.deseleccionarFilaTablaLibroAd();
                            ventanaBiblioteca.limpiarLibroAdmin();
                        }
                        else
                        {
                            ventanaBiblioteca.mostrarMensajeError("No se pudo editar el libro");
                        }
                    }
                    else
                    {
                        ventanaBiblioteca.mostrarMensajeError("Digite una fecha correcta");
                    }
                }
                else
                {
                    ventanaBiblioteca.mostrarMensajeError("Llene todos los campos");
                }
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("No se encuentra una editorial con ese id");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Ocurrio un error");
        }
    }

    public void listarLibroTablaAdEliminar(Libro libro)
    {
        DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getLibroAdminTableModel();
        int auxFila = ventanaBiblioteca.getFilaSeleccionadaLibroAd();
        auxModeloTabla.removeRow(auxFila);
    }

    public void eliminarLibro()
    {
        String isbn = ventanaBiblioteca.getTxtIsbnLibroA();
        Libro libro = manejadorDao.buscarLibroIsbn(isbn);

        if (libro != null)
        {
            if (manejadorDao.eliminarLibro(isbn))
            {
                ventanaBiblioteca.mostrarMensaje("Libro eliminado");
                ventanaBiblioteca.limpiarLibroAdmin();
                listarLibroTablaAdEliminar(libro);
                ventanaBiblioteca.deseleccionarFilaTablaLibroAd();
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("No se pudo realizar la acción");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("No se encontró el libro");
        }
    }

    /**************************************************************************
     Controlador_Ejemplar
     * Ejemplar - admin
     *************************************************************************/

    class EjemplarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("agregar"))
            {
                agregarEjemplar();
            }
            if (e.getActionCommand().equalsIgnoreCase("modificar"))
            {
                editarEjemplar();
            }
            if (e.getActionCommand().equalsIgnoreCase("eliminar"))
            {
                eliminarEjemplar();
            }
        }
    }

    public void listarEjemplarTablaAd()
    {
        ArrayList<Ejemplar> arrayEjemplar;
        arrayEjemplar = manejadorDao.listarEjemplares();
        if(arrayEjemplar != null)
        {
            String isbn;
            int numEjemplar;
            int estante;
            int numCajon;
            String nomSala;
            int numPasillo;

            for (Ejemplar ejemplar : arrayEjemplar) {
                isbn = ejemplar.getIsbn();
                numEjemplar = ejemplar.getNumEjemplar();
                estante = ejemplar.getEstante();
                numCajon = ejemplar.getNumCajon();
                nomSala = ejemplar.getNomSala();
                numPasillo = ejemplar.getNumPasillo();

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEjemplarAdminTableModel();
                auxModeloTabla.addRow(new Object[]{numEjemplar, isbn, estante, numCajon, nomSala, numPasillo});
            }
        }
    }
    public boolean comprobarCamposEjemplarAd()
    {
        boolean valido;
        valido = !ventanaBiblioteca.getTxtIsbnEjemplarA().isEmpty() && !ventanaBiblioteca.getTxtEstanteEjemplarA().isEmpty() && !ventanaBiblioteca.getTxtNumCajonEjemplarA().isEmpty() && !ventanaBiblioteca.getTxtNomSalaEjemplarA().isEmpty() && !ventanaBiblioteca.getTxtNumPasilloEjemplarA().isEmpty();
        return valido;
    }

    public void listarEjemplarTablaAdAgregar(Ejemplar ejemplar)
    {
        if(ejemplar != null)
        {
            String isbn;
            int numEjemplar;
            int estante;
            int numCajon;
            String nomSala;
            int numPasillo;

            isbn = ejemplar.getIsbn();
            numEjemplar = ejemplar.getNumEjemplar();
            estante = ejemplar.getEstante();
            numCajon = ejemplar.getNumCajon();
            nomSala = ejemplar.getNomSala();
            numPasillo = ejemplar.getNumPasillo();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEjemplarAdminTableModel();
            auxModeloTabla.addRow(new Object[]{numEjemplar, isbn, estante, numCajon, nomSala, numPasillo});
        }
    }

    public void agregarEjemplar()
    {
        Ejemplar ejemplar;
        String isbn;
        int numEjemplar;
        int estante;
        int numCajon;
        String nomSala;
        int numPasillo;

        numEjemplar = Integer.parseInt(ventanaBiblioteca.getTxtNumEjemplarA());

        if(numEjemplar == 0)
        {
            if (comprobarCamposEjemplarAd())
            {
                isbn = ventanaBiblioteca.getTxtIsbnEjemplarA();
                estante = Integer.parseInt(ventanaBiblioteca.getTxtEstanteEjemplarA());
                numCajon = Integer.parseInt(ventanaBiblioteca.getTxtNumCajonEjemplarA());
                nomSala = ventanaBiblioteca.getTxtNomSalaEjemplarA();
                numPasillo = Integer.parseInt(ventanaBiblioteca.getTxtNumPasilloEjemplarA());

                if (manejadorDao.buscarLibroIsbn(isbn) != null)
                {
                    ejemplar = new Ejemplar(isbn, estante, numCajon, nomSala, numPasillo);

                    if (manejadorDao.agregarEjemplar(ejemplar) > 0)
                    {
                        listarEjemplarTablaAdAgregar(ejemplar);
                        ventanaBiblioteca.mostrarMensaje("Ejemplar agregado con exito");
                        ventanaBiblioteca.limpiarEjemplarAdmin();
                    }
                    else
                    {
                        ventanaBiblioteca.mostrarMensajeError("No se pudo crear el ejemplar");
                    }
                }
                else
                {
                    ventanaBiblioteca.mostrarMensajeError("No existe un libro con ese ISBN");
                }
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("Llene todos los campos");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Deseleccione el ejemplar");
        }
    }

    public void listarEjemplarTabAdEditar(Ejemplar ejemplar)
    {
        if(ejemplar != null)
        {
            String isbn;
            int numEjemplar;
            int estante;
            int numCajon;
            String nomSala;
            int numPasillo;

            isbn = ejemplar.getIsbn();
            numEjemplar = ejemplar.getNumEjemplar();
            estante = ejemplar.getEstante();
            numCajon = ejemplar.getNumCajon();
            nomSala = ejemplar.getNomSala();
            numPasillo = ejemplar.getNumPasillo();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEjemplarAdminTableModel();
            int auxFila = ventanaBiblioteca.getFilaSeleccionadaEjemplarAd();

            auxModeloTabla.setValueAt(numEjemplar, auxFila, 0);
            auxModeloTabla.setValueAt(isbn, auxFila, 1);
            auxModeloTabla.setValueAt(estante, auxFila, 2);
            auxModeloTabla.setValueAt(numCajon, auxFila, 3);
            auxModeloTabla.setValueAt(nomSala, auxFila, 4);
            auxModeloTabla.setValueAt(numPasillo, auxFila, 5);
        }
    }

    public void editarEjemplar()
    {
        Ejemplar ejemplar;
        String isbn;
        int numEjemplar;

        isbn = ventanaBiblioteca.getTxtIsbnEjemplarA();
        numEjemplar = Integer.parseInt(ventanaBiblioteca.getTxtNumEjemplarA());
        ejemplar = manejadorDao.buscarEjemplar(isbn, numEjemplar);

        if(ejemplar != null)
        {
            if(comprobarCamposEjemplarAd())
            {
                ejemplar.setEstante(Integer.parseInt(ventanaBiblioteca.getTxtEstanteEjemplarA()));
                ejemplar.setNumCajon(Integer.parseInt(ventanaBiblioteca.getTxtNumCajonEjemplarA()));
                ejemplar.setNomSala(ventanaBiblioteca.getTxtNomSalaEjemplarA());
                ejemplar.setNumPasillo(Integer.parseInt(ventanaBiblioteca.getTxtNumPasilloEjemplarA()));

                if(manejadorDao.buscarLibroIsbn(ejemplar.getIsbn()) != null)
                {
                    if (manejadorDao.editarEjemplar(ejemplar))
                    {
                        ventanaBiblioteca.mostrarMensaje("Ejemplar editado con exito");
                        listarEjemplarTabAdEditar(ejemplar);
                        ventanaBiblioteca.deseleccionarTablaFilaEjemplarAd();
                        ventanaBiblioteca.limpiarEjemplarAdmin();
                    }
                    else
                    {
                        ventanaBiblioteca.mostrarMensajeError("No se pudo editar el ejemplar");
                    }
                }
                else
                {
                    ventanaBiblioteca.mostrarMensajeError("No existe un libro con ese ISBN");
                }
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("Llene todos los campos");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Ocurrio un error");
        }
    }

    public void listarEjemplarTablaAdEliminar(Ejemplar ejemplar)
    {
        DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getEjemplarAdminTableModel();
        int auxFila = ventanaBiblioteca.getFilaSeleccionadaEjemplarAd();
        auxModeloTabla.removeRow(auxFila);
    }

    public void eliminarEjemplar()
    {
        Ejemplar ejemplar;
        String isbn;
        int numEjemplar;

        isbn = ventanaBiblioteca.getTxtIsbnEjemplarA();
        numEjemplar = Integer.parseInt(ventanaBiblioteca.getTxtNumEjemplarA());
        ejemplar = manejadorDao.buscarEjemplar(isbn, numEjemplar);

        if (ejemplar != null)
        {
            if (manejadorDao.eliminarEjemplar(isbn, numEjemplar))
            {
                ventanaBiblioteca.mostrarMensaje("Ejemplar eliminado");
                ventanaBiblioteca.limpiarEjemplarAdmin();
                listarEjemplarTablaAdEliminar(ejemplar);
                ventanaBiblioteca.deseleccionarTablaFilaEjemplarAd();
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("No se pudo realizar la acción");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("No se encontró el ejemplar");
        }
    }

    /**************************************************************************
     Controlador_Digital
     * Digital - admin
     *************************************************************************/

    class DigitalListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("agregar"))
            {
                agregarDigital();
            }
            if (e.getActionCommand().equalsIgnoreCase("modificar"))
            {
                editarDigital();
            }
            if (e.getActionCommand().equalsIgnoreCase("eliminar"))
            {
                eliminarDigital();
            }
        }
    }

    public void listarDigitalTablaAd()
    {
        ArrayList<Digital> arrayDigital;
        arrayDigital = manejadorDao.listarDigitales();
        if(arrayDigital != null)
        {
            int numDigital;
            String isbn;
            String url;
            String formato;
            String bytes;

            for (Digital digital : arrayDigital) {
                numDigital = digital.getNumDigital();
                isbn = digital.getIsbn();
                url = digital.getUrl();
                formato = digital.getFormato();
                bytes = digital.getBytes();

                DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getDigitalAdminTableModel();
                auxModeloTabla.addRow(new Object[]{numDigital, isbn, url, formato, bytes});
            }
        }
    }
    public boolean comprobarCamposDigitalAd()
    {
        boolean valido;
        valido = !ventanaBiblioteca.getTxtIsbnDigitalA().isEmpty() && !ventanaBiblioteca.getTxtUrlDigitalA().isEmpty() && !ventanaBiblioteca.getTxtFormatoDigitalA().isEmpty() && !ventanaBiblioteca.getTxtBytesDigitalA().isEmpty();
        return valido;
    }

    public void listarDigitalTablaAdAgregar(Digital digital)
    {
        if(digital != null)
        {
            int numDigital;
            String isbn;
            String url;
            String formato;
            String bytes;

            numDigital = digital.getNumDigital();
            isbn = digital.getIsbn();
            url = digital.getUrl();
            formato = digital.getFormato();
            bytes = digital.getBytes();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getDigitalAdminTableModel();
            auxModeloTabla.addRow(new Object[]{numDigital, isbn, url, formato, bytes});
        }
    }

    public void agregarDigital()
    {
        Digital digital;
        int numDigital;
        String isbn;
        String url;
        String formato;
        String bytes;

        numDigital = Integer.parseInt(ventanaBiblioteca.getTxtNumDigitalA());

        if(numDigital == 0)
        {
            if (comprobarCamposDigitalAd())
            {
                isbn = ventanaBiblioteca.getTxtIsbnDigitalA();
                url = ventanaBiblioteca.getTxtUrlDigitalA();
                formato = ventanaBiblioteca.getTxtFormatoDigitalA();
                bytes = ventanaBiblioteca.getTxtBytesDigitalA();

                if (manejadorDao.buscarLibroIsbn(isbn) != null)
                {
                    digital = new Digital(isbn, url, formato, bytes);

                    if (manejadorDao.agregarDigital(digital) > 0)
                    {
                        listarDigitalTablaAdAgregar(digital);
                        ventanaBiblioteca.mostrarMensaje("Libro digital agregado con exito");
                        ventanaBiblioteca.limpiarDigitalAdmin();
                    }
                    else
                    {
                        ventanaBiblioteca.mostrarMensajeError("No se pudo crear el libro digital");
                    }
                }
                else
                {
                    ventanaBiblioteca.mostrarMensajeError("No existe un libro con ese ISBN");
                }
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("Llene todos los campos");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Deseleccione el libro digital");
        }
    }

    public void listarDigitalTabAdEditar(Digital digital)
    {
        if(digital != null) {
            int numDigital;
            String isbn;
            String url;
            String formato;
            String bytes;

            numDigital = digital.getNumDigital();
            isbn = digital.getIsbn();
            url = digital.getUrl();
            formato = digital.getFormato();
            bytes = digital.getBytes();

            DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getDigitalAdminTableModel();
            int auxFila = ventanaBiblioteca.getFilaSeleccionadaDigitalAd();

            auxModeloTabla.setValueAt(numDigital, auxFila, 0);
            auxModeloTabla.setValueAt(isbn, auxFila, 1);
            auxModeloTabla.setValueAt(url, auxFila, 2);
            auxModeloTabla.setValueAt(formato, auxFila, 3);
            auxModeloTabla.setValueAt(bytes, auxFila, 4);
        }
    }

    public void editarDigital()
    {
        Digital digital;
        String isbn;
        String url;

        isbn = ventanaBiblioteca.getTxtIsbnDigitalA();
        url = ventanaBiblioteca.getTxtUrlDigitalA();
        digital = manejadorDao.buscarDigital(isbn, url);

        if(digital != null)
        {
            if(comprobarCamposDigitalAd())
            {
                digital.setFormato(ventanaBiblioteca.getTxtFormatoDigitalA());
                digital.setBytes(ventanaBiblioteca.getTxtBytesDigitalA());

                if(manejadorDao.buscarLibroIsbn(digital.getIsbn()) != null)
                {
                    if (manejadorDao.editarDigital(digital))
                    {
                        ventanaBiblioteca.mostrarMensaje("Libro digital editado con exito");
                        listarDigitalTabAdEditar(digital);
                        ventanaBiblioteca.deseleccionarFilaTablaDigitalAd();
                        ventanaBiblioteca.limpiarDigitalAdmin();
                    }
                    else
                    {
                        ventanaBiblioteca.mostrarMensajeError("No se pudo editar el libro digital");
                    }
                }
                else
                {
                    ventanaBiblioteca.mostrarMensajeError("No existe un libro con ese ISBN");
                }
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("Llene todos los campos");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("Ocurrio un error");
        }
    }

    public void listarDigitalTablaAdEliminar(Digital digital)
    {
        DefaultTableModel auxModeloTabla = (DefaultTableModel) ventanaBiblioteca.getDigitalAdminTableModel();
        int auxFila = ventanaBiblioteca.getFilaSeleccionadaDigitalAd();
        auxModeloTabla.removeRow(auxFila);
    }

    public void eliminarDigital()
    {
        Digital digital;
        String isbn;
        String url;

        isbn = ventanaBiblioteca.getTxtIsbnDigitalA();
        url = ventanaBiblioteca.getTxtUrlDigitalA();
        digital = manejadorDao.buscarDigital(isbn, url);

        if (digital != null)
        {
            if (manejadorDao.eliminarDigital(isbn, url))
            {
                ventanaBiblioteca.mostrarMensaje("Libro digital eliminado");
                ventanaBiblioteca.limpiarDigitalAdmin();
                listarDigitalTablaAdEliminar(digital);
                ventanaBiblioteca.deseleccionarFilaTablaDigitalAd();
            }
            else
            {
                ventanaBiblioteca.mostrarMensajeError("No se pudo realizar la acción");
            }
        }
        else
        {
            ventanaBiblioteca.mostrarMensajeError("No se encontró el libro digital");
        }
    }
}
