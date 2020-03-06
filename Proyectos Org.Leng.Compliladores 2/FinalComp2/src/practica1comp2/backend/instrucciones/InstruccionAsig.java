/*
 * Instruccion Asignacion
 */
package practica1comp2.backend.instrucciones;

import practica1comp2.backend.analizadores.simbolos.Id;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionAsig extends Instruccion implements GenerarCuarteto {
    private Id loc;
    private Expresion exp;

    public InstruccionAsig(Id loc, Expresion exp, GeneradorCod generador) {
        super(generador);
        this.loc = loc;
        this.exp = exp;
    }   
    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        if (loc.getEx().isIsPosArray()) {
                //cuartetos de la localizacion
                if (loc.getEx().getList()!=null) {
                    for(Cuarteto c: loc.getEx().getList()){
                        this.getGenerador().addCuarteto(c);
                    }
                }
                //agregando los cuartetos que trae exp
                if (exp.getList()!=null) {
                    for(Cuarteto c: exp.getList()){
                        this.getGenerador().addCuarteto(c);
                    }
                }
                
                //evaluando que se va asignar si solo es una exp o una loc de array
                if (exp.isIsPosArray()) {
                    //creando cuarteto de asignacion
                    String temp = this.getGenerador().getLugarTemp();
                    this.getGenerador().addCuarteto(new Cuarteto(op.ASIG_AR2, new Expresion(temp, loc.getEx().getTipo(), this.getGenerador()), new Expresion(exp.getIdArray().getId().getLexeme(), exp.getTipo(), this.getGenerador()), exp));
                    this.getGenerador().addCuarteto(new Cuarteto(this.getGenerador().getOp().ASIG_AR, loc.getEx(),
                            new Expresion(temp, exp.getTipo(), this.getGenerador()), new Expresion(loc.getEx().getIdArray().getId().getLexeme(), loc.getEx().getTipo(), this.getGenerador())));
                } else {
                    //creando cuarteto de asignacion
                    this.getGenerador().addCuarteto(new Cuarteto(this.getGenerador().getOp().ASIG_AR,loc.getEx(),
                            exp, new Expresion(loc.getEx().getIdArray().getId().getLexeme(), loc.getEx().getTipo(), this.getGenerador())));
                }
                
            } else {
                //agregando los cuartetos que trae exp
                if (exp.getList()!=null) {
                    for(Cuarteto c: exp.getList()){
                        this.getGenerador().addCuarteto(c);
                    }
                }
                //evaluando que se va asignar si solo es una exp o una loc de array
                if (exp.isIsPosArray()) {
                    //creando cuarteto de asignacion
                    String temp = this.getGenerador().getLugarTemp();
                    this.getGenerador().addCuarteto(new Cuarteto(op.ASIG_AR2, new Expresion(temp, loc.getEx().getTipo(), this.getGenerador()), new Expresion(exp.getIdArray().getId().getLexeme(), exp.getTipo(), this.getGenerador()), exp));
                    this.getGenerador().addCuarteto(new Cuarteto(op, result, new Expresion(temp, loc.getEx().getTipo(), this.getGenerador()), arg2));
                } else {
                    //creando cuarteto de asignacion
                    this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
                }
                
            }
        
            //salto a la proxima etiqueta ---demas Cod
            if (exp.isIsBoolean()) {
                this.getGenerador().addCuarteto(new Cuarteto(this.getGenerador().getOp().ETIQ, new Expresion(exp.getEtiq2().f(), exp.getTipo(), this.getGenerador()), null, null));
                
            }
    }

    @Override
    public void evaluar() {
            if (exp!=null) {
                if (exp.isIsBoolean()) {
                if (exp.getOp() == this.getGenerador().getOp().OR) {
                    exp.getList().add(new Cuarteto(Operador.ETIQ, new Expresion(exp.getEtiq1().v(), exp.getTipo(), this.getGenerador()), null, null));
                    exp.getList().add( new Cuarteto(Operador.ASIG, new Expresion(loc.getId().getLexeme(), exp.getTipo(), this.getGenerador()), new Expresion("1", exp.getTipo(), this.getGenerador()), null));    
                    exp.setLugarTemp(""+0);
                } else {
                    exp.getList().add(new Cuarteto(Operador.ETIQ, new Expresion(exp.getEtiq1().f(), exp.getTipo(), this.getGenerador()), null, null));
                    exp.getList().add( new Cuarteto(Operador.ASIG, new Expresion(loc.getId().getLexeme(), exp.getTipo(), this.getGenerador()), new Expresion("0", exp.getTipo(), this.getGenerador()), null));
                    exp.setLugarTemp(""+1);
                }
                if (exp.getEtiq2()==null) {
                    exp.iniciarEtiq2(exp.getEtiq1().v(), this.getGenerador().getNuevaEtiq());
                }
                exp.getList().add(new Cuarteto(Operador.GOTO, new Expresion(exp.getEtiq2().f(), exp.getTipo(), this.getGenerador()), null, null));
                exp.getList().add(new Cuarteto(Operador.ETIQ, new Expresion(exp.getEtiq2().v(), exp.getTipo(), this.getGenerador()), null, null));
                
                }
                generarCuarteto(Operador.ASIG, new Expresion(loc.getId().getLexeme(), exp.getTipo(), this.getGenerador()), exp, null);
            
            }
            
    }

    public Id getLoc() {
        return loc;
    }

    public void setLoc(Id loc) {
        this.loc = loc;
    }

    public Expresion getExp() {
        return exp;
    }

    public void setExp(Expresion exp) {
        this.exp = exp;
    }

    
    
    
    
}
