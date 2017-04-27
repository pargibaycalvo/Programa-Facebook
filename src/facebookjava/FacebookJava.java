/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookjava;

import facebook4j.FacebookException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;

/**
 * Menú para poder acceder a las funciones del programa
 * @author ped90
 */
public class FacebookJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FacebookException, MalformedURLException {
        // TODO code application logic here
         int opcion;
            Seguridad face = new Seguridad();
            do{
            opcion= Integer.parseInt(JOptionPane.showInputDialog("1) Publicar Estado. \n2) Me gusta. \n3) Obtener Noticias. \n4) Mirar mi Biografía. \n5) Comentario en Foto. \n6) Comentario en Estado. \n7) URL con Imagen. \n0) Salir del Programa."));
            switch(opcion){
            case 1:
                face.clave();
                face.publicarEstado(JOptionPane.showInputDialog("Estado a añadir: "));
                break;
            case 2:
                face.clave();
                face.megustaPost();
                break;
            case 3:
                face.clave();
                face.buscarNoticias();
                break;
            case 4:
                face.clave();
                face.mirarBiografia();
                break;
            case 5:
                face.clave();
                face.publicarComentarioFoto();
                break;
            case 6:
                face.clave();
                face.publicarComentarioEstado();
                break;
            case 7:
                face.clave();
                face.publicarURLconImagen();
                break;
            case 0:
                JOptionPane.showMessageDialog(null,"Pulse para salir");
                System.exit(0); 
                break;
            default:
                JOptionPane.showMessageDialog(null,"Error");
        }
    }while(opcion!=0);
    }
    
    
}
