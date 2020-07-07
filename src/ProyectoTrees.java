

import java.io.*;
import java.util.*;

public class ProyectoTrees {
    static HashTable H = new HashTable();
    
    public static void leerUsuarios(){
        //Crear documentos leyendo el archivo txt y meterlos a la lista
        File fichero = new File("usuarios.txt");
        Scanner s = null;
        try {
            s = new Scanner(fichero);

            while (s.hasNextLine()) {
                String datos=s.nextLine();
                String [] partes = datos.split("-");
                User usuario = new User(partes[0], partes[1], partes[2], partes[3]);
                H.insert(usuario);
                System.out.println(H.HashFunction(partes[0]));
            }
        } catch (Exception ex) {
                System.out.println( ex.getMessage());
        } finally {
            try {
                if (s != null)
                    s.close();
            } catch (Exception ex2) {
                System.out.println(ex2.getMessage());
            }
        }
    }
    
    
    public static void main(String[] args) {
        leerUsuarios();
        Login login1 = new Login();
        login1.setVisible(true);
        
        
    }
}
