import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Gerador de Tabuada ---");
        System.out.print("Informe um número para gerar a tabuada: ");
        int numero = scanner.nextInt();

        System.out.printf("\nTabuada do %d:\n", numero);
        System.out.println("-----------------");

        // Estrutura de repetição que vai de 1 até 10
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.printf("%d x %02d = %d\n", numero, i, resultado); 
            // Dica: %02d formata números de 1 a 9 com um zero na frente (ex: 01, 02) para alinhar visualmente
        }

        scanner.close();
    }
}
