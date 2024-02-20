package desafio1modulo2.exception;

public class ValorInvalidoException extends RuntimeException{

	private static final long serialVersionUID = -2247306729133340051L;

	public ValorInvalidoException(String mensagem) {
        super(mensagem);
    }

}
