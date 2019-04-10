/*
 * Accion eliminar Sitio
 */
package proyecto1compi1.backend.acciones;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import proyecto1compi1.backend.ControladorDeArchivos;
import static proyecto1compi1.backend.acciones.Accion.PUERTO;
import proyecto1compi1.backend.app.Cliente;
import proyecto1compi1.backend.sitios.BDSitios;
import proyecto1compi1.backend.sitios.Pagina;
import proyecto1compi1.backend.sitios.Sitio;

/**
 *
 * @author bryan
 */
public class AccionEliminarSitio extends Accion{
        private Cliente cliente;
        private Thread hilo;
        public AccionEliminarSitio(String id) {
            super(id);
        }

        public AccionEliminarSitio() {
        }


        @Override
        public void ejecutarAciion() {
                System.out.println("Se eliminar el sitio......");
                System.out.println("ID: "+id);
                //verificando que no exista un sitio con el mismo nombre
                if (eliminarSitio()) {   
                        notificarCliente("ACCION EJECUTADA: Eliminacion del sitio web con ID: "+id);

                } else {
                        notificarCliente("ERROR: El Sitio con ID= "+id+"  no se puede eliminar porque no existe");
                }
        }
        
        public boolean eliminarSitio(){
                BDSitios bd = BDSitios.getInstance();
                ControladorDeArchivos con = new ControladorDeArchivos();
                boolean eliminar =false;
                int position=0;
                for(Sitio sitio: bd.getListaSitios()){
                        if (sitio.getId().equals(id)) {
                                eliminar = true;
                                con.eliminarCarpeta(new File(sitio.getPath()+"/"+id));
                                bd.getListaSitios().remove(position);
                                bd.actualizarBd();
                                break;
                        }
                        position++;
                }
                return eliminar;
        }
        public void notificarCliente(String mensaje){
                cliente= new Cliente(PUERTO, mensaje);
                hilo = new Thread(cliente);
                hilo.start();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
     
    
    
}
