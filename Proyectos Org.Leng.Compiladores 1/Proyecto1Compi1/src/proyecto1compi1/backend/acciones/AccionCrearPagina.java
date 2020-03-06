/*
 * Accion Crear pagina
 */
package proyecto1compi1.backend.acciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import proyecto1compi1.backend.ControladorDeArchivos;
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
public class AccionCrearPagina extends Accion{
    
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

        public AccionCrearPagina() {
        }
        
        public AccionCrearPagina(String titulo, String idSitio, String idPaginaPadre, String usuarioCreacion, LocalDate fechaCreacion, LocalDate fechaModificacion, String usuarioModificacion, List<Etiqueta> listaEtiquetas, String id) {
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
                
                if (id!=null && idSitio!=null) {
                        if (existeSitio()) {
                                if (!existePagina()) {//si no existe la pagina
                                        agregarPagina();
                                } else {
                                        notificarCliente("Error: La pagina con ID:"+id+" YA EXISTE en este sitio u otro");
                                }
                        
                        } else {
                                notificarCliente("Error: El SITIO donde se solicita crear la pagina con ID:"+id+" NO EXISTE");
                        }
                        
                } else {
                        notificarCliente("Error: Los parametros ID* y SITIO* son Obligatorios para una NUEVA_PAGINA");
                }
        }
        
        public void notificarCliente(String mensaje){
                cliente= new Cliente(PUERTO, mensaje);
                hilo = new Thread(cliente);
                hilo.start();
        }
        public boolean existeSitio(){
                BDSitios bd = BDSitios.getInstance();
                boolean existe =false;
                for(Sitio sitio: bd.getListaSitios()){
                        if (sitio.getId().equals(idSitio)) {
                                existe = true;
                                break;
                        }
                }
                return existe;
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
        public boolean existePaginaPadre(){
                BDSitios bd = BDSitios.getInstance();
                boolean existe =false;
                for(Sitio sitio: bd.getListaSitios()){
                        for(Pagina pag: sitio.getListaPaginas()){
                                if (pag.getId().equals(idPaginaPadre)) {
                                        //se agrega esta pagina como hija
                                        pag.getListaPagHijas().add(id);
                                        existe = true;
                                        break;
                                }
                        }
                        
                }
                return existe;
        }
        
        public void agregarPagina(){
                BDSitios bd = BDSitios.getInstance();
                int position = 0;
                for(Sitio sitio: bd.getListaSitios()){
                        if (sitio.getId().equals(idSitio)) {
                                if (idPaginaPadre!=null) {//si se especifica el padre, sino es hermana de index
                                        if (existePaginaPadre()) {
                                                bd.getListaSitios().get(position).getListaPaginas().add(new Pagina(id, "/var/www/html/"+idSitio, titulo, idSitio, idPaginaPadre,
                                                usuarioCreacion, fechaCreacion, fechaModificacion, usuarioModificacion, listaEtiquetas, new ArrayList(), new ArrayList()));
                                                bd.actualizarBd();
                                                generarPaginaHTML();
                                                actualizarSitio();
                                                notificarCliente("ACCION EJECUTADA: Se creo una nueva pagina web con ID: "+id);
                                        } else {
                                                notificarCliente("Error: El Padre de la pagina con ID: "+id+" NO EXISTE EN ESTE SITIO");
                                        }
                                        
                                } else {
                                        bd.getListaSitios().get(position).getListaPaginas().add(new Pagina(id, "/var/www/html/"+idSitio, titulo, idSitio, "_sinPadre",
                                                usuarioCreacion, fechaCreacion, fechaModificacion, usuarioModificacion, listaEtiquetas, new ArrayList(), new ArrayList()));
                                        bd.actualizarBd();
                                        generarPaginaHTML();
                                        actualizarSitio();
                                        notificarCliente("ACCION EJECUTADA: Se creo una nueva pagina web con ID: "+id);
                                }
                                
                                break;
                        }
                        position++;
                }
               
        }
        
        public void actualizarSitio(){
                String links ="";
                BDSitios bd = BDSitios.getInstance();
                int position = 0;
                for(Sitio sitio: bd.getListaSitios()){
                        if (sitio.getId().equals(idSitio)) {
                                for(Pagina pag: bd.getListaSitios().get(position).getListaPaginas()){
                                        //agregar cada pagina al index
                                        if (pag.getIdPaginaPadre().equals("_sinPadre")) {
                                                if (pag.getId().equals("_index")) {
                                                        links+="\t\t\t<li><a href=\""+pag.getId().substring(1)+".html\">"+pag.getId().substring(1)+"</li>\n";
                                                } else {
                                                        links+="\t\t\t<li><a href=\""+pag.getId()+".html\">"+pag.getId()+"</li>\n";
                                                }
                                                
                                        }
                                }
                                /*Actualizacion del index del sitio*/
                                String salida = "";
                                salida+="<!DOCTYPE html>\n";
                                salida+="\t<html>\n";
                                salida+="\t\t<head>\n";
                                salida+="\t\t\t<title>"+sitio.getId()+"</title>\n";
                                salida+="\t\t</head>\n";
                                salida+="\t\t<body>\n";
                                
                                salida+="\t\t<ul style=\"list-style-type:circle;\">\n";
                                salida+=links;
                                salida+="\t\t</ul>\n";
                                salida+="\t\t</body>\n";
                                salida+="\t</html>\n";

                                ControladorDeArchivos arc = new ControladorDeArchivos();
                                arc.escrituraBasica(sitio.getPath()+"/"+sitio.getId(), "index.html", salida);
                                break;
                        }
                        position++;
                }
                
                
                
        }
        
        public void generarPaginaHTML(){
                String salida = "";
                salida+="<!DOCTYPE html>\n";
                salida+="\t<html>\n";
                salida+="\t\t<head>\n";
                if (titulo!=null) {
                        salida+="\t\t\t<title>"+titulo+"</title>\n";
                } else {
                        salida+="\t\t\t<title> </title>\n";
                }
                salida+="\t\t</head>\n";
                salida+="\t\t<body>\n";
                salida+="\t\t</body>\n";
                salida+="\t</html>\n";
                
                ControladorDeArchivos arc = new ControladorDeArchivos();
                arc.escrituraBasica("/var/www/html/"+idSitio, id+".html", salida);
                
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
