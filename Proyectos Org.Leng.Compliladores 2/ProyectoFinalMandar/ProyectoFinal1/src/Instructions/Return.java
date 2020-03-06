/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instructions;

import CErrores.CErrores;
import Objetos.Cuarteto;
import Objetos.Expresion;
import Objetos.Logica;
import Objetos.Token;
import Tablas.TablaSimbolos.Simbolos;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import Valores.Temporales;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Return implements Instruction {
    private Logica logica = new Logica();
    private Expresion expresion;
    private TablaSimbolos tablaSimbolos;
    private TablaTipos tablaTipos;
    private String tipoReturn;
    private Token token;
    private Integer ambito;
    
    private String tSalida;
    private String etSalida;
    private String valorFuncion = "";

    public Return(Expresion expresion, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos, Token token) {
        this.expresion = expresion;
        this.tablaSimbolos = tablaSimbolos;
        this.tablaTipos = tablaTipos;
        this.token = token;
    }

    public String getTipoReturn() {
        return tipoReturn;
    }

    public void setTipoReturn(String tipoReturn) {
        this.tipoReturn = tipoReturn;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    public String gettSalida() {
        return tSalida;
    }

    public Logica getLogica() {
        return logica;
    }

    public void setLogica(Logica logica) {
        this.logica = logica;
    }

    public Integer getAmbito() {
        return ambito;
    }

    public void setAmbito(Integer ambito) {
        this.ambito = ambito;
    }

    public String getEtSalida() {
        return etSalida;
    }

    public void setEtSalida(String etSalida) {
        this.etSalida = etSalida;
    }

    
    public void settSalida(String tSalida) {
        this.tSalida = tSalida;
    }
    
    

    @Override
    public void setAmbit(int ambito) {
        this.expresion.asignarAmbito(ambito);
        this.ambito =ambito;
    }
    
    @Override
    public void asignarValorFuncion(String idFuncion) {
        this.expresion.asignarValorFuncion(idFuncion);
        this.valorFuncion = idFuncion;
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }

    public void setTablaSimbolos(TablaSimbolos tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
    }

    public TablaTipos getTablaTipos() {
        return tablaTipos;
    }

    public void setTablaTipos(TablaTipos tablaTipos) {
        this.tablaTipos = tablaTipos;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public boolean validate() {
        String valor = expresion.validarClases(tablaSimbolos, tablaTipos);
        if (valor != null) {
            if (logica.validarDosDatosParametros(tipoReturn,valor , tablaTipos)) {
                return true;
            } else {
                CErrores.agregarError("SEMANTICO", "RETURN", null, null, null,
                    token.getLine(), token.getColumn(),
                    "PROBLEMAS EN LA SENTENCIA RETURN, EL TIPO DE RETURN TIENE QUE SER: "+tipoReturn+", EL QUE SE ESTA PONIENDO ES DE TIPO: "+valor);
                return false;
            }
        } else {
            CErrores.agregarError("SEMANTICO", "RETURN", null, null, null,
                    token.getLine(), token.getColumn(),
                    "PROBLEMAS EN LA SENTENCIA RETURN");

            return false;
        }
    }

    @Override
    public List<Cuarteto> execute() {
        List<Cuarteto> lista = new ArrayList<>();
        lista = expresion.execute();
        String val = logica.returnUltimoTemporalExpresionValorT(lista);
        Cuarteto cuarteto = Cuarteto.MakeOperacionIgualAsignacion(tSalida, val,"",tipoReturn,tipoReturn);
        cuarteto.setMostrarC(false);
        lista.add(cuarteto);
        lista.add(Cuarteto.MakeReturn(tSalida,val,etSalida));     
        
        if(!valorFuncion.equals("")){
        lista.add(Cuarteto.MakeReturnCodigoC(tSalida,val));
        
        Simbolos sim = tablaSimbolos.getSimbolFuncion(valorFuncion);
        String etiqueta = sim.getEtSalida();
        lista.add(Cuarteto.MakeGotoSalidaC(etiqueta));
        }
        return lista;
    }

    @Override
    public boolean asignarReturn(String tipo,String tSalida) {
        return true;
    }

    

}
