package calculadora;

/**
 * Testes unitários autocontidos da classe {@link Calculadora}.
 * Executar com {@code java calculadora.TesteCalculadora} após a compilação.
 */
public class TesteCalculadora {
    private final Calculadora calculadora = new Calculadora();
    private int aprovados;

    /** Cria uma suíte de testes independente. */
    public TesteCalculadora() {
    }

    /** Executa todos os casos e encerra com erro se algum resultado divergir.
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        new TesteCalculadora().executar();
    }

    private void executar() {
        verificarResultado("soma", 8, 5, "+", 13);
        verificarResultado("subtração", 8, 5, "-", 3);
        verificarResultado("multiplicação", 8, 5, "*", 40);
        verificarResultado("divisão", 20, 4, "/", 5);
        verificarErro("divisão por zero", 8, 0, "/", "zero");
        verificarErro("operador inválido", 8, 5, "%", "inválida");
        verificarErro("operador nulo", 8, 5, null, "nulo");
        System.out.println("\n" + aprovados + " testes aprovados.");
    }

    private void verificarResultado(String nome, int a, int b, String op, int esperado) {
        int obtido = calculadora.calc(a, b, op);
        if (obtido != esperado) {
            throw new AssertionError(nome + ": esperado " + esperado + ", obtido " + obtido);
        }
        aprovados++;
        System.out.printf("[OK] %s: calc(%d, %d, %s) | esperado=%d | obtido=%d%n",
                nome, a, b, op, esperado, obtido);
    }

    private void verificarErro(String nome, int a, int b, String op, String mensagemEsperada) {
        try {
            int obtido = calculadora.calc(a, b, op);
            throw new AssertionError(nome + ": esperava erro, mas obteve " + obtido);
        } catch (IllegalArgumentException erro) {
            if (!erro.getMessage().toLowerCase().contains(mensagemEsperada)) {
                throw new AssertionError(nome + ": mensagem inesperada: " + erro.getMessage());
            }
            aprovados++;
            System.out.printf("[OK] %s: calc(%d, %d, %s) | esperado=erro (%s) | obtido=%s%n",
                    nome, a, b, op, mensagemEsperada, erro.getMessage());
        }
    }
}
