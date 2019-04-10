package proyecto1compi1;

import static proyecto1compi1.sym.error;
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
IGUAL = "="
CORCHETE_A = "["
CORCHETE_C = "]"
COM = "\""
NUMERAL = "#"
CARACTERES_ENTRADA = [^ \t\n\r\f\b"]"]
CARACTERES_ENTRADA_2 = [^\r\f\b"]"]

//palabras reservadas para etiquetas CASE SENSIVITE
ACCION = {A_}{C_}{C_}{I_}{O_}{N_}
ACCIONES = {A_}{C_}{C_}{I_}{O_}{N_}{E_}{S_}
NOMBRE = {N_}{O_}{M_}{B_}{R_}{E_}
PARAMETRO = {P_}{A_}{R_}{A_}{M_}{E_}{T_}{R_}{O_}
PARAMETROS = {P_}{A_}{R_}{A_}{M_}{E_}{T_}{R_}{O_}{S_}
ETIQUETA = {E_}{T_}{I_}{Q_}{U_}{E_}{T_}{A_}
ETIQUETAS = {E_}{T_}{I_}{Q_}{U_}{E_}{T_}{A_}{S_}
VALOR = {V_}{A_}{L_}{O_}{R_}
ATRIBUTO = {A_}{T_}{R_}{I_}{B_}{U_}{T_}{O_}
ATRIBUTOS = {A_}{T_}{R_}{I_}{B_}{U_}{T_}{O_}{S_}

//ADICIONALES DE BD


//PALABRAS RESERVADAS DE ACCIONES DISPONIBLES
NUEVO_SITIO_WEB = {COM}{ESPACIOS_BLANCO}"NUEVO_SITIO_WEB"{ESPACIOS_BLANCO}{COM}
BORRAR_SITIO_WEB = {COM}{ESPACIOS_BLANCO}"BORRAR_SITIO_WEB"{ESPACIOS_BLANCO}{COM}
NUEVA_PAGINA = {COM}{ESPACIOS_BLANCO}"NUEVA_PAGINA"{ESPACIOS_BLANCO}{COM}
BORRAR_PAGINA = {COM}{ESPACIOS_BLANCO}"BORRAR_PAGINA"{ESPACIOS_BLANCO}{COM}
MODIFICAR_PAGINA = {COM}{ESPACIOS_BLANCO}"MODIFICAR_PAGINA"{ESPACIOS_BLANCO}{COM}
AGREGAR_COMPONENTE = {COM}{ESPACIOS_BLANCO}"AGREGAR_COMPONENTE"{ESPACIOS_BLANCO}{COM}
BORRAR_COMPONENTE = {COM}{ESPACIOS_BLANCO}"BORRAR_COMPONENTE"{ESPACIOS_BLANCO}{COM}
MODIFICAR_COMPONENTE = {COM}{ESPACIOS_BLANCO}"MODIFICAR_COMPONENTE"{ESPACIOS_BLANCO}{COM}

//PALABRAS RESERVADAS DE PARAMETROS DISPONIBLES
//PARA SITIOS
ID = {COM}{ESPACIOS_BLANCO}"ID"{ESPACIOS_BLANCO}{COM}
//PATH = {COM}{ESPACIOS_BLANCO}"PATH"{ESPACIOS_BLANCO}{COM}
USUARIO_CREACION = {COM}{ESPACIOS_BLANCO}"USUARIO_CREACION"{ESPACIOS_BLANCO}{COM}
USUARIO_MODIFICACION = {COM}{ESPACIOS_BLANCO}"USUARIO_MODIFICACION"{ESPACIOS_BLANCO}{COM}
FECHA_CREACION = {COM}{ESPACIOS_BLANCO}"FECHA_CREACION"{ESPACIOS_BLANCO}{COM}
FECHA_MODIFICACION = {COM}{ESPACIOS_BLANCO}"FECHA_MODIFICACION"{ESPACIOS_BLANCO}{COM}
//PARA PAGINAS
TITULO = {COM}{ESPACIOS_BLANCO}"TITULO"{ESPACIOS_BLANCO}{COM}
SITIO = {COM}{ESPACIOS_BLANCO}"SITIO"{ESPACIOS_BLANCO}{COM}
PADRE = {COM}{ESPACIOS_BLANCO}"PADRE"{ESPACIOS_BLANCO}{COM}
//PARA COMPONENTES
PAGINA = {COM}{ESPACIOS_BLANCO}"PAGINA"{ESPACIOS_BLANCO}{COM}
CLASE = {COM}{ESPACIOS_BLANCO}"CLASE"{ESPACIOS_BLANCO}{COM}

//PALABRAS RESERVADAS PARA COMPONENTES FISICOS
COMP_TITULO = "TITULO"
PARRAFO = "PARRAFO"
IMAGEN = "IMAGEN"
VIDEO = "VIDEO"
MENU = "MENU"

//PALABRAS RESERVADAS PARA LOS ATRIBUTOS DE CADA COMPONENTE
TEXTO = {COM}{ESPACIOS_BLANCO}"TEXTO"{ESPACIOS_BLANCO}{COM}
ALINEACION = {COM}{ESPACIOS_BLANCO}"ALINEACION"{ESPACIOS_BLANCO}{COM}
CENTRAR = "CENTRAR"
IZQUIERDA = "IZQUIERDA"
DERECHA = "DERECHA"
JUSTIFICAR = "JUSTIFICAR"
ALINEACIONES= ({CENTRAR}|{IZQUIERDA}|{DERECHA}|{JUSTIFICAR})
COLOR = {COM}{ESPACIOS_BLANCO}"COLOR"{ESPACIOS_BLANCO}{COM}
ORIGEN = {COM}{ESPACIOS_BLANCO}"ORIGEN"{ESPACIOS_BLANCO}{COM}
ALTURA = {COM}{ESPACIOS_BLANCO}"ALTURA"{ESPACIOS_BLANCO}{COM}
ANCHO = {COM}{ESPACIOS_BLANCO}"ANCHO"{ESPACIOS_BLANCO}{COM}
//PADRE YA SE DECLARO
ATRIBUTO_ETIQUETAS = {COM}{ESPACIOS_BLANCO}"ETIQUETAS"{ESPACIOS_BLANCO}{COM}


//Identificadores
IDENTIFICADOR = ({CARACTERES_ESP})([:jletterdigit:]|{CARACTERES_ESP})*
//paths permitidos del tipo
HTTP="http"
S="s"
DOS_PT =":"
URL = ({HTTP}{S}?{DOS_PT}{DIAGONAL}{DIAGONAL}[^ \r\f\b\n\t"/""]""<"]+)({DIAGONAL}[^ \r\f\b\n\t"/""]""<"]+)*({DIAGONAL}?)

//fechas
FECHA = ([0-9][0-9][0-9][0-9])("-")(0[1-9]|1[0-2])("-")([0-2][0-9]|3[0-1])

//PARAMETROS
PARAMETRO_ID = {CORCHETE_A}{ESPACIOS_BLANCO}{IDENTIFICADOR}{ESPACIOS_BLANCO}{CORCHETE_C}
PARAMETRO_URL = {CORCHETE_A}{ESPACIOS_BLANCO}{URL}{ESPACIOS_BLANCO}{CORCHETE_C}
PARAMETRO_FECHA = {CORCHETE_A}{ESPACIOS_BLANCO}{FECHA}{ESPACIOS_BLANCO}{CORCHETE_C}
PARAMETRO_COLOR = {CORCHETE_A}{ESPACIOS_BLANCO}{NUMERAL}{CODIGO_COLOR}{ESPACIOS_BLANCO}{CORCHETE_C}
CODIGO_COLOR = ([:jletterdigit:][:jletterdigit:][:jletterdigit:][:jletterdigit:][:jletterdigit:][:jletterdigit:])
PARAMETRO_TITULO = {CORCHETE_A}{ESPACIOS_BLANCO}{COMP_TITULO}{ESPACIOS_BLANCO}{CORCHETE_C}
PARAMETRO_PARRAFO = {CORCHETE_A}{ESPACIOS_BLANCO}{PARRAFO}{ESPACIOS_BLANCO}{CORCHETE_C}
PARAMETRO_IMAGEN = {CORCHETE_A}{ESPACIOS_BLANCO}{IMAGEN}{ESPACIOS_BLANCO}{CORCHETE_C}
PARAMETRO_VIDEO = {CORCHETE_A}{ESPACIOS_BLANCO}{VIDEO}{ESPACIOS_BLANCO}{CORCHETE_C}
PARAMETRO_MENU = {CORCHETE_A}{ESPACIOS_BLANCO}{MENU}{ESPACIOS_BLANCO}{CORCHETE_C}
PARAMETRO_ATRIBUTO_ETIQUETAS = {CORCHETE_A}{PALABRAS_CLAVE}{CORCHETE_C}|{CORCHETE_A}({PALABRAS_CLAVE}"|")+{CORCHETE_C}
PARAMETRO_TODO_TEXTO = {CORCHETE_A}{CARACTERES_ENTRADA_2}+{CORCHETE_C}
PARAMETRO_ALINEACION = {CORCHETE_A}{ESPACIOS_BLANCO}{ALINEACIONES}{ESPACIOS_BLANCO}{CORCHETE_C}
PARAMETRO_ENTERO = {CORCHETE_A}{ESPACIOS_BLANCO}{NUMERO_ENTERO}{ESPACIOS_BLANCO}{CORCHETE_C}
NUMERO_ENTERO = 0 |[1-9][0-9]*

NOMBRE_ETIQUETA = {COM}{PALABRAS_CLAVE}{COM}
PALABRAS_CLAVE = {ESPACIOS_BLANCO}{CARACTERES_ENTRADA}+{ESPACIOS_BLANCO}

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
	{IGUAL}
		{System.out.printf(" IGUAL: %s\n", yytext()); return symbol(IGUAL, yytext());}
	//{COM}
	//	{System.out.printf(" COMILLAS: %s\n", yytext());}
	{ACCION}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(ACCION, yytext());}
	{ACCIONES}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(ACCIONES, yytext());}
	{NOMBRE}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(NOMBRE, yytext());}
	{PARAMETRO}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(PARAMETRO, yytext());}
	{PARAMETROS}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(PARAMETROS, yytext());}
	{ETIQUETA}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(ETIQUETA, yytext());}
	{ETIQUETAS}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(ETIQUETAS, yytext());}
	{VALOR}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(VALOR, yytext());}
	{ATRIBUTO}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(ATRIBUTO, yytext());}
	{ATRIBUTOS}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(ATRIBUTOS, yytext());}
	
	//ADICIONALES BD	
	{NUEVO_SITIO_WEB}
		{System.out.printf(" ACCION: %s\n", yytext()); return symbol(NUEVO_SITIO_WEB, yytext());}
	{BORRAR_SITIO_WEB}
		{System.out.printf(" ACCION: %s\n", yytext()); return symbol(BORRAR_SITIO_WEB, yytext());}
	{NUEVA_PAGINA}
		{System.out.printf(" ACCION: %s\n", yytext()); return symbol(NUEVA_PAGINA, yytext());}
	{BORRAR_PAGINA}
		{ System.out.printf(" ACCION: %s\n", yytext()); return symbol(BORRAR_PAGINA, yytext());}
	{MODIFICAR_PAGINA}
		{System.out.printf(" ACCION: %s\n", yytext()); return symbol(MODIFICAR_PAGINA, yytext());}

	{AGREGAR_COMPONENTE}
		{System.out.printf(" ACCION: %s\n", yytext()); return symbol(AGREGAR_COMPONENTE, yytext());}
	{BORRAR_COMPONENTE}
		{System.out.printf(" ACCION: %s\n", yytext()); return symbol(BORRAR_COMPONENTE, yytext());}
	{MODIFICAR_COMPONENTE}
		{System.out.printf(" ACCION: %s\n", yytext()); return symbol(MODIFICAR_COMPONENTE, yytext());}
	{ID}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(ID, yytext());}


	{USUARIO_CREACION}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(USUARIO_CREACION, yytext());}
	{USUARIO_MODIFICACION}
		{ System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(USUARIO_MODIFICACION, yytext());}
	{FECHA_CREACION}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(FECHA_CREACION, yytext());}

	{FECHA_MODIFICACION}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(FECHA_MODIFICACION, yytext());}
	{TITULO}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(TITULO, yytext());}
	{SITIO}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(SITIO, yytext());}
	{PAGINA}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(PAGINA, yytext());}
	{PADRE}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(PADRE, yytext());}
	{CLASE}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(CLASE, yytext());}
	{TEXTO}
		{ System.out.printf(" ATRIBUTO: %s\n", yytext()); return symbol(TEXTO, yytext());}
	{ALINEACION}
		{System.out.printf(" ATRIBUTO: %s\n", yytext()); return symbol(ALINEACION, yytext());}
	{COLOR}
		{System.out.printf(" ATRIBUTO: %s\n", yytext()); return symbol(COLOR, yytext());}
	{ORIGEN}
		{System.out.printf(" ATRIBUTO: %s\n", yytext()); return symbol(ORIGEN, yytext());}
	{ALTURA}
		{System.out.printf(" ATRIBUTO: %s\n", yytext()); return symbol(ALTURA, yytext());}
	{ANCHO}
		{System.out.printf(" ATRIBUTO: %s\n", yytext()); return symbol(ANCHO, yytext());}
	{ATRIBUTO_ETIQUETAS}
		{System.out.printf(" ATRIBUTO: %s\n", yytext()); return symbol(ATRIBUTO_ETIQUETAS, yytext());}
	{PARAMETRO_MENU}
		{System.out.printf(" COMPONENTE: %s\n", yytext()); return symbol(PARAMETRO_MENU, yytext());}
	{PARAMETRO_VIDEO}
		{System.out.printf(" COMPONENTE: %s\n", yytext()); return symbol(PARAMETRO_VIDEO, yytext());}
	{PARAMETRO_IMAGEN}
		{System.out.printf(" COMPONENTE: %s\n", yytext()); return symbol(PARAMETRO_IMAGEN, yytext());}
	{PARAMETRO_PARRAFO}
		{System.out.printf(" COMPONENTE: %s\n", yytext()); return symbol(PARAMETRO_PARRAFO, yytext());}
	{PARAMETRO_TITULO}
		{System.out.printf(" PARAMETRO: %s\n", yytext()); return symbol(PARAMETRO_TITULO, yytext());}
	{PARAMETRO_COLOR}
		{System.out.printf(" PARAMETRO COLOR: %s\n", yytext()); return symbol(PARAMETRO_COLOR, yytext());}
	{PARAMETRO_ID}
		{System.out.printf(" PARAMETRO ID: %s\n", yytext()); return symbol(PARAMETRO_ID, yytext());}
	{PARAMETRO_URL}
		{System.out.printf(" PARAMETRO URL: %s\n", yytext()); return symbol(PARAMETRO_URL, yytext());}
	{PARAMETRO_FECHA}
		{System.out.printf(" PARAMETRO FECHA: %s\n", yytext()); return symbol(PARAMETRO_FECHA, yytext());}	
	{PARAMETRO_ALINEACION}
		{System.out.printf(" PARAMETRO ALINACION: %s\n", yytext()); return symbol(PARAMETRO_ALINEACION, yytext());}
	{PARAMETRO_ENTERO}
		{System.out.printf(" PARAMETRO ALTURA: %s\n", yytext()); return symbol(PARAMETRO_ENTERO, yytext());}
	{PARAMETRO_ATRIBUTO_ETIQUETAS}
		{System.out.printf(" PARAMETRO ETIQUETAS: %s\n", yytext()); return symbol(PARAMETRO_ATRIBUTO_ETIQUETAS, yytext());}
	{PARAMETRO_TODO_TEXTO}
		{System.out.printf(" PARAMETRO TEXTO: %s\n", yytext()); return symbol(PARAMETRO_TODO_TEXTO, yytext());}
	{NOMBRE_ETIQUETA}
		{System.out.printf(" ETIQUETA: %s\n", yytext()); return symbol(NOMBRE_ETIQUETA, yytext());}
	{SEPARADORES}
	 	{/* los ignoramos */}
}

/* Error por cualquier otro simbolo*/
[^]    
		{ error(yytext(),yyline+1,yycolumn+1); return symbol(error, yytext());}

<<EOF>>
		{ return symbol(EOF); }