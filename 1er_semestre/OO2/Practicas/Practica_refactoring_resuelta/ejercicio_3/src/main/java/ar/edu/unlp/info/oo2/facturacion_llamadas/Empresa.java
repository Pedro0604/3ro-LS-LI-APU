package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private GestorNumerosDisponibles gestorNumerosDisponibles = new GestorNumerosDisponibles();

	public boolean agregarNumeroTelefono(String numeroDeTelefono) {
		return this.gestorNumerosDisponibles.agregarNumeroTelefono(numeroDeTelefono);
	}

	public String obtenerNumeroLibre() {
		return gestorNumerosDisponibles.obtenerNumeroLibre();
	}

	public Cliente registrarPersonaFisica(String dni, String nombre) {
		String numeroTelefonoLibre = this.obtenerNumeroLibre();
		Cliente nuevoCliente = new PersonaFisica(nombre, numeroTelefonoLibre, dni);
		clientes.add(nuevoCliente);
		return nuevoCliente;
	}

	public Cliente registrarPersonaJuridica(String cuit, String nombre) {
		String numeroTelefonoLibre = this.obtenerNumeroLibre();
		Cliente nuevoCliente = new PersonaJuridica(nombre, numeroTelefonoLibre, cuit);
		clientes.add(nuevoCliente);
		return nuevoCliente;
	}

	public int cantidadDeUsuarios() {
		return clientes.size();
	}

	public boolean existeUsuario(Cliente persona) {
		return clientes.contains(persona);
	}

	public GestorNumerosDisponibles getGestorNumeros() {
		return this.gestorNumerosDisponibles;
	}
}
