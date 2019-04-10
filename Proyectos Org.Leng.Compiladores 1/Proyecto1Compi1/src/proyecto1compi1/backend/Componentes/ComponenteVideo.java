/*
 * Componente Video
 */
package proyecto1compi1.backend.Componentes;

/**
 *
 * @author bryan
 */
public class ComponenteVideo extends Componente{
        private String origen;
        private Integer altura;
        private Integer ancho;

        public ComponenteVideo(String origen, Integer altura, Integer ancho, Componentes claseComponente) {
                super(claseComponente);
                this.origen = origen;
                this.altura = altura;
                this.ancho = ancho;
        }

        public ComponenteVideo() {
        }
        
        
        @Override
        public void construirComponente() {
                System.out.println("se creara un nuevo componente Video.......");
                System.out.println("ORIGEN: "+origen);
                //System.out.println("ALINEACION: "+alineacion.toString());
                System.out.println("ALTURA: "+altura+"px");
                System.out.println("ANCHO: "+ancho+"px");
        }

        public String getOrigen() {
            return origen;
        }

        public void setOrigen(String origen) {
            this.origen = origen;
        }

        public Integer getAltura() {
            return altura;
        }

        public void setAltura(Integer altura) {
            this.altura = altura;
        }

        public Integer getAncho() {
            return ancho;
        }

        public void setAncho(Integer ancho) {
            this.ancho = ancho;
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
                salida+="\t\t\t\t<atributos>\n";
                salida+="\t\t\t\t\t<atributo nombre = \"ORIGEN\">\n";
                salida+="\t\t\t\t\t\t["+this.origen+"]\n";
                salida+="\t\t\t\t\t</atributo>\n";
                salida+="\t\t\t\t\t<atributo nombre = \"ALTURA\">\n";
                salida+="\t\t\t\t\t\t["+this.altura+"]\n";
                salida+="\t\t\t\t\t</atributo>\n";
                salida+="\t\t\t\t\t<atributo nombre = \"ANCHO\">\n";
                salida+="\t\t\t\t\t\t["+this.ancho+"]\n";
                salida+="\t\t\t\t\t</atributo>\n";
               
                salida+="\t\t\t\t</atributos>\n";
                
                return salida;
        }
        
    @Override
    public String devolverEstructuraHTML() {
            String salida ="";
            salida +="\n<iframe width=\""+ancho+"\" height=\""+altura+"\" src=\""+origen+"\""+" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>\n";
            
            return salida;
    }

        
}
