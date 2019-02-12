
package clases1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author bryan
 */
public class Estudiante {
    private long carne;
    private int regAc;
    private String nombre;
    private String carrera;
    private static List<Estudiante> listaEstudiantes=new ArrayList<Estudiante>();

    public Estudiante(long carne, int regAc, String nombre, String carrera) {
        this.carne = carne;
        this.regAc = regAc;
        this.nombre = nombre;
        this.carrera = carrera;
    }
    public Estudiante(){ 
    }
    public void crearEstudiante(){
        Long carne;
        int regAc;
        String nombre,carrera;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2= new Scanner(System.in);
        System.out.println("Ingrese No.Carne: ");
        carne= scanner.nextLong();
        System.out.println("Ingrese No.Registro Academico: ");
        regAc= scanner.nextInt();
        System.out.println("Ingrese Nombre: ");
        nombre=scanner2.nextLine();
        System.out.println("Ingrese Carreara: ");
        carrera= scanner2.nextLine();
        
        listaEstudiantes.add(new Estudiante(carne, regAc, nombre, carrera));
    }
    public void verEstiantes(){
        System.out.println("Listado de Estudiantes: ");
        System.out.println("Nombre\t\t"+"Carne\t\t\t"+"Reg_Academico\t\t\t"+"Carrera");
        for(Estudiante i: listaEstudiantes){
            System.out.println(i.getNombre()+"\t\t"+i.getCarne()+"\t\t"+i.getRegAc()+"\t\t\t"+i.getCarrera());
            
        }
    }

    public long getCarne() {
        return carne;
    }

    public void setCarne(long carne) {
        this.carne = carne;
    }

    public int getRegAc() {
        return regAc;
    }

    public void setRegAc(int regAc) {
        this.regAc = regAc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
}
