package br.cesed.arquitetura.order.exception;

public class OrderInvalidoException extends Exception {

	private static final long serialVersionUID = 2960164348995736776L;

	public OrderInvalidoException() {
		super("Pedido invalido");
	}

}
