/*
 * Clase Sitio
 */
package proyecto1compi1.backend.sitios;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author bryan
 */
public class Sitio {
        private String id;
        private String path;
        private String usuarioCreacion;
        private LocalDate fechaCreacion;
        private LocalDate fechaModificacion;
        private String usuarioModificacion;
        private List<Pagina> listaPaginas;

        public Sitio(String id, String path, String usuarioCreacion, LocalDate fechaCreacion, LocalDate fechaModificacion, String usuarioModificacion, List<Pagina> listaPaginas) {
            this.id = id;
            this.path = path;
            this.usuarioCreacion = usuarioCreacion;
            this.fechaCreacion = fechaCreacion;
            this.fechaModificacion = fechaModificacion;
            this.usuarioModificacion = usuarioModificacion;
            this.listaPaginas = listaPaginas;
        }

        public Sitio() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getUsuarioCreacion() {
            return usuarioCreacion;
        }

        public void setUsuarioCreacion(String usuarioCreacion) {
            this.usuarioCreacion = usuarioCreacion;
        }

        public LocalDate getFechaCreacion() {
            return fechaCreacion;
        }

        public void setFechaCreacion(LocalDate fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }

        public LocalDate getFechaModificacion() {
            return fechaModificacion;
        }

        public void setFechaModificacion(LocalDate fechaModificacion) {
            this.fechaModificacion = fechaModificacion;
        }

        public String getUsuarioModificacion() {
            return usuarioModificacion;
        }

        public void setUsuarioModificacion(String usuarioModificacion) {
            this.usuarioModificacion = usuarioModificacion;
        }

        public List<Pagina> getListaPaginas() {
            return listaPaginas;
        }

        public void setListaPaginas(List<Pagina> listaPaginas) {
            this.listaPaginas = listaPaginas;
        }

        
    
}
