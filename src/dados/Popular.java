package dados;

public class Popular extends Veiculo {

    public Popular(Marca m, String modelo, int ano, String cor) {
        super(m, modelo, ano, cor);
    }

    @Override
    public double calcularDiaria() {
        return 100;
    }
    @Override
    public double calcularSeguro() {
        return 20;
    }

    @Override
    public double calcularManutencao() {
        return 10;
    }
}