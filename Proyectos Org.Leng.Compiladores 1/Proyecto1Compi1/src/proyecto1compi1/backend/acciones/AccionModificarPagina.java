/*
 * Accion modificar Pagina
 */
package proyecto1compi1.backend.acciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import proyecto1compi1.backend.ControladorDeArchivos;
import static proyecto1compi1.backend.acciones.Accion.PUERTO;
import proyecto1compi1.backend.app.Cliente;
import proyecto1compi1.backend.etiquetas.Etiqueta;
import proyecto1compi1.backend.sitios.BDSitios;
import proyecto1compi1.backend.sitios.ComponenteCompleto;
import proyecto1compi1.backend.sitios.Pagina;
import proyecto1compi1.backend.sitios.Sitio;

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
        
        private Cliente cliente;
        private Thread hilo;

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
                //for(Etiqueta eti: listaEtiquetas){
                //        System.out.println(eti.getValor());
                //}
                
                if (id!=null) {
                        if (!existePagina()) {//si no existe la pagina
                                       notificarCliente("Error: La pagina con ID:"+id+" NO EXISTE ");
                        } else {
                                if (titulo==null && (listaEtiquetas==null || listaEtiquetas.isEmpty())) {
                                        notificarCliente("Error: Es Obligatorio que se defina el nuevo Titulo y/o las nuevas Etiqeutas para MODIFICAR_PAGINA");
                                } else {
                                        modificarParametros();
                                }

                        }
                        
                        
                } else {
                        notificarCliente("Error: El parametros ID* es Obligatorio para MODIFICAR_PAGINA");
                }
            
        }
        
        public void notificarCliente(String mensaje){
                cliente= new Cliente(PUERTO, mensaje);
                hilo = new Thread(cliente);
                hilo.start();
        }
        
        public void modificarParametros(){
                BDSitios bd = BDSitios.getInstance();
                String componentes="";
                for(Sitio sitio: bd.getListaSitios()){
                        for(Pagina pag: sitio.getListaPaginas()){
                                if (pag.getId().equals(id)) {
                                        if (titulo!=null) {
                                                pag.setTitulo(titulo);//actualizar titulo
                                                notificarCliente("Cambio de Titulo de la Pagina: "+id+" exitoso");
                                        }
                                        if (listaEtiquetas!=null && !listaEtiquetas.isEmpty()) {
                                                pag.setListaEtiquetas(listaEtiquetas);//actualizar etiquetas
                                                notificarCliente("Cambio de Etiquetas de la Pagina: "+id+" exitoso");
                                        }
                                        bd.actualizarBd();
                                        
                                        for(ComponenteCompleto comp: pag.getListaComponentes()){
                                                componentes+=comp.getClaseComponente().devolverEstructuraHTML()+"\n";
                                        }
                                        //actualizacion del titulo de la pagina fisicamente
                                        String salida = "";
                                        salida+="<!DOCTYPE html>\n";
                                        salida+="\t<html>\n";
                                        salida+="\t\t<head>\n";
                                        if (titulo!=null) {
                                               salida+="\t\t\t<title>"+titulo+"</title>\n";
                                        } else {
                                                salida+="\t\t\t<title>"+pag.getTitulo()+"</title>\n";
                                        }
                                        
                                        salida+="\t\t</head>\n";
                                        salida+="\t\t<body>\n";
                                        salida+=componentes;
                                        salida+="\t\t</body>\n";
                                        salida+="\t</html>\n";

                                        ControladorDeArchivos arc = new ControladorDeArchivos();
                                        arc.escrituraBasica(sitio.getPath()+"/"+sitio.getId(), id+".html", salida);
                                        
                                        break;
                                }
                        }
                        
                }
                
        }
        
        public boolean existePagina(){
                BDSitios bd = BDSitios.getInstance();
                boolean existe =false;
                for(Sitio sitio: bd.getListaSitios()){
                        for(Pagina pag: sitio.getListaPaginas()){
                                if (pag.getId().equals(id)) {
                                        existe = true;
                                        break;
                                }
                        }
                        
                }
                return existe;
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
