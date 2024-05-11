package ar.edu.unlp.info.oo2.ejercicio22;

public class Elemento extends AbstractElemento {
	private String nombre;
	private double precio;

	public Elemento(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public double getPrecio() {
		return this.precio;
	}
}
