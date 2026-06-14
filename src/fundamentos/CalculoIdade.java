import java.util.Scanner;
import java.time.Year;

public class CalculoIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Calculadora de Idade ---");
        System.out.print("Informe o seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o seu ano de nascimento (ex: 1995): ");
        int anoNascimento = scanner.nextInt();

        // Captura o ano atual dinamicamente do sistema
        int anoAtual = Year.now().getValue();
        int idade = anoAtual - anoNascimento;

        System.out.printf("Olá '%s', você tem '%d' anos.\n", nome, idade);

        scanner.close();
    }
}
