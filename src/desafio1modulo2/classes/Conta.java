package desafio1modulo2.classes;

import desafio1modulo2.exception.ValorInvalidoException;
import desafio1modulo2.interfaces.ContaInterface;

public abstract class Conta implements ContaInterface{
	private int numero;
	private String nomeTitular;
	private String cpf;
	private String agencia;
	private double saldo;
	
	public Conta(int numero,String nomeTitular,String cpf,String agencia,double saldo) {
		this.numero = numero;
		this.nomeTitular = nomeTitular;
		this.cpf = cpf;
		this.agencia = agencia;
		this.saldo = saldo;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public abstract void sacar(double valor);
	
	public double deposito(double valor) {
		if(getSaldo() >= valor && valor >= 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("O deposito é: " + getSaldo());
		}else {
			throw new ValorInvalidoException("O valor deve ser maior que zero.");
		}
		return valor;
	}
	
	public void transferir(Conta conta,double valor) {
		if(saldo >= valor && valor >= 0) {
			sacar(valor);
			conta.deposito(valor);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso.");
		}else {
			System.out.println("Transferencia não autorizada:");
		}
	}
	

	public void visualizarConta() {
		System.out.println("Numero Da Conta: " + getNumero());
		System.out.println("Nome Titular: " + getNomeTitular());
		System.out.println("CPF: " + getCpf());
		System.out.println("Agencia: " + getAgencia());
		System.out.println("Saldo: " + getSaldo());
	}
}
