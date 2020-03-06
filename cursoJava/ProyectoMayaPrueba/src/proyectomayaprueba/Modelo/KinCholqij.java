package proyectomayaprueba.Modelo;
// Generated 11/09/2019 02:29:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * KinCholqij generated by hbm2java
 */
public class KinCholqij  implements java.io.Serializable {


     private int idKinCholqij;
     private Energia energia;
     private Nahual nahual;
     private Set cuentaLargas = new HashSet(0);

    public KinCholqij() {
    }

	
    public KinCholqij(int idKinCholqij, Energia energia, Nahual nahual) {
        this.idKinCholqij = idKinCholqij;
        this.energia = energia;
        this.nahual = nahual;
    }
    public KinCholqij(int idKinCholqij, Energia energia, Nahual nahual, Set cuentaLargas) {
       this.idKinCholqij = idKinCholqij;
       this.energia = energia;
       this.nahual = nahual;
       this.cuentaLargas = cuentaLargas;
    }
   
    public int getIdKinCholqij() {
        return this.idKinCholqij;
    }
    
    public void setIdKinCholqij(int idKinCholqij) {
        this.idKinCholqij = idKinCholqij;
    }
    public Energia getEnergia() {
        return this.energia;
    }
    
    public void setEnergia(Energia energia) {
        this.energia = energia;
    }
    public Nahual getNahual() {
        return this.nahual;
    }
    
    public void setNahual(Nahual nahual) {
        this.nahual = nahual;
    }
    public Set getCuentaLargas() {
        return this.cuentaLargas;
    }
    
    public void setCuentaLargas(Set cuentaLargas) {
        this.cuentaLargas = cuentaLargas;
    }




}

