/*
 * 
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
public class AccionCrearSitio extends Accion{
    
        private String usuarioCreacion;
        private LocalDate fechaCreacion;
        private LocalDate fechaModificacion;
        private String usuarioModificacion;
        
        private Cliente cliente;
        private Thread hilo;

        public AccionCrearSitio(String usuarioCreacion, LocalDate fechaCreacion, LocalDate fechaModificacion, String usuarioModificacion, String id) {
                super(id);
                this.usuarioCreacion = usuarioCreacion;
                this.fechaCreacion = fechaCreacion;
                this.fechaModificacion = fechaModificacion;
                this.usuarioModificacion = usuarioModificacion;
        }

        public AccionCrearSitio() {
        
        }
        
        @Override
        public void ejecutarAciion() {
                System.out.println("Se creara el sitio.....");
                System.out.println("ID: "+id);
                System.out.println("USUARIO CREACION: "+usuarioCreacion);
                System.out.println("FECHA CREACION: "+fechaCreacion.toString());
                System.out.println("FECHA MODIFICACION: "+fechaModificacion.toString());
                System.out.println("USUARIO MODIFICACION: "+usuarioModificacion);
                
                BDSitios bd = BDSitios.getInstance();
                //verificar si no es null el id
                if (id!=null) {
                        //verificando que no exista un sitio con el mismo nombre
                        if (!existeSitio()) {
                                //guardar sitio en bd                         
                                Pagina pagina = new Pagina("_index", "/var/www/html/"+id, "Pagina Inicial", id, "_sinPadre", usuarioCreacion, fechaCreacion, fechaModificacion,
                                        usuarioModificacion, new ArrayList(), new ArrayList(), new ArrayList());
                                List<Pagina> lista = new ArrayList();
                                lista.add(pagina);
                                Sitio sitio = new Sitio(id, "/var/www/html", usuarioCreacion, fechaCreacion, fechaModificacion, usuarioModificacion, lista);
                                
                                bd.getListaSitios().add(sitio);
                                bd.actualizarBd();
                                generarSitio(sitio);
                                notificarCliente("ACCION EJECUTADA: Se creo el nuevo sitio web con ID: "+id);
                                
                        } else {
                                notificarCliente("Error: El Sitio con ID= "+id+"  no se puede crear porque ya existe");
                        }
                
                } else {
                        notificarCliente("Error: Para crear un sitio es Obligatorio* su ID ");
                }
                
             /*cada vez que se agrega una nueva pagina a un sitio actualizar la pagina index con los nuevos hermanos*/   
                
                
        }
        
        public void generarSitio(Sitio sitio){
                String salida = "";
                salida+="<!DOCTYPE html>\n";
                salida+="\t<html>\n";
                salida+="\t\t<head>\n";
                salida+="\t\t\t<title>"+sitio.getId()+"</title>\n";
                salida+="\t\t</head>\n";
                salida+="\t\t<body>\n";
                salida+="\t\t</body>\n";
                salida+="\t</html>\n";
                
                ControladorDeArchivos arc = new ControladorDeArchivos();
                arc.escrituraBasica(sitio.getPath()+"/"+sitio.getId(), "index.html", salida);
        }
        
        public boolean existeSitio(){
                BDSitios bd = BDSitios.getInstance();
                boolean existe =false;
                for(Sitio sitio: bd.getListaSitios()){
                        if (sitio.getId().equals(id)) {
                                existe = true;
                                break;
                        }
                }
                return existe;
        }
        public void notificarCliente(String mensaje){
                cliente= new Cliente(PUERTO, mensaje);
                hilo = new Thread(cliente);
                hilo.start();
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    
}
