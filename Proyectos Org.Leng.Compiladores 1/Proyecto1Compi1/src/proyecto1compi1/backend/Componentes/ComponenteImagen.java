/*
 * Componente Imagen
 */
package proyecto1compi1.backend.Componentes;

/**
 *
 * @author bryan
 */
public class ComponenteImagen extends Componente{
        
        private String origen;
        private Alineaciones alineacion;
        private Integer altura;
        private Integer ancho;

        public ComponenteImagen(String origen, Alineaciones alineacion, Integer altura, Integer ancho, Componentes claseComponente) {
                super(claseComponente);
                this.origen = origen;
                this.alineacion = alineacion;
                this.altura = altura;
                this.ancho = ancho;
        }

        public ComponenteImagen() {
        }

        
        @Override
        public void construirComponente() {
                System.out.println("se creara un nuevo componente Imagen.......");
                System.out.println("ORIGEN: "+origen);
                System.out.println("ALINEACION: "+alineacion.toString());
                System.out.println("ALTURA: "+altura+"px");
                System.out.println("ANCHO: "+ancho+"px");
        }

        public String getOrigen() {
            return origen;
        }

        public void setOrigen(String origen) {
            this.origen = origen;
        }

        public Alineaciones getAlineacion() {
            return alineacion;
        }

        public void setAlineacion(Alineaciones alineacion) {
            this.alineacion = alineacion;
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
                if (this.alineacion!=null) {
                        salida+="\t\t\t\t\t<atributo nombre = \"ALINEACION\">\n";
                        salida+="\t\t\t\t\t\t["+this.alineacion.toString()+"]\n";
                        salida+="\t\t\t\t\t</atributo>\n";
                }               
                salida+="\t\t\t\t</atributos>\n";
                
                return salida;
        }

    @Override
    public String devolverEstructuraHTML() {
            String salida ="";
            salida +="\n<div ";
            if (alineacion!=null) {
                    salida +="style=\"text-align:"+alineacion.toString().toLowerCase()+"\"";
            }
            salida +="> \n";
            salida +="\t<img src=\""+origen+"\"";
            salida +="\"style=\"width:"+ancho+";"+" eight:"+altura+";\">\n";
            salida +="</div>\n";
       
            return salida;
    }

        
        
        
}
