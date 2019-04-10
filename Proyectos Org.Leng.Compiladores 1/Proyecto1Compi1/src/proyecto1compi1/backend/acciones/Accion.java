/*
 * Clase Abstracta Accion
 */
package proyecto1compi1.backend.acciones;

/**
 *
 * @author bryan
 */
public abstract class Accion {
        public static final int PUERTO=5000;
        //id de la pagina o sitio donde se ejecuta la accion
        String id;

        public Accion(String id) {
            this.id = id;
        }

        public Accion() {
        }
        
        //metodo abstracto ejecutar accion
        public abstract void ejecutarAciion();
        
    
}
