import java.util.Scanner;

public class ParesImparesIntervalo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Rastreador de Pares e Ímpares ---");
        
        System.out.print("Informe o primeiro número (menor): ");
        int num1 = scanner.nextInt();

        System.out.print("Informe o segundo número (maior que o primeiro): ");
        int num2 = scanner.nextInt();

        System.out.print("Você quer exibir os números pares ou impares? (Digite 'par' ou 'impar'): ");
        String escolha = scanner.next();

        System.out.printf("\nExibindo números %ss no intervalo de %d a %d em ordem decrescente:\n", escolha, num1, num2);

        // Laço decrescente: começa no maior (num2) e vai até o menor (num1)
        for (int i = num2; i >= num1; i--) {
            boolean isPar = (i % 2 == 0);

            // Verifica a escolha do usuário e a natureza do número atual
            if (escolha.equalsIgnoreCase("par") && isPar) {
                System.out.println(i);
            } else if (escolha.equalsIgnoreCase("impar") && !isPar) {
                System.out.println(i);
            }
        }

        scanner.close();
    }
}
