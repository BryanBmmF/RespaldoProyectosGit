/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.generadores;

import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.analizadores.simbolos.Token;
import practica1comp2.backend.expresiones.Expresion;

/**
 *
 * @author bryan
 */
public class Cuarteto {
   
    private Operador op;
    private Expresion result;
    private Expresion arg1;
    private Expresion arg2;
    
    public Cuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.op = op;
        this.result = result;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    
    public String imprimir3D(){
        String cod = "";
        switch (op) {
            case MAS:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"+"+arg2.getLugarTemp(); 
                break;
            case MENOS:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"-"+arg2.getLugarTemp(); 
                break;
            case POR:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"*"+arg2.getLugarTemp(); 
                break;
            case DIV:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"/"+arg2.getLugarTemp(); 
                break;
            case MOD:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"%"+arg2.getLugarTemp(); 
                break;
            case ASIG:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp(); 
                break;
            case ASIG_AR:
                cod =  arg2.getLugarTemp()+"["+result.getLugarTemp()+"]"+" = "+arg1.getLugarTemp(); 
                break;
            case ASIG_AR2:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"["+arg2.getLugarTemp()+"]";
                break;
            case DECL:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp(); 
                break;
            case ETIQ:
                cod = result.getLugarTemp()+" : "; 
                break;
            case IF_IGUAL:
                cod = " if ("+arg1.getLugarTemp()+ " == "+arg2.getLugarTemp() + ") goto "+result.getLugarTemp() ; 
		break;
            case IF_NOIGUAL:
                cod = " if ("+arg1.getLugarTemp()+ " != "+arg2.getLugarTemp() + ") goto "+result.getLugarTemp() ; 
		break;
            case IF_MAYOR:
                cod = " if ("+arg1.getLugarTemp()+ " > "+arg2.getLugarTemp() + ") goto "+result.getLugarTemp() ; 
		break;
            case IF_MAY_IGUAL:
                cod = " if ("+arg1.getLugarTemp()+ " >= "+arg2.getLugarTemp() + ") goto "+result.getLugarTemp() ; 
		break;
            case IF_MENOR:
                cod = " if ("+arg1.getLugarTemp()+ " < "+arg2.getLugarTemp() + ") goto "+result.getLugarTemp() ; 
		break;
            case IF_MEN_IGUAL:
                cod = " if ("+arg1.getLugarTemp()+ " <= "+arg2.getLugarTemp() + ") goto "+result.getLugarTemp() ; 
		break;
            case GOTO:
                cod = " goto "+result.getLugarTemp() ; 
		break;
            case PRINT:
                cod = " print "+result.getLugarTemp() ; 
		break;
            case PRINTLN:
                cod = " println "+result.getLugarTemp() ; 
		break;
            case RETURN:
                cod = " return "+result.getLugarTemp() ; 
		break;
            case CALL:
                cod = result.getLugarTemp()+"= call "+arg1.getLugarTemp()+" , "+arg2.getLugarTemp() ; 
		break;
            case PARAM:
                cod = "param "+result.getLugarTemp(); 
		break;
            case SCANN:
                cod = "scan "+result.getLugarTemp(); 
		break;
             case SCANS:
                cod = "scan "+result.getLugarTemp(); 
		break;
            default:
                //throw new AssertionError();//error en la generacin de codigo
        }
        return cod;
    }
   
    public String evaluarTipo3(String lleva, Tipo tipo3){
        String cod = "";
        if (tipo3!=null) {
            switch (tipo3.getTipo()) {
                case BOOLEAN:
                    cod = lleva+ "%d\", "+arg1.getLugarTemp()+","+arg2.getLugarTemp()+ ");";
                    break;
                case CHAR:
                    cod = lleva+ "%c\", "+arg1.getLugarTemp()+","+arg2.getLugarTemp()+ ");";
                    break;
                 case BYTE:
                    cod = lleva+ "%d\", "+arg1.getLugarTemp()+","+arg2.getLugarTemp()+ ");";
                    break;
                 case INT:
                    cod = lleva+ "%d\", "+arg1.getLugarTemp()+","+arg2.getLugarTemp()+ ");";
                    break;
                  case LONG:
                    cod = lleva+ "%ld\", "+arg1.getLugarTemp()+","+arg2.getLugarTemp()+ ");";
                    break;
                 case FLOAT:
                    cod = lleva+ "%.2f\", "+arg1.getLugarTemp()+","+arg2.getLugarTemp()+ ");";
                    break;
                 case DOUBLE:
                    cod = lleva+ "%.2lf\", "+arg1.getLugarTemp()+","+arg2.getLugarTemp()+ ");";
                    break;
                 case STRING:
                    cod = lleva+ "%s\", "+arg1.getLugarTemp()+","+arg2.getLugarTemp()+ ");";
                    break;
                default:
            }
            
        } else {
            cod = " sprintf("+result.getLugarTemp()+",\"%d%s\", "+arg1.getLugarTemp()+","+arg2.getLugarTemp()+ ");";
        }
        
        return cod;
    }
    public String evaluarTipo2(Tipo tipo2, Tipo tipo3){
        String cod = "";
        switch (tipo2.getTipo()) {
                case BOOLEAN:
                    cod = evaluarTipo3(" sprintf("+result.getLugarTemp()+",\"%d",tipo3);
                    break;
                case CHAR: 
                    cod = evaluarTipo3(" sprintf("+result.getLugarTemp()+",\"%c",tipo3);
                    break;
                 case BYTE: 
                    cod = evaluarTipo3(" sprintf("+result.getLugarTemp()+",\"%d",tipo3); 
                    break;
                 case INT: 
                    cod = evaluarTipo3(" sprintf("+result.getLugarTemp()+",\"%d",tipo3);
                    break;
                  case LONG: 
                    cod = evaluarTipo3(" sprintf("+result.getLugarTemp()+",\"%ld",tipo3);
                    break;
                 case FLOAT: 
                    cod = evaluarTipo3(" sprintf("+result.getLugarTemp()+",\"%.2f",tipo3);
                    break;
                 case DOUBLE:
                     cod = evaluarTipo3(" sprintf("+result.getLugarTemp()+",\"%.2lf",tipo3);
                    break;
                 case STRING:
                     cod = evaluarTipo3(" sprintf("+result.getLugarTemp()+",\"%s",tipo3);
                    break;
                default:
            }
        return cod;
    }
    
    public String evaluarTiposConcat(Tipo tipo2, Tipo tipo3){
        String cod = "";
        if (tipo2!=null) {
            cod = evaluarTipo2(tipo2, tipo3);
        } else {
            if (tipo3!=null) {
                cod = evaluarTipo3(" sprintf("+result.getLugarTemp()+",\"%s", tipo3);
            } else {
                cod = " sprintf("+result.getLugarTemp()+",\"%s%s\", "+arg1.getLugarTemp()+","+arg2.getLugarTemp()+ ");";
            }

        }
        return cod;
    }
    
    public String imprimirC(TablaSimbolos sym){
        Tipo tipo;
        String cod = "";
        switch (op) {
            case MAS:{
                //verificar el tipo de result
                tipo = result.getTipo();
                Tipo tipo2 = arg1.getTipo();
                Tipo tipo3 = arg2.getTipo();
                //Tipo tipo2 = sym.getTipo(new Token(arg1.getLugarTemp(), 0, 0));
                //Tipo tipo3 = sym.getTipo(new Token(arg2.getLugarTemp(), 0, 0));
                
                if (tipo.getTipo()==TipoVar.STRING) {
                    //verificar el tipo de arg1 y arg2
                    cod = evaluarTiposConcat(tipo2, tipo3);
                } else {
                    //declarar y asignar
                    cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"+"+arg2.getLugarTemp()+";"; 
                }
            }
                break;
            case MENOS:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"-"+arg2.getLugarTemp()+";"; 
                break;
            case POR:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"*"+arg2.getLugarTemp()+";"; 
                break;
            case DIV:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"/"+arg2.getLugarTemp()+";"; 
                break;
            case MOD:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"%"+arg2.getLugarTemp()+";"; 
                break;
            case ASIG: {
                //verificar el tipo de result
                tipo = result.getTipo();
                if (tipo.getTipo()==TipoVar.STRING) {
                    cod = " sprintf("+result.getLugarTemp()+",\"%s\", "+arg1.getLugarTemp()+");";
                } else {
                    cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+";"; 
                }
                
            }
                break;
            case ASIG_AR:
                cod =  arg2.getLugarTemp()+"["+result.getLugarTemp()+"]"+" = "+arg1.getLugarTemp()+";"; 
                break;
            case ASIG_AR2:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"["+arg2.getLugarTemp()+"]"+";";
                break;
            case DECL:
                cod = result.getLugarTemp()+" = "+arg1.getLugarTemp()+"; no se usa creo"; 
                break;
            case ETIQ:
                cod = result.getLugarTemp()+" : "; 
                break;
            case IF_IGUAL:
                //declarar args
                cod = " if ("+arg1.getLugarTemp()+ " == "+arg2.getLugarTemp() + ")\n"
                        + "     goto "+result.getLugarTemp() +";\n";
                        //+ " else "; 
		break;
            case IF_NOIGUAL:
                cod = " if ("+arg1.getLugarTemp()+ " != "+arg2.getLugarTemp() + ")\n"
                        + "     goto "+result.getLugarTemp() +";\n";
                        //+ " else "; 
		break;
            case IF_MAYOR:
                cod = " if ("+arg1.getLugarTemp()+ " > "+arg2.getLugarTemp() + ") \n"
                        + "     goto "+result.getLugarTemp() +";\n";
                        //+ " else ";  
		break;
            case IF_MAY_IGUAL:
                cod = " if ("+arg1.getLugarTemp()+ " >= "+arg2.getLugarTemp() + ") \n"
                        + "     goto "+result.getLugarTemp() +";\n";
                        //+ " else ";  
		break;
            case IF_MENOR:
                cod = " if ("+arg1.getLugarTemp()+ " < "+arg2.getLugarTemp() + ") \n"
                        + "     goto "+result.getLugarTemp() +";\n";
                        //+ " else ";  
		break;
            case IF_MEN_IGUAL:
                cod = " if ("+arg1.getLugarTemp()+ " <= "+arg2.getLugarTemp() + ")\n"
                        + "     goto "+result.getLugarTemp() +";\n";
                        //+ " else "; 
		break;
            case GOTO:
                cod = "     goto "+result.getLugarTemp()+";" ; 
		break;
            case PRINT:{
                //verificar el tipo de result
                tipo = result.getTipo();
                switch (tipo.getTipo()) {
                    case BOOLEAN:
                        cod = " printf(\"%d\", "+result.getLugarTemp()+ ");";
                        break;
                    case CHAR:
                        cod = " printf(\"%c\", "+result.getLugarTemp()+ ");";
                        break;
                     case BYTE:
                        cod = " printf(\"%d\", "+result.getLugarTemp()+ ");";
                        break;
                     case INT:
                        cod = " printf(\"%d\", "+result.getLugarTemp()+ ");";
                        break;
                      case LONG:
                        cod = " printf(\"%ld\", "+result.getLugarTemp()+ ");";
                        break;
                     case FLOAT:
                        cod = " printf(\"%.2f\", "+result.getLugarTemp()+ ");";
                        break;
                     case DOUBLE:
                        cod = " printf(\"%.2lf\", "+result.getLugarTemp()+ ");";
                        break;
                     case STRING:
                        cod = " printf(\"%s\", "+result.getLugarTemp()+ ");";
                        break;
                    default:
                }
                
            }
		break;
            case PRINTLN:{
                //verificar el tipo de result
                tipo = result.getTipo();
                //tipo = sym.buscarSimboloGlobal(result.getLugarTemp()).getTipo();
                switch (tipo.getTipo()) {
                    case BOOLEAN:
                        cod = " printf(\"%d\", "+result.getLugarTemp()+ ");";
                        cod +=" printf(\""+"\\n"+"\");";
                        break;
                    case CHAR:
                        cod = " printf(\"%c\", "+result.getLugarTemp()+ ");";
                        cod +=" printf(\""+"\\n"+"\");";
                        break;
                     case BYTE:
                        cod = " printf(\"%d\", "+result.getLugarTemp()+ ");";
                        break;
                     case INT:
                        cod = " printf(\"%i\", "+result.getLugarTemp()+ ");";
                        cod +=" printf(\""+"\\n"+"\");";
                        break;
                      case LONG:
                        cod = " printf(\"%ld\", "+result.getLugarTemp()+ ");";
                        cod +=" printf(\""+"\\n"+"\");";
                        break;
                     case FLOAT:
                        cod = " printf(\"%.2f\", "+result.getLugarTemp()+ ");";
                        cod +=" printf(\""+"\\n"+"\");";
                        break;
                     case DOUBLE:
                        cod = " printf(\"%.2lf\", "+result.getLugarTemp()+ ");";
                        cod +=" printf(\""+"\\n"+"\");";
                        break;
                     case STRING:
                        cod = " printf(\"%s\", "+result.getLugarTemp()+ ");";
                        cod +=" printf(\""+"\\n"+"\");";
                        break;
                    default:
                    }
                
            }
            break;
            case RETURN:
                cod = arg1.getLugarTemp()+" = "+result.getLugarTemp()+ ";"; 
		break;
            case CALL:
                cod = result.getLugarTemp()+"= "+arg1.getLugarTemp()+ ";";
		break;
            case SCANN:
                switch (result.getTipo().getTipo()) {
                        case BOOLEAN:
                            cod = "scanf(\"%d\",&" + result.getLugarTemp() + ");\n";
                        break;
                        case CHAR:
                            cod = "scanf(\"%c\",&" + result.getLugarTemp() + ");\n";
                            break;
                         case BYTE:
                            cod = "scanf(\"%d\",&" + result.getLugarTemp() + ");\n";
                            break;
                          case LONG:
                            cod = "scanf(\"%ld\",&" + result.getLugarTemp() + ");\n";
                            break;
                         case DOUBLE:
                            cod = "scanf(\"%lf\",&" + result.getLugarTemp() + ");\n";
                            break;
                        case INT:
                            cod = "scanf(\"%i\",&" + result.getLugarTemp() + ");\n";
                            break;
                        case FLOAT:
                            cod = "scanf(\"%f\",&" + result.getLugarTemp() + ");\n";
                            break;
                        default:
                            break;
                    }
                    break;
             case SCANS:
                cod = "scanf(\"%s\"," + result.getLugarTemp() + ");\n";
                break;
            default:
                //throw new AssertionError();//error en la generacin de codigo
        }
        return cod;
    }
    
    
    public void impEspecialArreglo(){
    
    }

    public Operador getOp() {
        return op;
    }

    public void setOp(Operador op) {
        this.op = op;
    }

    public Expresion getResult() {
        return result;
    }

    public void setResult(Expresion result) {
        this.result = result;
    }

    public Expresion getArg1() {
        return arg1;
    }

    public void setArg1(Expresion arg1) {
        this.arg1 = arg1;
    }

    public Expresion getArg2() {
        return arg2;
    }

    public void setArg2(Expresion arg2) {
        this.arg2 = arg2;
    }

    
    
}
