package ar.edu.unlp.info.oo2.ejercicio23;

public class Avion {
	private String nombre;
	private int cantAsientos;
	private double capacidadCarga;

	public Avion(String nombre, int cantAsientos, double capacidadCarga) {
		this.nombre = nombre;
		this.cantAsientos = cantAsientos;
		this.capacidadCarga = capacidadCarga;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantAsientos() {
		return cantAsientos;
	}

	public double getCapacidadCarga() {
		return capacidadCarga;
	}
}
