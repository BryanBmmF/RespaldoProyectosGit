/*
 * ModificarComponente
 */
package proyecto1compi1.backend.acciones;

import proyecto1compi1.backend.Componentes.Componente;

/**
 *
 * @author bryan
 */
public class AccionModificarComponente extends Accion{
        private String idPagina;
        private Componente claseComponente;

        public AccionModificarComponente(String idPagina, Componente claseComponente, String id) {
            super(id);
            this.idPagina = idPagina;
            this.claseComponente = claseComponente;
        }

        public AccionModificarComponente() {
        }
        
        
        @Override
        public void ejecutarAciion() {
                System.out.println("Se modificara un nuevo Componente.......");
                System.out.println("ID: "+id);
                System.out.println("ID_PAGINA: "+idPagina);
                claseComponente.construirComponente();
        }

        public String getIdPagina() {
            return idPagina;
        }

        public void setIdPagina(String idPagina) {
            this.idPagina = idPagina;
        }

        public Componente getClaseComponente() {
            return claseComponente;
        }

        public void setClaseComponente(Componente claseComponente) {
            this.claseComponente = claseComponente;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        
        
        
        
    
}
