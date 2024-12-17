package main.java.sistemadevotos.exception;

/**
 * Exceção personalizada para indicar que o limite diário de votos foi atingido.
 * <p>
 * Esta exceção é lançada quando uma operação que requer votos ultrapassa o limite
 * permitido em um determinado período (como um dia). A mensagem associada fornece
 * informações adicionais sobre a causa.
 * </p>
 *
 * @author [Gustavo]
 * @version 1.0
 */
public class LimiteDeVotosDiariosException extends Exception {

    /**
     * Constrói uma nova exceção LimiteDeVotosDiariosException com uma mensagem especificada.
     *
     * @param message A mensagem detalhada que descreve a causa da exceção.
     */
    public LimiteDeVotosDiariosException(String message) {
        super(message);
    }
}


