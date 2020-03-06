/* codigo de usuario */
package Analizadores.Flex;

import java.util.ArrayList;
import java_cup.runtime.Symbol;
import Analizadores.Cup.sym;
//import Objetos.Logica;
import javax.swing.JTextArea;
import Objetos.Token;
import CErrores.CErrores;

%% //separador de area



 /* opciones y declaraciones de jflex */

%class Lexer
%public
%cup
%cupdebug
%line
%column

%state STRING
%state COMENTARIO_LINEA
%state COMENTARIO_BLOQUE


WhiteSpace = [\r|\n|\r\n] | [ \t\f]
SaltoLinea = [\n]



BOOLEAN = "boolean"
CHAR = "char"
BYTE = "byte"
INT = "int"
LONG = "long"
FLOAT = "float"
DOUBLE = "double"
STRING = "string"
VOID = "void"
RETURN = "return"
MAIN = "MAIN"

ARRAY = "ARRAY"




PUNTO_COMA = ";"
COMA = ","
PUNTO = "."
DOS_PUNTOS = ":"

ASIGNACION = "<-"
COMILLA = "\""


SUMA = "+"
RESTA = "-"
MULTIPLICACION = "*"
DIVISION = "/"
MODULO = "%"
SEPARADOR = "\%\%\%"


NOT = "NOT"
AND = "AND"
OR = "OR"

TRUEE = "TRUE"
FALSEE = "FALSE"

IF = "IF"
ELSIF = "ELSIF"
ELSE = "ELSE"
WHILE = "WHILE"
DO = "DO"
FOR = "FOR"
PRINT = "PRINT"
PRINTLN = "PRINTLN"
SCANS = "SCANS"
SCANN = "SCANN"



PARENTESIS_ABIERTO = "("
PARENTESIS_CERRADO = ")"
CORCHETE_ABIERTO = "["
CORCHETE_CERRADO = "]"

MENOR = "<"
MAYOR = ">"
MENOR_IGUAL = "<="
MAYOR_IGUAL = ">="
DIFERENTE = "!="
IGUAL = "=="
GUION_BAJO = "_"
DOLAR = "$"

COMENTARIO_LINEA = "--"
INICIO_COMENTARIO_BLOQUE = "<!--"
FIN_COMENTARIO_BLOQUE = "-->"

NUMERO = [0-9]
NUMERO_SIN_CERO = [1-9]
LETRA = [a-zA-Z]
F_ = [fF]

IDD =    ({LETRA}|{GUION_BAJO}|{DOLAR})({LETRA}|{NUMERO}|{GUION_BAJO}|{DOLAR})*
NUMERO_ENTERO = ({NUMERO_SIN_CERO}({NUMERO})* | "0")
NUMERO_DOUBLE = ({NUMERO_SIN_CERO}({NUMERO})* | "0") {PUNTO} ({NUMERO}|{NUMERO_SIN_CERO})+
NUMERO_FLOAT =  ({NUMERO_SIN_CERO}({NUMERO})* | "0")  ({PUNTO} ({NUMERO}|{NUMERO_SIN_CERO})+ )? ({F_}) 

%{

	String lexema = "";
	String lexemaError = "";

	String lexemaMandar = "";
        ArrayList<CErrores> errores;
        JTextArea area;

	public Lexer(java.io.Reader in,JTextArea area,ArrayList<CErrores> errores) {
    		this.zzReader = in;
		this.area=area;
                this.errores = errores;
		this.area=area;


  	}
  	
  	
  	

	public void crearLexema(String mandar){
		lexema = lexema+mandar;	
	}
	public void crearLexemaMandar(String mandar){
		lexemaMandar = lexemaMandar+mandar;	
	}
	public void crearLexemaError(String mandar){
		lexemaError = lexemaError+ mandar;
	}
	public void verificarError(){
		if(!lexemaError.equals("")){
			error(lexemaError);
		}
		lexemaError="";
	}
	

  
	private Symbol symbol(int type) {
        String lexeme = yytext();

        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1));
    }

    private Symbol symbol(int type, String lexeme) {
	this.lexema="";
        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1));
    }


  private void error(String message) {
      System.out.println("\nError Lexico en Fila: " + (yyline + 1) + ", columna " + (yycolumn + 1) + " : " + message + "\n");
        
  }

%}



%% /* separador de areas*/

/* reglas lexicas */
<YYINITIAL> {
{WhiteSpace} {verificarError();}

{COMENTARIO_LINEA} {verificarError();yybegin(COMENTARIO_LINEA);}
{INICIO_COMENTARIO_BLOQUE} {verificarError();yybegin(COMENTARIO_BLOQUE);} 
{COMILLA} {yybegin(STRING);}

{TRUEE} {verificarError(); return symbol(sym.BOOLEANO,yytext());}
{FALSEE} {verificarError();return symbol(sym.BOOLEANO,yytext());}

{BOOLEAN} {verificarError();return symbol(sym.BOOLEAN);}
{CHAR} {verificarError();return symbol(sym.CHAR);}
{BYTE} {verificarError();return symbol(sym.BYTE);}
{INT} {verificarError();return symbol(sym.INT);}
{LONG} {verificarError();return symbol(sym.LONG);}
{FLOAT} {verificarError();return symbol(sym.FLOAT);}
{DOUBLE} {verificarError();return symbol(sym.DOUBLE);}
{STRING} {verificarError();return symbol(sym.STRING);}
{VOID} {verificarError();return symbol(sym.VOID);}
{RETURN} {verificarError();return symbol(sym.RETURN);}
{MAIN} {verificarError();return symbol(sym.MAIN);}
{ARRAY} {verificarError();return symbol(sym.ARRAY,yytext());}


{COMA} {verificarError();return symbol(sym.COMA);}
{PUNTO_COMA} {verificarError();return symbol(sym.PUNTO_COMA);}
{DOS_PUNTOS} {verificarError();return symbol(sym.DOS_PUNTOS);}
{ASIGNACION} {verificarError();return symbol(sym.ASIGNACION);}


{SUMA} {verificarError();return symbol(sym.SUMA);}
{RESTA} {verificarError();return symbol(sym.RESTA);}
{MULTIPLICACION} {verificarError();return symbol(sym.MULTIPLICACION);}
{DIVISION} {verificarError();return symbol(sym.DIVISION);}
{MODULO} {verificarError();return symbol(sym.MODULO);}
{SEPARADOR} {verificarError();return symbol(sym.SEPARADOR);}
 

{NOT} {verificarError();return symbol(sym.NOT);}
{AND} {verificarError();return symbol(sym.AND);}
{OR} {verificarError();return symbol(sym.OR);}

{IF} {verificarError();return symbol(sym.IF);}
{ELSIF} {verificarError();return symbol(sym.ELSIF);}
{ELSE} {verificarError();return symbol(sym.ELSE);}
{WHILE} {verificarError();return symbol(sym.WHILE);}
{DO} {verificarError();return symbol(sym.DO);}
{FOR} {verificarError();return symbol(sym.FOR);}
{PRINT} {verificarError();return symbol(sym.PRINT);}
{PRINTLN} {verificarError();return symbol(sym.PRINTLN);}
{SCANS} {verificarError();return symbol(sym.SCANS);}
{SCANN} {verificarError();return symbol(sym.SCANN);}



{PARENTESIS_ABIERTO} {verificarError();return symbol(sym.PARENTESIS_ABIERTO);}
{PARENTESIS_CERRADO} {verificarError();return symbol(sym.PARENTESIS_CERRADO);}
{CORCHETE_ABIERTO} {verificarError();return symbol(sym.CORCHETE_ABIERTO);}
{CORCHETE_CERRADO} {verificarError();return symbol(sym.CORCHETE_CERRADO);}


{MENOR} {verificarError();return symbol(sym.MENOR);}
{MAYOR} {verificarError();return symbol(sym.MAYOR);}
{MENOR_IGUAL} {verificarError();return symbol(sym.MENOR_IGUAL);}
{MAYOR_IGUAL} {verificarError();return symbol(sym.MAYOR_IGUAL);}
{DIFERENTE} {verificarError();return symbol(sym.DIFERENTE);}
{IGUAL} {verificarError();return symbol(sym.IGUAL);}


{IDD} {verificarError();return symbol(sym.IDD,yytext());}
{NUMERO_DOUBLE} {verificarError();return symbol(sym.NUMERO_DOUBLE,yytext());}
{NUMERO_FLOAT} {verificarError();return symbol(sym.NUMERO_FLOAT,yytext());}


{NUMERO_ENTERO} {
					verificarError(); 
					int tipoDato = 0;
					try{
						long numero = Long.parseLong(yytext());
						tipoDato=1;
						int  numero2 = Integer.parseInt(yytext());
						tipoDato=2;
						byte numero3 = Byte.parseByte(yytext());
						tipoDato=3;
						return symbol(sym.NUMERO_BYTE,yytext());
        			}catch(Exception e){
        				if(tipoDato==1){
							return symbol(sym.NUMERO_LONG,yytext());
        				}else if(tipoDato==2){
        					return symbol(sym.NUMERO_ENTERO,yytext());
        				}else if(tipoDato==3){
        					return symbol(sym.NUMERO_BYTE,yytext());
        				}else{
        					error("EL NUMERO NO PERTENECE A NINGUN CAMPO DE NUMEROS, NI A BYTE, NI A INT, NI A LONG");
        				}
        			}
        			
						
	
        			

	}
}

<STRING> {
{COMILLA} {yybegin(YYINITIAL);return symbol(sym.LEX_STRING,"\""+this.lexema+"\"");}
[^]              {crearLexema(yytext());}  
}


<COMENTARIO_LINEA>{ 
{SaltoLinea}  {verificarError();yybegin(YYINITIAL);}
[^] {verificarError();}
}

<COMENTARIO_BLOQUE>{
{FIN_COMENTARIO_BLOQUE} {verificarError();yybegin(YYINITIAL);}
[^] {verificarError();}
}


[^]                     {crearLexemaError(yytext());}
<<EOF>>                 {return symbol(sym.EOF);}

/*



*/

