package dados;

public class Locacao {

    private Cliente cliente;
    private Veiculo veiculo;
    private int dias;
    private boolean encerrada;

    public Locacao(Cliente cliente, Veiculo veiculo, int dias) {

        if (dias <= 0) {
            throw new IllegalArgumentException("Quantidade de dias invalida!");
        }
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;

        this.encerrada = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public int getDias() {
        return dias;
    }
    public boolean isEncerrada() {
        return encerrada;
    }

    public void encerrar() {
        this.encerrada = true;
    }

    public double calcularValorTotal() {

        double diaria = dias * veiculo.calcularDiaria();
        double seguro = dias * veiculo.calcularSeguro();
        double manutencao = dias * veiculo.calcularManutencao();

        return diaria + seguro + manutencao;
    }
    @Override
    public String toString() {

        return "Cliente: " + cliente.getNome()
                + "\nVeiculo: " + veiculo.getModelo()
                + "\nDias: " + dias
                + "\nValor Total: R$ "
                + calcularValorTotal();
    }
}