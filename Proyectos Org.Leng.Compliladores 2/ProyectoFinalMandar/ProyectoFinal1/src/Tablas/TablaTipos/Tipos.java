
package Tablas.TablaTipos;

import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Tipos {
    private Integer numeroElemento;
    private String nombre;
    private Integer ambito;
    private String conjuntoDatos;
    
    private String tipoBase;
    private String tipoElemento;

    public Tipos(Integer numeroElemento, String nombre, Integer ambito, String conjuntoDatos, String tipoBase, String tipoElemento) {
        this.numeroElemento = numeroElemento;
        this.nombre = nombre;
        this.ambito = ambito;
        this.conjuntoDatos = conjuntoDatos;
        this.tipoBase = tipoBase;
        this.tipoElemento = tipoElemento;
    }

    public Tipos(String nombre, Integer ambito, String conjuntoDatos, String tipoBase, String tipoElemento) {
        this.nombre = nombre;
        this.ambito = ambito;
        this.conjuntoDatos = conjuntoDatos;
        this.tipoBase = tipoBase;
        this.tipoElemento = tipoElemento;
    }
    
    
    
    
    
    

    public String getTipoBase() {
        return tipoBase;
    }

    public void setTipoBase(String tipoBase) {
        this.tipoBase = tipoBase;
    }

    public String getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(String tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    
   
    public String getConjuntoDatos() {
        return conjuntoDatos;
    }

    public void setConjuntoDatos(String conjuntoDatos) {
        this.conjuntoDatos = conjuntoDatos;
    }
    
    
    
    

    public Integer getNumeroElemento() {
        return numeroElemento;
    }

    public void setNumeroElemento(Integer numeroElemento) {
        this.numeroElemento = numeroElemento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Integer getAmbito() {
        return ambito;
    }

    public void setAmbito(Integer ambito) {
        this.ambito = ambito;
    }


    
    
    
}
