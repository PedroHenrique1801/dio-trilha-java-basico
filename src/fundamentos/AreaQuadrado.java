import java.util.Scanner;

public class AreaQuadrado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.println("--- Calculadora de Área: Quadrado ---");
        System.out.print("Informe o tamanho do lado do quadrado: ");
        
        // Utilizando double para permitir medidas reais
        double lado = scanner.nextDouble();
        
        double area = lado * lado;

        // %.2f formata a saída para exibir apenas duas casas decimais
        System.out.printf("A área do quadrado é: %.2f\n", area);

        scanner.close();
    }
}
