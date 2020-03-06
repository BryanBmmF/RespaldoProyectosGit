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
public class EtiqRedireccion {
    private String ini;
    private String fin;

    public EtiqRedireccion(String e1, String e2) {
            ini = e1;
            fin = e2;
    }

    public void ini(String e1) {
            ini = e1;
    }

    public void fin(String e2) {
            fin = e2;
    }

    public String ini() {
            return ini;
    }

    public String fin() {
            return fin;
    }

    public void setIni(String ini) {
        this.ini = ini;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
        
    
}
