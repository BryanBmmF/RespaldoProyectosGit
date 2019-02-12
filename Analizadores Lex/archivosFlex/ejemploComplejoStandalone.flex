/* codigo de usuario */


%% //separador de area

/* opciones y declaraciones de jflex */

%class lexer
%standalone
%line
%column
LETRA = [a-zA-Z]
DIGITO = [0-9]
SEPARADORES = [ \n\r\t]

%% // separador de areas

/* reglas lexicas */
<YYINITIAL> {
	{SEPARADORES} {/* ignoramos */}
	{LETRA}({LETRA}|{DIGITO})* {System.out.printf("*** Encontrado IDENTIFICADOR [%s]***\n", yytext());}
	{DIGITO}({DIGITO}*|({DIGITO}*[.]{DIGITO}*)) {System.out.printf("*** Encontrado NUMERO [%s]***\n", yytext());}
	"=" {System.out.printf("*** Encontrado IGUAL [%s]***\n", yytext());}
	"+" {System.out.printf("*** Encontrado SUMA [%s]***\n", yytext());}
	"*" {System.out.printf("*** Encontrado MULTIPLICACION [%s]***\n", yytext());}
	"-" {System.out.printf("*** Encontrado RESTA [%s]***\n", yytext());;}
	"/" {System.out.printf("*** Encontrado DIVISION [%s]***\n", yytext());}
}
[^] {System.out.printf("*** Encontrado ERROR [%s]***\n", yytext());}


