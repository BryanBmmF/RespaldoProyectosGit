/*
 * clase Usuario que permite la creacion de un nuevo usuario del programa .
 */
package proyectofinal.fabrica.usuarios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import proyectofinal.fabrica.archivo.Archivo;
import proyectofinal.fabrica.archivo.Escritor;

/**
 *
 * @author bryan
 */
public class Usuario implements Serializable{
    
    //caracteristicas obligatorias de un user
    private String user;
    private String pasword;
    private int tipo;
    
    private ArrayList<String> revision;
    private Escritor escritor;
    
    //constructor de Usuario sobrecargado
    public Usuario(String user, String pasword, int tipo){
        this.user=user;
        this.pasword=pasword;
        this.tipo=tipo;
        
        this.escritor= new Escritor();
        this.revision= new ArrayList<String>();
    }
    //constructor de Usuario
    public Usuario(String nombreUser){
        this.user=nombreUser;
        
    }
    public Usuario(){

    }
    public void mostrarDatos(){
    
        System.out.println("\n"+user+"\n"+pasword+"\n"+tipo);
    }
    //metodo para validar un usuario
    public void validar(){
        //se crea la instancia de archivo user y se busca
        Archivo archivoUser= new Archivo();
            //verificando si existe o no el User
            if (archivoUser.buscarExistente("src/usuarios/usuario" + user + ".usr")) {
                revision.add("Error");
            } 
            else {
            //revision de errores en formato de parametros recibidos

            }
            //comprobando si existe un error en el User
            int errorUser= revision.indexOf("Error");
                if(errorUser>=0){
                    System.out.println("\n Usuario no procesado");
                    //se guarda la instruccion
                    escritor.escrituraLinea("Usuario no procesado porque "+user+" ya existe");
                }
                else{
                    System.out.println("Usuario procesado ");
                    //se genera
                    generarUser("src/usuarios/","usuario"+user,".usr");       
                }
            
    }
    //metodo generador de archivo de usuario nuevo
    public void generarUser(String ruta,String nombre,String exten){
        //metodo para generar Usuarios
        File file = new File(ruta+nombre+exten);
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
                    outputStream.writeObject(this);
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			e.printStackTrace();
		}
            //se guarda la instruccion
            escritor.escrituraLinea("Se ha creado el Usuario "+user+" de tipo "+tipo);
        
    }
    
    //metodos accesores Usuario

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
