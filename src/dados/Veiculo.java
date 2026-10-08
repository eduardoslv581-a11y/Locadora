package dados;

public abstract class Veiculo {

    public abstract double calcularDiaria();
    public abstract double calcularSeguro();
    public abstract double calcularManutencao();

	private Marca marca;  
	private String modelo;
	private int ano;
	private String cor;
	private static int qtd=0;
	
	private boolean disponivel = true;
	
	private int quantidadeTotal;
	private int quantidadeDisponivel;
	
	public static int getQuantidade() {
		return Veiculo.qtd;
	}
	
	public Veiculo(String m, String mo, int a, String c) {
		Veiculo.qtd += 1;
		this.setAno(a);
		this.setCor(c);
		this.setMarca(m);
		this.setModelo(mo);
	}
	
	public Veiculo(Marca m,String mo, int a, String c) {
		Veiculo.qtd += 1;
		this.setAno(a);
		this.setCor(c);
		this.setMarca(m);
		this.setModelo(mo);		
	}
	
	public String getMarca() {
		return marca.getNome();
	}
	
	public void setMarca(Marca m) {
		this.marca  = m;
	}
	
	public void setMarca(String marca) {
		Marca mc = new Marca(marca);
		this.marca = mc;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		
	    if (ano < 1900 || ano > 2030) {
	        throw new IllegalArgumentException("Ano invalido!");
	    }

	    this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {

	    if (cor == null || cor.isBlank()) {
	        throw new IllegalArgumentException("Cor invalida!");
	    }
	    this.cor = cor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {

	    if (modelo == null || modelo.isBlank()) {
	        throw new IllegalArgumentException("Modelo invalido!");
	    }

	    this.modelo = modelo;
	}
	
	public int getQuantidadeTotal() {
	    return quantidadeTotal;
	}

	public void setQuantidadeTotal(int quantidadeTotal) {
	    this.quantidadeTotal = quantidadeTotal;
	}

	public int getQuantidadeDisponivel() {
	    return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
	    this.quantidadeDisponivel = quantidadeDisponivel;
	}
	
	public boolean isDisponivel() {
	    return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
	    this.disponivel = disponivel;
	}
	
	@Override
	public String toString() {

	    String desc = "";

	    desc += "Marca: " + this.getMarca() + "\n";
	    desc += "Modelo: " + this.getModelo() + "\n";
	    desc += "Ano: " + this.getAno() + "\n";
	    desc += "Cor: " + this.getCor() + "\n";

	    return desc;
	}
	
	@Override
	public boolean equals(Object obj) {
		Veiculo cmp = Veiculo.class.cast(obj);
		if (
				this.getMarca().equals(cmp.getMarca()) &&
				this.getModelo().equals(cmp.getModelo()) &&
				(this.getAno() == cmp.getAno())
		) {
			return true;
		} else {
			return false;
		}
	}
}