package Tablas.TablaTipos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class TablaTipos {

    private List<Tipos> tablaTipos;

    public TablaTipos() {
        this.tablaTipos = new ArrayList<>();
    }

    public boolean addElementInAmbit(Tipos element) {
        if (!existsInAmbit(element.getNombre(), element.getAmbito())) {
            element.setNumeroElemento(tablaTipos.size()+1);
            tablaTipos.add(element);
            return true;
        }
        return false;
    } 
    
    public boolean addElementInGeneral(Tipos element) {
        if (!existsInGeneral(element.getNombre())) {
            element.setNumeroElemento(tablaTipos.size()+1);
            tablaTipos.add(element);
            return true;
        }
        return false;
    }
    
    public boolean existsInAmbit(String nombre, int ambito) {
        for (int i = 0; i < tablaTipos.size(); i++) {
            if (tablaTipos.get(i).getNombre().equals(nombre) && ambito == tablaTipos.get(i).getAmbito()) {
                return true;
            } 
        }
        return false;
    }
    
    public boolean existsInGeneral(String nombre) {
        for (int i = 0; i < tablaTipos.size(); i++) {
            if (tablaTipos.get(i).getNombre().equals(nombre) && 0 == tablaTipos.get(i).getAmbito()) {
                return true;
            } 
        }
        return false;
    }
    



    public Tipos posicionTipo(String tipo) {
        for (int i = 0; i < tablaTipos.size(); i++) {
            if (tablaTipos.get(i).getNombre().equals(tipo)) {
                return tablaTipos.get(i);
            }
        }
        return null;
    }

    public Boolean pertenecenAlMismoDato(String uno, String dos) {
        String tipoUno = null, tipoDos = null;
        for (int i = 0; i < this.tablaTipos.size(); i++) {
            if (tablaTipos.get(i).getNombre().equals(uno)) {
                tipoUno = tablaTipos.get(i).getTipoElemento();
            }
        }

        for (int i = 0; i < this.tablaTipos.size(); i++) {
            if (tablaTipos.get(i).getNombre().equals(dos)) {
                tipoDos = tablaTipos.get(i).getTipoElemento();
            }
        }

        if (tipoUno != null && tipoDos != null) {
            return tipoUno.equals(tipoDos);
        }
        
        
        
        return null;
    }

    public Tipos returnTipo(String nombre) {
        for (int i = 0; i < tablaTipos.size() && nombre!=null; i++) {
            if (tablaTipos.get(i).getNombre().equals(nombre)) {
                return tablaTipos.get(i);
            }
        }
        return null;
    }

    public String crearElemento(String nombre, String categoria, String tipo, Integer ambito, TablaTipos tablaTipos) {
        try {
            int numeroElemento = tablaTipos.tipoElemento(tipo, ambito);

            int tipoBase = tipoElemento(tipo, ambito);
            
            if (tipoBase != -1 && numeroElemento != -1) {
                Tipos simbol = new Tipos(nombre,ambito,null, tipo, categoria);
                addElementInAmbit(simbol);
                return "TRUE";
            } else {
                return "NO SE HA PODIDO AGREGAR EL ELEMENTO :" + nombre + " A LA TABLA DE SIMBOLOS NI DE TIPOS";
            }

        } catch (Exception e) {
            return "NO SE HA PODIDO AGREGAR EL ELEMENTO :" + nombre + " A LA TABLA DE SIMBOLOS NI DE TIPOS";
        }

    }

    public int tipoElemento(String nombre, int ambito) {
        for (int i = 0; i < tablaTipos.size(); i++) {
            if (tablaTipos.get(i).getNombre().equals(nombre) && tablaTipos.get(i).getAmbito() == ambito) {
                return tablaTipos.get(i).getNumeroElemento();
            }
        }
        
        for (int i = 0; i < tablaTipos.size(); i++) {
            if (tablaTipos.get(i).getNombre().equals(nombre) && tablaTipos.get(i).getAmbito() == 0) {
                return tablaTipos.get(i).getNumeroElemento();
            }
        }
        return -1;
    }

    public List<Tipos> getTabla() {
        return this.tablaTipos;
    }
    
     public boolean addElement(Tipos element) {
        if (!existsInGeneral(element.getNombre())) {
            tablaTipos.add(element);
            return true;
        }
        return false;
    }
}
