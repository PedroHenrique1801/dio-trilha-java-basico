import java.util.Scanner;

public class CalculadoraImc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Calculadora de IMC ---");
        System.out.print("Informe o seu peso em kg (ex: 75.5): ");
        double peso = scanner.nextDouble();

        System.out.print("Informe a sua altura em metros (ex: 1.75): ");
        double altura = scanner.nextDouble();

        // Cálculo do IMC usando Math.pow para elevar a altura ao quadrado
        double imc = peso / Math.pow(altura, 2);

        System.out.printf("\nSeu IMC é: %.2f\n", imc);
        System.out.print("Classificação: ");

        // Estrutura de controle condicional
        if (imc <= 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc < 25.0) {
            System.out.println("Peso ideal");
        } else if (imc < 30.0) {
            System.out.println("Levemente acima do peso");
        } else if (imc < 35.0) {
            System.out.println("Obesidade Grau I");
        } else if (imc < 40.0) {
            System.out.println("Obesidade Grau II (Severa)");
        } else {
            System.out.println("Obesidade III (Mórbida)");
        }

        scanner.close();
    }
}
