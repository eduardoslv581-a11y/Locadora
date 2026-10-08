package dados;

public class Cliente {

    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.isBlank()) { //nao permiti o usuario deixar em branco
            throw new IllegalArgumentException("Nome invalido!"); //excessão nao verificada 
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {

        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF invalido!"); //excessão nao verificada
        }
        this.cpf = cpf;
    }

    @Override //sobrescreve o metodo pai 
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf;
    }
}