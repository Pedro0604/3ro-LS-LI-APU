package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private String nombre;
	private String numeroTelefono;

	public Cliente(String nombre, String numeroTelefono) {
		this.nombre = nombre;
		this.numeroTelefono = numeroTelefono;
		this.llamadas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public abstract double getMontoDescuento(double monto);

	private double getMontoLlamadaConDescuento(Llamada llamada) {
		double montoLlamada = llamada.getMonto();
		return montoLlamada - this.getMontoDescuento(montoLlamada);
	}

	public double calcularMontoTotalLlamadas() {
		return this.llamadas.stream().mapToDouble(llamada -> this.getMontoLlamadaConDescuento(llamada)).sum();
	}

	public Llamada registrarLlamadaNacional(Cliente clienteDestino, int duracion) {
		Llamada llamada = new LlamadaNacional(this.getNumeroTelefono(), clienteDestino.getNumeroTelefono(), duracion);
		this.llamadas.add(llamada);
		return llamada;
	}

	public Llamada registrarLlamadaInternacional(Cliente clienteDestino, int duracion) {
		Llamada llamada = new LlamadaInternacional(this.getNumeroTelefono(), clienteDestino.getNumeroTelefono(),
				duracion);
		this.llamadas.add(llamada);
		return llamada;
	}
}
