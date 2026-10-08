package ui;

import dados.Veiculo;
import dados.Marca;
import dados.Popular;
import dados.Sedan;
import dados.SUV;
import dados.Cliente;
import dados.Locacao;

import java.util.LinkedList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Veiculo> veiculos = new LinkedList<>();
		LinkedList<Marca> marcas = new LinkedList<>();
		LinkedList<Cliente> clientes = new LinkedList<>();
		LinkedList<Locacao> locacoes = new LinkedList<>();
		//Marca[] marcas = new Marca[3];
		int posAtualCarros = 0;
		int optAtual = -1;
		while (optAtual != 0) {
			System.out.println("==== Bem vindo ao Relampago marquinhos! ====");
			System.out.println("| Digite a opção desejada:                 |");
			System.out.println("| 1 - Cadastrar Marca                      |");
			System.out.println("| 2 - Cadastrar Carro                      |");
			System.out.println("| 3 - Listar Carros                        |");
			System.out.println("| 4 - Listar Marcas                        |");
			System.out.println("| 5 - Cadastrar Cliente                    |");
			System.out.println("| 6 - Abrir Locacao                        |");
			System.out.println("| 7 - Listar Locacoes                      |");
			System.out.println("| 8 - Devolver Veiculo                     |");
			System.out.println("| 9 - Exibir Relatorio                     |");
			System.out.println("| 0 - Sair                                 |");
			System.out.println("============================================");
			
			try {
				optAtual = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException ne) {
				System.err.println("ANIMAL! DIGITE UM NÚMERO VÁLIDO!!!!!");
			}
			if (optAtual == 1) {
			    System.out.println("PERFEITO! Vamos cadastrar a marca!");
			    System.out.print("Digite o nome da marca: ");

			    String nome = sc.nextLine();

			    Marca m = new Marca(nome);

			    marcas.add(m);

			    System.out.println("Marca cadastrada com sucesso!");
			    
			} else if (optAtual == 2) {

			    if (marcas.isEmpty()) {
			        System.out.println("Cadastre uma marca primeiro!");
			        continue;
			    }

			    System.out.println("Marcas cadastradas:");

			    for (int i = 0; i < marcas.size(); i++) {
			        System.out.println(i + " - " + marcas.get(i));
			    }

			    System.out.print("Digite o CODIGO da marca: ");
			    int codigoMarca = Integer.parseInt(sc.nextLine());

			    Marca marcaSelecionada = marcas.get(codigoMarca);

			    System.out.print("Modelo: ");
			    String modelo = sc.nextLine();

			    System.out.print("Ano: ");
			    int ano = Integer.parseInt(sc.nextLine());

			    System.out.print("Cor: ");
			    String cor = sc.nextLine();

			    System.out.println("Tipo:");
			    System.out.println("1 - Popular");
			    System.out.println("2 - Sedan");
			    System.out.println("3 - SUV");

			    int tipo = Integer.parseInt(sc.nextLine());

			    Veiculo v = null;

			    if (tipo == 1) {
			        v = new Popular(marcaSelecionada, modelo, ano, cor);
			    }
			    else if (tipo == 2) {
			        v = new Sedan(marcaSelecionada, modelo, ano, cor);
			    }
			    else if (tipo == 3) {
			        v = new SUV(marcaSelecionada, modelo, ano, cor);
			    }

			    veiculos.add(v);

			    System.out.println("Veículo cadastrado com sucesso!");
			    
				} else if (optAtual == 3) {

				    if (veiculos.isEmpty()) {
				        System.out.println("Nenhum veículo cadastrado!");
				    } else {

				        System.out.println("=== VEÍCULOS CADASTRADOS ===");

				        int codigo = 0;

				        for (Veiculo v : veiculos) {

				            System.out.println("Código: " + codigo);
				            System.out.println(v);
				            System.out.println("Diária: R$ " + v.calcularDiaria());

				            if (v.isDisponivel()) {
				                System.out.println("Status: Disponível");
				            } else {
				                System.out.println("Status: Ocupado");
				            }

				            System.out.println("---------------------");

				            codigo++;
				        }
				    }
				} else if (optAtual == 4) {
	
					System.out.println("Marcas cadastradas: ");
					int pNaLista=0;
					
					for (Marca m : marcas) {
					System.out.println("Código -> " + Integer.toString(pNaLista));
					System.out.println(m);
					System.out.println("===============\n");
					pNaLista += 1;
				} 
			} else if (optAtual == 5) {

			    System.out.print("Nome: ");
			    String nome = sc.nextLine();

			    System.out.print("CPF: ");
			    String cpf = sc.nextLine();

			    Cliente c = new Cliente(nome, cpf);

			    clientes.add(c);

			    System.out.println("Cliente cadastrado com sucesso!");
			} 
				else if (optAtual == 6) {

				    if (clientes.isEmpty()) {
				        System.out.println("Nenhum cliente cadastrado!");
				        continue;
				    }

				    if (veiculos.isEmpty()) {
				        System.out.println("Nenhum veiculo cadastrado!");
				        continue;
				    }

				    System.out.println("=== CLIENTES ===");

				    for (int i = 0; i < clientes.size(); i++) {
				        System.out.println(i + " - " + clientes.get(i).getNome());
				    }

				    System.out.print("Escolha o cliente: ");
				    int codCliente = Integer.parseInt(sc.nextLine());

				    Cliente cliente = clientes.get(codCliente);

				    System.out.println("=== VEICULOS ===");

				    for (int i = 0; i < veiculos.size(); i++) {
				        System.out.println(i + " - " + veiculos.get(i).getModelo());
				    }

				    System.out.print("Escolha o veiculo: ");
				    int codVeiculo = Integer.parseInt(sc.nextLine());

				    Veiculo veiculo = veiculos.get(codVeiculo);

				    if (!veiculo.isDisponivel()) {
				        System.out.println("Veiculo indisponivel!");
				        continue;
				    }

				    System.out.print("Quantidade de dias: ");
				    int dias = Integer.parseInt(sc.nextLine());

				    Locacao loc = new Locacao(cliente, veiculo, dias);

				    locacoes.add(loc);

				    veiculo.setDisponivel(false);

				    System.out.println("Locacao realizada com sucesso!");
				    System.out.println("Valor total: R$ " + loc.calcularValorTotal());
				}
				else if (optAtual == 7) {

			    if (locacoes.isEmpty()) {
			        System.out.println("Nenhuma locação cadastrada.");
			    } else {

			    	for (Locacao l : locacoes) {

			    	    if (!l.isEncerrada()) {

			    	        System.out.println("----------------");
			    	        System.out.println(l);
			    	        System.out.println("----------------");
			    	    }
			    	}
			    }
			} else if (optAtual == 8) {

			    if (locacoes.isEmpty()) {
			        System.out.println("Nenhuma locacao encontrada!");
			        continue;
			    }

			    for (int i = 0; i < locacoes.size(); i++) {
			        System.out.println(i + " - " + locacoes.get(i));
			    }

			    System.out.print("Escolha a locacao: ");
			    int codigo = Integer.parseInt(sc.nextLine());

			    Locacao loc = locacoes.get(codigo);

			    loc.getVeiculo().setDisponivel(true);

			    loc.encerrar();

			    System.out.println("Locacao encerrada!");
			    System.out.println("Veiculo devolvido com sucesso!");
			
			} else if (optAtual == 9) {

			    System.out.println("\n===== RELATORIO GERAL =====");
			    System.out.println("Quantidade de marcas: " + marcas.size());
			    System.out.println("Quantidade de clientes: " + clientes.size());
			    System.out.println("Quantidade de veiculos: " + veiculos.size());
			    System.out.println("Quantidade de locacoes: " + locacoes.size());

			    int disponiveis = 0;
			    int alugados = 0;

			    for (Veiculo v : veiculos) {

			        if (v.isDisponivel()) {
			            disponiveis++;
			        } else {
			            alugados++;
			        }
			    }

			    System.out.println("Veiculos disponiveis: " + disponiveis);

			    System.out.println("Veiculos alugados: " + alugados);

			    double faturamento = 0;

			    for (Locacao l : locacoes) {
			        faturamento += l.calcularValorTotal();
			    }

			    System.out.println("Faturamento total: R$ " + faturamento);

			    System.out.println("===========================\n");
			}
		} 
	}
}