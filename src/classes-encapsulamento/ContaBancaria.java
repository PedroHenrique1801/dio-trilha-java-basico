import java.util.Scanner;

public class ContaBancaria {
    private double saldo;
    private double limiteChequeEspecial;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;
        if (depositoInicial <= 500.0) {
            this.limiteChequeEspecial = 50.0;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }
    }

    public void consultarSaldo() {
        System.out.printf("Saldo atual: R$ %.2f\n", saldo);
    }

    public void consultarChequeEspecial() {
        System.out.printf("Limite total do cheque especial: R$ %.2f\n", limiteChequeEspecial);
        if (saldo < 0) {
            System.out.printf("Cheque especial em uso: R$ %.2f\n", Math.abs(saldo));
            System.out.printf("Cheque especial disponível: R$ %.2f\n", limiteChequeEspecial + saldo);
        } else {
            System.out.println("Nenhum valor do cheque especial está em uso.");
        }
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        
        // Regra da taxa de 20% sobre o uso do cheque especial
        if (saldo < 0) {
            double valorUsado = Math.abs(saldo);
            double taxa = valorUsado * 0.20;
            System.out.printf("Atenção: Cobrança de R$ %.2f referente à taxa de 20%% do cheque especial usado.\n", taxa);
            saldo -= taxa; // Desconta a taxa do saldo antes de aplicar o depósito
        }
        
        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    public void sacar(double valor) {
        processarSaqueOuPagamento(valor, "Saque");
    }

    public void pagarBoleto(double valor) {
        processarSaqueOuPagamento(valor, "Pagamento de boleto");
    }

    private void processarSaqueOuPagamento(double valor, String operacao) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }
        if (saldo + limiteChequeEspecial >= valor) {
            saldo -= valor;
            System.out.println(operacao + " realizado com sucesso.");
        } else {
            System.out.println("Saldo e cheque especial insuficientes para esta operação.");
        }
    }

    public void verificarUsoChequeEspecial() {
        if (saldo < 0) {
            System.out.println("Atenção: A conta ESTÁ utilizando o cheque especial no momento.");
        } else {
            System.out.println("A conta NÃO está utilizando o cheque especial.");
        }
    }

    // --- Menu Interativo ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Bem-vindo! Para abrir sua conta, informe o depósito inicial: R$ ");
        double depositoInicial = scanner.nextDouble();
        ContaBancaria conta = new ContaBancaria(depositoInicial);

        int opcao = 0;
        while (opcao != 7) {
            System.out.println("\n--- MENU BANCÁRIO ---");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Consultar Cheque Especial");
            System.out.println("3 - Depositar Dinheiro");
            System.out.println("4 - Sacar Dinheiro");
            System.out.println("5 - Pagar Boleto");
            System.out.println("6 - Verificar Uso do Cheque Especial");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> conta.consultarSaldo();
                case 2 -> conta.consultarChequeEspecial();
                case 3 -> {
                    System.out.print("Valor do depósito: R$ ");
                    conta.depositar(scanner.nextDouble());
                }
                case 4 -> {
                    System.out.print("Valor do saque: R$ ");
                    conta.sacar(scanner.nextDouble());
                }
                case 5 -> {
                    System.out.print("Valor do boleto: R$ ");
                    conta.pagarBoleto(scanner.nextDouble());
                }
                case 6 -> conta.verificarUsoChequeEspecial();
                case 7 -> System.out.println("Encerrando sistema bancário...");
                default -> System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
