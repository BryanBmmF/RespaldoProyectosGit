/*
 * ModificarComponente
 */
package proyecto1compi1.backend.acciones;

import proyecto1compi1.backend.Componentes.Componente;
import proyecto1compi1.backend.ControladorDeArchivos;
import static proyecto1compi1.backend.acciones.Accion.PUERTO;
import proyecto1compi1.backend.app.Cliente;
import proyecto1compi1.backend.sitios.BDSitios;
import proyecto1compi1.backend.sitios.ComponenteCompleto;
import proyecto1compi1.backend.sitios.Pagina;
import proyecto1compi1.backend.sitios.Sitio;

/**
 *
 * @author bryan
 */
public class AccionModificarComponente extends Accion{
        private String idPagina;
        private Componente claseComponente;
        
        private Cliente cliente;
        private Thread hilo;

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
                
                BDSitios bd = BDSitios.getInstance();
                int position = 0;
                int positionComp = 0;
                boolean compExist = false;
                for(Sitio sitio: bd.getListaSitios()){
                        for(Pagina pag: sitio.getListaPaginas()){
                                if (pag.getId().equals(idPagina)) {
                                        for(ComponenteCompleto comp: sitio.getListaPaginas().get(position).getListaComponentes()){
                                                if (comp.getId().equals(id)) {
                                                        compExist=true;
                                                        positionComp = sitio.getListaPaginas().get(position).getListaComponentes().indexOf(comp);
                                                        break;
                                                }
                                                
                                        }
                                        if (!compExist) {
                                                notificarCliente("El Componente con ID: "+id+"  NO EXISTE EN UNA DE LAS PAGINAS");
                            
                                        } else  {

                                                sitio.getListaPaginas().get(position).getListaComponentes().get(positionComp).setId(id);
                                                sitio.getListaPaginas().get(position).getListaComponentes().get(positionComp).setIdPagina(idPagina);
                                                sitio.getListaPaginas().get(position).getListaComponentes().get(positionComp).setClaseComponente(claseComponente);
                                                //actualizar pagina con componente nuevo
                                                bd.actualizarBd();
                                                actualizarPagina();
                                                notificarCliente("ACCION EJECUTADA MODIFICAR COMPONENTE ID: "+id);
                                        }
                                        break;
                                }
                        position++;
                        }
                        
                }
            claseComponente.construirComponente();
                
                
        }
        
        public void actualizarPagina(){
                BDSitios bd = BDSitios.getInstance();
                int position = 0;
                String componentes ="";
                for(Sitio sitio: bd.getListaSitios()){
                        for(Pagina pag: sitio.getListaPaginas()){
                                if (pag.getId().equals(idPagina)) {
                                        for(ComponenteCompleto comp: sitio.getListaPaginas().get(position).getListaComponentes()){
                                                componentes+=comp.getClaseComponente().devolverEstructuraHTML()+"\n";
                                        }
                                        
                                        String salida = "";
                                        salida+="<!DOCTYPE html>\n";
                                        salida+="\t<html>\n";
                                        salida+="\t\t<head>\n";
                                        if (pag.getTitulo()!=null) {
                                                salida+="\t\t\t<title>"+pag.getTitulo()+"</title>\n";
                                        } else {
                                                salida+="\t\t\t<title> </title>\n";
                                        }
                                        salida+="\t\t</head>\n";
                                        salida+="\t\t<body>\n";
                                        salida+=componentes;
                                        salida+="\t\t</body>\n";
                                        salida+="\t</html>\n";

                                        ControladorDeArchivos arc = new ControladorDeArchivos();
                                        arc.escrituraBasica(sitio.getPath()+"/"+sitio.getId(), idPagina+".html", salida);
                                        
                                        break;
                                }
                        position++;
                        }
                        
                }
        
        }
        
        public void notificarCliente(String mensaje){
                cliente= new Cliente(PUERTO, mensaje);
                hilo = new Thread(cliente);
                hilo.start();
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
