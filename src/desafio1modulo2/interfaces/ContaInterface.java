package desafio1modulo2.interfaces;

import desafio1modulo2.classes.Conta;

public interface ContaInterface {
	
	void sacar(double valor);
	double deposito(double valor);
	double transferir(Conta conta,double valor);
}
