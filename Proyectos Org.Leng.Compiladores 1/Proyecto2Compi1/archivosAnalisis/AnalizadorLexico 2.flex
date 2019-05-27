package proyecto2compi1;

import static proyecto2compi1.sym2.*;
import java_cup.runtime.*;
import javax.swing.JTextArea;

%%

%public
%class Lexer2
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
J_=[Jj]
K_=[Kk]
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
W_=[Ww]
X_=[Xx]
Y_=[Yy]
Z_=[Zz]

//caracteres y separadores
CARACTERES_ESP = [_]
//TERMINADOR_LINEA = \r|\n|\r\n
SEPARADORES = [ \r\t\b\f\n]

//SALTO = [\n]
IGUAL = "="
//CORCHETE_A = "["
//CORCHETE_C = "]"
ABRE = "<"
CIERRA = ">"
FIN = "/"
COM = "\""
//APOSTROFE = "'"
//PARENT_A = "("
//PARENT_C = ")"
NUMERAL = "#"
//SUMA = "+"
//RESTA = "-"
//MULT = "*"
//DIV = "/"
MOD = "%"
CARACTERES_ENTRADA = [^ \t\r\n\f\b"<"">""/""\"""=""_"]
//CARACTERES_ENTRADA2 = [^\r\f\b",""'"]
//CARACTERES_ENTRADA2 = [^\r\f\b"<"">""/""\"""="]

//palabras reservadas para etiquetas CASE INSENSITIVE
HTML = {H_}{T_}{M_}{L_}    //no podemos agregar espacios o saltos despues de cada etiqueta es mejor ignorarlos y agregarlos cuando se genere el archivo HTML
//END_HTML = {H_}{T_}{M_}{L_}
HEAD = {H_}{E_}{A_}{D_}
//END_HEAD = {H_}{E_}{A_}{D_}
TITLE = {T_}{I_}{T_}{L_}{E_}
//END_TITLE = {T_}{I_}{T_}{L_}{E_}
BODY = {B_}{O_}{D_}{Y_}
//END_BODY = {B_}{O_}{D_}{Y_}
CENTER = {C_}{E_}{N_}{T_}{E_}{R_}
//END_CENTER = {C_}{E_}{N_}{T_}{E_}{R_}
P = {P_}//PARRAFO CON SALTO
//END_P = {P_}
B = {B_} //NEGRILLA
//END_B ={B_}
U = {U_} //SUBRAYADO
//END_U ={U_}
I = {I_} //ITALICA
//END_I ={I_}
STRIKE = {S_}{T_}{R_}{I_}{K_}{E_} //TACHADO
//END_STRIKE = {S_}{T_}{R_}{I_}{K_}{E_}
BLINK = {B_}{L_}{I_}{N_}{K_} //PARPADEANTE
//END_BLINK = {B_}{L_}{I_}{N_}{K_}
SUB = {S_}{U_}{B_} //SUBINDICE
//END_SUB = {S_}{U_}{B_}
SUP = {S_}{U_}{P_} //SUPERINDICE
//END_SUP = {S_}{U_}{P_}
FONT = {F_}{O_}{N_}{T_}
//END_FONT = {F_}{O_}{N_}{T_}
UL = {U_}{L_} //LISTA DESORDENADA
//END_UL = {U_}{L_}
OL = {O_}{L_} //LISTA ORDENADA
//END_OL = {O_}{L_}
LI = {L_}{I_} //ITEM
//END_LI = {L_}{I_}
BR = {B_}{R_} //SALTO LINEA
NOBR = {N_}{O_}{B_}{R_} //NO SALTO DE LINEA AUNQUE SEA NECESARIO
//END_NOBR = {N_}{O_}{B_}{R_}
HR = {H_}{R_} //LINEA HORIZONTAL
//END_HR = {H_}{R_}
BLOCKQUOTE = {B_}{L_}{O_}{C_}{K_}{Q_}{U_}{O_}{T_}{E_} //SANGRIA
//END_BLOCKQUOTE = {B_}{L_}{O_}{C_}{K_}{Q_}{U_}{O_}{T_}{E_}
A = {A_} //LINK
//END_A = {A_}


//ATRIBUTOS
BGCOLOR = {B_}{G_}{C_}{O_}{L_}{O_}{R_}
TEXT = {T_}{E_}{X_}{T_}
LINK = {L_}{I_}{N_}{K_}
ALIGN = {A_}{L_}{I_}{G_}{N_}
SIZE = {S_}{I_}{Z_}{E_}
FACE = {F_}{A_}{C_}{E_} //PARA TIPO DE LETRA SE DEBEN DEFINIR ALGUNOS TIPOS O TMARLO COMO CUALQUIER TEXTO
COLOR = {C_}{O_}{L_}{O_}{R_}
TYPE = {T_}{Y_}{P_}{E_}
START = {S_}{T_}{A_}{R_}{T_}
WIDTH = {W_}{I_}{D_}{T_}{H_}
NAME = {N_}{A_}{M_}{E_}
HREF = {H_}{R_}{E_}{F_}


//parametros
//CODIGO_COLOR = ({NUMERAL}[:jletterdigit:][:jletterdigit:][:jletterdigit:][:jletterdigit:][:jletterdigit:][:jletterdigit:])
CONST_COLOR = {B_}{L_}{A_}{C_}{K_}|{O_}{L_}{I_}{V_}{E_}|{T_}{E_}{A_}{L_}|{R_}{E_}{D_}|{B_}{L_}{U_}{E_}|{M_}{A_}{R_}{O_}{O_}{N_}|{N_}{A_}{V_}{Y_}|
			  {G_}{R_}{A_}{Y_}|{L_}{I_}{M_}{E_}|{F_}{U_}{C_}{H_}{S_}{I_}{A_}|{G_}{R_}{E_}{E_}{N_}|{W_}{H_}{I_}{T_}{E_}|{P_}{U_}{R_}{P_}{L_}{E_}|
			  {S_}{I_}{L_}{V_}{E_}{R_}|{Y_}{E_}{L_}{L_}{O_}{W_}|{A_}{Q_}{U_}{A_}
ALINEACION = {L_}{E_}{F_}{T_}|{R_}{I_}{G_}{H_}{T_}|{C_}{E_}{N_}{T_}{E_}{R_}|{J_}{U_}{S_}{T_}{I_}{F_}{I_}{E_}{D_}
NUMERO_ENTERO = 0 |[1-9][0-9]*

TIPO_LETRA = {A_}{R_}{I_}{A_}{L_} //AGREGAR MAS
TIPO_LISTA = {C_}{I_}{R_}{C_}{L_}{E_}|{S_}{Q_}{U_}{A_}{R_}{E_}|{D_}{I_}{S_}{C_}
//TIPO_CARACTER = "A"|"a"|"1"
PORCENTAJE = {NUMERO_ENTERO}{MOD}

ANCLA_ETIQUETA = {NUMERAL}{CARACTERES_ENTRADA}+
//ETIQUETA = {CARACTERES_ENTRADA}+

TEXTO = {CARACTERES_ENTRADA}+

//PARAMETRO_TEXTO = {APOSTROFE}{CARACTERES_ENTRADA2}+{APOSTROFE}

//SIMBOLOS ESPECIALES
AMP_LT = "&lt"
AMP_GT = "&gt"
AMP = "&"
AMP_AACUTE = "&aacute"
AMP_EACUTE = "&eacute"
AMP_IACUTE = "&iacute"
AMP_OACUTE = "&oacute"
AMP_UACUTE = "&uacute"
AMP_NTILDE_MAYUS = "&Ntilde"
AMP_NTILDE_MINUS = "&ntilde"

//CODIGO EMBEBIDO

//VARIABLES

IDENTIFICADOR = ([:jletter:])([:jletterdigit:]|{CARACTERES_ESP})*

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
		{System.out.printf(" MENOR QUE: %s\n", yytext()); return symbol(ABRE, yytext());}
	{CIERRA}
		{System.out.printf(" MAYOR QUE: %s\n", yytext()); return symbol(CIERRA, yytext());}
	{HTML}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(HTML, yytext());}
	{HEAD}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(HEAD, yytext());}
	{TITLE}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(TITLE, yytext());}
	{BODY}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(BODY, yytext());}
	{CENTER}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(CENTER, yytext());}
	{P}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(P, yytext());}
	{B}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(B, yytext());}
	{U}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(U, yytext());}
	{I}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(I, yytext());}
	{STRIKE}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(STRIKE, yytext());}
	{BLINK}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(BLINK, yytext());}
	{SUB}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(SUB, yytext());}
	{SUP}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(SUP, yytext());}
	{FONT}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(FONT, yytext());}
	{UL}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(UL, yytext());}
	{OL}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(OL, yytext());}
	{LI}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(LI, yytext());}
	{BR}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(BR, yytext());}
	{NOBR}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(NOBR, yytext());}
	{HR}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(HR, yytext());}
	{BLOCKQUOTE}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(BLOCKQUOTE, yytext());}
	{A}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(A, yytext());}
	{BGCOLOR}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(BGCOLOR, yytext());}
	{TEXT}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(TEXT, yytext());}
	{LINK}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(LINK, yytext());}
	{ALIGN}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(ALIGN, yytext());}
	{SIZE}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(SIZE, yytext());}
	{FACE}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(FACE, yytext());}
	{COLOR}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(COLOR, yytext());}
	{TYPE}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(TYPE, yytext());}
	{START}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(START, yytext());}
	{WIDTH}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(WIDTH, yytext());}
	{NAME}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(NAME, yytext());}
	{HREF}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(HREF, yytext());}

	{PORCENTAJE}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(PORCENTAJE, yytext());}
	{ANCLA_ETIQUETA}
		{System.out.printf(" ANCLA_ETIQUETA: %s\n", yytext()); return symbol(ANCLA_ETIQUETA, yytext());}

	{AMP_LT}
		{System.out.printf(" SIMBOLO: %s\n", yytext()); return symbol(AMP_LT, yytext());}
	{AMP_GT}
		{System.out.printf(" SIMBOLO: %s\n", yytext()); return symbol(AMP_GT, yytext());}
	{AMP_AACUTE}
		{System.out.printf(" SIMBOLO: %s\n", yytext()); return symbol(AMP_AACUTE, yytext());}
	{AMP_EACUTE}
		{System.out.printf(" SIMBOLO: %s\n", yytext()); return symbol(AMP_EACUTE, yytext());}
	{AMP_IACUTE}
		{System.out.printf(" SIMBOLO: %s\n", yytext()); return symbol(AMP_IACUTE, yytext());}
	{AMP_OACUTE}
		{System.out.printf(" SIMBOLO: %s\n", yytext()); return symbol(AMP_OACUTE, yytext());}
	{AMP_UACUTE}
		{System.out.printf(" SIMBOLO: %s\n", yytext()); return symbol(AMP_UACUTE, yytext());}
	{AMP}
		{System.out.printf(" SIMBOLO: %s\n", yytext()); return symbol(AMP, yytext());}
	{AMP_NTILDE_MINUS}
		{System.out.printf(" SIMBOLO: %s\n", yytext()); return symbol(AMP_NTILDE_MINUS, yytext());}
	{AMP_NTILDE_MAYUS}
		{System.out.printf(" SIMBOLO: %s\n", yytext()); return symbol(AMP_NTILDE_MAYUS, yytext());}

	
	{FIN}
		{System.out.printf(" DIV: %s\n", yytext()); return symbol(FIN, yytext());}
	{IGUAL}
		{System.out.printf(" IGUAL: %s\n", yytext()); return symbol(IGUAL, yytext());}

	{COM}
		{System.out.printf(" COMILLA DOBLE: %s\n", yytext()); return symbol(COM, yytext());}

	{CONST_COLOR}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(CONST_COLOR, yytext());}
	{ALINEACION}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(ALINEACION, yytext());}
	{NUMERO_ENTERO}
		{System.out.printf(" ENTERO: %s\n", yytext()); return symbol(NUMERO_ENTERO, new Integer(yytext()));}
	{TIPO_LETRA}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(TIPO_LETRA, yytext());}
	{TIPO_LISTA}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(TIPO_LISTA, yytext());}
	{TEXTO}
		{System.out.printf(" TEXTO: %s\n", yytext()); return symbol(TEXTO, yytext());}

	{IDENTIFICADOR}
		{System.out.printf(" IDENTIFICADOR: %s\n", yytext()); return symbol(IDENTIFICADOR, yytext());}

	{SEPARADORES}
	 	{/* los ignoramos */}
	
}

/* Error por cualquier otro simbolo SERIA TEXTO POR ESO NO A[PLICA ESTA REGLA*/ 
//[^]    
//		{ error(yytext(),yyline+1,yycolumn+1); return symbol(error, yytext());}

<<EOF>>
		{ return symbol(EOF); }