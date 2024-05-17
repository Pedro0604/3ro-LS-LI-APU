package ar.edu.unlp.info.oo2.ejercicio23;

public class Pasajero {
	private String nombre;
	private int dni;

	public Pasajero(String nombre, int dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDni() {
		return dni;
	}
}
