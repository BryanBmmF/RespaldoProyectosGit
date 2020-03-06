/*
 * Accion Eliminar pagina
 */
package proyecto1compi1.backend.acciones;

import java.io.File;
import proyecto1compi1.backend.ControladorDeArchivos;
import proyecto1compi1.backend.app.Cliente;
import proyecto1compi1.backend.sitios.BDSitios;
import proyecto1compi1.backend.sitios.Pagina;
import proyecto1compi1.backend.sitios.Sitio;

/**
 *
 * @author bryan
 */
public class AccionEliminarPagina extends Accion{
        private Cliente cliente;
        private Thread hilo;
        public AccionEliminarPagina(String id) {
            super(id);
        }

        public AccionEliminarPagina() {
            
        }
        
        @Override
        public void ejecutarAciion() {
            System.out.println("Se eliminara la pagina......");
            System.out.println("ID: "+id);
            
            if (!existePagina()) { // si no existe la pagina
                    notificarCliente("Error: La Pagina con ID: "+id+" NO EXISTE Y NO SE PUEDE BORRAR");
            }
            
            
        }
        
        public void notificarCliente(String mensaje){
                cliente= new Cliente(PUERTO, mensaje);
                hilo = new Thread(cliente);
                hilo.start();
        }
        public boolean existePagina(){
                BDSitios bd = BDSitios.getInstance();
                boolean existe =false;
                String links="";
                int position =0;
                for(Sitio sitio: bd.getListaSitios()){
                        for(Pagina pag: sitio.getListaPaginas()){
                                if (pag.getId().equals(id)) {
                                        existe = true;
                                        //si tiene hijos
                                        File fileHija;
                                        if (!pag.getListaPagHijas().isEmpty()) {
                                                File filePadre = new File("/var/www/html/"+pag.getIdSitio()+"/"+pag.getId()+".html");
                                                filePadre.delete();
                                                //sitio.getListaPaginas().remove(position);//se borra la pagHija de momoria
                                                notificarCliente("AVISO: Se elimino la Pagina: "+id);
                                                //se recorre la lista de paginas hijas y se buscan en la lista pagina para borrarlas
                                                for(String hija: pag.getListaPagHijas()){
                                                       fileHija = new File("/var/www/html/"+pag.getIdSitio()+"/"+hija+".html"); 
                                                       fileHija.delete();
                                                       for(Pagina pagHija: sitio.getListaPaginas()){
                                                            if (pagHija.getId().equals(hija)) {
                                                                    borrarPagina(hija);
                                                                    notificarCliente("AVISO: Se elimino la Pagina hija: "+hija);
                                                                    break;
                                                            } 
                                                       }
                                                }
                                                
                                                int pos = sitio.getListaPaginas().indexOf(pag);
                                                sitio.getListaPaginas().remove(pos);
                                        } else {
                                                //solo borrar la pagina
                                                File filePadre = new File("/var/www/html/"+pag.getIdSitio()+"/"+pag.getId()+".html");
                                                filePadre.delete();
                                                int pos = sitio.getListaPaginas().indexOf(pag);
                                                sitio.getListaPaginas().remove(pos);//se borra la pagHija de momoria
                                                notificarCliente("AVISO: Se elimino la Pagina: "+id);
                                        }
                                        
                                        bd.actualizarBd();//se actualizaen la bd
                                        
                                        /*Actualizacion del index del sitio*/
                                        //listando paginas 
                                        for(Pagina p: sitio.getListaPaginas()){
                                                if (p.getIdPaginaPadre().equals("_sinPadre")) {
                                                    if (p.getId().equals("_index")) {
                                                            links+="\t\t\t<li><a href=\""+p.getId().substring(1)+".html\">"+p.getId().substring(1)+"</li>\n";
                                                    } else {
                                                            links+="\t\t\t<li><a href=\""+p.getId()+".html\">"+p.getId()+"</li>\n";
                                                    }
                                                
                                                }
                                        }
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
                return existe;
        }
        
        public void borrarPagina(String idPag){
                BDSitios bd = BDSitios.getInstance();
                int position =0;
                for(Sitio sitio: bd.getListaSitios()){
                        for(Pagina pag: sitio.getListaPaginas()){
                                if (pag.getId().equals(idPag)) {      
                                        //si tiene hijos pero no es la pagina padre de toddas ;as que se borraran
                                        File fileHija;
                                        if (!pag.getListaPagHijas().isEmpty()) {
                                                //solo borrar la pagina
                                                File filePadre = new File("/var/www/html/"+pag.getIdSitio()+"/"+pag.getId()+".html");
                                                filePadre.delete();
                                                //sitio.getListaPaginas().remove(position);//se borra la pagHija de momoria
                                                //se recorre la lista de paginas hijas y se buscan en la lista pagina para borrarlas
                                                for(String hija: pag.getListaPagHijas()){
                                                       fileHija = new File("/var/www/html/"+pag.getIdSitio()+"/"+hija+".html"); 
                                                       fileHija.delete();
                                                       for(Pagina pagHija: sitio.getListaPaginas()){
                                                            if (pagHija.getId().equals(hija)) {
                                                                    borrarPagina(hija);
                                                                    notificarCliente("AVISO: Se elimino la Pagina hija: "+hija);
                                                                    break;
                                                            }
                                                       }
                                                }
                                                int pos = sitio.getListaPaginas().indexOf(pag);
                                                sitio.getListaPaginas().remove(pos);
                                        } else {
                                                //solo borrar la pagina
                                                File filePadre = new File("/var/www/html/"+pag.getIdSitio()+"/"+pag.getId()+".html");
                                                filePadre.delete();
                                                int pos = sitio.getListaPaginas().indexOf(pag);
                                                sitio.getListaPaginas().remove(pos);//se borra la pagHija de momoria
                                                
                                        }
                                        break;
                                }
                                position++;
                        }
                        
                }
                
        }
        
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        
}
