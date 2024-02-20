package desafio1modulo2.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {

	ArrayList<Conta> contas = new ArrayList<>();
	
	public Banco() {
		
	}
	
	public void adicionarConta(Conta conta) {
		contas.add(conta);
		System.out.println("Conta cadastada com sucesso: ");
	}
	
	public void editarConta(int numeroConta) {
		Conta conta = pesquisarConta(numeroConta);
		int op = 0;
		Scanner entrada = new Scanner(System.in);
		if(conta != null) {
			do {
				System.out.println("Informe qual campo deseja alterar: ");
				System.out.println("1 - Numero Da Conta: ");
				System.out.println("2 - Nome Do Titular: ");
				System.out.println("3 - CPF: ");
				System.out.println("4 - Agência: ");
				System.out.println("5 - Saldo Atual: ");
				System.out.println("6 - Limite De Credito: ");
				System.out.println("7 - Data De Aniversário: ");
				System.out.println("8 - Sair Do Menu: ");
				op = entrada.nextInt();
				switch (op) {
				case 1: 
					System.out.println("Altere o numero da conta: ");
					int numeroDaConta = entrada.nextInt();
					conta.setNumero(numeroDaConta);
                    System.out.println("Número da conta alterado com sucesso:");
					break;
				case 2:
					System.out.println("Altere o nome do titular: ");
					String nomeTitular = entrada.next();
					conta.setNomeTitular(nomeTitular);
                    System.out.println("Agência da conta alterada com sucesso:");
					break;
				case 3:
					System.out.println("Altere o CPF: ");
					String cpf = entrada.next();
					conta.setCpf(cpf);
                    System.out.println("Titular da conta alterado com sucesso:");
					break;
				case 4:
					System.out.println("Altere a Agência: ");
					String agencia = entrada.next();
                    System.out.println("Agência da conta alterado com sucesso:");
					conta.setAgencia(agencia);
					break;
				case 5:
					System.out.println("Altere o saldo atual: ");
					double saldoAtual = entrada.nextDouble();
                    System.out.println("Saldo da conta alterado com sucesso:");
					conta.setSaldo(saldoAtual);
					break;
				case 6:
					if(conta instanceof ContaCorrente) {
						System.out.println("Altere o limite de credito: ");
						double limiteCredito = entrada.nextDouble();
						((ContaCorrente) conta).setLimiteCredito(limiteCredito);
                        System.out.println("Limite de crédito alterado com sucesso: ");
					}else {
                        System.out.println("Essa conta não suporta esse limite: ");
					}
					break;
				case 7:
					if(conta instanceof ContaPoupanca) {
						System.out.println("Altere a data de aniversario: ");
						String dataAniversario = entrada.next();
						((ContaPoupanca) conta).setDataAniversario(dataAniversario);
                        System.out.println("Data De Aniversário alterado com sucesso: ");
					}else {
                        System.out.println("Essa conta não suporta essa data de aniversário: ");
					}
					break;
				case 8:
					System.out.println("Saindo da conta: ");
					break;
				default:
					throw new IllegalArgumentException("Opção Invalida:");
				}
			}while(op != 8);
		}

	}
	
	public void excluirConta(int numeroConta) {
		contas.removeIf(contas -> contas.getNumero() == numeroConta);
		System.out.println("Conta Removida com sucesso:");
	}
	
	public Conta pesquisarConta(int numeroConta) {
		for(Conta conta : contas) {
			if(conta.getNumero() == numeroConta) {
				return conta;
			}
		}
		System.out.println("Conta nao encontrada:");
		return null;
	}
	
	public List<Conta> visualizarConta(){
		for(int i = 0; i < contas.size(); i++) {
			if(contas.get(i) != null) {
				Conta conta = pesquisarConta(contas.get(i).getNumero());
				conta.visualizarConta();
				return contas;
			}
		}
		
		System.out.println("Conta não cadastrada:");
		return null;
	}
	
	public void acessarConta() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o número da conta: ");
        int numeroConta = entrada.nextInt();
        int op = 0;
        Conta conta = pesquisarConta(numeroConta);
        if(conta != null) {
        	do {
            	System.out.println("1 - Sacar: ");
        		System.out.println("2 - Depositar: ");
        		System.out.println("3 - Transferir: ");
        		System.out.println("4 - Sair: ");
        		op = entrada.nextInt();
        		switch (op) {
        		case 1: 
        			System.out.println("Informe o valor a ser sacado: ");
        			double saque = entrada.nextDouble();
        			conta.sacar(saque);
        			break;
        		case 2:
        			System.out.println("Digite o valor do deposito: ");
        			double deposito = entrada.nextDouble();
        			conta.deposito(deposito);
        			break;
        		case 3:
        			if(conta != null) {
        				System.out.println("Digite o valor a ser transferido: ");
            			double tranferencia = entrada.nextDouble();
            			System.out.println("Informe o numero da conta: ");
            			numeroConta = entrada.nextInt();
            			conta.transferir(conta,tranferencia);
        			}else {
        				System.out.println("Conta não foi encontrada");
        			}
        			break;
        		case 4:
        			System.out.println("Saindo do menu: ");
        			break;
        		default:
        			throw new IllegalArgumentException("Opção Invalida:");
        		}
            }while(op != 4);
        }else {
        	System.out.println("Conta não cadastrada:");
        }
        
	}
}
