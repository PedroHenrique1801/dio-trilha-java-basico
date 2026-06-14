import java.util.Scanner;

public class VerificadorMultiplos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Verificador de Múltiplos ---");
        System.out.print("Informe o número inicial: ");
        int numeroInicial = scanner.nextInt();

        // Loop contínuo que só será interrompido pela palavra-chave 'break'
        while (true) {
            System.out.print("\nInforme o próximo número: ");
            int proximoNumero = scanner.nextInt();

            // Regra 1: Ignorar números menores que o inicial
            if (proximoNumero < numeroInicial) {
                System.out.println("Número ignorado (menor que o número inicial).");
                continue; // Pula para a próxima iteração do loop
            }

            // Regra 2: Parar a execução se tiver resto diferente de 0 (não for múltiplo)
            if (proximoNumero % numeroInicial != 0) {
                System.out.println("Fim da execução! O número " + proximoNumero + 
                                   " não é múltiplo de " + numeroInicial + ".");
                break; // Quebra o loop e encerra o programa
            }

            System.out.println("Número aceito! " + proximoNumero + " é múltiplo de " + numeroInicial + ".");
        }

        scanner.close();
    }
}
