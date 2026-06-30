public interface FiguraGeometrica {
    double calcularArea();
}

public class Quadrado implements FiguraGeometrica {
    private double lado;

    public Quadrado(double lado) {
        if (lado <= 0) throw new IllegalArgumentException("O lado deve ser maior que zero.");
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    public double getLado() { return lado; }
}

public class Retangulo implements FiguraGeometrica {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Base e altura devem ser maiores que zero.");
        }
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    public double getBase() { return base; }
    public double getAltura() { return altura; }
}

public class Circulo implements FiguraGeometrica {
    private double raio;

    public Circulo(double raio) {
        if (raio <= 0) throw new IllegalArgumentException("O raio deve ser maior que zero.");
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * (raio * raio);
    }

    public double getRaio() { return raio; }
}
