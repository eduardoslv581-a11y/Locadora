package dados;

public class SUV extends Veiculo {

    public SUV(Marca m, String modelo, int ano, String cor) {
        super(m, modelo, ano, cor);
    }

    @Override
    public double calcularDiaria() {
        return 250;
    }
    @Override
    public double calcularSeguro() {
    	return 60;
    }
    @Override
    public double calcularManutencao() {
    	return 30;
    }
}