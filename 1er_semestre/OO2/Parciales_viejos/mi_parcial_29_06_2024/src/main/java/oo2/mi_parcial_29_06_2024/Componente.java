package oo2.mi_parcial_29_06_2024;

// Solo lo implemento para que corra
public class Componente {
	private double consumo, precio;
	private String nombre;

	public Componente(double consumo, double precio, String nombre) {
		this.consumo = consumo;
		this.precio = precio;
		this.nombre = nombre;
	}

	public double getConsumo() {
		return consumo;
	}

	public double getPrecio() {
		return precio;
	}

	public String getNombre() {
		return nombre;
	}
}
