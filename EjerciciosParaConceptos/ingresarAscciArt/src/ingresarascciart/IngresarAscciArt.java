/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresarascciart;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class IngresarAscciArt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String imagen;
        
        System.out.println("ingrese una imagen");
        imagen= scanner.nextLine();
        
        for(int i=0;i<imagen.length();i++){
            int as= imagen.charAt(i);
            System.out.println(as);
        }
    }
    
}
