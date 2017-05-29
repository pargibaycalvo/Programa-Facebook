/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookjava;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Estructura interna del programa Facebook con NetBeans
 * @author ped90
 */
public class Seguridad {
    public Facebook facebook;
    ResponseList<Post> results;
    /**
     * Introducion de las claves de tu cuenta de Facebook para poder usar este programa.
     * Más los permisos necesarios.
     * Las claves van dentro de las comillas donde están los asteríscos.
     */
    public void clave(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthAppId("***")
            .setOAuthAppSecret("***")
            .setOAuthAccessToken("***")
            .setOAuthPermissions("email,publish_stream,publish_actions,user_photos,user_likes,user_posts");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
        
    }
    /**
     * Publica el estado que tu elijas en tu cuenta de facebook mediante el menú.
     * @param postId 
     */
    public void publicarEstado(String postId){
        try {
            facebook.postStatusMessage(postId);
        } catch (FacebookException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Asignas un me gusta a una publicación tuya asigandole la posición en la que está la publicación.
     * NOTA: Esta funcion esta deshabilitada temporalmente por Facebook
     */
    public void megustaPost(){
        try {
            facebook.likePost(results.get(1).getId());
        } catch (FacebookException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Subir una imagen a tu perfil con la URL de la página que tiene asiganda esa imagen.
     * @throws java.net.MalformedURLException
     */
    public void publicarURLconImagen() throws MalformedURLException{
        try {
            PostUpdate post = new PostUpdate(new URL("https://www.wired.com"))
                    .picture(new URL("https://www.wired.com/wp-content/uploads/2014/07/breakingbad-ft.jpg"))
                    .name("Walter")
                    .caption("wired.com")
                    .description("Breaking Bad");
            facebook.postFeed(post);
        } catch (FacebookException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Buscador de noticias en Facebook relacionada con la palabra clave que tu elijas.
     * @throws FacebookException 
     */
    public void buscarNoticias() throws FacebookException{
        ResponseList<Post> results = facebook.getPosts("reebok");
        System.out.println(results.toString());
    }
    /**
     * Mirar tu biografía, si tienes algo nuevo que te han etiquetado, etc y sus comentarios.
     */
    public void mirarBiografia(){
        try {
            results = facebook.getFeed();
            System.out.println(results.toString());
        } catch (FacebookException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Publicar un comentario en una foto tuya seleccionando el ID.
     * ?fbid=1435360446539314 (este seria el ID de la foto).
     * Tiene que ser una foto tuya no vale la de otro usuario de Facebook.
     * @throws FacebookException 
     */
    public void publicarComentarioFoto() throws FacebookException{
        facebook.commentPhoto("1349349925140367", "Hola bonito buga");
        
    }
//    /**
//     * Publica un comentario en un estado tuyo seleccionando la posicion (puede ser estado, foto o video subido por ti).
//     * Tiene que ser un estado tuyo no vale uno de otra persona que te haya etiquetado.
//     */
//    
//    public void publicarComentarioEstado(){
//        try {
//            facebook.commentPost(results.get(1).getId(), "Prueba");
//        } catch (FacebookException ex) {
//            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    } 
    
}
