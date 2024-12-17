package main.java.sistemadevotos.util;

import java.util.Scanner;

/**
 * Classe utilitária para entrada de dados via terminal.
 * <p>
 * Esta classe facilita a leitura de valores do usuário, como {@code String} e {@code Integer},
 * exibindo uma mensagem personalizada antes da entrada.
 * </p>
 *
 * @author [Gustavo]
 * @version 1.0
 */

public class TecladoUtil {

 /**
     * Scanner estático para leitura de entradas do teclado.
     */
    static Scanner teclado = new Scanner(System.in);
        /**
     * Lê uma string fornecida pelo usuário.
     * <p>
     * Exibe uma mensagem antes de capturar a entrada do teclado.
     * </p>
     *
     * @param mensagem A mensagem a ser exibida ao usuário antes da entrada.
     * @return A string digitada pelo usuário.
     */
        public static String lerString(String mensagem) {
            System.out.println(mensagem);
            return teclado.nextLine();
    }
/**
     * Lê um número inteiro fornecido pelo usuário.
     * <p>
     * Exibe uma mensagem antes de capturar a entrada do teclado.
     * Caso a entrada não seja um número válido, pode ocorrer uma exceção {@code InputMismatchException}.
     * </p>
     *
     * @param mensagem A mensagem a ser exibida ao usuário antes da entrada.
     * @return O número inteiro digitado pelo usuário.
     */
    public static Integer lerInteiro(String mensagem) {
        System.out.println(mensagem);
        return teclado.nextInt();
    }
    
}
