package desafio1modulo2.classes;

import desafio1modulo2.exception.ValorInvalidoException;

public class ContaPoupanca extends Conta{

	private String dataAniversario;
	public static final double JUROSAPLICADOS = 0.02;
	
	public ContaPoupanca(int numero, String nomeTitular, String cpf, String agencia,double saldo,String dataAniversario) {
		super(numero, nomeTitular, cpf, agencia,saldo);
		this.dataAniversario = dataAniversario;
		// TODO Auto-generated constructor stub
	}
	
	public String getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public void sacar(double valor) {
		if(getSaldo() >= valor) {
			double juros = valor * JUROSAPLICADOS;
			setSaldo(getSaldo() - valor - (valor - juros));
			System.out.println("O saque é : " + getSaldo() + " mais os juros aplicados de: " + juros);
		}else {
			throw new ValorInvalidoException("Saldo Insuficiênte.");
		}
	}
	
	public double deposito(double valor) {
		super.deposito(valor);
		return valor;
	}
	
	public void transferir(Conta conta,double valor) {
		super.transferir(conta,valor);
	}
	
	public void visualizarConta() {
		super.visualizarConta();
		System.out.println("Data de Aniversário: "+ getDataAniversario());
	}

}
