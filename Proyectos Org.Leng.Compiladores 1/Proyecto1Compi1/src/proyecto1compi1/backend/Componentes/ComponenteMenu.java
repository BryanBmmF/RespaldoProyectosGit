/*
 * Componente Menu
 */
package proyecto1compi1.backend.Componentes;

import java.util.List;
import proyecto1compi1.backend.etiquetas.Etiqueta;

/**
 *
 * @author bryan
 */
public class ComponenteMenu extends Componente{
        
        private String idPadre;
        //listado etiquetas
        private List<Etiqueta> listaEtiquetas;

        public ComponenteMenu(String idPadre, List<Etiqueta> listaEtiquetas, Componentes claseComponente) {
                super(claseComponente);
                this.idPadre = idPadre;
                this.listaEtiquetas = listaEtiquetas;
        }

        public ComponenteMenu() {
        }
        

        @Override
        public void construirComponente() {
                System.out.println("se creara un nuevo componente Menu.......");
                System.out.println("ID_PADRE: "+idPadre);
                System.out.println("ETIQUETAS:");
                for(Etiqueta e: listaEtiquetas){
                    System.out.println(e.getValor());
                }
                
        }

        public String getIdPadre() {
            return idPadre;
        }

        public void setIdPadre(String idPadre) {
            this.idPadre = idPadre;
        }

        public List<Etiqueta> getListaEtiquetas() {
            return listaEtiquetas;
        }

        public void setListaEtiquetas(List<Etiqueta> listaEtiquetas) {
            this.listaEtiquetas = listaEtiquetas;
        }

        public Componentes getClaseComponente() {
            return claseComponente;
        }

        public void setClaseComponente(Componentes claseComponente) {
            this.claseComponente = claseComponente;
        }
        
        @Override
        public Componentes devolverClaseComponente() {
                return this.claseComponente;
        }  
        @Override
        public String devolverEstructuraAtributos() {
                String salida = "";
                int ultimaEtiqueta;
                salida+="\t\t\t\t<atributos>\n";
                salida+="\t\t\t\t\t<atributo nombre = \"PADRE\">\n";
                salida+="\t\t\t\t\t\t["+this.idPadre+"]\n";
                salida+="\t\t\t\t\t</atributo>\n";
                if (!this.listaEtiquetas.isEmpty()) {
                        salida+="\t\t\t\t\t<atributo nombre = \"ETIQUETAS\">\n";
                        salida+="\t\t\t\t\t\t[";
                        ultimaEtiqueta=this.listaEtiquetas.size()-1;
                        for (int i = 0; i < this.listaEtiquetas.size(); i++) {
                                if (i==ultimaEtiqueta) {
                                        salida+=this.listaEtiquetas.get(i).getValor();
                                } else {
                                        salida+=this.listaEtiquetas.get(i).getValor()+"|";
                                }
                        }
                        salida+="]\n";
                        salida+="\t\t\t\t\t</atributo>\n";
                
                }
                salida+="\t\t\t\t</atributos>\n";
                return salida;
        }
        
        @Override
        public String devolverEstructuraHTML() {
            String salida ="";
            return salida;
        }
        
}
