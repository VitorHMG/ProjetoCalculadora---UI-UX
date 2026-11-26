package calculadora;

/**
 * Executa operações aritméticas básicas para o módulo financeiro da FinançApp.
 *
 * @author FinançApp
 * @version 1.0
 */
public class Calculadora {

    /** Cria uma calculadora sem estado interno. */
    public Calculadora() {
    }

    /**
     * Calcula o resultado da operação indicada.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @param op operador: {@code +}, {@code -}, {@code *} ou {@code /}
     * @return resultado inteiro da operação; a divisão segue a regra de inteiros Java
     * @throws IllegalArgumentException se o operador for inválido ou houver divisão por zero
     */
    public int calc(int a, int b, String op) {
        if (op == null) {
            throw new IllegalArgumentException("Operação inválida: o operador não pode ser nulo.");
        }

        return aplicarOperacao(a, b, op);
    }

    /**
     * Direciona o cálculo para a operação solicitada.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @param op operador validado como não nulo
     * @return resultado da operação
     * @throws IllegalArgumentException se o operador não for suportado ou a divisão for por zero
     */
    private int aplicarOperacao(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException("Operação inválida: " + op);
        };
    }

    /**
     * Realiza a divisão inteira após validar o divisor.
     *
     * @param dividendo valor que será dividido
     * @param divisor valor pelo qual dividir
     * @return quociente inteiro
     * @throws IllegalArgumentException se o divisor for zero
     */
    private int dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return dividendo / divisor;
    }
}
