/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2compi1;

import java.util.HashMap;
import proyecto2compi1.frontend.JFramePrincipal;

/**
 *
 * @author bryan
 */
public class Proyecto2Compi1 {
    private Boolean bol;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFramePrincipal ven = new JFramePrincipal();
        ven.setVisible(true);
        //System.out.println("'");
        //String.valueOf("");
        //Boolean bol = new Boolean(Boolean.FALSE || Boolean.TRUE);
        
       // if (bol.booleanValue()==false) {
        //        System.out.println("********");
       // }
       
        HashMap<String, String> codigoHtml = new HashMap<String, String>();
        
        codigoHtml.put("texto", "<html>");
        codigoHtml.put("texto", "12");
        codigoHtml.put("texto", "<head>");
        
        for (String key: codigoHtml.keySet()){
                    System.out.println(key+": "+codigoHtml.get(key));
                   
            }
       
        
        
    }
    
}
