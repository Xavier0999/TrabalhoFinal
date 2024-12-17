package main.java.sistemadevotos.util;

import java.util.Scanner;

public class TecladoUtil {


    static Scanner teclado = new Scanner(System.in);
        
        public static String lerString(String mensagem) {
            System.out.println(mensagem);
            return teclado.nextLine();
    }

    public static Integer lerInteiro(String mensagem) {
        System.out.println(mensagem);
        return teclado.nextInt();
    }
    
}
