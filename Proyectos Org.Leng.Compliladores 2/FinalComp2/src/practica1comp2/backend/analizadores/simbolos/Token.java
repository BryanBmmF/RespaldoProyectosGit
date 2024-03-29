package practica1comp2.backend.analizadores.simbolos;

/**
 *
 * @author bryan
 */
public class Token {
    private final String lexeme;
    private final int line;
    private final int column;

    public Token(String lexema, int linea, int columna) {
        this.lexeme = lexema;
        this.line = linea;
        this.column = columna;
    }

//    public Token(String lexeme) {
//        this.lexeme = lexeme;
//    }
    
    
    public Token(int fila, int columna) {
        this(null, fila, columna);
    }

    
    public String getLexeme() {
        return lexeme;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
    
    
}
