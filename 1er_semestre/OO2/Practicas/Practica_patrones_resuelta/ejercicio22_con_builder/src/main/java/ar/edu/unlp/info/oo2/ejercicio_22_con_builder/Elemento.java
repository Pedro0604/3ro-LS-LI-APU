package ar.edu.unlp.info.oo2.ejercicio_22_con_builder;

public class Elemento {
	private String nombre;
	private double precio;

	public Elemento(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getPrecio() {
		return this.precio;
	}
}
