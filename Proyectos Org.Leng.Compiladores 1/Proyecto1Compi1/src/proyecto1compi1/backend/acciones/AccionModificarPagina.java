/*
 * Accion modificar Pagina
 */
package proyecto1compi1.backend.acciones;

import java.time.LocalDate;
import java.util.List;
import proyecto1compi1.backend.etiquetas.Etiqueta;

/**
 *
 * @author bryan
 */
public class AccionModificarPagina extends Accion{
    
        private String titulo;
        private String idSitio;
        private String idPaginaPadre;
        private String usuarioCreacion;
        private LocalDate fechaCreacion;
        private LocalDate fechaModificacion;
        private String usuarioModificacion;
        //lista de etiquetas puede ser un array list de etiquetas
        private List<Etiqueta> listaEtiquetas;

        public AccionModificarPagina(String titulo, String idSitio, String idPaginaPadre, String usuarioCreacion, LocalDate fechaCreacion, LocalDate fechaModificacion, String usuarioModificacion, List<Etiqueta> listaEtiquetas, String id) {
                super(id);
                this.titulo = titulo;
                this.idSitio = idSitio;
                this.idPaginaPadre = idPaginaPadre;
                this.usuarioCreacion = usuarioCreacion;
                this.fechaCreacion = fechaCreacion;
                this.fechaModificacion = fechaModificacion;
                this.usuarioModificacion = usuarioModificacion;
                this.listaEtiquetas = listaEtiquetas;
        }

        public AccionModificarPagina() {
        }
        
        @Override
        public void ejecutarAciion() {
                System.out.println("Se creara la pagina");
                System.out.println("ID: "+id);
                System.out.println("TITULO: "+titulo);
                System.out.println("ID_SITIO: "+idSitio);
                System.out.println("ID_PAGINA_PADRE: "+idPaginaPadre);
                System.out.println("USUARIO CREACION: "+usuarioCreacion);
                System.out.println("FECHA CREACION: "+fechaCreacion.toString());
                System.out.println("FECHA MODIFICACION: "+fechaModificacion.toString());
                System.out.println("USUARIO MODIFICACION: "+usuarioModificacion);
                System.out.println("ETIQUETAS: ");
                for(Etiqueta eti: listaEtiquetas){
                        System.out.println(eti.getValor());
                }
            
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        
        

        
    
}
