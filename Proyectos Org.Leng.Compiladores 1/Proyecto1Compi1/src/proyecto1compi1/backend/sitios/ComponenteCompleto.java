/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1compi1.backend.sitios;

import proyecto1compi1.backend.Componentes.Componente;

/**
 *
 * @author bryan
 */
public class ComponenteCompleto {
        private String id;
        private String idPagina;
        private Componente claseComponente;

        public ComponenteCompleto(String id, String idPagina, Componente claseComponente) {
            this.id = id;
            this.idPagina = idPagina;
            this.claseComponente = claseComponente;
        }

        public ComponenteCompleto() {
        }
        
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
        
        
    
}
