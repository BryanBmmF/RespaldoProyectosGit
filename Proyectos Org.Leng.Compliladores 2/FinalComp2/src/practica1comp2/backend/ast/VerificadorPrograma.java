/*
 
 */
package practica1comp2.backend.ast;

import practica1comp2.backend.instrucciones.Instruccion;

/**
 *
 * @author bryan
 */
public class VerificadorPrograma {
    private Ast ast;

    public VerificadorPrograma(Ast ast) {
        this.ast = ast;
    }
    
    public void verificar(){
        /*programas completo*/
        if (ast.getDeclaracionesGlobal()!=null && ast.getSubProgramas()!=null) {
            //evaluando declaraciones, evaluando subprogramas y evaluando instrucciones main
            evaluarDeclaraciones();
            //evaluarSubprogramas();
            evaluarMain();
            evaluarSubprogramas();
        /*sin subprogramas*/    
        } else if (ast.getSubProgramas()==null && ast.getDeclaracionesGlobal()!=null) {
                evaluarDeclaraciones();
                evaluarMain();
        /*sin declaraciones*/ 
        } else if (ast.getSubProgramas()!=null && ast.getDeclaracionesGlobal()==null) {
                //evaluarSubprogramas();
                evaluarMain();
                evaluarSubprogramas();
        /*solo main*/
        } else {
               evaluarMain(); 
        }
        
    }
    
    public void evaluarDeclaraciones(){
        if (!ast.getDeclaracionesGlobal().isEmpty()) {
            for(Instruccion declaracion : ast.getDeclaracionesGlobal()){
                   if (declaracion!=null) {
                       System.out.println("--NUEVA DECLARACION");
                       declaracion.evaluar();
                }
            }
        }
    
    }
    
    public void evaluarSubprogramas(){
        if (!ast.getSubProgramas().isEmpty()) {
            for(Instruccion sub : ast.getSubProgramas()){
                   if (sub!=null) {
                       System.out.println("**NUEVO SUBPROGRAMA");
                       sub.evaluar(); /*no se deven evaluar ya que el codigo sera incrustado en cada llamada*/
                }
            }
        }
    
    }
    
    public void evaluarMain(){
        if (ast.getInstruccionesMain().getInstrucciones()!=null) {
            ast.getInstruccionesMain().evaluar();
        }

    }
    
}
