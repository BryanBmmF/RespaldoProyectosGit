package EjemploBinding ;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author bryan
 */
public class Persona implements Serializable {
    
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;

    public Persona(String nombre, String apellido, String genero, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
    }
    public Persona(String nombre){
        this.nombre= nombre;
    }

    public static List<Persona> crearPersonas() {
        List<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona("Bryan","Monzon","M",21));
        personas.add(new Persona("Pedro","Monzon","M",21));
        personas.add(new Persona("Juan","Monzon","M",21));
        personas.add(new Persona("Oscar","Monzon","M",21));
        personas.add(new Persona("Carlos","Monzon","M",21));
        personas.add(new Persona("Maria","Orozco","F",21));
        personas.add(new Persona("Rosa","Mazariegos","F",21));
        personas.add(new Persona("Carla","Perez","F",21));
        return personas;
    }
    public static List<Persona> comboNombres(){
        List<Persona> nombres= new ArrayList<>();
            nombres.add(new Persona("Gilberto"));
            nombres.add(new Persona("Gilberto"));
            nombres.add(new Persona("Gilberto"));
            nombres.add(new Persona("Gilberto"));
            nombres.add(new Persona("Gilberto"));
            nombres.add(new Persona("Gilberto"));
        return nombres;
        
    }
    public String getGenero() {    
        return genero;        
    }

    
    public void setGenero(String genero) {
        String anterior= this.genero;
        this.genero = genero;
        propertyChangeSupport.firePropertyChange("genero", anterior, genero); 
    }

    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
         String anterior= this.apellido;
        this.apellido = apellido;
        propertyChangeSupport.firePropertyChange("apellido", anterior, apellido);
    }
    
    public int getEdad() {
        return edad;
    }
   
    public void setEdad(int edad) {
         int anterior= this.edad;
        this.edad = edad;
        propertyChangeSupport.firePropertyChange("edad", anterior, edad);
    }
    
    public String getNombre() {
        return nombre;
    }
   
    public void setNombre(String nombre) {
        String anterior = this.nombre; 
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange("nombre", anterior, nombre); 
    }
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
