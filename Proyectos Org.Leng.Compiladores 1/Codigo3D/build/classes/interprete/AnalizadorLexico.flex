package codigo3d;

import static codigo3d.sym.*;
import java_cup.runtime.*;

%%

%public
%class Lexer
%cup
%cupdebug
%line
%column
//%type String //el valor retornado por cada lectura será del tipo Token

//caracteres y separadores
CARACTERES_ESP = [_]
//TERMINADOR_LINEA = \r|\n|\r\n
SEPARADORES = [ \r\t\b\f\n]

//SALTO = [\n]
IGUAL = "="
PARENT_A = "("
PARENT_C = ")"
SUMA = "+"
RESTA = "-"
MULT = "*"
PT_COMA =";"
NUMERO_ENTERO = 0 |[1-9][0-9]*

IDENTIFICADOR = ([:jletter:])([:jletterdigit:]|{CARACTERES_ESP})*


%{
	public String lexeme;
	public int linea;
	public int columna;
	public char c;
%}

%{
	private Symbol symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn+1);
	}

	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn+1, value);
	}

	private void error(String error, int linea, int columna) {
		String mensaje = "Se detecto un Error Lexico en la  Linea:" + linea + "  Columna: " + columna+"  El error:"+error;
		System.out.println(mensaje);
	}

	public Lexer (java.io.Reader entrada){
		this.zzReader = entrada;
	}
%}

%%

/* reglas lexicas */
<YYINITIAL> {

	{PT_COMA}
		{System.out.printf(" PUNTO Y COMA: %s\n", yytext()); return symbol(PT_COMA, yytext());}
	{PARENT_A}
		{System.out.printf(" PARENT_A: %s\n", yytext()); return symbol(PARENT_A, yytext());}
	{PARENT_C}
		{System.out.printf(" PARENT_C: %s\n", yytext()); return symbol(PARENT_C, yytext());}
	{SUMA}
		{System.out.printf(" SUMA: %s\n", yytext()); return symbol(SUMA, yytext());}
	{RESTA}
		{System.out.printf(" RESTA: %s\n", yytext()); return symbol(RESTA, yytext());}
	{MULT}
		{System.out.printf(" MULT: %s\n", yytext()); return symbol(MULT, yytext());}
	{IGUAL}
		{System.out.printf(" IGUAL: %s\n", yytext()); return symbol(IGUAL, yytext());}
	{NUMERO_ENTERO}
		{System.out.printf(" ENTERO: %s\n", yytext()); return symbol(NUMERO_ENTERO, new Integer(yytext()));}
	
	{IDENTIFICADOR}
		{System.out.printf(" IDENTIFICADOR: %s\n", yytext()); return symbol(IDENTIFICADOR, yytext());}

	{SEPARADORES}
	 	{/* los ignoramos */}
	
}

/* Error por cualquier otro simbolo SERIA TEXTO POR ESO NO A[PLICA ESTA REGLA*/ 
[^]    
		{ error(yytext(),yyline+1,yycolumn+1); return symbol(error, yytext());}

<<EOF>>
		{ return symbol(EOF); }