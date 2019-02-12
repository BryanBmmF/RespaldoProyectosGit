/*
 * Clase Campo
 */
package practicaclases;

/**
 * 
 * @author bryan
 */
public class Campo {
    private String nombre;
    private String dimensiones;
    private String ubicacion;
    private String tipoGramilla;
    //para un estadio
    private int capacidad;
    private String tipoDeAsientos;
    //constructor para campo simple
    public Campo(String nombre, String dimensiones, String ubicacion,String tipoGramilla) {
        this.nombre = nombre;
        this.dimensiones = dimensiones;
        this.ubicacion = ubicacion;
        this.tipoGramilla= tipoGramilla;
    }
    //constructor para estadio
    public Campo(String nombre, String dimensiones, String ubicacion, String tipoGramilla, int capacidad, String tipoDeAsientos) {
        this.nombre = nombre;
        this.dimensiones = dimensiones;
        this.ubicacion = ubicacion;
        this.tipoGramilla = tipoGramilla;
        this.capacidad = capacidad;
        this.tipoDeAsientos = tipoDeAsientos;
    }
    
    public Campo(){
    
    }
    //metodos Accesores
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoGramilla() {
        return tipoGramilla;
    }

    public void setTipoGramilla(String tipoGramilla) {
        this.tipoGramilla = tipoGramilla;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoDeAsientos() {
        return tipoDeAsientos;
    }

    public void setTipoDeAsientos(String tipoDeAsientos) {
        this.tipoDeAsientos = tipoDeAsientos;
    }

    
   
}
