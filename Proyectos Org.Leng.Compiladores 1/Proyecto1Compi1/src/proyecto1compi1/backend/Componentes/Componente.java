/*
 * Clase Componente
 */
package proyecto1compi1.backend.Componentes;

/**
 *
 * @author bryan
 */
public abstract class Componente {
        Componentes claseComponente;

        public Componente(Componentes claseComponente) {
            this.claseComponente = claseComponente;
        }

        public Componente() {
            
        }
        
       
        public abstract void construirComponente();
        public abstract Componentes devolverClaseComponente();
        public abstract String devolverEstructuraAtributos();
        public abstract String devolverEstructuraHTML();
        
        
}
