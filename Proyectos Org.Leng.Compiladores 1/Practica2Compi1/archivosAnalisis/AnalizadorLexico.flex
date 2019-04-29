package practica2compi1;

import static practica2compi1.sym.error;
import java_cup.runtime.*;
import javax.swing.JTextArea;

%%

%public
%class Lexer
%cup
%cupdebug
%line
%column
//%type String //el valor retornado por cada lectura será del tipo Token
//alfabeto separado
A_=[Aa]
B_=[Bb]
C_=[Cc]
D_=[Dd]
E_=[Ee]
F_=[Ff]
G_=[Gg]
H_=[Hh]
I_=[Ii]
//J_=[Jj]
K_=[Kk]
L_=[Ll]
//M_=[Mm]
N_=[Nn]
O_=[Oo]
P_=[Pp]
//Q_=[Qq]
R_=[Rr]
S_=[Ss]
T_=[Tt]
U_=[Uu]
//V_=[Vv]
W_=[Ww]
X_=[Xx]
Y_=[Yy]
//Z_=[Zz]

//caracteres y separadores
CARACTERES_ESP = [-_$]
TERMINADOR_LINEA = \r|\n|\r\n
SEPARADORES = [ \r\t\b\f]

SALTO = [\n]
IGUAL = "="
CORCHETE_A = "["
CORCHETE_C = "]"
PARENT_A = "("
PARENT_C = ")"
NUMERAL = "#"
SUMA = "+"
RESTA = "-"
MULT = "*"
DIV = "/"
CARACTERES_ENTRADA = [^\r\n\f\b]

//palabras reservadas para etiquetas CASE SENSIVITE
FORWARD = {F_}{O_}{R_}{W_}{A_}{R_}{D_}|{F_}{D_}
BACKWARD = {B_}{A_}{C_}{K_}{W_}{A_}{R_}{D_}|{B_}{K_}
RIGHT = {R_}{I_}{G_}{H_}{T_}|{R_}{T_}
LEFT = {L_}{E_}{F_}{T_}|{L_}{T_}
CLEARS = {C_}{L_}{E_}{A_}{R_}{S_}|{C_}{S_}
PEN_UP = {P_}{E_}{N_}{U_}{P_}|{P_}{U_}
PEN_DOWN = {P_}{E_}{N_}{D_}{O_}{W_}{N_}|{P_}{D_}
TO_CENTER = {T_}{O_}{C_}{E_}{N_}{T_}{E_}{R_}|{C_}{R_}
COLOR = {C_}{O_}{L_}{O_}{R_}
POSITION_XY = {P_}{O_}{S_}{I_}{T_}{I_}{O_}{N_}{X_}{Y_}|{P_}{O_}{S_}{X_}{Y_}
POSITION_X = {P_}{O_}{S_}{I_}{T_}{I_}{O_}{N_}{X_}|{P_}{O_}{S_}{X_}
POSITION_Y = {P_}{O_}{S_}{I_}{T_}{I_}{O_}{N_}{Y_}|{P_}{O_}{S_}{Y_}
HIDE_TURTLE = {H_}{I_}{D_}{E_}{T_}{U_}{R_}{T_}{L_}{E_}|{H_}{T_}
SHOW_TURTLE = {S_}{H_}{O_}{W_}{T_}{U_}{R_}{T_}{L_}{E_}|{S_}{T_}
TO_ERASE = {T_}{O_}{E_}{R_}{A_}{S_}{E_}|{T_}{E_}
TO_DRAW = {T_}{O_}{D_}{R_}{A_}{W_}|{T_}{D_}
REPEAT = {R_}{E_}{P_}{E_}{A_}{T_}

//VARIABLES
DOS_PT =":"
COMA =","
IDENTIFICADOR = ([:jletterdigit:]|{CARACTERES_ESP})+
VARIABLE = {DOS_PT}{IDENTIFICADOR}

CODIGO_COLOR = ({NUMERAL}[:jletterdigit:][:jletterdigit:][:jletterdigit:][:jletterdigit:][:jletterdigit:][:jletterdigit:])
NUMERO_ENTERO = 0 |[1-9][0-9]*
// COMENTARIO DE LINEA
COMENTARIO_LINEA = {NUMERAL}{CARACTERES_ENTRADA}*{TERMINADOR_LINEA}?

%{
	public String lexeme;
	public int linea;
	public int columna;
	public char c;
%}

%{
	JTextArea textArea;

	private Symbol symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn+1);
	}

	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn+1, value);
	}

	private void error(String error, int linea, int columna) {
		String mensaje = "Se detecto un Error Lexico en la  Linea:" + linea + "  Columna: " + columna+"  El error:"+error;
		System.out.println(mensaje);
		this.textArea.append("\n" + mensaje);
	}

	public Lexer (java.io.Reader entrada, JTextArea textArea) {
		this.zzReader = entrada;
		this.textArea = textArea;
	}
%}

%%

/* reglas lexicas */
<YYINITIAL> {
	{CORCHETE_A}
		{System.out.printf(" CORCHETE_A: %s\n", yytext()); return symbol(CORCHETE_A, yytext());}
	{CORCHETE_C}
		{System.out.printf(" CORCHETE_C: %s\n", yytext()); return symbol(CORCHETE_C, yytext());}
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
	{DIV}
		{System.out.printf(" DIV: %s\n", yytext()); return symbol(DIV, yytext());}
	{IGUAL}
		{System.out.printf(" IGUAL: %s\n", yytext()); return symbol(IGUAL, yytext());}
	{COMA}
		{System.out.printf(" COMA: %s\n", yytext()); return symbol(COMA, yytext());}
	{FORWARD}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(FORWARD, yytext());}
	{BACKWARD}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(BACKWARD, yytext());}
	{RIGHT}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(RIGHT, yytext());}
	{LEFT}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(LEFT, yytext());}
	{CLEARS}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(CLEARS, yytext());}
	{PEN_UP}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(PEN_UP, yytext());}
	{PEN_DOWN}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(PEN_DOWN, yytext());}
	{TO_CENTER}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(TO_CENTER, yytext());}
	{COLOR}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(COLOR, yytext());}
	{POSITION_XY}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(POSITION_XY, yytext());}
	{POSITION_X}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(POSITION_X, yytext());}
	{POSITION_Y}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(POSITION_Y, yytext());}
	{HIDE_TURTLE}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(HIDE_TURTLE, yytext());}
	{SHOW_TURTLE}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(SHOW_TURTLE, yytext());}
    {TO_ERASE}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(TO_ERASE, yytext());}
	{TO_DRAW}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(TO_DRAW, yytext());}
	{REPEAT}
		{System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(REPEAT, yytext());}
	{VARIABLE}
		{System.out.printf(" VARIABLE: %s\n", yytext()); return symbol(VARIABLE, yytext());}
	{CODIGO_COLOR}
		{System.out.printf(" COLOR: %s\n", yytext()); return symbol(CODIGO_COLOR, yytext());}
	{NUMERO_ENTERO}
		{System.out.printf(" NUMERO_ENTERO: %s\n", yytext()); return symbol(NUMERO_ENTERO, new Integer(yytext()));}
	{COMENTARIO_LINEA}
		{System.out.printf(" COMENTARIO_LINEA: %s\n", yytext()); return symbol(COMENTARIO_LINEA, yytext());}
	{SALTO}
		{System.out.printf(" SIGUIENTE INSTRUCCION: %s\n", yytext()); return symbol(SALTO, yytext());}
	{SEPARADORES}
	 	{/* los ignoramos */}
}

/* Error por cualquier otro simbolo*/
[^]    
		{ error(yytext(),yyline+1,yycolumn+1); return symbol(error, yytext());}

<<EOF>>
		{ return symbol(EOF); }