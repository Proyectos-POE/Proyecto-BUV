package modelo;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Archivo
{
    private File archivo;

    public Archivo(File auxNombre)
    {
        String home = System.getProperty("user.home");
        this.archivo = new File(home + "/Downloads/" + auxNombre + ".pdf");
    }

    public boolean descargarArchivo(String auxUrl)
    {
        System.out.println("opening connection");
        try {
            URL url = new URL(auxUrl);
            InputStream in = url.openStream();
            FileOutputStream fos = new FileOutputStream(archivo);

            System.out.println("reading from resource and writing to file...");
            int length = -1;
            byte[] buffer = new byte[1024];// buffer for portion of data from connection
            while ((length = in.read(buffer)) > -1) {
                fos.write(buffer, 0, length);
            }
            fos.close();
            in.close();
            System.out.println("File downloaded");
            return true;
        } catch (MalformedURLException e) {
            System.out.println(e);
            return false;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return false;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }

    }
}
