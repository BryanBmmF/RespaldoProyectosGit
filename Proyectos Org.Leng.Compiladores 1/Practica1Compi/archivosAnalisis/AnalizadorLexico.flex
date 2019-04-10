package consolaLinux;

import static consolaLinux.sym.error;
import java_cup.runtime.*;
import javax.swing.JTextArea;

%%

%public
%class Lexer
%cup
%cupdebug
%line
%column
//caracteres y separadores
CARACTERES_ESP = [-_@+*#.]
ESPACIOS_SEPARACION = [\t\f\r]
ESPACIO = [ ]+
SALTO = [\n]
DIAGONAL = "/"

//Identificadores
IDENTIFICADOR = ([:jletterdigit:]|{CARACTERES_ESP})+
//paths permitidos del tipo
PATH = {DIAGONAL}|({DIAGONAL}?{IDENTIFICADOR})({DIAGONAL}{IDENTIFICADOR})*

//Manejo de archivos permisos y ubicaciones
PWD = "pwd"
LS = "ls"
COMPLET_LS = "-"("l"|"a")+
CD = "cd"
TOUCH = "touch"
MKDIR = "mkdir"
MV = "mv"
CP = "cp"
RM = "rm"
RMDIR = "rmdir"
CHMOD = "chmod"
ENCADENACION = " && "
GUION_R_MAYUS = "-R"
GUION_R_MINUS = "-r"
REMOVER_PERMISOS_CHMOD = "-"("w"|"r"|"x")+
AGREGAR_PERMISOS_CHMOD = "+"("w"|"r"|"x")+
EXIT = "exit"

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

	private void error(String mensaje) {
		String error = "Se detecto un Error Lexico en la  posición " + (yycolumn + 1) + " : " + mensaje;
		System.out.println(error);
		this.textArea.append("\n" + error);
	}

	public Lexer (java.io.Reader entrada, JTextArea textArea) {
		this.zzReader = entrada;
		this.textArea = textArea;
	}
%}

%%

/* reglas lexicas */
<YYINITIAL> {
	{PWD}
		{System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(PWD, yytext());}
	{LS}
		{System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(LS, yytext());}
	{COMPLET_LS}
		{System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(COMPLET_LS, yytext());}
	{CD}
		{System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(CD, yytext());}
	{TOUCH}
		{System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(TOUCH, yytext());}
	{MKDIR}
		{System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(MKDIR, yytext());}
	{MV}
		{System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(MV, yytext());}
	{CP}
		{System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(CP, yytext());}
	{RM}
		{System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(RM, yytext());}
	{RMDIR}
		{System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(RMDIR, yytext());}
	{CHMOD}
		{System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(CHMOD, yytext());}
	{ENCADENACION}
		{System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(ENCADENACION, yytext());}
	{GUION_R_MAYUS}
		{System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(GUION_R_MAYUS, yytext());}
	{GUION_R_MINUS}
		{System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(GUION_R_MINUS, yytext());}
	{REMOVER_PERMISOS_CHMOD}
		{System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(REMOVER_PERMISOS_CHMOD, yytext());}
	{AGREGAR_PERMISOS_CHMOD}
		{System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(AGREGAR_PERMISOS_CHMOD, yytext());}
	{EXIT}
		{System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(EXIT, yytext());}
	{ESPACIO}
		{ System.out.printf(" leido un espacio\n"); return symbol(ESPACIO, "[ ] (espacio)");}
	{SALTO}
		{System.out.printf(" leido un enter\n"); return symbol(SALTO);}

	{PATH}
		{System.out.printf(" leido un path\n"); return symbol(PATH, yytext());}

	{ESPACIOS_SEPARACION}
	 	{/* los ignoramos */}
}

/* Error por cualquier otro simbolo*/
[^]    
		{ error("Simbolo invalido <" + yytext() + ">"); return symbol(error, yytext());}

<<EOF>>
		{ return symbol(EOF); }