import java.util.Scanner;

public class DiferencaIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Calculadora de Diferença de Idades ---");

        System.out.print("Informe o nome da primeira pessoa: ");
        String nome1 = scanner.nextLine();
        System.out.print("Informe a idade de " + nome1 + ": ");
        int idade1 = scanner.nextInt();

        // Limpeza do buffer do Scanner (necessário após ler um int e antes de ler uma nova String)
        scanner.nextLine(); 

        System.out.print("\nInforme o nome da segunda pessoa: ");
        String nome2 = scanner.nextLine();
        System.out.print("Informe a idade de " + nome2 + ": ");
        int idade2 = scanner.nextInt();

        // Math.abs garante que a diferença seja sempre positiva
        int diferenca = Math.abs(idade1 - idade2);

        System.out.printf("\nA diferença de idade entre %s e %s é de %d anos.\n", nome1, nome2, diferenca);

        scanner.close();
    }
}
