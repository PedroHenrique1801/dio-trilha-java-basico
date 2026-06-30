import java.util.Scanner;

public class FormatadorTelefone {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de telefone (ou 'sair' para encerrar):");

        while (true) {
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }
            System.out.println(processarTelefone(entrada));
            System.out.println("--------------------------------------------------");
        }
        scanner.close();
    }

    public static String processarTelefone(String entrada) {
        if (entrada == null || entrada.trim().isEmpty()) {
            return "Entrada inválida.";
        }

        String apenasNumeros = entrada.replaceAll("\\D", "");
        int tamanho = apenasNumeros.length();

        if (!isTamanhoValido(tamanho)) {
            return "Não se trata de um número válido. Quantidade de dígitos incorreta: " + tamanho;
        }

        String numeroFormatadoCorretamente = aplicarMascara(apenasNumeros, tamanho);
        String tipoDispositivo = identificarTipo(tamanho);

        if (entrada.equals(numeroFormatadoCorretamente)) {
            return "Número já estava formatado corretamente.\n" +
                   "Número: " + numeroFormatadoCorretamente + "\n" +
                   "Tipo: " + tipoDispositivo;
        }

        return "Número formatado/corrigido com sucesso.\n" +
               "Resultado: " + numeroFormatadoCorretamente + "\n" +
               "Tipo: " + tipoDispositivo;
    }

    private static boolean isTamanhoValido(int tamanho) {
        return tamanho == 8 || tamanho == 9 || tamanho == 10 || tamanho == 11;
    }

    private static String identificarTipo(int tamanho) {
        switch (tamanho) {
            case 8: return "Telefone Fixo (Sem DDD)";
            case 9: return "Celular (Sem DDD)";
            case 10: return "Telefone Fixo (Com DDD)";
            case 11: return "Celular (Com DDD)";
            default: return "Desconhecido";
        }
    }

    private static String aplicarMascara(String numeros, int tamanho) {
        switch (tamanho) {
            case 8:
                return numeros.substring(0, 4) + "-" + numeros.substring(4);
            case 9:
                return numeros.substring(0, 5) + "-" + numeros.substring(5);
            case 10:
                return "(" + numeros.substring(0, 2) + ")" + numeros.substring(2, 6) + "-" + numeros.substring(6);
            case 11:
                return "(" + numeros.substring(0, 2) + ")" + numeros.substring(2, 7) + "-" + numeros.substring(7);
            default:
                return numeros;
        }
    }
}
