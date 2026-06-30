public abstract class Produto {
    protected double preco;

    public Produto(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    public abstract double calcularTributo();
    
    public double getPreco() {
        return preco;
    }
}

public class Alimentacao extends Produto {
    private static final double TAXA_TRIBUTO = 0.01;

    public Alimentacao(double preco) {
        super(preco);
    }

    @Override
    public double calcularTributo() {
        return this.preco * TAXA_TRIBUTO;
    }
}

public class SaudeBemEstar extends Produto {
    private static final double TAXA_TRIBUTO = 0.015; 

    public SaudeBemEstar(double preco) {
        super(preco);
    }

    @Override
    public double calcularTributo() {
        return this.preco * TAXA_TRIBUTO;
    }
}

public class Vestuario extends Produto {
    private static final double TAXA_TRIBUTO = 0.025;

    public Vestuario(double preco) {
        super(preco);
    }

    @Override
    public double calcularTributo() {
        return this.preco * TAXA_TRIBUTO;
    }
}

public class Cultura extends Produto {
    private static final double TAXA_TRIBUTO = 0.04; 

    public Cultura(double preco) {
        super(preco);
    }

    @Override
    public double calcularTributo() {
        return this.preco * TAXA_TRIBUTO;
    }
}
