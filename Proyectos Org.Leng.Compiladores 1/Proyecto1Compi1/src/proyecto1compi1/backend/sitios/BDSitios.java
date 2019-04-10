/*
 * Clase BDSitios para levantar la base de datos en el srvidor
 */
package proyecto1compi1.backend.sitios;

import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto1compi1.Lexer;
import proyecto1compi1.Lexer2;
import proyecto1compi1.backend.ControladorDeArchivos;
import proyecto1compi1.backend.app.Cliente;
import proyecto1compi1.backend.etiquetas.Etiqueta;
import proyecto1compi1.parserBD;

/**
 *
 * @author bryan
 */
public class BDSitios {
        private static BDSitios bd;
        private List<Sitio> listaSitios;

        private BDSitios(){

        }

        public static BDSitios getInstance(){
                    if (bd==null) { //se crea una unica instancia de Logger
                            bd= new BDSitios();            
                    }
                    return bd;
        }
        
        public void levantarBaseDatos(){
                ControladorDeArchivos con = new ControladorDeArchivos();
                String entrada = con.leerArchivo("src/BaseDatos/basePrueba.txt");
                //con.escrituraBasica("/var/www/html/SegundaConCarpCreada","index.html", "<html><h1> PRIMERA PAGINA</h1></html>");
                
                Lexer2 lexer = new Lexer2(new StringReader(""), null);
                parserBD parser1 = new parserBD(lexer);
                
                //parser1.limpiarListas();// limpiar listas del parser1 para una nueva avaluacion                        
                lexer.yyreset(new StringReader(entrada));
                try {
                    parser1.parse();
                } catch (Exception ex) {
                    Logger.getLogger(BDSitios.class.getName()).log(Level.SEVERE, null, ex);
                }
                /*SI NO HAY INCONSISTENCIAS*/
                if (parser1.devolverErrores().isEmpty()) {
                    System.out.println("ANALISIS CORRECTO COMPLETADO!!!!");
                    setListaSitios(parser1.devolverSitios());
                } else {
                        System.out.println("HAY ERRORES");
                        for(String s: parser1.devolverErrores()){
                            System.out.println(s);
                        }
                }
        }
        
        public void listarSitios(){
                for(Sitio sitio: listaSitios){
                        System.out.println("***************************************************************");
                        System.out.println("ID: "+sitio.getId());
                        System.out.println("PATH: "+sitio.getPath());
                        System.out.println("USUARIO_CREACION: "+sitio.getUsuarioCreacion());
                        System.out.println("USUARIO_MODIFICACION: "+sitio.getUsuarioModificacion());
                        System.out.println("FECHA_CREACION: "+sitio.getFechaCreacion().toString());
                        System.out.println("FECHA_MODIFICACION: "+sitio.getFechaModificacion().toString());
                        System.out.println("LISTA DE PAGINAS: ");
                        if (!sitio.getListaPaginas().isEmpty()) {
                         for(Pagina pag: sitio.getListaPaginas()){
                                System.out.println(">>>>>>>PAGINA: ");
                                System.out.println("ID: "+pag.getId());
                                System.out.println("PATH: "+pag.getPath());
                                System.out.println("TITULO: "+pag.getTitulo());
                                System.out.println("ID_SITIO: "+pag.getIdSitio());
                                System.out.println("ID_PAGINA_PADRE: "+pag.getIdPaginaPadre());
                                System.out.println("USUARIO CREACION: "+pag.getUsuarioCreacion());
                                System.out.println("FECHA CREACION: "+pag.getFechaCreacion().toString());
                                System.out.println("FECHA MODIFICACION: "+pag.getFechaModificacion().toString());
                                System.out.println("USUARIO MODIFICACION: "+pag.getUsuarioModificacion());
                                System.out.println("------ETIQUETAS: ");
                                for(Etiqueta eti: pag.getListaEtiquetas()){
                                        System.out.println(eti.getValor());
                                }
                                System.out.println("------COMPONENTES: ");
                                for(ComponenteCompleto com: pag.getListaComponentes()){
                                        System.out.println("ID: "+com.getId());
                                        System.out.println("ID_PAGINA: "+com.getIdPagina());
                                        com.getClaseComponente().construirComponente();
                                }
                                System.out.println("------PAGINAS HIJAS: ");
                                for(String hijo: pag.getListaPagHijas()){
                                        System.out.println(hijo);
                                }
                                
                        }
                        }
                       
                        
                }
                
        }
        
        public void actualizarBd(){
                String salida = "";
   
                for(Sitio sitio: listaSitios){
                        salida+="\n<sitio>\n";
                        salida+="\t<parametros>\n";
                        salida+="\t\t<parametro nombre = \"ID\">\n";
                        salida+="\t\t\t["+sitio.getId()+"]\n";
                        salida+="\t\t</parametro>\n";
                        salida+="\t\t<parametro nombre = \"PATH\">\n";
                        salida+="\t\t\t["+sitio.getPath()+"]\n";
                        salida+="\t\t</parametro>\n";
                        salida+="\t\t<parametro nombre = \"USUARIO_CREACION\">\n";
                        salida+="\t\t\t["+sitio.getUsuarioCreacion()+"]\n";
                        salida+="\t\t</parametro>\n";
                        salida+="\t\t<parametro nombre = \"FECHA_CREACION\">\n";
                        salida+="\t\t\t["+sitio.getFechaCreacion().toString()+"]\n";
                        salida+="\t\t</parametro>\n";
                        salida+="\t\t<parametro nombre = \"FECHA_MODIFICACION\">\n";
                        salida+="\t\t\t["+sitio.getFechaModificacion().toString()+"]\n";
                        salida+="\t\t</parametro>\n";
                        salida+="\t\t<parametro nombre = \"USUARIO_MODIFICACION\">\n";
                        salida+="\t\t\t["+sitio.getUsuarioModificacion()+"]\n";
                        salida+="\t\t</parametro>\n";
                        salida+="\t</parametros>\n";
                        System.out.println("LISTA DE PAGINAS: ");
                        salida+="\t<paginas>\n";
                        if (!sitio.getListaPaginas().isEmpty()) {
                                 for(Pagina pag: sitio.getListaPaginas()){
                                        System.out.println(">>>>>>>PAGINA: ");
                                        salida+="\t\t<pagina>\n";
                                        salida+="\t\t\t<parametros>\n";
                                        salida+="\t\t\t\t<parametro nombre = \"ID\">\n";
                                        salida+="\t\t\t\t\t["+pag.getId()+"]\n";
                                        salida+="\t\t\t\t</parametro>\n";
                                        salida+="\t\t\t\t<parametro nombre = \"PATH\">\n";
                                        salida+="\t\t\t\t\t["+pag.getPath()+"]\n";
                                        salida+="\t\t\t\t</parametro>\n";
                                        if (pag.getTitulo()!=null) {
                                                salida+="\t\t\t\t<parametro nombre = \"TITULO\">\n";
                                                salida+="\t\t\t\t\t["+pag.getTitulo()+"]\n";
                                                salida+="\t\t\t\t</parametro>\n";
                                        }
                                        salida+="\t\t\t\t<parametro nombre = \"SITIO\">\n";
                                        salida+="\t\t\t\t\t["+pag.getIdSitio()+"]\n";
                                        salida+="\t\t\t\t</parametro>\n";
                                        if (pag.getTitulo()!=null) {
                                                salida+="\t\t\t\t<parametro nombre = \"PADRE\">\n";
                                                salida+="\t\t\t\t\t["+pag.getIdPaginaPadre()+"]\n";
                                                salida+="\t\t\t\t</parametro>\n";
                                        }
                                        salida+="\t\t\t\t<parametro nombre = \"USUARIO_CREACION\">\n";
                                        salida+="\t\t\t\t\t["+pag.getUsuarioCreacion()+"]\n";
                                        salida+="\t\t\t\t</parametro>\n";
                                        salida+="\t\t\t\t<parametro nombre = \"FECHA_CREACION\">\n";
                                        salida+="\t\t\t\t\t["+pag.getFechaCreacion().toString()+"]\n";
                                        salida+="\t\t\t\t</parametro>\n";
                                        salida+="\t\t\t\t<parametro nombre = \"FECHA_MODIFICACION\">\n";
                                        salida+="\t\t\t\t\t["+pag.getFechaModificacion().toString()+"]\n";
                                        salida+="\t\t\t\t</parametro>\n";
                                        salida+="\t\t\t\t<parametro nombre = \"USUARIO_MODIFICACION\">\n";
                                        salida+="\t\t\t\t\t["+pag.getUsuarioModificacion()+"]\n";
                                        salida+="\t\t\t\t</parametro>\n";
                                        salida+="\t\t\t</parametros>\n";
                                        System.out.println("------COMPONENTES: ");
                                        if (!pag.getListaComponentes().isEmpty()) {
                                                salida+="\t\t\t<componentes>\n";
                                                for(ComponenteCompleto com: pag.getListaComponentes()){
                                                        salida+="\t\t\t  <componente>\n";
                                                        salida+="\t\t\t\t<parametros>\n";
                                                        salida+="\t\t\t\t\t<parametro nombre = \"ID\">\n";
                                                        salida+="\t\t\t\t\t\t["+com.getId()+"]\n";
                                                        salida+="\t\t\t\t\t</parametro>\n";
                                                        salida+="\t\t\t\t\t<parametro nombre = \"PAGINA\">\n";
                                                        salida+="\t\t\t\t\t\t["+com.getIdPagina()+"]\n";
                                                        salida+="\t\t\t\t\t</parametro>\n";
                                                        salida+="\t\t\t\t\t<parametro nombre = \"CLASE\">\n";
                                                        salida+="\t\t\t\t\t\t["+com.getClaseComponente().devolverClaseComponente().toString()+"]\n";
                                                        salida+="\t\t\t\t\t</parametro>\n";
                                                        salida+="\t\t\t\t</parametros>\n";
                                                        salida+=com.getClaseComponente().devolverEstructuraAtributos();
                                                        salida+="\t\t\t  </componente>\n";
                                                        //com.getClaseComponente().construirComponente();
                                                }
                                                salida+="\t\t\t</componentes>\n";
                                        } else {
                                                salida+="\t\t\t<componentes>\n";
                                                salida+="\t\t\t</componentes>\n";            
                                        }
                                        System.out.println("------ETIQUETAS: ");
                                        if (!pag.getListaEtiquetas().isEmpty()) {
                                                salida+="\t\t\t<etiquetas>\n";
                                                for(Etiqueta eti: pag.getListaEtiquetas()){
                                                        salida+="\t\t\t\t<etiqueta valor = \""+eti.getValor()+"\"/>\n";
                                                }
                                                salida+="\t\t\t</etiquetas>\n";
                                        } else {
                                                salida+="\t\t\t<etiquetas>\n";
                                                salida+="\t\t\t</etiquetas>\n";   
                                        }

                                        System.out.println("------PAGINAS HIJAS: ");
                                        if (!pag.getListaPagHijas().isEmpty()) {
                                                salida+="\t\t\t<hijos>\n";
                                                for(String hijo: pag.getListaPagHijas()){
                                                        salida+="\t\t\t\t<hijo valor = \""+hijo+"\"/>\n";
                                                }
                                                salida+="\t\t\t</hijos>\n";
                                        } else {
                                                salida+="\t\t\t<hijos>\n";
                                                salida+="\t\t\t</hijos>\n";   
                                        }

                                        salida+="\t\t</pagina>\n";
                                }
                        }
                        salida+="\t</paginas>\n";
                        salida+="</sitio>\n";
                        
                }
                
                ControladorDeArchivos con = new ControladorDeArchivos();
                con.escrituraBasica("src/BaseDatos", "basePrueba.txt", salida);
        }

        public List<Sitio> getListaSitios() {
            return listaSitios;
        }

        public void setListaSitios(List<Sitio> listaSitios) {
            this.listaSitios = listaSitios;
        }

    
}
