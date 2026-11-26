package calculadora;

import java.util.NoSuchElementException;
import java.util.Scanner;

/** Ponto de entrada interativo da calculadora. */
public class Main {
    /** Inicia uma sessão e apresenta o resultado da operação informada.
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            Calculadora calculadora = new Calculadora();
            System.out.println("FinançApp — Calculadora básica");
            System.out.print("Digite a operação (ex.: 8 / 2): ");

            try {
                int a = entrada.nextInt();
                String operador = entrada.next();
                int b = entrada.nextInt();
                System.out.println("Resultado: " + calculadora.calc(a, b, operador));
            } catch (IllegalArgumentException | NoSuchElementException erro) {
                System.out.println("Não foi possível calcular: " + erro.getMessage());
            }
        }
    }
}
