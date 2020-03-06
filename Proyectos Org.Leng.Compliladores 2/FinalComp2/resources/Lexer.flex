package practica1comp2.backend.analizadores;

import java.util.ArrayList;
import java.util.List;
import static practica1comp2.backend.analizadores.sym.*;
import java_cup.runtime.*;
import practica1comp2.backend.analizadores.simbolos.Token;

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
SEPARADORES = [ \r\t\b\f\n]

//Tipos primitivos
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


//Op. Numericas
MAS = "+"
MENOS = "-" //tambien unario
POR = "*"
DIV = "/"
MOD = "%"

//Op. Booleanas
NOT = "NOT"
AND = "AND"
OR = "OR"
TRUE = "TRUE"
FALSE = "FALSE"

//Op. Relacionales
MAYOR = ">"
MENOR = "<"
MAYOR_I = ">="
MENOR_I = "<="
IGUAL = "=="
DISTINTO = "!="

//CARACTERES ESPECIALES DE INSTRUCCION/ASIGNACION
PARENT_A = "("
PARENT_C = ")"
//BLOQUES
CORCH_A = "["
CORCH_C = "]"

COMA = ","
PT_COMA =";" //SEPARADOR DE INSTRUCCIONES
DOS_PT = ":"
ASIGN = "<-"
COM = [\"]
PORCENT = "%%%"

//Numeros
//NUMERO_ENTERO = 0 |[-]?[1-9][0-9]* PROBLEMAS CON EL MENOS UNARIO
NUMERO_ENTERO = 0 |[1-9][0-9]*
NUMERO_FLOTANTE = ([0][.][0-9]+|[1-9][0-9]*[.][0-9]+)[f]? //poner f para float sino lo toma como double
//NUMERO_FLOTANTE = [-]?([0][.][0-9]+|[1-9][0-9]*[.][0-9]+)[f]? //poner f para float sino lo toma como double 

IDENTIFICADOR = ([:jletter:])([:jletterdigit:]|{CARACTERES_ESP})*

//RESERVADAS 
MAIN = "MAIN"
ARRAY = "ARRAY"
//AL NO ESPECIFICARSE UN BLOQUE EN UN CONTROL DE FLUJO SE TOMA LA INSTRUCCION SIGUIENTE
IF = "IF"
//END_IF = "END_IF"
ELSE = "ELSE"
ELSIF = "ELSIF"
WHILE = "WHILE"
DO = "DO"
FOR = "FOR"
PRINT = "PRINT"
PRINTLN = "PRINTLN"
SCANS = "SCANS"
SCANN = "SCANN"

//cadenas de caracteres
STRINGS = [^\"\n]
//CARACTERES_ENTRADA2 = [^\r\n\"]
CADENA = {COM}{STRINGS}*{COM}

//COMENTARIOS
COMENTARIO_LINEA = "--"[^\n]*
COMENTARIO_BLOQUE = "<!--"[^"-->"]*"-->"

%{

	private List<String> errorsList;
%}

%{
	private Symbol symbol(int type) {
        String lexeme = yytext();
        System.out.printf("Token tipo %d, lexeme %s, en linea %d, columna %d\n", type, lexeme == null ? "" : lexeme, yyline + 1, yycolumn + 1);
        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1));
    }

    private Symbol symbol(int type, String lexeme) {
        System.out.printf("Token tipo %d, lexeme %s, en linea %d, columna %d\n", type, lexeme == null ? "" : lexeme, yyline + 1, yycolumn + 1);
        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1));
    }

    private void error(String lexeme) {
        System.out.printf("Error Lexico en el Texto: %s  linea %d,  columna %d. \n", lexeme, yyline + 1, yycolumn + 1);
            errorsList.add(String.format("Error Lexico en el Texto: %s  linea %d, columna %d. Corrige e intenta de nuevo.", lexeme, yyline + 1, yycolumn + 1));
    }
    public List<String> getErrorsList() {
        return errorsList;
    }
%}
%init{
    errorsList = new ArrayList<>();
%init}

%%

/* reglas lexicas */
<YYINITIAL> {

	{COMA}
		{System.out.printf(" COMA: %s\n", yytext()); return symbol(COMA, yytext());}
	{PT_COMA}
		{System.out.printf(" PUNTO Y COMA: %s\n", yytext()); return symbol(PT_COMA, yytext());}
	{DOS_PT}
		{System.out.printf(" DOS_PT: %s\n", yytext()); return symbol(DOS_PT, yytext());}
	{PORCENT}
		{System.out.printf(" PORCENTAJES: %s\n", yytext()); return symbol(PORCENT, yytext());}
	//{COM}
	//	{System.out.printf(" COMILLAS: %s\n", yytext()); return symbol(COM, yytext());}
	{PARENT_A}
		{System.out.printf(" PARENT_A: %s\n", yytext()); return symbol(PARENT_A, yytext());}
	{PARENT_C}
		{System.out.printf(" PARENT_C: %s\n", yytext()); return symbol(PARENT_C, yytext());}
	{CORCH_A}
		{System.out.printf(" CORCH_A: %s\n", yytext()); return symbol(CORCH_A, yytext());}
	{CORCH_C}
		{System.out.printf(" CORCH_C: %s\n", yytext()); return symbol(CORCH_C, yytext());}
	{MAYOR}
		{System.out.printf(" MAYOR QUE: %s\n", yytext()); return symbol(MAYOR, yytext());}
	{MENOR}
		{System.out.printf(" MENOR QUE: %s\n", yytext()); return symbol(MENOR, yytext());}
	{MAYOR_I}
		{System.out.printf(" MAYOR_I: %s\n", yytext()); return symbol(MAYOR_I, yytext());}
	{MENOR_I}
		{System.out.printf(" MENOR_I: %s\n", yytext()); return symbol(MENOR_I, yytext());}
	{DISTINTO}
		{System.out.printf(" DISTINTO: %s\n", yytext()); return symbol(DISTINTO, yytext());}
	{IGUAL}
		{System.out.printf(" IGUAL: %s\n", yytext()); return symbol(IGUAL, yytext());}
	{NOT}
		{System.out.printf(" NOT: %s\n", yytext()); return symbol(NOT, yytext());}
	{AND}
		{System.out.printf(" AND: %s\n", yytext()); return symbol(AND, yytext());}
	{OR}
		{System.out.printf(" OR: %s\n", yytext()); return symbol(OR, yytext());}
	{TRUE}
		{System.out.printf(" TRUE: %s\n", yytext()); return symbol(TRUE, yytext());}
	{FALSE}
		{System.out.printf(" FALSE: %s\n", yytext()); return symbol(FALSE, yytext());}
	{MAS}
		{System.out.printf(" MAS: %s\n", yytext()); return symbol(MAS, yytext());}
	{MENOS}
		{System.out.printf(" MENOS: %s\n", yytext()); return symbol(MENOS, yytext());}
	{POR}
		{System.out.printf(" POR: %s\n", yytext()); return symbol(POR, yytext());}
	{DIV}
		{System.out.printf(" DIV: %s\n", yytext()); return symbol(DIV, yytext());}
	{MOD}
		{System.out.printf(" MOD: %s\n", yytext()); return symbol(MOD, yytext());}
	{BOOLEAN}
		{System.out.printf(" BOOLEAN: %s\n", yytext()); return symbol(BOOLEAN, yytext());}
	{CHAR}
		{System.out.printf(" CHAR: %s\n", yytext()); return symbol(CHAR, yytext());}
	{LONG}
		{System.out.printf(" LONG: %s\n", yytext()); return symbol(LONG, yytext());}
	{INT}
		{System.out.printf(" INT: %s\n", yytext()); return symbol(INT, yytext());}
	{BYTE}
		{System.out.printf(" BYTE: %s\n", yytext()); return symbol(BYTE, yytext());}
	{DOUBLE}
		{System.out.printf(" DOUBLE: %s\n", yytext()); return symbol(DOUBLE, yytext());}
	{FLOAT}
		{System.out.printf(" FLOAT: %s\n", yytext()); return symbol(FLOAT, yytext());}
	{STRING}
		{System.out.printf(" STRING: %s\n", yytext()); return symbol(STRING, yytext());}
	{VOID}
		{System.out.printf(" VOID: %s\n", yytext()); return symbol(VOID, yytext());}
	{RETURN}
		{System.out.printf(" RETURN: %s\n", yytext()); return symbol(RETURN, yytext());}
	{ASIGN}
		{System.out.printf(" ASIGN: %s\n", yytext()); return symbol(ASIGN, yytext());}
	{MAIN}
		{System.out.printf(" MAIN: %s\n", yytext()); return symbol(MAIN, yytext());}
	{ARRAY}
		{System.out.printf(" ARRAY: %s\n", yytext()); return symbol(ARRAY, yytext());}
	{IF}
		{System.out.printf(" IF: %s\n", yytext()); return symbol(IF, yytext());}
	//{END_IF}
	//	{System.out.printf(" IF: %s\n", yytext()); return symbol(END_IF, yytext());}
	{ELSIF}
		{System.out.printf(" ELSIF: %s\n", yytext()); return symbol(ELSIF, yytext());}
	{ELSE}
		{System.out.printf(" ELSE: %s\n", yytext()); return symbol(ELSE, yytext());}
	{WHILE}
		{System.out.printf(" WHILE: %s\n", yytext()); return symbol(WHILE, yytext());}
	{DO}
		{System.out.printf(" DO: %s\n", yytext()); return symbol(DO, yytext());}
	{FOR}
		{System.out.printf(" FOR: %s\n", yytext()); return symbol(FOR, yytext());}
	{PRINT}
		{System.out.printf(" PRINT: %s\n", yytext()); return symbol(PRINT, yytext());}
	{PRINTLN}
		{System.out.printf(" PRINTL: %s\n", yytext()); return symbol(PRINTLN, yytext());}
	{SCANS}
		{System.out.printf(" SCANS: %s\n", yytext()); return symbol(SCANS, yytext());}
	{SCANN}
		{System.out.printf(" SCANN: %s\n", yytext()); return symbol(SCANN, yytext());}
	{NUMERO_ENTERO}
		{System.out.printf(" ENTERO: %s\n", yytext()); return symbol(NUMERO_ENTERO, yytext());}
	{NUMERO_FLOTANTE}
		{System.out.printf(" NUMERO_FLOTANTE: %s\n", yytext()); return symbol(NUMERO_FLOTANTE, yytext());}
	{IDENTIFICADOR}
		{System.out.printf(" IDENTIFICADOR: %s\n", yytext()); return symbol(IDENTIFICADOR, yytext());}
	{CADENA}
		{System.out.printf(" CADENA: %s\n", yytext()); return symbol(CADENA, yytext());}
	{COMENTARIO_LINEA}
		{System.out.printf(" COMENTARIO_LINEA: %s\n", yytext());}
	{COMENTARIO_BLOQUE}
		{System.out.printf(" COMENTARIO_BLOQUE: %s\n", yytext());}


	{SEPARADORES}
	 	{/* los ignoramos */}
	
}

/* Error por cualquier otro simbolo SERIA TEXTO POR ESO NO A[PLICA ESTA REGLA*/ 
[^]    
		{ error(yytext()); return symbol(error, yytext());}

<<EOF>>
		{ return symbol(EOF); }

		// un string : COM STRINGS COM
		// o mejor capturarlo con comillas para no tener clavos 