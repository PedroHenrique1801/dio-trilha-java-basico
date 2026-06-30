import java.util.Scanner;

public class CalculadoraString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os números separados por vírgula (ex: 10,20,30):");
        String entrada = scanner.nextLine();

        System.out.println("Escolha a operação: \n1 - Soma \n2 - Subtração");
        int operacao = scanner.nextInt();

        try {
            double resultado = calcular(entrada, operacao);
            System.out.println("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Certifique-se de usar apenas números e vírgulas.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static double calcular(String entrada, int operacao) {
        String[] numerosString = entrada.split(",");
        
        if (numerosString.length == 0 || entrada.trim().isEmpty()) {
            throw new IllegalArgumentException("Nenhum número foi informado.");
        }

        double resultado = Double.parseDouble(numerosString[0].trim());

        for (int i = 1; i < numerosString.length; i++) {
            double numeroAtual = Double.parseDouble(numerosString[i].trim());

            if (operacao == 1) {
                resultado += numeroAtual;
            } else if (operacao == 2) {
                resultado -= numeroAtual;
            } else {
                throw new IllegalArgumentException("Operação inválida.");
            }
        }

        return resultado;
    }
}
