package dados;

public class Sedan extends Veiculo {

    public Sedan(Marca m, String modelo, int ano, String cor) {
        super(m, modelo, ano, cor);
    }

    @Override
    public double calcularDiaria() {
        return 180;
    }
    @Override
    public double calcularSeguro() {
        return 40;
    }

    @Override
    public double calcularManutencao() {
        return 20;
    }
}