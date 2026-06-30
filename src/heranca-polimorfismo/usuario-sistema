public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected boolean administrador;

    public Usuario(String nome, String email, String senha, boolean administrador) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.administrador = administrador;
    }

    // Métodos comuns a todos os usuários
    public void realizarLogin(String email, String senha) {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            System.out.println(nome + " logado com sucesso.");
        } else {
            System.out.println("Credenciais inválidas.");
        }
    }

    public void realizarLogoff() {
        System.out.println(nome + " saiu do sistema.");
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public void alterarDados(String novoNome, String novoEmail) {
        this.nome = novoNome;
        this.email = novoEmail;
    }

    // Getters básicos
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public boolean isAdministrador() { return administrador; }
}

public class Gerente extends Usuario {
    public Gerente(String nome, String email, String senha) {
        // Administrador é obrigatoriamente true
        super(nome, email, senha, true); 
    }

    public void gerarRelatorioFinanceiro() {
        System.out.println("Gerando relatório financeiro restrito...");
    }

    public void consultarVendas() {
        System.out.println("Consultando volume total de vendas da unidade...");
    }
}

public class Vendedor extends Usuario {
    private int quantidadeVendas;

    public Vendedor(String nome, String email, String senha) {
        // Administrador é obrigatoriamente false
        super(nome, email, senha, false);
        this.quantidadeVendas = 0;
    }

    public void realizarVenda() {
        this.quantidadeVendas++;
        System.out.println("Venda realizada com sucesso!");
    }

    public void consultarVendas() {
        System.out.println("Você realizou " + this.quantidadeVendas + " vendas.");
    }

    public int getQuantidadeVendas() { return quantidadeVendas; }
}

public class Atendente extends Usuario {
    private double valorEmCaixa;

    public Atendente(String nome, String email, String senha) {
        // Administrador é obrigatoriamente false
        super(nome, email, senha, false);
        this.valorEmCaixa = 0.0;
    }

    public void receberPagamento(double valor) {
        if (valor > 0) {
            this.valorEmCaixa += valor;
            System.out.println("Pagamento de R$ " + valor + " recebido.");
        }
    }

    public void fecharCaixa() {
        System.out.println("Caixa fechado. Total: R$ " + this.valorEmCaixa);
        this.valorEmCaixa = 0.0; // Zera o caixa para o próximo turno
    }

    public double getValorEmCaixa() { return valorEmCaixa; }
}
