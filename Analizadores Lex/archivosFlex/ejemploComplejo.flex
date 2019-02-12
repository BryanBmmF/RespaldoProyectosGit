/* codigo de usuario */
package analizadorlexico;
import analizadorlexico.Token;

%% //separador de area

/* opciones y declaraciones de jflex */

%class Lexer
%type Token //el valor retornado por cada lectura será del tipo Token
%line
%column
LETRA = [a-zA-Z]
DIGITO = [0-9]
SEPARADORES = [ \n\r\t]

%{
    private String lexema;
    
    public String getLexema() {
        return lexema;
    }
%}

%% // separador de areas

/* reglas lexicas */
<YYINITIAL> {
	{SEPARADORES} {/* ignoramos */}
	{LETRA}({LETRA}|{DIGITO})* {lexema = yytext(); return Token.IDENTIFICADOR;}
	{DIGITO}({DIGITO}*|({DIGITO}*[.]{DIGITO}*)) {lexema = yytext(); return Token.NUMERO;}
	"=" {return Token.IGUAL;}
	"+" {return Token.SUMA;}
	"*" {return Token.MULTIPLICACION;}
	"-" {return Token.RESTA;}
	"/" {return Token.DIVISION;}
}
[^] {lexema = yytext(); return Token.ERROR;}


