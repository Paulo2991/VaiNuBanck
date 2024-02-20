package desafio1modulo2;

import java.util.Scanner;

import desafio1modulo2.classes.Banco;
import desafio1modulo2.classes.ContaCorrente;
import desafio1modulo2.classes.ContaPoupanca;

public class VaiNuBanck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op = 0;
		Banco banco = new Banco();
		Scanner entrada = new Scanner(System.in);
		do {
			System.out.println("Informe qual opção do menu desejar: ");
			System.out.println("1 - Cadastar Conta Corrente: ");
			System.out.println("2 - Cadastrar Conta Poupança: ");
			System.out.println("3 - Acessar Conta: ");
			System.out.println("4 - Listar Contas: ");
			System.out.println("5 - Excluir Contas: ");
			System.out.println("6 - Alterar Contas: ");
			System.out.println("7 - Sair Menu: ");
			op = entrada.nextInt();
			switch (op) {
			case 1:
				System.out.println("Informe o numero da conta: ");
				int numeroConta = entrada.nextInt();
				System.out.println("Informe o nome do titular: ");
				String nomeTitular = entrada.next();
				System.out.println("Informe o CPF: ");
				String cpf = entrada.next();
				System.out.println("Informe a agência: ");
				String agencia = entrada.next();
				System.out.println("Informe o saldo atual: ");
				double saldo = entrada.nextDouble();
				System.out.println("Informe o limite de credito: ");
				double limiteCredito = entrada.nextDouble();
				ContaCorrente contaCorrente = new ContaCorrente(numeroConta,nomeTitular,cpf,agencia,saldo,limiteCredito);
				contaCorrente.setLimiteCredito(limiteCredito);
				banco.adicionarConta(contaCorrente);
				break;
			case 2:
				System.out.println("Informe o numero da conta: ");
				numeroConta = entrada.nextInt();
				System.out.println("Informe o nome do titular: ");
				nomeTitular = entrada.next();
				System.out.println("Informe o CPF: ");
				cpf = entrada.next();
				System.out.println("Informe a agência: ");
				agencia = entrada.next();
				System.out.println("Informe o saldo atual: ");
				saldo = entrada.nextDouble();
				System.out.println("Informe a data de aniversario: ");
				String dataAniversario  = entrada.next();
				ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta,nomeTitular,cpf,agencia,saldo,dataAniversario);
				contaPoupanca.setDataAniversario(dataAniversario);
				banco.adicionarConta(contaPoupanca);
				break;
			case 3:
				banco.acessarConta();
				break;
			case 4:
				banco.visualizarConta();
				break;
			case 5:
				System.out.println("Informe o numero da conta: ");
				numeroConta = entrada.nextInt();
				banco.excluirConta(numeroConta);
				break;
			case 6:
				System.out.println("Informe o numero da conta: ");
				numeroConta = entrada.nextInt();
				banco.editarConta(numeroConta);
				break;
			case 7:
				System.out.println("Saindo do menu:");
				break;
			default:
				throw new IllegalArgumentException("Opção Invalida ");
			}
		}while(op != 7);
	}

}
