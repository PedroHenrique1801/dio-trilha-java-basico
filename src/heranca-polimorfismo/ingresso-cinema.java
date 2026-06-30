public abstract class Ingresso {
    protected double valorOriginal;
    protected String nomeFilme;
    protected boolean legendado;

    public Ingresso(double valorOriginal, String nomeFilme, boolean legendado) {
        this.valorOriginal = valorOriginal;
        this.nomeFilme = nomeFilme;
        this.legendado = legendado;
    }

    // Método abstrato: obriga as subclasses a implementarem suas próprias regras de cálculo
    public abstract double calcularValorReal();

    public String getNomeFilme() { return nomeFilme; }
    public boolean isLegendado() { return legendado; }
}

public class MeiaEntrada extends Ingresso {
    public MeiaEntrada(double valorOriginal, String nomeFilme, boolean legendado) {
        super(valorOriginal, nomeFilme, legendado);
    }

    @Override
    public double calcularValorReal() {
        return this.valorOriginal / 2.0;
    }
}

public class IngressoFamilia extends Ingresso {
    private int numeroPessoas;

    public IngressoFamilia(double valorOriginal, String nomeFilme, boolean legendado, int numeroPessoas) {
        super(valorOriginal, nomeFilme, legendado);
        if (numeroPessoas < 2) {
            throw new IllegalArgumentException("Ingresso família exige pelo menos 2 pessoas.");
        }
        this.numeroPessoas = numeroPessoas;
    }

    @Override
    public double calcularValorReal() {
        double valorTotal = this.valorOriginal * this.numeroPessoas;
        if (this.numeroPessoas > 3) {
            // Aplica 5% de desconto
            valorTotal -= valorTotal * 0.05; 
        }
        return valorTotal;
    }
}
