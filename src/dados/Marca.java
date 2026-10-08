package dados;

public class Marca {

	private String nome;

	public Marca(String n) {
		this.setNome(n);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {

	    if(nome == null || nome.isBlank()) {
	        throw new IllegalArgumentException("Marca invalida!");
	    }
	    this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
}
