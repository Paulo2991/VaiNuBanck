package desafio1modulo2.classes;

import desafio1modulo2.exception.ValorInvalidoException;

public class ContaCorrente extends Conta{

	private double limiteCredito;
	public ContaCorrente(int numero, String nomeTitular, String cpf, String agencia,double saldo,double limiteCredito) {
		super(numero, nomeTitular, cpf, agencia,saldo);
		this.limiteCredito = limiteCredito;
		// TODO Auto-generated constructor stub
	}
	
	public double getLimiteCredito() {
		return limiteCredito;
	}
	
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	@Override
	public void sacar(double valor) {
		double limiteTotal = getSaldo() + limiteCredito;
		if(limiteTotal >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("O saque é : " + getSaldo());
		}else {
			throw new ValorInvalidoException("O saldo Insuficiênte.");
		}
	}
	
	public double deposito(double valor) {
		super.deposito(valor);
		return valor;
	}
	
	@Override
	public double transferir(Conta conta,double valor) {
		super.transferir(conta,valor);
		return valor;
	}
	
	public void visualizarConta() {
		super.visualizarConta();
		System.out.println("Limite Credito: " + getLimiteCredito());
	}
}
