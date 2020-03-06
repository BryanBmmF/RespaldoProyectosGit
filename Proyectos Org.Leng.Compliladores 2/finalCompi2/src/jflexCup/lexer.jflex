package jflexCup;
import java_cup.runtime.*;
import java.util.List;
import Objetos.*;
%% //separador de area

/* opciones y declaraciones de jflex */

%class lexico
%cup
%public
%cupdebug
%line
%column

/* identifiers */
Letra = [a-zA-Z]
Signo = [_]
diagonal = [\\]+
Otros = [:;/?!<>=+-@#$%*]
Numero = [0123456789]
WHITE_SPACE_CHAR=[\ \n\r\t\f]
Texto = ({Letra})({Letra}|{Signo}|{Numero})*

%{
  List<TokError> errores;
  StringBuilder string = new StringBuilder();
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

    private Symbol symbol(int type, Object value) {

    return new Symbol(type, yyline+1, yycolumn+1, value);
  }
  public void addErrores(String value){
    errores.add(new TokError(value,"lexico",yyline+1, yycolumn+1)); 
  }
  public lexico(java.io.Reader in,List<TokError> errores) {
    this.zzReader = in;
    this.errores=errores;
  }
%}


%% // separador de areas
/* reglas lexicas [^] */
<YYINITIAL> {
        //Delimitadores
        "("                 {return symbol(sym.PARA,new String(yytext()));}
        "["                 {return symbol(sym.CORA,new String(yytext()));}
        "]"                 {return symbol(sym.CORC,new String(yytext()));}
        ")"                 {return symbol(sym.PARC,new String(yytext()));}   
        "{"                 {return symbol(sym.LLAVEA,new String(yytext()));}
        "}"                 {return symbol(sym.LLAVEC,new String(yytext()));}
        ";"                 {return symbol(sym.PUNTOCOMA,new String(yytext()));}
        ","                 {return symbol(sym.COMA,new String(yytext()));}
        "\""                {return symbol(sym.COMILLA,new String(yytext()));}   
        //Asignacion
        "="                 {return symbol(sym.ASIGNAR,new String(yytext()));}
        //aritmetica
        "+"                 {return symbol(sym.MAS,new String(yytext()));}
        "-"                 {return symbol(sym.MENOS,new String(yytext()));}
        "*"                 {return symbol(sym.POR,new String(yytext()));}
        "/"                 {return symbol(sym.DIV,new String(yytext()));}
        //Operadores logicos
        "||"                 {return symbol(sym.OR,new String(yytext()));}
        "&&"                 {return symbol(sym.AND,new String(yytext()));}
        //Operadores relacionales
        "<"                 {return symbol(sym.MENOR,new String(yytext()));}
        ">"                 {return symbol(sym.MAYOR,new String(yytext()));}
        "=="                 {return symbol(sym.IGUAL,new String(yytext()));}
        "!="                 {return symbol(sym.DIFERENTE,new String(yytext()));}
        //palabras reservadas
        "main"                 {return symbol(sym.MAIN,new String(yytext()));}
        "while"                 {return symbol(sym.WHILE,new String(yytext()));}
        "prints"                 {return symbol(sym.PRINTS,new String(yytext()));}
        "printn"                 {return symbol(sym.PRINTN,new String(yytext()));}
        "if"                 {return symbol(sym.IF,new String(yytext()));}
        "else"                 {return symbol(sym.ELSE,new String(yytext()));}
        "scanS"                 {return symbol(sym.SCANS,new String(yytext()));}
        "scanN"                 {return symbol(sym.SCANN,new String(yytext()));}
        //tipo de datos
        "int"                 {return symbol(sym.INT,new String(yytext()));}
        "boolean"                 {return symbol(sym.BOOLEAN,new String(yytext()));}
        "float"                 {return symbol(sym.FLOAT,new String(yytext()));}
        "String"                 {return symbol(sym.STRING,new String(yytext()));}
        "true"                 {return symbol(sym.TRUE,new String(yytext()));}
        "false"                 {return symbol(sym.FALSE,new String(yytext()));} 
        "break"                 {return symbol(sym.BREAK,new String(yytext()));}
        //Valores
        {Texto}    {return symbol(sym.ID,new String(yytext()));}
        ({Numero})({Numero})*     {return symbol(sym.ENTERO,new String(yytext()));}
        (({Numero})+|({Numero})+(".")({Numero})+)("f")     {return symbol(sym.FLOTANTE,new String(yytext()));}
        (\")(({Letra}|{Signo}|{Otros}|{Numero})|{diagonal}|{WHITE_SPACE_CHAR})*(\")            {return symbol(sym.LITERAL,new String(yytext()));}
        {WHITE_SPACE_CHAR}               {}//ignoramos
        .                   {addErrores(yytext());}           
}
