/*
 * Clase enumeradora para los tokens
 */
package analizadorsintactico.backend;

/**
 *
 * @author bryan
 */
public enum Token {
        IDENTIFICADOR,
        NUMERO,NUMERO_NEGATIVO,
        SUMA,
        RESTA,
	MULTIPLICACION,
        DIVISION,
        ERROR,
        IGUAL,
        PARENTESIS_IZQUIERDO,
        PARENTESIS_DERECHO,
        COMENTARIO,
        LITERAL,
        OPERADOR,
        SIGNO_PUNTUACION,
        ESCRIBIR,
        FIN,
        REPETIR,
        INICIAR,
        SI,
        VERDADERO,
        FALSO,
        ENTONCES
}
