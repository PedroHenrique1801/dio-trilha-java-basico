import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorDados {

    static class Campo {
        String nome;
        String valor;
        String tipo;

        public Campo(String nome, String valor, String tipo) {
            this.nome = nome.trim();
            this.valor = valor.trim();
            this.tipo = tipo.trim().toLowerCase();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Campo> campos = new ArrayList<>();

        System.out.println("Digite os dados no formato: NOME_CAMPO;VALOR;TIPO");
        System.out.println("Tipos suportados: texto, datas, data e hora, inteiros, pontos flutuantes, boleanos, array");
        System.out.println("Digite 'gerar' para finalizar a entrada de dados.\n");

        while (true) {
            String entrada = scanner.nextLine();
            
            if (entrada.equalsIgnoreCase("gerar")) {
                break;
            }

            String[] partes = entrada.split(";");
            if (partes.length >= 3) {
                campos.add(new Campo(partes[0], partes[1], partes[2]));
            } else {
                System.out.println("Entrada inválida. Siga o padrão NOME_CAMPO;VALOR;TIPO;");
            }
        }

        if (!campos.isEmpty()) {
            System.out.println("\n================ JSON ================");
            System.out.println(gerarJson(campos));

            System.out.println("\n================ XML =================");
            System.out.println(gerarXml(campos));

            System.out.println("\n================ YAML ================");
            System.out.println(gerarYaml(campos));
        } else {
            System.out.println("Nenhum dado foi informado.");
        }

        scanner.close();
    }

    private static String gerarJson(List<Campo> campos) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        for (int i = 0; i < campos.size(); i++) {
            Campo c = campos.get(i);
            json.append("  \"").append(c.nome).append("\": ").append(formatarValor(c.valor, c.tipo));
            if (i < campos.size() - 1) {
                json.append(",");
            }
            json.append("\n");
        }
        json.append("}");
        return json.toString();
    }

    private static String gerarXml(List<Campo> campos) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<documento>\n");
        for (Campo c : campos) {
            String tag = c.nome.replaceAll("\\s+", "_"); 
            xml.append("  <").append(tag).append(">")
               .append(c.valor)
               .append("</").append(tag).append(">\n");
        }
        xml.append("</documento>");
        return xml.toString();
    }

    private static String gerarYaml(List<Campo> campos) {
        StringBuilder yaml = new StringBuilder();
        yaml.append("---\n");
        for (Campo c : campos) {
            yaml.append(c.nome).append(": ").append(formatarValor(c.valor, c.tipo)).append("\n");
        }
        return yaml.toString();
    }

    private static String formatarValor(String valor, String tipo) {
        if (tipo.contains("texto") || tipo.contains("datas") || tipo.contains("data e hora")) {
            return "\"" + valor + "\"";
        } else if (tipo.contains("array")) {
            if (!valor.trim().startsWith("[")) {
                return "[" + valor + "]";
            }
            return valor;
        } else {
            return valor;
        }
    }
}
