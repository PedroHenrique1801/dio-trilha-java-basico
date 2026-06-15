import java.util.Scanner;

public class Carro {
    private boolean ligado = false;
    private int velocidade = 0;
    private int marcha = 0;

    public void ligar() {
        if (ligado) {
            System.out.println("O carro já está ligado.");
        } else {
            ligado = true;
            System.out.println("Carro ligado! Vrum vrum.");
        }
    }

    public void desligar() {
        if (!ligado) {
            System.out.println("O carro já está desligado.");
        } else if (velocidade == 0 && marcha == 0) {
            ligado = false;
            System.out.println("Carro desligado com segurança.");
        } else {
            System.out.println("Erro: Para desligar, pare o carro (0km/h) e coloque em ponto morto (Marcha 0).");
        }
    }

    public void acelerar() {
        if (!ligado) {
            System.out.println("Erro: Não é possível acelerar com o carro desligado.");
            return;
        }
        if (marcha == 0) {
            System.out.println("Erro: Carro em ponto morto. Engate uma marcha para acelerar.");
            return;
        }
        if (velocidade >= 120) {
            System.out.println("Velocidade máxima (120km/h) atingida!");
            return;
        }
        
        if (podeAcelerarNaMarchaAtual()) {
            velocidade++;
            System.out.println("Acelerando... Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("Erro: Limite da marcha " + marcha + " atingido. Troque a marcha para continuar acelerando.");
        }
    }

    public void diminuirVelocidade() {
        if (!ligado) {
            System.out.println("Erro: Carro desligado.");
            return;
        }
        if (velocidade <= 0) {
            System.out.println("O carro já está parado.");
            return;
        }

        if (podeFrearNaMarchaAtual()) {
            velocidade--;
            System.out.println("Freando... Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("Erro: Velocidade muito baixa para a marcha " + marcha + ". Reduza a marcha para não 'morrer'.");
        }
    }

    public void virar(String direcao) {
        if (!ligado) {
            System.out.println("Erro: Carro desligado.");
            return;
        }
        if (velocidade >= 1 && velocidade <= 40) {
            System.out.println("Virando para a " + direcao + " com segurança.");
        } else {
            System.out.println("Erro: Para virar, a velocidade deve estar entre 1km/h e 40km/h.");
        }
    }

    public void verificarVelocidade() {
        System.out.println("Painel - Velocidade: " + velocidade + " km/h | Marcha: " + marcha | Status: " + (ligado ? "Ligado" : "Desligado"));
    }

    public void trocarMarcha(int novaMarcha) {
        if (!ligado) {
            System.out.println("Erro: Carro desligado.");
            return;
        }
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida. O carro tem marchas de 0 a 6.");
            return;
        }
        // Impede pular marcha (a diferença não pode ser maior que 1)
        if (Math.abs(this.marcha - novaMarcha) > 1) {
            System.out.println("Erro: Você não pode pular marchas.");
            return;
        }
        
        this.marcha = novaMarcha;
        System.out.println("Marcha trocada para: " + (marcha == 0 ? "Ponto Morto (0)" : marcha));
    }

    // Validações privadas de encapsulamento
    private boolean podeAcelerarNaMarchaAtual() {
        return switch (marcha) {
            case 1 -> velocidade < 20;
            case 2 -> velocidade < 40;
            case 3 -> velocidade < 60;
            case 4 -> velocidade < 80;
            case 5 -> velocidade < 100;
            case 6 -> velocidade < 120;
            default -> false;
        };
    }

    private boolean podeFrearNaMarchaAtual() {
        // Permite frear até o limite mínimo da marcha (ou até 0 se for marcha 1 ou ponto morto)
        if (marcha == 1 || marcha == 0) return true;
        return switch (marcha) {
            case 2 -> velocidade > 21;
            case 3 -> velocidade > 41;
            case 4 -> velocidade > 61;
            case 5 -> velocidade > 81;
            case 6 -> velocidade > 101;
            default -> false;
        };
    }

    // --- Menu Interativo ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();
        int opcao = 0;

        while (opcao != 8) {
            System.out.println("\n--- PAINEL DO CARRO ---");
            System.out.println("1 - Ligar / 2 - Desligar");
            System.out.println("3 - Acelerar / 4 - Frear");
            System.out.println("5 - Virar / 6 - Verificar Painel");
            System.out.println("7 - Trocar Marcha / 8 - Sair do Carro");
            System.out.print("Escolha uma ação: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> carro.ligar();
                case 2 -> carro.desligar();
                case 3 -> carro.acelerar();
                case 4 -> carro.diminuirVelocidade();
                case 5 -> {
                    System.out.print("Direção (Esquerda/Direita): ");
                    carro.virar(scanner.next());
                }
                case 6 -> carro.verificarVelocidade();
                case 7 -> {
                    System.out.print("Engatar marcha (0 a 6): ");
                    carro.trocarMarcha(scanner.nextInt());
                }
                case 8 -> System.out.println("Você saiu do carro.");
                default -> System.out.println("Ação não reconhecida.");
            }
        }
        scanner.close();
    }
}
