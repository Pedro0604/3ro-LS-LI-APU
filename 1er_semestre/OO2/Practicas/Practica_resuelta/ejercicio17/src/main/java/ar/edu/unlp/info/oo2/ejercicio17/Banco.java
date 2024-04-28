package ar.edu.unlp.info.oo2.ejercicio17;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private List<Cliente> clientes;

	public Banco() {
		this.clientes = new ArrayList<>();
	}

	public void addCliente(Cliente c) {
		this.clientes.add(c);
	}
}
