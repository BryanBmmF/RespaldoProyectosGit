package proyecto1compi1;

import static proyecto1compi1.sym.error;
import java_cup.runtime.*;
import javax.swing.JTextArea;

%%

%public
%class Lexer3
%cup
%cupdebug
%line
%column
//%type String //el valor retornado por cada lectura será del tipo Token
//alfabeto separado
A_=[Aa]
B_=[Bb]
C_=[Cc]
//D_=[Dd]
E_=[Ee]
//F_=[Ff]
G_=[Gg]
H_=[Hh]
I_=[Ii]
J_=[Jj]
//K_=[Kk]
L_=[Ll]
M_=[Mm]
N_=[Nn]
O_=[Oo]
P_=[Pp]
Q_=[Qq]
R_=[Rr]
S_=[Ss]
T_=[Tt]
U_=[Uu]
V_=[Vv]
//W_=[Ww]
//X_=[Xx]
//Y_=[Yy]
//Z_=[Zz]

//caracteres y separadores
CARACTERES_ESP = [-_$]
//ESPACIOS_SEPARACION = [\t\f\r]
//NADA =""
SEPARADORES = [ \n\r\t\b\f]
ESPACIOS_BLANCO = [ \n\t]*
//SALTO = [\n]
DIAGONAL = "/"
ABRE = "<"
CIERRA = ">"
CORCHETE_A = "["
CORCHETE_C = "]"

CARACTERES_ENTRADA = [^ \t\n\r\f\b"]"]

//palabras reservadas para etiquetas CASE SENSIVITE
USUARIO = {U_}{S_}{U_}{A_}{R_}{I_}{O_}
PASS = {P_}{A_}{S_}{S_}
NOMBRE = {N_}{O_}{M_}{B_}{R_}{E_}


//Identificadores
IDENTIFICADOR = ({CARACTERES_ESP})([:jletterdigit:]|{CARACTERES_ESP})*

PARAMETRO_ID = {CORCHETE_A}{ESPACIOS_BLANCO}{IDENTIFICADOR}{ESPACIOS_BLANCO}{CORCHETE_C}
PARAMETRO_PASS = {CORCHETE_A}{ESPACIOS_BLANCO}{CARACTERES_ENTRADA}+{ESPACIOS_BLANCO}{CORCHETE_C}
//Manejo de archivos permisos y ubicaciones

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
	{ABRE}
		{System.out.printf(" ABRE: %s\n", yytext()); return symbol(ABRE, yytext());}
	{CIERRA}
		{System.out.printf(" CIERRA: %s\n", yytext()); return symbol(CIERRA, yytext());}
	{DIAGONAL}
		{System.out.printf(" FIN %s\n", yytext()); return symbol(DIAGONAL, yytext());}
	{USUARIO}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(USUARIO, yytext());}
	{PASS}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(PASS, yytext());}
	{NOMBRE}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(NOMBRE, yytext());}
	{PARAMETRO_ID}
		{System.out.printf(" PARAMETRO ID: %s\n", yytext()); return symbol(PARAMETRO_ID, yytext());}
	{PARAMETRO_PASS}
		{System.out.printf(" PARAMETRO URL: %s\n", yytext()); return symbol(PARAMETRO_PASS, yytext());}
	{SEPARADORES}
	 	{/* los ignoramos */}
}

/* Error por cualquier otro simbolo*/
[^]    
		{ error(yytext(),yyline+1,yycolumn+1); return symbol(error, yytext());}

<<EOF>>
		{ return symbol(EOF); }