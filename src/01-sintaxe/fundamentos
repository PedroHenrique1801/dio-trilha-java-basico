import java.util.Scanner;

/**
 * Classe demonstrativa de sintaxe básica, entrada de dados e operadores lógicos.
 * Exercício: Verificar se o usuário atende aos requisitos legais para dirigir.
 */
public class VerificacaoHabilitacao {

    public static void main(String[] args) {
        // Inicializando o Scanner para capturar dados inseridos no terminal
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Sistema de Verificação para CNH ---");

        System.out.print("Informe a sua idade: ");
        int idade = scanner.nextInt();

        System.out.print("Você é emancipado legalmente? (true / false ): ");
        boolean isEmancipado = scanner.nextBoolean();

        /* * Lógica principal (Regras de negócio):
         * O usuário pode dirigir se for maior/igual a 18 anos OU 
         * se for emancipado E tiver 16 anos ou mais.
         */
        boolean podeDirigir = idade >= 18 || (isEmancipado && idade >= 16);

        System.out.println("\n--- Resultado da Análise ---");
        
        // Utilizando printf para injetar a variável booleana (%b) diretamente na string
        System.out.printf("Permissão para dirigir concedida? %b \n", podeDirigir);

        // Um pequeno acréscimo de controle de fluxo
        if (podeDirigir) {
            System.out.println("Status: Você já pode iniciar o processo da sua habilitação!");
        } else {
            System.out.println("Status: Você ainda não atende aos requisitos legais para dirigir.");
        }

        // Sempre fechar o Scanner após o uso para evitar vazamento de memória (resource leak)
        scanner.close();
    }
}
