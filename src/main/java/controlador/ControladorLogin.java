package controlador;

import dao.DaoEstudiante;
import dao.DaoProfesor;
import modelo.Empleado;
import modelo.Estudiante;
import modelo.Profesor;
import vista.VentanaBiblioteca;
import vista.VentanaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ControladorLogin
{
    private final VentanaLogin ventanaLogin;
    private final DaoEstudiante daoEstudiante;
    private final DaoProfesor daoProfesor;
    private final String admin = "admin";

    public ControladorLogin(VentanaLogin auxA, DaoEstudiante auxB, DaoProfesor auxC)
    {
        this.ventanaLogin = auxA;
        this.daoEstudiante = auxB;
        this.daoProfesor = auxC;

        RegistroListener registroListener = new RegistroListener();
        ventanaLogin.addBtnRegistrarseAListener(registroListener);
        ventanaLogin.addBtnRegistrarseDListener(registroListener);

        LoginListener loginListener = new LoginListener();
        ventanaLogin.addBtnLoginListener(loginListener);

        ventanaLogin.pantallaCompleta();
    }

    private boolean comprobarRegistroEstudiante(ArrayList<String> formulario)
    {
        boolean camposValidos = true;
        if(!comprobarCedula(formulario.get(0)))
        {
            ventanaLogin.mostrarMensajeError("Ingrese una cedula valida");
            camposValidos = false;
        }
        else if(formulario.get(1).equals(""))
        {
            ventanaLogin.mostrarMensajeError("Ingrese un nombre valido");
            camposValidos = false;
        }
        else if(!comprobarCorreo(formulario.get(2)))
        {
            ventanaLogin.mostrarMensajeError("Ingrese un correo valido");
            camposValidos = false;
        }
        else if(formulario.get(3).equals(""))
        {
            ventanaLogin.mostrarMensajeError("Ingrese un clave valida");
            camposValidos = false;
        }
        else if(formulario.get(4).equals(""))
        {
            ventanaLogin.mostrarMensajeError("Ingrese una direccion valida");
            camposValidos = false;
        }
        else if(comprobarTelefono(formulario.get(5)))
        {
            ventanaLogin.mostrarMensajeError("Ingrese una telefono valido");
            camposValidos = false;
        }
        else if(formulario.get(6).equals(""))
        {
            ventanaLogin.mostrarMensajeError("Ingrese una carrera valida");
            camposValidos = false;
        }
        else if(formulario.get(7).equals(""))
        {
            ventanaLogin.mostrarMensajeError("Ingrese una universidad valida");
            camposValidos = false;
        }

        return camposValidos;
    }

    private void agregarEstudiante()
    {
        Estudiante auxEstudiante;

        String auxCedula;
        String auxNombre;
        String auxCorreo;
        String auxClave;
        String auxDireccion;
        String auxTelefono;
        String auxCarrera;
        String auxUniversidad;

        ArrayList<String> formularioRegistroE = ventanaLogin.getFormularioEstudiante();

        if(comprobarRegistroEstudiante(formularioRegistroE))
        {
            try
            {
                auxCedula = formularioRegistroE.get(0);
                auxNombre = formularioRegistroE.get(1);
                auxCorreo = formularioRegistroE.get(2);
                auxClave = formularioRegistroE.get(3);
                auxDireccion = formularioRegistroE.get(4);
                auxTelefono = formularioRegistroE.get(5);
                auxCarrera = formularioRegistroE.get(6);
                auxUniversidad = formularioRegistroE.get(7);

                auxEstudiante = new Estudiante(auxCedula, auxNombre, auxCorreo, auxClave, auxDireccion, auxTelefono, auxCarrera, auxUniversidad);

                if(daoEstudiante.insertEstudiante(auxEstudiante) != -1)
                {
                    ventanaLogin.mostrarMensaje("Registro realizado con exito");
                }
                else
                {
                    ventanaLogin.mostrarMensajeError("Registro realizado sin exito");
                }
                ventanaLogin.limpiarRegistroA();
            }
            catch (Exception e)
            {
                ventanaLogin.mostrarMensajeError("Ha ocurrido un error. Comuniquese con atencion al cliente");
            }
        }

    }

    private boolean comprobarRegistroProfesor(ArrayList<String> formulario)
    {
        boolean camposValidos = true;
        if(!comprobarCedula(formulario.get(0)))
        {
            ventanaLogin.mostrarMensajeError("Ingrese una cedula valida");
            camposValidos = false;
        }
        else if(formulario.get(1).equals(""))
        {
            ventanaLogin.mostrarMensajeError("Ingrese un nombre valido");
            camposValidos = false;
        }
        else if(!comprobarCorreo(formulario.get(2)))
        {
            ventanaLogin.mostrarMensajeError("Ingrese un correo valido");
            camposValidos = false;
        }
        else if(formulario.get(3).equals(""))
        {
            ventanaLogin.mostrarMensajeError("Ingrese un clave valida");
            camposValidos = false;
        }
        else if(formulario.get(4).equals(""))
        {
            ventanaLogin.mostrarMensajeError("Ingrese una direccion valida");
            camposValidos = false;
        }
        else if(comprobarTelefono(formulario.get(5)))
        {
            ventanaLogin.mostrarMensajeError("Ingrese un telefono valido");
            camposValidos = false;
        }
        else if(formulario.get(6).equals(""))
        {
            ventanaLogin.mostrarMensajeError("Ingrese un titulo valido");
            camposValidos = false;
        }
        else if(formulario.get(7).equals(""))
        {
            ventanaLogin.mostrarMensajeError("Ingrese una dependencia valida");
            camposValidos = false;
        }

        return camposValidos;
    }

    private void agregarProfesor()
    {
        Profesor auxProfesor;

        String auxCedula;
        String auxNombre;
        String auxCorreo;
        String auxClave;
        String auxDireccion;
        String auxTelefono;
        String auxTitulo;
        String auxDependencia;

        ArrayList<String> formularioRegistroP = ventanaLogin.getFormularioProfesor();

        if(comprobarRegistroProfesor(formularioRegistroP))
        {
            try
            {
                auxCedula = formularioRegistroP.get(0);
                auxNombre = formularioRegistroP.get(1);
                auxCorreo = formularioRegistroP.get(2);
                auxClave = formularioRegistroP.get(3);
                auxDireccion = formularioRegistroP.get(4);
                auxTelefono = formularioRegistroP.get(5);
                auxTitulo = formularioRegistroP.get(6);
                auxDependencia = formularioRegistroP.get(7);

                auxProfesor = new Profesor(auxCedula, auxNombre, auxCorreo, auxClave, auxDireccion, auxTelefono, auxTitulo, auxDependencia);

                if(daoProfesor.insertProfesor(auxProfesor) != -1)
                {
                    ventanaLogin.mostrarMensaje("Registro realizado con exito");
                }
                else
                {
                    ventanaLogin.mostrarMensajeError("Registro realizado sin exito");
                }
                ventanaLogin.limpiarRegistroD();
            }
            catch (Exception e)
            {
                ventanaLogin.mostrarMensajeError("Ha ocurrido un error. Comuniquese con atencion al cliente");
            }
        }

    }

    private void login()
    {
        Profesor auxProfesor = null;
        Estudiante auxEstudiante = null;
        Empleado auxEmpleado = null;

        String auxCorreo;
        String auxContrasena;

        ArrayList<String> formularioLogin = ventanaLogin.getFormularioLogin();

        auxCorreo = formularioLogin.get(0);
        auxContrasena = formularioLogin.get(1);

        if(!auxCorreo.equals(admin) && !auxContrasena.equals(admin))
        {
            auxProfesor = daoProfesor.consultarProfesorEmail(auxCorreo, auxContrasena);
            auxEstudiante = daoEstudiante.consultarEstudianteEmail(auxCorreo, auxContrasena);
            //auxEmpleado = daoEmpleado.consultarEmpleadoEmail(auxCorreo, auxContrasena);
        }

        System.out.println(auxEstudiante);
        System.out.println(auxProfesor);

        if(auxProfesor != null)
        {
            ventanaLogin.dispose();
            ControladorBiblioteca controladorBiblioteca = new ControladorBiblioteca(new VentanaBiblioteca(), auxProfesor);
        }
        else if(auxEstudiante != null)
        {
            ventanaLogin.dispose();
            ControladorBiblioteca controladorBiblioteca = new ControladorBiblioteca(new VentanaBiblioteca(), auxEstudiante);
        }
        /*else if(auxEmpleado != null)
        {
            ventanaLogin.dispose();
            ControladorBiblioteca controladorBiblioteca = new ControladorBiblioteca(new VentanaBiblioteca(), auxEmpleado);
        }*/
        else if(auxCorreo.equals(admin) && auxContrasena.equals(admin))
        {
            ventanaLogin.dispose();
            ControladorBiblioteca controladorBiblioteca = new ControladorBiblioteca(new VentanaBiblioteca(), null);
        }
        else
        {
            ventanaLogin.mostrarMensajeError("Correo o contaseña incorrectas");
        }
    }

    class RegistroListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("RegistrarseA"))
            {
                agregarEstudiante();
            }
            if (e.getActionCommand().equalsIgnoreCase("RegistrarseD"))
            {
                agregarProfesor();
            }
        }
    }

    private boolean comprobarCorreo(String email)
    {
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }

    private boolean comprobarTelefono(String telefono)
    {
        String regexPattern = "\\d+";
        return Pattern.compile(regexPattern).matcher(telefono).matches() && telefono.length() == 10;
    }

    private boolean comprobarCedula(String cedula)
    {
        String regexPattern = "\\d+";
        return Pattern.compile(regexPattern).matcher(cedula).matches();
    }

    class LoginListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("Login"))
            {
                login();
            }
        }
    }


}
