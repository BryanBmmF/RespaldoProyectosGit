/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclases;

/**
 *
 * @author christian
 */
public class Autoclases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        figuras fig;
        fig = new circulo();
        fig.setArea(25);
        fig.setLados(0);
        fig.setPerimetro(5);
        ((circulo) fig).setRadio(30);
        System.out.println(fig.getPerimetro());
        System.out.println( ((circulo) fig).getArea()        );





//        Persona j1 = new Jugador("Luis","Guatemalteco","delantero",12);
//        System.out.println(j1.getNombre());
//        j1=new Arbitro(j1.getNombre(),j1.getNacionalidad(),"Central",35);
//        System.out.println( ((Arbitro) j1).getPosicion()  );
        
//        int edad[] = {20,17,12,23,26,12,28,29,30,31,32,33,5,3,9,8,12,100,71,-8,9,-7,-3,2};
//        int principal,secundarios,burbuja,cont=0;
//        for(principal=0;principal<edad.length;principal++){
//            for(secundarios=0;secundarios<edad.length;secundarios++){                
//                if(edad[principal]<edad[secundarios]){
//                    burbuja = edad[principal];
//                    edad[principal]=edad[secundarios];
//                    edad[secundarios]=burbuja;
//                }
//                cont++;
//            }
//        }
//        for(principal=0;principal<edad.length;principal++){
//            System.out.println(edad[principal]);
//        }
//        System.out.println("Se recorrieron "+cont+" veces el listado");
    }
    
}