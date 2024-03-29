/*
 * Clase Pagina
 */
package proyecto1compi1.backend.sitios;

import java.time.LocalDate;
import java.util.List;
import proyecto1compi1.backend.Componentes.Componente;
import proyecto1compi1.backend.etiquetas.Etiqueta;

/**
 *
 * @author bryan
 */
public class Pagina {
        private String id;
        private String path;
        private String titulo;
        private String idSitio;
        private String idPaginaPadre;
        private String usuarioCreacion;
        private LocalDate fechaCreacion;
        private LocalDate fechaModificacion;
        private String usuarioModificacion;
        //lista de etiquetas puede ser un array list de etiquetas
        private List<Etiqueta> listaEtiquetas;
        private List<ComponenteCompleto>  listaComponentes;
        private List<String> listaPagHijas;

        public Pagina(String id, String path, String titulo, String idSitio, String idPaginaPadre, String usuarioCreacion, LocalDate fechaCreacion, LocalDate fechaModificacion, String usuarioModificacion, List<Etiqueta> listaEtiquetas, List<ComponenteCompleto> listaComponentes, List<String> listaPagHijas) {
            this.id = id;
            this.path = path;
            this.titulo = titulo;
            this.idSitio = idSitio;
            this.idPaginaPadre = idPaginaPadre;
            this.usuarioCreacion = usuarioCreacion;
            this.fechaCreacion = fechaCreacion;
            this.fechaModificacion = fechaModificacion;
            this.usuarioModificacion = usuarioModificacion;
            this.listaEtiquetas = listaEtiquetas;
            this.listaComponentes = listaComponentes;
            this.listaPagHijas = listaPagHijas;
        }

        public Pagina() {
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

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getIdSitio() {
            return idSitio;
        }

        public void setIdSitio(String idSitio) {
            this.idSitio = idSitio;
        }

        public String getIdPaginaPadre() {
            return idPaginaPadre;
        }

        public void setIdPaginaPadre(String idPaginaPadre) {
            this.idPaginaPadre = idPaginaPadre;
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

        public List<Etiqueta> getListaEtiquetas() {
            return listaEtiquetas;
        }

        public void setListaEtiquetas(List<Etiqueta> listaEtiquetas) {
            this.listaEtiquetas = listaEtiquetas;
        }

        public List<ComponenteCompleto> getListaComponentes() {
            return listaComponentes;
        }

        public void setListaComponentes(List<ComponenteCompleto> listaComponentes) {
            this.listaComponentes = listaComponentes;
        }

        public List<String> getListaPagHijas() {
            return listaPagHijas;
        }

        public void setListaPagHijas(List<String> listaPagHijas) {
            this.listaPagHijas = listaPagHijas;
        }

        
        
        
        
    
}
