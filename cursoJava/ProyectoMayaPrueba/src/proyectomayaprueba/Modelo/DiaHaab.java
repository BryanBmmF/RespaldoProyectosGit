package proyectomayaprueba.Modelo;
// Generated 11/09/2019 02:29:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * DiaHaab generated by hbm2java
 */
public class DiaHaab  implements java.io.Serializable {


     private int idDiaHaab;
     private Set kinHaabs = new HashSet(0);

    public DiaHaab() {
    }

	
    public DiaHaab(int idDiaHaab) {
        this.idDiaHaab = idDiaHaab;
    }
    public DiaHaab(int idDiaHaab, Set kinHaabs) {
       this.idDiaHaab = idDiaHaab;
       this.kinHaabs = kinHaabs;
    }
   
    public int getIdDiaHaab() {
        return this.idDiaHaab;
    }
    
    public void setIdDiaHaab(int idDiaHaab) {
        this.idDiaHaab = idDiaHaab;
    }
    public Set getKinHaabs() {
        return this.kinHaabs;
    }
    
    public void setKinHaabs(Set kinHaabs) {
        this.kinHaabs = kinHaabs;
    }




}


