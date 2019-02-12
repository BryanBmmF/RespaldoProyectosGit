/*
 * Clase encargada de validar usuarios
 */
package proyectofinal.fabrica.usuarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import proyectofinal.fabrica.archivo.Archivo;
import proyectofinal.interfaz.Escritorio;

/**
 *
 * @author bryan
 */
public class Validacion {
    private Archivo archivo;
    private Usuario userRecup;
    //private Usuario nuevoUsuario;
    private String user;
    private static final String rutaUser="src/usuarios/usuario";
    private static final String extenUser=".usr";
    private static final String admin="admin";
    private static final String passAdmin="87654321";
    //constructor por defecto
    public Validacion(){
        this.archivo= new Archivo();
        this.userRecup= new Usuario();
        
    }
    //constructor sobrecargado
    public Validacion(String user){
        this.user=user;
        
    }
    //metodo validador del usuario
    public boolean validar(String usuario, String pasword){
        //se verifica si ahun no existe el Usuario admin
        if(archivo.buscarExistente(rutaUser+admin+extenUser)==false){
            //se crea el usuario principal
            Usuario nuevoUsuario= new Usuario(admin, passAdmin, 3);
            nuevoUsuario.validar();
        
        }
        boolean validar= false;
            //se verifica si existe el User que se desea validar
            if(archivo.buscarExistente(rutaUser+usuario+extenUser)){        
                //si existe se verifica el pasword se llama al objeto
                File archivoLeer= new File(rutaUser+usuario+extenUser);
                    //se intenta crear el flujo de entrada para la lectura
                    try(FileInputStream fileStream= new FileInputStream(archivoLeer);
                        ObjectInputStream inputObject = new ObjectInputStream(fileStream);){
                         //se castea el objeto leido
                         userRecup=(Usuario)inputObject.readObject();
                         
                            if(pasword.equals(userRecup.getPasword())){                                
                                validar=true;// el pasword coincide con el del usuario guardado    
                                //se habilita el escritorio segun el tipo de usuario
                                habilitarEscritorio(userRecup.getTipo(),usuario);
                            }
                            else{
                                // mensage de error en la contraseña
                                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
                            }
                    //se capturan las Excepciones                   
                    }catch(IOException e){
                        System.out.println("Error de conexion con el archivo");
                        e.printStackTrace();
                            
                    }catch(ClassNotFoundException e){
                        System.out.println("El objeto no tiene la forma requerida");
                                
                    }
                
        
            }
            else{
                // mensage de error en los datos ingresados
                JOptionPane.showMessageDialog(null, "Usuario invalido");
            }

        return validar;
    }
    
    //metodo habilitador de escritorio
    public void habilitarEscritorio(int tipo,String user){
        
        //mostrando el Escritorio principal  segun tipo de usuario
         Escritorio escritorio = new Escritorio();
         
         switch(tipo){
         
             case 1:{
                 escritorio.paraFabrica(user);
                 break;
             }
             case 2:{
                 escritorio.paraVentas(user);
                 break;
             }
             default:{
                 escritorio.paraAdmon(user);
             }
         }
         escritorio.setVisible(true);
         
         
    
    }
    
    
}
