import java.util.Scanner;

public class AreaRetangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Calculadora de Área: Retângulo ---");
        
        System.out.print("Informe o valor da base do retângulo: ");
        double base = scanner.nextDouble();

        System.out.print("Informe o valor da altura do retângulo: ");
        double altura = scanner.nextDouble();

        double area = base * altura;

        System.out.printf("A área do retângulo é: %.2f\n", area);

        scanner.close();
    }
}
