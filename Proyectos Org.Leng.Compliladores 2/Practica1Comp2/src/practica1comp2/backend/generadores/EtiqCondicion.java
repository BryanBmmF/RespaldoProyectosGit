/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.generadores;

/**
 *
 * @author bryan
 */
public class EtiqCondicion {
    private String v;
    private String f;

    public EtiqCondicion(String e1, String e2) {
            v = e1;
            f = e2;
    }

    public String v() {
            return v;
    }

    public String f() {
            return f;
    }

    public void setV(String v) {
        this.v = v;
    }

    public void setF(String f) {
        this.f = f;
    }
        
        
    
}
