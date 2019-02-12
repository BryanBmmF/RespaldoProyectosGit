/* codigo de usuario */
package analizadorsintactico.backend;
import analizadorsintactico.backend.Token;
import analizadorsintactico.backend.Lexem;

%% //separador de area

/* opciones y declaraciones de jflex */

%class Lexer
%type Lexem //el valor retornado por cada lectura será del tipo Token
%line
%column

LETRA = [a-zA-Z]
DIGITO = [0-9]
DIGITO2 = [1-9]
SEPARADORES = [ \n\r\t]
CARACTERES_ENTRADA = [^\r\n]
CARACTERES_ENTRADA2 = [^\r\n\"]
TERMINADOR_LINEA = \r|\n|\r\n
DIAGONAL = "/"
GUION_BAJO = "_"
GUION = "-"
SIGNO_NEGATIVO = "-"
OPERADOR_SUMA = "+"
OPERADOR_PRODUCTO = "*"
PARENTESIS_IZQ = "("
PARENTESIS_DER = ")"
SIGNO_IGUAL = "="

//PALABRAS RESERVADAS
ESCRIBIR = "ESCRIBIR"
FIN = "FIN"
REPETIR = "REPETIR"
INICIAR = "INICIAR"
SI = "SI"
VERDADERO = "VERDADERO"
FALSO = "FALSO"
ENTONCES = "ENTONCES"
COMILLA_DOBLE = "\""

//SOLO ENTEROS Y ENTEROS NEGATIVOS
NUMERO_ENTERO = 0 | {DIGITO2}{DIGITO}*
NUMERO_NEGATIVO = {SIGNO_NEGATIVO}{DIGITO2}{DIGITO}*

//IDENTIFICADORES
IDENTIFICADOR = ({LETRA}|{GUION_BAJO})({LETRA}|{DIGITO}|{GUION_BAJO}|{GUION})*

//LITERALES
LITERAL = {COMILLA_DOBLE}{CARACTERES_ENTRADA2}*{COMILLA_DOBLE}

// COMENTARIO DE LINEA
COMENTARIO_LINEA = {DIAGONAL}{DIAGONAL}{CARACTERES_ENTRADA}*{TERMINADOR_LINEA}?


%{
 
    private Lexem lexem;

    public Lexem getLexem(){
    	return lexem;

    }

%}

%% // separador de areas

/* reglas lexicas */

<YYINITIAL>{ESCRIBIR} 	{lexem =new Lexem(yytext(),Token.ESCRIBIR,yyline+1,yycolumn+1); return lexem;}
<YYINITIAL>{FIN} 		{lexem =new Lexem(yytext(),Token.FIN,yyline+1,yycolumn+1); return lexem;}
<YYINITIAL>{REPETIR} 	{lexem =new Lexem(yytext(),Token.REPETIR,yyline+1,yycolumn+1); return lexem;}
<YYINITIAL>{INICIAR} 	{lexem =new Lexem(yytext(),Token.INICIAR,yyline+1,yycolumn+1); return lexem;}
<YYINITIAL>{SI} 		{lexem =new Lexem(yytext(),Token.SI,yyline+1,yycolumn+1); return lexem;}
<YYINITIAL>{VERDADERO} 	{lexem =new Lexem(yytext(),Token.VERDADERO,yyline+1,yycolumn+1); return lexem;}
<YYINITIAL>{FALSO} 		{lexem =new Lexem(yytext(),Token.FALSO,yyline+1,yycolumn+1); return lexem;}
<YYINITIAL>{ENTONCES} 	{lexem =new Lexem(yytext(),Token.ENTONCES,yyline+1,yycolumn+1); return lexem;}
<YYINITIAL> {
	{SEPARADORES} {/* ignoramos */}

	{NUMERO_ENTERO} 	{lexem =new Lexem(yytext(),Token.NUMERO,yyline+1,yycolumn+1); return lexem;}

	{NUMERO_NEGATIVO} 	{lexem =new Lexem(yytext(),Token.NUMERO_NEGATIVO,yyline+1,yycolumn+1); return lexem;}

	{IDENTIFICADOR} 	{lexem =new Lexem(yytext(),Token.IDENTIFICADOR,yyline+1,yycolumn+1); return lexem;}
	
	{LITERAL} 			{lexem =new Lexem(yytext(),Token.LITERAL,yyline+1,yycolumn+1); return lexem;}

	{COMENTARIO_LINEA} 	{lexem =new Lexem(yytext(),Token.COMENTARIO,yyline+1,yycolumn+1); return lexem;}

	{OPERADOR_SUMA} 	{lexem =new Lexem(yytext(),Token.SUMA,yyline+1,yycolumn+1); return lexem;}
	{OPERADOR_PRODUCTO} {lexem =new Lexem(yytext(),Token.MULTIPLICACION,yyline+1,yycolumn+1); return lexem;}
	{PARENTESIS_IZQ} 	{lexem =new Lexem(yytext(),Token.PARENTESIS_IZQUIERDO,yyline+1,yycolumn+1); return lexem;}
	{PARENTESIS_DER} 	{lexem =new Lexem(yytext(),Token.PARENTESIS_DERECHO,yyline+1,yycolumn+1); return lexem;}
	{SIGNO_IGUAL} 		{lexem =new Lexem(yytext(),Token.IGUAL,yyline+1,yycolumn+1); return lexem;}

}
[^] {lexem =new Lexem(yytext(),Token.ERROR,yyline+1,yycolumn+1); return lexem;}