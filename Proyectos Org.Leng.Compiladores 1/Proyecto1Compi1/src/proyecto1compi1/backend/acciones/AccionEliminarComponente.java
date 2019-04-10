/*
 * Accion Eliminar Componente
 */
package proyecto1compi1.backend.acciones;

/**
 *
 * @author bryan
 */
public class AccionEliminarComponente extends Accion{
        
        private String idPagina;

        public AccionEliminarComponente(String idPagina, String id) {
            super(id);
            this.idPagina = idPagina;
        }

        public AccionEliminarComponente() {
        
        }
        
        @Override
        public void ejecutarAciion() {
                System.out.println("Se eliminara un nuevo Componente.......");
                System.out.println("ID: "+id);
                System.out.println("ID_PAGINA: "+idPagina);
             
        }

        public String getIdPagina() {
            return idPagina;
        }

        public void setIdPagina(String idPagina) {
            this.idPagina = idPagina;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        
        
    
}
