/*
 * Accion Eliminar pagina
 */
package proyecto1compi1.backend.acciones;

/**
 *
 * @author bryan
 */
public class AccionEliminarPagina extends Accion{

        public AccionEliminarPagina(String id) {
            super(id);
        }

        public AccionEliminarPagina() {
            
        }
        
        @Override
        public void ejecutarAciion() {
            System.out.println("Se eliminara la pagina......");
            System.out.println("ID: "+id);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        
}
