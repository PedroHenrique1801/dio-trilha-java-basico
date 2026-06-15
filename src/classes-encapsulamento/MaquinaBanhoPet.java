import java.util.Scanner;

public class MaquinaBanhoPet {
    private int nivelAgua = 0; // Max 30
    private int nivelShampoo = 0; // Max 10
    private boolean temPet = false;
    private boolean petLimpo = false;
    private boolean precisaLimpar = false;

    public void darBanho() {
        if (!temPet) {
            System.out.println("Erro: Não há nenhum pet na máquina.");
            return;
        }
        if (nivelAgua < 10 || nivelShampoo < 2) {
            System.out.println("Erro: Nível de água ou shampoo insuficiente para o banho.");
            return;
        }
        
        nivelAgua -= 10;
        nivelShampoo -= 2;
        petLimpo = true;
        System.out.println("Banho concluído! O pet está limpo e cheiroso.");
    }

    public void abastecerAgua() {
        if (nivelAgua + 2 <= 30) {
            nivelAgua += 2;
            System.out.println("Abastecimento concluído: +2L de água.");
        } else {
            System.out.println("Atenção: A máquina já está com o reservatório de água quase/totalmente cheio.");
        }
    }

    public void abastecerShampoo() {
        if (nivelShampoo + 2 <= 10) {
            nivelShampoo += 2;
            System.out.println("Abastecimento concluído: +2L de shampoo.");
        } else {
            System.out.println("Atenção: A máquina já está com o reservatório de shampoo quase/totalmente cheio.");
        }
    }

    public void verificarNivelAgua() {
        System.out.println("Nível de Água: " + nivelAgua + "L / 30L");
    }

    public void verificarNivelShampoo() {
        System.out.println("Nível de Shampoo: " + nivelShampoo + "L / 10L");
    }

    public void verificarPet() {
        if (temPet) {
            System.out.println("Há um pet na máquina. Status: " + (petLimpo ? "Limpo" : "Aguardando banho"));
        } else {
            System.out.println("A máquina está vazia.");
        }
    }

    public void colocarPet() {
        if (temPet) {
            System.out.println("Erro: Já existe um pet na máquina. Aguarde o término do banho.");
            return;
        }
        if (precisaLimpar) {
            System.out.println("Erro: A máquina está suja. Realize a limpeza antes de colocar um novo pet.");
            return;
        }
        temPet = true;
        petLimpo = false;
        System.out.println("Pet posicionado na máquina com sucesso.");
    }

    public void retirarPet() {
        if (!temPet) {
            System.out.println("Erro: Não há nenhum pet para ser retirado.");
            return;
        }
        if (!petLimpo) {
            System.out.println("Aviso: O pet foi retirado sujo. A máquina precisará ser higienizada.");
            precisaLimpar = true;
        } else {
            System.out.println("Pet limpo retirado com sucesso!");
        }
        temPet = false;
        petLimpo = false;
    }

    public void limparMaquina() {
        if (temPet) {
            System.out.println("Erro: Retire o pet antes de realizar a autolimpeza da máquina.");
            return;
        }
        if (nivelAgua < 3 || nivelShampoo < 1) {
            System.out.println("Erro: Água ou shampoo insuficientes para o ciclo de limpeza.");
            return;
        }
        
        nivelAgua -= 3;
        nivelShampoo -= 1;
        precisaLimpar = false;
        System.out.println("Ciclo de autolimpeza concluído! Máquina pronta para uso.");
    }

    // --- Menu Interativo ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaquinaBanhoPet maquina = new MaquinaBanhoPet();
        int opcao = 0;

        while (opcao != 10) {
            System.out.println("\n--- PETSHOP: MÁQUINA DE BANHO ---");
            System.out.println("1 - Colocar Pet | 2 - Dar Banho | 3 - Retirar Pet");
            System.out.println("4 - Abastecer Água (+2L) | 5 - Abastecer Shampoo (+2L)");
            System.out.println("6 - Nível de Água | 7 - Nível de Shampoo");
            System.out.println("8 - Verificar Pet | 9 - Limpar Máquina");
            System.out.println("10 - Desligar Máquina");
            System.out.print("Escolha uma operação: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> maquina.colocarPet();
                case 2 -> maquina.darBanho();
                case 3 -> maquina.retirarPet();
                case 4 -> maquina.abastecerAgua();
                case 5 -> maquina.abastecerShampoo();
                case 6 -> maquina.verificarNivelAgua();
                case 7 -> maquina.verificarNivelShampoo();
                case 8 -> maquina.verificarPet();
                case 9 -> maquina.limparMaquina();
                case 10 -> System.out.println("Desligando máquina de banho...");
                default -> System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
