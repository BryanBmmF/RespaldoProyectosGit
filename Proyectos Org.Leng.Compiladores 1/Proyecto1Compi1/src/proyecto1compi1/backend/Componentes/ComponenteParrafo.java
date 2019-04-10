/*
 * Componente Parrafo
 */
package proyecto1compi1.backend.Componentes;

/**
 *
 * @author bryan
 */
public class ComponenteParrafo extends Componente{
        private String texto;
        private Alineaciones alineacion;
        private String color;

        public ComponenteParrafo(String texto, Alineaciones alineacion, String color, Componentes claseComponente) {
                super(claseComponente);
                this.texto = texto;
                this.alineacion = alineacion;
                this.color = color;
        }

        public ComponenteParrafo() {
        }
        

        @Override
        public void construirComponente() {
                System.out.println("se creara un nuevo componente Parrafo.......");
                System.out.println("TEXTO: "+texto);
                System.out.println("COLOR: "+color);
                System.out.println("ALINEACION: "+alineacion.toString());
        }

        public String getTexto() {
            return texto;
        }

        public void setTexto(String texto) {
            this.texto = texto;
        }

        public Alineaciones getAlineacion() {
            return alineacion;
        }

        public void setAlineacion(Alineaciones alineacion) {
            this.alineacion = alineacion;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
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
                salida+="\t\t\t\t\t<atributo nombre = \"TEXTO\">\n";
                salida+="\t\t\t\t\t\t["+this.texto+"]\n";
                salida+="\t\t\t\t\t</atributo>\n";
                if (this.alineacion!=null) {
                        salida+="\t\t\t\t\t<atributo nombre = \"ALINEACION\">\n";
                        salida+="\t\t\t\t\t\t["+this.alineacion.toString()+"]\n";
                        salida+="\t\t\t\t\t</atributo>\n";
                }
                if (this.color!=null) {
                        salida+="\t\t\t\t\t<atributo nombre = \"COLOR\">\n";
                        salida+="\t\t\t\t\t\t["+this.color+"]\n";
                        salida+="\t\t\t\t\t</atributo>\n";
                }       
                salida+="\t\t\t\t</atributos>\n";
                
                return salida;
        }
        
        @Override
        public String devolverEstructuraHTML() {
            String salida ="";
            
            salida +="\n<p style=\"";
            if (color!=null) {
                    salida +="color:"+color+"; ";
            }
            if (alineacion!=null) {
                    salida +="text-align:"+alineacion.toString().toLowerCase()+"; ";
            }
            
            salida +="\">"+texto+"</p>";
           
            return salida;
        }
        
}
