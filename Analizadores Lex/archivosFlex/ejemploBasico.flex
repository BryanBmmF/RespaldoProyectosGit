/* codigo de usuario */

%% //separador de area

%class ejemplo1
%standalone
%line
%column

%% // separador de areas

/* reglas lexicas */

<YYINITIAL> {
	(a|b)*abb   {System.out.printf("*** Encontrada ocurrencia [%s] en linea %d, columna %d ***\n", yytext(), yyline + 1, yycolumn + 1);}
}

\n  { /* Nada */}
[ ] { /* Ignorar */ }
[^]   { System.out.printf("**ERROR: lexema invalido [%s] en linea %d, column %d **\n", yytext(), yyline + 1, yycolumn + 1);}
